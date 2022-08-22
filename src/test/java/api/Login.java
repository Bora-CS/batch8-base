package api;

import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Login {
	public static void main(String[] args) {

		RestAssured.baseURI = "https://boratech.herokuapp.com";
		String endpoint = "/api/auth";
		RequestSpecification request = RestAssured.given();

		request.header("Content-Type", "application/json");

		HashMap<String, String> body = new HashMap<String, String>();
		body.put("email", "annaecuador@gmail.com");
		body.put("password", "123456");

		request.body(body);

		Response response = request.post(endpoint);
		int actualStatusCode = response.getStatusCode();
		int expectedStatusCode = 200;

		if (expectedStatusCode == actualStatusCode) {
			String responseBody = response.getBody().asString();
		 	System.out.println("Response Body: "+ responseBody);
			System.out.println();
			
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Failed");
			System.out.println("expected Status Code "+ expectedStatusCode);
			System.out.println("actual Status Code " + actualStatusCode);
		}
	}
}
