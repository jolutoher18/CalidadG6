package com.example.myapplication.domain.score.points;

import com.example.myapplication.domain.Status;
import com.example.myapplication.domain.random.RandomUtils;

/**
 * A karma-based {@link PointsStrategy} which is takes into account the current karma.
 */
public class KarmaBasedPointsStrategy implements PointsStrategy {

    @Override
    public int computeIncrement(Status status, int currentKarma) {
        int increment;
        if(status == Status.SUCCESS) {
            int min = 10 + (currentKarma / 2);
            int max = 50 + (currentKarma / 2);
            increment = RandomUtils.randomInRange(min, max);
        } else {
            int min = 5 + currentKarma;
            int max = 25 + currentKarma;
            increment = -RandomUtils.randomInRange(min, max);
        }
        return increment;
    }

}
