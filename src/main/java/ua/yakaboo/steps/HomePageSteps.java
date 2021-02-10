package ua.yakaboo.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ua.yakaboo.pages.HomePage;
import utils.Waits;
import utils.driver.DriverProvider;

public class HomePageSteps {

    private WebDriver driver;
    private Waits waits;

    public HomePageSteps(DriverProvider driverProvider) {
        this.driver = driverProvider.getDriver();
        waits = new Waits(driver);
    }

    @Given("Check that Home page id displayed")
    public void check_that_home_page_id_displayed() {
        String title = driver.getTitle();
        Assert.assertEquals(title, ("Yakaboo — Інтернет-магазин книг, подарунків і дитячих товарів. Купити книги та подарунки по найкращим в Україні цінами."));
    }

    @When("User checks {string} search field placeholder")
    public void user_checks_search_field_placeholder(String string) {
        var homePage = new HomePage(driver);
        Assert.assertEquals(homePage.getSearchFieldPlaceholder(), string, "Placeholder is not correct");
    }

    @When("User checks that Search button is clickable")
    public void user_checks_that_search_button_is_clickable() {
        var homePage = new HomePage(driver);
        Assert.assertTrue(waits.isElementToBeClickableShort(homePage.searchButton), "Search button is not clickable");
    }

    @When("User sees that Wish list icon is displayed")
    public void user_sees_that_wish_list_icon_is_displayed() {
        var homePage = new HomePage(driver);
        Assert.assertTrue(waits.isElementVisibilityShort(homePage.wishListButton), "Wishlist icon is not displayed");
    }

    @When("User sees that Cart icon is displayed")
    public void user_sees_that_cart_icon_is_displayed() {
        var homePage = new HomePage(driver);
        Assert.assertTrue(waits.isElementVisibilityShort(homePage.cartButton), "Cart icon is not displayed");
    }

    @When("User sees that Promo slider is displayed")
    public void user_sees_that_promo_slider_is_displayed() {
        var homePage = new HomePage(driver);
        Assert.assertTrue(waits.isElementVisibilityShort(homePage.promoSlider), "Promo slider is not displayed");
    }

    @When("User sees that All Categories section is displayed")
    public void user_sees_that_all_categories_section_is_displayed() {
        var homePage = new HomePage(driver);
        Assert.assertTrue(waits.isElementVisibilityShort(homePage.allCategoriesSection), "All Categories section is not displayed");
    }

    @When("User sees that Seo Block section is displayed")
    public void user_sees_that_seo_block_section_is_displayed() {
        var homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isSeoBlockSectionDisplayed(), "Seo Block section is not displayed");
    }

    @Then("Social Networks section is displayed")
    public void social_networks_section_is_displayed() {
        var homePage = new HomePage(driver);
        Assert.assertTrue(waits.isElementVisibilityShort(homePage.socialNetworks), "Social Networks section is not displayed");
    }
}
