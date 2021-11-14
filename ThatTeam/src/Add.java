import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
/**
 * This class implements a pop up frame where admins can enter information about a Pokemon to be added into the database.
 * @author rachelmao
 *
 */
public class Add {

	private JFrame frmThatAdd;
	private JTextField nameField;
	private JTextField typeField;
	private JTextField genField;
	private JTextField weightField;
	private JTextField sizeField;

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
	 * @throws SQLException 
	 */
	public Add() throws SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
		Database db = Database.getInstance();
		
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
		
		nameField = new JTextField();
		nameField.setBounds(135, 31, 188, 19);
		frmThatAdd.getContentPane().add(nameField);
		nameField.setColumns(10);
		
		typeField = new JTextField();
		typeField.setColumns(10);
		typeField.setBounds(135, 62, 188, 19);
		frmThatAdd.getContentPane().add(typeField);
		
		genField = new JTextField();
		genField.setColumns(10);
		genField.setBounds(135, 93, 188, 19);
		frmThatAdd.getContentPane().add(genField);
		
		weightField = new JTextField();
		weightField.setColumns(10);
		weightField.setBounds(135, 125, 188, 19);
		frmThatAdd.getContentPane().add(weightField);
		
		sizeField = new JTextField();
		sizeField.setColumns(10);
		sizeField.setBounds(135, 155, 188, 19);
		frmThatAdd.getContentPane().add(sizeField);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Check that text field values are valid.
				boolean validName = true;
				boolean validType = true;
				boolean validGeneration = true;
				boolean validWeight = true;
				boolean validSize = true;
				
				String name = nameField.getText();
				String type = typeField.getText();
				int gen = 0;
				float weight = 0;
				int size = 0;
				try {
					gen = Integer.parseInt(genField.getText());
				}
				catch (NumberFormatException nfe) {
					
				}
				try {
					weight = Float.parseFloat(weightField.getText());
				}
				catch (NumberFormatException nfe) {
					
				}
				try {
					size = Integer.parseInt(sizeField.getText());
				}
				catch (NumberFormatException nfe){
					
				}
				// All fields are valid.
				if (validName && validType && validGeneration && validWeight && validSize == true) {
					Pokemon pokemon = new Pokemon(name, type, gen, weight, size, true);
					if (db.addPokemon(pokemon)) {
						JOptionPane.showMessageDialog(frmThatAdd, "Successfully added Pokemon.");
						frmThatAdd.dispose();
					}
					else {
						JOptionPane.showMessageDialog(frmThatAdd, "Error in adding Pokemon. Please try again.");
					}
				}
				// Fields have error.
				else {
					
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(234, 184, 89, 26);
		frmThatAdd.getContentPane().add(btnNewButton);
		
		//Back button is made to go back to the Admin's pokedex
		JButton btnCancdel = new JButton("Back");
		btnCancdel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MainWindow main = new MainWindow();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
	            MainWindow.main(null);
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
				nameField.setText(null);
				typeField.setText(null);
				genField.setText(null);
				weightField.setText(null);
				sizeField.setText(null);
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnReset.setBounds(135, 184, 89, 26);
		frmThatAdd.getContentPane().add(btnReset);
	}
}
