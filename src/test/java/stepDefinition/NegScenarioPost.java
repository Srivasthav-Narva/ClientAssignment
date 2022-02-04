package stepDefinition;

import static io.restassured.RestAssured.given;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class NegScenarioPost {
	RequestSpecification request;
	Response response;
	@Given("API for testing for negative scenario")
	public void api_for_testing_for_negative_scenario() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		System.out.println("Given");
		RestAssured.baseURI="https://reqres.in";	
		request=given().header("content-type","application/json").
				body("{\r\n"
						+ "    \"email\": \"sydney@fife\"\r\n"
						+ "}");
	
		
	}

	@When("posted with incorrect information in the url")
	public void posted_with_incorrect_information_in_the_url() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
		System.out.println("When");
		String path="api/register";
		response=request.post(path).then().log().all().extract().response();
	}

	@Then("validate negative status code for post")
	public void validate_negative_status_code_for_post() {
	    // Write code here that turns the phrase above into concrete actions
	  //  throw new io.cucumber.java.PendingException();
		System.out.println("Then");
		Assert.assertEquals(response.getStatusCode(), 400);
	}
}
