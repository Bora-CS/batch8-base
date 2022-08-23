package api;

import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Login {

	public static void main(String[] args) {

		RestAssured.baseURI = "https://boratech.herokuapp.com";
		RequestSpecification request = RestAssured.given();

		request.header("content-Type", "application/json");

		HashMap<String, String> body = new HashMap<String, String>();
		body.put("email", "xu.he201@gmail.com");
		body.put("password", "123456");

		request.body(body);

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

	}

}
