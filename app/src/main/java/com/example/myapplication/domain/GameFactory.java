package com.example.myapplication.domain;

/**
 * Represents a simple singleton factory for the game.
 */
public class GameFactory {

    private static Game game;

    public static Game currentGame() {
        if(game == null) {
            game = new Game();
        }
        return game;
    }

    public static Game resetGame() {
        Game currentGame = currentGame();
        currentGame.resetGame();
        return currentGame;
    }

}
