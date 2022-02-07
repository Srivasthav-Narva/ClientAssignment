package stepDefinition;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.junit.Assert;
//import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataproviderStepdef {
	RequestSpecification request;
	Response response;
	
	@Given("An url for api testing")
	public void an_url_for_api_testing() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		System.out.println(" Base URL is given");
		RestAssured.baseURI="https://reqres.in";
		request=given().header("content-type","application/json");
	}

	@When("enter the path of the given method {string}")
	public void enter_the_path_of_the_given_method(String path) {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
		System.out.println(" path of get method {string}");
		   
		   response=request.get(path).then().log().all().extract().response();
	}

	@Then("Validate response code")
	public void validate_response_code() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		System.out.println(" Validate status code");
		int statusCode= response.getStatusCode();
		String statusLine =response.getStatusLine();
		 System.out.println("status Line is "+statusLine);
		  System.out.println("status code is "+statusCode);
		  Assert.assertEquals(200, statusCode);
		  Assert.assertEquals("HTTP/1.1 200 OK", statusLine);
	}

}
