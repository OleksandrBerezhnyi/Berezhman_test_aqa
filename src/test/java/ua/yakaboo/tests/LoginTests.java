package ua.yakaboo.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.yakaboo.pages.LoginPage;
import utils.DriverHelper;

public class LoginTests extends BaseTests {

    private LoginPage loginPage;

    @BeforeMethod
    public void initLoginPage() {
        loginPage = new LoginPage(driver);
    }

    @Test
    public void signInWithValidUser() {
        loginPage.waitOpenLoginPopupButtonToBeClickable();
        loginPage.clickOpenLoginPopupButton();
        Assert.assertTrue(waits.isElementVisibilityShort(loginPage.loginPopup), "login popup is not displayed");
        loginPage.fillEmailField("oleksandr.berezhnyi@gravit.io");
        loginPage.fillPasswordField("123456");
        loginPage.clickLoginButtonWithJS(driver);
        Assert.assertEquals(loginPage.getFirstName(), "Вітаємо, Oleksandr", "User name is not correct");
    }

    @Test
    public void signInWithEmptyFields() throws InterruptedException {
        loginPage.waitOpenLoginPopupButtonToBeClickable();
        loginPage.clickOpenLoginPopupButton();
        Assert.assertTrue(waits.isElementVisibilityShort(loginPage.loginPopup), "login popup is not displayed");
        loginPage.loginButton.click();
        waits.waitAlertPresentShort();
        Assert.assertEquals(DriverHelper.getAlertText(driver), "Введіть телефон або e-mail.", "Alert message is not correct");
    }

    @Test
    public void signInWithEmptyLoginField() throws InterruptedException {
        loginPage.waitOpenLoginPopupButtonToBeClickable();
        loginPage.clickOpenLoginPopupButton();
        Assert.assertTrue(waits.isElementVisibilityShort(loginPage.loginPopup), "login popup is not displayed");
        loginPage.fillPasswordField("123456");
        loginPage.loginButton.click();
        waits.waitAlertPresentShort();
        Assert.assertEquals(DriverHelper.getAlertText(driver), "Введіть телефон або e-mail.", "Alert message is not correct");
    }

    @Test
    public void signInWithEmptyPasswordField() throws InterruptedException {
        loginPage.waitOpenLoginPopupButtonToBeClickable();
        loginPage.clickOpenLoginPopupButton();
        Assert.assertTrue(waits.isElementVisibilityShort(loginPage.loginPopup), "login popup is not displayed");
        loginPage.fillEmailField("oleksandr.berezhnyi@gravit.io");
        loginPage.loginButton.click();
        waits.waitAlertPresentShort();
        Assert.assertEquals(DriverHelper.getAlertText(driver), "Input password", "Alert message is not correct");
    }

    @Test
    public void signInWithInvalidCredentials() throws InterruptedException {
        loginPage.waitOpenLoginPopupButtonToBeClickable();
        loginPage.clickOpenLoginPopupButton();
        Assert.assertTrue(waits.isElementVisibilityShort(loginPage.loginPopup), "login popup is not displayed");
        loginPage.fillEmailField("oleksandr.berezhnyi@gravit.io");
        loginPage.fillPasswordField("1234567");
        loginPage.loginButton.click();
        loginPage.waitLoginPopupAlertMessageToBeVisibility(driver);
        Assert.assertEquals(loginPage.getLoginPopupAlertMessage(), "Невірний логін або пароль.", "Alert message is not correct");
    }
}