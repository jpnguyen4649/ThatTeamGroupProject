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
class PokemonCellRenderer extends JLabel implements ListCellRenderer  {
	
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
		if (isSelected) {
			setBackground(list.getSelectionBackground());
			setForeground(list.getSelectionForeground());
		}
		else {
			setBackground(Color.white);
			setForeground(Color.black);
		}
		
		if (pokemon.isVisible() == false) {
			setBackground(Color.lightGray);
			setForeground(Color.black);
			if (isSelected) {
				setBackground(list.getSelectionBackground());
				setForeground(list.getSelectionForeground());
			}
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
	JSpinner leftInchField;
	JLabel leftSizeInchLabel;
	
	JLabel sizeDashLabel;
	
	JSpinner rightFeetField;
	JLabel rightSizeFeetLabel;
	JSpinner rightInchField;
	JLabel rightSizeInchLabel;

	
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
//		   filterPanel.setLayout(new GridLayout(10, 1, 5, 5));
		   filterPanel.setLayout(new BoxLayout(filterPanel, BoxLayout.PAGE_AXIS));
//		   filterPanel.setAlignmentX(Component._ALIGNMENT);
		   
		   JPanel filterLabelPanel = new JPanel();
		   filterLabelPanel.setAlignmentX(LEFT_ALIGNMENT);
		   
		   filterLabel = new JLabel("Filter:");
		   filterLabel.setAlignmentX(CENTER_ALIGNMENT);
		   filterLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		   filterLabelPanel.add(filterLabel);
		   
		   typeFilterLabel = new JLabel("Type");
		   typeFilterLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		   typeFilterLabel.setHorizontalAlignment(SwingConstants.LEFT);
		   genFilterLabel = new JLabel("Generation");
		   genFilterLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		   sizeFilterLabel = new JLabel("Size");
		   sizeFilterLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		   weightFilterLabel = new JLabel("Weight");
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
//		   sizePanel.setLayout(new GridLayout(1, 9));
		   
		   leftFeetField = new JSpinner();
		   leftFeetField.setModel(new SpinnerNumberModel(0, 0, 1000, 1));
		   leftFeetField.setEditor(new JSpinner.NumberEditor(leftFeetField,"#"));
		   leftSizeFeetLabel = new JLabel("ft.");
		   
		   leftInchField = new JSpinner();
		   leftInchField.setModel(new SpinnerNumberModel(0, 0, 1000, 1));
		   leftInchField.setEditor(new JSpinner.NumberEditor(leftInchField,""));
		   JFormattedTextField leftInchEditor = ((JSpinner.NumberEditor) leftInchField.getEditor()).getTextField();
		   ((NumberFormatter) leftInchEditor.getFormatter()).setAllowsInvalid(false);
		   leftSizeInchLabel = new JLabel("in.");
		   
		   sizeDashLabel = new JLabel("-");
		   
		   rightFeetField = new JSpinner();
		   rightFeetField.setModel(new SpinnerNumberModel(1000, 0, 1000, 1));
		   rightFeetField.setEditor(new JSpinner.NumberEditor(rightFeetField,""));
		   rightFeetField.setEditor(new JSpinner.NumberEditor(rightFeetField,"#"));
		   rightSizeFeetLabel = new JLabel("ft.");
		   
		   rightInchField = new JSpinner();
		   rightInchField.setModel(new SpinnerNumberModel(0, 0, 1000, 1));
		   rightInchField.setEditor(new JSpinner.NumberEditor(rightInchField,""));
		   JFormattedTextField rightInchEditor = ((JSpinner.NumberEditor) rightInchField.getEditor()).getTextField();
		   ((NumberFormatter) rightInchEditor.getFormatter()).setAllowsInvalid(false);
		   rightSizeInchLabel = new JLabel("in.");
		   
		   sizePanel.add(leftFeetField);
		   sizePanel.add(leftSizeFeetLabel);
//		   sizePanel.add(leftInchField);
//		   sizePanel.add(leftSizeInchLabel);
		   sizePanel.add(sizeDashLabel);
		   sizePanel.add(rightFeetField);
		   sizePanel.add(rightSizeFeetLabel);
//		   sizePanel.add(rightInchField);
//		   sizePanel.add(rightSizeInchLabel);
		   
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
		   
//		   filterPanel.add(filterLabel);
		   filterPanel.add(filterLabelPanel);
		   filterPanel.add(typeFilterLabel);
		   filterPanel.add(typeFilterCb);
		   filterPanel.add(genFilterLabel);
		   filterPanel.add(genFilterCb);
		   filterPanel.add(sizeFilterLabel);
//		   filterPanel.add(sizeFilterCb);
		   filterPanel.add(sizePanel);
		   filterPanel.add(weightFilterLabel);
//		   filterPanel.add(weightFilterCb);
		   filterPanel.add(weightPanel);
//		   filterPanel.add(applyFilterBtn);
		   filterPanel.add(applyBtnPanel);
		   
		   
		   
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
		   
		   
		   
		   // Search Panel.
		   JPanel searchPanel = new JPanel();
		   searchPanel.setLayout(new GridLayout(2, 1, 5, 5));
		   searchLabel = new JLabel("Search:");
		   searchLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		   JPanel searchBarPanel = new JPanel();
		   searchBarPanel.setLayout(new FlowLayout(2, 1, 0));
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
						   try {
							refreshArchived();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					   }
					   else {
						   JOptionPane.showMessageDialog(MainWindow.this, "Error in archiving Pokemon. Please try again.");
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