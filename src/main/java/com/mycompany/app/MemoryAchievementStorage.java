package com.mycompany.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryAchievementStorage implements AchievementStorage {

    private Map<String, List<Achievement>> achievements = new HashMap<>();
    private List<AchievementObserver> observers = new ArrayList<>();

    @Override
    public List<Achievement> getAchievements(String user) {
        return achievements.getOrDefault(user, new ArrayList<>());
    }

    @Override
    public Achievement getAchievement(String user, String achievementName) {

        List<Achievement> userAchievements = achievements.getOrDefault(user, new ArrayList<>());

        return userAchievements.stream()
                .filter(achievement -> achievement.getName().equals(achievementName))
                .findFirst()
                .orElse(null);

    }

    @Override
    public void addAchievement(String user, Achievement achievement) {
        Achievement existingAchievement = getAchievement(user, achievement.getName());

        if (existingAchievement != null) {
            existingAchievement.add(achievement);
            notifyObservers(user, existingAchievement);
        } else {
            achievements.computeIfAbsent(user, k -> new ArrayList<>()).add(achievement);
            notifyObservers(user, achievement);
        }

    }

    @Override
    public void addObserver(AchievementObserver observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers(String user, Achievement achievement) {
        observers.forEach(observer -> observer.achievementUpdate(user, achievement));
    }

}
