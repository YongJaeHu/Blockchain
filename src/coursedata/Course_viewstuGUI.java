package coursedata;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Menu_GUI.StudentM;
import bcd_solution_crypto.Asymmetric;
import bcd_solution_key.KeyAccess;

import javax.swing.JLabel;
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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Course_viewstuGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Course_viewstuGUI frame = new Course_viewstuGUI();
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
	public Course_viewstuGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 882, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Course Data");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(316, 66, 166, 49);
		contentPane.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(55, 245, 752, 124);
		contentPane.add(textArea);
		
		JComboBox CoursecomboBox = new JComboBox();
		CoursecomboBox.setModel(new DefaultComboBoxModel(new String[] {"", "2019ITFT", "2020IT", "2021SE"}));
		CoursecomboBox.setBounds(156, 166, 447, 27);
		contentPane.add(CoursecomboBox);
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//read text Field
				String id = (String)CoursecomboBox.getSelectedItem();
				
				//search for the id in the file
				String fileName = "src/Course_master/Course_Ledger.txt";
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
		btnView.setBounds(666, 452, 105, 35);
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
		btnBack.setBounds(713, 10, 105, 35);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Course ID:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(55, 152, 220, 48);
		contentPane.add(lblNewLabel_1_1_1);
		
	}
}
