package com.mycompany.app;

public class LoggingAchievementObserver implements AchievementObserver {

    public LoggingAchievementObserver(AchievementStorage achievementStorage) {
    }

    @Override
    public void achievementUpdate(String user, Achievement achievement) {
        System.out.println(String.format("User %s earned achievement %s", user, achievement));

    }

}
