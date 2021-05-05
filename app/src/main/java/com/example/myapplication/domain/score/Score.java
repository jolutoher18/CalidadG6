package com.example.myapplication.domain.score;

import com.example.myapplication.domain.Status;
import com.example.myapplication.domain.score.points.KarmaBasedPointsStrategy;
import com.example.myapplication.domain.score.points.PointsStrategy;
import com.example.myapplication.domain.score.points.SimplePointsStrategy;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * A score that represents the current achieved points.
 */
public class Score implements Comparable<Score> {

    private static final int STARTING_POINTS = 0;
    private static final int STARTING_KARMA = 0;

    private final AtomicInteger points;
    private final AtomicBoolean isKarmaLocked;
    private final AtomicInteger karma;

    public Score() {
        this(STARTING_POINTS, STARTING_KARMA);
    }

    public Score(int points, int karma) {
        this.points = new AtomicInteger(points);
        this.karma = new AtomicInteger(karma);
        this.isKarmaLocked = new AtomicBoolean(false);
    }

    public int getPoints() {
        return points.get();
    }

    public int getKarma() {
        return karma.get();
    }

    public void resetPoints() {
        points.set(STARTING_POINTS);
    }

    public void updateStatus(Status status) {
        PointsStrategy pointsStrategy = isKarmaLocked.get() ? new SimplePointsStrategy() : new KarmaBasedPointsStrategy();
        int increment = pointsStrategy.computeIncrement(status, getKarma());
        int result = increment + getPoints() < 0 ? STARTING_POINTS : increment;
        points.set(result);
    }

    public int addPoints(int increment) {
        points.set(points.get() + increment);
        return points.get();
    }

    public boolean setKarma(boolean locked) {
        return isKarmaLocked.getAndSet(!locked);
    }

    public int incrementKarma(int increment) {
        return karma.getAndSet(getKarma() + increment);
    }

    @Override
    public int compareTo(Score score) {
        return Integer.compare(getPoints(), score.getPoints());
    }

}