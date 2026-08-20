# SauceDemo Automation Framework

UI + API test automation framework for [SauceDemo](https://www.saucedemo.com), built with Java, Maven, Cucumber, Selenide and Docker.

## Tech stack

- Java 25
- Maven
- Cucumber 7.14.0 (BDD)
- JUnit 4.13.2
- Selenide 7.3.1 (built on Selenium WebDriver)
- Page Object Model

## Project structure

    src/test/java
    ├── pages/    → Page Object classes (LoginPage, ...)
    ├── steps/    → Cucumber Step Definitions (LoginSteps, ...)
    ├── hooks/    → Cucumber Hooks (browser cleanup, etc.)
    └── runner/   → Cucumber TestRunner

    src/test/resources/features/  → Gherkin .feature files

## Scenarios implemented

### Login (`login.feature`)
- Successful login with valid credentials → redirects to inventory page
- Failed login with invalid credentials → shows error message
  
### Checkout (`checkout.feature`)
- Successful checkout with one product in cart → order confirmation displayed
## How to run

Run the Cucumber suite via:

com.davidsafta... (or default package) → TestRunner.java


In IntelliJ: right-click `TestRunner.java` → **Run 'TestRunner'**

Expected result: **2 tests passed**, exit code 0

## Roadmap

- [x] Project setup (Maven + dependencies)
- [x] Page Object Model
- [x] Cucumber BDD setup
- [x] Login scenarios
- [x] Checkout flow scenarios
- [ ] API testing (REST Assured)
- [ ] Docker containerization
- [ ] Allure reporting
- [ ] CI/CD with GitHub Actions
