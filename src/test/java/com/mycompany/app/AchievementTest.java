package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class AchievementTest {


    @Test
    public void testShouldThrowExceptionWhenAdd() {
        Achievement achievement = new Achievement("name");
        Achievement achievement2 = new Achievement("name2");

        try {
            achievement.add(achievement2);
            fail("Should throw exception");
        } catch (Exception e) {
            assertEquals("Add method not implemented", e.getMessage());
        }

    }

    @Test
    public void testShouldAddPointAchievement() {
        Point point = new Point("name", 10);
        Point point2 = new Point("name", 20);

        point.add(point2);

        assertEquals(30, point.getPoints());
    }


    @Test
    public void testShouldAddBadgeAchievementAndDoNothing() {
        Badge badge = new Badge("name");
        Badge badge2 = new Badge("name");

        badge.add(badge2);

        assertEquals("name", badge.getName());
    }

}
