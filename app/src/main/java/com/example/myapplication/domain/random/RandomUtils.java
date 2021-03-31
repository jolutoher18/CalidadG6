package com.example.myapplication.domain.random;

import java.util.Random;

public class RandomUtils {

    private static Random BASE_RANDOM = new Random();

    public static int randomInRange(int min, int max) {
        return BASE_RANDOM.nextInt((max - min) + 1) + min;
    }

}
