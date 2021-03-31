package com.example.myapplication.domain.score.points;

import com.example.myapplication.domain.Status;

/**
 * A strategy to compute the points increment depending on given status.
 */
public interface PointsStrategy {

    int computeIncrement(Status state, int currentKarma);

}
