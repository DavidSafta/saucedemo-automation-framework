Feature: Todos API on JSONPlaceholder

  Scenario: Get an existing todo item
    Given a GET request is sent to "/todos/1"
    Then the response status code should be 200
    And the response should contain a field "title"

  Scenario: Get a non-existing todo item returns 404
    Given a GET request is sent to "/todos/9999"
    Then the response status code should be 404

  Scenario: Create a new post
    Given a POST request is sent to "/posts" with title "QA Automation" and body "Learning REST Assured"
    Then the response status code should be 201
    And the response should contain a field "title" with value "QA Automation"