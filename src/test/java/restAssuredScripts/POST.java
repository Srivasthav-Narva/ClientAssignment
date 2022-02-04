package restAssuredScripts;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class POST {
	@Test
	public static void test1() {
		
		Response res1= given().log().all()
				.header("Content-Type","application/json")
				.body("{\r\n"
						+ "    \"name\": \"vasthav\",\r\n"
						+ "    \"job\": \"System Engineer\"\r\n"
						+ "}")
				.when().post("https://reqres.in/api/users")
				.then().log().all().statusCode(201).extract().response();

				RestAssured.baseURI="https://reqres.in/api/users?page=2";
				System.out.println(res1.asString());
				
		}
}
