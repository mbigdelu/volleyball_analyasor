package com.example.volleyballanalaysor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class GamesPage extends AppCompatActivity {


    private Button newBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games_page);

        SavedGameManager savedGameManager = new SavedGameManager(getApplicationContext());
        List<SavedGame> savedGamesGson = savedGameManager.getSavedGames();

        SavedGame[] savedGames = savedGamesGson.toArray(new SavedGame[savedGamesGson.size()]);

        Intent newGame = new Intent(this, NewGameInfo.class);





        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        SavedGamesAdapter adapter = new SavedGamesAdapter(savedGames, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        newBtn = (Button) findViewById(R.id.newGameBtn);

        newBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(newGame);
            }
        });




    }
}