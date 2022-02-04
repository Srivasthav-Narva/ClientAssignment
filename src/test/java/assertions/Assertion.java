package assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Assertion {
	@Test
	public void test_1() {
		Response res = get("https://reqres.in/api/users?page=2");
		System.out.println(res.getStatusCode());
		
		int statusCode = res.getStatusCode();
		Assert.assertEquals(statusCode, 200);

}
	String URL = "https://reqres.in/api/users?page=2";
	@Test
void test1() {
	Response getResponse = RestAssured.get(URL);
	System.out.println(getResponse.getStatusCode());
	Assert.assertEquals(getResponse.getStatusCode(), 200);
	}
	
	@Test
	void test_2() {
Response res=(Response)given().log().all()
				
				.header("Content-Type","application/json")
				.body("{\r\n"
						+ "    \"name\": \"morpheus\",\r\n"
						+ "    \"job\": \"leader\"\r\n"
						+ "}")
				.when().post("https://reqres.in/api/users")
				.then().assertThat().log().all().statusCode(201).extract().response();
System.out.println(res);
		
	}
	
}


