package se.smu;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JYearChooser;

public class SubjectChange extends JFrame {

	private JPanel contentPane;
	private SubjectManage subjectmanageclass;
	private SubjectChange thisSubjectChange = this;
	
	private JTextField txtSubject;
	private JTextField txtProf;


	public SubjectChange(SubjectManage subjectmanage_parm) {
		
		
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
		
		/*
		 * DB연동해서 데이터 받아와야함.
		 * 
		 */
		txtSubject = new JTextField();
		txtSubject.setBounds(133, 45, 116, 24);
		contentPane.add(txtSubject);
		txtSubject.setColumns(10);
		
		txtProf = new JTextField();
		txtProf.setBounds(133, 142, 116, 24);
		contentPane.add(txtProf);
		txtProf.setColumns(10);
		
		JComboBox cbStartHour = new JComboBox();
		cbStartHour.setBounds(437, 45, 49, 24);
		contentPane.add(cbStartHour);
		
		JComboBox cbStartMinute = new JComboBox();
		cbStartMinute.setBounds(495, 45, 49, 24);
		contentPane.add(cbStartMinute);
		
		JComboBox cbEndHour = new JComboBox();
		cbEndHour.setBounds(437, 142, 49, 24);
		contentPane.add(cbEndHour);
		
		JComboBox cbEndMinute = new JComboBox();
		cbEndMinute.setBounds(495, 142, 49, 24);
		contentPane.add(cbEndMinute);
		
		JComboBox cbStartAm = new JComboBox();
		cbStartAm.setBounds(374, 45, 49, 24);
		contentPane.add(cbStartAm);
		
		JComboBox cbEndAm = new JComboBox();
		cbEndAm.setBounds(374, 142, 49, 24);
		contentPane.add(cbEndAm);
		
		JYearChooser ycYear = new JYearChooser();
		ycYear.setBounds(133, 255, 79, 24);
		contentPane.add(ycYear);
		
		JComboBox cbSemester = new JComboBox();
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
		
		/*
		 * Change 버튼 눌렀을때 변겨된 내용으로 새로 업데이트
		 */
		JButton btnNewButton = new JButton("Change");
		btnNewButton.setBounds(595, 38, 105, 45);
		contentPane.add(btnNewButton);
	}

}
