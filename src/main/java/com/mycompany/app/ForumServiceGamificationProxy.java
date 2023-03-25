package com.mycompany.app;

public class ForumServiceGamificationProxy implements ForumService {

    private final ForumService forumService;
    private final AchievementStorage achievementStorage;

    public ForumServiceGamificationProxy(ForumService forumService, AchievementStorage achievementStorage) {
        this.forumService = forumService;
        this.achievementStorage = achievementStorage;
    }

    @Override
    public void addTopic(String user, String topic) {
        try {
            forumService.addTopic(user, topic);
            achievementStorage.addAchievement(user, new Point("CREATION", 5));
            achievementStorage.addAchievement(user, new Badge("I CAN TALK"));
        } catch (Exception e) {
            // log or handle the error
        }
    }

    @Override
    public void addComment(String user, String topic, String comment) {
        try {
            forumService.addComment(user, topic, comment);
            achievementStorage.addAchievement(user, new Point("PARTICIPATION", 3));
            achievementStorage.addAchievement(user, new Badge("LET ME ADD"));
        } catch (Exception e) {
            // log or handle the error
        }
    }

    @Override
    public void likeTopic(String user, String topic, String topicUser) {
        try {
            forumService.likeTopic(user, topic, topicUser);
            achievementStorage.addAchievement(topicUser, new Point("CREATION", 1));
        } catch (Exception e) {
            // log or handle the error
        }
    }

    @Override
    public void likeComment(String user, String topic, String comment, String commentUser) {
        try {
            forumService.likeComment(user, topic, comment, commentUser);
            achievementStorage.addAchievement(commentUser, new Point("PARTICIPATION", 1));
        } catch (Exception e) {
            // log or handle the error
        }
    }
}
