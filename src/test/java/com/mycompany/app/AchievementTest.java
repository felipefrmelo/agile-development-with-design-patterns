package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AchievementTest {

    @Test
    public void testShouldAddNewTopic() {
        Achievement point1 = new Point("java", 5);
        Point point2 = new Point("java", 5);

        point2.add(point1);

        assertEquals(10, point2.getPoints());



    }
}

