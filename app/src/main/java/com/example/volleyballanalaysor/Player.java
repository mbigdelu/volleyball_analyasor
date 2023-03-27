package com.example.volleyballanalaysor;

public class Player {
    private String name;
    private int number;
    private int points;

    public Player (String name) {
        this.name = name;
        points = 0;
    }

    public void increasePoints (){
        points++;
    }

    public int getPoints(){
        return points;
    }

    public String getName(){
        return name;
    }
}
