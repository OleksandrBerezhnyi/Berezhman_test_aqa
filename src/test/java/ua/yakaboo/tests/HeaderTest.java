package ua.yakaboo.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.yakaboo.pages.HeaderPage;
import utils.DriverHelper;

public class HeaderTest extends BaseTests {

    private HeaderPage headerPage;

    @BeforeMethod
    public void initHeaderPage() {
        headerPage = new HeaderPage(driver);
    }

    @Test
    public void checkElementsInTheHeader() {
        Assert.assertTrue(waits.isElementVisibilityShort(headerPage.storeLogo), "Logo is not displayed");

        headerPage.waitAttachedWebElementToBePresence();
        headerPage.clickCancelButtonOnDialog();

        headerPage.waitPromotionsButtonToBeClickable();
        headerPage.clickPromotionsButtonWithAction();
        Assert.assertTrue(waits.isElementVisibilityShort(headerPage.discountsPage), "Discounts page does not open");
        driver.navigate().back();

        headerPage.waitAboutUsButtonToBeClickable();
        headerPage.clickAboutUsButton();
        Assert.assertTrue(waits.isElementVisibilityShort(headerPage.aboutUsPage), "About Us page does not open");
        driver.navigate().back();

        headerPage.waitDeliveryButtonToBeClickable();
        headerPage.clickDeliveryButton();
        Assert.assertTrue(waits.isElementVisibilityShort(headerPage.deliveryPage), "Delivery page does not open");
        driver.navigate().back();

        headerPage.waitPaymentButtonToBeClickable();
        headerPage.clickPaymentButton();
        Assert.assertTrue(waits.isElementVisibilityShort(headerPage.paymentPage), "Payment page does not open");
        driver.navigate().back();

        headerPage.waitContactButtonToBeClickable();
        headerPage.clickContactButton();
        Assert.assertTrue(waits.isElementVisibilityShort(headerPage.contactPage), "Contact page does not open");
        driver.navigate().back();

        String secondTab = "Книжковий блог Yakaboo — Головна сторінка";
        headerPage.waitBlogButtonToBeClickable();
        headerPage.clickBlogButton();
        DriverHelper.switchWindowByTitle(secondTab, driver);
        Assert.assertTrue(waits.isElementVisibilityShort(headerPage.blogPage), "Blog page does not open");
        String mainTab = "Yakaboo — Інтернет-магазин книг, подарунків і дитячих товарів. Купити книги та подарунки по найкращим в Україні цінами.";
        DriverHelper.switchWindowByTitle(mainTab, driver);
    }
}