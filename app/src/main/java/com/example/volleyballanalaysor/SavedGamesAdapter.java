package com.example.volleyballanalaysor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SavedGamesAdapter extends RecyclerView.Adapter<SavedGameViewHolder> {
    private SavedGame[] savedGames;

    public SavedGamesAdapter(SavedGame[] savedGames) {
        this.savedGames = savedGames;
    }

    @NonNull
    @Override
    public SavedGameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.games_row, parent, false);
        return new SavedGameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SavedGameViewHolder holder, int position) {
        SavedGame savedGame = savedGames[position];

        String[] teams = savedGame.getTeams();

        String teamOne = teams[0];
        String teamTwo = teams[1];


        holder.team1NameTextView.setText(teamOne);
        holder.team2NameTextView.setText(teamTwo);
    }

    @Override
    public int getItemCount() {
        return savedGames.length;
    }
}
