package com.api.stepdefinitions;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.List;
import java.util.Map;

import com.api.pojo.CustomerPOJO;
import com.utility.TestUtility;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateJobSD {
	
	private RequestSpecification request;
	private Response response;
	
	@Given("the base URL is {string}")
	public void the_base_url_of_the_application_is(String url) {
		baseURI = url;
		request = given();
		
	}
	
	@Given("the Header of API request is")
	public void the_header_of_api_request_is(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		
		List<Map<String,String>> dataMapList = dataTable.asMaps();
		for(Map<String,String> data : dataMapList) {
			String key=data.get("Key");
			String value = data.get("Value");
			request.header(key,value);
			
		}
	}

	@Given("the request body is")
	public void the_request_body_is(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		CustomerPOJO customer=null;
		String dataJSON="";
		List<Map<String,String>> dataMapList = dataTable.asMaps();
		for(Map<String,String> data:dataMapList) {
			String customerName = data.get("CustomerName");
			String customerLastName = data.get("CustomerLastName");
			String IMEI = data.get("IMEI");
			String productName = data.get("ProductName");
			String modelNumber = data.get("ModelNumber");
			String DOP = data.get("DOP");
			customer = new CustomerPOJO(customerName,customerLastName,IMEI,productName,modelNumber,DOP);
			
		}
		dataJSON=TestUtility.convertPOJOToJSON(customer);
		request.body(dataJSON);
	    
	}

	@When("I make a post request to endpoint {string}")
	public void i_make_a_post_request_to_endpoint(String endpoint) {
	    // Write code here that turns the phrase above into concrete actions
	    response = request.post(endpoint);
	}

	@Then("job number needs to be created")
	public void job_number_needs_to_be_created() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("job number should be int")
	public void job_number_should_be_int() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("Customer ID should be int")
	public void customer_id_should_be_int() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("status code is {int}")
	public void status_code_is(Integer statuscode) {
	    
	    
	}

}