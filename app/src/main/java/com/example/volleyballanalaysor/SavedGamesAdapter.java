package com.example.volleyballanalaysor;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SavedGamesAdapter extends RecyclerView.Adapter<SavedGameViewHolder> {
    private SavedGame[] savedGames;

    private Context context;

    public SavedGamesAdapter(SavedGame[] savedGames, Context context) {
        this.savedGames = savedGames;
        this.context = context;
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

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gameDone = new Intent(context, GameReview.class);
                gameDone.putExtra("game", savedGame);

                context.startActivity(gameDone);

            }
        });
    }

    @Override
    public int getItemCount() {
        return savedGames.length;
    }
}
