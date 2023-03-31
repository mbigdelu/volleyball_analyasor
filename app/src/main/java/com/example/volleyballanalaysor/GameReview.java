package com.example.volleyballanalaysor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class GameReview extends AppCompatActivity {

    private SavedGame game;
    private int numberOfSets;

    private int[][]  setsScore;

    private int[] acts;

    private ConstraintLayout ScoresBox;

    private TextView winnerTeamText, t1s1, t1s2, t1s3, t1s4, t1s5, t2s1, t2s2, t2s3, t2s4, t2s5, noOfTipsText, noOfSpikesText, noOfBlocksText, noOfServesText, MVBText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_review);

        SavedGameManager savedGameManager = new SavedGameManager(this.getApplicationContext());

        Intent thisIntent = getIntent();
        game = (SavedGame) thisIntent.getSerializableExtra("game");


        acts = game.getActs();

        ScoresBox = (ConstraintLayout) findViewById(R.id.ScoresBox);


        winnerTeamText = (TextView) findViewById(R.id.winnerTeamText);

        t1s1 = (TextView) findViewById(R.id.TeamOne_SetOne);
        t1s2 = (TextView) findViewById(R.id.TeamOne_SetTwo);
        t1s3 = (TextView) findViewById(R.id.TeamOne_SetThree);
        t1s4 = (TextView) findViewById(R.id.TeamOne_SetFour);
        t1s5 = (TextView) findViewById(R.id.TeamOne_SetFive);
        t2s1 = (TextView) findViewById(R.id.TeamTwo_SetOne);
        t2s2 = (TextView) findViewById(R.id.TeamTwo_SetTwo);
        t2s3 = (TextView) findViewById(R.id.TeamTwo_SetThree);
        t2s4 = (TextView) findViewById(R.id.TeamTwo_SetFour);
        t2s5 = (TextView) findViewById(R.id.TeamTwo_SetFive);


        noOfTipsText = (TextView) findViewById(R.id.NoOfTipsText);
        noOfSpikesText = (TextView) findViewById(R.id.NoOfSpikesText);
        noOfBlocksText = (TextView) findViewById(R.id.NoOfBlocksText);
        noOfServesText = (TextView) findViewById(R.id.NoOfServesText);
        MVBText = (TextView) findViewById(R.id.MVBText);

        noOfTipsText.setText(Integer.toString(acts[0]));
        noOfSpikesText.setText(Integer.toString(acts[1]));
        noOfBlocksText.setText(Integer.toString(acts[2]));
        noOfServesText.setText((Integer.toString(acts[3])));


        if(game.getMVB().getPoints() != 0)MVBText.setText(game.getMVB().getName());






        numberOfSets = game.numberOfSets;
        setsScore = game.getScores();

        winnerTeamText.setText("The Winner is " + game.getTeams()[game.winner]);

        t1s1.setText(scoreToString(setsScore[0][0]));
        t2s1.setText(scoreToString(setsScore[0][1]));
        t1s2.setText(scoreToString(setsScore[1][0]));
        t2s2.setText(scoreToString(setsScore[1][1]));
        t1s3.setText(scoreToString(setsScore[2][0]));
        t2s3.setText(scoreToString(setsScore[2][1]));
        t1s4.setText(scoreToString(setsScore[3][0]));
        t2s4.setText(scoreToString(setsScore[3][1]));
        t1s5.setText(scoreToString(setsScore[4][0]));
        t2s5.setText(scoreToString(setsScore[3][1]));




    }

    private String scoreToString(int score){

        if(score != 0){
            return Integer.toString(score);
        }
        else return "";
    }

}