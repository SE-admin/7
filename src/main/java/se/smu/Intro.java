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

	public Intro() {
		setTitle("Intro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 528, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Subject Manage");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thisIntro.setVisible(false);
				subjectmanage1 = new SubjectManage(thisIntro);
				subjectmanage1.setVisible(true);
			}
		});
		btnNewButton.setBounds(47, 106, 139, 56);
		contentPane.add(btnNewButton);
		
		JButton btnTo = new JButton("To do List");
		btnTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thisIntro.setVisible(false);
				TodoManage todomanage1 = new TodoManage(thisIntro);
				todomanage1.setVisible(true);
			}
		});
		btnTo.setBounds(322, 106, 139, 56);
		contentPane.add(btnTo);
	}
}
