package com.example.utkiteam.Person;

public class Person {
    int lvl;
    String name;
    int points;

    public Person(int lvl, String name, int points) {
        this.lvl = lvl;
        this.name = name;
        this.points = points;
    }

    public int getLvl() {
        return lvl;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
