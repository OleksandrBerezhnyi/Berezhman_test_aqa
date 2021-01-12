package ua.yakaboo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
        Thread.sleep(3000);
        WebElement loginPopup = driver.findElement(By.id("modal-login"));
        Assert.assertTrue(loginPopup.isDisplayed(), "login popup is not displayed");

        driver.findElement(By.id("email")).sendKeys("oleksandr.berezhnyi@gravit.io");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.xpath(".//div[@class='modal-footer']//button[contains(@id,'login')]")).click();
        Thread.sleep(2000);
        String firstName = driver.findElement(By.xpath(".//span[@data-customer='firstname']")).getText();
        Assert.assertEquals(firstName, "Вітаємо, Oleksandr");
    }
}

