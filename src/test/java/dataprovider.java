import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class dataprovider {
@DataProvider(name="postdata")
	public Object[][] dataForPost() {
		return new Object[][] {
		{"Vasthav","Engineer"},
		{"Chinnu","Designer"},
		{"IronMan","Industrilaist"}
	};

}	

@SuppressWarnings("unchecked")
@Test(dataProvider="postdata")
public void test_post(String name,String job)
{
	JSONObject request=new JSONObject();
	request.put("name", name);
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