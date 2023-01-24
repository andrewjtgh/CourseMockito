package course;

public class Course {
	private INameList attendees;

	public Course(INameList namelist) {
		this.attendees = namelist;
	}

	public void addAttendee(String name) {
		attendees.addName(name);
	}

	public String getAttendee(int i) {
		return attendees.getName(i);
	}

	public void clearAttendeesList() {
		attendees.clear();
	}
}
