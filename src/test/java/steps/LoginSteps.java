import com.codeborne.selenide.Configuration;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginSteps {

    private final LoginPage loginPage = new LoginPage();

    @Before
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
    }

    @Given("the user is on the SauceDemo login page")
    public void the_user_is_on_the_login_page() {
        loginPage.openPage();
    }

    @When("the user logs in with username {string} and password {string}")
    public void the_user_logs_in(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("the user should be redirected to the inventory page")
    public void the_user_should_be_redirected() {
        assertTrue(url().contains("inventory.html"));
    }

    @Then("an error message {string} should be displayed")
    public void an_error_message_should_be_displayed(String expectedMessage) {
        assertEquals(expectedMessage, loginPage.getErrorMessage());
    }
}