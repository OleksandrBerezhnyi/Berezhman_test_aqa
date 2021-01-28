package ua.yakaboo.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.Waits;
import utils.driver.DriverProvider;

import static utils.PropertyReader.getProperty;

public class BaseTests {

    public WebDriver driver;
    public Waits waits;

    @BeforeMethod
    public void setUp() {
        driver = new DriverProvider().getDriver();
        driver.get(getProperty("HOME_URL"));
        waits = new Waits(driver);
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }
}
