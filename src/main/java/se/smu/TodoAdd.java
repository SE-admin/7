package se.smu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import com.toedter.calendar.JYearChooser;
import com.toedter.calendar.JCalendar;
import java.beans.PropertyChangeListener;
import java.util.Date;
import java.beans.PropertyChangeEvent;

public class TodoAdd extends JFrame {

	private JPanel contentPane;
	private TodoManage todomanageclass;
	private TodoAdd thisTodoAdd = this;
	private JTextField txtTodo;
	public JScrollPane scrollPane;	
	private DataBase DataBase;
	public TodoElement TodoElement;
	
	public static void AM_PM(Calendar calendar, JButton btn){					//methods for set Calendar's AM_PM
		if((btn.getText()).equals("AM"))
			calendar.set(Calendar.AM_PM, Calendar.AM);
		else 
			calendar.set(Calendar.AM_PM, Calendar.PM);
	}
	
	public TodoAdd(TodoManage todomanage_parm) {
		DataBase = DataBase.getDataBase();					//Import Todo
		todomanageclass = todomanage_parm;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 736, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				todomanageclass.setVisible(true);
				thisTodoAdd.dispose();
			}
		});
		btnBack.setBounds(599, 157, 105, 27);
		contentPane.add(btnBack);
		
		JLabel lblToDo = new JLabel("To do");
		lblToDo.setBounds(45, 66, 61, 16);
		contentPane.add(lblToDo);
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setBounds(45, 116, 61, 16);
		contentPane.add(lblSubject);
		
		JLabel lblDeadline = new JLabel("Deadline");
		lblDeadline.setBounds(45, 161, 61, 16);
		contentPane.add(lblDeadline);
		
		JLabel lbCompleted = new JLabel("Compeleted");
		lbCompleted.setBounds(331, 116, 96, 16);
		contentPane.add(lbCompleted);
		
		JLabel lblNewLabel_1 = new JLabel("Due Date");
		lblNewLabel_1.setBounds(331, 161, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		txtTodo = new JTextField();
		txtTodo.setBounds(104, 61, 441, 26);
		contentPane.add(txtTodo);
		txtTodo.setColumns(10);
		
		JComboBox cbSubject = new JComboBox();
		cbSubject.setBounds(104, 112, 200, 27);
		contentPane.add(cbSubject);
		
		JCheckBox checkCompleted = new JCheckBox();
		checkCompleted.setHorizontalAlignment(SwingConstants.LEFT);
		checkCompleted.setBounds(417, 116, 128, 23);
		contentPane.add(checkCompleted);
		
		JLabel lblImportance = new JLabel("Importance");
		lblImportance.setBounds(331, 88, 96, 16);
		contentPane.add(lblImportance);
		
		JCheckBox checkImportance = new JCheckBox();
		checkImportance.setHorizontalAlignment(SwingConstants.LEFT);
		checkImportance.setBounds(417, 84, 128, 23);
		contentPane.add(checkImportance);
		
		JButton btnAmPmDeadline = new JButton("AM");
		btnAmPmDeadline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((btnAmPmDeadline.getText()).equals("AM")){
					btnAmPmDeadline.setText("PM");					//AM to PM button text 바꾸기 
				}
				else
					btnAmPmDeadline.setText("AM");
			}
		});
		btnAmPmDeadline.setBounds(104, 156, 59, 29);
		contentPane.add(btnAmPmDeadline);
		
		JComboBox cbDeadlineHour = new JComboBox(DataBase.Hour);
		cbDeadlineHour.setMaximumRowCount(12);
		cbDeadlineHour.setBounds(162, 157, 65, 27);
		contentPane.add(cbDeadlineHour);
		
		JComboBox cbDueDateHour = new JComboBox(DataBase.Hour);
		cbDueDateHour.setMaximumRowCount(59);
		cbDueDateHour.setBounds(438, 157, 52, 27);
		contentPane.add(cbDueDateHour);
		
		JComboBox cbDeadlineMinute = new JComboBox(DataBase.Minute);
		cbDeadlineMinute.setMaximumRowCount(59);
		cbDeadlineMinute.setBounds(231, 157, 70, 27);
		contentPane.add(cbDeadlineMinute);
		
		JComboBox cbDueDateMinute = new JComboBox(DataBase.Minute);
		cbDueDateMinute.setMaximumRowCount(12);
		cbDueDateMinute.setBounds(523, 157, 52, 27);
		contentPane.add(cbDueDateMinute);
		
		JCalendar JCalendarDueDate = new JCalendar();
		JCalendarDueDate.setWeekOfYearVisible(false);
		JCalendarDueDate.setNullDateButtonText("");
		JCalendarDueDate.setDecorationBordersVisible(true);
		JCalendarDueDate.setBounds(375, 190, 325, 229);
		contentPane.add(JCalendarDueDate);
		
		
		
		JButton btnAmPmDueDate = new JButton("AM");
		btnAmPmDueDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((btnAmPmDueDate.getText()).equals("AM")){
					btnAmPmDueDate.setText("PM");					//AM to PM button text 바꾸기 
				}
				else
					btnAmPmDueDate.setText("AM");
			}
		});
		btnAmPmDueDate.setBounds(393, 156, 45, 29);
		contentPane.add(btnAmPmDueDate);
		
		JCalendar JCalendarDeadline = new JCalendar();
		JCalendarDeadline.setWeekOfYearVisible(false);
		JCalendarDeadline.setNullDateButtonText("");
		JCalendarDeadline.setDecorationBordersVisible(true);
		JCalendarDeadline.setBounds(20, 189, 325, 229);
		contentPane.add(JCalendarDeadline);
		
		    
//Add버  
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
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
		
		    
// 등록단계 
			TodoElement=new TodoElement();
			TodoElement.setTodoElement(Todo, Subject, CalendarDeadline, CalendarDueDate, Completed, Importance);
			DataBase.TodoAdd(TodoElement);
			todomanage_parm.UpdateTable();		    //update table
			todomanage_parm.setVisible(true);
			thisTodoAdd.dispose();
			}
		});
		btnAdd.setBounds(599, 62, 105, 27);
		contentPane.add(btnAdd);
		
		
	}
	
}

