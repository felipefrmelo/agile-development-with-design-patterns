package com.mycompany.app;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        AchievementStorage achievementStorage = AchievementStorageFactory.getAchievementStorage();

        AchievementObserver creationAchievementObserver = new CreationAchievementObserver(achievementStorage);
        achievementStorage.addObserver(creationAchievementObserver);

        AchievementObserver participationAchievementObserver = new ParticipationAchievementObserver(achievementStorage);
        achievementStorage.addObserver(participationAchievementObserver);

        AchievementObserver loggingAchievementObserver = new LoggingAchievementObserver(achievementStorage);
        achievementStorage.addObserver(loggingAchievementObserver);

        ForumService forumService = new ForumServiceCLI();
        ForumService forumServiceProxy = new ForumServiceGamificationProxy(forumService, achievementStorage);

        Forum forum = new Forum(forumServiceProxy);

        forum.runCLI();

    }
}
