package ua.yakaboo.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.yakaboo.pages.HomePage;
import utils.Waits;

public class HomePageTest extends BaseTests {

    private HomePage homePage;
    private Waits waits;

    @BeforeMethod
    public void initHomePage() {
        homePage = new HomePage(driver);
        waits = new Waits(driver);
    }

    @Test
    public void homePageIsDisplayed() {
        String title = driver.getTitle();
        Assert.assertEquals(title, ("Yakaboo — Інтернет-магазин книг, подарунків і дитячих товарів. Купити книги та подарунки по найкращим в Україні цінами."));
    }

    @Test
    public void checkMainElementsOnHomePage() {
        Assert.assertEquals(homePage.getSearchFieldPlaceholder(), "Пошук товарів", "Placeholder is not correct");
        Assert.assertTrue(waits.isElementToBeClickableShort(homePage.searchButton), "Search button is not clickable");
        Assert.assertTrue(waits.isElementVisibilityShort(homePage.wishListButton), "Wishlist icon is not displayed");
        Assert.assertTrue(waits.isElementVisibilityShort(homePage.cartButton), "Cart icon is not displayed");
        Assert.assertTrue(waits.isElementVisibilityShort(homePage.promoSlider), "Promo slider is not displayed");
        Assert.assertTrue(waits.isElementVisibilityShort(homePage.allCategoriesSection), "All Categories section is not displayed");
        Assert.assertTrue(homePage.isSeoBlockSectionDisplayed(), "Seo Block section is not displayed");
        Assert.assertTrue(waits.isElementVisibilityShort(homePage.socialNetworks), "Social Networks section is not displayed");
    }
}
