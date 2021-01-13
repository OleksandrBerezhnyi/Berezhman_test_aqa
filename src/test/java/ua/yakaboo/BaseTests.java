package ua.yakaboo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BaseTests extends WebDriverSettings {

    @Test
    public void homePageIsDisplayed() {
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Yakaboo — Інтернет-магазин книг, подарунків і дитячих товарів. Купити книги та подарунки по найкращим в Україні цінами."));
    }

    @Test
    public void signInWithValidUser() throws InterruptedException {
        driver.findElement(By.id("customer_menu")).click();
        Thread.sleep(2000);
        WebElement loginPopup = driver.findElement(By.id("modal-login"));
        Assert.assertTrue(loginPopup.isDisplayed(), "login popup is not displayed");

        driver.findElement(By.id("email")).sendKeys("oleksandr.berezhnyi@gravit.io");
        driver.findElement(By.id("pass")).sendKeys("123456");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath(".//div[@class='modal-footer']//button[contains(@id,'login')]")));
        Thread.sleep(2000);

        String firstName = driver.findElement(By.xpath(".//span[@data-customer='firstname']")).getText();
        Assert.assertEquals(firstName, "Вітаємо, Oleksandr");
    }

    @Test
    public void checkMainElementsOnHomePage() {
        WebElement searchField = driver.findElement(By.xpath(".//input[@class='input-text']"));
        Assert.assertTrue(searchField.isDisplayed(), "Search field is not displayed");

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

    @Test
    public void checkElementsInTheHeader() throws InterruptedException {
        WebElement logoSrc = driver.findElement(By.xpath(".//div[@class='i-logo']//img[contains(@src,'logo_book_cup.png')]"));
        Assert.assertTrue(logoSrc.isDisplayed(), "Logo is not displayed");

        WebElement attachedWebElement = driver.findElement(By.className("grv-dialog-host"));
        WebElement shadowRootElement = (WebElement)((JavascriptExecutor)driver).executeScript("return arguments[0].shadowRoot", attachedWebElement);
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
        switchWindowByTitle(secondTab, driver);
        Thread.sleep(2000);
        WebElement blogPage = driver.findElement(By.xpath(".//div[@class='elementor-image']//a[contains(@href,'blog')]"));
        Assert.assertTrue(blogPage.isDisplayed(), "Blog page does not open");
        switchWindowByTitle("Yakaboo — Інтернет-магазин книг, подарунків і дитячих товарів. Купити книги та подарунки по найкращим в Україні цінами.", driver);
    }

    public void switchWindowByTitle(String title, WebDriver driver) {
        //will keep current window to switch back
        String currentWindow = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            if (driver.switchTo().window(winHandle).getTitle().contains(title)) {
                //This is the one you're looking for
                break;
            } else {
                driver.switchTo().window(currentWindow);
            }
        }
    }
}

