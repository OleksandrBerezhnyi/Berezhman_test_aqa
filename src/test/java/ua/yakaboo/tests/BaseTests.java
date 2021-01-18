package ua.yakaboo.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.driver.DriverProvider;

import static utils.PropertyReader.getProperty;

public class BaseTests {

    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new DriverProvider().getDriver();
        driver.get(getProperty("HOME_URL"));
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }
}
