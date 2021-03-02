package parallel;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.AccountPage;
import pages.LoginPage;

import java.util.List;
import java.util.Map;

public class AccountPageSteps {

    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private AccountPage accountPage;

    @Given("user has already logged in to application")
    public void user_has_already_logged_in_to_application(DataTable dataTable) {
        List<Map<String, String>> creditList = dataTable.asMaps();
        String userName = creditList.get(0).get("username");
        String password = creditList.get(0).get("password");

        DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

        //return an AccountPage
        accountPage = loginPage.doLogin(userName, password);
    }

    @Given("user is on Account page")
    public void user_is_on_account_page() {
        String title = accountPage.getAccountPageTitle();
        System.out.println("Account page title is: " + title);
    }

    @Then("user gets account section")
    public void user_gets_account_section(DataTable sectionTable) {
        //those data are coming from feature file
        List<String> expectedAccountSectionList = sectionTable.asList();
        System.out.println("Expected account section list: " + expectedAccountSectionList);

        //those data are coming from Account Page
        List<String> actualAccountSectionList = accountPage.getAccountSectionList();
        System.out.println("Actual account section list: " + actualAccountSectionList);

        Assert.assertTrue(expectedAccountSectionList.containsAll(actualAccountSectionList));
    }

    @Then("account section count should be {int}")
    public void account_section_count_should_be(Integer expectedSectionCount) {
        Assert.assertTrue(accountPage.getAccountSectionCount() == expectedSectionCount);
    }
}
