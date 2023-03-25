package com.mycompany.app;

public class ParticipationAchievementObserver implements AchievementObserver {

    private AchievementStorage storage;

    public ParticipationAchievementObserver(AchievementStorage storage) {
        this.storage = storage;
    }

    @Override
    public void achievementUpdate(String user, Achievement achievement) {
        Point point = (Point) achievement;
        if (point.getName().equals("PARTICIPATION") && point.getPoints() >= 100) {
            storage.addAchievement(user, new Badge("PART OF THE COMMUNITY"));
        }

    }

}
