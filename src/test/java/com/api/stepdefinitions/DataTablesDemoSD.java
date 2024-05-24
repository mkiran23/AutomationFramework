package com.api.stepdefinitions;

import java.util.List;
import java.util.Map;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DataTablesDemoSD {
	
	@Given("I have following data")
	public void i_have_following_data(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.

		List<Map<String,String>> dataMapList = dataTable.asMaps();
		for(Map<String,String> data : dataMapList) {
			String name = data.get("Name");
			String age = data.get("Age");
			String gender = data.get("Gender");
			System.out.println(name+"\t"+age+"\t"+gender);
		}
	}

	@When("I perform action")
	public void i_perform_action() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("I should see the results")
	public void i_should_see_the_results() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}


}
