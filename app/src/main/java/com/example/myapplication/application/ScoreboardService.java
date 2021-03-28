package com.example.myapplication.application;

import com.example.myapplication.domain.score.Score;

import java.util.List;

/**
 * Application-level service to manage the scoreboard.
 */
public interface ScoreboardService {

    /**
     * Finds the {@code amount} highest scores.
     * @param amount top scores amount to be found
     * @return the {@code amount} highest scores
     */
    List<Score> findByHighestScore(int amount);

    /**
     * Adds a new score to the scoreboard.
     * @param score a score to be added
     * @return the scoreboard added score
     */
    Score addScoreToScoreboard(Score score);

}
