package ua.yakaboo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.yakaboo.pages.HomePage;

public class HomePageTest extends BaseTests {

    @Test
    public void homePageIsDisplayed() {
        String title = driver.getTitle();
        Assert.assertEquals(title, ("Yakaboo — Інтернет-магазин книг, подарунків і дитячих товарів. Купити книги та подарунки по найкращим в Україні цінами."));
    }

    @Test
    public void checkMainElementsOnHomePage() {
        HomePage homePage = new HomePage(driver);

        Assert.assertEquals(homePage.getSearchFieldPlaceholder(), "Пошук товарів", "Placeholder is not correct");
        Assert.assertTrue(homePage.isSearchButtonEnabled(), "Search button is not clickable");
        Assert.assertTrue(homePage.isWishListButtonDisplayed(), "Wishlist icon is not displayed");
        Assert.assertTrue(homePage.isCartButtonDisplayed(), "Cart icon is not displayed");
        Assert.assertTrue(homePage.isPromoSliderDisplayed(), "Promo slider is not displayed");
        Assert.assertTrue(homePage.isAllCategoriesSectionDisplayed(), "All Categories section is not displayed");
        Assert.assertTrue(homePage.isSeoBlockSectionDisplayed(), "Seo Block section is not displayed");
        Assert.assertTrue(homePage.isSocialNetworksDisplayed(), "Social Networks section is not displayed");
    }
}
