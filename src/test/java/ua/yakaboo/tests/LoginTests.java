package ua.yakaboo.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.yakaboo.pages.LoginPage;
import utils.DriverHelper;
import utils.Waits;

public class LoginTests extends BaseTests {

    private LoginPage loginPage;
    private Waits waits;

    @BeforeMethod
    public void initLoginPage() {
        loginPage = new LoginPage(driver);
        waits = new Waits(driver);
    }

    @Test
    public void signInWithValidUser() throws InterruptedException {
        loginPage.waitOpenLoginPopupButtonToBeClickable(driver);
        loginPage.clickOpenLoginPopupButton(driver);
        Assert.assertTrue(loginPage.isLoginPopupDisplayed(), "login popup is not displayed");
        loginPage.fillEmailField("oleksandr.berezhnyi@gravit.io");
        loginPage.fillPasswordField("123456");
        loginPage.clickLoginButtonWithJS(driver);
        Assert.assertEquals(loginPage.getFirstName(), "Вітаємо, Oleksandr", "User name is not correct");
    }

    @Test
    public void signInWithEmptyFields() throws InterruptedException {
        loginPage.waitOpenLoginPopupButtonToBeClickable(driver);
        loginPage.clickOpenLoginPopupButton(driver);
        Assert.assertTrue(loginPage.isLoginPopupDisplayed(), "login popup is not displayed");
        loginPage.clickLoginButton();
        waits.waitAlertPresentShort();
        Assert.assertEquals(DriverHelper.getAlertText(driver), "Введіть телефон або e-mail.", "Alert message is not correct");
    }

    @Test
    public void signInWithEmptyLoginField() throws InterruptedException {
        loginPage.waitOpenLoginPopupButtonToBeClickable(driver);
        loginPage.clickOpenLoginPopupButton(driver);
        Assert.assertTrue(loginPage.isLoginPopupDisplayed(), "login popup is not displayed");
        loginPage.fillPasswordField("123456");
        loginPage.clickLoginButton();
        waits.waitAlertPresentShort();
        Assert.assertEquals(DriverHelper.getAlertText(driver), "Введіть телефон або e-mail.", "Alert message is not correct");
    }

    @Test
    public void signInWithEmptyPasswordField() throws InterruptedException {
        loginPage.waitOpenLoginPopupButtonToBeClickable(driver);
        loginPage.clickOpenLoginPopupButton(driver);
        Assert.assertTrue(loginPage.isLoginPopupDisplayed(), "login popup is not displayed");
        loginPage.fillEmailField("oleksandr.berezhnyi@gravit.io");
        loginPage.clickLoginButton();
        waits.waitAlertPresentShort();
        Assert.assertEquals(DriverHelper.getAlertText(driver), "Input password", "Alert message is not correct");
    }

    @Test
    public void signInWithInvalidCredentials() throws InterruptedException {
        loginPage.waitOpenLoginPopupButtonToBeClickable(driver);
        loginPage.clickOpenLoginPopupButton(driver);
        Assert.assertTrue(loginPage.isLoginPopupDisplayed(), "login popup is not displayed");
        loginPage.fillEmailField("oleksandr.berezhnyi@gravit.io");
        loginPage.fillPasswordField("1234567");
        loginPage.clickLoginButton();
        loginPage.waitLoginPopupAlertMessageToBeVisibility(driver);
        Assert.assertEquals(loginPage.getLoginPopupAlertMessage(), "Невірний логін або пароль.", "Alert message is not correct");
    }
}