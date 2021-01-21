package ua.yakaboo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.yakaboo.pages.LoginPage;
import utils.DriverHelper;

public class LoginTests extends BaseTests {

    @Test
    public void signInWithValidUser() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOpenLoginPopupButton();
        Assert.assertTrue(loginPage.isLoginPopupDisplayed(), "login popup is not displayed");
        loginPage.fillEmailField("oleksandr.berezhnyi@gravit.io");
        loginPage.fillPasswordField("123456");
        loginPage.clickLoginButtonWithJS(driver);
        Assert.assertEquals(loginPage.getFirstName(), "Вітаємо, Oleksandr", "User name is not correct");
    }

    @Test
    public void signInWithEmptyFields() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOpenLoginPopupButton();
        Assert.assertTrue(loginPage.isLoginPopupDisplayed(), "login popup is not displayed");
        loginPage.clickLoginButton();
        Assert.assertEquals(DriverHelper.getAlertText(driver), "Введіть телефон або e-mail.", "Alert message is not correct");
    }

    @Test
    public void signInWithEmptyLoginField() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOpenLoginPopupButton();
        Assert.assertTrue(loginPage.isLoginPopupDisplayed(), "login popup is not displayed");
        loginPage.fillPasswordField("123456");
        loginPage.clickLoginButton();
        Assert.assertEquals(DriverHelper.getAlertText(driver), "Введіть телефон або e-mail.", "Alert message is not correct");
    }

    @Test
    public void signInWithEmptyPasswordField() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOpenLoginPopupButton();
        Assert.assertTrue(loginPage.isLoginPopupDisplayed(), "login popup is not displayed");
        loginPage.fillEmailField("oleksandr.berezhnyi@gravit.io");
        loginPage.clickLoginButton();
        Assert.assertEquals(DriverHelper.getAlertText(driver), "Input password", "Alert message is not correct");
    }

    @Test
    public void signInWithInvalidCredentials() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOpenLoginPopupButton();
        Assert.assertTrue(loginPage.isLoginPopupDisplayed(), "login popup is not displayed");
        loginPage.fillEmailField("oleksandr.berezhnyi@gravit.io");
        loginPage.fillPasswordField("1234567");
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getLoginPopupAlertMessage(), "Невірний логін або пароль.", "Alert message is not correct");
    }
}