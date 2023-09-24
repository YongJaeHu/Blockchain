package Menu_GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import academy_GUI.bcd_decrypt_viewemp;
import academy_GUI.bcd_decrypt_viewstu;
import hash.Employer_loginGUI;

import hash.Student_loginGUI;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Employer extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employer frame = new Employer();
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
	public Employer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 261);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Employer Pages");
		lblNewLabel.setBounds(130, 51, 195, 37);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Verify Certificate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                bcd_decrypt_viewemp mainFrame = new bcd_decrypt_viewemp();
                mainFrame.setVisible(true);
                dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(130, 126, 195, 47);
		contentPane.add(btnNewButton);
		
		JButton btnback = new JButton("Back");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	                Main mainFrame = new Main();
	                mainFrame.setVisible(true);
	                dispose();
	            }
		});
		btnback.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnback.setBounds(352, 10, 85, 21);
		contentPane.add(btnback);
	}
}
