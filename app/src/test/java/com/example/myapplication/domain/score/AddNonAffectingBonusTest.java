package com.example.myapplication.domain.score;

import org.junit.Assert;
import org.junit.runner.RunWith;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
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
@RunWith(Cucumber.class)
public class AddNonAffectingBonusTest {

    /*@Test
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

        // Act : the performance of the act that is being tested
        calculator.addBonus(score);

        // Assert : the assertion that the expected behavior occurred
        Assert.assertEquals(225, score.getPoints());
    }*/

    private Score score;
    private ScoreBonusCalculator calculator;

    @Given("^an initial score$")
    public void givenAnInitialScore() throws Throwable {
        calculator = new ScoreBonusCalculator();
        score = new Score();
        score.addPoints(125);
    }

    @When("^add non affecting bonus$")
    public void whenAddNonAffectingBonus() throws Throwable {
        calculator.addBonus(score);
    }

    @Then("^score not altered$")
    public void thenScoreNotAltered() throws Throwable {
        Assert.assertEquals(5, score.getPoints());
    }

}










