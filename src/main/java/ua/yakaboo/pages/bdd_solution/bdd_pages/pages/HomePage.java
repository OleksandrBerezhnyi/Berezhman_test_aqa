package ua.yakaboo.pages.bdd_solution.bdd_pages.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.yakaboo.pages.bdd_solution.bdd_pages.base_page.BasePage;

public class HomePage extends BasePage {

    @FindBy(xpath = ".//input[@class='input-text']")
    private WebElement searchField;

    @FindBy(xpath = ".//button[contains(@class,'btn-search')]")
    public WebElement searchButton;

    @FindBy(xpath = ".//div[@class='wishlist-top']")
    public WebElement wishListButton;

    @FindBy(xpath = ".//div[@class='cart-top']//button[contains(@class,'btn')]")
    public WebElement cartButton;

    @FindBy(xpath = ".//div[@class='scroller']//ancestor::div[@class='easyslideslider-id']")
    public WebElement promoSlider;

    @FindBy(xpath = ".//div[@class='side_center']//div[contains(@class,'all-categories')]")
    public WebElement allCategoriesSection;

    @FindBy(xpath = ".//div[contains(@class,'seo-block')]")
    private WebElement seoBlockSection;

    @FindBy(xpath = ".//div[contains(@class,'cms-social')]")
    public WebElement socialNetworks;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getSearchFieldPlaceholder() {
        return searchField.getAttribute("placeholder");
    }

    public boolean isSeoBlockSectionDisplayed() {
        return waits.isElementVisibilityShort(seoBlockSection);
    }
}