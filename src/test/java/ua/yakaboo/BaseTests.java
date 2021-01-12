package ua.yakaboo;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

public class BaseTests extends WebDriverSettings {

    @Test
    public void homePageIsDisplayed() {
        driver.get("https://www.yakaboo.ua/");

        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Yakaboo — Інтернет-магазин книг, подарунків і дитячих товарів. Купити книги та подарунки по найкращим в Україні цінами."));
    }

    @Test
    public void SignIn() {
        driver.get("https://www.yakaboo.ua/");

        driver.findElement(By.id("customer_menu")).click();
        driver.findElement(By.id("modal-login")).isDisplayed();
        driver.findElement(By.id("email")).sendKeys("oleksandr.berezhnyi@gravit.io");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("button-login-modal")).click();
    }
}
