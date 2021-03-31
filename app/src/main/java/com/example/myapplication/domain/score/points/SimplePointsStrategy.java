package com.example.myapplication.domain.score.points;

import com.example.myapplication.domain.Status;
import com.example.myapplication.domain.random.RandomUtils;

/**
 * A simple {@link PointsStrategy} which is the default points calculator.
 */
public class SimplePointsStrategy implements PointsStrategy {

    @Override
    public int computeIncrement(Status status, int currentKarma) {
        int increment;
        if(status == Status.SUCCESS) {
            int min = 10;
            int max = 50;
            increment = RandomUtils.randomInRange(min, max);
        } else {
            int min = 5;
            int max = 25;
            increment = -RandomUtils.randomInRange(min, max);
        }
        return increment;
    }

}
