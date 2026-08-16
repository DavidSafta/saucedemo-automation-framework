import com.codeborne.selenide.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginTest {

    private LoginPage loginPage;

    @Before
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        loginPage = new LoginPage();
    }

    @Test
    public void validLoginShouldRedirectToInventoryPage() {
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");

        assertTrue(url().contains("inventory.html"));
    }

    @Test
    public void invalidLoginShouldShowErrorMessage() {
        loginPage.openPage();
        loginPage.login("wrong_user", "wrong_password");

        assertEquals(
                "Epic sadface: Username and password do not match any user in this service",
                loginPage.getErrorMessage()
        );
    }

    @After
    public void tearDown() {
        closeWebDriver();
    }
}