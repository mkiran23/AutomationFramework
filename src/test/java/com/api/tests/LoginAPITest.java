package com.api.tests;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.pojo.LoginRequestPOJO;
import static com.constants.Env.*;
import static com.utility.TestUtility.*;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;




/* Gpt: 
 * Test Data Creation
 * Code rEVIEW
 * cLEANING cODE
 * Documentation
 * 
 */

@Listeners(com.listeners.APITestListeners.class)
public class LoginAPITest {

	private LoginRequestPOJO login;
	
	@BeforeMethod(description = "Setting up the Login POJO for the Payload and reading the BaseURL for the config dfile",alwaysRun = true)
	public void setup() {
		login = new LoginRequestPOJO("iamfd", "password");

		baseURI = readConfigFile(QA, "BASE_URL"); // The Base URL of the application
	}
	
	
	@Test(description = "Verify if the FD is able to login into the app via API, validate the status 200, response body as the value Success and Response time is less than 900MS",
			groups = {"api","sanity", "smoke","e2e","regression"} , retryAnalyzer = com.listeners.MyRetryAnalyzer.class
			)
	public void verifyloginAPI() {

		given()
			.header("Content-type", "application/json")
		.and()
 	 		.body(convertPOJOToJSON(login))
 	    .when()
 	    	.log().all()
 	 		.post("login")
 	    .then() //assertion!!! test is happening
 	    	.log().all()
 	 		.assertThat()
 	 		.statusCode(200)
 	    .and()
 	 		.time(lessThan(1000L)) // Unit Testing Library!!! RA addon ?? 500ms
 	    .and()
 	 		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonSchemas/LoginResponseJSONSchema.json"))
 	 		.and()
 	 		.body("message", equalTo("Success"));

	}
	
	/*
	 * Status code 200
	 * Response time ?? Performance of your backend!!SQL
	 * Key Value
	 * JSON SCHEMA Validation
	 */

}
