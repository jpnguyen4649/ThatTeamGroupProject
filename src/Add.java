import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;

public class Add {

	private JFrame frmThatAdd;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add window = new Add();
					window.frmThatAdd.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public Add() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmThatAdd = new JFrame();
		frmThatAdd.setTitle("That Add");
		frmThatAdd.setBounds(100, 100, 450, 300);
		frmThatAdd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmThatAdd.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(48, 21, 70, 35);
		frmThatAdd.getContentPane().add(lblNewLabel);
		
		JLabel lblType = new JLabel("Type :");
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblType.setBounds(48, 52, 70, 35);
		frmThatAdd.getContentPane().add(lblType);
		
		JLabel lblGeneration = new JLabel("Generation :");
		lblGeneration.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGeneration.setBounds(48, 83, 89, 35);
		frmThatAdd.getContentPane().add(lblGeneration);
		
		JLabel lblWeight = new JLabel("Weight :");
		lblWeight.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblWeight.setBounds(48, 115, 89, 35);
		frmThatAdd.getContentPane().add(lblWeight);
		
		JLabel lblSize = new JLabel("Size :");
		lblSize.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSize.setBounds(48, 145, 89, 35);
		frmThatAdd.getContentPane().add(lblSize);
		
		textField = new JTextField();
		textField.setBounds(135, 31, 188, 19);
		frmThatAdd.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(135, 62, 188, 19);
		frmThatAdd.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(135, 93, 188, 19);
		frmThatAdd.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(135, 125, 188, 19);
		frmThatAdd.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(135, 155, 188, 19);
		frmThatAdd.getContentPane().add(textField_4);
		
		DefaultListModel model = new DefaultListModel();
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//This is the code to add the Pokemon that the admin inputted
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(234, 184, 89, 26);
		frmThatAdd.getContentPane().add(btnNewButton);
		
		//Back button is made to go back to the Admin's pokedex
		JButton btnCancdel = new JButton("Back");
		btnCancdel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThatPokedexAdmin admin = new ThatPokedexAdmin(); 
				try {
					ThatPokedexAdmin.main(null);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frmThatAdd.dispose();
			}
		});
		btnCancdel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancdel.setBounds(333, 227, 89, 26);
		frmThatAdd.getContentPane().add(btnCancdel);
		
		//Reset button is made to erase everything that you inputted
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnReset.setBounds(135, 184, 89, 26);
		frmThatAdd.getContentPane().add(btnReset);
	}
}
