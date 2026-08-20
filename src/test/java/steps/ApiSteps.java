import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ApiSteps {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    private Response response;
    private int lastStatusCode;

    @Given("a GET request is sent to {string}")
    public void a_get_request_is_sent_to(String endpoint) {
        response = given()
                .when()
                .get(BASE_URL + endpoint);
        lastStatusCode = response.statusCode();
    }

    @Given("a POST request is sent to {string} with title {string} and body {string}")
    public void a_post_request_is_sent_to(String endpoint, String title, String body) {
        response = given()
                .header("Content-Type", "application/json")
                .body("{ \"title\": \"" + title + "\", \"body\": \"" + body + "\", \"userId\": 1 }")
                .when()
                .post(BASE_URL + endpoint);
        lastStatusCode = response.statusCode();
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(int expectedStatusCode) {
        assertEquals(expectedStatusCode, lastStatusCode);
    }

    @And("the response should contain a field {string}")
    public void the_response_should_contain_a_field(String fieldPath) {
        assertNotNull(response.jsonPath().get(fieldPath));
    }

    @And("the response should contain a field {string} with value {string}")
    public void the_response_should_contain_a_field_with_value(String fieldPath, String expectedValue) {
        assertEquals(expectedValue, response.jsonPath().getString(fieldPath));
    }
}