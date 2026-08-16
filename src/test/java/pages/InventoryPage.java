import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class InventoryPage {

    private final SelenideElement cartIcon = $(".shopping_cart_link");

    public void addProductToCart(String productId) {
        $("[data-test='add-to-cart-" + productId + "']").click();
    }

    public void goToCart() {
        cartIcon.click();
    }
}