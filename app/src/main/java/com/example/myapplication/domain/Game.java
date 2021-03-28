package com.example.myapplication.domain;

import com.example.myapplication.domain.countdown.Countdown;
import com.example.myapplication.domain.score.Score;

public class Game {

    private final Countdown countdown;
    private final Score score;

    public Game() {
        this.countdown = Countdown.newDefault();
        this.score = new Score();
    }

    public void resetGame() {
        countdown.resetCounter();
        score.resetPoints();
    }

    public Score getScore() {
        return score;
    }

    public boolean hasGameFinished() {
        return countdown.finishedCount();
    }

    public void updateStatus(Status status) {
        score.updateStatus(status);
    }

    public int countdown() {
        return countdown.decrementCounter();
    }

}
