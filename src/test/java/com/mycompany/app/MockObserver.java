package com.mycompany.app;

public class MockObserver implements AchievementObserver {

    private int count = 0;

    public MockObserver(AchievementStorage storage) {
    }

    @Override
    public void achievementUpdate(String user, Achievement achievement) {
        count++;
    }

    public int getCount() {
        return count;
    }

}
