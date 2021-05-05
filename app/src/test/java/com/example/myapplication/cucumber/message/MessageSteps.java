package com.example.myapplication.cucumber.message;

import com.example.myapplication.domain.score.Score;
import com.example.myapplication.domain.score.ScoreBonusCalculator;
import com.example.myapplication.infrastructure.Message;
import com.example.myapplication.infrastructure.MessageFactory;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MessageSteps {

    private static final String KEY = "messages.{language}.welcome";

    private MessageFactory messageFactory;

    @Given("^A populated message factory$")
    public void given() throws Throwable {
        messageFactory = createPopulated();
    }

    @When("^Obtaining the \"([^\"]*)\" welcome message$")
    public void when(String language) throws Throwable {
        messageFactory.createMessage(KEY.replace("{language}", language));
    }

    @Then("^The welcome message is in \"([^\"]*)\" language$")
    public void then(String language) throws Throwable {
        String key = KEY.replace("{language}", language);
        Message message = messageFactory.createMessage(key);
        Assert.assertEquals(language, message.getLanguage());
    }

    public MessageFactory createPopulated() {
        MessageFactory messageFactory = new MessageFactory();
        String key = KEY.replace("{language}", "spanish");
        String message = "¡Bienvenido!";
        messageFactory.storeMessage(key, new Message("spanish", message));
        return messageFactory;
    }

}
