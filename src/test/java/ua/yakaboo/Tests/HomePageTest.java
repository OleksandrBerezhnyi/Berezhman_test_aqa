package ua.yakaboo.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ua.yakaboo.Tests.BaseTests;

public class HomePageTest extends BaseTests {

    @Test
    public void homePageIsDisplayed() {
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Yakaboo — Інтернет-магазин книг, подарунків і дитячих товарів. Купити книги та подарунки по найкращим в Україні цінами."));
    }

    @Test
    public void checkMainElementsOnHomePage() {
        WebElement searchField = driver.findElement(By.xpath(".//input[@class='input-text']"));
        Assert.assertEquals(searchField.getAttribute("placeholder"), "Пошук товарів", "Placeholder is not correct");

        WebElement searchButton = driver.findElement(By.id("search_mini_form_submit"));
        Assert.assertTrue(searchButton.isEnabled(), "Search button is not clickable");

        WebElement wishList = driver.findElement(By.linkText("Бажані"));
        Assert.assertTrue(wishList.isDisplayed(), "Wishlist icon is not displayed");

        WebElement cartItem = driver.findElement(By.xpath(".//div[@id='cart-top-items']//button[contains(@class,'btn')]"));
        Assert.assertTrue(cartItem.isDisplayed(), "Cart icon is not displayed");

        WebElement promoSlider = driver.findElement(By.className("scroller"));
        Assert.assertTrue(promoSlider.isDisplayed(), "Promo slider is not displayed");

        WebElement allCategories = driver.findElement(By.xpath(".//div[@class='side_center']//div[contains(@class,'all-categories')]"));
        Assert.assertTrue(allCategories.isDisplayed(), "All Categories section is not displayed");

        WebElement seoBlock = driver.findElement(By.className("cms-seo-block"));
        Assert.assertTrue(seoBlock.isDisplayed(), "Seo Block section is not displayed");

        WebElement socialNetworks = driver.findElement(By.xpath(".//div[@class='span2 cms-social']"));
        Assert.assertTrue(socialNetworks.isDisplayed(), "Social Networks section is not displayed");
    }
}
