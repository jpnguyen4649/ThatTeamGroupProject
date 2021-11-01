import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Archive {

	private JFrame frmThatArchive;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Archive window = new Archive();
					window.frmThatArchive.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Archive() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmThatArchive = new JFrame();
		frmThatArchive.setTitle("That Archive");
		frmThatArchive.setBounds(100, 100, 450, 300);
		frmThatArchive.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmThatArchive.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter the name of the Pokemon you would like to Archive :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(35, 32, 379, 52);
		frmThatArchive.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(90, 90, 47, 22);
		frmThatArchive.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(147, 92, 197, 22);
		frmThatArchive.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Archive");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//This is the code to make the archive happen
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(129, 139, 91, 33);
		frmThatArchive.getContentPane().add(btnNewButton);
		
		//Made the back button to go back to the admin's Pokedex
		JButton btnCancel = new JButton("Back");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThatPokedexAdmin admin = new ThatPokedexAdmin();
				ThatPokedexAdmin.main(null);
				frmThatArchive.dispose();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancel.setBounds(230, 139, 91, 33);
		frmThatArchive.getContentPane().add(btnCancel);
	}

}
