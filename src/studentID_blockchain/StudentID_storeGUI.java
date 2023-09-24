package studentID_blockchain;

import bcd_solution_signature.DigitalSignature;
import studentID_blockchain.Blockchain;
import studentID_blockchain.Block;
import studentID_blockchain.StudentID;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Menu_GUI.Main;
import Menu_GUI.StudentM;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.beans.PropertyChangeEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentID_storeGUI extends JFrame {

	private JPanel contentPane;
	private JTextField nametextField;
	private JTextField idtextField;
	
	private JTextField ictextField;
	private JTextField gendertextField;
	private JTextField cnotextField;
	private JTextField emailtextField;
	private JTextField addresstextField;
	private JTextField panametextField;
	private JTextField pacnotextField;
	private JTextField paemtextField;
	
	public static String masterFolder = "src/studentID_master/";
	public static String fileName = masterFolder+"StudentID_chain.bin";
	public static final String LEDGER_FILE = masterFolder + "StudentID_Ledger.txt";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentID_storeGUI frame = new StudentID_storeGUI();
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
	public StudentID_storeGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 734);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student's ID Storage");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(166, 41, 279, 81);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Student's Name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(37, 123, 155, 60);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Student's ID:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(37, 165, 155, 60);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Course Name:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(37, 415, 155, 60);
		contentPane.add(lblNewLabel_1_1_1);
		
		nametextField = new JTextField();
		nametextField.setBounds(271, 143, 301, 30);
		contentPane.add(nametextField);
		nametextField.setColumns(10);
		
		idtextField = new JTextField();
		idtextField.setBounds(271, 185, 301, 30);
		contentPane.add(idtextField);
		idtextField.setColumns(10);
		
		JComboBox courseNamecomboBox = new JComboBox();
		courseNamecomboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		courseNamecomboBox.setModel(new DefaultComboBoxModel(new String[] {"", "InformationTechnology(IT)", "SoftwareEngineering(SE)", "Accounting&Finance(AF)"}));
		courseNamecomboBox.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
			}
		});
		courseNamecomboBox.setBounds(271, 433, 301, 30);
		contentPane.add(courseNamecomboBox);
		
		JComboBox courseIDcomboBox = new JComboBox();
		courseIDcomboBox.setModel(new DefaultComboBoxModel(new String[] {"", "2019ITFT", "2020IT", "2021SE"}));
		courseIDcomboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		courseIDcomboBox.setBounds(271, 473, 301, 30);
		contentPane.add(courseIDcomboBox);
		JLabel lblNewLabel_1_1_2 = new JLabel("IC / Passport no:");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_2.setBounds(37, 204, 155, 60);
		contentPane.add(lblNewLabel_1_1_2);
		
		ictextField = new JTextField();
		ictextField.setColumns(10);
		ictextField.setBounds(271, 225, 301, 30);
		contentPane.add(ictextField);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Course ID:");
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1_2.setBounds(37, 455, 155, 60);
		contentPane.add(lblNewLabel_1_1_1_2);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Gender:");
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_2_1.setBounds(37, 244, 155, 60);
		contentPane.add(lblNewLabel_1_1_2_1);
		
		gendertextField = new JTextField();
		gendertextField.setColumns(10);
		gendertextField.setBounds(271, 265, 301, 30);
		contentPane.add(gendertextField);
		
		cnotextField = new JTextField();
		cnotextField.setColumns(10);
		cnotextField.setBounds(271, 305, 301, 30);
		contentPane.add(cnotextField);
		
		emailtextField = new JTextField();
		emailtextField.setColumns(10);
		emailtextField.setBounds(271, 348, 301, 30);
		contentPane.add(emailtextField);
		
		addresstextField = new JTextField();
		addresstextField.setColumns(10);
		addresstextField.setBounds(271, 388, 301, 30);
		contentPane.add(addresstextField);
		
		panametextField = new JTextField();
		panametextField.setColumns(10);
		panametextField.setBounds(271, 513, 301, 30);
		contentPane.add(panametextField);
		
		pacnotextField = new JTextField();
		pacnotextField.setColumns(10);
		pacnotextField.setBounds(271, 553, 301, 30);
		contentPane.add(pacnotextField);
		
		paemtextField = new JTextField();
		paemtextField.setColumns(10);
		paemtextField.setBounds(271, 594, 301, 30);
		contentPane.add(paemtextField);
		
		JLabel lblNewLabel_1_1_2_1_1 = new JLabel("Parent / Guardian C. no:");
		lblNewLabel_1_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_2_1_1.setBounds(37, 533, 249, 60);
		contentPane.add(lblNewLabel_1_1_2_1_1);
		
		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("Contact Number:");
		lblNewLabel_1_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1_2_1.setBounds(37, 284, 155, 60);
		contentPane.add(lblNewLabel_1_1_1_2_1);
		
		JLabel lblNewLabel_1_1_1_2_2 = new JLabel("Email:");
		lblNewLabel_1_1_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1_2_2.setBounds(37, 330, 155, 60);
		contentPane.add(lblNewLabel_1_1_1_2_2);
		
		JLabel lblNewLabel_1_1_1_2_3 = new JLabel("Address:");
		lblNewLabel_1_1_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1_2_3.setBounds(37, 368, 155, 60);
		contentPane.add(lblNewLabel_1_1_1_2_3);
		
		JLabel lblNewLabel_1_1_2_1_1_1 = new JLabel("Parent / Guardian Name:");
		lblNewLabel_1_1_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_2_1_1_1.setBounds(33, 503, 249, 60);
		contentPane.add(lblNewLabel_1_1_2_1_1_1);
		
		JLabel lblNewLabel_1_1_2_1_1_2 = new JLabel("Parent / Guardian Email:");
		lblNewLabel_1_1_2_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_2_1_1_2.setBounds(37, 574, 249, 60);
		contentPane.add(lblNewLabel_1_1_2_1_1_2);
		
		JButton btnbc = new JButton("Store");
		btnbc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Input Validation
		        String name = nametextField.getText().trim();
		        String id = idtextField.getText().trim();
		        String ic = ictextField.getText().trim();
		        String gender = gendertextField.getText().trim();
		        String contact = cnotextField.getText().trim();
		        String email = emailtextField.getText().trim();
		        String address = addresstextField.getText().trim();
		        String pname = panametextField.getText().trim();
		        String pcno = pacnotextField.getText().trim();
		        String pemail = paemtextField.getText().trim();
	            String couname = (String) courseNamecomboBox.getSelectedItem();
	            String couID = (String) courseIDcomboBox.getSelectedItem();
		        
		        if (name.isEmpty() || id.isEmpty()|| ic.isEmpty()|| gender.isEmpty()|| contact.isEmpty()|| email.isEmpty()|| address.isEmpty()|| pname.isEmpty()|| pcno.isEmpty()|| pemail.isEmpty()) {
		            JOptionPane.showMessageDialog(contentPane, "The fields cannot be blank", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
				else {
					String plainID = String.format("%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s",name,id,ic,gender,contact,email,address,pname,pcno,pemail,couname,couID);
					
					//Do Encrypt
					try {
						//call method SignedDoc: to return Encrypted Certificate
						String encID = DigitalSignature.SignedDoc(plainID);
						StudentID IDList = new StudentID();
						
						//validation make sure enCert got value
						if (encID != null) {
							IDList.add(encID);
							}
						
				        studentID_blockchain.Blockchain bc = studentID_blockchain.Blockchain.getInstance(fileName);

				        if (!new File(masterFolder).exists()) {
				            System.err.println("> creating Blockchain binary!");
				            new File(masterFolder).mkdir();
				            bc.genesis();
				        } else {
							String line1 = (name + "|" + id + "|" + ic + "|"+ gender + "|" + contact + "|"+ email + "|"+ address + "|"+ couname + "|" + couID + "|"+ pname + "|"+ pcno + "|"+ pemail);
							
							studentID_blockchain.StudentID tranxLst = new studentID_blockchain.StudentID();
							tranxLst.add(line1);
							IDList.complete();
							
							String previousHash = Blockchain.get().getLast().getBlockHeader().getCurrentHash();
					        Block b1 = new Block( previousHash, IDList.getMerkleRoot() );
					        b1.setTranxLst(IDList);
					        bc.nextBlock(b1);
					        
					        }
						
						
						Blockchain.distribute();
						
						JOptionPane.showMessageDialog(null, "Student's ID is successfully added to the blockchain! ");
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}				
			}
		});
		btnbc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnbc.setBounds(216, 646, 130, 30);
		contentPane.add(btnbc);
		
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JButton btnback = new JButton("Back");
        btnback.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StudentM mainFrame = new StudentM();
                mainFrame.setVisible(true);
                dispose();
            }
        });
		btnback.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnback.setBounds(487, 10, 85, 21);
		contentPane.add(btnback);
	
	}
}
