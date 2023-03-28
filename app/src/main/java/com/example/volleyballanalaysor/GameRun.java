package com.example.volleyballanalaysor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.TestLooperManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameRun extends AppCompatActivity {

    private String teamOne, teamTwo;

    protected int numberOfSets, numberOfPoints;

    private Player[] teamOnePlayers, teamTwoPlayers;

    private int[] score = new int[2];
    private int[] sets = new int[2];
    private int[][]  setsScore = new int[10][2];
    private int set, totalNumberOfSets;

    private Button teamOneBtn, teamTwoBtn;
    private TextView scoreTeamOne, scoreTeamTwo, teamOneSet, teamTwoSet;



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

        score[0] = 0;
        score[1] = 0;
        sets[0] = 0;
        sets[1] = 0;
        set = 1;
        totalNumberOfSets = (numberOfSets * 2 ) - 1;


        teamOneBtn = (Button)  findViewById(R.id.TeamOneBtn);
        teamTwoBtn = (Button) findViewById(R.id.TeamTwoBtn);

        scoreTeamOne = (TextView) findViewById(R.id.TeamOneScore);
        scoreTeamTwo = (TextView) findViewById(R.id.TeamTwoScore);
        teamOneSet = (TextView)  findViewById(R.id.TeamOneSet);
        teamTwoSet = (TextView) findViewById(R.id.TeamTwoSets);

        teamOneBtn.setText(teamOne);
        teamTwoBtn.setText(teamTwo);

        scoreTeamOne.setText("0");
        scoreTeamTwo.setText("0");
        teamOneSet.setText("0");
        teamTwoSet.setText("0");

        teamOneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPoint(0);

                if(isLastPoint()){

                    updateSets();

                }
                else {

                    updateBoard();
                }
            }
        });


        teamTwoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPoint(1);

                if(isLastPoint()){

                    updateSets();

                }
                else {

                    updateBoard();
                }

            }
        });



    }



    private boolean isLastPoint(){

        boolean isLastPoint = false;

        if(score[0] >= numberOfPoints || score[1] >= numberOfPoints){

            if(Math.abs(score[0] - score[1] ) >= 2){

                isLastPoint = true;
            }
        }

        else {
            isLastPoint = false;
        }


        return isLastPoint;
    }

    private boolean isLastSet() {

        boolean isLastSet = false;

        if (sets[0] == numberOfSets || sets[1] == numberOfSets){
            isLastSet = true;
        }
        return isLastSet;
    }

    private void addPoint(int team){

        score[team]++;
    }

    private void updateBoard(){
        scoreTeamOne.setText(Integer.toString(score[0]));
        teamOneSet.setText(Integer.toString(sets[0]));
        scoreTeamTwo.setText(Integer.toString(score[1]));
        teamTwoSet.setText(Integer.toString(sets[1]));
    }

    private void updateSets(){
        if(score[0] > score[1]){
            sets[0]++;
        }

        else if (score[1] > score[0]) {

            sets[1]++;
        }


        score[0] = 0;
        score[1] = 0;

        updateBoard();

    }


}