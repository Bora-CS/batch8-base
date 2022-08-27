package apiTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.BoraAPI;
import pojo.Experience;
import pojo.Profile;
import pojo.ProfileWithUserId;

import static org.testng.Assert.*;

public class AddExperienceTest {

	@Test
	public static void mainTest() {

		// Login
		String token = BoraAPI.login("muradil.erkin@boratechschool.com", "Boratech");
		// Get Current User Profile
		Profile profile = BoraAPI.getCurrentUserProfile(token);
		int originalNumberOfExperieces = profile.experience.size();

		// Add Experience
		Experience inputExperience = new Experience("Cashier", "Ben Gong's Tea", "Annandale, VA", "2021/8/16", "", true,
				"Best place to work in Boba Industry", null);
		ProfileWithUserId profileAfterAdd = BoraAPI.addExperience_V2(token, inputExperience);
		int numberOfExperiecesAfterAdd = profileAfterAdd.experience.size();
		assertEquals(numberOfExperiecesAfterAdd, originalNumberOfExperieces + 1);

		// Delete Experience
		String idToDelete = "";
		for (Experience experience : profileAfterAdd.experience) {
			if (experience.company.equals(inputExperience.company)) {
				idToDelete = experience._id;
				break;
			}
		}
		Assert.assertFalse(idToDelete.isEmpty());
		ProfileWithUserId profileAfterDelete = BoraAPI.deleteExperience(token, idToDelete);
		int numberOfExperiecesAfterDelete = profileAfterDelete.experience.size();
		assertEquals(numberOfExperiecesAfterDelete, numberOfExperiecesAfterAdd - 1);

	}

}
