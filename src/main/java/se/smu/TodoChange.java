package se.smu;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import com.toedter.calendar.JCalendar;

public class TodoChange extends JFrame {

	private JPanel contentPane;
	private TodoChange thisTodoChange = this;
	private TodoElement TodoElement;
    DataBase DataBase = new DataBase();
	public TodoChange(TodoManage todomanage_parm,int selectedRow) {
		
		String loadedAmPm;																//variable for loading Am/Pm on each button
		DataBase = DataBase.getDataBase();												//import DB
		TodoElement selectedTodoElement = DataBase.getSelectedTodoElement(selectedRow);	//load selected Todo element on each field
		setBounds(100, 100, 751, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Compeleted");
		label.setBounds(387, 146, 110, 18);
		contentPane.add(label);
		
		JLabel lblTodo = new JLabel("To do");
		lblTodo.setBounds(32, 26, 89, 18);
		contentPane.add(lblTodo);
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setBounds(32, 66, 89, 18);
		contentPane.add(lblSubject);
		
		JLabel lblDeadline = new JLabel("Deadline");
		lblDeadline.setBounds(32, 106, 79, 16);
		contentPane.add(lblDeadline);
		
		JLabel lblimportance = new JLabel("Importance");
		lblimportance.setBounds(387, 106, 110, 18);
		contentPane.add(lblimportance);
		
		JLabel lblDueDate = new JLabel("Due Date");
		lblDueDate.setBounds(32, 143, 89, 16);
		contentPane.add(lblDueDate);
		
		
		JButton btnAmPmDueDate = new JButton();
		if(selectedTodoElement.DueDate.get(Calendar.AM_PM ) == 0) loadedAmPm ="AM";			//load AM or PM
		else 									loadedAmPm ="PM";
		btnAmPmDueDate.setText(loadedAmPm);
		btnAmPmDueDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((btnAmPmDueDate.getText()).equals("AM"))
					btnAmPmDueDate.setText("PM");					//AM to PM button text 바꾸기 
				else
					btnAmPmDueDate.setText("AM");
			}
		});
		btnAmPmDueDate.setBounds(132, 143, 59, 25);
		contentPane.add(btnAmPmDueDate);
		
	
		JButton btnAmPmDeadline = new JButton();
		if(selectedTodoElement.Deadline.get(Calendar.AM_PM) == 0) loadedAmPm ="AM";		//load AM or PM
		else  									 loadedAmPm ="PM";
		btnAmPmDeadline.setText(loadedAmPm);
		btnAmPmDeadline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((btnAmPmDeadline.getText()).equals("AM"))
					btnAmPmDeadline.setText("PM");					//AM to PM button text 바꾸기 
				else
					btnAmPmDeadline.setText("AM");
			}
		});
		btnAmPmDeadline.setBounds(132, 106, 59, 25);
		contentPane.add(btnAmPmDeadline);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				todomanage_parm.setVisible(true);
				thisTodoChange.dispose();
			}
		});
		btnBack.setBounds(573, 75, 105, 45);
		contentPane.add(btnBack);
		
		JTextField txtTodo = new JTextField(selectedTodoElement.Todo);
		txtTodo.setColumns(10);
		txtTodo.setBounds(135, 20, 418, 24);
		contentPane.add(txtTodo);
		
//TODO subject연동 
		JComboBox cbSubject = new JComboBox(DataBase.getSubjectName());
		cbSubject.setBounds(135, 59, 200, 24);
		contentPane.add(cbSubject);
	
		
		JCheckBox checkImportance = new JCheckBox("");
		checkImportance.setSelected(selectedTodoElement.Importance); 									//load Importance
		checkImportance.setBounds(486, 106, 29, 23);
		contentPane.add(checkImportance);
		
		
		JCheckBox checkCompleted = new JCheckBox("");
		checkCompleted.setSelected(selectedTodoElement.Completed); 									// load Completed
		checkCompleted.setHorizontalAlignment(SwingConstants.LEFT);
		checkCompleted.setBounds(486, 146, 29, 23);
		contentPane.add(checkCompleted);
		
		JComboBox cbDeadlineHour = new JComboBox(DataBase.Hour);
		cbDeadlineHour.setSelectedIndex(selectedTodoElement.Deadline.get(Calendar.HOUR)-1);							// Load hour indx접근이기떄문에 0부터..~> -1해준다.
		cbDeadlineHour.setMaximumRowCount(12);
		cbDeadlineHour.setBounds(194, 106, 59, 24);
		contentPane.add(cbDeadlineHour);
		
		JComboBox cbDeadlineMinute = new JComboBox(DataBase.Minute);
		cbDeadlineMinute.setSelectedIndex(selectedTodoElement.Deadline.get(Calendar.MINUTE));					  //
		cbDeadlineMinute.setMaximumRowCount(59);
		cbDeadlineMinute.setBounds(258, 106, 59, 24);
		contentPane.add(cbDeadlineMinute);

		JCalendar JCalendarDueDate = new JCalendar();
//** Calendar Default **///MIN,HOUR	
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy.M.dd hh:mm a");	
		Calendar cal1=Calendar.getInstance();
		cal1.set(2002,10,11,11,11);														//Default
		String dateA=simpleDateFormat.format(cal1.getTime());
		String dateB=simpleDateFormat.format(selectedTodoElement.DueDate.getTime());
		if(dateA.compareTo(dateB)==0){
			Calendar c = Calendar.getInstance();								
			 JCalendarDueDate.setCalendar(c); 
			}
		else
			JCalendarDueDate.setCalendar(selectedTodoElement.DueDate);			// load Calendar data
//
		JCalendarDueDate.setWeekOfYearVisible(false);
		JCalendarDueDate.setNullDateButtonText("");
		JCalendarDueDate.setDecorationBordersVisible(true);
		JCalendarDueDate.setBounds(387, 183, 325, 229);
		contentPane.add(JCalendarDueDate);
		
		JComboBox cbDueDateHour = new JComboBox(DataBase.Hour);
		if(dateA.compareTo(dateB)==0){
			Calendar c = Calendar.getInstance(); 
			cbDueDateHour.setSelectedIndex(c.get(Calendar.HOUR));   }																
		else
			cbDueDateHour.setSelectedIndex(selectedTodoElement.DueDate.get(Calendar.HOUR)-1);	
		cbDueDateHour.setMaximumRowCount(12);
		cbDueDateHour.setBounds(194, 143, 59, 24);
		contentPane.add(cbDueDateHour);
		
		JComboBox cbDueDateMinute = new JComboBox(DataBase.Minute);
		if(dateA.compareTo(dateB)==0){
			Calendar c = Calendar.getInstance();
			cbDueDateMinute.setSelectedIndex(c.get(Calendar.MINUTE));   }
																							//
		else
			cbDueDateMinute.setSelectedIndex(selectedTodoElement.DueDate.get(Calendar.MINUTE));					//
		cbDueDateMinute.setMaximumRowCount(12);
		cbDueDateMinute.setBounds(258, 143, 59, 24);
		contentPane.add(cbDueDateMinute);
		
		JCalendar JCalendarDeadline = new JCalendar();
		JCalendarDeadline.setCalendar(selectedTodoElement.Deadline);					//load Calendar data
		JCalendarDeadline.setWeekOfYearVisible(false);
		JCalendarDeadline.setNullDateButtonText("");
		JCalendarDeadline.setDecorationBordersVisible(true);
		JCalendarDeadline.setBounds(17, 183, 325, 229);
		contentPane.add(JCalendarDeadline);
		
		

		
//TODO 
		JButton btnChange = new JButton("Change");
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Todo=txtTodo.getText();
				String Subject=(String) cbSubject.getSelectedItem();
				boolean Completed=checkCompleted.isSelected();
			    boolean Importance=checkImportance.isSelected();
			    
	        	Calendar CalendarDeadline=Calendar.getInstance();					//날짜,시간정보 저장을 위한 캘린더 생성 
				CalendarDeadline.setTime(JCalendarDeadline.getDate());				//getDate()메소드 사용, 입력정보 저장 
				Calendar CalendarDueDate=Calendar.getInstance();
				CalendarDueDate.setTime(JCalendarDueDate.getDate());
	// HOUR, MINUTE은 콤보박스로 받아오기 때문에 따로 set해줘야 함.			
				CalendarDeadline.set(Calendar.HOUR, Integer.parseInt((String) cbDeadlineHour.getSelectedItem()));   
				CalendarDeadline.set(Calendar.MINUTE, Integer.parseInt((String) cbDeadlineMinute.getSelectedItem()));
				CalendarDueDate.set(Calendar.HOUR, Integer.parseInt((String)cbDueDateHour.getSelectedItem()));
				CalendarDueDate.set(Calendar.MINUTE, Integer.parseInt((String)cbDueDateMinute.getSelectedItem()));
	//AM_PM설정 			
				TodoAdd.AM_PM(CalendarDueDate, btnAmPmDueDate);
				TodoAdd.AM_PM(CalendarDeadline, btnAmPmDeadline);
			
				
				TodoElement TodoElement = new TodoElement(Todo, Subject, CalendarDeadline, CalendarDueDate, Completed, Importance);
				TodoElement.todochangeDB(selectedRow);
				DataBase.getSelectedTodoElement(selectedRow);
				DataBase.TodoChange(TodoElement, selectedRow);
				todomanage_parm.SelectUpdateTableMethod();
				//todomanage_parm.UpdateTable();
				todomanage_parm.setVisible(true);
				thisTodoChange.dispose();
			}
		});
		btnChange.setBounds(573, 15, 105, 45);
		contentPane.add(btnChange);
		
		
	}
}