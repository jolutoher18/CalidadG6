package com.example.myapplication.domain.score;

public class ScoreBonusCalculator {

    public void addBonus(Score score) {
        if(score.getPoints() >= 100) {
            score.addPoints(100);
        }
    }

}
