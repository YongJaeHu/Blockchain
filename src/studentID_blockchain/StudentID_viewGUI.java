package studentID_blockchain;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Menu_GUI.StudentM;
import bcd_solution_crypto.Asymmetric;
import bcd_solution_crypto.DecryptAndWrite;
import bcd_solution_crypto.Student_DecryptAndWrite;
import bcd_solution_key.KeyAccess;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class StudentID_viewGUI extends JFrame {

	private JPanel contentPane;
	private JTextField IdtextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentID_viewGUI frame = new StudentID_viewGUI();
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
	public StudentID_viewGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 882, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student ID View");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(289, 59, 232, 49);
		contentPane.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(55, 245, 782, 124);
		contentPane.add(textArea);
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Decrypt and write to file
		        String fileName = "src/studentID_master/Decrypted_text.txt";
		        try {
		            Student_DecryptAndWrite.decryptAndWriteToFile(fileName);
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
				
				//read text Field
				String id = IdtextField.getText().trim();
				
				//search for the id in the file				
				File file = new File(fileName);
				boolean idFound = false;
				try (BufferedReader br = new BufferedReader(new FileReader(file))) {
				    String line;
				    while ((line = br.readLine()) != null) {
				        if (line.contains(id)) {
				            textArea.setText(line);
				            idFound = true;
				            break;
				        }
				    }
				} catch (Exception ex) {
				    ex.printStackTrace();
				}
				
				// Display error message if ID not found
		        if (!idFound) {
		            JOptionPane.showMessageDialog(null, "ID not found. Please try another ID.", "Error", JOptionPane.ERROR_MESSAGE);
		        }
				
			}
		});
		btnView.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnView.setBounds(415, 428, 105, 35);
		contentPane.add(btnView);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                StudentM mainFrame = new StudentM();
                mainFrame.setVisible(true);
                dispose();
			}
			
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.setBounds(732, 21, 105, 35);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Student ID here: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(175, 153, 218, 49);
		contentPane.add(lblNewLabel_1);
		
		IdtextField = new JTextField();
		IdtextField.setBounds(352, 167, 200, 25);
		contentPane.add(IdtextField);
		IdtextField.setColumns(10);
	}
}
