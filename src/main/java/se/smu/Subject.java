package se.smu;

public class Subject {
	
	//"name", "prof", "selectday", "starthour", "startminute", "endhour", endminute", "year", "semester"
	public String name;
	public String prof;
	public String selectday;
	public int starthour;
	public String startminute;
	public int endhour;
	public String endminute;
	public int year;
	public String semester;
	
	/*
	 * 과목별 정보를 받아옴
	 */
	public Subject(String name, String prof, String selectDay, int startHour, String startMinute, int endHour,
			String endMinute, int year, String semester) { 
		this.name = name; // this.name=>public class Subject의 name
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
