import io.cucumber.java.After;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class Hooks {

    @After
    public void tearDown() {
        closeWebDriver();
    }
}