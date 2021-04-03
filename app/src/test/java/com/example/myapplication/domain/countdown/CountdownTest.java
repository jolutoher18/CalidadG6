package com.example.myapplication.domain.countdown;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountdownTest {
    @Test
    public void createCountdown(){
        Countdown countdown = new Countdown();
        assertEquals(30, countdown.counterValue());
    }

    @Test
    public void createCountdownWithCustomStart(){
        Countdown countdown = new Countdown(74);
        assertEquals(74, countdown.counterValue());
    }

    @Test
    public void decrementCounter(){
        Countdown countdown = new Countdown(74);
        countdown.decrementCounter();
        assertEquals(73, countdown.counterValue());
    }

    @Test
    public void finishedCounter(){
        Countdown countdown = new Countdown(1);
        countdown.decrementCounter();
        assertTrue(countdown.finishedCount());
    }

    @Test
    public void resetCounter(){
        Countdown countdown = new Countdown(64);
        countdown.decrementCounter();
        countdown.resetCounter();
        assertEquals(64, countdown.counterValue());
    }

}