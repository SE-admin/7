package se.smu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;

public class SubjectManage extends JFrame {
	private Intro introclass;
	private JPanel contentPane;
	
	private SubjectManage thisSubjectManage = this;
	
	private DataBase DB;
	
	private JTable table;
	private DefaultTableModel TableModel;
	public JScrollPane scrollPane;	
	
	public void SubjectTable(){
		String[] SubjectColumnNames={"Subject", "Prof", "Year/Semester", "Day", "Start", "End"};
		TableModel = new DefaultTableModel(DB.MatrixSubject(), SubjectColumnNames);
		table = new JTable(TableModel);
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setPreferredWidth(96);
		table.getColumnModel().getColumn(2).setPreferredWidth(157);
		table.getColumnModel().getColumn(3).setPreferredWidth(157);
		table.getColumnModel().getColumn(4).setPreferredWidth(50);
		table.getColumnModel().getColumn(5).setPreferredWidth(50);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		table.setAutoCreateRowSorter(true);	
		
	}


	public SubjectManage(Intro introclass_parm) {
		DB = DataBase.getDataBase();
		
		setTitle("SubjectManage");
		introclass = introclass_parm;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 689, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(531, 33, 105, 39);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//thisSubjectManage.setVisible(false);
				SubjectAdd subjectadd1 = new SubjectAdd(thisSubjectManage);
				subjectadd1.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnAdd);
		
		JButton btnChange = new JButton("Change");
		btnChange.setBounds(531, 116, 105, 39);
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedrow = table.convertRowIndexToModel(table.getSelectedRow());
				SubjectChange subjectchange = new SubjectChange(thisSubjectManage, selectedrow);
				subjectchange.setVisible(true);
			}
		});
		contentPane.add(btnChange);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				int selectedRow=table.convertRowIndexToModel(table.getSelectedRow());
				Subject selectedSubject = DB.getSelectedSubject(selectedRow);	//load selected Todo element on each field
				DB.getSelectedSubject(selectedRow);
				DB.SubjectDelete(selectedSubject, selectedRow);
				
				thisSubjectManage.SubjectTable();
			}
		});
		btnDelete.setBounds(531, 206, 105, 39);
		contentPane.add(btnDelete);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(531, 317, 105, 46);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				introclass.setVisible(true);
				thisSubjectManage.dispose();
			}
		});
		contentPane.add(btnBack);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 12, 489, 379);
		contentPane.add(scrollPane);

		this.SubjectTable();
	}
}