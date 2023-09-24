package academy_GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import academy_blockchain.Block;
import academy_blockchain.Blockchain;
import bcd_solution_crypto.Asymmetric;
import bcd_solution_crypto.Decrypt;
import bcd_solution_crypto.DecryptAndWrite;
import bcd_solution_key.KeyAccess;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.util.LinkedList;
import java.util.List;
import java.awt.event.ActionEvent;

public class bcd_acbody_view extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bcd_acbody_view frame = new bcd_acbody_view();
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
	public bcd_acbody_view() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 529);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 121, 594, 300);
		contentPane.add(textArea);
		
		JLabel lblNewLabel = new JLabel("Blockchain Data");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(190, 42, 218, 51);
		contentPane.add(lblNewLabel);
		
		JButton btnShow = new JButton("Show All");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
				String fileName = "src/masterFile/Decrypted_text.txt";
		        try {
		            // Decrypt and write to file
		            DecryptAndWrite.decryptAndWriteToFile(fileName);

		            // Read decrypted text from file and display in text area
		            File file = new File(fileName);
		            BufferedReader br = new BufferedReader(new FileReader(file));
		            String line;
		            StringBuilder sb = new StringBuilder();
		            while ((line = br.readLine()) != null) {
		                sb.append(line).append("\n");
		            }
		            textArea.setText(sb.toString());

		            // Close the reader
		            br.close();
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		    }
		});
		btnShow.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnShow.setBounds(264, 453, 133, 29);
		contentPane.add(btnShow);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				dispose();
				bcd_acbody_main frame = new bcd_acbody_main();
				frame.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.setBounds(407, 453, 133, 29);
		contentPane.add(btnBack);
	}
}
