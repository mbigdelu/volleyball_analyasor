package com.example.volleyballanalaysor;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class SavedGameViewHolder extends RecyclerView.ViewHolder {
    public TextView team1NameTextView;
    public TextView team2NameTextView;

    public SavedGameViewHolder(View itemView) {
        super(itemView);
        team1NameTextView = itemView.findViewById(R.id.team1_name);
        team2NameTextView = itemView.findViewById(R.id.team2_name);
    }
}
