package parallel;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

import java.sql.Driver;

public class LoginPageSteps {

    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private String title;

    @Given("user is on login page")
    public void user_is_on_login_page() {
        // enter the url
        DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    }

    @When("user gets the title of the page")
    public void user_gets_the_title_of_the_page() {
        // gets the title
        title = loginPage.getLoginPageTitle();
        System.out.println("Login page title is " + title);

    }

    @Then("page title should be {string}")
    public void page_title_should_be(String expectedTitleName) {
        // verify the title as expected
        Assert.assertTrue(title.contains(expectedTitleName));
    }

    @Then("forgot your password link should be displayed")
    public void forgot_your_password_link_should_be_displayed() {
        // verify the forgot password link is displayed
        Assert.assertTrue(loginPage.isForgotPwdLinkExist());
    }

    @When("user enters username {string}")
    public void user_enters_username(String usrName) {
        // enter the user name
        loginPage.enterUsername(usrName);
    }

    @When("user enters password {string}")
    public void user_enters_password(String pwd) {
        // enter the password
        loginPage.enterPassword(pwd);
    }

    @When("user clicks on Login button")
    public void user_clicks_on_login_button() {
        // click on the submit button
        loginPage.clickOnLogin();
    }
}
