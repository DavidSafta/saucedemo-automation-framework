Feature: Login functionality on SauceDemo

  Scenario: Successful login with valid credentials
    Given the user is on the SauceDemo login page
    When the user logs in with username "standard_user" and password "secret_sauce"
    Then the user should be redirected to the inventory page

  Scenario: Failed login with invalid credentials
    Given the user is on the SauceDemo login page
    When the user logs in with username "wrong_user" and password "wrong_password"
    Then an error message "Epic sadface: Username and password do not match any user in this service" should be displayed