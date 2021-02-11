package ua.yakaboo.tests.testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/ua/yakaboo/tests/features",
        glue = "steps",
        tags = "@SmokeTest")
public class TestRunner {
}
