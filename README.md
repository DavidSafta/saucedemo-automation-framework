# SauceDemo Automation Framework

UI + API test automation framework for [SauceDemo](https://www.saucedemo.com), built with Java, Maven, Cucumber, Selenide and Docker.

## Tech stack

- Java 25
- Maven
- Cucumber 7.14.0 (BDD)
- JUnit 4.13.2
- Selenide 7.3.1 (built on Selenium WebDriver)
- Page Object Model
- REST Assured 5.4.0 (API testing)
- Docker & Docker Compose (containerized test execution with Selenium Grid)
- Allure Report (test reporting)

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

### API (`api.feature`)
- Get an existing todo item → returns 200 with title field
- Get a non-existing todo item → returns 404
- Create a new post → returns 201 with correct title

## How to run

### Locally (IntelliJ)

Run the Cucumber suite via `TestRunner.java` (in `src/test/java/runner`).

In IntelliJ: right-click `TestRunner.java` → **Run 'TestRunner'**

Expected result: **6 tests passed**, exit code 0

### With Docker

    docker compose up --build

This spins up a Chrome container (Selenium standalone) and runs the full Cucumber suite against it.

Expected result: **BUILD SUCCESS**, 6 tests passed.

## Test reporting

After running the tests, generate and view the Allure report:

    allure serve allure-results

Opens an interactive HTML report with test results, suite breakdown, and execution timeline.

## Roadmap

- [x] Project setup (Maven + dependencies)
- [x] Page Object Model
- [x] Cucumber BDD setup
- [x] Login scenarios
- [x] Checkout flow scenarios
- [x] API testing (REST Assured)
- [x] Docker containerization
- [x] Allure reporting
- [ ] CI/CD with GitHub Actions
