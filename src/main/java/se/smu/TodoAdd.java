package se.smu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TodoAdd extends JFrame {

	private JPanel contentPane;
	private TodoManage todomanageclass;
	private TodoAdd thisTodoAdd = this;

	public TodoAdd(TodoManage todomanage_parm) {
		todomanageclass = todomanage_parm;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 736, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(599, 62, 105, 27);
		contentPane.add(btnAdd);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				todomanageclass.setVisible(true);
				thisTodoAdd.dispose();
			}
		});
		btnBack.setBounds(599, 157, 105, 27);
		contentPane.add(btnBack);
	}
}
