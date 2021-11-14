import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.GridBagConstraints;

import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
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
import javax.swing.JSlider;
import javax.swing.JSplitPane;
import javax.swing.JPanel;

/**
 * This class renders the items in the JList containing Pokemon objects.
 * @author rachelmao
 *
 */
class PokemonCellRenderer extends JLabel implements ListCellRenderer  {
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
		if (pokemon.isVisible() == false) {
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

/**
 * This class implements the main window of the Pokedex.
 * @author rachelmao
 *
 */
public class MainWindow extends JFrame {
	
	boolean isAdmin;
	ArrayList<Pokemon> pokemonList;
	DefaultListModel<Pokemon> model;
	GridBagConstraints gbc = new GridBagConstraints();
	
	// Filter GUI components.
	JLabel filterLabel;
	JLabel typeFilterLabel;
	JComboBox<String> typeFilterCb;
	JLabel genFilterLabel;
	JComboBox<Integer> genFilterCb;
	JLabel sizeFilterLabel;
	JComboBox<Double> sizeFilterCb;
	//JSlider sizeFilterSlider;
	JLabel weightFilterLabel;
	//JSlider weightFilterSlider;
	JComboBox<Double> weightFilterCb;
	JButton applyFilterBtn;
	
	// List GUI components.
	JScrollPane scrollPane;
	JLabel sortLabel;
	JComboBox<String> sortCb;
	
	// Search GUI components.
	JLabel searchLabel;
	JLabel nameLabel;
	JTextField searchField;
	JButton searchBtn;
	
	// Add, Archive, Select, Logout (Control) GUI components.
	JButton addBtn;
	JButton archiveBtn;
	JButton aboutBtn;
	JButton logoutBtn;
	
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
	    * This method refreshes the Pokemon list display so that archived Pokemon appear at the bottom.
	    */
	   public void refreshArchived() {
		   model.removeAllElements();
		   ArrayList<Pokemon> archived = new ArrayList<>();
		   for (int i = 0; i < pokemonList.size(); i++) {
			   if (pokemonList.get(i).isVisible() == false) {
				   archived.add(pokemonList.get(i));
				   continue;
			   }
			   model.addElement(pokemonList.get(i));
		   }
		   if (isAdmin) {
			   for (int i = 0; i < archived.size(); i++) {
				   model.addElement(archived.get(i));
			   }
		   }
	   }
		
		/**
		 * Create the application.
		 * @throws SQLException 
		 */
	   public MainWindow() throws SQLException {
		   Database db = Database.getInstance();
		   pokemonList = db.getPokemon();
		   
		   // Set accessLevel.
		   User user = User.getInstance();
		   if (user.getAccessLevel() == 1) isAdmin = true;
		   else isAdmin = false;
		   
		   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		   model = new DefaultListModel<>();
		   refreshArchived();
		   
 
		   JList<Pokemon> list = new JList<Pokemon>(model);
		   list.setCellRenderer(new PokemonCellRenderer());

		   
		   // GUI designing.
		   setSize(450, 450);
		   setTitle("That Pokedex");
		   Container mainContainer = this.getContentPane();
		   mainContainer.setLayout(new GridBagLayout());
		   gbc.insets = new Insets(5, 5, 5, 5);
		   
		   // List Panel.
		   JPanel listPanel = new JPanel();
		   listPanel.setLayout(new GridLayout(2, 1, 5, 5));  
		   
		   scrollPane = new JScrollPane();
		   scrollPane.setViewportView(list);
		   scrollPane.setPreferredSize(new Dimension(100, 150));
		   
		   JPanel sortPanel = new JPanel();
		   sortPanel.setLayout(new FlowLayout(3, 4, 4));
		   sortLabel = new JLabel("Sort:");
		   sortLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		   
		   String[] choices = {"Select One", "Alphabetically", "Type", "Generation", "Size", "Weight"};
		   sortCb = new JComboBox<String>(choices);
		   sortPanel.add(sortLabel);
		   sortPanel.add(sortCb);
		   
		   
		   listPanel.add(scrollPane);
		   listPanel.add(sortPanel);
		   
		   
		   // Filter Panel.
		   JPanel filterPanel = new JPanel();
		   filterPanel.setLayout(new GridLayout(10, 1, 5, 5));
		   filterLabel = new JLabel("Filter:");
		   filterLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		   typeFilterLabel = new JLabel("Type");
		   genFilterLabel = new JLabel("Generation");
		   sizeFilterLabel = new JLabel("Size");
		   weightFilterLabel = new JLabel("Weight");
		   
		   typeFilterCb = new JComboBox<String>();
		   genFilterCb = new JComboBox<Integer>();
		   sizeFilterCb = new JComboBox<Double>();
		   //sizeFilterSlider = new JSlider();
		   weightFilterCb = new JComboBox<Double>();
		   //weightFilterSlider = new JSlider();
		   applyFilterBtn = new JButton("Apply");
		   filterPanel.add(filterLabel);
		   filterPanel.add(typeFilterLabel);
		   filterPanel.add(typeFilterCb);
		   filterPanel.add(genFilterLabel);
		   filterPanel.add(genFilterCb);
		   filterPanel.add(sizeFilterLabel);
		   //filterPanel.add(sizeFilterSlider);
		   filterPanel.add(sizeFilterCb);
		   filterPanel.add(weightFilterLabel);
		   filterPanel.add(weightFilterCb);
		   //filterPanel.add(weightFilterSlider);
		   filterPanel.add(applyFilterBtn);
		   
		   
		   typeFilterCb.setModel(new DefaultComboBoxModel(new String[] {"Select One", "Bug", "Bug, Fairy", "Bug, Flying", "Bug, Poison", "Dark", "Dragon", "Dragon, Psychic", "Electric", "Electric, Poison", "Fairy", "Fighting", "Fire", "Ghost ", "Ghost, Grass", "Grass", "Grass, Dragon", "Grass, Flying", "Grass, Poison", "Ground", "Ground, Psychic", "Ice", "Ice, Water", "Normal", "Normal, Fairy", "Normal, Flying", "Poison", "Poison, Flying", "Poison, Water", "Psychic", "Psychic, Fairy", "Psychic, Fire", "Psychic, Flying", "Psychic, Grass", "Rock", "Rock, Bug", "Rock, Fairy", "Rock, Grass", "Rock, Ground", "Rock, Ice", "Water", "Water, Electric", "Water, Fairy", "Water, Ground", "Water, Psychic"}));
		   genFilterCb.setModel(new DefaultComboBoxModel(new String[] {"Select One", "Generation 1", "Generation 2", "Generation 3", "Generation 4", "Generation 5", "Generation 6", "Generation 7", "Generation 8"}));
		   sizeFilterCb.setModel(new DefaultComboBoxModel(new String[] {"Select One", "~ 0 ft.", "~ 1 ft.", "~ 2 ft.", "~ 3 ft.", "> 3 ft."}));
		   weightFilterCb.setModel(new DefaultComboBoxModel(new String[] {"Select One", "0 - 10 lbs", "10 - 20 lbs", "20 - 30 lbs", "30 - 40 lbs", "50 - 60 lbs", "60 - 70 lbs", "70 - 80 lbs", "80+ lbs"}));
		   
		   applyFilterBtn.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
				   
			   }
		   });
		   
		   // Search Panel.
		   JPanel searchPanel = new JPanel();
		   searchPanel.setLayout(new GridLayout(2, 1, 5, 5));
		   searchLabel = new JLabel("Search:");
		   searchLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		   JPanel searchBarPanel = new JPanel();
		   searchBarPanel.setLayout(new FlowLayout(2, 1, 0));
//		   nameLabel = new JLabel("Name: ");
		   searchField = new JTextField("Name: ", 8);
		   
		   searchBtn = new JButton("Search");
		   
		   searchBtn.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
				   try {
					   String search = searchField.getText();
					   if(search.equals("")||search.equals("Name: ")) {
						   JOptionPane.showMessageDialog(null, "Please type in a Pokemon name.", "Try Again", JOptionPane.ERROR_MESSAGE);
					   }else {
						   int index = list.getNextMatch(search, 0, javax.swing.text.Position.Bias.Forward);
				           Pokemon selected = model.getElementAt(index);
						   if(index!=-1 && selected.getName().equalsIgnoreCase(search)) {
				                try {
									new View(selected);
								} catch (SQLException f) {
									f.printStackTrace();
								}

						   }else {
							   JOptionPane.showMessageDialog(null, "Pokemon not found. Please try again.", "Try Again", JOptionPane.ERROR_MESSAGE);
						   }
					   }
				   }catch (Exception q) {
					   JOptionPane.showMessageDialog(null, "Pokemon not found. Please try again.", "Try Again", JOptionPane.ERROR_MESSAGE);
				   }
				} 
			});
		   
//		   searchBarPanel.add(nameLabel);
		   searchBarPanel.add(searchField);
		   searchBarPanel.add(searchBtn); 
		   
		   searchPanel.add(searchLabel);
		   searchPanel.add(searchBarPanel);
		   
		   // Control Panel.
		   JPanel controlPanel = new JPanel();
		   controlPanel.setLayout(new GridLayout(2,2,5,5));
		   addBtn = new JButton("Add");
		   archiveBtn = new JButton("Archive");
		   aboutBtn = new JButton("About");
		   logoutBtn = new JButton("Log Out");
		   if (isAdmin) {
			   controlPanel.add(addBtn);
			   controlPanel.add(archiveBtn);
		   }
		   controlPanel.add(aboutBtn);
		   controlPanel.add(logoutBtn);
		   
		   aboutBtn.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	About about = new About(); 
 	                About.main(null);
	            }
		   });
		   
		   searchField.addFocusListener(new FocusListener() {
			    public void focusGained(FocusEvent e) {
			        searchField.setText("");
			    }

			    public void focusLost(FocusEvent e) {
			        // nothing
			    }
			});
		   
		   archiveBtn.addActionListener(new ActionListener() {
			   @Override
			   public void actionPerformed(ActionEvent e) {
				   Pokemon selected = list.getSelectedValue();
				   if (selected == null) {
					   JOptionPane.showMessageDialog(MainWindow.this, "Please select a Pokemon to archive");
				   }
				   else {
					   if (db.archivePokemon(selected)) {
						   JOptionPane.showMessageDialog(MainWindow.this, "Successfully archived Pokemon.");
						   refreshArchived();
					   }
					   else {
						   JOptionPane.showMessageDialog(MainWindow.this, "Error in archving Pokemon. Please try again.");
					   }
				   }
			   }
		   });
		   
		   addBtn.addActionListener(new ActionListener() {
			   @Override 
			   public void actionPerformed(ActionEvent e) {
				   try {
					new Add();
					Add.main(null);
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				   
				   
			   }
		   });
		   
		   logoutBtn.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   if(JOptionPane.showConfirmDialog(logoutBtn, "Confirm if you want to log out", "That Pokedex",
                           JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                              Login login = new Login(); 
                              Login.main(null);
                              dispose();
                   }    
               }
           });
		   
		   list.addMouseListener(new MouseAdapter() {
			    public void mouseClicked(MouseEvent evt) {
			        if (evt.getClickCount() == 2) {
			            Pokemon selected = list.getSelectedValue();
			            String sampleText = "Pokemon: " + selected.getName() + "\nTypes: " + selected.getTypes() + "\nGeneration: " + selected.getGeneration() + "\nWeight: " + selected.getWeight() + "\nSize: " + selected.getSize();
//		            	JOptionPane.showMessageDialog(MainWindow.this, sampleText, selected.getName(), JOptionPane.INFORMATION_MESSAGE);
		                try {
							new View(selected);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			            
			        } 
			    }
			});
		   
		   gbc.gridx = 0;
		   gbc.gridy = 0;
		   gbc.gridheight = 2;
		   gbc.fill = GridBagConstraints.VERTICAL;
		   gbc.gridwidth = 2;
		   gbc.fill = GridBagConstraints.HORIZONTAL;
		   getContentPane().add(listPanel,gbc);
		   gbc.gridx = 2;
		   gbc.gridy = 0;
		   gbc.gridwidth = 1;
		   gbc.fill = GridBagConstraints.HORIZONTAL;
		   getContentPane().add(filterPanel,gbc);
		   gbc.gridx = 0;
		   gbc.gridy = 2;
		   gbc.gridheight = 1;
		   gbc.fill = GridBagConstraints.VERTICAL;
		   gbc.gridwidth = 2;
		   gbc.fill = GridBagConstraints.HORIZONTAL;
		   getContentPane().add(searchPanel,gbc);
		   gbc.gridx = 2;
		   gbc.gridy = 2;
		   gbc.gridwidth = 1;
		   gbc.fill = GridBagConstraints.HORIZONTAL;
		   getContentPane().add(controlPanel,gbc);
		   
	   }

}