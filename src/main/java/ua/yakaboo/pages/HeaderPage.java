package ua.yakaboo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage {
    @FindBy(xpath = ".//div[@class='i-logo']//img[contains(@src,'logo_book_cup.png')]")
    private WebElement logoStore;

    @FindBy(className = "grv-dialog-host")
    private WebElement attachedWebElement;

    @FindBy(css = "button.sub-dialog-btn.block_btn")
    private WebElement ShadowOkButton;

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
        PageFactory.initElements(driver, this);
    }
}