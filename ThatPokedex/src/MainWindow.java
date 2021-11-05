import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import javax.swing.ListCellRenderer;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JPanel;

class PokemonCellRenderer extends JLabel implements ListCellRenderer {
	private static final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);
	
	public PokemonCellRenderer() {
		setOpaque(true);
		setIconTextGap(12);
	}

	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		// TODO Auto-generated method stub
		Pokemon pokemon = (Pokemon) value;
		setText(pokemon.getName());
		System.out.println(pokemon.getName());
		System.out.println(pokemon.getVisibility());
		if (pokemon.getVisibility() == false) {
			System.out.println("INVISIBLE");
			setBackground(Color.red);
			setForeground(Color.black);
		}
		if (isSelected) {
			setBackground(HIGHLIGHT_COLOR);
			setForeground(Color.white);
		}
		else {
			setBackground(Color.white);
			setForeground(Color.black);
		}
		return this;
	}
	
}

public class MainWindow extends JFrame {

		/**
		 * Launch the application.
		 */
	   public static void main(String[] args) {
	      EventQueue.invokeLater(
	         new Runnable() {
	            public void run() {
	               try {
	                  MainWindow window = new MainWindow();
	                  window.setVisible(true);
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
	   public MainWindow() throws SQLException {
		   Database db = new Database();
		   ArrayList<Pokemon> pokemonList = db.getPokemon();
		   
		   
		   DefaultListModel<Pokemon> model = new DefaultListModel<>();
		   
		   // ---- Refresh archived.
		   ArrayList<Pokemon> archived = new ArrayList<>();
		   for (int i = 0; i < pokemonList.size(); i++) {
			   if (pokemonList.get(i).getVisibility() == false) {
				   archived.add(pokemonList.get(i));
				   continue;
			   }
			   model.addElement(pokemonList.get(i));
		   }
		   for (int i = 0; i < archived.size(); i++) {
			   model.addElement(archived.get(i));
		   }
		   // ---- end refresh archived.

		   setSize(500, 500);
		   JButton btn = new JButton("Select");
		   getContentPane().setLayout(new FlowLayout());
		   
		   JScrollPane scrollPane = new JScrollPane();
		   scrollPane.setBounds(20, 21, 230, 307);
		 
		   
		   JList<Pokemon> list = new JList(model);
		   list.setCellRenderer(new PokemonCellRenderer());
		   
		   btn.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	int index = list.getSelectedIndex();
	            	Pokemon pkm = list.getSelectedValue();
	            	String sampleText = "Pokemon: " + pkm.getName() + "\nTypes: " + pkm.getTypes() + "\nGeneration: " + pkm.getGeneration() + "\nWeight: " + pkm.getWeight() + "\nSize: " + pkm.getSize();
	                System.out.print(sampleText);
	                // -- dialog class
	                JDialog jd = new JDialog();
	                jd.setBounds(500, 300, 400, 300);
	                JLabel jLabel = new JLabel(sampleText);
	                jd.add(jLabel);
	                // -- end dialog class.
//	            	JOptionPane.showMessageDialog(MainWindow.this, sampleText, "Hey", JOptionPane.INFORMATION_MESSAGE);
	                jd.setVisible(true);
	            }
	        });
		   scrollPane.setViewportView(list);
		   getContentPane().add(scrollPane);
		   getContentPane().add(btn);
			
//		   initialize();
	   }

		/**
		 * Initialize the contents of the frame.
		 */
	   private void initialize() {
//		   frmThatPokedex = new JFrame("That Pokedex");
//		   JPanel p = new JPanel();
//		   setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
//		   frmThatPokedex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		   frmThatPokedex.add(new JButton("hi"));
//		   frmThatPokedex.add(new JButton("bye"));
//		   frmThatPokedex.setSize(500, 500);
		   
//	      frmThatPokedex = new JFrame();
//	      frmThatPokedex.setTitle("That Pokedex - Admin");
//	      frmThatPokedex.setBounds(100, 100, 579, 576);
//	      frmThatPokedex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	      frmThatPokedex.getContentPane().setLayout(null);
	   
	   }
}