package com.mycompany.app;

public class AchievementStorageFactory {

    private static AchievementStorage achievementStorage;

    private AchievementStorageFactory() {
    }

    public static void setAchievementStorage(AchievementStorage a) {
        achievementStorage = a;
    }

    public static AchievementStorage getAchievementStorage() {
        if (achievementStorage == null) {
            achievementStorage = new MemoryAchievementStorage();
        }
        return achievementStorage;
    }
}
