package pojo;

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
		return "[User] ID: " + this._id + " Name: " + this.name;
	}

}
