package se.smu;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private DataBase DataBase;
	public TodoChange(TodoManage todomanage_parm,int selectedRow) {
		
		String loadedAmPm;																//variable for loading Am/Pm on each button
		DataBase = DataBase.getDataBase();												//import DB
		TodoElement selectedTodoElement = DataBase.getSelectedTodoElement(selectedRow);	//load selected Todo element on each field
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 744, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Compeleted");
		label.setBounds(330, 109, 96, 16);
		contentPane.add(label);
		
		JLabel lblTodo = new JLabel("To do");
		lblTodo.setBounds(24, 66, 61, 16);
		contentPane.add(lblTodo);
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setBounds(24, 109, 61, 16);
		contentPane.add(lblSubject);
		
		JLabel lblDeadline = new JLabel("Deadline");
		lblDeadline.setBounds(29, 161, 61, 16);
		contentPane.add(lblDeadline);
		
		JLabel lblimportance = new JLabel("Importance");
		lblimportance.setBounds(293, 87, 96, 16);
		contentPane.add(lblimportance);
		
		JLabel lblDueDate = new JLabel("Due Date");
		lblDueDate.setBounds(310, 161, 61, 16);
		contentPane.add(lblDueDate);
		
		if(selectedTodoElement.DueDate.AM == 0) loadedAmPm ="AM";			//load AM or PM
		else 									loadedAmPm ="PM";
		JButton btnAmPmDueDate = new JButton(loadedAmPm);
		btnAmPmDueDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((btnAmPmDueDate.getText()).equals("AM"))
					btnAmPmDueDate.setText("PM");					//AM to PM button text 바꾸기 
				else
					btnAmPmDueDate.setText("AM");
			}
		});
		btnAmPmDueDate.setBounds(367, 156, 59, 29);
		contentPane.add(btnAmPmDueDate);
		
		if(selectedTodoElement.Deadline.AM == 0) loadedAmPm ="AM";
		else  									 loadedAmPm ="PM";
		JButton btnAmPmDeadline = new JButton(loadedAmPm);
		btnAmPmDeadline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((btnAmPmDeadline.getText()).equals("AM"))
					btnAmPmDeadline.setText("PM");					//AM to PM button text 바꾸기 
				else
					btnAmPmDeadline.setText("AM");
			}
		});
		btnAmPmDeadline.setBounds(90, 156, 59, 29);
		contentPane.add(btnAmPmDeadline);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				todomanage_parm.setVisible(true);
				thisTodoChange.dispose();
			}
		});
		btnBack.setBounds(599, 157, 105, 27);
		contentPane.add(btnBack);
		
		JTextField txtTodo = new JTextField(selectedTodoElement.Todo);
		txtTodo.setColumns(10);
		txtTodo.setBounds(65, 61, 441, 26);
		contentPane.add(txtTodo);
//TODO subject연동 
		JComboBox cbSubject = new JComboBox();
		cbSubject.setBounds(81, 102, 200, 27);
		contentPane.add(cbSubject);
		
		JCheckBox checkImportance = new JCheckBox("");
		checkImportance.setSelected(selectedTodoElement.Importance); 									//load Importance
		checkImportance.setBounds(401, 83, 128, 23);
		contentPane.add(checkImportance);
		
		
		JCheckBox checkCompleted = new JCheckBox("");
		checkCompleted.setSelected(selectedTodoElement.Completed); 									// load Completed
		checkCompleted.setHorizontalAlignment(SwingConstants.LEFT);
		checkCompleted.setBounds(412, 102, 128, 23);
		contentPane.add(checkCompleted);
		
		JComboBox cbDeadlineHour = new JComboBox(DataBase.Hour);
		cbDeadlineHour.setSelectedIndex(selectedTodoElement.Deadline.HOUR);							// Load hour  
		cbDeadlineHour.setMaximumRowCount(12);
		cbDeadlineHour.setBounds(157, 157, 65, 27);
		contentPane.add(cbDeadlineHour);
		
		JComboBox cbDeadlineMinute = new JComboBox(DataBase.Minute);
		cbDeadlineMinute.setSelectedIndex(selectedTodoElement.Deadline.MINUTE);					  //
		cbDeadlineMinute.setMaximumRowCount(59);
		cbDeadlineMinute.setBounds(230, 157, 70, 27);
		contentPane.add(cbDeadlineMinute);
		
		JComboBox cbDueDateHour = new JComboBox(DataBase.Hour);
		cbDueDateHour.setSelectedIndex(selectedTodoElement.DueDate.HOUR);							//
		cbDueDateHour.setMaximumRowCount(12);
		cbDueDateHour.setBounds(430, 157, 52, 27);
		contentPane.add(cbDueDateHour);
		
		
		JComboBox cbDueDateMinute = new JComboBox(DataBase.Minute);
		cbDueDateMinute.setSelectedIndex(selectedTodoElement.DueDate.MINUTE);					//
		cbDueDateMinute.setMaximumRowCount(12);
		cbDueDateMinute.setBounds(489, 157, 65, 27);
		contentPane.add(cbDueDateMinute);

//*TODO 캘린더 기존거 불러오도록 해야함!!!+클릭된거 색깔체크로 보여줄것  ~>TodoAdd도 마찬가지 
		JCalendar JCalendarDueDate = new JCalendar();
		JCalendarDueDate.setWeekOfYearVisible(false);
		JCalendarDueDate.setNullDateButtonText("");
		JCalendarDueDate.setDecorationBordersVisible(true);
		JCalendarDueDate.setBounds(379, 196, 325, 229);
		contentPane.add(JCalendarDueDate);
		
		JCalendar JCalendarDeadline = new JCalendar();
		JCalendarDeadline.setWeekOfYearVisible(false);
		JCalendarDeadline.setNullDateButtonText("");
		JCalendarDeadline.setDecorationBordersVisible(true);
		JCalendarDeadline.setBounds(20, 196, 325, 229);
		contentPane.add(JCalendarDeadline);
		

		
//TODO -Ing ~> TodoAdd의 change부분과 겹치는데..함수화할까?
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
			
				
				TodoElement=new TodoElement();
				TodoElement.setTodoElement(Todo, Subject, CalendarDeadline, CalendarDueDate, Completed, Importance);
				DataBase.getSelectedTodoElement(selectedRow);
				DataBase.TodoChange(TodoElement, selectedRow);
				todomanage_parm.UpdateTable();
				todomanage_parm.setVisible(true);
				thisTodoChange.dispose();
			}
		});
		btnChange.setBounds(599, 62, 105, 27);
		contentPane.add(btnChange);
		
		
	}
}
