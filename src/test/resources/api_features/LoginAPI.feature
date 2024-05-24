#Author: Kiran
#Keywords Summary : API Tests for Pheonix application
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@api @e2e @regression
Feature: Login API feature for Pheonix application
  I want to check whether users of pheonix application are able to login and a JWT token is generated for the user

  @positive
  Scenario: FD login via login API
    Given the base URL of the application is "http://139.59.91.96:9000/v1"
    And credentials for the FD user is "iamfd" and "password"
    And the Header of API request is "Content-type" and "application/json"
    And pass the fd credentials in request body in json format
    When I make a POST request to the endpoint "/login"
    Then the status code should be 200
    And the response time should be 2000 ms
    And the message should contain "Success"
    And the JWT token should be generated

