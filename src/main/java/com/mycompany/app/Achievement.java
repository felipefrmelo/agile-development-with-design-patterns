package com.mycompany.app;

public class Achievement {

    private String name;

    public Achievement(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void add(Achievement a) {
        throw new UnsupportedOperationException("Add method not implemented");
    }

    @Override
    public String toString() {
        return "Achievement [name=" + name + "]";
    }

}
