package ua.yakaboo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import utils.Waits;

public class HeaderPage extends BasePage {

    @FindBy(xpath = ".//div[@class='i-logo']//img[contains(@src,'logo_book_cup.png')]")
    private WebElement storeLogo;

    @FindBy(className = "grv-dialog-host")
    private WebElement attachedWebElement;

    private By shadowOkButton = By.cssSelector("button.sub-dialog-btn.block_btn");

    @FindBy(xpath = ".//ul[@class='cms-list']//a[contains(@href,'promotions')]")
    private WebElement promotionsButton;

    @FindBy(xpath = ".//article[@class='col-main']")
    private WebElement discountsPage;

    @FindBy(xpath = ".//ul[@class='cms-list']//a[contains(@href,'about-us')]")
    private WebElement aboutUsButton;

    @FindBy(xpath = ".//div[@class='line vertical']//preceding-sibling::div[@class='span10']")
    private WebElement aboutUsPage;

    @FindBy(xpath = ".//ul[@class='cms-list']//a[contains(@href,'delivery')]")
    private WebElement deliveryButton;

    @FindBy(xpath = ".//article[@class='col-main']//child::div[@id='cms-content']")
    private WebElement deliveryPage;

    @FindBy(xpath = ".//ul[@class='cms-list']//a[contains(@href,'payment')]")
    private WebElement paymentButton;

    @FindBy(xpath = ".//article[@class='col-main']//parent::div[contains(@class,'span10')]")
    private WebElement paymentPage;

    @FindBy(xpath = ".//ul[@class='cms-list']//a[contains(@href,'contact')]")
    private WebElement contactButton;

    @FindBy(xpath = ".//article[@class='col-main']//following::div[@class='std']")
    private WebElement contactPage;

    @FindBy(xpath = ".//ul[@class='cms-list']//a[contains(@href,'blog')]")
    private WebElement blogButton;

    @FindBy(xpath = ".//div[@class='elementor-image']//a[contains(@href,'blog')]")
    private WebElement blogPage;

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public void waitPromotionsButtonToBeClickable() {
        waits.waitElementToBeClickableShort(promotionsButton);
    }

    public void clickPromotionsButtonWithAction(WebDriver driver) {
        clickButtonWithAction(driver, promotionsButton);
        waits.waitVisibilityOfElement(discountsPage, 3);
    }

    public void clickCancelButtonOnDialog(WebDriver driver) {
        WebElement shadowRootElement = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot", attachedWebElement);
        shadowRootElement.findElement(shadowOkButton).click();
    }

    public void waitAboutUsButtonToBeClickable(WebDriver driver) {
        waits.waitElementToBeClickableShort(aboutUsButton);
    }

    public void clickAboutUsButton(WebDriver driver) {
        aboutUsButton.click();
        waits.waitVisibilityOfElementShort(aboutUsPage);
    }

    public void waitDeliveryButtonToBeClickable(WebDriver driver) {
        waits.waitElementToBeClickableShort(deliveryButton);
    }

    public void clickDeliveryButton(WebDriver driver) {
        deliveryButton.click();
        waits.waitVisibilityOfElementShort(deliveryPage);
    }

    public void waitPaymentButtonToBeClickable(WebDriver driver) {
        waits.waitElementToBeClickableShort(paymentButton);
    }

    public void clickPaymentButton(WebDriver driver) {
        paymentButton.click();
        waits.waitVisibilityOfElementShort(paymentPage);
    }

    public void waitContactButtonToBeClickable(WebDriver driver) {
        waits.waitElementToBeClickableShort(contactButton);
    }

    public void clickContactButton(WebDriver driver) {
        contactButton.click();
        waits.waitVisibilityOfElementShort(contactPage);
    }

    public void waitBlogButtonToBeClickable(WebDriver driver) {
        waits.waitElementToBeClickableShort(blogButton);
    }

    public void clickBlogButton() {
        blogButton.click();
    }

    public boolean isStoreLogoDisplayed() {
        return storeLogo.isDisplayed();
    }

    public boolean isDiscountsPageDisplayed() {
        return discountsPage.isDisplayed();
    }

    public boolean isAboutUsPageDisplayed() {
        return aboutUsPage.isDisplayed();
    }

    public boolean isDeliveryPageDisplayed() {
        return deliveryPage.isDisplayed();
    }

    public boolean isPaymentPageDisplayed() {
        return paymentPage.isDisplayed();
    }

    public boolean isContactPageDisplayed() {
        return contactPage.isDisplayed();
    }

    public boolean isBlogPageDisplayed() {
        return blogPage.isDisplayed();
    }
}