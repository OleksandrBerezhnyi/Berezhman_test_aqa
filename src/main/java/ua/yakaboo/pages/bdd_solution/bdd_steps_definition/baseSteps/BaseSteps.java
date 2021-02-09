package ua.yakaboo.pages.bdd_solution.bdd_steps_definition.baseSteps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.driver.DriverProvider;

import static utils.PropertyReader.getProperty;

public class BaseSteps {
    private DriverProvider driverProvider;
    private WebDriver driver;

    public BaseSteps(DriverProvider driverProvider) {
        this.driverProvider = driverProvider;
    }

    @Before
    public void setUp() {
        driver = new DriverProvider().getDriver();
        driver.get(getProperty("HOME_URL"));
    }

    @After
    public void close() {
        driver.quit();
    }
}
