package stepDefinition;

import static io.restassured.RestAssured.given;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetNegativeScenario {
	RequestSpecification request;
	Response response;
	@Given("An API for testing get method")
	public void an_api_for_testing_get_method() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		
		System.out.println("Given");
		RestAssured.baseURI="https://reqres.in";	
		request=given().header("content-type","application/json");
	}

	@When("retriving information from  API")
	public void retriving_information_from_api() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
		System.out.println("When");
		String path="api/users/23";
		response=request.get(path).then().log().all().extract().response();
	}

	@Then("validate response code")
	public void validate_response_code() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		System.out.println("Then");
		Assert.assertEquals("HTTP/1.1 404 Not Found", response.getStatusLine());
		Assert.assertEquals(404, response.getStatusCode());
	}

}
