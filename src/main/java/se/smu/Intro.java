package se.smu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Intro extends JFrame {

	
	private JPanel contentPane;
	private Intro thisIntro = this;
	private SubjectManage subjectmanage1;
	private TodoElement TodoElement;
	private DataBase database = new DataBase();

	public Intro() {
		SubjectElement SE = new SubjectElement(null, null, null, 0, null, 0, null, 0, null);
		if(SE.DBrow() != 0){
			SE.initDB();}
		TodoElement TE = new TodoElement(null, null, null, null, rootPaneCheckingEnabled, rootPaneCheckingEnabled);
		if(TE.todoDBrow() != 0){
			TE.todoinitDB();
//			TodoElement = new TodoElement(null, null, null, null, rootPaneCheckingEnabled, rootPaneCheckingEnabled);
//			database.TodoAdd(TodoElement);
		}
		setTitle("Intro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 533, 314);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton btnSubjectManage = new JButton("Subject Manage");
		btnSubjectManage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thisIntro.setVisible(false);
				subjectmanage1 = new SubjectManage(thisIntro);
				subjectmanage1.setVisible(true);
			}
		});
		btnSubjectManage.setBounds(68, 106, 168, 56);
		contentPane.add(btnSubjectManage);
		
		JButton btnTo = new JButton("To do List");
		btnTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thisIntro.setVisible(false);
				TodoManage todomanage1 = new TodoManage(thisIntro);
				todomanage1.setVisible(true);
			}
		});
		btnTo.setBounds(270, 106, 168, 56);
		contentPane.add(btnTo);
	}
}
