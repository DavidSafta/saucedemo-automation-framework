import com.codeborne.selenide.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static org.junit.Assert.assertEquals;

public class FirstSmokeTest {

    @Before
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
    }

    @Test
    public void pageTitleShouldBeCorrect() {
        open("https://www.saucedemo.com");
        assertEquals("Swag Labs", title());
    }

    @After
    public void tearDown() {
        com.codeborne.selenide.Selenide.closeWebDriver();
    }
}