package apiTest;

import api.BoraAPI;

public class LoginTest {

	public static void main(String[] args) {

		String token = BoraAPI.login("muradil.erkin@boratechschool.com", "Boratech1");
		System.out.println("Token: " + token);

	}

}
