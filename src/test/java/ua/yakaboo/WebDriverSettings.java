package ua.yakaboo;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class WebDriverSettings {

    public ChromeDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver87");
        driver = new ChromeDriver();
        driver.get("https://www.yakaboo.ua/");
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }
}
