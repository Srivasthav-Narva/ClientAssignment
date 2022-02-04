package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
import org.junit.Assert;

public class Stepdef {
	RequestSpecification request;
	Response response;
	
	@Given("An API for Post method")
	public void an_api_for_post_method() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		System.out.println("Given");
		RestAssured.baseURI="https://reqres.in";	
		request=given().header("content-type","application/json").
				body("{\r\n"
						+ "    \"name\": \"ABC\",\r\n"
						+ "    \"job\": \"leader\"\r\n"
						+ "}");
		
	}
	

	@When("posted with correct information")
	public void posted_with_correct_information() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
		System.out.println("When");
		String path="api/users";
		response=request.post(path).then().log().all().extract().response();
		
	}

	@Then("validate status code received for post")
	public void validate_status_code_received_for_post() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		System.out.println("Then");
		System.out.println("response status code : "+response.getStatusCode()); 
		System.out.println("response status line : "+response.getStatusLine());
		Assert.assertEquals("HTTP/1.1 201 Created", response.getStatusLine());
		Assert.assertEquals(201, response.getStatusCode());
	}
	@Given("An Api for testing get method")
	public void an_api_for_testing_get_method() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Given");
		RestAssured.baseURI="https://reqres.in";	
		request=given().header("content-type","application/json");
	    //throw new io.cucumber.java.PendingException();
	}

	@When("Retrieve the information from the api")
	public void retrieve_the_information_from_the_api() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
		System.out.println("When");
		String path="api/users?page=2";
		response=request.get(path).then().log().all().extract().response();

	}

	@Then("validate status  code for get method")
	public void validate_status_code_for_get_method() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
		System.out.println("Then");
		Assert.assertEquals(200, response.getStatusCode());
	}
	@Given("API for testing put method")
	public void api_for_testing_put_method() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		System.out.println("Given");
		RestAssured.baseURI="https://reqres.in";	
		request=given().header("content-type","application/json");
	}

	@When("Updated correct information")
	public void updated_correct_information() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		System.out.println("When");
		String path="api/users/2";
		response=request.put(path).then().log().all().extract().response();
	}

	@Then("validate response code for put method")
	public void validate_response_code_for_put_method() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
		System.out.println("Then");
		System.out.println("response status code : "+response.getStatusCode()); 
		System.out.println("response status line : "+response.getStatusLine());
//		Assert.assertEquals("HTTP/1.1 200 Created", response.getStatusLine());
		Assert.assertEquals(200, response.getStatusCode());
	}
	@Given("An API for testing patch method")
	public void an_api_for_testing_patch_method() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		System.out.println("Given");
		RestAssured.baseURI="https://reqres.in";	
		request=given().header("content-type","application/json").
				body("{\r\n"
						+ "    \"name\": \"morpheus\",\r\n"
						+ "    \"job\": \"zion resident\"\r\n"
						+ "}");
	}

	@When("updates with correct information")
	public void updates_with_correct_information() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		String path="api/users/2";
		response=request.patch(path).then().log().all().extract().response();
	}

	@Then("validate positive response code for patch method")
	public void validate_positive_response_code_for_patch_method() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
		System.out.println("Then");
		Assert.assertEquals(200, response.getStatusCode());
	}
	@Given("An API for testing delete method")
	public void an_api_for_testing_delete_method() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		System.out.println("Given");
		RestAssured.baseURI="https://reqres.in";
		request=given().header("content-type","application/json");
	}

	@When("Delete the resource from api")
	public void delete_the_resource_from_api() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
		System.out.println("When");
		String path="api/users/2";
		response=request.delete(path).then().log().all().extract().response();
	}

	@Then("validate the response code for delete")
	public void validate_the_response_code_for_delete() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		System.out.println("Then");
		//Assert.assertEquals(204, response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 204);
	}
	@Given("API for testing Post method")
	public void api_for_testing_post_method() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		System.out.println("Given");
		RestAssured.baseURI="https://reqres.in";	
		request=given().header("content-type","application/json").
				body("{\r\n"
						+ "    \"email\": \"eve.holt@reqres.in\",\r\n"
						+ "    \"password\": \"pistol\"\r\n"
						+ "}");
	}

	@When("posted with correct information in the url")
	public void posted_with_correct_information_in_the_url() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
		System.out.println("When");
		String path="api/register";
		response=request.post(path).then().log().all().extract().response();
	}

	@Then("validate status for post")
	public void validate_status_for_post() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
		System.out.println("Then");
		Assert.assertEquals(200, response.getStatusCode());
	}
	

}
