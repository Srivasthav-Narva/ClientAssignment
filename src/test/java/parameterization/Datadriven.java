package parameterization;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
//import io.restassured.response.Response;


public class Datadriven {
	
	@DataProvider(name="DataForPost")
	public Object [][] dataForPost()	
	{
		return new Object[][] {
				{"Vasthav","Engineer"},
				{"Chinnu","Designer"},
				{"IronMan","Industrialist"},
				{"Dr.Strange","Magician"},
				{"SteveRogers","Captain"}
		};
		
		
	}

	@SuppressWarnings("unchecked")
	@Test(dataProvider="DataForPost")
	public void test_post(String name,String job)
	{

		
		JSONObject request=new JSONObject();
		request.put("name",name);
		request.put("job", job);
		RestAssured.baseURI="https://reqres.in/";
		given().
		header("content-Type","application/json").
		body(request.toJSONString()).
		when().
		post("/api/users").
		then().
		statusCode(201).
		log().all();
		
		
	}
	
}
