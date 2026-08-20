
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertEquals;

public class CheckoutSteps {

    private final LoginPage loginPage = new LoginPage();
    private final InventoryPage inventoryPage = new InventoryPage();
    private final CartPage cartPage = new CartPage();
    private final CheckoutPage checkoutPage = new CheckoutPage();

    @Given("the user is logged in as {string}")
    public void the_user_is_logged_in_as(String username) {
        loginPage.openPage();
        loginPage.login(username, "secret_sauce");
    }

    @When("the user adds {string} to the cart")
    public void the_user_adds_product_to_cart(String productId) {
        inventoryPage.addProductToCart(productId);
    }

    @And("the user proceeds to checkout")
    public void the_user_proceeds_to_checkout() {
        inventoryPage.goToCart();
        cartPage.proceedToCheckout();
    }

    @And("the user fills in checkout information {string} {string} {string}")
    public void the_user_fills_in_checkout_information(String firstName, String lastName, String postalCode) {
        checkoutPage.fillInformation(firstName, lastName, postalCode);
    }

    @And("the user finishes the order")
    public void the_user_finishes_the_order() {
        checkoutPage.finishOrder();
    }

    @Then("the order confirmation message should be {string}")
    public void the_order_confirmation_message_should_be(String expectedMessage) {
        assertEquals(expectedMessage, checkoutPage.getConfirmationMessage());
    }
}