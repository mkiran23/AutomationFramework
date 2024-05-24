#Author: m.kiran2312@gmail.com
#Keywords Summary :
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
@api @e2e @sanity
Feature: Create Job API feature
  I want to create an inwarranty job using the Create Job API

  Scenario: Inwarranty Job creation
    Given the base URL is "http://139.59.91.96:9000/v1"
    And the Header of API request is
    |	Key 				  | Value 					  |
    |	Content-type  | application/json  |
    
    |	Authorization | randomToken			  |
    And the request body is
    | CustomerName | CustomerLastName | IMEI 				 | ProductName  | ModelNumber | DOP			|
    | Kiran				 | M								| randomNumber |	IQOO			 	| Legend			|21/5/2024|
    When I make a post request to endpoint "/job/create"
    Then job number needs to be created
    And job number should be int
    And Customer ID should be int
    And status code is 200

