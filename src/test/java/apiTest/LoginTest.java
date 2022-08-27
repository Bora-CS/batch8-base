package apiTest;

import java.util.List;
import api.BoraAPI;
import pojo.Experience;

import static org.testng.Assert.*;

public class LoginTest {

	public static void main(String[] args) {

		String token = BoraAPI.login("muradil.erkin@boratechschool.com", "Boratech");

		Experience inputExperience = new Experience("Cashier", "Ben Gong's Tea", "Annandale, VA", "2021/8/16", "", true,
				"Best place to work in Boba Industry", null);

		List<Experience> experiences = BoraAPI.addExperience(token, inputExperience);

		boolean found = false;
		for (Experience experience : experiences) {
			if (experience.company.equals(inputExperience.company)) {
				found = true;
				break;
			}
		}
		assertTrue(found);

	}

}
