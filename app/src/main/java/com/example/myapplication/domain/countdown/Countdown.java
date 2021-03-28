package com.example.myapplication.domain.countdown;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * A thread-safe countdown counter implementation.
 */
public class Countdown {

    public static Countdown newDefault() {
        return new Countdown();
    }

    public static Countdown newStartingFrom(int startFrom) {
        return new Countdown(startFrom);
    }

    private static final int START_FROM = 30;

    private final AtomicInteger counter;

    public Countdown() {
        this(START_FROM);
    }

    public Countdown(int startFrom) {
        this.counter = new AtomicInteger(startFrom);
    }

    public boolean finishedCount() {
        return counter.get() == 0;
    }

    public int counterValue() {
        return counter.get();
    }

    public int decrementCounter() {
        return counter.getAndDecrement();
    }

    public void resetCounter() {
        counter.set(START_FROM);
    }

}
