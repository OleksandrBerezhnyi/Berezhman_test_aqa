package utils.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Optional;

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
}
