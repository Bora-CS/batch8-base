package api;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.LoginRequestBody;

public class Login {

	public static void main(String[] args) {
		
		RestAssured.baseURI="http://boratech.herokuapp.com";
		String endpoint ="/api/auth";

		RequestSpecification request = RestAssured.given();
		
		request.header("Content-Type", "application/json");
		
//		Map<String, String> body= new HashedMap<String, String>();
//		body.put("email", "yrong07@gmail.com");
//		body.put("password", "Welcomeboratech");
		
		LoginRequestBody body = new LoginRequestBody("yrong07@gmail.com","Welcomeboratech");
		
		request.body(body);
		
		Response response=request.post(endpoint);
		int actualStatusCode = response.getStatusCode();
		int expectedStatusCode= 200;
		
		if(expectedStatusCode==actualStatusCode) {
//			String responseBody=response.getBody().asString();
			LoginResponseBody responseBody=response.getBody().as(LoginResponseBody.class);
			String token=responseBody.getToken();
			System.out.println("Response Body: "+token);
			
			
//			String tokenString =responseBody.substring(9, responseBody.length()-1);
//			System.out.println(tokenString);
			
			
			System.out.println("Test Passed");
		}else {
			System.out.println("Test failed");
			System.out.println("Expected Status Code: "+ expectedStatusCode);
			System.out.println("Actual Status Code: "+actualStatusCode);
		}
	}

}
