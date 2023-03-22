package com.mycompany.app;

public class Achievement {

    private String name;

    public Achievement(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void add(Achievement achievement) {
        achievement.add(this);
    }
}
