package com.example.myapplication.infrastructure;

import org.junit.Assert;
import org.junit.Test;

public class MessageTest {

    @Test
    public void createMessageTest() {
        // Arrange : arrangement of the preconditions of the test
        String content = "Welcome to the best game out here!";

        // Act : the performance of the act that is being tested
        Message message = Message.newMessage(content);

        // Assert : the assertion that the expected behavior occurred
        Assert.assertNotNull(message);
    }

    @Test
    public void getMessageTest() {
        // Arrange : arrangement of the preconditions of the test
        String content = "Welcome to the best game out here!";

        // Act : the performance of the act that is being tested
        Message message = Message.newMessage(content);

        // Assert : the assertion that the expected behavior occurred
        Assert.assertEquals("Welcome to the best game out here!", message.getContent());
    }

    @Test
    public void storeMessageTest() {
        // Arrange : arrangement of the preconditions of the test
        MessageFactory factory = new MessageFactory();
        String content = "Welcome to the best game out here!";
        Message message = Message.newMessage(content);

        // Act : the performance of the act that is being tested
        factory.storeMessage("game.welcome", message);

        // Assert : the assertion that the expected behavior occurred
        Assert.assertNotNull(factory.createMessage("game.welcome"));
    }

    @Test
    public void retrieveMessageTest() {
        // Arrange : arrangement of the preconditions of the test
        MessageFactory factory = new MessageFactory();
        String content = "Welcome to the best game out here!";
        Message message = Message.newMessage(content);

        // Act : the performance of the act that is being tested
        factory.storeMessage("game.welcome", message);

        // Assert : the assertion that the expected behavior occurred
        Assert.assertEquals(message, factory.createMessage("game.welcome"));
    }

    @Test
    public void deleteMessageTest() {
        // Arrange : arrangement of the preconditions of the test
        MessageFactory factory = new MessageFactory();
        String content = "Welcome to the best game out here!";
        Message message = Message.newMessage(content);
        factory.storeMessage("game.welcome", message);

        // Act : the performance of the act that is being tested
        factory.deleteMessage("game.welcome");

        // Assert : the assertion that the expected behavior occurred
        Assert.assertNull(factory.createMessage("game.welcome"));
    }

}




