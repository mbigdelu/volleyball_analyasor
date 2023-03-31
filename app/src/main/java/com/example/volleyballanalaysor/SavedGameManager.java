package com.example.volleyballanalaysor;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SavedGameManager {
    private static final String TAG = "SavedGameManager";
    private static final String FILE_NAME = "saved_games.json";

    private List<SavedGame> savedGames;
    private Gson gson;
    private Context context;

    public SavedGameManager(Context context) {
        this.context = context;
        savedGames = new ArrayList<>();
        gson = new Gson();

        // Load saved games from file
        loadFromFile();
    }

    public void addSavedGame(SavedGame savedGame) {
        savedGames.add(savedGame);
    }

    public List<SavedGame> getSavedGames() {
        return savedGames;
    }

    public void saveToFile() {
        String json = gson.toJson(savedGames);

        try {
            File file = new File(context.getFilesDir(), FILE_NAME);

            if (!file.exists()) {
                boolean created = file.createNewFile();

                if (!created) {
                    Log.e(TAG, "Failed to create a new file");
                    return;
                }
            }

            FileWriter writer = new FileWriter(file);
            writer.write(json);
            writer.flush();
            writer.close();

            Log.d(TAG, "Saved games to file: " + json);
            Log.d(TAG, "File path: " + file.getAbsolutePath());
        } catch (IOException e) {
            Log.e(TAG, "Failed to save games to file: " + e.getMessage());
        }
    }

    private void loadFromFile() {
        try {
            File file = new File(context.getFilesDir(), FILE_NAME);

            if (!file.exists()) {
                boolean created = file.createNewFile();

                if (!created) {
                    Log.e(TAG, "Failed to create a new file");
                    return;
                }
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }

            reader.close();

            SavedGame[] savedGamesArray = gson.fromJson(sb.toString(), SavedGame[].class);
            if (savedGamesArray != null) {
                savedGames = new ArrayList<>(Arrays.asList(savedGamesArray));
                Log.d(TAG, "Loaded games from file: " + savedGames.toString());
            } else {
                Log.d(TAG, "Saved games array is null");
            }
        } catch (FileNotFoundException e) {
            Log.d(TAG, "Saved games file not found: " + e.getMessage());
        } catch (IOException e) {
            Log.e(TAG, "Failed to load games from file: " + e.getMessage());
        }
    }
}
