package ua.yakaboo;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BaseTests extends WebDriverSettings {

    @Test
    public void homePageIsDisplayed() {
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Yakaboo — Інтернет-магазин книг, подарунків і дитячих товарів. Купити книги та подарунки по найкращим в Україні цінами."));
    }

    @Test
    public void signInWithValidUser() throws InterruptedException {
        driver.findElement(By.id("customer_menu")).click();
        driver.findElement(By.id("modal-login"));
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.id("modal-login")).isDisplayed());

        driver.findElement(By.id("email")).sendKeys("oleksandr.berezhnyi@gravit.io");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("button-login-modal")).click();
    }
}

