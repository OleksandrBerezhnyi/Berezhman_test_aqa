package ua.yakaboo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.yakaboo.pages.base.BasePage;

public class HeaderPage extends BasePage {

    @FindBy(xpath = ".//div[@class='i-logo']//img[contains(@src,'logo_book_cup.png')]")
    public WebElement storeLogo;

    @FindBy(className = "grv-dialog-host")
    private WebElement attachedWebElement;

    private By shadowOkButton = By.cssSelector("button.sub-dialog-btn.block_btn");

    @FindBy(xpath = ".//ul[@class='cms-list']//a[contains(@href,'promotions')]")
    private WebElement promotionsButton;

    @FindBy(xpath = ".//article[@class='col-main']")
    public WebElement discountsPage;

    @FindBy(xpath = ".//ul[@class='cms-list']//a[contains(@href,'about-us')]")
    private WebElement aboutUsButton;

    @FindBy(xpath = ".//div[@class='line vertical']//preceding-sibling::div[@class='span10']")
    public WebElement aboutUsPage;

    @FindBy(xpath = ".//ul[@class='cms-list']//a[contains(@href,'delivery')]")
    private WebElement deliveryButton;

    @FindBy(xpath = ".//article[@class='col-main']//child::div[@id='cms-content']")
    public WebElement deliveryPage;

    @FindBy(xpath = ".//ul[@class='cms-list']//a[contains(@href,'payment')]")
    private WebElement paymentButton;

    @FindBy(xpath = ".//article[@class='col-main']//parent::div[contains(@class,'span10')]")
    public WebElement paymentPage;

    @FindBy(xpath = ".//ul[@class='cms-list']//a[contains(@href,'contact')]")
    private WebElement contactButton;

    @FindBy(xpath = ".//article[@class='col-main']//following::div[@class='std']")
    public WebElement contactPage;

    @FindBy(xpath = ".//ul[@class='cms-list']//a[contains(@href,'blog')]")
    private WebElement blogButton;

    @FindBy(xpath = ".//div[@class='elementor-image']//a[contains(@href,'blog')]")
    public WebElement blogPage;

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public void waitPromotionsButtonToBeClickable() {
        waits.waitElementToBeClickableShort(promotionsButton);
    }

    public void waitAttachedWebElementToBePresence() {
        waits.waitPresenceOfElementShort(By.className("grv-dialog-host"));
    }

    public void clickPromotionsButtonWithAction() {
        clickButtonWithAction(promotionsButton);
        waits.waitVisibilityOfElement(discountsPage, 3);
    }

    public void clickCancelButtonOnDialog() {
        WebElement shadowRootElement = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot", attachedWebElement);
        shadowRootElement.findElement(shadowOkButton).click();
    }

    public void waitAboutUsButtonToBeClickable() {
        waits.waitElementToBeClickableShort(aboutUsButton);
    }

    public void clickAboutUsButton() {
        aboutUsButton.click();
        waits.waitVisibilityOfElementShort(aboutUsPage);
    }

    public void waitDeliveryButtonToBeClickable() {
        waits.waitElementToBeClickableShort(deliveryButton);
    }

    public void clickDeliveryButton() {
        deliveryButton.click();
        waits.waitVisibilityOfElementShort(deliveryPage);
    }

    public void waitPaymentButtonToBeClickable() {
        waits.waitElementToBeClickableShort(paymentButton);
    }

    public void clickPaymentButton() {
        paymentButton.click();
        waits.waitVisibilityOfElementShort(paymentPage);
    }

    public void waitContactButtonToBeClickable() {
        waits.waitElementToBeClickableShort(contactButton);
    }

    public void clickContactButton() {
        contactButton.click();
        waits.waitVisibilityOfElementShort(contactPage);
    }

    public void waitBlogButtonToBeClickable() {
        waits.waitElementToBeClickableShort(blogButton);
    }

    public void clickBlogButton() {
        blogButton.click();
    }
}