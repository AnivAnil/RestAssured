package test;

import java.net.http.HttpRequest;
import java.nio.file.Path;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class readjsondata {
  @Test
  private void readjasondata() {
	RestAssured.baseURI="https://reqres.in/api/";
	RequestSpecification req = RestAssured.given();
	Response res = req.get("/users/2");
	JsonPath jsonPath = res.jsonPath();
	Object object = jsonPath.get("email");
	System.out.println(object);

}
}
