import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
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

// Renderer for list items.
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

public class MainWindow extends JFrame {
	
	
	GridBagConstraints gbc = new GridBagConstraints();
	
	// Filter GUI components.
	JLabel filterLabel;
	JLabel typeFilterLabel;
	JComboBox<String> typeFilterCb;
	JLabel genFilterLabel;
	JComboBox<Integer> genFilterCb;
	JLabel sizeFilterLabel;
	JSlider sizeFilterSlider;
	JLabel weightFilterLabel;
	JSlider weightFilterSlider;
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
		 * Create the application.
		 * @throws SQLException 
		 */
	   public MainWindow() throws SQLException {
		   
		   // NOTE: We'll have to move this eventually, but for now I'm creating a database instance here.
		   Database db = new Database();
		   ArrayList<Pokemon> pokemonList = db.getPokemon();
		   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		   DefaultListModel<Pokemon> model = new DefaultListModel<>();
		   
		   // ---- Refresh archived.
		   ArrayList<Pokemon> archived = new ArrayList<>();
		   for (int i = 0; i < pokemonList.size(); i++) {
			   if (pokemonList.get(i).isVisible() == false) {
				   archived.add(pokemonList.get(i));
				   continue;
			   }
			   model.addElement(pokemonList.get(i));
		   }
		   for (int i = 0; i < archived.size(); i++) {
			   model.addElement(archived.get(i));
		   }
		   // ---- end refresh archived.
		   
 
		   JList<Pokemon> list = new JList(model);
		   list.setCellRenderer(new PokemonCellRenderer());

		   
		   // GUI designing.
		   setSize(500, 670);
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
		   sortPanel.setLayout(new FlowLayout(2, 4, 4));
		   sortLabel = new JLabel("Sort");
		   sortCb = new JComboBox<String>();
		   sortPanel.add(sortLabel);
		   sortPanel.add(sortCb);
		   
		   listPanel.add(scrollPane);
		   listPanel.add(sortPanel);
		   
		   
		   // Filter Panel.
		   JPanel filterPanel = new JPanel();
		   filterPanel.setLayout(new GridLayout(10, 1, 5, 5));
		   filterLabel = new JLabel("Filter");
		   typeFilterLabel = new JLabel("Type");
		   genFilterLabel = new JLabel("Generation");
		   sizeFilterLabel = new JLabel("Size");
		   weightFilterLabel = new JLabel("Weight");
		   
		   typeFilterCb = new JComboBox<String>();
		   genFilterCb = new JComboBox<Integer>();
		   sizeFilterSlider = new JSlider();
		   weightFilterSlider = new JSlider();
		   applyFilterBtn = new JButton("Apply");
		   filterPanel.add(filterLabel);
		   filterPanel.add(typeFilterLabel);
		   filterPanel.add(typeFilterCb);
		   filterPanel.add(genFilterLabel);
		   filterPanel.add(genFilterCb);
		   filterPanel.add(sizeFilterLabel);
		   filterPanel.add(sizeFilterSlider);
		   filterPanel.add(weightFilterLabel);
		   filterPanel.add(weightFilterSlider);
		   filterPanel.add(applyFilterBtn);
		   
		   // Search Panel.
		   JPanel searchPanel = new JPanel();
		   searchPanel.setLayout(new GridLayout(2, 1, 5, 5));
		   searchLabel = new JLabel("Search");
		   
		   JPanel searchBarPanel = new JPanel();
		   searchBarPanel.setLayout(new FlowLayout(2, 0, 0));
//		   nameLabel = new JLabel("Name: ");
		   searchField = new JTextField("Name: ");
		   searchBtn = new JButton("Search");
		   
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
		   controlPanel.add(addBtn);
		   controlPanel.add(archiveBtn);
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
					   try {
						   db.archivePokemon(selected);
						   JOptionPane.showMessageDialog(MainWindow.this, "Successfully archived Pokemon.");
						   }
					   catch(Exception e1) {
						   JOptionPane.showMessageDialog(MainWindow.this, "Error in archving Pokemon. Please try again.");
					   }
				   }
			   }
		   });
		   
		   addBtn.addActionListener(new ActionListener() {
			   @Override 
			   public void actionPerformed(ActionEvent e) {
				   Add add = new Add();
				   Add.main(null);
				   
			   }
		   });
		   
		   list.addMouseListener(new MouseAdapter() {
			    public void mouseClicked(MouseEvent evt) {
			        if (evt.getClickCount() == 2) {
			            Pokemon selected = list.getSelectedValue();
			            String sampleText = "Pokemon: " + selected.getName() + "\nTypes: " + selected.getTypes() + "\nGeneration: " + selected.getGeneration() + "\nWeight: " + selected.getWeight() + "\nSize: " + selected.getSize();
		            	JOptionPane.showMessageDialog(MainWindow.this, sampleText, selected.getName(), JOptionPane.INFORMATION_MESSAGE);
		                
			            
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