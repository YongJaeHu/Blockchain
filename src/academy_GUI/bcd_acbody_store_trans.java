package academy_GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import academy_blockchain.Block;
import academy_blockchain.Blockchain;
import academy_blockchain.Transaction;
import bcd_solution_signature.DigitalSignature;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class bcd_acbody_store_trans extends JFrame {
	//Transcript
	private JPanel contentPane;
	private JTextField IdtextField;
	private JTextField NametextField;
	private JTextField CgpatextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bcd_acbody_store_trans frame = new bcd_acbody_store_trans();
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
	public bcd_acbody_store_trans() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 722, 627);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Accredit -BlockChain Transcript ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(135, 10, 475, 117);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("StudentID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(27, 124, 114, 48);
		contentPane.add(lblNewLabel_1);
		
		IdtextField = new JTextField();
		IdtextField.setBounds(218, 138, 356, 27);
		contentPane.add(IdtextField);
		IdtextField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("StudentName");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(27, 182, 114, 48);
		contentPane.add(lblNewLabel_1_1);
		
		NametextField = new JTextField();
		NametextField.setBounds(218, 196, 356, 27);
		contentPane.add(NametextField);
		NametextField.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Online Degree Course");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(27, 241, 220, 48);
		contentPane.add(lblNewLabel_1_1_1);
		
		JComboBox CoursecomboBox = new JComboBox();
		CoursecomboBox.setModel(new DefaultComboBoxModel(new String[] {"", "InformationTechnology(IT)", "SoftwareEngineering(SE)", "Accounting&Finance(AF)"}));
		CoursecomboBox.setBounds(218, 252, 356, 27);
		contentPane.add(CoursecomboBox);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Course ID");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_1_1.setBounds(27, 299, 173, 48);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JComboBox StatuscomboBox = new JComboBox();
		StatuscomboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Graduated", "Pending"}));
		StatuscomboBox.setBounds(218, 371, 144, 27);
		contentPane.add(StatuscomboBox);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Status");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_1_1_1.setBounds(27, 357, 173, 48);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		JComboBox subidcomboBox = new JComboBox();
		subidcomboBox.setModel(new DefaultComboBoxModel(new String[] {"", "2019ITFT", "2020IT", "2021SE"}));
		subidcomboBox.setBounds(218, 310, 356, 27);
		contentPane.add(subidcomboBox);
		
		CgpatextField = new JTextField();
		CgpatextField.setBounds(218, 431, 96, 27);
		contentPane.add(CgpatextField);
		CgpatextField.setColumns(10);
		
		JButton btnAdd = new JButton("Sign & Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = IdtextField.getText().trim();
		        String name = NametextField.getText().trim();
		        String sub = (String)CoursecomboBox.getSelectedItem();
		        String subid = (String)subidcomboBox.getSelectedItem();
		        String stat = (String)StatuscomboBox.getSelectedItem();
		        String cgpa = CgpatextField.getText().trim();
				
		        //validation - data input cannot be empty
				if(id.isEmpty() || name.isEmpty() || sub.isEmpty() || subid.isEmpty() || stat.isEmpty() || cgpa.isEmpty() ) {
					JOptionPane.showMessageDialog(contentPane, "Please fill in all fields");
				}
				else {
					String plainCert = String.format("%s|%s|%s|%s|%s|%s",id,name,sub,subid,stat,cgpa);
					
					//Do Encrypt
					try {
						//call method SignedDoc: to return Encrypted Certificate
						String encCert = DigitalSignature.SignedDoc(plainCert);
						Transaction CertList = new Transaction();
						
						//validation make sure enCert got value
						if (encCert != null) {
							CertList.add(encCert);
							}
						
						// Check if the blockchain already exists
						boolean blockchainExists = Blockchain.get() != null;
						
						if (!blockchainExists) {
							new File(Blockchain.MASTER_BLOCKCHAIN).mkdir();
							Blockchain.genesis();
						}
						
						List<Transaction> transactions = new ArrayList<>();
						transactions.add(CertList);
						
						System.out.println("Transactions: " +transactions);
						
						//add transactions to Blockchain
						for (Transaction transaction : transactions) {
							
							String masterFile = "src/masterFile";
							String fileName = masterFile+"Aca_Blockchain.txt";
							Blockchain bc = Blockchain.getInstance( fileName );
							String line1 = (name + "|" + id + "|" + sub + "|" + subid + "|" + stat + "|"  + cgpa);
							
							academy_blockchain.Transaction tranxLst = new academy_blockchain.Transaction();
							tranxLst.add(line1);
							CertList.complete();
							
							String previousHash = Blockchain.get().getLast().getBlockHeader().getCurrentHash();
					        Block b1 = new Block( previousHash, CertList.getMerkleRoot() );
					        b1.setTranxLst(CertList);
					        bc.nextBlock(b1);
					        
						}
						
						Blockchain.distribute();
						
						JOptionPane.showMessageDialog(null, "> Transcript record is created! ");
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}				
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdd.setBounds(401, 531, 114, 36);
		contentPane.add(btnAdd);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				bcd_acbody_main frame = new bcd_acbody_main();
				frame.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setBounds(536, 531, 114, 36);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("CGPA");
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_1_2.setBounds(27, 417, 220, 48);
		contentPane.add(lblNewLabel_1_1_1_2);
		
		
	}
}
