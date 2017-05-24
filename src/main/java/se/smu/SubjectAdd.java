package se.smu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JYearChooser;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class SubjectAdd extends JFrame {
	
	private DataBase DB;
	
	private JPanel contentPane;
	private SubjectManage subjectmanageclass;
	private SubjectAdd thisSubjectAdd = this;
	
	private JTextField txtSubject;
	private JTextField txtProf;
	
	JButton btnMON;
	JButton btnTUE;
	JButton btnWED;
	JButton btnTHU;
	JButton btnFRI;
	JButton btnSAT;
	JButton btnSUN;

	public SubjectAdd(SubjectManage subjectmanage_parm) {
		DB = DataBase.getDataBase();
		
		setTitle("Add");
		subjectmanageclass = subjectmanage_parm;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subjectmanageclass.setVisible(true);
				thisSubjectAdd.dispose();
			}
		});
		btnBack.setBounds(595, 135, 105, 45);
		contentPane.add(btnBack);
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setBounds(30, 51, 89, 18);
		contentPane.add(lblSubject);
		
		JLabel lblProf = new JLabel("Prof");
		lblProf.setBounds(30, 148, 89, 18);
		contentPane.add(lblProf);
		
		JLabel lblYearsemester = new JLabel("Year/Semester");
		lblYearsemester.setBounds(14, 255, 105, 18);
		contentPane.add(lblYearsemester);
		
		JLabel lblDay = new JLabel("Day");
		lblDay.setBounds(30, 354, 62, 18);
		contentPane.add(lblDay);
		
		JLabel lblStart = new JLabel("Start");
		lblStart.setBounds(332, 51, 34, 18);
		contentPane.add(lblStart);
		
		JLabel lblEnd = new JLabel("End");
		lblEnd.setBounds(332, 148, 34, 18);
		contentPane.add(lblEnd);
		
		txtProf = new JTextField();
		txtProf.setBounds(133, 142, 116, 24);
		contentPane.add(txtProf);
		txtProf.setColumns(10);
		
		txtSubject = new JTextField();
		txtSubject.setBounds(133, 45, 116, 24);
		contentPane.add(txtSubject);
		txtSubject.setColumns(10);
		
		JComboBox cbStartHour = new JComboBox(DB.Hour);
		cbStartHour.setBounds(437, 45, 49, 24);
		contentPane.add(cbStartHour);
		
		JComboBox cbStartMinute = new JComboBox(DB.Minute);
		cbStartMinute.setBounds(500, 45, 49, 24);
		contentPane.add(cbStartMinute);
		
		JComboBox cbStartAm = new JComboBox(DB.Am);
		cbStartAm.setBounds(374, 45, 49, 24);
		contentPane.add(cbStartAm);
		
		JComboBox cbEndHour = new JComboBox(DB.Hour);
		cbEndHour.setBounds(437, 142, 49, 24);
		contentPane.add(cbEndHour);
		
		JComboBox cbEndMinute = new JComboBox(DB.Minute);
		cbEndMinute.setBounds(500, 142, 49, 24);
		contentPane.add(cbEndMinute);
		
		JComboBox cbEndAm = new JComboBox(DB.Am);
		cbEndAm.setBounds(374, 142, 49, 24);
		contentPane.add(cbEndAm);
		
		JComboBox cbSemester = new JComboBox(DB.Semester);
		cbSemester.setBounds(215, 252, 49, 24);
		contentPane.add(cbSemester);
		
		JYearChooser ycYear = new JYearChooser();
		ycYear.setBounds(133, 252, 79, 24);
		contentPane.add(ycYear);
		
		/*
		 *각각 버튼 눌렀을때 색 변경
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
		 * Add버튼 눌렀을때 동작.
		 * 테이블 업데이트, 정보 get해오기, DB저장 추가
		 */
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int startHour = Integer.parseInt((String) cbStartHour.getSelectedItem());     //combobox안의 내용은 String임! int로 바꿔줘야 함
				
				int endHour = Integer.parseInt((String) cbEndHour.getSelectedItem());
				String startMinute = (String) cbStartMinute.getSelectedItem();
				String endMinute = (String) cbEndMinute.getSelectedItem();
				String semester;
				
				if (cbStartAm.getSelectedItem() == "PM")
					startHour = startHour + 12;
				if (cbEndAm.getSelectedItem() == "PM")
					endHour = endHour + 12;
				if (cbSemester.getSelectedItem() == "1")
					semester = "1";
				else
					semester = "2";
				
				
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
				
				
				Subject addSubject = new Subject(txtSubject.getText(), txtProf.getText(), SelectDay, startHour, startMinute,
						endHour, endMinute, ycYear.getValue(), semester);    //subject 구조체(?)에 내용 저장
				
				//DB의 Subject벡터에 꼬리 달기
				DB.SubjectAdd(addSubject);
				//SubjectManage의 화면 테이블에 내용 add
				subjectmanage_parm.SubjectTable();	
				subjectmanage_parm.setVisible(true);
				thisSubjectAdd.dispose();
				
			}
		});
		btnAdd.setBounds(595, 38, 105, 45);
		contentPane.add(btnAdd);
	}
}