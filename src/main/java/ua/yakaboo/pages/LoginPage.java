package ua.yakaboo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.Waits.waitSeconds;

public class LoginPage {
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
    private WebElement alertMessage;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
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
        waitSeconds(3);
    }

    public void clickOpenLoginPopupButton() {
        openLoginPopupButton.click();
        waitSeconds(3);
    }
}
