package apiTest;

import org.testng.Assert;

import api.BoraAPI;
import pojo.Profile;
import pojo.User;

public class AuthenticationTest {

	public static void main(String[] args) {

		String token = BoraAPI.login("muradil.erkin@boratechschool.com", "Boratech");
		User user = BoraAPI.getCurrentUser(token);
		Profile profile = BoraAPI.getCurrentUserProfile(token);

		System.out.println(user);
		System.out.println(profile);
		Assert.assertEquals(user.name, "Muradil Erkin");
		Assert.assertEquals(profile.user.name, "Muradil Erkin");

	}

}
