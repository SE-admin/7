package se.smu;

public class SubjectElement {
	public String name;
	public String prof;
	public String selectday;
	public int starthour;
	public String startminute;
	public int endhour;
	public String endminute;
	public int year;
	public String semester;
	
	
	public SubjectElement(String name, String prof, String selectDay, int startHour, String startMinute, int endHour,
			String endMinute, int year, String semester) { 
		this.name = name; // this.name=>public class Subject�� name
		this.prof = prof;
		this.selectday = selectDay;
		this.starthour = startHour;
		this.startminute = startMinute;
		this.endhour = endHour;
		this.endminute = endMinute;
		this.year = year;
		this.semester = semester;
	}
	
}
