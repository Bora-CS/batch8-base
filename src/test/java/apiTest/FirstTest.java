package apiTest;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FirstTest {

	String token;

	@Test(priority = -1)
	public void login_user_test() {

		// base URL + endPoint
		// Method -> Get, Post, Put, Patch, Delete
		// Header -> Content-Type - Application/json
		// body -> Json Format

		RestAssured.baseURI = "https://boratech.herokuapp.com";
		RequestSpecification request = RestAssured.given();

		// header
		request.header("content-Type", "application/json");

		// body
		HashMap<String, String> body = new HashMap<String, String>();
		body.put("email", "xu.he201@gmail.com");
		body.put("password", "123456");

		request.body(body);

		// response
		Response response = request.post("/api/auth");
		int actualStatusCode = response.getStatusCode();
		int expectedStatusCode = 200;

		if (expectedStatusCode == actualStatusCode) {
			String responseBody = response.getBody().asString();
			System.out.println("Response body :" + responseBody);
			System.out.println("test passed");

		} else {
			System.out.println("Test Failed");
			System.out.println("Expected Status Code :" + expectedStatusCode);
			System.out.println("Actual Status Code :" + actualStatusCode);
		}
		token = response.jsonPath().get("token");

	}

	@Test
	public void addExperience() {

		RestAssured.baseURI = "https://boratech.herokuapp.com";
		RequestSpecification request = RestAssured.given();

		// header
		request.header("content-Type", "application/json");
		request.header("x-auth-token", token);

		// body
		HashMap<String, String> body = new HashMap<String, String>();

		body.put("title", "Cashier");
		body.put("company", "Vivi's Tea");
		body.put("location", "Annadale,VA");
		body.put("from", "2021/8/16");
		body.put("to", "");
		body.put("current", "true");
		body.put("description", "Best place to work in USA");

		request.body(body);

		Response response = request.put("/api/profile/experience");
		System.out.println(response.getBody().asPrettyString());
		
	}
}
