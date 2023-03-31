package com.example.volleyballanalaysor;

import java.io.Serializable;
import java.sql.Array;


// SavedGame is the class that stores the data of the each game inside and it will return this data based on category
public class SavedGame implements Serializable {

    private int []  acts;
    private int[][]setsScores;
    private String teamOneName, teamTwoName;
    private Player MVB;
    private Player[] teamOnePlayers, teamTwoPlayers;

    protected int numberOfSets, winner;

    public SavedGame(int[][] setsScores, int [] acts, String teamOneName, String teamTwoName, Player[] teamOnePlayers, Player[] teamTwoPlayers, int numberOfSets, int winner){
        this.setsScores = setsScores;
        this.teamOneName = teamOneName;
        this.teamTwoName = teamTwoName;
        this.acts = acts;
        this.teamOnePlayers = teamOnePlayers;
        this.teamTwoPlayers = teamTwoPlayers;
        this.numberOfSets = numberOfSets;
        this.winner = winner;

        MVB = teamOnePlayers[0];

        for (int i = 1; i < teamOnePlayers.length; i++) {
            if (teamOnePlayers[i].getPoints() > MVB.getPoints()) {
                MVB = teamOnePlayers[i];
            }
        }

        for (int i = 1; i < teamTwoPlayers.length; i++) {
            if (teamTwoPlayers[i].getPoints() > MVB.getPoints()) {
                MVB = teamTwoPlayers[i];
            }
        }



    }

    public int[][] getScores(){
        return setsScores;
    }

    public String[] getTeams(){
        String[] teamNames = {teamOneName, teamTwoName};
        return teamNames;
    }

    public int[] getActs() {
        return acts;
    }

    public Player getMVB(){return MVB;}


}
