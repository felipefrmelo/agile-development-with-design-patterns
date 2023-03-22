package com.mycompany.app;

public class Achievement {

    private String name;
    public Achievement(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    } 
    

    public String getName() {
        return name;
    }


    public void add(Achievement a) {
        throw new UnsupportedOperationException("Add method not implemented");
    }
    

}
