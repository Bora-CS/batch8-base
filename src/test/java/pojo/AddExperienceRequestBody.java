package pojo;

public class AddExperienceRequestBody {

	public String title;
	public String company;
	public String location;
	public String from;
	public String to;
	public boolean current;
	public String description;

	public AddExperienceRequestBody(String title, String company, String location, String from, String to,
			boolean current, String description) {
		this.title = title;
		this.company = company;
		this.location = location;
		this.from = from;
		this.to = to;
		this.current = current;
		this.description = description;
	}
}
