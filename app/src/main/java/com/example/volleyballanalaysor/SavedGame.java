package com.example.volleyballanalaysor;

import java.sql.Array;


// SavedGame is the class that stores the data of the each game inside and it will return this data based on category
public class SavedGame {

    private int [] setsScores;
    private String teamOneName, teamTwoName, MVB;
    private int tips, spikes, serves, blocks;

    public SavedGame(int[] setsScores, int tips, int spikes, int serves, int blocks, String teamOneName, String teamTwoName, String MVB){
        this.setsScores = setsScores;
        this.teamOneName = teamOneName;
        this.teamTwoName = teamTwoName;
        this.MVB = MVB;
        this.tips = tips;
        this.spikes= spikes;
        this.serves = serves;
        this.blocks = blocks;

    }

    public int[] getScores(){
        return setsScores;
    }

    public String[] getTeams(){
        String[] teamNames = {teamOneName, teamTwoName};
        return teamNames;
    }

    public int[] getActs() {
        int[] acts = {tips, spikes, serves, blocks};
        return acts;
    }


}
