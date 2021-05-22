package com.example.myapplication.cucumber;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@CucumberOptions(
        plugin = "pretty",
        features = {
                // First two requested Gherkin HU's
                "src/test/java/com/example/myapplication/cucumber/bonus/bonus.feature",
                "src/test/java/com/example/myapplication/cucumber/message/message.feature",
                // The new 2 scenarios using generated skeleton (1 feature with 2 scenarios)
                "src/test/java/com/example/myapplication/cucumber/greeting/greeting.feature"
        },
        glue = "com.example.myapplication.cucumber"
)
@RunWith(Cucumber.class)
public class Runner {

}










