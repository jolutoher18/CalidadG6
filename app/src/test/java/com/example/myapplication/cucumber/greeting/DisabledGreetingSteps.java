package com.example.myapplication.cucumber.greeting;

import com.example.myapplication.domain.Greetings;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DisabledGreetingSteps {

    private Greetings greetings;
    private boolean hasThrowedException;

    @Given("^A disabled random greeting$")
    public void given() throws Throwable {
        Greetings.GREETINGS_ENABLED = false;
        greetings = new Greetings();
    }

    @When("^Generating a new random greeting, when greetings are disabled$")
    public void when() throws Throwable {
        try {
            greetings.randomGreeting();
        } catch(Exception ignored) {
            hasThrowedException = true;
        }
    }

    @Then("^Throws an exception$")
    public void then() throws Throwable {
        Assert.assertTrue(hasThrowedException);
    }

}
