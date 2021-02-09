package ua.yakaboo.pages.bdd_solution.bdd_steps_definition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import ua.yakaboo.pages.bdd_solution.bdd_pages.base_page.BasePage;
import ua.yakaboo.pages.bdd_solution.bdd_pages.pages.LoginPage;
import utils.DriverHelper;

public class LoginSteps extends BasePage{

    private LoginPage loginPage;

    public LoginSteps(WebDriver driver) {
        super(driver);
    }

    @Given("User opens Login popup")
    public void user_opens_login_popup() {
        loginPage.waitOpenLoginPopupButtonToBeClickable();
        loginPage.clickOpenLoginPopupButton();
        Assert.assertTrue("login popup is not displayed", waits.isElementVisibilityShort(loginPage.loginPopup));
    }

    @When("User enters {string} into Email field on the popup")
    public void user_enters_into_email_field_on_the_popup(String string) {
        loginPage.fillEmailField(string);
    }

    @When("User enters {string} into Password field on the popup")
    public void user_enters_into_password_field_on_the_popup(String string) {
        loginPage.fillPasswordField(string);
    }

    @When("User clicks Login button with JS on the popup")
    public void userClicksLoginButtonWithJSOnThePopup() {
        loginPage.clickLoginButtonWithJS();
    }

    @When("User clicks Login button on the popup")
    public void user_clicks_login_button_on_the_popup() {
        loginPage.loginButton.click();
    }

    @Then("User sees that first name appears in the profile")
    public void userSeesThatFirstNameAppearsInTheProfile() {
        Assert.assertEquals(loginPage.getFirstName(), "Вітаємо, Oleksandr", "User name is not correct");
    }

    @Then("User sees that Valid message appears")
    public void userSeesThatValidMessageAppears() {
        loginPage.waitLoginPopupAlertMessageToBeVisibility();
        Assert.assertEquals(loginPage.getLoginPopupAlertMessage(), "Невірний логін або пароль.", "Alert message is not correct");
    }

    @Then("User sees that {string} alert message appears")
    public void userSeesThatAlertMessageAppears(String text) {
        waits.waitAlertPresentShort();
        Assert.assertEquals(DriverHelper.getAlertText(driver),text, "Alert message is not correct");
    }
}
