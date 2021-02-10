package ua.yakaboo.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ua.yakaboo.pages.HeaderPage;
import utils.DriverHelper;
import utils.Waits;
import utils.driver.DriverProvider;

public class HeaderSteps {

    private WebDriver driver;
    private Waits waits;

    public HeaderSteps(DriverProvider driverProvider) {
        this.driver = driverProvider.getDriver();
        waits = new Waits(driver);
    }

    @Given("Check that Header section is displayed")
    public void check_that_header_section_is_displayed() {
        var headerPage = new HeaderPage(driver);
        Assert.assertTrue(waits.isElementVisibilityShort(headerPage.storeLogo), "Logo is not displayed");
    }

    @When("User clicks Cancel button on the dialog")
    public void userClicksCancelButtonOnTheDialog() {
        var headerPage = new HeaderPage(driver);
        headerPage.waitAttachedWebElementToBePresence();
        headerPage.clickCancelButtonOnDialog();
    }

    @When("User clicks Promotions button in the section")
    public void user_clicks_promotions_button_in_the_section() {
        var headerPage = new HeaderPage(driver);
        headerPage.waitPromotionsButtonToBeClickable();
        headerPage.clickPromotionsButtonWithAction();
    }

    @Then("User sees that Discounts page opens")
    public void user_sees_that_discounts_page_opens() {
        var headerPage = new HeaderPage(driver);
        Assert.assertTrue(waits.isElementVisibilityShort(headerPage.discountsPage), "Discounts page does not open");
        driver.navigate().back();
    }

    @When("User clicks About Us button in the section")
    public void user_clicks_about_us_button_in_the_section() {
        var headerPage = new HeaderPage(driver);
        headerPage.waitAboutUsButtonToBeClickable();
        headerPage.clickAboutUsButton();
    }

    @Then("User sees that About Us page opens")
    public void user_sees_that_about_us_page_opens() {
        var headerPage = new HeaderPage(driver);
        Assert.assertTrue(waits.isElementVisibilityShort(headerPage.aboutUsPage), "About Us page does not open");
        driver.navigate().back();
    }

    @When("User clicks Delivery button in the section")
    public void user_clicks_delivery_button_in_the_section() {
        var headerPage = new HeaderPage(driver);
        headerPage.waitDeliveryButtonToBeClickable();
        headerPage.clickDeliveryButton();
    }

    @Then("User sees that Delivery page opens")
    public void user_sees_that_delivery_page_opens() {
        var headerPage = new HeaderPage(driver);
        Assert.assertTrue(waits.isElementVisibilityShort(headerPage.deliveryPage), "Delivery page does not open");
        driver.navigate().back();
    }

    @When("User clicks Payment button in the section")
    public void user_clicks_payment_button_in_the_section() {
        var headerPage = new HeaderPage(driver);
        headerPage.waitPaymentButtonToBeClickable();
        headerPage.clickPaymentButton();
    }

    @Then("User sees that Payment page opens")
    public void user_sees_that_payment_page_opens() {
        var headerPage = new HeaderPage(driver);
        Assert.assertTrue(waits.isElementVisibilityShort(headerPage.paymentPage), "Payment page does not open");
        driver.navigate().back();
    }

    @When("User clicks Contact button in the section")
    public void user_clicks_contact_button_in_the_section() {
        var headerPage = new HeaderPage(driver);
        headerPage.waitContactButtonToBeClickable();
        headerPage.clickContactButton();
    }

    @Then("User sees that Contact page opens")
    public void user_sees_that_contact_page_opens() {
        var headerPage = new HeaderPage(driver);
        Assert.assertTrue(waits.isElementVisibilityShort(headerPage.contactPage), "Contact page does not open");
        driver.navigate().back();
    }

    @When("User clicks Blog button in the section")
    public void user_clicks_blog_button_in_the_section() {
        var headerPage = new HeaderPage(driver);
        headerPage.waitBlogButtonToBeClickable();
        headerPage.clickBlogButton();
    }

    @Then("User redirects to Blog page")
    public void user_redirects_to_blog_page() {
        String secondTab = "Книжковий блог Yakaboo — Головна сторінка";
        var headerPage = new HeaderPage(driver);
        DriverHelper.switchWindowByTitle(secondTab, driver);
        Assert.assertTrue(waits.isElementVisibilityShort(headerPage.blogPage), "Blog page does not open");
        String mainTab = "Yakaboo — Інтернет-магазин книг, подарунків і дитячих товарів. Купити книги та подарунки по найкращим в Україні цінами.";
        DriverHelper.switchWindowByTitle(mainTab, driver);
    }
}
