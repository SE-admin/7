package se.smu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
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
	private TodoElement TE = new TodoElement(null, null, null, null, rootPaneCheckingEnabled, rootPaneCheckingEnabled);
	private DataBase DataBase;
/* 
 * 	use UpdateTable() for initiating and updating table
 *  methods is specified down below the class
*/
	
	public TodoManage(Intro introclass_parm) {
		
		DataBase = DataBase.getDataBase();										//Import DB to Manage To do 
		
		setTitle("TodoManage");
		introclass = introclass_parm;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 914, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
//ADD 구현완료 	
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(779, 100, 105, 45);
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
		btnNewButton.setBounds(779, 150, 105, 45);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try{											
					int selectedRow = table.convertRowIndexToModel(table.getSelectedRow());					// change view index to model index 
					if(selectedRow>-1){
					TodoChange todochange = new TodoChange(thisTodoManage, selectedRow);						
					todochange.setVisible(true);
					}
				}
				 catch(Exception ex){
					 JOptionPane.showConfirmDialog(contentPane, "Please select To do ", "Alert", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,null);
				 }
				}
			});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  try{
					int selectedRow=table.convertRowIndexToModel(table.getSelectedRow());
					if(selectedRow>-1){
					TodoElement selectedTodoElement = DataBase.getSelectedTodoElement(selectedRow);	//load selected Todo element on each field
					DataBase.getSelectedTodoElement(selectedRow);
					DataBase.TodoDelete(selectedTodoElement, selectedRow);
					thisTodoManage.SelectUpdateTableMethod();
					//thisTodoManage.UpdateTable();
					}
				  }
				  catch(Exception ex){
						 JOptionPane.showConfirmDialog(contentPane, "Please select To do", "Alert", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,null);
					 }
				
				}
			});
		btnNewButton_1.setBounds(779, 200, 105, 45);
		contentPane.add(btnNewButton_1);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(779, 250, 105, 45);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				introclass.setVisible(true);
				thisTodoManage.dispose();
			}
		});
		contentPane.add(btnBack);
		
	    scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 15, 752, 387);
		contentPane.add(scrollPane);
//reset sort		
		JButton btnResetSort = new JButton("reset sort");
		
		btnResetSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thisTodoManage.SelectUpdateTableMethod();
			}
		});
		btnResetSort.setForeground(Color.BLACK);
		btnResetSort.setBounds(779, 50, 105, 45);
		contentPane.add(btnResetSort);
	
/*
 ******HIDE AND SHOW COMPLETED TO DO
***************구현
**********************************~
*/
		JButton btnHideShowCompleted = new JButton();
		if(DataBase.Hide==false)
			btnHideShowCompleted.setText("Hide");
		else
			btnHideShowCompleted.setText("Show");
		btnHideShowCompleted.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				if((btnHideShowCompleted.getText()).equals("Hide")){
					btnHideShowCompleted.setText("Show");					//AM to PM button text when it is clicked
					thisTodoManage.UpdateTable_HideShowCompleted();							// Hide completed item
					DataBase.Hide=true;
				}
				else{
					btnHideShowCompleted.setText("Hide");
					thisTodoManage.UpdateTable();											// back to original
					DataBase.Hide=false;
				}
				}
							
				});
		btnHideShowCompleted.setBounds(826, 274, 105, 29);
		contentPane.add(btnHideShowCompleted);
					
		thisTodoManage.SelectUpdateTableMethod(); 									///~~~~~~~~~!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		//thisTodoManage.UpdateTable();													//create table


		
		
}
//initiate & update table
	public void UpdateTable(){ 
		TableModel = new DefaultTableModel(DataBase.MatrixTodoElement(),DataBase.TodoColumnNames){    //테이블 수정 금지
	         public boolean isCellEditable(int row, int column){
	            return false;
	            }
	      };
	      
		table = new JTable();
		table.setModel(TableModel);		// set table model 
		DataBase.setTableModel(TableModel);
		int cnt = TE.todoDBrow();
		if(cnt != 0){
		for(int i=0; i<cnt;i++){
			TableModel.addRow(DataBase.inittodo.toArray());
			for(int j =0 ; j<7; j++){
				DataBase.inittodo.remove(0);
				}
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
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		
		centerRenderer.setHorizontalAlignment( SwingConstants.CENTER );				//center the 'Completed' and 'Importance' column
		table.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );	

//과목정렬, 마감기한, 실제 마감일 , 완료 여부 정렬 
		scrollPane.setViewportView(table);
		RowSorter sorter = new TableRowSorter(TableModel);
		table.setRowSorter(sorter);									 // sort table
		}
//Data model for 'HIDE AND SHOW COMPLETED TO DO'
	
	public void UpdateTable_HideShowCompleted(){
		TableModel = new DefaultTableModel(DataBase.MatrixTodoElement(),DataBase.TodoColumnNames){    //테이블 수정 금지
	         public boolean isCellEditable(int row, int column){
	            return false;
	            }
	      };
		table = new JTable();
		TableModel=new DefaultTableModel(DataBase.MatrixHideShowCompleted(),DataBase.TodoColumnNames);
		table.setModel(TableModel);																	// set table model 
		DataBase.setTableModel(TableModel);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setPreferredWidth(96);
		table.getColumnModel().getColumn(2).setPreferredWidth(157);
		table.getColumnModel().getColumn(3).setPreferredWidth(157);
		table.getColumnModel().getColumn(4).setPreferredWidth(50);
		table.getColumnModel().getColumn(5).setPreferredWidth(50);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		table.setAutoCreateRowSorter(true);										 // sort table
	}
		
//Select which 'update table' method will be used according to the statement of Hide/Show button
	public void SelectUpdateTableMethod(){
		if(DataBase.Hide==false)
			thisTodoManage.UpdateTable();
		else
			UpdateTable_HideShowCompleted();
		}

//	public void Update_Table(){   
//		table = new JTable();
//		TableModel=new DefaultTableModel(DataBase.MatrixTodoElement(),DataBase.TodoColumnNames);
//		table.setModel(TableModel);		// set table model 
//		table = new JTable(TableModel);
//		for(int i=0;i<TableModel.getRowCount();i++)
//		{
//			TableModel.removeRow(0);
//		}
//		for(int i=0; i<=DataBase.inittodo.size();i++){
//			TableModel.addRow(DataBase.inittodo.toArray());
//			for(int j =0 ; j<6; j++){
//				DataBase.inittodo.remove(0);}
//			}
//		
//		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		table.getColumnModel().getColumn(0).setPreferredWidth(150);
//		table.getColumnModel().getColumn(1).setPreferredWidth(96);
//		table.getColumnModel().getColumn(2).setPreferredWidth(157);
//		table.getColumnModel().getColumn(3).setPreferredWidth(157);
//		table.getColumnModel().getColumn(4).setPreferredWidth(50);
//		table.getColumnModel().getColumn(5).setPreferredWidth(50);
//		table.setFillsViewportHeight(true);
//		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
//		
//		centerRenderer.setHorizontalAlignment( SwingConstants.CENTER );				//center the 'Completed' and 'Importance' column
//		table.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
//		table.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );	
//
////과목정렬, 마감기한, 실제 마감일 , 완료 여부 정렬 
//		scrollPane.setViewportView(table);
//		RowSorter sorter = new TableRowSorter(TableModel);
//		table.setRowSorter(sorter);									 // sort table
//		}
	}			

		
		

	
	
	
	


