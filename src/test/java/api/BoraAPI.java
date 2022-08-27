package api;

import static org.testng.Assert.*;

import java.util.List;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.Experience;
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

	public static List<Experience> addExperience(String token, Experience body) {
		RestAssured.baseURI = "https://boratech.herokuapp.com";
		String endpoint = "/api/profile/experience";
		RequestSpecification request = RestAssured.given();

		request.header("Content-Type", "application/json");
		request.header("x-auth-token", token);

		request.body(body);

		Response response = request.put(endpoint);
		int actualStatusCode = response.getStatusCode();
		int expectedStatusCode = 200;

		Assert.assertEquals(actualStatusCode, expectedStatusCode);

		JsonPath jp = response.jsonPath();
		List<Experience> experiences = jp.getList("experience", Experience.class);
		return experiences;
	}

}
