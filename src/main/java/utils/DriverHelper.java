package utils;

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
}
