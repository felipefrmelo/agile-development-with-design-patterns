package com.mycompany.app;

import java.util.List;

public interface AchievementStorage {

    List<Achievement> getAchievements(String user);

    Achievement getAchievement(String user, String achievementName);

    void addAchievement(String user, Achievement achievement);

    void addObserver(AchievementObserver observer);

    void notifyObservers(String user, Achievement achievement);

}
