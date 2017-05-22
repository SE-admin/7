package se.smu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

public class TodoManage extends JFrame {
	private Intro introclass;
	private JPanel contentPane;
	private TodoManage thisTodoManage = this;
	private JTable table;
	private DefaultTableModel TableModel;
	public JScrollPane scrollPane;	
	
	private DataBase DataBase;
	
	public void UpdateTable(){
		table = new JTable();
		TableModel=new DefaultTableModel(DataBase.getTodoElement(),DataBase.TodoColumnNames);
		table.setModel(TableModel);															 // create a table model 
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getColumnModel().getColumn(0).setPreferredWidth(201);
		table.getColumnModel().getColumn(1).setPreferredWidth(96);
		table.getColumnModel().getColumn(2).setPreferredWidth(157);
		table.getColumnModel().getColumn(3).setPreferredWidth(51);
		table.getColumnModel().getColumn(4).setPreferredWidth(97);
		table.getColumnModel().getColumn(5).setPreferredWidth(104);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		table.setAutoCreateRowSorter(true);										// 테이블 정렬 
	}
	
	public TodoManage(Intro introclass_parm) {
		
		DataBase = DataBase.getDataBase();										//데이터 베이스 가져옴 
		
		setTitle("TodoManage");
		introclass = introclass_parm;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(579, 46, 105, 27);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TodoAdd todoadd1 = new TodoAdd(thisTodoManage);
				todoadd1.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnAdd);
		
		JButton btnNewButton = new JButton("Change");
		btnNewButton.setBounds(579, 111, 105, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.setBounds(579, 186, 105, 27);
		contentPane.add(btnNewButton_1);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(579, 333, 105, 27);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				introclass.setVisible(true);
				thisTodoManage.dispose();
			}
		});
		contentPane.add(btnBack);
		
	    scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 12, 489, 379);
		contentPane.add(scrollPane);
	
		this.UpdateTable();										// 초기 테이블 생성 

		
}
}			
		
		

	
	
	
	


