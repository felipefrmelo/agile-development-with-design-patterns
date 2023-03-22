
package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ForumServiceTest {

    @Test
    public void testShouldAddNewTopic() {
        ForumServiceMock forumServiceMock = new ForumServiceMock();
        ForumService forumService = new ForumServiceGamificationProxy();
        String topic = "java";
        String user = "John";
        forumService.addTopic(user, topic);

        assertEquals(1, forumServiceMock.getNumberOfTopics());
    }
}
