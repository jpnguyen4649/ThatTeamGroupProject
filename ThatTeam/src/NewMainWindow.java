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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.GridBagConstraints;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
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
import javax.swing.SpinnerNumberModel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.text.NumberFormatter;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JPanel;


/**
 * This class renders the items in the JList containing Pokemon objects.
 * @author rachelmao
 *
 */
//class PokemonCellRenderer extends JLabel implements ListCellRenderer  {
//	
//	public PokemonCellRenderer() {
//		setOpaque(true);
//		setIconTextGap(12);
//	}
//
//	@Override
//	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
//			boolean cellHasFocus) {
//		// TODO Auto-generated method stub
//		Pokemon pokemon = (Pokemon) value;
//		setText(pokemon.getName());
//		if (isSelected) {
//			setBackground(list.getSelectionBackground());
//			setForeground(list.getSelectionForeground());
//		}
//		else {
//			setBackground(Color.white);
//			setForeground(Color.black);
//		}
//		
//		if (pokemon.isVisible() == false) {
//			setBackground(Color.lightGray);
//			setForeground(Color.black);
//			if (isSelected) {
//				setBackground(list.getSelectionBackground());
//				setForeground(list.getSelectionForeground());
//			}
//		}
//		return this;
//	}
//}

/**
 * This class implements the main window of the Pokedex.
 * @author rachelmao
 *
 */
public class NewMainWindow extends JFrame {
	
	static boolean isAdmin;
	ArrayList<Pokemon> pokemonList;
	static DefaultListModel<Pokemon> model;
	GridBagConstraints gbc = new GridBagConstraints();
	
	// Filter GUI components.
	JLabel filterLabel;
	
	JLabel typeFilterLabel;
	CustomComboCheck typeFilterCb;
	
	JLabel genFilterLabel;
	CustomComboCheck genFilterCb;
	
	JLabel sizeFilterLabel;
	JSpinner leftFeetField;
	JLabel leftSizeFeetLabel;
	
	JLabel sizeDashLabel;
	JSpinner rightFeetField;
	JLabel rightSizeFeetLabel;

	
	JLabel weightFilterLabel;
	JSpinner leftWeightField;
	JLabel leftWeightUnitLabel;
	JLabel weightDashLabel;
	JSpinner rightWeightField;
	JLabel rightWeightUnitLabel;
	
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
	                  NewMainWindow window = new NewMainWindow();
	                  window.setVisible(true);
	               } catch (Exception e) {
	                  e.printStackTrace();
	               }
	            }
	         });
	   }
	   
	   
	
	   /**
	    * This method refreshes the Pokemon list display so that archived Pokemon appear at the bottom.
	 * @throws SQLException 
	    */
	   public static void refreshArchived() throws SQLException {
		   model.removeAllElements();
		   Database db = Database.getInstance();
		   ArrayList<Pokemon> archived = new ArrayList<>();
		   ArrayList<Pokemon> filtered = new ArrayList<>();
		   filtered = db.getDisplayedPokemon();
		   for (int i = 0; i < filtered.size(); i++) {
			   if (filtered.get(i).isVisible() == false) {
				   archived.add(filtered.get(i));
				   continue;
			   }
			   model.addElement(filtered.get(i));
		   }
		   if (isAdmin) {
			   for (int i = 0; i < archived.size(); i++) {
				   model.addElement(archived.get(i));
			   }
		   }
	   }
	   
// refresh the sorted Pokemon list
	   
	   public void refreshSortedA() throws SQLException{
		   model.removeAllElements();
		   Database db = Database.getInstance();
		   ArrayList<Pokemon> archived = new ArrayList<>();
		   ArrayList<Pokemon> sorted = new ArrayList<>();		   
		   sorted = db.sortedAlphabetically();
		   
		   for(int i = 0; i < sorted.size(); i++) {
			   System.out.println(sorted.get(i).getName() + "\t" + sorted.get(i).getGeneration() + "\t" + sorted.get(i).getTypes());
		   }
		   
		   for (int i = 0; i < sorted.size(); i++) {
			   if (sorted.get(i).isVisible() == false) {
				   archived.add(sorted.get(i));
				   continue;
			   }
			   model.addElement(sorted.get(i));
		   }
		   if (isAdmin) {
			   for (int i = 0; i < archived.size(); i++) {
				   model.addElement(archived.get(i));
			   }
		   }
		   
	   }
	   public void refreshSortedS() throws SQLException{
		   model.removeAllElements();
		   Database db = Database.getInstance();
		   ArrayList<Pokemon> archived = new ArrayList<>();
		   ArrayList<Pokemon> sorted = new ArrayList<>();
		   sorted = db.sortedBySize();
		   
		   for(int i = 0; i < sorted.size(); i++) {
			   System.out.println(sorted.get(i).getName() + "\t" + sorted.get(i).getGeneration() + "\t" + sorted.get(i).getTypes());
		   }
		   
		   
		   for (int i = 0; i < sorted.size(); i++) {
			   if (sorted.get(i).isVisible() == false) {
				   archived.add(sorted.get(i));
				   continue;
			   }
			   model.addElement(sorted.get(i));
		   }
		   if (isAdmin) {
			   for (int i = 0; i < archived.size(); i++) {
				   model.addElement(archived.get(i));
			   }
		   }		   
	   }
	   public void refreshSortedW() throws SQLException{
		   model.removeAllElements();
		   Database db = Database.getInstance();
		   ArrayList<Pokemon> archived = new ArrayList<>();
		   ArrayList<Pokemon> sorted = new ArrayList<>();
		   sorted = db.sortedByWeight();
		   
		   for(int i = 0; i < sorted.size(); i++) {
			   System.out.println(sorted.get(i).getName() + "\t" + sorted.get(i).getGeneration() + "\t" + sorted.get(i).getTypes());
		   }
		   
		   
		   for (int i = 0; i < sorted.size(); i++) {
			   if (sorted.get(i).isVisible() == false) {
				   archived.add(sorted.get(i));
				   continue;
			   }
			   model.addElement(sorted.get(i));
		   }
		   if (isAdmin) {
			   for (int i = 0; i < archived.size(); i++) {
				   model.addElement(archived.get(i));
			   }
		   }		
	   }
	   public void refreshSortedG() throws SQLException{
		   model.removeAllElements();
		   Database db = Database.getInstance();
		   ArrayList<Pokemon> archived = new ArrayList<>();
		   ArrayList<Pokemon> sorted = new ArrayList<>();
		   sorted = db.sortedByGeneration();

		   for(int i = 0; i < sorted.size(); i++) {
			   System.out.println(sorted.get(i).getName() + "\t" + sorted.get(i).getGeneration() + "\t" + sorted.get(i).getTypes());
		   }
		   
		   
		   for (int i = 0; i < sorted.size(); i++) {
			   if (sorted.get(i).isVisible() == false) {
				   archived.add(sorted.get(i));
				   continue;
			   }
			   model.addElement(sorted.get(i));
		   }
		   if (isAdmin) {
			   for (int i = 0; i < archived.size(); i++) {
				   model.addElement(archived.get(i));
			   }
		   }		
	   }
	   public void refreshSortedT() throws SQLException{
		   model.removeAllElements();
		   Database db = Database.getInstance();
		   ArrayList<Pokemon> archived = new ArrayList<>();
		   ArrayList<Pokemon> sorted = new ArrayList<>();
		   sorted = db.sortedByType();
		   
		   for(int i = 0; i < sorted.size(); i++) {
			   System.out.println(sorted.get(i).getName() + "\t" + sorted.get(i).getGeneration() + "\t" + sorted.get(i).getTypes());
		   }
		   
		   
		   for (int i = 0; i < sorted.size(); i++) {
			   if (sorted.get(i).isVisible() == false) {
				   archived.add(sorted.get(i));
				   continue;
			   }
			   model.addElement(sorted.get(i));
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
	   public NewMainWindow() throws SQLException {
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
		   setSize(520, 530);
		   setTitle("That Pokedex");
		   setResizable(false);
		   Container mainContainer = this.getContentPane();
		   SpringLayout springLayout = new SpringLayout();
		   getContentPane().setLayout(springLayout);
		   
		   scrollPane = new JScrollPane();
		   scrollPane.setViewportView(list);
		   springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 15, SpringLayout.NORTH, getContentPane());
		   springLayout.putConstraint(SpringLayout.WEST, scrollPane, 15, SpringLayout.WEST, getContentPane());
		   springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -109, SpringLayout.SOUTH, getContentPane());
		   springLayout.putConstraint(SpringLayout.EAST, scrollPane, 266, SpringLayout.WEST, getContentPane());
		   getContentPane().add(scrollPane);
		   
		   JPanel filterPanel = new JPanel();
		   springLayout.putConstraint(SpringLayout.WEST, filterPanel, 16, SpringLayout.EAST, scrollPane);
		   springLayout.putConstraint(SpringLayout.SOUTH, filterPanel, -102, SpringLayout.SOUTH, scrollPane);
		   springLayout.putConstraint(SpringLayout.EAST, filterPanel, -15, SpringLayout.EAST, getContentPane());
		   springLayout.putConstraint(SpringLayout.NORTH, filterPanel, 15, SpringLayout.NORTH, getContentPane());
		   getContentPane().add(filterPanel);
		   
// ================ START FILTER ================
		   filterPanel.setLayout(new BoxLayout(filterPanel, BoxLayout.PAGE_AXIS));
		   
		   JPanel filterLabelPanel = new JPanel();
		   filterLabelPanel.setAlignmentX(LEFT_ALIGNMENT);
		   
		   filterLabel = new JLabel("Filter:");
		   filterLabel.setAlignmentX(CENTER_ALIGNMENT);
		   filterLabelPanel.add(filterLabel);
		   
		   typeFilterLabel = new JLabel(" Type");
		   typeFilterLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		   typeFilterLabel.setHorizontalAlignment(SwingConstants.LEFT);
		   genFilterLabel = new JLabel(" Generation");
		   genFilterLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		   sizeFilterLabel = new JLabel(" Size");
		   sizeFilterLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		   weightFilterLabel = new JLabel(" Weight");
		   weightFilterLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		   

		   String[] types = {"Poison", "Ground", "Flying", "Water", "Rock", "Ghost", "Grass", "Fighting", "Dark", "Ice", "Fairy", "Normal", "Fire", "Dragon", "Bug", "Electric", "Psychic"};
		   Vector typesVector = new Vector<>();
		   for (int i = 0; i < types.length; i++) {
			   typesVector.add(new JCheckBox(types[i], false));
		   }
		   typeFilterCb = new CustomComboCheck(typesVector);
		   
		   // TODO: modify this so it isn't hard coded		   
		   String[] gens = {"1", "2", "3", "4", "5", "6"};
		   
		   Vector gensVector = new Vector<>();
		   for (int i = 0; i < gens.length; i++) {
			   gensVector.add(new JCheckBox(gens[i], false));
		   }
		   genFilterCb = new CustomComboCheck(gensVector);
		   
		   // Size Panel. 
		   JPanel sizePanel = new JPanel();
		   sizePanel.setLayout(new BoxLayout(sizePanel, BoxLayout.LINE_AXIS)); 
		   
		   leftFeetField = new JSpinner();
		   leftFeetField.setModel(new SpinnerNumberModel(0, 0, 1000, 1));
		   leftFeetField.setEditor(new JSpinner.NumberEditor(leftFeetField,"#"));
		   leftSizeFeetLabel = new JLabel("ft.");
		   sizeDashLabel = new JLabel("-");
		   rightFeetField = new JSpinner();
		   rightFeetField.setModel(new SpinnerNumberModel(1000, 0, 1000, 1));
		   rightFeetField.setEditor(new JSpinner.NumberEditor(rightFeetField,""));
		   rightFeetField.setEditor(new JSpinner.NumberEditor(rightFeetField,"#"));
		   rightSizeFeetLabel = new JLabel("ft.");
		   
		   sizePanel.add(leftFeetField);
		   sizePanel.add(leftSizeFeetLabel);
		   sizePanel.add(sizeDashLabel);
		   sizePanel.add(rightFeetField);
		   sizePanel.add(rightSizeFeetLabel);
		   
		   // Weight Panel.
		   JPanel weightPanel = new JPanel();
		   weightPanel.setLayout(new BoxLayout(weightPanel, BoxLayout.LINE_AXIS));
		   leftWeightField = new JSpinner();
		   leftWeightField.setModel(new SpinnerNumberModel(0, 0, 10000, 0.1));
		   leftWeightField.setEditor(new JSpinner.NumberEditor(leftWeightField,"##.#"));
		   leftWeightUnitLabel = new JLabel("lbs.");
		   weightDashLabel = new JLabel("-");
		   rightWeightField = new JSpinner();
		   rightWeightField.setModel(new SpinnerNumberModel(10000, 0, 10000, 0.1));
		   rightWeightField.setEditor(new JSpinner.NumberEditor(rightWeightField,"##.#"));
		   rightWeightUnitLabel = new JLabel("lbs.");
		   
		   weightPanel.add(leftWeightField);
		   weightPanel.add(leftWeightUnitLabel);
		   weightPanel.add(weightDashLabel);
		   weightPanel.add(rightWeightField);
		   weightPanel.add(rightWeightUnitLabel);
		   
		   typeFilterCb.setAlignmentX(LEFT_ALIGNMENT);
		   genFilterCb.setAlignmentX(LEFT_ALIGNMENT);
		   sizePanel.setAlignmentX(LEFT_ALIGNMENT);
		   weightPanel.setAlignmentX(LEFT_ALIGNMENT);
		   
		   JPanel applyBtnPanel = new JPanel();
		   applyBtnPanel.setAlignmentX(LEFT_ALIGNMENT);
		   applyFilterBtn = new JButton("Apply");
		   applyFilterBtn.setAlignmentX(CENTER_ALIGNMENT);
		   applyBtnPanel.add(applyFilterBtn);
		   
		   filterPanel.add(filterLabelPanel);
		   filterPanel.add(typeFilterLabel);
		   filterPanel.add(typeFilterCb);
		   filterPanel.add(genFilterLabel);
		   filterPanel.add(genFilterCb);
		   filterPanel.add(sizeFilterLabel);
		   filterPanel.add(sizePanel);
		   filterPanel.add(weightFilterLabel);
		   filterPanel.add(weightPanel);
		   filterPanel.add(applyBtnPanel);
		   
		   
// ================ END FILTER ================
		   
		   JPanel sortPanel = new JPanel();
		   springLayout.putConstraint(SpringLayout.NORTH, sortPanel, 398, SpringLayout.NORTH, getContentPane());
		   springLayout.putConstraint(SpringLayout.WEST, sortPanel, 15, SpringLayout.WEST, getContentPane());
		   springLayout.putConstraint(SpringLayout.SOUTH, sortPanel, -62, SpringLayout.SOUTH, getContentPane());
		   springLayout.putConstraint(SpringLayout.EAST, sortPanel, -254, SpringLayout.EAST, getContentPane());
		   getContentPane().add(sortPanel);
		   sortPanel.setLayout(new BoxLayout(sortPanel, BoxLayout.X_AXIS));
		   

		   sortLabel = new JLabel("Sort: ");
		   sortPanel.add(sortLabel);

		   String[] choices = {"Select One", "Alphabetically", "Type", "Generation", "Size", "Weight"};
		   sortCb = new JComboBox(choices);
		   
		   sortPanel.add(sortCb);
		   
		   JPanel panel = new JPanel();
		   springLayout.putConstraint(SpringLayout.NORTH, panel, 5, SpringLayout.SOUTH, sortPanel);
		   springLayout.putConstraint(SpringLayout.WEST, panel, 15, SpringLayout.WEST, getContentPane());
		   springLayout.putConstraint(SpringLayout.SOUTH, panel, -10, SpringLayout.SOUTH, getContentPane());
		   springLayout.putConstraint(SpringLayout.EAST, panel, -254, SpringLayout.EAST, getContentPane());
		   getContentPane().add(panel);
		   SpringLayout sl_panel = new SpringLayout();
		   panel.setLayout(sl_panel);
		   
		   searchLabel = new JLabel("Search: ");
		   sl_panel.putConstraint(SpringLayout.NORTH, searchLabel, 0, SpringLayout.NORTH, panel);
		   sl_panel.putConstraint(SpringLayout.WEST, searchLabel, 0, SpringLayout.WEST, panel);
		   panel.add(searchLabel);
		   
		   searchField = new JTextField();
		   sl_panel.putConstraint(SpringLayout.NORTH, searchField, 6, SpringLayout.SOUTH, searchLabel);
		   sl_panel.putConstraint(SpringLayout.WEST, searchField, 0, SpringLayout.WEST, panel);
		   panel.add(searchField);
		   searchField.setColumns(10);
		   
		   searchBtn = new JButton("Search");
		   
		   sl_panel.putConstraint(SpringLayout.EAST, searchField, -6, SpringLayout.WEST, searchBtn);
		   sl_panel.putConstraint(SpringLayout.NORTH, searchBtn, 22, SpringLayout.NORTH, panel);
		   sl_panel.putConstraint(SpringLayout.EAST, searchBtn, 0, SpringLayout.EAST, panel);
		   panel.add(searchBtn);
		   
		   JPanel controlPanel = new JPanel();
		   springLayout.putConstraint(SpringLayout.NORTH, controlPanel, 443, SpringLayout.NORTH, getContentPane());
		   springLayout.putConstraint(SpringLayout.SOUTH, controlPanel, -10, SpringLayout.SOUTH, getContentPane());
		   springLayout.putConstraint(SpringLayout.WEST, controlPanel, 0, SpringLayout.WEST, filterPanel);
		   springLayout.putConstraint(SpringLayout.EAST, controlPanel, 0, SpringLayout.EAST, filterPanel);
		   getContentPane().add(controlPanel);
		   controlPanel.setLayout(new GridLayout(2, 2, 3, 3));
		   
		   archiveBtn = new JButton("Archive");
		   aboutBtn = new JButton("About");
		   addBtn = new JButton("Add");
		   logoutBtn = new JButton("Logout");


		   if (isAdmin) {
			   controlPanel.add(addBtn);
			   controlPanel.add(archiveBtn);
		   }
		   controlPanel.add(aboutBtn);
		   controlPanel.add(logoutBtn);
		   
		   // Event Listeners.

		   applyFilterBtn.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {

				   ArrayList<TypeFilter> typeFilters = new ArrayList<>();
				   ArrayList<String> selectedTypes = typeFilterCb.getSelected();
				   for (int i = 0; i < selectedTypes.size(); i++) {
					   typeFilters.add(new TypeFilter(selectedTypes.get(i)));
				   }
				   
				   ArrayList<GenerationFilter> genFilters = new ArrayList<>();
				   ArrayList<String> selectedGens = genFilterCb.getSelected();
				   for (int i = 0; i < selectedGens.size(); i++) {
					   genFilters.add(new GenerationFilter(Integer.valueOf(selectedGens.get(i))));
				   }
				   
				   ArrayList<SizeFilter> sizeFilters = new ArrayList<> ();
				   int leftSize = (int) leftFeetField.getValue();
				   int rightSize = (int) rightFeetField.getValue();
				   sizeFilters.add(new SizeFilter(leftSize, ">"));
				   sizeFilters.add(new SizeFilter(rightSize, "<"));
				   
				   ArrayList<WeightFilter> weightFilters = new ArrayList<>();
				   double leftWeight = (double) leftWeightField.getValue();
				   double rightWeight = (double) rightWeightField.getValue();
				   weightFilters.add(new WeightFilter(leftWeight, ">"));
				   weightFilters.add(new WeightFilter(rightWeight, "<"));
				   
				   ArrayList<Pokemon> filteredPokemon = db.filterPokemon(typeFilters, genFilters, sizeFilters, weightFilters);		
				   for(int i = 0; i < filteredPokemon.size(); i++) {

					   System.out.println(filteredPokemon.get(i).toString());
				   }
				   
				   try {
					refreshArchived();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			   }
		   });
		   
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
									new NewView(selected);
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
					   JOptionPane.showMessageDialog(NewMainWindow.this, "Please select a Pokemon to archive");
				   }
				   else {
					   if (db.archivePokemon(selected)) {
						   JOptionPane.showMessageDialog(NewMainWindow.this, "Successfully archived Pokemon.");
						   try {
							refreshArchived();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					   }
					   else {
						   JOptionPane.showMessageDialog(NewMainWindow.this, "Error in archiving Pokemon. Please try again.");
					   }
				   }
			   }
		   });
		   
		   addBtn.addActionListener(new ActionListener() {
			   @Override 
			   public void actionPerformed(ActionEvent e) {
				   try {
					new NewAdd();
//					Add.main(null);
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
		                try {
							new NewView(selected);
						} catch (SQLException e) {
							e.printStackTrace();
						}
			            
			        } 
			    }
			});
		   
		   sortCb.addActionListener(new ActionListener() {
			   @Override
			   public void actionPerformed(ActionEvent e) {
				   try {
				   String s = (String) sortCb.getSelectedItem();
				   switch(s) {
				   case "Alphabetically":
					   refreshSortedA();
					   break;
				   case "Type":
					   refreshSortedT();
					   break;
				   case "Weight":
					   refreshSortedW();
					   break;
				   case "Generation":
					   refreshSortedG();
					   break;
				   case "Size":
					   refreshSortedS();
					   break;
				   case "Select One":
					   refreshArchived();
					   break;
				   }
				   }
				   catch(SQLException e1) {
					   e1.printStackTrace();
				   }				  				   
			   }
			   
		   });
		   
	        addWindowListener(new WindowAdapter() {
	            public void windowClosed(WindowEvent e) {
	            	dispose();
	            }
	        });
		   
	   }
}