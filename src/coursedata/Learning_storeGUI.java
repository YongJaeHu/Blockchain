package coursedata;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Menu_GUI.Main;
import academy_GUI.bcd_acbody_main;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.LinkedList;
import java.util.List;
import java.beans.PropertyChangeEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Learning_storeGUI extends JFrame {

	private JPanel contentPane;
	private JTextField nametextField;
	
	private static String masterFolder = "src/Course_master/";
	private static String fileName = masterFolder+"Course_chain.bin";
	public static final String LEDGER_FILE = masterFolder + "Course_Ledger.txt";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Learning_storeGUI frame = new Learning_storeGUI();
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
	public Learning_storeGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Learning Resources & Summative Assessment Storage");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(22, 33, 494, 81);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(37, 117, 155, 60);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Course Name:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(37, 183, 155, 60);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Status:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1.setBounds(37, 307, 155, 60);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		nametextField = new JTextField();
		nametextField.setBounds(197, 137, 301, 30);
		contentPane.add(nametextField);
		nametextField.setColumns(10);
		
		JComboBox courseNamecomboBox = new JComboBox();
		courseNamecomboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		courseNamecomboBox.setModel(new DefaultComboBoxModel(new String[] {"", "InformationTechnology(IT)", "SoftwareEngineering(SE)", "Accounting&Finance(AF)"}));
		courseNamecomboBox.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
			}
		});
		courseNamecomboBox.setBounds(197, 201, 301, 30);
		contentPane.add(courseNamecomboBox);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Not Started", "Ongoing", "Finished"}));
		comboBox.setBounds(202, 323, 125, 30);
		contentPane.add(comboBox);
		JComboBox courseIDcomboBox = new JComboBox();
		courseIDcomboBox.setModel(new DefaultComboBoxModel(new String[] {"", "2019ITFT", "2020IT", "2021SE"}));
		courseIDcomboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		courseIDcomboBox.setBounds(197, 267, 301, 30);
		contentPane.add(courseIDcomboBox);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Course ID:");
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1_2.setBounds(37, 249, 155, 60);
		contentPane.add(lblNewLabel_1_1_1_2);
		
		JButton btnbc = new JButton("Store");
		btnbc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Input Validation
		        String name = nametextField.getText().trim();
		        if (name.isEmpty()) {
		            JOptionPane.showMessageDialog(contentPane, "The fields cannot be blank", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        coursedata.Blockchain bc = coursedata.Blockchain.getInstance(fileName);

		        if (!new File(masterFolder).exists()) {
		            System.err.println("> creating Blockchain binary!");
		            new File(masterFolder).mkdir();
		            bc.genesis();
		        } else {
		            String couname = (String) courseNamecomboBox.getSelectedItem();
		            String couID = (String) courseIDcomboBox.getSelectedItem();
		            String status = (String) comboBox.getSelectedItem();
		            
		            String line1 = (name +  "|"+ couname + "|" + couID + "|"+ status);

		            coursedata.Course tranxLst = new coursedata.Course();
		            tranxLst.add(line1);

		            String previousHash = bc.get().getLast().getBlockHeader().getCurrentHash();
		            coursedata.Block b1 = new coursedata.Block(previousHash);
		            b1.setTranxLst(tranxLst);
		            bc.nextBlock(b1);
		            System.out.println(b1);
		            bc.distribute();

		            // Show a success message
		            JOptionPane.showMessageDialog(contentPane, "Learning Material and Summative Assessment is successfully updated to the blockchain!");
		        }
			}
        });
		btnbc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnbc.setBounds(197, 394, 130, 30);
		contentPane.add(btnbc);
	    
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JButton btnback = new JButton("Back");
        btnback.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bcd_acbody_main mainFrame = new bcd_acbody_main();
                mainFrame.setVisible(true);
                dispose();
            }
        });		
		btnback.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnback.setBounds(431, 10, 85, 21);
		contentPane.add(btnback);
	}
}
