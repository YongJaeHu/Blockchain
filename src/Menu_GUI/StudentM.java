package Menu_GUI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import academy_GUI.bcd_decrypt_viewstu;
import coursedata.Course_viewstuGUI;
import hash.Employer_loginGUI;
import hash.Student_loginGUI;
import studentID_blockchain.StudentID_storeGUI;
import studentID_blockchain.StudentID_viewGUI;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentM extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentM frame = new StudentM();
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
	public StudentM() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 468, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Page");
		lblNewLabel.setBounds(154, 39, 159, 37);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("View Course Data");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                Course_viewstuGUI mainFrame = new Course_viewstuGUI();
                mainFrame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(103, 86, 254, 47);
		contentPane.add(btnNewButton);
		
		JButton btnLoginAsInstitution = new JButton("Register ID");
		btnLoginAsInstitution.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                StudentID_storeGUI mainFrame = new StudentID_storeGUI();
                mainFrame.setVisible(true);
                dispose();
			}
		});
		btnLoginAsInstitution.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnLoginAsInstitution.setBounds(103, 141, 254, 47);
		contentPane.add(btnLoginAsInstitution);
		
		JButton btnViewCertificate = new JButton("View Certificate &Transcript");
		btnViewCertificate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                bcd_decrypt_viewstu mainFrame = new bcd_decrypt_viewstu();
                mainFrame.setVisible(true);
                dispose();
			}
		});
		btnViewCertificate.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnViewCertificate.setBounds(103, 255, 254, 47);
		contentPane.add(btnViewCertificate);
		
		JButton btnback = new JButton("Back");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                Main mainFrame = new Main();
                mainFrame.setVisible(true);
                dispose();
			}
		});
		btnback.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnback.setBounds(354, 10, 85, 21);
		contentPane.add(btnback);
		
		JButton btnViewId = new JButton("View ID");
		btnViewId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                StudentID_viewGUI mainFrame = new StudentID_viewGUI();
                mainFrame.setVisible(true);
                dispose();
			}
		});
		btnViewId.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnViewId.setBounds(103, 198, 254, 47);
		contentPane.add(btnViewId);
	}
}
