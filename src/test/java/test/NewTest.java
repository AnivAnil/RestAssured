package test;


import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class NewTest {
  
	@Test
	private void test() {
		RestAssured.baseURI = "https://reqres.in/api";
		RequestSpecification req = RestAssured.given();
		Response response = req.request(Method.GET, "/users/23");
		String response_body = response.getBody().asString();
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode, 404);
		System.out.println("status code ==>"+statusCode);
        System.out.println("response_body ===>"+response_body);
	}
	@Test
	private void test2() {
		RestAssured.baseURI = "https://reqres.in/api";
		RequestSpecification req = RestAssured.given();
		Response response = req.get("/users/2");
		String asString = response.getBody().asString();
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode, 200);
	}
	@Test
	private void post() {
		RestAssured.baseURI = "https://reqres.in/api";
		RequestSpecification req = RestAssured.given();
		JSONObject json = new JSONObject();
		json.put("name", "anil");
		json.put("job", "QA");
		req.body(json.toJSONString());
		Response res = req.post("/users");
		int statusCode = res.statusCode();
		System.out.println(statusCode);
		
		
		  
		

	}
}
