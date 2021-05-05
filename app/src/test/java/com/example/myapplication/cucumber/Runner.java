package com.example.myapplication.cucumber;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@CucumberOptions(
        plugin = "pretty",
        features = {
                "src/test/java/com/example/myapplication/cucumber/bonus/bonus.feature",
                "src/test/java/com/example/myapplication/cucumber/message/message.feature"
        },
        glue = "com.example.myapplication.cucumber"
)
@RunWith(Cucumber.class)
public class Runner {

}










