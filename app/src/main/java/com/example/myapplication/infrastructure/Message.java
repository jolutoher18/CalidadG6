package com.example.myapplication.infrastructure;

public class Message {

    private final String language;
    private final String content;

    public Message(String language, String content) {
        this.language = language;
        this.content = content;
    }

    public static Message newMessage(String language, String content) {
        return new Message(language, content);
    }

    public String getLanguage() {
        return language;
    }

    public String getContent() {
        return content;
    }

}


