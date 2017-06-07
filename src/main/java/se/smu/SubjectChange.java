package se.smu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JYearChooser;

public class SubjectChange extends JFrame {
	
	private DataBase database;
	
	private JPanel contentPane;
	private SubjectManage subjectmanageclass;
	private SubjectChange thisSubjectChange = this;
	
	public SubjectElement SubjectElement;
	
	private JTextField txtSubject;
	private JTextField txtProf;


	public SubjectChange(SubjectManage subjectmanage_parm, int selectedRow) {
		database = DataBase.getDataBase();
		SubjectElement selectedSubject = database.getSelectedSubject(selectedRow);
		
		setTitle("Change");
		subjectmanageclass = subjectmanage_parm;
		
		setBounds(100, 100, 743, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subjectmanageclass.setVisible(true);
				thisSubjectChange.dispose();
			}
		});
		contentPane.setLayout(null);
		btnBack.setBounds(595, 98, 105, 45);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("Subject");
		lblNewLabel.setBounds(30, 51, 89, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblProf = new JLabel("Prof");
		lblProf.setBounds(30, 111, 89, 18);
		contentPane.add(lblProf);
		
		JLabel lblYearsemester = new JLabel("Year/Semester");
		lblYearsemester.setBounds(30, 172, 133, 18);
		contentPane.add(lblYearsemester);
		
		JLabel lblNewLabel_1 = new JLabel("Day");
		lblNewLabel_1.setBounds(30, 239, 61, 18);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblStart = new JLabel("Start");
		lblStart.setBounds(317, 51, 49, 18);
		contentPane.add(lblStart);
		
		JLabel lblEnd = new JLabel("End");
		lblEnd.setBounds(317, 111, 34, 18);
		contentPane.add(lblEnd);
		
		
		txtSubject = new JTextField(selectedSubject.name);
		txtSubject.setBounds(133, 45, 147, 24);
		contentPane.add(txtSubject);
		txtSubject.setColumns(10);
		
		txtProf = new JTextField(selectedSubject.prof);
		txtProf.setBounds(133, 105, 147, 24);
		contentPane.add(txtProf);
		txtProf.setColumns(10);
		
		JComboBox cbStartHour = new JComboBox(database.Hour);
		int originstartHour = selectedSubject.starthour; //셍각
		if(originstartHour > 12)
			originstartHour = originstartHour - 12;
		String originstart = ""+originstartHour;
		//cbStartHour.setSelectedItem(originstart);
		cbStartHour.setSelectedIndex(originstartHour-1);
		cbStartHour.setBounds(437, 45, 49, 24);
		contentPane.add(cbStartHour);
		
		JComboBox cbStartMinute = new JComboBox(database.Minute);
		int startMinuteint = Integer.parseInt((String) selectedSubject.startminute);
		cbStartMinute.setSelectedIndex(startMinuteint);
		cbStartMinute.setBounds(495, 45, 49, 24);
		contentPane.add(cbStartMinute);
		
		JComboBox cbEndHour = new JComboBox(database.Hour);
		int originendHour = selectedSubject.endhour;  //생각
		if(originendHour > 12)
			originendHour = originendHour - 12;
		String originend = ""+originendHour;
		//cbEndHour.setSelectedItem(originend);
		cbEndHour.setSelectedIndex(originendHour-1);
		cbEndHour.setBounds(437, 105, 49, 24);
		contentPane.add(cbEndHour);
		
		JComboBox cbEndMinute = new JComboBox(database.Minute);
		int endMinuteint = Integer.parseInt((String) selectedSubject.endminute);
		cbEndMinute.setSelectedIndex(endMinuteint);
		cbEndMinute.setBounds(495, 105, 49, 24);
		contentPane.add(cbEndMinute);
		
		JComboBox cbStartAm = new JComboBox(database.Am);
		String originstartAm = null;
		if(selectedSubject.starthour < 12)
			originstartAm = new String("AM");
		else 
			originstartAm = new String("PM");
		cbStartAm.setSelectedItem(originstartAm);
		cbStartAm.setBounds(374, 45, 51, 24);
		contentPane.add(cbStartAm);
		
		JComboBox cbEndAm = new JComboBox(database.Am);
		String originendAm = null;
		if(selectedSubject.endhour < 12)
			originendAm = new String("AM");
		else 
			originendAm = new String("PM");
		cbEndAm.setSelectedItem(originendAm);
		cbEndAm.setBounds(374, 105, 51, 24);
		contentPane.add(cbEndAm);
		
		JYearChooser ycYear = new JYearChooser();
		ycYear.setBounds(205, 169, 79, 24);
		contentPane.add(ycYear);
		
		JComboBox cbSemester = new JComboBox(database.Semester);
		int Semesterint = Integer.parseInt((String) selectedSubject.semester);
		cbSemester.setSelectedIndex(Semesterint-1);
		cbSemester.setBounds(287, 169, 42, 24);
		contentPane.add(cbSemester);
		
		/*
		 * 요일 버튼 클릭 동작
		 */
		
		JButton btnMon = new JButton("MON");
		btnMon.setBounds(133, 226, 73, 45);
		contentPane.add(btnMon);
		
		JButton btnTue = new JButton("TUE");
		btnTue.setBounds(215, 226, 73, 45);
		contentPane.add(btnTue);
		
		JButton btnWed = new JButton("WED");
		btnWed.setBounds(297, 226, 73, 45);
		contentPane.add(btnWed);
		
		JButton btnThu = new JButton("THU");
		btnThu.setBounds(379, 226, 73, 45);
		contentPane.add(btnThu);
		
		JButton btnFri = new JButton("FRI");
		btnFri.setBounds(461, 226, 73, 45);
		contentPane.add(btnFri);
		
		JButton btnSat = new JButton("SAT");
		btnSat.setBounds(543, 226, 73, 45);
		contentPane.add(btnSat);
		
		JButton btnSun = new JButton("SUN");
		btnSun.setBounds(625, 226, 73, 45);
		contentPane.add(btnSun);
		
		//생각
		if(selectedSubject.selectday == "Mon")
			btnMon.setBackground(Color.CYAN);
		else if (selectedSubject.selectday == "Tue")
			btnTue.setBackground(Color.CYAN);
		else if (selectedSubject.selectday == "Wed")
			btnWed.setBackground(Color.CYAN);
		else if (selectedSubject.selectday == "Thu")
			btnThu.setBackground(Color.CYAN);
		else if (selectedSubject.selectday == "Fri")
			btnFri.setBackground(Color.CYAN);
		else if (selectedSubject.selectday == "Sat")
			btnSat.setBackground(Color.CYAN);
		else if (selectedSubject.selectday == "Sun")
			btnSun.setBackground(Color.CYAN);
		
		 class SelectDay extends MouseAdapter {
			 public void mouseClicked(MouseEvent e){
				if(e.getClickCount() == 1){
					btnMon.setBackground(null);
					btnTue.setBackground(null);
					btnWed.setBackground(null);
					btnThu.setBackground(null);
					btnFri.setBackground(null);
					btnSat.setBackground(null);
					btnSun.setBackground(null);
					JButton btnMon = (JButton)e.getSource();
					JButton btnTue = (JButton)e.getSource();
					JButton btnWed = (JButton)e.getSource();
					JButton btnThu = (JButton)e.getSource();
					JButton btnFri = (JButton)e.getSource();
					JButton btnSat = (JButton)e.getSource();
					JButton btnSun = (JButton)e.getSource();
					btnMon.setBackground(Color.CYAN);
					btnTue.setBackground(Color.CYAN);
					btnWed.setBackground(Color.CYAN);
					btnThu.setBackground(Color.CYAN);
					btnFri.setBackground(Color.CYAN);
					btnSat.setBackground(Color.CYAN);
					btnSun.setBackground(Color.CYAN);
				}
			}
		}
		 btnMon.addMouseListener(new SelectDay());
		 btnTue.addMouseListener(new SelectDay());
		 btnWed.addMouseListener(new SelectDay());
		 btnThu.addMouseListener(new SelectDay());
		 btnFri.addMouseListener(new SelectDay());
		 btnSat.addMouseListener(new SelectDay());
		 btnSun.addMouseListener(new SelectDay());
		
		/*
		 * Change 버튼 눌렀을때 변경된 내용으로 새로 업데이트
		 */
		 JButton btnNewButton = new JButton("Change");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int startHour = Integer.parseInt((String) cbStartHour.getSelectedItem());     //combobox안의 내용은 String임! int로 바꿔줘야 함
					int endHour = Integer.parseInt((String) cbEndHour.getSelectedItem());
					String startMinute = (String) cbStartMinute.getSelectedItem();
					String endMinute = (String) cbEndMinute.getSelectedItem();
					String semester = (String) cbSemester.getSelectedItem();
					
					if (cbStartAm.getSelectedItem() == "PM")
						startHour = startHour + 12;
					if (cbEndAm.getSelectedItem() == "PM")
						endHour = endHour + 12;	
					
					String SelectDay = null;
					if (btnMon.getBackground() == Color.CYAN)
						SelectDay = btnMon.getText();
					else if (btnTue.getBackground() == Color.CYAN)
						SelectDay = btnTue.getText();
					else if (btnWed.getBackground() == Color.CYAN)
						SelectDay = btnWed.getText();
					else if (btnThu.getBackground() == Color.CYAN)
						SelectDay = btnThu.getText();
					else if (btnFri.getBackground() == Color.CYAN)
						SelectDay = btnFri.getText();
					else if (btnSat.getBackground() == Color.CYAN)
						SelectDay = btnSat.getText();
					else if (btnSun.getBackground() == Color.CYAN)
						SelectDay = btnSun.getText();
					
					SubjectElement addSubject = new SubjectElement(txtSubject.getText(), txtProf.getText(), SelectDay, startHour, startMinute,
							endHour, endMinute, ycYear.getValue(), semester);    //subject에 내용 저장
					
					//SubjectManage의 화면 테이블에 내용 add
					addSubject.changeDB(selectedRow);
					database.getSelectedSubject(selectedRow);
					database.SubjectChange(addSubject, selectedRow);	
					subjectmanage_parm.Subject_Table();	
					subjectmanage_parm.setVisible(true);
					thisSubjectChange.dispose();
				}
			});
			btnNewButton.setBounds(595, 38, 105, 45);
			contentPane.add(btnNewButton);
	}

}
