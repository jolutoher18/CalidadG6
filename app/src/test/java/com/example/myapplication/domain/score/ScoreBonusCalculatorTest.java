package com.example.myapplication.domain.score;

import org.junit.Assert;
import org.junit.Test;

/**
 * Acierto: (+) 10-50
 * Fallo:   (-) 5-25
 *
 *
 * Dada una puntuacion aplicarle el bonus y sumarle mas puntos
 *
 * Puntos     Incremento
 * 100-200        100
 * 200-300        200
 * 400-500        500
 */
public class ScoreBonusCalculatorTest {

    @Test
    public void addNonApplicableBonusToScoreTest() {
        // Arrange : arrangement of the preconditions of the test
        Score score = new Score();
        score.addPoints(5);
        ScoreBonusCalculator calculator = new ScoreBonusCalculator();

        // Act : the performance of the act that is being tested
        calculator.addBonus(score);

        // Assert : the assertion that the expected behavior occurred
        Assert.assertEquals(5, score.getPoints());
    }

    @Test
    public void addFirstApplicableBonusToScoreTest() {
        // Arrange : arrangement of the preconditions of the test
        Score score = new Score();
        score.addPoints(125);
        ScoreBonusCalculator calculator = new ScoreBonusCalculator();

        // Act : the performance of the act that is being tested
        calculator.addBonus(score);

        // Assert : the assertion that the expected behavior occurred
        Assert.assertEquals(225, score.getPoints());
    }

}













