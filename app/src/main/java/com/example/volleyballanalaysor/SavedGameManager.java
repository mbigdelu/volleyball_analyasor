package com.example.volleyballanalaysor;

import java.io.*;


    public class SavedGameManager{
        private static final String FILE_PATH = "./SavedGames/saved_games.obj"; // replace with your file path
        private SavedGame[] savedGames;

        public SavedGameManager() {
            try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
                savedGames = (SavedGame[]) inputStream.readObject();
            } catch (FileNotFoundException e) {
                // If the file doesn't exist yet, initialize the array to an empty array
                savedGames = new SavedGame[0];
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        public SavedGame[] getSavedGames() {
            return savedGames;
        }

        public void addSavedGame(SavedGame newSavedGame) {
            SavedGame[] updatedSavedGames = new SavedGame[savedGames.length + 1];
            System.arraycopy(savedGames, 0, updatedSavedGames, 0, savedGames.length);
            updatedSavedGames[savedGames.length] = newSavedGame;
            savedGames = updatedSavedGames;
        }

        public void saveToFile() {
            try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
                outputStream.writeObject(savedGames);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


