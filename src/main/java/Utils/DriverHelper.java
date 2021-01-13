package Utils;

import org.openqa.selenium.WebDriver;

public class DriverHelper {

    public static void switchWindowByTitle(String title, WebDriver driver) {
        //will keep current window to switch back
        String currentWindow = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            if (driver.switchTo().window(winHandle).getTitle().contains(title)) {
                //This is the one you're looking for
                break;
            } else {
                driver.switchTo().window(currentWindow);
            }
        }
    }
}
