package se.smu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;

public class SubjectManage extends JFrame {
	private Intro introclass;
	private JPanel contentPane;
	private SubjectManage thisSubjectManage = this;
	private JTable table;



	public SubjectManage(Intro introclass_parm) {
		setTitle("SubjectManage");
		introclass = introclass_parm;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 689, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBounds(531, 33, 105, 39);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//thisSubjectManage.setVisible(false);
				SubjectAdd subjectadd1 = new SubjectAdd(thisSubjectManage);
				subjectadd1.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		JButton btnChange = new JButton("Change");
		btnChange.setBounds(531, 116, 105, 39);
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		contentPane.add(btnChange);
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.setBounds(531, 206, 105, 39);
		contentPane.add(btnNewButton_1);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(531, 317, 105, 46);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				introclass.setVisible(true);
				thisSubjectManage.dispose();
			}
		});
		contentPane.add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 12, 489, 379);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Subject", "Prof", "Year/Semester", "Day", "Start", "End"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(201);
		table.getColumnModel().getColumn(1).setPreferredWidth(96);
		table.getColumnModel().getColumn(2).setPreferredWidth(157);
		table.getColumnModel().getColumn(3).setPreferredWidth(51);
		table.getColumnModel().getColumn(4).setPreferredWidth(97);
		table.getColumnModel().getColumn(5).setPreferredWidth(104);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
	}
}
