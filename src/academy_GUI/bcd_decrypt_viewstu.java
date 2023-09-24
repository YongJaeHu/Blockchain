package academy_GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Menu_GUI.StudentM;
import bcd_solution_crypto.Asymmetric;
import bcd_solution_crypto.DecryptAndWrite;
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

public class bcd_decrypt_viewstu extends JFrame {

	private JPanel contentPane;
	private JTextField IdtextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bcd_decrypt_viewstu frame = new bcd_decrypt_viewstu();
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
	public bcd_decrypt_viewstu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 674, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Associated Cert Verifier - Decrypt ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(93, 10, 480, 49);
		contentPane.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(55, 245, 548, 124);
		contentPane.add(textArea);
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Decrypt and write to file
		        String fileName = "src/masterFile/Decrypted_text.txt";
		        try {
		            DecryptAndWrite.decryptAndWriteToFile(fileName);
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
				            textArea.append(line + "\n"); // append the line to the text area
				            idFound = true;
				        }
				    }
				    if (!idFound) {
				        textArea.setText("ID not found."); // display a message if the ID is not found
				    }
				} catch (Exception ex) {
				    ex.printStackTrace();
				}
			}
		});
		btnView.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnView.setBounds(456, 160, 105, 35);
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
		btnBack.setBounds(524, 452, 105, 35);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Student ID here: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(51, 153, 218, 49);
		contentPane.add(lblNewLabel_1);
		
		IdtextField = new JTextField();
		IdtextField.setBounds(224, 167, 200, 25);
		contentPane.add(IdtextField);
		IdtextField.setColumns(10);
	}
}
