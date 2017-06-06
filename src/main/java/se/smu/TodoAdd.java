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
import javax.swing.JOptionPane;

public class TodoAdd extends JFrame {

	private JPanel contentPane;
	private TodoManage todomanageclass;
	private TodoAdd thisTodoAdd = this;
	private JTextField txtTodo;
	public JScrollPane scrollPane;	
	private DataBase DataBase;
	public TodoElement TodoElement;
	public JOptionPane JOptionPane;
	public static void AM_PM(Calendar calendar, JButton btn){					//methods for set Calendar's AM_PM
		if((btn.getText()).equals("AM"))
			calendar.set(Calendar.AM_PM, Calendar.AM);
		else 
			calendar.set(Calendar.AM_PM, Calendar.PM);
	}
	
	public TodoAdd(TodoManage todomanage_parm) {
		DataBase = DataBase.getDataBase();					//Import Todo
		todomanageclass = todomanage_parm;
		setBounds(100, 100, 723, 478);
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
		btnBack.setBounds(571, 100, 105, 45);
		contentPane.add(btnBack);
		
		JLabel lblToDo = new JLabel("To do");
		lblToDo.setBounds(30, 51, 89, 18);
		contentPane.add(lblToDo);
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setBounds(30, 111, 89, 18);
		contentPane.add(lblSubject);
		
		JLabel lblDeadline = new JLabel("Deadline");
		lblDeadline.setBounds(30, 171, 79, 16);
		contentPane.add(lblDeadline);
/*		
		JLabel lbCompleted = new JLabel("Compeleted");
		lbCompleted.setBounds(331, 116, 96, 16);
		contentPane.add(lbCompleted);
*/				
		txtTodo = new JTextField();
		txtTodo.setBounds(133, 45, 418, 24);
		contentPane.add(txtTodo);
		txtTodo.setColumns(10);
		
//subject DB 연동 
		JComboBox cbSubject = new JComboBox(DataBase.getSubjectName());
		cbSubject.setBounds(133, 111, 200, 24);
		contentPane.add(cbSubject);
/*		
		JCheckBox checkCompleted = new JCheckBox();
		checkCompleted.setHorizontalAlignment(SwingConstants.LEFT);
		checkCompleted.setBounds(417, 116, 128, 23);
		contentPane.add(checkCompleted);
*/		
		JLabel lblImportance = new JLabel("Importance");
		lblImportance.setBounds(351, 111, 110, 18);
		contentPane.add(lblImportance);
		
		JCheckBox checkImportance = new JCheckBox();
		checkImportance.setHorizontalAlignment(SwingConstants.LEFT);
		checkImportance.setBounds(454, 111, 29, 24);
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
		btnAmPmDeadline.setBounds(133, 171, 59, 24);
		contentPane.add(btnAmPmDeadline);
		
		JComboBox cbDeadlineHour = new JComboBox(DataBase.Hour);
		cbDeadlineHour.setMaximumRowCount(12);
		cbDeadlineHour.setBounds(195, 171, 59, 24);
		contentPane.add(cbDeadlineHour);
		
		JComboBox cbDeadlineMinute = new JComboBox(DataBase.Minute);
		cbDeadlineMinute.setMaximumRowCount(59);
		cbDeadlineMinute.setBounds(259, 171, 59, 24);
		contentPane.add(cbDeadlineMinute);
		
		JCalendar JCalendarDeadline = new JCalendar();
		JCalendarDeadline.setWeekOfYearVisible(false);
		JCalendarDeadline.setNullDateButtonText("");
		JCalendarDeadline.setDecorationBordersVisible(true);
		JCalendarDeadline.setBounds(351, 171, 325, 229);
		contentPane.add(JCalendarDeadline);
		
/*		
		JComboBox cbDueDateMinute = new JComboBox(DataBase.Minute);
		cbDueDateMinute.setMaximumRowCount(12);
		cbDueDateMinute.setBounds(523, 157, 52, 27);
		contentPane.add(cbDueDateMinute);
		
		JComboBox cbDueDateHour = new JComboBox(DataBase.Hour);
		cbDueDateHour.setMaximumRowCount(59);
		cbDueDateHour.setBounds(438, 157, 52, 27);
		contentPane.add(cbDueDateHour);
		
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
		
		JLabel lblNewLabel_1 = new JLabel("Due Date");
		lblNewLabel_1.setBounds(331, 161, 61, 16);
		contentPane.add(lblNewLabel_1);
*/		
		    
//Add  
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
			String Todo=txtTodo.getText();
			String Subject=(String) cbSubject.getSelectedItem();
			boolean Completed=false;
		    boolean Importance=checkImportance.isSelected();
		    
        	Calendar CalendarDeadline=Calendar.getInstance();					//Using Calendar, store yyyy.MM.DD.hh.mm 
			CalendarDeadline.setTime(JCalendarDeadline.getDate());				//getDate() to which date is selected in JCalendar
			Calendar CalendarDueDate=Calendar.getInstance();
// HOUR, MINUTE are selected from JCombox that returns STRING. Store hour and minute in Calendar with date value			
			CalendarDeadline.set(Calendar.HOUR, Integer.parseInt((String) cbDeadlineHour.getSelectedItem()));   
			CalendarDeadline.set(Calendar.MINUTE, Integer.parseInt((String) cbDeadlineMinute.getSelectedItem()));
			CalendarDueDate.set(2002,10,11,11,11); 								//set DueDate to default
//AM_PM설정 			
			TodoAdd.AM_PM(CalendarDeadline, btnAmPmDeadline);
		
//Alert 
			if(Todo.equals(""))
				JOptionPane.showConfirmDialog(contentPane, "Please enter To do", "Alert", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,null);
			else if(cbSubject.getItemCount()==0)
				JOptionPane.showConfirmDialog(contentPane, "Please select subject", "Alert", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,null);	
			else{
//Update DataBase and table 
			TodoElement TodoElement=new TodoElement(Todo, Subject, CalendarDeadline, CalendarDueDate, Completed, Importance);
			TodoElement.todoinsertDB();
			DataBase.TodoAdd(TodoElement);
			todomanage_parm.SelectUpdateTableMethod();
			//todomanage_parm.UpdateTable();		    //update table
			todomanage_parm.setVisible(true);
			thisTodoAdd.dispose();
			}
			}
		});
		btnAdd.setBounds(571, 40, 105, 45);
		contentPane.add(btnAdd);
		
		
	}
	
}

