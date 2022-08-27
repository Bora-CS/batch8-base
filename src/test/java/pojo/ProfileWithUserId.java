package pojo;

import java.util.ArrayList;

import utils.Constants;

public class ProfileWithUserId {

	public Social social;
	public ArrayList<String> skills;
	public String _id;
	public String user;
	public int __v;
	public String bio;
	public String company;
	public String githubusername;
	public String location;
	public String status;
	public String website;
	public String date;
	public ArrayList<Education> education;
	public ArrayList<Experience> experience;

	public String toString() {
		return Constants.LINE_BREAK + "\n[Profile]\nID: " + this._id + "\nUser ID: " + this.user
				+ "\nNumber of experiences: " + this.experience.size() + "\nNumber of educations: "
				+ this.education.size() + "\n" + Constants.LINE_BREAK;
	}

}
