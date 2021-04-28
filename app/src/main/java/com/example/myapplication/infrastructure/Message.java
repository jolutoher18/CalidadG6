package com.example.myapplication.infrastructure;

public class Message {

    private final String content;

    public Message(String content) {
        this.content = content;
    }

    public static Message newMessage(String content) {
        return new Message(content);
    }

    public String getContent() {
        return content;
    }

}


