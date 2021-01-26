package ua.yakaboo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.yakaboo.pages.HeaderPage;
import utils.DriverHelper;

public class HeaderTest extends BaseTests {

    @Test
    public void checkElementsInTheHeader() throws InterruptedException {
        HeaderPage headerPage = new HeaderPage(driver);

        Assert.assertTrue(headerPage.isStoreLogoDisplayed(), "Logo is not displayed");
        headerPage.clickCancelButtonOnDialog(driver);

        headerPage.waitPromotionsButtonToBeClickable(driver);
        headerPage.clickPromotionsButtonWithAction(driver);
        Assert.assertTrue(headerPage.isDiscountsPageDisplayed(), "Discounts page does not open");
        driver.navigate().back();

        headerPage.waitAboutUsButtonToBeClickable(driver);
        headerPage.clickAboutUsButton(driver);
        Assert.assertTrue(headerPage.isAboutUsPageDisplayed(), "About Us page does not open");
        driver.navigate().back();

        headerPage.waitDeliveryButtonToBeClickable(driver);
        headerPage.clickDeliveryButton(driver);
        Assert.assertTrue(headerPage.isDeliveryPageDisplayed(), "Delivery page does not open");
        driver.navigate().back();

        headerPage.waitPaymentButtonToBeClickable(driver);
        headerPage.clickPaymentButton(driver);
        Assert.assertTrue(headerPage.isPaymentPageDisplayed(), "Payment page does not open");
        driver.navigate().back();

        headerPage.waitContactButtonToBeClickable(driver);
        headerPage.clickContactButton(driver);
        Assert.assertTrue(headerPage.isContactPageDisplayed(), "Contact page does not open");
        driver.navigate().back();

        String secondTab = "Книжковий блог Yakaboo — Головна сторінка";
        headerPage.waitBlogButtonToBeClickable(driver);
        headerPage.clickBlogButton();
        DriverHelper.switchWindowByTitle(secondTab, driver);

        Assert.assertTrue(headerPage.isBlogPageDisplayed(), "Blog page does not open");
        String mainTab = "Yakaboo — Інтернет-магазин книг, подарунків і дитячих товарів. Купити книги та подарунки по найкращим в Україні цінами.";
        DriverHelper.switchWindowByTitle(mainTab, driver);
    }
}