import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Login {
	
	private JFrame frmThatPokedexLogin;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmThatPokedexLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmThatPokedexLogin = new JFrame();
		frmThatPokedexLogin.setTitle("That Pokedex Login");
		frmThatPokedexLogin.setBounds(200, 200, 500, 300);
		frmThatPokedexLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmThatPokedexLogin.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to That Pokedex!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(114, 10, 268, 43);
		frmThatPokedexLogin.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Please enter a password to continue.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(114, 59, 283, 22);
		frmThatPokedexLogin.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(212, 91, 69, 22);
		frmThatPokedexLogin.getContentPane().add(lblNewLabel_2);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(132, 112, 226, 35);
		frmThatPokedexLogin.getContentPane().add(txtPassword);
		
		//Adding Login Button
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password = txtPassword.getText();
				
				if(password.equals("thatteam")) { //This is for the user's password
					txtPassword.setText(null);
					
					ThatPokedex database = new ThatPokedex(); //user's pokedex database pops up
					ThatPokedex.main(null);
					frmThatPokedexLogin.dispose();
				}
				
				else if(password.equals("root")) { //This is for the admin's password
					txtPassword.setText(null);
					
					try {
						ThatPokedexAdmin admin = new ThatPokedexAdmin();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} //admin's pokedex database pops up
					ThatPokedexAdmin.main(null);
					frmThatPokedexLogin.dispose();
				}
				
				else { //If incorrect password, it shows an error message
					JOptionPane.showMessageDialog(null, "Wrong password", "That Pokedex Login Error", JOptionPane.ERROR_MESSAGE);
					txtPassword.setText(null);
				}
			}
		});
		btnNewButton.setBounds(153, 157, 85, 27);
		frmThatPokedexLogin.getContentPane().add(btnNewButton);
		
		//Exit button is made 
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmThatPokedexLogin = new JFrame("Exit");
				
				//A confirmation message pops up if you really want to log out
				if(JOptionPane.showConfirmDialog(frmThatPokedexLogin, "Confirm if you want to exit", "That Pokedex Login",
				   JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}	
			}
		});
		btnNewButton_1.setBounds(248, 157, 85, 27);
		frmThatPokedexLogin.getContentPane().add(btnNewButton_1);
	}
}
