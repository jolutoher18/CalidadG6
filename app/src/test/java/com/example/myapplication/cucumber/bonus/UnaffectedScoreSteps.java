package com.example.myapplication.cucumber.bonus;


import com.example.myapplication.domain.score.Score;
import com.example.myapplication.domain.score.ScoreBonusCalculator;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UnaffectedScoreSteps {

    private Score score;
    private ScoreBonusCalculator calculator;

    @Given("^A score with 5 points$")
    public void given() throws Throwable {
        calculator = new ScoreBonusCalculator();
        score = new Score();
        score.addPoints(5);
    }

    @When("^Adding bonus to 5 points score$")
    public void when() throws Throwable {
        calculator.addBonus(score);
    }

    @Then("^Score remains still with 5 points$")
    public void then() throws Throwable {
        Assert.assertEquals(5, score.getPoints());
    }

}
