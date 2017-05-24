package se.smu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

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
	
/* 
 * 	use UpdateTable() for initiating and updating table
 *  methods is specified down below the class
*/
	
	public TodoManage(Intro introclass_parm) {
		
		DataBase = DataBase.getDataBase();										//Import DB to Manage Todo 
		
		setTitle("TodoManage");
		introclass = introclass_parm;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 952, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
//ADD 구현완료 	
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(826, 55, 105, 27);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TodoAdd todoadd1 = new TodoAdd(thisTodoManage);
				todoadd1.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnAdd);
//Change 구현완료 		
		JButton btnNewButton = new JButton("Change");
		btnNewButton.setBounds(826, 120, 105, 27);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.convertRowIndexToModel(table.getSelectedRow());					// jtable에는 view index, model index따로존재 mapping정보 알 수 있다. 
				TodoChange todochange = new TodoChange(thisTodoManage, selectedRow);
				todochange.setVisible(true);
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int selectedRow=table.convertColumnIndexToModel(table.getSelectedRow());
				TodoElement selectedTodoElement = DataBase.getSelectedTodoElement(selectedRow);	//load selected Todo element on each field
				DataBase.getSelectedTodoElement(selectedRow);
				DataBase.TodoDelete(selectedTodoElement, selectedRow);
				
				thisTodoManage.UpdateTable();
			}
		});
		btnNewButton_1.setBounds(826, 195, 105, 27);
		contentPane.add(btnNewButton_1);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(826, 342, 105, 27);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				introclass.setVisible(true);
				thisTodoManage.dispose();
			}
		});
		contentPane.add(btnBack);
		
	    scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 12, 786, 379);
		contentPane.add(scrollPane);
	
		thisTodoManage.UpdateTable();						// Create initial table 

		
		
}
//initiate & update table
	public void UpdateTable(){   
		table = new JTable();
		TableModel=new DefaultTableModel(DataBase.MatrixTodoElement(),DataBase.TodoColumnNames);
		table.setModel(TableModel);																// set table model 
			
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setPreferredWidth(96);
		table.getColumnModel().getColumn(2).setPreferredWidth(157);
		table.getColumnModel().getColumn(3).setPreferredWidth(157);
		table.getColumnModel().getColumn(4).setPreferredWidth(50);
		table.getColumnModel().getColumn(5).setPreferredWidth(50);
		table.setFillsViewportHeight(true);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		
		centerRenderer.setHorizontalAlignment( SwingConstants.CENTER );				//center the 'Completed' and 'Importance' column
		table.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );	
		
		scrollPane.setViewportView(table);
		table.setAutoCreateRowSorter(true);										 // sort table
		}
	}			

		
		

	
	
	
	


