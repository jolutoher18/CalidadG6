package com.example.myapplication.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@SuppressWarnings("NewAPI")
public class Greetings {

    public static boolean GREETINGS_ENABLED = true;

    public boolean areGreetingsEnabled() {
        return GREETINGS_ENABLED;
    }

    public String randomGreeting() {
        if(!areGreetingsEnabled()) throw new RuntimeException("Greetings are not enabled");
        List<String> greetings = getAllGreetings();
        int index = ThreadLocalRandom.current().nextInt(0, greetings.size());
        return greetings.get(index);
    }

    public List<String> getAllGreetings() {
        return new ArrayList<String>() {{
            add("Welcome back! Ready to play?");
            add("Hi, glad to see you again");
            add("Welcome back to the best game!");
        }};
    }

}
