package utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class DriverHelper {

    public static void switchWindowByTitle(String title, WebDriver driver) {
        String currentWindow = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            if (driver.switchTo().window(winHandle).getTitle().contains(title)) {
                break;
            } else {
                driver.switchTo().window(currentWindow);
            }
        }
    }

    public static String getAlertText(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        String alertMessage = driver.switchTo().alert().getText();
        alert.accept();
        return alertMessage;
    }

}
