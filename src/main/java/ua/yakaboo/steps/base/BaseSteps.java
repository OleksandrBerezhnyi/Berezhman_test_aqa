package ua.yakaboo.steps.base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.driver.DriverProvider;

import static utils.PropertyReader.getProperty;

public class BaseSteps {
    private DriverProvider driverProvider;

    public BaseSteps(DriverProvider driverProvider) {
        this.driverProvider = driverProvider;
    }

    @Before
    public void setUp() {
        var driver = driverProvider.getDriver();
        driver.get(getProperty("HOME_URL"));
    }

    @After
    public void close() {
        driverProvider.quiteDriver();
    }
}
