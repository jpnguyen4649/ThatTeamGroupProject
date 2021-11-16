import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextField;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;

public class Main extends JFrame{
	
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
	
	public static void main(String[] args) {
	      EventQueue.invokeLater(
	         new Runnable() {
	            public void run() {
	               try {
	                  MainWindow window = new MainWindow();
//	            	   Main window = new Main();
	                  window.setVisible(true);
	               } catch (Exception e) {
	                  e.printStackTrace();
	               }
	            }
	         });
	}
	
	public Main() throws SQLException {
	setSize(500, 600);
	Container mainContainer = this.getContentPane();
	JPanel panel = new JPanel();
	JScrollPane sp = new JScrollPane();
	
	   Database db = Database.getInstance();
	   ArrayList<Pokemon>pokemonList = db.getPokemon();

	   
	   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	   DefaultListModel<Pokemon> model = new DefaultListModel<>();
	   ArrayList<Pokemon> archived = new ArrayList<>();
	   for (int i = 0; i < pokemonList.size(); i++) {
		   if (pokemonList.get(i).isVisible() == false) {
			   archived.add(pokemonList.get(i));
			   continue;
		   }
		   model.addElement(pokemonList.get(i));
	   }
	   

	   JList<Pokemon> list = new JList<Pokemon>(model);
	   list.setCellRenderer(new PokemonCellRenderer());

	
	   mainContainer.setLayout(new GridLayout(1, 2, 5, 5));
	   
	   
	   
	   // List panel.
	   JPanel listPanel = new JPanel();
	   listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.PAGE_AXIS));
	   
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
	   
	   
	   // Filter panel.
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
	   
	   mainContainer.add(listPanel);
	   mainContainer.add(filterPanel);
	
	}
}