package com.example.volleyballanalaysor;

import java.io.Serializable;

public class Player implements Serializable {
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
