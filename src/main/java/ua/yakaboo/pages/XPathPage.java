package ua.yakaboo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class XPathPage {

    @FindBy(xpath = ".//div[@class='elementor-image']//a[contains(@href,'blog')]")
    private WebElement blogPage;

    @FindBy(xpath = ".//label[starts-with(text(),\"Пароль\")]")
    private WebElement passwordLabel;

    @FindBy(xpath = ".//div[@class='line vertical']//preceding-sibling::div[@class='span10']")
    private WebElement aboutUsPage;

    @FindBy(xpath = ".//article[@class='col-main']//child::div[@id='cms-content']")
    private WebElement deliveryPage;

    @FindBy(xpath = ".//article[@class='col-main']//parent::div[contains(@class,'span10')]")
    private WebElement paymentPage;

    @FindBy(xpath = ".//article[@class='col-main']//following::div[@class='std']")
    private WebElement contactPage;

    @FindBy(xpath = ".//div[@class='scroller']//ancestor::div[@class='easyslideslider-id']")
    private WebElement promoSlider;



    


}
