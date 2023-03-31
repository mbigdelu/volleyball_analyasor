package com.example.volleyballanalaysor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

public class GameRun extends AppCompatActivity {

    private String teamOne, teamTwo;



    private Player[] teamOnePlayers, teamTwoPlayers;

    private int[] score = new int[2];
    private int[] sets = new int[2];
    private int[] acts = new int[4];
    private int[][]  setsScore = new int[5][2];

    private ConstraintLayout playersBox, actsBox, teamsBox;
    private int setId, selectedTeamId, selectedPlayerId, selectedActId, numberOfSets, numberOfPoints, winner;

    private Button nextPointBtn;

    private ToggleButton teamOneToggle, teamTwoToggle, playerOneToggle, playerTwoToggle, playerThreeToggle, playerFourToggle, playerFiveToggle, playerSixToggle, tipToggle, spikeToggle, blockToggle, serveToggle;
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



        actsBox = (ConstraintLayout) findViewById(R.id.ActsBox);
        playersBox = (ConstraintLayout) findViewById(R.id.PlayersBox);
        teamsBox = (ConstraintLayout)findViewById(R.id.TeamsBox);


        score[0] = 0;
        score[1] = 0;
        sets[0] = 0;
        sets[1] = 0;
        setId = 0;



        nextPointBtn = (Button) findViewById(R.id.NextPointBtn);


        scoreTeamOne = (TextView) findViewById(R.id.TeamOneScore);
        scoreTeamTwo = (TextView) findViewById(R.id.TeamTwoScore);
        teamOneSet = (TextView)  findViewById(R.id.TeamOneSet);
        teamTwoSet = (TextView) findViewById(R.id.TeamTwoSets);



        teamOneToggle = (ToggleButton) findViewById(R.id.TeamOneToggle);
        teamTwoToggle = (ToggleButton) findViewById(R.id.TeamTwoToggle);

        playerOneToggle = (ToggleButton) findViewById(R.id.PlayerOneToggleBtn);
        playerTwoToggle = (ToggleButton) findViewById(R.id.PlayerTwoToggleBtn);
        playerThreeToggle = (ToggleButton) findViewById(R.id.PlayerThreeToggleBtn);
        playerFourToggle = (ToggleButton) findViewById(R.id.PlayerFourToggleBtn);
        playerFiveToggle = (ToggleButton) findViewById(R.id.PlayerFiveToggleBtn);
        playerSixToggle = (ToggleButton) findViewById(R.id.PlayerSixToggleBtn);

        tipToggle = (ToggleButton) findViewById(R.id.TipToggleBtn);
        spikeToggle = (ToggleButton) findViewById(R.id.SpikeToggleBtn);
        blockToggle = (ToggleButton) findViewById(R.id.BlockToggleBtn);
        serveToggle = (ToggleButton) findViewById(R.id.ServeToggleBtn);



        scoreTeamOne.setText("0");
        scoreTeamTwo.setText("0");
        teamOneSet.setText("0");
        teamTwoSet.setText("0");

        teamOneToggle.setTextOff(teamOne);
        teamOneToggle.setTextOn(teamOne);
        teamTwoToggle.setTextOff(teamTwo);
        teamTwoToggle.setTextOn(teamTwo);

         setupToggleButtons(actsBox, 'a');
         setupToggleButtons(playersBox, 'p');
         setupToggleButtons(teamsBox, 't');






        nextPointBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addPoint(selectedTeamId);
                addPointToPlayer(selectedPlayerId);
                addToActs(selectedActId);



                if(isLastPoint()){

                    updateSets();

                }
                else {

                    updateBoard();
                }


                resetPoint();


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

    private boolean isGameDone(){
        if(isLastSet()){
            return true;
        }
        else return false;
    }

    private void addPoint(int team){

       if(team == 0 || team == 1) {
           score[team]++;
       }
    }

    private void addPointToPlayer(int player){
        if(player == 0 || player == 1 || player == 2 || player == 3 || player == 4 || player == 5){

            if (selectedTeamId == 0){

                teamOnePlayers[player].increasePoints();

            }

            else if (selectedTeamId == 1){
                teamTwoPlayers[player].increasePoints();
            }
        }
    }

    private void addToActs(int act){
        if(act == 0 || act == 1 || act == 2 || act == 3 ){
            acts[act]++;
        }
    }

    private void updateBoard(){
        scoreTeamOne.setText(Integer.toString(score[0]));
        teamOneSet.setText(Integer.toString(sets[0]));
        scoreTeamTwo.setText(Integer.toString(score[1]));
        teamTwoSet.setText(Integer.toString(sets[1]));
    }

    private void updateSets(){

        setsScore[setId][0] = score[0];
        setsScore[setId][1] = score[1];


        if(score[0] > score[1]){
            sets[0]++;
        }

        else if (score[1] > score[0]) {

            sets[1]++;
        }

        if(isGameDone()){
            finishGame();
        }

        score[0] = 0;
        score[1] = 0;
        setId++;

        updateBoard();


    }

    private void finishGame(){
        if(sets[0] == numberOfSets){
            winner = 0;
        }
        else if(sets[1] == numberOfSets){
            winner = 1;
        }

        SavedGame game = new SavedGame(setsScore, acts, teamOne, teamTwo, teamOnePlayers, teamTwoPlayers, numberOfSets, winner);


        Intent gameIsDone = new Intent(this, GameDone.class);

        Log.i("scores", Integer.toString(setsScore[0][0]));
        gameIsDone.putExtra("game", game);
        gameIsDone.putExtra("refCode", "NEW_GAME");
        startActivity(gameIsDone);
    }



    private void setupToggleButtons(ConstraintLayout box, char refCode) {


        for (int i = 0; i < box.getChildCount(); i++) {
            View view = box.getChildAt(i);
            if (view instanceof ToggleButton) {
                ToggleButton toggleButton = (ToggleButton) view;
                int finalI = i;
                toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            setId(finalI, refCode);
                            for (int j = 0; j < box.getChildCount(); j++) {
                                View view = box.getChildAt(j);
                                if (view instanceof ToggleButton && view != buttonView) {
                                    ((ToggleButton) view).setChecked(false);
                                }
                            }
                        }
                    }
                });
            }
        }
    }

    private void setId(int i, char refCode){


        switch (refCode){

            case 'a':
                selectedActId = i;
                break;

            case 't':
                selectedTeamId = i;
                setPlayersName();
                break;

            case 'p':
                selectedPlayerId = i;
                break;

            default:
                break;
        }
    }

    private void resetPoint() {
        teamOneToggle.setChecked(false);
        teamTwoToggle.setChecked(false);
        playerOneToggle.setChecked(false);
        playerTwoToggle.setChecked(false);
        playerThreeToggle.setChecked(false);
        playerFourToggle.setChecked(false);
        playerFiveToggle.setChecked(false);
        playerSixToggle.setChecked(false);
        tipToggle.setChecked(false);
        spikeToggle.setChecked(false);
        blockToggle.setChecked(false);
        serveToggle.setChecked(false);


        selectedTeamId = -1;
        selectedPlayerId = -1;
        selectedActId = -1;

    }

    private void setPlayersName (){

        for (int i = 0; i < playersBox.getChildCount(); i++) {
            View view = playersBox.getChildAt(i);
            if (view instanceof ToggleButton) {
                ToggleButton toggleButton = (ToggleButton) view;
                if(selectedTeamId == 0){
                    toggleButton.setTextOn(teamOnePlayers[i].getName());
                }

                else if(selectedTeamId == 1){
                    toggleButton.setTextOn(teamTwoPlayers[i].getName());
                }

            }

        }

    }




}