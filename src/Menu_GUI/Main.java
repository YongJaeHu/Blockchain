package Menu_GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import academy_GUI.bcd_acbody_login_key;
import hash.Employer_loginGUI;

import hash.Student_loginGUI;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Elearning Degree Validation System");
		lblNewLabel.setBounds(33, 22, 403, 37);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Login as Student");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                Student_loginGUI mainFrame = new Student_loginGUI();
                mainFrame.setVisible(true);
                dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(112, 84, 225, 47);
		contentPane.add(btnNewButton);
		
		JButton btnLoginAsEmployer = new JButton("Login as Employer");
		btnLoginAsEmployer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                Employer_loginGUI mainFrame = new Employer_loginGUI();
                mainFrame.setVisible(true);
                dispose();
			}
		});
		btnLoginAsEmployer.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnLoginAsEmployer.setBounds(112, 145, 225, 47);
		contentPane.add(btnLoginAsEmployer);
		
		JButton btnLoginAsInstitution = new JButton("Login as Academy Body");
		btnLoginAsInstitution.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                bcd_acbody_login_key mainFrame = new bcd_acbody_login_key();
                mainFrame.setVisible(true);
                dispose();
			}
		});
		btnLoginAsInstitution.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnLoginAsInstitution.setBounds(112, 202, 225, 47);
		contentPane.add(btnLoginAsInstitution);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnExit.setBounds(112, 259, 225, 47);
		contentPane.add(btnExit);
	}
}
