package ua.yakaboo.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ua.yakaboo.pages.LoginPage;

public class LoginTests extends BaseTests {

    @Test
    public void signInWithValidUser() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOpenLoginPopupButton();
        WebElement loginPopup = driver.findElement(By.xpath(".//div[@id='modal-login']"));
        Assert.assertTrue(loginPopup.isDisplayed(), "login popup is not displayed");
        loginPage.fillEmailField("oleksandr.berezhnyi@gravit.io");
        loginPage.fillPasswordField("123456");
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click();", driver.findElement(By.xpath(".//div[@class='modal-footer']//button[contains(@id,'login')]")));
        loginPage.clickLoginButton();
        String firstName = driver.findElement(By.xpath(".//span[@data-customer='firstname']")).getText();
        Assert.assertEquals(firstName, "Вітаємо, Oleksandr", "User name is not correct");
    }

    @Test
    public void signInWithEmptyFields() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOpenLoginPopupButton();
        WebElement loginPopup = driver.findElement(By.xpath(".//div[@id='modal-login']"));
        Assert.assertTrue(loginPopup.isDisplayed(), "login popup is not displayed");
        loginPage.clickLoginButton();
        Alert alert = driver.switchTo().alert();
        String alertMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(alertMessage, "Введіть телефон або e-mail.", "Alert message is not correct");
        alert.accept();
    }

    @Test
    public void signInWithEmptyLoginField() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOpenLoginPopupButton();
        WebElement loginPopup = driver.findElement(By.xpath(".//div[@id='modal-login']"));
        Assert.assertTrue(loginPopup.isDisplayed(), "login popup is not displayed");
        loginPage.fillPasswordField("123456");
        loginPage.clickLoginButton();
        Alert alert = driver.switchTo().alert();
        String alertMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(alertMessage, "Введіть телефон або e-mail.", "Alert message is not correct");
        alert.accept();
    }

    @Test
    public void signInWithEmptyPasswordField() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOpenLoginPopupButton();
        WebElement loginPopup = driver.findElement(By.xpath(".//div[@id='modal-login']"));
        Assert.assertTrue(loginPopup.isDisplayed(), "login popup is not displayed");
        loginPage.fillEmailField("oleksandr.berezhnyi@gravit.io");
        loginPage.clickLoginButton();
        Alert alert = driver.switchTo().alert();
        String alertMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(alertMessage, "Input password", "Alert message is not correct");
        alert.accept();
    }

    @Test
    public void signInWithInvalidCredentials() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOpenLoginPopupButton();
        WebElement loginPopup = driver.findElement(By.xpath(".//div[@id='modal-login']"));
        Assert.assertTrue(loginPopup.isDisplayed(), "login popup is not displayed");
        loginPage.fillEmailField("oleksandr.berezhnyi@gravit.io");
        loginPage.fillPasswordField("1234567");
        loginPage.clickLoginButton();
        String alertMessage = driver.findElement(By.xpath(".//div[@class='alert alert-error']")).getText();
        Assert.assertEquals(alertMessage, "Невірний логін або пароль.", "Alert message is not correct");
    }
}