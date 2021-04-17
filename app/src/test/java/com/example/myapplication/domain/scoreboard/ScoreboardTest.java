package com.example.myapplication.domain.scoreboard;

import com.example.myapplication.domain.score.Score;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class ScoreboardTest {

    @Test
    public void getAllScores() {
        Scoreboard scoreboard = new Scoreboard();
        Score score = new Score(10,20);
        Score score2 = new Score(30,50);

        ArrayList<Score> givenScores = new ArrayList<>();
        givenScores.add(score);
        givenScores.add(score2);

        scoreboard.addAllScores(givenScores);
        Collections.reverse(givenScores);

        assertEquals(givenScores, scoreboard.getAllScores());

    }


    @Test
    public void addScore() {
        Scoreboard scoreboard = new Scoreboard();
        Score score = new Score(10,20);
        scoreboard.addScore(score);
        List<Score> scores = new ArrayList<Score>();
        scores.add(score);

        assertEquals(scores, scoreboard.getAllScores());
    }
}