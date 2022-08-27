package pojo;

import utils.Constants;

public class User {

	public String _id;
	public String name;
	public String email;
	public String avatar;
	public String date;

	public User(String _id, String name, String email, String avatar, String date) {
		this._id = _id;
		this.name = name;
		this.email = email;
		this.avatar = avatar;
		this.date = date;
	}

	public String toString() {
		return Constants.LINE_BREAK + "\n[User]\nID: " + this._id + "\nName: " + this.name + "\n"
				+ Constants.LINE_BREAK;
	}

}
