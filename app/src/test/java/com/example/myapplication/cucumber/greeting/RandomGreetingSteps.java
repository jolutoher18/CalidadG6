package com.example.myapplication.cucumber.greeting;

import com.example.myapplication.domain.Greetings;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RandomGreetingSteps {

    private Greetings greetings;
    private String generatedGreeting;

    @Given("^A random greeting generator$")
    public void given() throws Throwable {
        greetings = new Greetings();
    }

    @When("^Generating a new random greeting$")
    public void when() throws Throwable {
        generatedGreeting = greetings.randomGreeting();
    }

    @Then("^The greeting must be in the greetings list$")
    public void then() throws Throwable {
        Assert.assertTrue(greetings.getAllGreetings().contains(generatedGreeting));
    }

}
