package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.LoginRequestBody;
import pojo.LoginResponseBody;

public class Login {

	public static void main(String[] args) {

		RestAssured.baseURI = "https://boratech.herokuapp.com";
		String endpoint = "/api/auth";
		RequestSpecification request = RestAssured.given();

		request.header("Content-Type", "application/json");

		LoginRequestBody body = new LoginRequestBody("muradil.erkin@boratechschool.com", "Boratech");
		request.body(body);

		Response response = request.post(endpoint);
		int actualStatusCode = response.getStatusCode();
		int expectedStatusCode = 200;

		if (expectedStatusCode == actualStatusCode) {
			LoginResponseBody responseBody = response.getBody().as(LoginResponseBody.class);
			String token = responseBody.getToken();
			System.out.println("Token: " + token);
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Failed");
			System.out.println("Expected Status Code: " + expectedStatusCode);
			System.out.println("Actual Status Code: " + actualStatusCode);
		}

	}

}
