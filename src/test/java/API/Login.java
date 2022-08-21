package API;

import java.util.HashMap;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Login {

	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://boratech.herokuapp.com/";
		String endPoint = "/api/auth";
		RequestSpecification request = RestAssured.given();
		
		request.header("Content-Type","application/json");
		
		HashMap<String,String> body = new HashMap<String,String>();
		body.put("email", "lixiasun2000@gmail.com");
		body.put("password", "Lsun1688");
		
		request.body(body);
		
		Response response = request.post(endPoint);
		int actualStatusCode = response.getStatusCode();
		int expectStatusCode = 200;
		
		if (expectStatusCode == actualStatusCode) {
			String responseBody = response.getBody().asString();
			System.out.println(responseBody);
			
			System.out.println("Test passed");
		}else {
			System.out.println("Test failed");
			System.out.println("Expect Status Code: " + expectStatusCode );
			System.out.println("Actual Status Code: " + actualStatusCode );
		}
	}

}
