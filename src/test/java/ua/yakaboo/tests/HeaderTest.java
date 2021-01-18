package ua.yakaboo.tests;

import Utils.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HeaderTest extends BaseTests {

    @Test
    public void checkElementsInTheHeader() throws InterruptedException {
        WebElement logoSrc = driver.findElement(By.xpath(".//div[@class='i-logo']//img[contains(@src,'logo_book_cup.png')]"));
        Assert.assertTrue(logoSrc.isDisplayed(), "Logo is not displayed");
        Thread.sleep(2000);
        WebElement attachedWebElement = driver.findElement(By.className("grv-dialog-host"));
        WebElement shadowRootElement = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot", attachedWebElement);
        shadowRootElement.findElement(By.cssSelector("button.sub-dialog-btn.block_btn")).click();

        WebElement promotionsButton = driver.findElement(By.xpath(".//ul[@class='cms-list']//a[contains(@href,'promotions')]"));
        Actions actions = new Actions(driver);
        actions.click(promotionsButton).build().perform();
        Thread.sleep(2000);
        WebElement discountsPage = driver.findElement(By.xpath(".//article[@class='col-main']"));
        Assert.assertTrue(discountsPage.isDisplayed(), "Discounts page does not open");
        driver.navigate().back();

        driver.findElement(By.xpath(".//ul[@class='cms-list']//a[contains(@href,'about-us')]")).click();
        Thread.sleep(2000);
        WebElement aboutUsPage = driver.findElement(By.xpath(".//article[@class='col-main']"));
        Assert.assertTrue(aboutUsPage.isDisplayed(), "About Us page does not open");
        driver.navigate().back();

        driver.findElement(By.xpath(".//ul[@class='cms-list']//a[contains(@href,'delivery')]")).click();
        Thread.sleep(2000);
        WebElement deliveryPage = driver.findElement(By.xpath(".//article[@class='col-main']"));
        Assert.assertTrue(deliveryPage.isDisplayed(), "Delivery page does not open");
        driver.navigate().back();

        driver.findElement(By.xpath(".//ul[@class='cms-list']//a[contains(@href,'payment')]")).click();
        Thread.sleep(2000);
        WebElement paymentPage = driver.findElement(By.xpath(".//article[@class='col-main']"));
        Assert.assertTrue(paymentPage.isDisplayed(), "Payment page does not open");
        driver.navigate().back();

        driver.findElement(By.xpath(".//ul[@class='cms-list']//a[contains(@href,'contact')]")).click();
        Thread.sleep(2000);
        WebElement contactPage = driver.findElement(By.xpath(".//article[@class='col-main']"));
        Assert.assertTrue(contactPage.isDisplayed(), "Contact page does not open");
        driver.navigate().back();

        String secondTab = "Книжковий блог Yakaboo — Головна сторінка";
        driver.findElement(By.xpath(".//ul[@class='cms-list']//a[contains(@href,'blog')]")).click();
        DriverHelper.switchWindowByTitle(secondTab, driver);
        Thread.sleep(2000);
        WebElement blogPage = driver.findElement(By.xpath(".//div[@class='elementor-image']//a[contains(@href,'blog')]"));
        Assert.assertTrue(blogPage.isDisplayed(), "Blog page does not open");
        DriverHelper.switchWindowByTitle("Yakaboo — Інтернет-магазин книг, подарунків і дитячих товарів. Купити книги та подарунки по найкращим в Україні цінами.", driver);
    }
}
