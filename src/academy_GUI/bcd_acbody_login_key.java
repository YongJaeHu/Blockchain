package academy_GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Menu_GUI.Main;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class bcd_acbody_login_key extends JFrame {

	private JPanel contentPane;
	private JTextField usernametextField;
	private JPasswordField acbpasswordField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bcd_acbody_login_key frame = new bcd_acbody_login_key();
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
	public bcd_acbody_login_key() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Accrediting Bodies Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(94, 46, 354, 70);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(35, 162, 121, 47);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20)); 
		lblNewLabel_1_1.setBounds(35, 230, 121, 47);
		contentPane.add(lblNewLabel_1_1);
		
		usernametextField = new JTextField();
		usernametextField.setBounds(150, 171, 260, 37);
		contentPane.add(usernametextField);
		usernametextField.setColumns(10);
		
		acbpasswordField = new JPasswordField();
		acbpasswordField.setBounds(150, 228, 260, 37);
		contentPane.add(acbpasswordField);
		
		JButton btnlogin = new JButton("Login");
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = usernametextField.getText().trim();
		        String pwd = acbpasswordField.getText().trim();
		        if (name.isEmpty() || pwd.isEmpty()) {
		            JOptionPane.showMessageDialog(contentPane, "Name and Password fields cannot be blank", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        else if (!name.equals("ccim") || !pwd.equals("ccim") ){
		        	JOptionPane.showMessageDialog(contentPane, "Name and Password not matched", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        else {
		        	
		        	//call key validator to check
		        	boolean result = bcd_solution_key.KeyValidator.validateKeys();
		        			        	
		            if(result == true) {
		            	
		            	// Show a success message
			            JOptionPane.showMessageDialog(contentPane, "Login Successfully!");
		            	
		            }
		            
		            //if key existed then proceed to sign and encrypt page
		            else {		            			            	
			            
			            //Generate key pairs only when false
		            	bcd_solution_key.KeyGenerator.create();
		            	byte[] publicKey = bcd_solution_key.KeyGenerator.getPublicKey().getEncoded();
		        		byte[] privateKey = bcd_solution_key.KeyGenerator.getPrivateKey().getEncoded();
		        		
		        		bcd_solution_key.KeyGenerator.putKey(publicKey, "masterFile/CCIM_PublicKey.txt");
		        		bcd_solution_key.KeyGenerator.putKey(privateKey, "masterFile/CCIM_PrivateKey.txt");
		            	// Show a success message
			            JOptionPane.showMessageDialog(contentPane, "Key Created and Login Successfully!");
			            			            
		            	
		            }
		            //Next GUI
		            dispose();
		            dispose();
		            bcd_acbody_main nframe = new bcd_acbody_main();
					nframe.setVisible(true);
		        }
			}
		});
		btnlogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnlogin.setBounds(211, 313, 85, 21);
		contentPane.add(btnlogin);
		
		JButton btnback = new JButton("Back");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	                Main mainFrame = new Main();
	                mainFrame.setVisible(true);
	                dispose();
				}
		});
		btnback.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnback.setBounds(429, 15, 85, 21);
		contentPane.add(btnback);
	}
}
