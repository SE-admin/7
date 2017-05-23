package se.smu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
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
	
	private DataBase DB;
	
	private JPanel contentPane;
	private SubjectManage subjectmanageclass;
	private SubjectChange thisSubjectChange = this;
	
	public Subject Subject;
	
	private JTextField txtSubject;
	private JTextField txtProf;


	public SubjectChange(SubjectManage subjectmanage_parm, int selectedRow) {
		DB = DataBase.getDataBase();
		Subject selectedSubject = DB.getSelectedSubject(selectedRow);
		
		setTitle("Change");
		subjectmanageclass = subjectmanage_parm;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subjectmanageclass.setVisible(true);
				thisSubjectChange.dispose();
			}
		});
		btnBack.setBounds(595, 135, 105, 45);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("Subject");
		lblNewLabel.setBounds(30, 51, 89, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblProf = new JLabel("Prof");
		lblProf.setBounds(30, 148, 89, 18);
		contentPane.add(lblProf);
		
		JLabel lblYearsemester = new JLabel("Year/Semester");
		lblYearsemester.setBounds(14, 255, 105, 18);
		contentPane.add(lblYearsemester);
		
		JLabel lblNewLabel_1 = new JLabel("Day");
		lblNewLabel_1.setBounds(30, 354, 62, 18);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblStart = new JLabel("Start");
		lblStart.setBounds(332, 51, 34, 18);
		contentPane.add(lblStart);
		
		JLabel lblEnd = new JLabel("End");
		lblEnd.setBounds(332, 148, 34, 18);
		contentPane.add(lblEnd);
		
		
		txtSubject = new JTextField(selectedSubject.name);
		txtSubject.setBounds(133, 45, 116, 24);
		contentPane.add(txtSubject);
		txtSubject.setColumns(10);
		
		txtProf = new JTextField(selectedSubject.prof);
		txtProf.setBounds(133, 142, 116, 24);
		contentPane.add(txtProf);
		txtProf.setColumns(10);
		
		JComboBox cbStartHour = new JComboBox(DB.Hour);
		cbStartHour.setBounds(437, 45, 49, 24);
		contentPane.add(cbStartHour);
		
		JComboBox cbStartMinute = new JComboBox(DB.Minute);
		cbStartMinute.setBounds(495, 45, 49, 24);
		contentPane.add(cbStartMinute);
		
		JComboBox cbEndHour = new JComboBox(DB.Hour);
		cbEndHour.setBounds(437, 142, 49, 24);
		contentPane.add(cbEndHour);
		
		JComboBox cbEndMinute = new JComboBox(DB.Minute);
		cbEndMinute.setBounds(495, 142, 49, 24);
		contentPane.add(cbEndMinute);
		
		JComboBox cbStartAm = new JComboBox(DB.Am);
		cbStartAm.setBounds(374, 45, 49, 24);
		contentPane.add(cbStartAm);
		
		JComboBox cbEndAm = new JComboBox(DB.Am);
		cbEndAm.setBounds(374, 142, 49, 24);
		contentPane.add(cbEndAm);
		
		JYearChooser ycYear = new JYearChooser();
		ycYear.setBounds(133, 255, 79, 24);
		contentPane.add(ycYear);
		
		JComboBox cbSemester = new JComboBox(DB.Semester);
		cbSemester.setBounds(215, 255, 45, 24);
		contentPane.add(cbSemester);
		
		/*
		 * 요일 버튼 클릭 동작
		 */
		
		JButton btnMon = new JButton("MON");
		btnMon.setBounds(133, 350, 65, 45);
		contentPane.add(btnMon);
		
		JButton btnTue = new JButton("TUE");
		btnTue.setBounds(215, 350, 65, 45);
		contentPane.add(btnTue);
		
		JButton btnWed = new JButton("WED");
		btnWed.setBounds(294, 350, 65, 45);
		contentPane.add(btnWed);
		
		JButton btnThu = new JButton("THU");
		btnThu.setBounds(374, 350, 65, 45);
		contentPane.add(btnThu);
		
		JButton btnFri = new JButton("FRI");
		btnFri.setBounds(453, 350, 65, 45);
		contentPane.add(btnFri);
		
		JButton btnSat = new JButton("SAT");
		btnSat.setBounds(532, 350, 65, 45);
		contentPane.add(btnSat);
		
		JButton btnSun = new JButton("SUN");
		btnSun.setBounds(609, 350, 65, 45);
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
		btnNewButton.setBounds(595, 38, 105, 45);
		contentPane.add(btnNewButton);
	}

}
