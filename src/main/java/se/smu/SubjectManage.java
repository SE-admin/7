package se.smu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import javax.swing.ListSelectionModel;

public class SubjectManage extends JFrame {
	private Intro introclass;
	private JPanel contentPane;
	
	private SubjectManage thisSubjectManage = this;
	private Frame frame = this;
	
	private DataBase database;
	
	private JTable table;
	private DefaultTableModel TableModel;
	public JScrollPane scrollPane;	
	private SubjectElement SE = new SubjectElement(null, null, null, 0, null, 0, null, 0, null);
	Vector<SubjectElement> SV = new Vector<SubjectElement>();

	
	public void Subject_Table(){
		int cnt = SE.DBrow();
		String[] SubjectColumnNames={"Subject", "Prof", "Year/Semester", "Day", "Start", "End"};
		TableModel = new DefaultTableModel(database.MatrixSubject(), database.SubjectColumnNames){
			public boolean isCellEditable(int row, int column){
				return false;
				}
		};;
		
		table = new JTable(TableModel);
		if(cnt != 0){System.out.println(database.initsubject.size());
		for(int i=0;i<TableModel.getRowCount();i++)
		{
			TableModel.removeRow(0);
		}
		for(int i=0; i<cnt;i++){
			TableModel.addRow(database.initsubject.toArray());
			for(int j =0 ; j<6; j++){
			database.initsubject.remove(0);}            
		}
		}
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
		database = DataBase.getDataBase();
		
		setTitle("SubjectManage");
		introclass = introclass_parm;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 689, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(545, 45, 105, 45);
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
		btnChange.setBounds(545, 125, 105, 45);
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int selectedrow = table.convertRowIndexToModel(table.getSelectedRow());
					if(selectedrow > -1){
						SubjectChange subjectchange = new SubjectChange(thisSubjectManage, selectedrow);
						subjectchange.setVisible(true);
					}
				}
				catch(Exception ex){
					JOptionPane.showMessageDialog(frame, "Select row", "Error", JOptionPane.WARNING_MESSAGE);
				}
			
			}
		});
		contentPane.add(btnChange);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int selectedRow=table.convertRowIndexToModel(table.getSelectedRow());
					if(selectedRow > -1){
						SubjectElement selectedSubject = database.getSelectedSubject(selectedRow);
						database.getSelectedSubject(selectedRow);
						database.SubjectDelete(selectedSubject, selectedRow);
						SE.deleteDB(selectedRow);
						thisSubjectManage.Subject_Table();
					}
				}
				catch(Exception ex){
					JOptionPane.showMessageDialog(frame, "Select row", "Error", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnDelete.setBounds(545, 205, 105, 45);
		contentPane.add(btnDelete);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(545, 285, 105, 45);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				introclass.setVisible(true);
				thisSubjectManage.dispose();
			}
		});
		contentPane.add(btnBack);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 518, 375);
		contentPane.add(scrollPane);

		this.Subject_Table();
	}
}