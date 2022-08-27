package api;

import static org.testng.Assert.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.LoginRequestBody;
import pojo.LoginResponseBody;

public class BoraAPI {

	public static String login(String username, String password) {
		RestAssured.baseURI = "https://boratech.herokuapp.com";
		String endpoint = "/api/auth";
		RequestSpecification request = RestAssured.given();

		request.header("Content-Type", "application/json");

		LoginRequestBody body = new LoginRequestBody(username, password);
		request.body(body);

		Response response = request.post(endpoint);
		int actualStatusCode = response.getStatusCode();
		int expectedStatusCode = 200;

		assertEquals(actualStatusCode, expectedStatusCode);

		LoginResponseBody responseBody = response.getBody().as(LoginResponseBody.class);
		String token = responseBody.getToken();
		assertNotNull(token);
		assertTrue(token != "");
		return token;
	}

}
