
package com.mycompany.app;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ForumServiceTest {

    ForumServiceMock forumServiceMock;
    ForumService forumService;
    AchievementStorage storage;

    @BeforeEach
    public void setUp() {
        forumServiceMock = new ForumServiceMock();
        storage = new MemoryAchievementStorage();
        forumService = new ForumServiceGamificationProxy(forumServiceMock, storage);
    }

    @Test
    public void testShouldAddNewTopic() {

        forumService.addTopic("John", "java");

        assertIfMethodsIsCalled("addTopic");
    }

    @Test
    public void testShouldAddNewTopicAndAddAchievement() {
        forumService.addTopic("John", "java");

        assertEquals(2, storage.getAchievements("John").size());

        Point point = (Point) storage.getAchievement("John", "CREATION");

        assertEquals("CREATION", point.getName());
        assertEquals(5, point.getPoints());

        Badge badge = (Badge) storage.getAchievement("John", "I CAN TALK");

        assertEquals("I CAN TALK", badge.getName());

        assertIfMethodsIsCalled("addTopic");
    }

    @Test
    public void testShouldAddNewTopicAndAddAchievementOnlyOnce() {

        forumService.addTopic("John", "java");
        forumService.addTopic("John", "python");

        assertEquals(2, storage.getAchievements("John").size());

        Point point = (Point) storage.getAchievement("John", "CREATION");

        assertEquals("CREATION", point.getName());
        assertEquals(10, point.getPoints());

        assertIfMethodsIsCalled("addTopic", "addTopic");

    }

    @Test
    public void testShouldAddNewTopicAndAddAchievementOnlyOnceForDifferentUsers() {

        forumService.addTopic("John", "java");
        forumService.addTopic("John", "python");
        forumService.addTopic("Mary", "java");

        assertEquals(2, storage.getAchievements("John").size());
        assertEquals(2, storage.getAchievements("Mary").size());

        Point point = (Point) storage.getAchievement("John", "CREATION");

        assertEquals("CREATION", point.getName());
        assertEquals(10, point.getPoints());

        point = (Point) storage.getAchievement("Mary", "CREATION");

        assertEquals("CREATION", point.getName());
        assertEquals(5, point.getPoints());

    }

    @Test
    public void testShouldAddNewCommentAndAddAchievement() {

        forumService.addComment("John", "java", "I like it");

        assertEquals(2, storage.getAchievements("John").size());

        Point point = (Point) storage.getAchievement("John", "PARTICIPATION");
        assertEquals(3, point.getPoints());

        assertNotNull(storage.getAchievement("John", "LET ME ADD"));

        assertIfMethodsIsCalled("addComment");
    }

    @Test
    public void testShouldLikeTopic() {

        forumService.likeTopic("John", "java", "Mary");

        assertEquals(1, storage.getAchievements("Mary").size());

        Point point = (Point) storage.getAchievement("Mary", "CREATION");
        assertEquals(1, point.getPoints());

        assertIfMethodsIsCalled("likeTopic");

    }

    @Test
    public void testShouldLikeComment() {

        forumService.likeComment("John", "java", "I like it", "Mary");

        assertEquals(1, storage.getAchievements("Mary").size());

        Point point = (Point) storage.getAchievement("Mary", "PARTICIPATION");
        assertEquals(1, point.getPoints());

        assertIfMethodsIsCalled("likeComment");

    }

    @Test
    public void testShouldAddNewTopicAndAddAchievementOnlyOnceForDifferentUsersAndMultipleTopics() {

        String user_1 = "John";
        String user_2 = "Mary";
        forumService.addTopic(user_1, "java");
        forumService.addTopic(user_1, "python");
        forumService.addTopic(user_2, "java");
        forumService.addComment(user_2, "java", "I like it");

        forumService.likeTopic(user_1, "java", user_2);
        forumService.likeComment(user_1, "java", "I like it", user_2);
        forumService.likeTopic(user_2, "java", user_1);
        forumService.likeTopic(user_2, "python", user_1);

        assertEquals(2, storage.getAchievements(user_1).size());
        assertEquals(4, storage.getAchievements(user_2).size());

        assertUserPoints(user_1, 12);
        assertUserPoints(user_2, 10);

    }

    @Test
    public void testShouldNotAddAchievementsWhenExceptionIsThrown() {
        forumServiceMock.setShouldThrowException(true);
        forumService.addTopic("John", "java");
        forumService.addComment("John", "java", "I like it");

        assertEquals(0, storage.getAchievements("John").size());

        assertIfMethodsIsCalled("addTopic", "addComment");
    }

    @Test
    public void testShouldReceiveInventorBadgeWhenReach100Points() {

        AchievementObserver observer = new CreationAchievementObserver(storage);
        storage.addObserver(observer);

        for (int i = 0; i < 20; i++) {
            forumService.addTopic("John", "java");
        }

        assertEquals(3, storage.getAchievements("John").size());

        Point point = (Point) storage.getAchievement("John", "CREATION");
        assertEquals(100, point.getPoints());

        assertNotNull(storage.getAchievement("John", "INVENTOR"));

    }

    @Test
    public void testShouldReceivePartOfTheCommunityBadgeWhenReach100Points() {

        AchievementObserver observer = new ParticipationAchievementObserver(storage);
        storage.addObserver(observer);

        for (int i = 0; i < 34; i++) {
            forumService.addComment("John", "java", "I like it");
        }

        assertEquals(3, storage.getAchievements("John").size());

        Point point = (Point) storage.getAchievement("John", "PARTICIPATION");
        assertEquals(102, point.getPoints());

        assertNotNull(storage.getAchievement("John", "PART OF THE COMMUNITY"));

    }

    private void assertUserPoints(String user, int expected) {
        int points = storage.getAchievements(user).stream()
                .filter(a -> a instanceof Point)
                .map(a -> (Point) a)
                .mapToInt(Point::getPoints)
                .sum();

        assertEquals(expected, points);

    }

    private void assertIfMethodsIsCalled(String... methods) {
        assertEquals(List.of(methods), forumServiceMock.getMethodsCalled());
    }
}
