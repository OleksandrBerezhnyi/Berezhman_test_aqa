package ua.yakaboo.tests.testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/ua/yakaboo/tests/features",
        glue = "bdd_steps_definition",
        tags = "@SmokeTest")

public class TestRunner {
}
