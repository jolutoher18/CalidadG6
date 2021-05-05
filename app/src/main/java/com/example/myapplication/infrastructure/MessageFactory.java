package com.example.myapplication.infrastructure;

import java.util.HashMap;
import java.util.Map;

public class MessageFactory {

    private final Map<String, Message> keyToMessage;

    public MessageFactory() {
        this.keyToMessage = new HashMap<>();
    }

    public Message createMessage(String key) {
        return keyToMessage.get(key);
    }

    public void storeMessage(String key, Message message) {
        keyToMessage.put(key, message);
    }

    public boolean deleteMessage(String key) {
        keyToMessage.remove(key);
        return true;
    }

}
