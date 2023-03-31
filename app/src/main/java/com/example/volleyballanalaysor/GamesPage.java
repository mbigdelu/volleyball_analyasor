package com.example.volleyballanalaysor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class GamesPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games_page);

        SavedGameManager savedGameManager = new SavedGameManager(getApplicationContext());
        List<SavedGame> savedGamesGson = savedGameManager.getSavedGames();

        SavedGame[] savedGames = savedGamesGson.toArray(new SavedGame[savedGamesGson.size()]);



        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        SavedGamesAdapter adapter = new SavedGamesAdapter(savedGames);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));




    }
}