package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JSActions {

    private WebDriver driver;

    public JSActions(WebDriver driver) {
        this.driver = driver;
    }

    public static void clickButtonWithJS(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }
}