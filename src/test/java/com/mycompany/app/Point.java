package com.mycompany.app;

public class Point extends Achievement {

    private int points;

    public Point(String name, int points) {
        super(name);
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public void add(Achievement achievement) {
        Point point = (Point) achievement;
        this.points += point.getPoints();

    }

}
