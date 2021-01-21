package ua.yakaboo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.yakaboo.pages.HeaderPage;
import utils.DriverHelper;

import static utils.Waits.waitSeconds;

public class HeaderTest extends BaseTests {

    @Test
    public void checkElementsInTheHeader() throws InterruptedException {
        HeaderPage headerPage = new HeaderPage(driver);

        Assert.assertTrue(headerPage.isStoreLogoDisplayed(), "Logo is not displayed");
        waitSeconds(3);
        headerPage.clickCancelButtonOnDialog(driver);

        headerPage.clickPromotionsButtonWithAction(driver);
        Assert.assertTrue(headerPage.isDiscountsPageDisplayed(), "Discounts page does not open");
        driver.navigate().back();

        headerPage.clickAboutUsButton();
        Assert.assertTrue(headerPage.isAboutUsPageDisplayed(), "About Us page does not open");
        driver.navigate().back();

        headerPage.clickDeliveryButton();
        Assert.assertTrue(headerPage.isDeliveryPageDisplayed(), "Delivery page does not open");
        driver.navigate().back();

        headerPage.clickPaymentButton();
        Assert.assertTrue(headerPage.isPaymentPageDisplayed(), "Payment page does not open");
        driver.navigate().back();

        headerPage.clickContactButton();
        Assert.assertTrue(headerPage.isContactPageDisplayed(), "Contact page does not open");
        driver.navigate().back();

        String secondTab = "Книжковий блог Yakaboo — Головна сторінка";
        headerPage.clickBlogButton();
        DriverHelper.switchWindowByTitle(secondTab, driver);
        waitSeconds(2);
        Assert.assertTrue(headerPage.isBlogPageDisplayed(), "Blog page does not open");
        String mainTab = "Yakaboo — Інтернет-магазин книг, подарунків і дитячих товарів. Купити книги та подарунки по найкращим в Україні цінами.";
        DriverHelper.switchWindowByTitle(mainTab, driver);
    }
}