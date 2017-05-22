package se.smu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class SubjectAdd extends JFrame {
	
	private JPanel contentPane;
	private SubjectManage subjectmanageclass;
	private SubjectAdd thisSubjectAdd = this;
	private JTextField textField;
	private JTextField textField_1;
	JButton btnMON;
	JButton btnTUE;
	JButton btnWED;
	JButton btnTHU;
	JButton btnFRI;
	JButton btnSAT;
	JButton btnSUN;

	public SubjectAdd(SubjectManage subjectmanage_parm) {
		setTitle("Add");
		subjectmanageclass = subjectmanage_parm;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBounds(595, 38, 105, 45);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subjectmanageclass.setVisible(true);
				thisSubjectAdd.dispose();
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
		
		textField = new JTextField();
		textField.setBounds(133, 45, 116, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(133, 142, 116, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(437, 45, 34, 24);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(485, 45, 34, 24);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(437, 142, 34, 24);
		contentPane.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(485, 142, 34, 24);
		contentPane.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(374, 45, 34, 24);
		contentPane.add(comboBox_4);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBounds(374, 142, 34, 24);
		contentPane.add(comboBox_5);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setBounds(133, 252, 78, 24);
		contentPane.add(comboBox_6);
		
		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setBounds(215, 252, 34, 24);
		contentPane.add(comboBox_7);
		
		/*
		 * 
		 */
		
		JButton btnMon = new JButton("MON");
		btnMon.setBounds(133, 350, 65, 45);
		contentPane.add(btnMon);
		
		JButton btnTUE = new JButton("TUE");
		btnTUE.setBounds(215, 350, 65, 45);
		contentPane.add(btnTUE);
		
		JButton btnWED = new JButton("WED");
		btnWED.setBounds(294, 350, 65, 45);
		contentPane.add(btnWED);
		
		JButton btnTHU = new JButton("THU");
		btnTHU.setBounds(374, 350, 65, 45);
		contentPane.add(btnTHU);
		
		JButton btnFRI = new JButton("FRI");
		btnFRI.setBounds(453, 350, 65, 45);
		contentPane.add(btnFRI);
		
		JButton btnSat = new JButton("SAT");
		btnSat.setBounds(532, 350, 65, 45);
		contentPane.add(btnSat);
		
		JButton btnSun = new JButton("SUN");
		btnSun.setBounds(609, 350, 65, 45);
		contentPane.add(btnSun);
		
		
	}
}
