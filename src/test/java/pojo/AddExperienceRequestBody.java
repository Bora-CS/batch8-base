package pojo;

public class AddExperienceRequestBody {
	public String jobTitle;
	public String company;
	public String location;
	public String fromDate;
	public String toDate;
	public boolean current;
	public String description;
	public String _id;

	public AddExperienceRequestBody(String jobTitle, String company, String location, String fromDate, String toDate,
			boolean current, String description, String _id) {
		this.jobTitle = jobTitle;
		this.company = company;
		this.location = location;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.current = current;
		this.description = description;
		this._id = _id;

	}

}
