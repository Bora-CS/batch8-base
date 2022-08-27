package apiTest;

import org.testng.Assert;

import api.BoraAPI;
import pojo.User;

public class AuthenticationTest {

	public static void main(String[] args) {

		String token = BoraAPI.login("muradil.erkin@boratechschool.com", "Boratech");

		User user = BoraAPI.getCurrentUser(token);

		System.out.println(user);

		Assert.assertEquals(user.name, "Muradil Erkin");

	}

}
