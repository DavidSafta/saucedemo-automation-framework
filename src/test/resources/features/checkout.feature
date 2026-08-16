Feature: Checkout flow on SauceDemo

  Scenario: Successful checkout with one product in the cart
    Given the user is logged in as "standard_user"
    When the user adds "sauce-labs-backpack" to the cart
    And the user proceeds to checkout
    And the user fills in checkout information "John" "Doe" "12345"
    And the user finishes the order
    Then the order confirmation message should be "Thank you for your order!"