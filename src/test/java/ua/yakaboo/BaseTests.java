package ua.yakaboo;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BaseTests {
    @Test
    public void HomePageIsDisplayed() {
        System.setProperty("webdriver.chrome.driver", "/Users/Berezhman/Downloads/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://www.yakaboo.ua/");

        String title = driver.getTitle();
        System.out.println(driver.getTitle());
        Assert.assertTrue(title.equals("Yakaboo — Інтернет-магазин книг, подарунків і дитячих товарів. Купити книги та подарунки по найкращим в Україні цінами."));

        driver.quit();
    }
}
