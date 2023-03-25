package com.mycompany.app;

public class CreationAchievementObserver implements AchievementObserver {

    private AchievementStorage storage;

    public CreationAchievementObserver(AchievementStorage storage) {
        this.storage = storage;
    }

    @Override
    public void achievementUpdate(String user, Achievement achievement) {
        if (!(achievement instanceof Point)) {
            return;
        }
        Point point = (Point) achievement;
        if (point.getName().equals("CREATION") && point.getPoints() >= 100) {
            storage.addAchievement(user, new Badge("INVENTOR"));
        }

    }

}
