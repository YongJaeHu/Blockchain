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
import java.beans.PropertyChangeEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Course_storeGUI extends JFrame {

	private JPanel contentPane;
	private JTextField nametextField;
	private JTextField idtextField;
	
	private static String masterFolder = "src/Course_master/";
	private static String fileName = masterFolder+"Course_chain.bin";
	public static final String LEDGER_FILE = masterFolder + "Course_Ledger.txt";
	private JTextField detailtextField;
	private JTextField topictextField;
	private JTextField insnametextField;
	private JTextField acanametextField;
	private JTextField reviewtextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Course_storeGUI frame = new Course_storeGUI();
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
	public Course_storeGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 625);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Course Storage");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(150, 39, 216, 81);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Course Name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(37, 123, 155, 60);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Course ID:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(37, 165, 155, 60);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Instructor Name:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(37, 296, 155, 60);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Rating:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1.setBounds(37, 395, 155, 60);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		nametextField = new JTextField();
		nametextField.setBounds(197, 143, 301, 30);
		contentPane.add(nametextField);
		nametextField.setColumns(10);
		
		idtextField = new JTextField();
		idtextField.setBounds(197, 185, 301, 30);
		contentPane.add(idtextField);
		idtextField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"5.0", "4.0", "3.0", "2.0", "1.0"}));
		comboBox.setBounds(197, 411, 95, 30);
		contentPane.add(comboBox);
		
		JButton btnbc = new JButton("Store");
		btnbc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Input Validation
		        String name = nametextField.getText().trim();
		        String id = idtextField.getText().trim();
		        String detail = detailtextField.getText().trim();
		        String topic = topictextField.getText().trim();
		        String insname = insnametextField.getText().trim();
		        String acaname = acanametextField.getText().trim();
		        String rating = (String) comboBox.getSelectedItem();
		        String review = reviewtextField.getText().trim();
		        if (name.isEmpty() || id.isEmpty()|| detail.isEmpty()|| topic.isEmpty()|| insname.isEmpty()|| acaname.isEmpty()|| review.isEmpty()) {
		            JOptionPane.showMessageDialog(contentPane, "The fields cannot be blank", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		            
		        }
				else {
					String plainID = String.format("%s|%s|%s|%s|%s|%s|%s|%s",name,id,detail,topic,insname,acaname, rating,review);
					

		        coursedata.Blockchain bc = coursedata.Blockchain.getInstance(fileName);

		        if (!new File(masterFolder).exists()) {
		            System.err.println("> creating Blockchain binary!");
		            new File(masterFolder).mkdir();
		            bc.genesis();
		        } else {
		            
		            String line1 = (name + "|" + id + "|" + detail + "|"+ topic + "|" + insname + "|"+ acaname + "|"+ rating +"|"+ review + "|");

		            coursedata.Course tranxLst = new coursedata.Course();
		            tranxLst.add(line1);

		            String previousHash = bc.get().getLast().getBlockHeader().getCurrentHash();
		            coursedata.Block b1 = new coursedata.Block(previousHash);
		            b1.setTranxLst(tranxLst);
		            bc.nextBlock(b1);
		            System.out.println(b1);
		            bc.distribute();

		            // Show a success message
		            JOptionPane.showMessageDialog(contentPane, "Course Data is successfully added to the blockchain!");
		        }
			}
			}
		});
		btnbc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnbc.setBounds(197, 522, 130, 30);
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
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Course Detail:");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_2.setBounds(37, 204, 155, 60);
		contentPane.add(lblNewLabel_1_1_2);
		
		detailtextField = new JTextField();
		detailtextField.setColumns(10);
		detailtextField.setBounds(197, 225, 301, 30);
		contentPane.add(detailtextField);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Academy Name:");
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1_2.setBounds(37, 349, 155, 60);
		contentPane.add(lblNewLabel_1_1_1_2);
		
		topictextField = new JTextField();
		topictextField.setColumns(10);
		topictextField.setBounds(197, 272, 301, 30);
		contentPane.add(topictextField);
		
		insnametextField = new JTextField();
		insnametextField.setColumns(10);
		insnametextField.setBounds(197, 316, 301, 30);
		contentPane.add(insnametextField);
		
		acanametextField = new JTextField();
		acanametextField.setColumns(10);
		acanametextField.setBounds(197, 369, 301, 30);
		contentPane.add(acanametextField);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Topic:");
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_2_1.setBounds(37, 252, 155, 60);
		contentPane.add(lblNewLabel_1_1_2_1);
		
		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("Review:");
		lblNewLabel_1_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1_2_1.setBounds(37, 445, 155, 60);
		contentPane.add(lblNewLabel_1_1_1_2_1);
		
		reviewtextField = new JTextField();
		reviewtextField.setColumns(10);
		reviewtextField.setBounds(197, 465, 301, 30);
		contentPane.add(reviewtextField);
	
	}
}
