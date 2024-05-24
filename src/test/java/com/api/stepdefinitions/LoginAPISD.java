package com.api.stepdefinitions;

import static com.utility.TestUtility.convertPOJOToJSON;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.hamcrest.Matchers;

import com.api.pojo.LoginRequestPOJO;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginAPISD {
	
	private LoginRequestPOJO login;
	private Header myHeader;
	private RequestSpecification request;
	private Response response;
	
	@Given("the base URL of the application is {string}")
	public void the_base_url_of_the_application_is(String url) {
		baseURI = url;
		request = given();
	}

	@Given("credentials for the FD user is {string} and {string}")
	public void credentials_for_the_fd_user_is_and(String userName, String password) {
		login = new LoginRequestPOJO("iamfd", "password");
	}

	@Given("the Header of API request is {string} and {string}")
	public void the_header_of_api_request_is_and(String key, String value) {
		request.header(key,value);
	}

	@Given("pass the fd credentials in request body in json format")
	public void pass_the_fd_credentials_in_request_body_in_json_format() {
		request.body(convertPOJOToJSON(login));
	}

	@When("I make a POST request to the endpoint {string}")
	public void i_make_a_post_request_to_the_endpoint(String endpoint) {
	    response=request.post(endpoint);
	}

	@Then("the status code should be {int}")
	public void the_status_code_should_be(Integer statuscode) {
		response.then().assertThat().statusCode(statuscode);
	}

	@Then("the response time should be {int} ms")
	public void the_response_time_should_be_ms(Integer time) {
		response.then().assertThat().time(Matchers.lessThan((long)time));
	}

	@Then("the message should contain {string}")
	public void the_message_should_contain(String data) {
	    response.then().body("message", equalTo("Success"));
	}

	@Then("the JWT token should be generated")
	public void the_jwt_token_should_be_generated() {
		response.then().body("data.token", Matchers.notNullValue());
	}

}
