package utils.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Objects;
import java.util.Optional;

import static java.lang.String.format;
import static utils.PropertyReader.getProperty;

public class DriverProvider {

    private WebDriver driver;

    public DriverProvider() {
        this.driver = createNewDriver();
    }

    public WebDriver getDriver() {
        return Optional.ofNullable(driver).orElseGet(this::createNewDriver);
    }

    private WebDriver createNewDriver() {
        switch (getProperty("BROWSER")) {
            case "FIREFOX" -> {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions()
                        .addArguments("start-maximized")
                        .addArguments("disable-infobars")
                        .addArguments("--headless");
                return new FirefoxDriver(options);
            }
            case "CHROME" -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions()
                        .addArguments("start-maximized")
                        .addArguments("disable-infobars");
                return new ChromeDriver(options);
            }
            default -> throw new IllegalArgumentException("Unknown browser. Please, edit config.properties");
        }
    }

    public void quiteDriver() {
        if (Objects.nonNull(driver))
            try {
                driver.manage().deleteAllCookies();
            } catch (Exception ex) {
                System.out.printf("An  exception  occurred while cookie deleting: %s%n", ex);
            }
        try {
            driver.close();
        } catch (Exception ex) {
            System.out.printf("An  exception  occurred while driver closing: %s%n", ex);
        }
        try {
            driver.quit();
        } catch (Exception ex) {
            System.out.printf("An  exception  occurred while cookie deleting: %s%n", ex);
        }
        driver = null;
    }
}