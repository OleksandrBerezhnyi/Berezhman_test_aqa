package ua.yakaboo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    @FindBy(xpath = ".//input[@class='input-text']")
    private WebElement searchField;

    @FindBy(xpath = ".//button[contains(@class,'btn-search')]")
    private WebElement searchButton;

    @FindBy(xpath = ".//div[@class='wishlist-top']")
    private WebElement wishListButton;

    @FindBy(xpath = ".//div[@class='cart-top']//button[contains(@class,'btn')]")
    private WebElement cartButton;

    @FindBy(xpath = ".//div[@class='scroller']//ancestor::div[@class='easyslideslider-id']")
    private WebElement promoSlider;

    @FindBy(xpath = ".//div[@class='side_center']//div[contains(@class,'all-categories')]")
    private WebElement allCategoriesSection;

    @FindBy(xpath = ".//div[contains(@class,'seo-block')]")
    private WebElement seoBlockSection;

    @FindBy(xpath = ".//div[contains(@class,'cms-social')]")
    private WebElement socialNetworks;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
