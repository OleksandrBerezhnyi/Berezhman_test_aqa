package ua.yakaboo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import utils.JSActions;
import utils.Waits;

public class BasePage {
    protected WebDriver driver;
    protected JSActions jsActions;
    protected Waits waits;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        jsActions = new JSActions(driver);
        waits = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickButtonWithAction(WebElement element) {
        Actions actions = new Actions(driver);
        actions.click(element).build().perform();
    }
}
