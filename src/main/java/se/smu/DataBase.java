package se.smu;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class DataBase {
	private static DataBase DataBase;
	
	    // (Column Identifiers to table model )
		public final String[] SubjectColumnNames={"Subject", "Prof", "Year/Semester", "Day", "Start", "End"};			//과목 테이블 column에 들어갈정보 
		public final String[] TodoColumnNames={"To do", "Subject", "Deadline", "Due date", "Completed", "Importance"};			//과목 테이블 column에 들어갈정보
		public final String[] Hour = {"1","2","3","4","5","6","7","8","9","10","11","12"};
		public final String[] Minute = {"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15",
				"16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37",
				"38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59"};

		
		
		Vector<TodoElement> TodoElement = new Vector <TodoElement>();
		
		public static DataBase getDataBase() {
			if(DataBase==null){
				DataBase = new DataBase();
			}
			return DataBase;
		}
//"To do", "Subject", "Deadline", "Due date", "Completed", "Importance"		
//Todo등록Add
		public void TodoAdd(TodoElement Element){
			TodoElement.add(Element);
		}
		
	
//Todoelement 2차원 배열화 ~> datamodel에 사용을 위함 Object [] []로 행값 넘겨줌 
		
		public String[][] getTodoElement(){
			String [][] TodoMatrix= new String [TodoElement.size()][6];   //배열 선언 후 iterator를 통한 순차접근~> maxtrix채운다.
			Iterator<TodoElement> iterator=TodoElement.iterator();
			TodoElement element=new TodoElement();
			for(int i=0; iterator.hasNext();i++){
				element=iterator.next();
				TodoMatrix[i][0]=element.Todo;
				TodoMatrix[i][1]=element.Subject;
				
				SimpleDateFormat Dead_sdf=new SimpleDateFormat("yyyy-M-dd hh:mm");     //Date출력 형식 지정 
				TodoMatrix[i][2]=Dead_sdf.format(element.Deadline.getTime());						//Convert Date to String

				SimpleDateFormat Due_sdf=new SimpleDateFormat("yyyy-M-dd hh:mm"); 
				TodoMatrix[i][3]=Due_sdf.format(element.DueDate.getTime());	
				
				if (element.Completed==true) TodoMatrix[i][4]="O" ;
				else TodoMatrix[i][4]="X";
				if (element.Importance==true) TodoMatrix[i][4]="O" ;
				else TodoMatrix[i][4]="X";	
			}
			return TodoMatrix;	
		}
		
		
	
}
