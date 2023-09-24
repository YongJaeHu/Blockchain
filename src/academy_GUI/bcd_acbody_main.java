package academy_GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Menu_GUI.Main;
import Menu_GUI.StudentM;
import coursedata.Course_storeGUI;
import coursedata.Course_viewsacaGUI;
import coursedata.Learning_storeGUI;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class bcd_acbody_main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bcd_acbody_main frame = new bcd_acbody_main();
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
	public bcd_acbody_main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Accrediting Body");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(135, 10, 280, 96);
		contentPane.add(lblNewLabel);
		
		JButton btnTranscript = new JButton("Add Transcript");
		btnTranscript.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnTranscript.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				bcd_acbody_store_trans frame1 = new bcd_acbody_store_trans();
				frame1.setVisible(true);
			}
		});
		btnTranscript.setBounds(128, 276, 257, 48);
		contentPane.add(btnTranscript);
		
		JButton btnCert = new JButton("Add Certificate");
		btnCert.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnCert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				bcd_acbody_store_cer frame2 = new bcd_acbody_store_cer();
				frame2.setVisible(true);
			}
		});
		btnCert.setBounds(128, 334, 257, 48);
		contentPane.add(btnCert);
		
		JButton btnView = new JButton("View Transcript & Certificate");
		btnView.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				bcd_acbody_view frame = new bcd_acbody_view();
				frame.setVisible(true);
			}
		});
		btnView.setBounds(128, 398, 257, 48);
		contentPane.add(btnView);
		
		JButton btnClose = new JButton("Log Out");
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "> Logged Out! ");
				dispose();
				
				//Compile
//				
				Main frame = new Main();
				frame.setVisible(true);
			}
		});
		btnClose.setBounds(417, 10, 98, 35);
		contentPane.add(btnClose);
		
		JButton btnNewButton = new JButton("Add Course Data");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                Course_storeGUI mainFrame = new Course_storeGUI();
                mainFrame.setVisible(true);
                dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(128, 101, 257, 47);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View Course Details");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                Course_viewsacaGUI mainFrame = new Course_viewsacaGUI();
                mainFrame.setVisible(true);
                dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_1.setBounds(128, 219, 257, 47);
		contentPane.add(btnNewButton_1);
		
		JButton btnLoginAsEmployer = new JButton("Add Learning Materials");
		btnLoginAsEmployer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                Learning_storeGUI mainFrame = new Learning_storeGUI();
                mainFrame.setVisible(true);
                dispose();
			}
		});
		btnLoginAsEmployer.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnLoginAsEmployer.setBounds(128, 162, 257, 47);
		contentPane.add(btnLoginAsEmployer);
	}
}
