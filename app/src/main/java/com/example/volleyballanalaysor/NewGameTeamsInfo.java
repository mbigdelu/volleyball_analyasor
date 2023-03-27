package com.example.volleyballanalaysor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NewGameTeamsInfo extends AppCompatActivity {

    private String teamOne, teamTwo;

    protected int numberOfSets, numberOfPoints;

    private Player[] teamOnePlayers = new Player[6];
    private Player[] teamTwoPlayers = new Player[6];

    private EditText  FirstTeamIn, SecondTeamIn, FirstTeam_Player1, FirstTeam_Player2, FirstTeam_Player3, FirstTeam_Player4, FirstTeam_Player5, FirstTeam_Player6, SecondTeam_Player1, SecondTeam_Player2, SecondTeam_Player3, SecondTeam_Player4, SecondTeam_Player5, SecondTeam_Player6;

    private Button  gameStartBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game_teams_info);

        Intent thisIntent = getIntent();
        Intent intent = new Intent(this, GameRun.class);

        gameStartBtn = (Button) findViewById(R.id.GameStartBtn) ;

        FirstTeamIn = (EditText) findViewById(R.id.FirstTeamName);
        SecondTeamIn = (EditText) findViewById(R.id.SecondTeamName);

        numberOfSets = thisIntent.getIntExtra("numberOfSets", 1);
        numberOfPoints = thisIntent.getIntExtra("numberOfPoints", 25);



        gameStartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                createPlayers();
                teamOne = FirstTeamIn.getText().toString();
                teamTwo = SecondTeamIn.getText().toString();



                intent.putExtra("numberOfSets", numberOfSets);
                intent.putExtra("numberOfPoints", numberOfPoints);
                intent.putExtra("teamOnePlayers", teamOnePlayers);
                intent.putExtra("teamTwoPlayers", teamTwoPlayers);

            }
        });
    }

    public void createPlayers(){




        FirstTeam_Player1 = (EditText) findViewById(R.id.FirstTeam_Player1);
        FirstTeam_Player2 = (EditText) findViewById(R.id.FirstTeam_Player2);
        FirstTeam_Player3 = (EditText) findViewById(R.id.FirstTeam_Player3);
        FirstTeam_Player4 = (EditText) findViewById(R.id.FirstTeam_Player4);
        FirstTeam_Player5 = (EditText) findViewById(R.id.FirstTeam_Player5);
        FirstTeam_Player6 = (EditText) findViewById(R.id.FirstTeam_Player6);

        SecondTeam_Player1 = (EditText) findViewById(R.id.SecondTeam_Player1);
        SecondTeam_Player2 = (EditText) findViewById(R.id.SecondTeam_Player2);
        SecondTeam_Player3 = (EditText) findViewById(R.id.SecondTeam_Player3);
        SecondTeam_Player4 = (EditText) findViewById(R.id.SecondTeam_Player4);
        SecondTeam_Player5 = (EditText) findViewById(R.id.SecondTeam_Player5);
        SecondTeam_Player6 = (EditText) findViewById(R.id.SecondTeam_Player6);


        teamOnePlayers[0] = new Player(FirstTeam_Player1.getText().toString());
        teamOnePlayers[1] = new Player(FirstTeam_Player2.getText().toString());
        teamOnePlayers[2] = new Player(FirstTeam_Player3.getText().toString());
        teamOnePlayers[3] = new Player(FirstTeam_Player4.getText().toString());
        teamOnePlayers[4] = new Player(FirstTeam_Player5.getText().toString());
        teamOnePlayers[5] = new Player(FirstTeam_Player6.getText().toString());

        teamTwoPlayers[0] = new Player(SecondTeam_Player1.getText().toString());
        teamTwoPlayers[1] = new Player(SecondTeam_Player2.getText().toString());
        teamTwoPlayers[2] = new Player(SecondTeam_Player3.getText().toString());
        teamTwoPlayers[3] = new Player(SecondTeam_Player4.getText().toString());
        teamTwoPlayers[4] = new Player(SecondTeam_Player5.getText().toString());
        teamTwoPlayers[5] = new Player(SecondTeam_Player6.getText().toString());
    }
}