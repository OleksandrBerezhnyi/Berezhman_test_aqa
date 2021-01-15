package ua.yakaboo.Tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTests {

    @Test
    public void signInWithValidUser() throws InterruptedException {
        driver.findElement(By.id("customer_menu")).click();
        Thread.sleep(2000);
        WebElement loginPopup = driver.findElement(By.xpath(".//a[@class='show-modal-login']"));
        Assert.assertTrue(loginPopup.isDisplayed(), "login popup is not displayed");

        driver.findElement(By.xpath(".//input[contains(@name,'username')]")).sendKeys("oleksandr.berezhnyi@gravit.io");
        driver.findElement(By.xpath(".//input[contains(@name,'password')]")).sendKeys("123456");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath(".//div[@class='modal-footer']//button[contains(@id,'login')]")));
        Thread.sleep(2000);

        String firstName = driver.findElement(By.xpath(".//span[@data-customer='firstname']")).getText();
        Assert.assertEquals(firstName, "Вітаємо, Oleksandr", "User name is not correct");
    }


    @Test
    public void signInWithEmptyFields() throws InterruptedException {
        driver.findElement(By.id("customer_menu")).click();
        Thread.sleep(2000);
        WebElement loginPopup = driver.findElement(By.id("modal-login"));
        Assert.assertTrue(loginPopup.isDisplayed(), "login popup is not displayed");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath(".//div[@class='modal-footer']//button[contains(@id,'login')]")));
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        String alertMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(alertMessage, "Введіть телефон або e-mail.", "Alert message is not correct");
        alert.accept();
    }

    @Test
    public void signInWithEmptyLoginField() throws InterruptedException {
        driver.findElement(By.id("customer_menu")).click();
        Thread.sleep(2000);
        WebElement loginPopup = driver.findElement(By.id("modal-login"));
        Assert.assertTrue(loginPopup.isDisplayed(), "login popup is not displayed");
        driver.findElement(By.id("pass")).sendKeys("123456");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath(".//div[@class='modal-footer']//button[contains(@id,'login')]")));
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        String alertMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(alertMessage, "Введіть телефон або e-mail.", "Alert message is not correct");
        alert.accept();
    }

    @Test
    public void signInWithEmptyPasswordFields() throws InterruptedException {
        driver.findElement(By.id("customer_menu")).click();
        Thread.sleep(2000);
        WebElement loginPopup = driver.findElement(By.id("modal-login"));
        Assert.assertTrue(loginPopup.isDisplayed(), "login popup is not displayed");
        driver.findElement(By.id("email")).sendKeys("oleksandr.berezhnyi@gravit.io");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath(".//div[@class='modal-footer']//button[contains(@id,'login')]")));
        Alert alert = driver.switchTo().alert();
        String alertMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(alertMessage, "Input password", "Alert message is not correct");
        alert.accept();
    }

    @Test
    public void signInWithInvalidCredentials() throws InterruptedException {
        driver.findElement(By.id("customer_menu")).click();
        Thread.sleep(2000);
        WebElement loginPopup = driver.findElement(By.id("modal-login"));
        Assert.assertTrue(loginPopup.isDisplayed(), "login popup is not displayed");
        driver.findElement(By.id("email")).sendKeys("oleksandr.berezhnyi@gravit.io");
        driver.findElement(By.id("pass")).sendKeys("1234567");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath(".//div[@class='modal-footer']//button[contains(@id,'login')]")));
        Thread.sleep(2000);
        String alertMessage = driver.findElement(By.xpath(".//div[@class='alert alert-error']")).getText();
        System.out.println(alertMessage);
        Assert.assertEquals(alertMessage, "Невірний логін або пароль.", "Alert message is not correct");
    }
}