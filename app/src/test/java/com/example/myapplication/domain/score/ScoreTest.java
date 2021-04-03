package com.example.myapplication.domain.score;

import static org.junit.Assert.*;
import org.junit.Test;


public class ScoreTest {

    @Test
    public void getPoints(){
        Score score = new Score();
        assertEquals(0, score.getPoints());
    }

    @Test
    public void getKarma(){
        Score score = new Score();
        assertEquals(0, score.getKarma());
    }

    @Test
    public void incrementKarma(){
        Score score = new Score();
        score.incrementKarma(2);
        assertEquals(2, score.getKarma());
    }
}