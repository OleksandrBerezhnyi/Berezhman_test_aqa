package ua.yakaboo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.JSActions.clickButtonWithJS;

public class LoginPage extends BasePage {

    @FindBy(xpath = ".//a[@class='show-modal-login']")
    private WebElement openLoginPopupButton;

    @FindBy(xpath = ".//div[@id='modal-login']")
    private WebElement loginPopup;

    @FindBy(xpath = ".//input[contains(@name,'username')]")
    private WebElement usernameField;

    @FindBy(xpath = ".//input[contains(@name,'password')]")
    private WebElement passwordField;

    @FindBy(xpath = ".//div[@class='modal-footer']//button[contains(@id,'login')]")
    private WebElement loginButton;

    @FindBy(xpath = ".//span[@data-customer='firstname']")
    private WebElement profileFirstName;

    @FindBy(xpath = ".//div[@class='alert alert-error']")
    private WebElement loginPopupAlertMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void fillEmailField(String userEmail) {
        usernameField.clear();
        usernameField.sendKeys(userEmail);
    }

    public void fillPasswordField(String userPassword) {
        passwordField.clear();
        passwordField.sendKeys(userPassword);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickOpenLoginPopupButton(WebDriver driver) {
        openLoginPopupButton.click();
        waits.waitVisibilityOfElement(usernameField, 3);
    }

    public boolean isLoginPopupDisplayed() {
        return loginPopup.isDisplayed();
    }

    public String getFirstName() {
        return profileFirstName.getText();
    }

    public String getLoginPopupAlertMessage() {
        return loginPopupAlertMessage.getText();
    }

    public void clickLoginButtonWithJS(WebDriver driver) {
        clickButtonWithJS(driver, loginButton);
        waits.waitVisibilityOfElementShort(profileFirstName);
    }

    public void waitOpenLoginPopupButtonToBeClickable(WebDriver driver) {
        waits.waitElementToBeClickableShort(openLoginPopupButton);
    }

    public void waitLoginPopupAlertMessageToBeVisibility(WebDriver driver) {
        waits.waitVisibilityOfElementShort(loginPopupAlertMessage);
    }
}