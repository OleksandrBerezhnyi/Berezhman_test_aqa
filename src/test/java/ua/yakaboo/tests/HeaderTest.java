package ua.yakaboo.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.yakaboo.pages.HeaderPage;
import utils.DriverHelper;
import utils.Waits;

public class HeaderTest extends BaseTests {

    private HeaderPage headerPage;
    private Waits waits;

    @BeforeMethod
    public void initHeaderPage() {
        headerPage = new HeaderPage(driver);
        waits = new Waits(driver);
    }

    @Test
    public void checkElementsInTheHeader() {
        Assert.assertTrue(waits.isElementVisibilityShort(headerPage.storeLogo), "Logo is not displayed");

        headerPage.waitAttachedWebElementToBePresence();
        headerPage.clickCancelButtonOnDialog(driver);

        headerPage.waitPromotionsButtonToBeClickable();
        headerPage.clickPromotionsButtonWithAction(driver);
        Assert.assertTrue(waits.isElementVisibilityShort(headerPage.discountsPage), "Discounts page does not open");
        driver.navigate().back();

        headerPage.waitAboutUsButtonToBeClickable(driver);
        headerPage.clickAboutUsButton(driver);
        Assert.assertTrue(waits.isElementVisibilityShort(headerPage.aboutUsPage), "About Us page does not open");
        driver.navigate().back();

        headerPage.waitDeliveryButtonToBeClickable(driver);
        headerPage.clickDeliveryButton(driver);
        Assert.assertTrue(waits.isElementVisibilityShort(headerPage.deliveryPage), "Delivery page does not open");
        driver.navigate().back();

        headerPage.waitPaymentButtonToBeClickable(driver);
        headerPage.clickPaymentButton(driver);
        Assert.assertTrue(waits.isElementVisibilityShort(headerPage.paymentPage), "Payment page does not open");
        driver.navigate().back();

        headerPage.waitContactButtonToBeClickable(driver);
        headerPage.clickContactButton(driver);
        Assert.assertTrue(waits.isElementVisibilityShort(headerPage.contactPage), "Contact page does not open");
        driver.navigate().back();

        String secondTab = "Книжковий блог Yakaboo — Головна сторінка";
        headerPage.waitBlogButtonToBeClickable(driver);
        headerPage.clickBlogButton();
        DriverHelper.switchWindowByTitle(secondTab, driver);
        Assert.assertTrue(waits.isElementVisibilityShort(headerPage.blogPage), "Blog page does not open");
        String mainTab = "Yakaboo — Інтернет-магазин книг, подарунків і дитячих товарів. Купити книги та подарунки по найкращим в Україні цінами.";
        DriverHelper.switchWindowByTitle(mainTab, driver);
    }
}