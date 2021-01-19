package ua.yakaboo.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTests {

    @Test
    public void homePageIsDisplayed() {
        String title = driver.getTitle();
        Assert.assertEquals(title,("Yakaboo — Інтернет-магазин книг, подарунків і дитячих товарів. Купити книги та подарунки по найкращим в Україні цінами."));
    }

    @Test
    public void checkMainElementsOnHomePage() {
        WebElement searchField = driver.findElement(By.xpath(".//input[@class='input-text']"));
        Assert.assertEquals(searchField.getAttribute("placeholder"), "Пошук товарів", "Placeholder is not correct");

        WebElement searchButton = driver.findElement(By.xpath(".//button[contains(@class,'btn-search')]"));
        Assert.assertTrue(searchButton.isEnabled(), "Search button is not clickable");

        WebElement wishListButton = driver.findElement(By.xpath(".//div[@class='wishlist-top']"));
        Assert.assertTrue(wishListButton.isDisplayed(), "Wishlist icon is not displayed");

        WebElement cartButton = driver.findElement(By.xpath(".//div[@class='cart-top']//button[contains(@class,'btn')]"));
        Assert.assertTrue(cartButton.isDisplayed(), "Cart icon is not displayed");

        WebElement promoSlider = driver.findElement(By.xpath(".//div[@class='scroller']//ancestor::div[@class='easyslideslider-id']"));
        Assert.assertTrue(promoSlider.isDisplayed(), "Promo slider is not displayed");

        WebElement allCategoriesSection = driver.findElement(By.xpath(".//div[@class='side_center']//div[contains(@class,'all-categories')]"));
        Assert.assertTrue(allCategoriesSection.isDisplayed(), "All Categories section is not displayed");

        WebElement seoBlockSection = driver.findElement(By.xpath(".//div[contains(@class,'seo-block')]"));
        Assert.assertTrue(seoBlockSection.isDisplayed(), "Seo Block section is not displayed");

        WebElement socialNetworks = driver.findElement(By.xpath(".//div[contains(@class,'cms-social')]"));
        Assert.assertTrue(socialNetworks.isDisplayed(), "Social Networks section is not displayed");
    }
}
