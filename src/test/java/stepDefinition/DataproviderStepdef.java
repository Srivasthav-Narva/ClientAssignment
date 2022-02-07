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
	
	String uri="https://reqres.in";
	//Response response;
	
	RequestSpecification request;
	Response response;
	JSONObject req=new JSONObject();
	
	@DataProvider(name="DataForPost")
	public Object [][] dataForPost()	
	{
		
				Object[][] data=new Object[2][2];
				data[0][0]="Vastav";
				data[0][1]="Designer";
				
				data[1][0]="Chinnu";
				data[0][1]="Engineer";
			
				return data;
				
				
			
	}
	@Given("An Api for testing post method")
	public void an_api_for_testing_post_method() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		
		
		RestAssured.baseURI="https://reqres.in";	
		request=given().header("content-type","application/json").
				body(req.toJSONString());
		
	}
		
	



	@SuppressWarnings("unchecked")
	@Test(dataProvider="DataForPost")
	@When("posted the correct information with dataprovider {string} and {string}")
	public void posted_the_correct_information_with_dataprovider_and(String name, String job) {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingEx
		//String path="api/users";
		req.put("name", name);
		req.put("job", job);
		System.out.println("When");
		String path="api/users";
		response=request.post(path).then().log().all().extract().response();
		
		
		
	}
	@Test(dataProvider="DataForPost")
	@Then("validate the response code {string} and {string}")
	public void validate_the_response_code_and(String name, String job) {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
		System.out.println("Then");
		System.out.println("response status code : "+response.getStatusCode()); 
		System.out.println("response status line : "+response.getStatusLine());
//		Assert.assertEquals("HTTP/1.1 201 Created", response.getStatusLine());
		Assert.assertEquals(201, response.getStatusCode());
		
	}

}
