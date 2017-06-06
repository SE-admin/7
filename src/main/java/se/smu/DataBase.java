package se.smu;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
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
		public boolean Hide=false;
		
		public static Vector<SubjectElement> SubjectElement = new Vector<SubjectElement>();
		public static Vector<TodoElement> TodoElement = new Vector <TodoElement>();
		public static Vector<String> initsubject = new Vector <String>();
		public static Vector<String> inittodo = new Vector <String>();
		public static HashMap<Integer, Integer> HideHashMap=new HashMap<Integer,Integer>();			// mapping'Show index' to 'Vector index'
		
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
		public TodoElement getSelectedTodoElement(int selectedRow){
			TodoElement selectedTodoElement;
			if(Hide==false)
				selectedTodoElement = TodoElement.get(selectedRow);		// find which Todo element is selected in Vector 
			else{
				int change=HideHashMap.get(selectedRow);
				selectedTodoElement = TodoElement.get(change);
			}	
			return selectedTodoElement;
		}
		
		public void TodoDelete(TodoElement Element, int selectedRow){
			if(Hide==false)
				TodoElement.remove(selectedRow);								// remove selected vector 
			else{
				int delete=HideHashMap.get(selectedRow);
				TodoElement.remove(delete);
			}
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
/*
* calculate size of matrix used in method below //count not completed item in Vector to allocate matrix
*/
			public int SizeofMatrix(){
				int size=0;
				Iterator<TodoElement> iterator=TodoElement.iterator();
				TodoElement element=new TodoElement(null, null, null, null, false, false);
				for(int i=0; iterator.hasNext();i++){
					element=iterator.next();
					if(element.Completed==false)
						size++;
				}
				return size;
			}		
/* 
* Table model for 'hide or show completed To do'
*/
				public String[][] MatrixHideShowCompleted(){
					int size=SizeofMatrix();
					String [][] TodoMatrix= new String [size][6];   // fill the matrix using iterator
					Iterator<TodoElement> iterator=TodoElement.iterator();
					TodoElement element=new TodoElement(null, null, null, null, false, false);
					int ShowIndex=0;								//Model Index of table model
					HideHashMap.clear();  					//clear hashmap for updating mapping index ~~~!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
					for(int i=0; iterator.hasNext();i++){			// i is vector index
						element=iterator.next();
						if(element.Completed==false){									// remove completed item from data model		
						HideHashMap.put(ShowIndex,i );							//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
								
						TodoMatrix[ShowIndex][0]=element.Todo;
						TodoMatrix[ShowIndex][1]=element.Subject;
						SimpleDateFormat Dead_sdf=new SimpleDateFormat("yyyy.M.dd hh:mm a");     //Data format * 'a' is Am/Pm marker
						TodoMatrix[ShowIndex][2]=Dead_sdf.format(element.Deadline.getTime());						//Convert Date to String
						SimpleDateFormat Due_sdf=new SimpleDateFormat("yyyy.M.dd hh:mm a"); 
						
						SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy.M.dd hh:mm a");	
						Calendar cal1=Calendar.getInstance();
						cal1.set(2002,10,11,11,11);														//Default
						String dateA=simpleDateFormat.format(cal1.getTime());
						String dateB=simpleDateFormat.format(element.DueDate.getTime());
						if(dateA.compareTo(dateB)==0) 											//Default value of DueDate will be shown " - " in table
							TodoMatrix[ShowIndex][3]="  -  ";	
						else
							TodoMatrix[ShowIndex][3]=Due_sdf.format(element.DueDate.getTime());	
									
						if (element.Completed==true) TodoMatrix[ShowIndex][4]="O" ;
						else TodoMatrix[ShowIndex][4]="X";
						if (element.Importance==true) TodoMatrix[ShowIndex][5]="O" ;
						else TodoMatrix[ShowIndex][5]="X";	
							ShowIndex++;
							}
							}
						return TodoMatrix;	
						}	
		
		
	
}
