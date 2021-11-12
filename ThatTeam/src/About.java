import java.awt.EventQueue;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.*;
/**
 * This class implements the About window.
 * @author rachelmao
 *
 */
public class About {
	private JFrame frame;
	private JFrame frmThatAboutPage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About window = new About();
					window.frmThatAboutPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public About() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmThatAboutPage = new JFrame();
		frmThatAboutPage.setTitle("That About Page");
		frmThatAboutPage.setBounds(100, 100, 452, 395);
		frmThatAboutPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmThatAboutPage.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CSC131 Fall 2021");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(111, 10, 206, 44);
		frmThatAboutPage.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("This program was made by That Team:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(58, 43, 316, 33);
		frmThatAboutPage.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Antonio Abaya");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setBounds(166, 72, 103, 33);
		frmThatAboutPage.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Brian Shao");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(166, 92, 77, 33);
		frmThatAboutPage.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Christian Smith");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2.setBounds(166, 115, 112, 26);
		frmThatAboutPage.getContentPane().add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Dongjin Li");
		lblNewLabel_2_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_1.setBounds(166, 135, 77, 26);
		frmThatAboutPage.getContentPane().add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("Ernesto Rosas");
		lblNewLabel_2_2_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_1_1.setBounds(166, 151, 112, 33);
		frmThatAboutPage.getContentPane().add(lblNewLabel_2_2_1_1);
		
		JLabel lblNewLabel_2_2_1_1_1 = new JLabel("Jessica Nguyen");
		lblNewLabel_2_2_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_1_1_1.setBounds(166, 171, 219, 33);
		frmThatAboutPage.getContentPane().add(lblNewLabel_2_2_1_1_1);
		
		JLabel lblNewLabel_2_2_1_1_1_1 = new JLabel("Kaitlyn Elise Yu");
		lblNewLabel_2_2_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_1_1_1_1.setBounds(166, 194, 112, 26);
		frmThatAboutPage.getContentPane().add(lblNewLabel_2_2_1_1_1_1);
		
		JLabel lblNewLabel_2_2_1_1_1_1_1 = new JLabel("Rachel Mao");
		lblNewLabel_2_2_1_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_1_1_1_1_1.setBounds(166, 214, 151, 26);
		frmThatAboutPage.getContentPane().add(lblNewLabel_2_2_1_1_1_1_1);
		
		JLabel lblNewLabel_2_2_1_1_1_1_1_1 = new JLabel("Tory Petersen");
		lblNewLabel_2_2_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_1_1_1_1_1_1.setBounds(166, 230, 112, 33);
		frmThatAboutPage.getContentPane().add(lblNewLabel_2_2_1_1_1_1_1_1);
		
		
		//Adding the Back to Pokedex Button
		JButton btnNewButton = new JButton("Back to Pokedex");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmThatAboutPage.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(141, 270, 151, 38);
		frmThatAboutPage.getContentPane().add(btnNewButton);
	}

}
