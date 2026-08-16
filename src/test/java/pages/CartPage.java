import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CartPage {

    private final SelenideElement checkoutButton = $("#checkout");

    public void proceedToCheckout() {
        checkoutButton.click();
    }
}