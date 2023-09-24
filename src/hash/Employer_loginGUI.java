package hash;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Menu_GUI.Employer;
import Menu_GUI.Main;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.LinkedList;
import java.util.List;
import java.beans.PropertyChangeEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Employer_loginGUI extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private static final byte[] SALT = {-123, 45, 67, 89, -10, 12, -123, 45, 67, 89, -10, 12};

	private JPanel contentPane;
	private JTextField nametextField;
	private JTextField idtextField;
	
	private static String masterFolder = "src/transcript_master/";
	private static String fileName = masterFolder+"Transcript_chain.bin";
	public static final String LEDGER_FILE = masterFolder + "Transcript_Ledger.txt";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employer_loginGUI frame = new Employer_loginGUI();
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
	public Employer_loginGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 538, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Employer Login Page");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(137, 33, 310, 81);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(37, 103, 155, 60);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(37, 160, 155, 60);
		contentPane.add(lblNewLabel_1_1);
		
		nametextField = new JTextField();
		nametextField.setBounds(197, 123, 301, 30);
		contentPane.add(nametextField);
		nametextField.setColumns(10);
		
		idtextField = new JTextField();
		idtextField.setBounds(197, 173, 301, 30);
		contentPane.add(idtextField);
		idtextField.setColumns(10);
		
		JButton btnbc = new JButton("Store");
		btnbc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Input Validation
		        String email = nametextField.getText().trim();
		        String password = idtextField.getText().trim();
		        if (email.isEmpty() || password.isEmpty()) {
		            JOptionPane.showMessageDialog(contentPane, "The fields cannot be blank", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }else {
		            
		            ArrayList<Student> students = new ArrayList<Student>();
		            students.add(new Student("boss1@example.com", "Boss123"));
		            students.add(new Student("boss2@example.com", "Boss456"));

		            for (Student s : students) {
		                String saltedData = s.getSensitiveData() + new String(SALT, StandardCharsets.UTF_8);
		                String hashedData = Hasher.sha256_salted(saltedData, SALT);
		                s.setHashedData(hashedData);
		            }

		            String saltedData = email + password + new String(SALT, StandardCharsets.UTF_8);
		            String hashedData = Hasher.sha256_salted(saltedData, SALT);

		            boolean found = false;
		            for (Student s : students) {
		                if (s.getHashedData().equals(hashedData)) {
		                	JOptionPane.showMessageDialog(contentPane, "Login Successfully");
		                    found = true;
			                Employer mainFrame = new Employer();
			                mainFrame.setVisible(true);
			                dispose();
		                    break;
		                }
		            }           
		            if (!found) {
		            	JOptionPane.showMessageDialog(contentPane,"Login failed: invalid email or password");
		            }

		        }
			}
        });
		btnbc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnbc.setBounds(197, 235, 130, 30);
		contentPane.add(btnbc);
	    
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JButton btnback = new JButton("Back");
        btnback.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main mainFrame = new Main();
                mainFrame.setVisible(true);
                dispose();
            }
        });		
		btnback.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnback.setBounds(431, 10, 85, 21);
		contentPane.add(btnback);
	}
}
