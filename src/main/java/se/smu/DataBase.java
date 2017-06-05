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
		public final String[] Am = {"AM", "PM"};    //Subject영역에서 사용
		public final String[] Semester = {"1", "2"};  //Subject영역에서 사용

		
		public static Vector<SubjectElement> SubjectElement = new Vector<SubjectElement>();
		public static Vector<TodoElement> TodoElement = new Vector <TodoElement>();
		public static Vector<String> initsubject = new Vector <String>();
		public static Vector<String> inittodo = new Vector <String>();
		public static DataBase getDataBase() {
			if(DataBase==null){
				DataBase = new DataBase();
			}
			return DataBase;
		}
	

// "name","prof", "selectday", "starthour", "startminute", "endhour", endminute", "year", "semester"
//subject등록 add
		public void SubjectAdd(SubjectElement Element){
			SubjectElement.add(Element);
			
		}
	
		public void SubjectChange(SubjectElement Element, int selectedRow){
			SubjectElement.set(selectedRow, Element);								
		}
		
		public SubjectElement getSelectedSubject(int selectedRow){
			SubjectElement selectedSubject = SubjectElement.get(selectedRow);		
			return selectedSubject;
		}
		
		public void SubjectDelete(SubjectElement Element, int selectedRow){
			SubjectElement.remove(selectedRow);								
		}
		
		public String[][] MatrixSubject(){  
			initsubject.removeAllElements();
			String subjectmatrix[][] = new String[SubjectElement.size()][6];    //이중 배열 선언: int[][] table = new int[5][10];
			for(int i = 0 ; i < SubjectElement.size() ; i++){
				//	(Vector에서) Object elementAt(int index): index 위치의 객체를 반환한다.
				SubjectElement in = SubjectElement.elementAt(i); //index = i인 위치의 객체 반환
				this.initsubject.add(subjectmatrix[i][0] = in.name);
				this.initsubject.add(subjectmatrix[i][1] = in.prof);
				this.initsubject.add(subjectmatrix[i][2] = in.year + "/" + in.semester);
				this.initsubject.add(subjectmatrix[i][3] = in.selectday);
				this.initsubject.add(subjectmatrix[i][4] = in.starthour + " : " + in.startminute);
				this.initsubject.add(subjectmatrix[i][5] = in.endhour + " : " + in.endminute); 
			}	
			return null;
		}
		
		public String[] getSubjectName(){
			String SubjectName[] = new String[SubjectElement.size()];
			for(int i=0; i<SubjectElement.size(); i++){
				SubjectElement s = SubjectElement.elementAt(i);
				SubjectName[i] = s.name;
			}
			return SubjectName;
		}
		

		
	
		
//"To do", "Subject", "Deadline", "Due date", "Completed", "Importance"		
		public void TodoAdd(TodoElement Element){
			TodoElement.add(Element);
		}
		
		public void TodoChange(TodoElement Element, int selectedRow){
			TodoElement.set(selectedRow, Element);							// replace specific vector from selected row	
		}

// selected todo아이템에 대한 return todoitelement (화면에 기존 정보 뿌리기위함)
// selected row에 대한 index필요 ~> ind exx로 vector 찾아 리턴
		public TodoElement getSelectedTodoElement(int selectedRow){
			TodoElement selectedTodoElement = TodoElement.get(selectedRow);		// find which Todoitem is selected in Vector 
			return selectedTodoElement;
		}
		
		public void TodoDelete(TodoElement Element, int selectedRow){
			TodoElement.remove(selectedRow);								// remove selected vector 
		}
//Todoelement 2차원 배열화 ~> datamodel에 사용을 위함 * Object [] [] 행값 넘겨줌 
		
		public String[][] MatrixTodoElement(){
			String [][] TodoMatrix= new String [TodoElement.size()][6];   //배열 선언 후 iterator를 통한 순차접근~> maxtrix채운다.
			Iterator<TodoElement> iterator=TodoElement.iterator();
			for(int i=0; i<TodoElement.size();i++){
				TodoElement element = TodoElement.elementAt(i);
				this.inittodo.add(TodoMatrix[i][0]=element.Todo);
				this.inittodo.add(TodoMatrix[i][1]=element.Subject);
				SimpleDateFormat Dead_sdf=new SimpleDateFormat("yyyy.M.dd hh:mm a"); //Date출력 형식 지정 * 'a' is Am/pm marker
				this.inittodo.add(TodoMatrix[i][2]=Dead_sdf.format(element.Deadline.getTime()));						//Convert Date to String
				SimpleDateFormat Due_sdf=new SimpleDateFormat("yyyy.M.dd hh:mm a"); 
				this.inittodo.add(TodoMatrix[i][3]=Due_sdf.format(element.DueDate.getTime()));	
				if (element.Completed == true) this.inittodo.add(TodoMatrix[i][4]="O") ;
				else this.inittodo.add(TodoMatrix[i][4]="X");
				if (element.Importance== true) this.inittodo.add(TodoMatrix[i][5]="O") ;
				else this.inittodo.add(TodoMatrix[i][5]="X");	
			}
			return null;	
		}	
		
		
		
	
}
