package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Waits {

    private WebDriver driver;

    private final int shortTimeout = 3;
    private final int middleTimeout = 8;
    private final int longTimeout = 15;

    public Waits(WebDriver driver) {
        this.driver = driver;
    }

    public void waitPresenceOfElementLocated(By element, int timeOut) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeOut);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public void waitPresenceOfElementShort(By element) {
        waitPresenceOfElementLocated(element, shortTimeout);
    }

    public void waitPresenceOfElementMiddle(By element) {
        waitPresenceOfElementLocated(element, middleTimeout);
    }

    public void waitPresenceOfElementLong(By element) {
        waitPresenceOfElementLocated(element, longTimeout);
    }

    public void waitVisibilityOfElement(WebElement element, int timeOut) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeOut);
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitVisibilityOfElementShort(WebElement element) {
        waitVisibilityOfElement(element, shortTimeout);
    }

    public void waitVisibilityOfElementMiddle(WebElement element) {
        waitVisibilityOfElement(element, middleTimeout);
    }

    public void waitVisibilityOfElementLong(WebElement element) {
        waitVisibilityOfElement(element, longTimeout);
    }

    public void waitVisibilityOfElements(List<WebElement> elements, int timeOut) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeOut);
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public void waitAlertPresent(int timeOut) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeOut);
        webDriverWait.until(ExpectedConditions.alertIsPresent());
    }

    public void waitAlertPresentShort() {
        waitAlertPresent(shortTimeout);
    }

    public void waitAlertPresentMiddle() {
        waitAlertPresent(middleTimeout);
    }

    public void waitAlertPresentLong() {
        waitAlertPresent(longTimeout);
    }

    public void waitElementToBeClickable(WebElement element, int timeOut) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeOut);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitElementToBeClickableShort(WebElement element) {
        waitElementToBeClickable(element, shortTimeout);
    }

    public void waitElementToBeClickableMiddle(WebElement element) {
        waitElementToBeClickable(element, middleTimeout);
    }

    public void waitElementToBeClickableLong(WebElement element) {
        waitElementToBeClickable(element, longTimeout);
    }

    public boolean isElementToBeClickable(WebElement element, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.elementToBeClickable(element)) != null;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isElementToBeClickableShort(WebElement element) {
        return isElementToBeClickable(element, shortTimeout);
    }

    public boolean isElementVisibility(WebElement element, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.visibilityOf(element)) != null;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isElementVisibilityShort(WebElement element) {
        return isElementVisibility(element, shortTimeout);
    }
}