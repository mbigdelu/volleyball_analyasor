package com.example.volleyballanalaysor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class GameRun extends AppCompatActivity {

    private String teamOne, teamTwo;

    protected int numberOfSets, numberOfPoints;

    private Player[] teamOnePlayers, teamTwoPlayers;

    private int[] score;
    private int set;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_run);

        Intent thisIntent = getIntent();

        numberOfSets = thisIntent.getIntExtra("numberOfSets", 1);
        numberOfPoints = thisIntent.getIntExtra("numberOfPoints", 25);
        teamOne = thisIntent.getStringExtra("teamOne");
        teamTwo = thisIntent.getStringExtra("teamTwo");
        teamOnePlayers = (Player[]) thisIntent.getSerializableExtra("teamOnePlayers");
        teamTwoPlayers = (Player[]) thisIntent.getSerializableExtra("teamTwoPlayers");


    }
}