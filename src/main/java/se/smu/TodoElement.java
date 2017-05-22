package se.smu;

import java.util.Calendar;

public class TodoElement {

	//"To do", "Subject", "Deadline", "Due date", "Completed", "Importance"
	public String Todo;
	public String Subject;
	public Calendar Deadline;
	public Calendar DueDate;
	public boolean Completed = false;
	public boolean Importance = false;


	public void setTodoElement(String Todo, String Subject, Calendar Deadline, 
			Calendar DueDate, boolean Completed, boolean Importance){
		this.Todo=Todo;
		this.Subject=Subject;
		this.Deadline=Deadline;
		this.DueDate=DueDate;
		this.Completed=Completed;
		this.Importance=Importance;
	}
	
}
