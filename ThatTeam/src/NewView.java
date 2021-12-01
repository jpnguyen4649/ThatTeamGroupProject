import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpringLayout;
import javax.swing.text.NumberFormatter;

/**
 * This class implements a pop up view of the pokemon's information. 
 * @author rachelmao
 *
 */

public class NewView extends JFrame {
	
	boolean isAdmin; 
	String[] pokemonTypes = {"Poison", "Ground", "Flying", "Water", "Rock", "Ghost", "Grass", "Fighting", "Dark", "Ice", "Fairy", "Normal", "Fire", "Dragon", "Bug", "Electric", "Psychic"};
	JLabel nameLabel;
	JLabel typeLabel;
	JLabel genLabel;
	JLabel weightLabel;
	JLabel sizeLabel;
	
	JLabel pokemonName;
	JLabel pokemonType;
	JLabel pokemonGen;
	JLabel pokemonWeight;
	JLabel pokemonSize;
	
	JTextField nameField;
	CustomComboCheck typeField;
	JSpinner genField;
	JSpinner weightField;
	JSpinner sizeField;
	
	JToggleButton editBtn;
	JButton republishBtn;
	

	public void refreshFields(Pokemon pokemon) {
    	nameField.setText(pokemon.getName());
    	String types = pokemon.getTypes();
        for (String type: types.split(", ")) {
        	int index = Arrays.asList(pokemonTypes).indexOf(type);
        	System.out.print(type + " " + index);
        	typeField.setSelected(index);
         }
    	genField.setValue(pokemon.getGeneration());
    	weightField.setValue((double) pokemon.getWeight());
    	sizeField.setValue(pokemon.getSize());
	}
	
	/**
	 * This constructs a View object that displays information about the specified Pokemon. 
	 * @param pokemon
	 * @throws SQLException
	 */
	public NewView (Pokemon pokemon ) throws SQLException {
		
		// Set access levels.
		if (User.getInstance().getAccessLevel() == 1) isAdmin = true;
		else isAdmin = false;
		
		Database db = Database.getInstance();
		
		setTitle(pokemon.getName());
		setSize(280,300);
		
	    Container mainContainer = this.getContentPane();
	    mainContainer.setLayout(new BoxLayout(mainContainer, BoxLayout.PAGE_AXIS));

		pokemonName = new JLabel(pokemon.getName());
		pokemonType = new JLabel(pokemon.getTypes());
		pokemonGen = new JLabel(String.valueOf(pokemon.getGeneration()));
		pokemonSize = new JLabel(String.valueOf(pokemon.getSize()));
		pokemonWeight = new JLabel(String.valueOf(pokemon.getWeight()));

	    JPanel formPanel = new JPanel();
	    SpringLayout sl_formPanel = new SpringLayout();
	    formPanel.setLayout(sl_formPanel);
	    
	    JPanel formWrapper = new JPanel();
	    formWrapper.setLayout(new BoxLayout(formWrapper, BoxLayout.PAGE_AXIS));
	    formWrapper.add(formPanel);
	    
	    // Name.
	    nameLabel= new JLabel("Name: ");
	    sl_formPanel.putConstraint(SpringLayout.NORTH, nameLabel, 20, SpringLayout.NORTH, formPanel);
	    sl_formPanel.putConstraint(SpringLayout.WEST, nameLabel, 20, SpringLayout.WEST, formPanel);
	    formPanel.add(nameLabel);
	   
	    JPanel nameWrapper = new JPanel();
	    nameWrapper.setLayout(new GridLayout());
	    nameField = new JTextField();
	    sl_formPanel.putConstraint(SpringLayout.EAST, formPanel, 20, SpringLayout.EAST, nameWrapper);
	    sl_formPanel.putConstraint(SpringLayout.VERTICAL_CENTER, nameWrapper, 0, SpringLayout.VERTICAL_CENTER, nameLabel);
//	    nameWrapper.add(nameField);
	    nameWrapper.add(pokemonName);
	    formPanel.add(nameWrapper);
	    
	    // Type.
	    typeLabel = new JLabel("Types: ");
	    sl_formPanel.putConstraint(SpringLayout.NORTH, typeLabel, 15, SpringLayout.SOUTH, nameLabel);
	    sl_formPanel.putConstraint(SpringLayout.WEST, typeLabel, 20, SpringLayout.WEST, formPanel);
	    formPanel.add(typeLabel);
	    
	    JPanel typeWrapper = new JPanel();
	    typeWrapper.setLayout(new GridLayout());
	    
	      JTextField typeField2 = new JTextField();
	
		   Vector typesVector = new Vector<>();
		   for (int i = 0; i < pokemonTypes.length; i++) {
			   typesVector.add(new JCheckBox(pokemonTypes[i], false));
		   }
		   typeField = new CustomComboCheck(typesVector);
		   
	    sl_formPanel.putConstraint(SpringLayout.EAST, typeWrapper, 0, SpringLayout.EAST, nameWrapper);
	    sl_formPanel.putConstraint(SpringLayout.VERTICAL_CENTER, typeWrapper, 0, SpringLayout.VERTICAL_CENTER, typeLabel);
//	    typeWrapper.add(typeField);
	    typeWrapper.add(pokemonType);
	    formPanel.add(typeWrapper);
	    
	    // Generation.
	    genLabel = new JLabel("Generation: ");
	    sl_formPanel.putConstraint(SpringLayout.NORTH, genLabel, 15, SpringLayout.SOUTH, typeLabel);
	    sl_formPanel.putConstraint(SpringLayout.WEST, genLabel, 20, SpringLayout.WEST, formPanel);
	    formPanel.add(genLabel);
	    
	    JPanel genWrapper = new JPanel();
	    genWrapper.setLayout(new GridLayout());
	    genField = new JSpinner();
	    sl_formPanel.putConstraint(SpringLayout.WEST, genWrapper, 5, SpringLayout.EAST, genLabel);
	    sl_formPanel.putConstraint(SpringLayout.EAST, genWrapper, 0, SpringLayout.EAST, nameWrapper);
	    sl_formPanel.putConstraint(SpringLayout.VERTICAL_CENTER, genWrapper, 0, SpringLayout.VERTICAL_CENTER, genLabel);
	    
	       genField.setModel(new SpinnerNumberModel(1, 1, 9, 1));
	       genField.setEditor(new JSpinner.NumberEditor(genField,"#"));

//	    genWrapper.add(genField);
	    genWrapper.add(pokemonGen);
	    formPanel.add(genWrapper);
	    
	    // Size.
	    sizeLabel = new JLabel("Size(in): ");
	    sl_formPanel.putConstraint(SpringLayout.NORTH, sizeLabel, 15, SpringLayout.SOUTH, genLabel);
	    sl_formPanel.putConstraint(SpringLayout.WEST, sizeLabel, 20, SpringLayout.WEST, formPanel);
	    formPanel.add(sizeLabel);
	    
	    JPanel sizeWrapper = new JPanel();
	    sizeWrapper.setLayout(new GridLayout());
	    sizeField = new JSpinner();
	    sl_formPanel.putConstraint(SpringLayout.EAST, sizeWrapper, 0, SpringLayout.EAST, nameWrapper);
	    sl_formPanel.putConstraint(SpringLayout.VERTICAL_CENTER, sizeWrapper, 0, SpringLayout.VERTICAL_CENTER, sizeLabel);

	       sizeField.setModel(new SpinnerNumberModel(0, 0, 1000, 1));
	       sizeField.setEditor(new JSpinner.NumberEditor(sizeField,"#"));

		   
//	    sizeWrapper.add(sizeField);
	    sizeWrapper.add(pokemonSize);
	    formPanel.add(sizeWrapper);
	    
	    // Weight.
	    weightLabel = new JLabel("Weight(lbs): ");
	    sl_formPanel.putConstraint(SpringLayout.NORTH, weightLabel, 15, SpringLayout.SOUTH, sizeLabel);
	    sl_formPanel.putConstraint(SpringLayout.WEST, weightLabel, 20, SpringLayout.WEST, formPanel);
	    formPanel.add(weightLabel);
	    
	    JPanel weightWrapper = new JPanel();
	    weightWrapper.setLayout(new GridLayout());
	    weightField = new JSpinner();
	    sl_formPanel.putConstraint(SpringLayout.EAST, weightWrapper, 0, SpringLayout.EAST, nameWrapper);
	    sl_formPanel.putConstraint(SpringLayout.VERTICAL_CENTER, weightWrapper, 0, SpringLayout.VERTICAL_CENTER, weightLabel);

	       weightField.setModel(new SpinnerNumberModel(0, 0, 10000, 0.1));
		   weightField.setEditor(new JSpinner.NumberEditor(weightField,"##.#"));
		   
//	    weightWrapper.add(weightField);
	    weightWrapper.add(pokemonWeight);
	    formPanel.add(weightWrapper);
	    
	    
	    // Align all fields.
	    sl_formPanel.putConstraint(SpringLayout.WEST,  nameWrapper, 0, SpringLayout.WEST, genWrapper);
	    sl_formPanel.putConstraint(SpringLayout.WEST,  typeWrapper, 0, SpringLayout.WEST, genWrapper);
	    sl_formPanel.putConstraint(SpringLayout.WEST,  sizeWrapper, 0, SpringLayout.WEST, genWrapper);
	    sl_formPanel.putConstraint(SpringLayout.WEST,  weightWrapper, 0, SpringLayout.WEST, genWrapper);
	    
	    
	    getContentPane().add(formWrapper);
	    
	    editBtn = new JToggleButton("Edit");
	    republishBtn = new JButton("Republish");
	    
	    refreshFields(pokemon);
	    
	    
	    if (isAdmin) {
	    	getContentPane().add(editBtn);
	    	if (!pokemon.isVisible()) {
	    		getContentPane().add(republishBtn);
	    	}
	    }
	    
	    
	    ItemListener itemListener = new ItemListener() {
	    	 
            public void itemStateChanged(ItemEvent itemEvent)
            {
 
                int state = itemEvent.getStateChange();
                
                // Edit Mode ON.
                if (state == ItemEvent.SELECTED) {
                	
                   editBtn.setText("Confirm");
                	
              	   nameWrapper.add(nameField);
              	   nameWrapper.remove(pokemonName);
              	   typeWrapper.add(typeField);
              	   typeWrapper.remove(pokemonType);
              	   genWrapper.add(genField);
              	   genWrapper.remove(pokemonGen);
              	   weightWrapper.add(weightField);
              	   weightWrapper.remove(pokemonWeight);
              	   sizeWrapper.add(sizeField);
              	   sizeWrapper.remove(pokemonSize);
                	
                    System.out.println("Selected");
                }
                // Edit Mode OFF.
                else {
                	
                	editBtn.setText("Edit");
                	
                	// Pokemon data to update in database.
                	String name = nameField.getText();
                	ArrayList<String> selectedTypes = typeField.getSelected();
                	String types = String.join(", ", selectedTypes);
                	int gen = (int) genField.getValue();
                	int size = (int) sizeField.getValue();
                	double weight = (double) weightField.getValue();
                	DecimalFormat df = new DecimalFormat("#.#");
                	double roundedWeight = Double.valueOf(df.format(weight));
                	
                	pokemon.setName(name);
                	pokemon.setTypes(types);
                	pokemon.setGeneration(gen);
                	pokemon.setSize(size);
                	pokemon.setWeight((float)roundedWeight);
                	db.updateDatabase(pokemon);
                	
                	refreshFields(pokemon);
                	
                	System.out.println(name);
                	System.out.println(types);
                	System.out.println(gen);
                	System.out.println(size);
                	System.out.println(weight);


 	        	   pokemonName.setText(pokemon.getName());
 	        	   pokemonType.setText(pokemon.getTypes());
 	        	   pokemonGen.setText(Integer.toString(pokemon.getGeneration()));
 	        	   pokemonWeight.setText(Float.toString(pokemon.getWeight()));
 	        	   pokemonSize.setText(Integer.toString(pokemon.getSize()));
             	   
             	   nameWrapper.remove(nameField);
             	   nameWrapper.add(pokemonName);
             	   typeWrapper.remove(typeField);
             	   typeWrapper.add(pokemonType);
             	   genWrapper.remove(genField);
             	   genWrapper.add(pokemonGen);
             	   weightWrapper.remove(weightField);
             	   weightWrapper.add(pokemonWeight);
             	   sizeWrapper.remove(sizeField);
             	   sizeWrapper.add(pokemonSize);

                    System.out.println("Deselected");
                    
                }
                
          	   nameWrapper.revalidate();
          	   typeWrapper.validate();
          	   genWrapper.validate();
          	   weightWrapper.validate();
          	   sizeWrapper.validate();
          	   nameWrapper.repaint();
          	   typeWrapper.repaint();
          	   genWrapper.repaint();
          	   weightWrapper.repaint();
          	   sizeWrapper.repaint();
            }
        };
       
        addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
            	try {
					MainWindow.refreshArchived();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        
        editBtn.addItemListener(itemListener);
	    
	    republishBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (db.republishPokemon(pokemon)) {
					   JOptionPane.showMessageDialog(NewView.this, "Successfully republished Pokemon.");
					   dispose();
				   }
				   else {
					   JOptionPane.showMessageDialog(NewView.this, "Error in republishing Pokemon. Please try again.");
				   }
				
			}
	    	
	    });
	
		setVisible(true);
	}
	
	   public static void main(String[] args) {
	      EventQueue.invokeLater(
	         new Runnable() {
	            public void run() {
	               try {
	                  NewView window = new NewView(new Pokemon("Pikachu", "Electric", 1, 13, 6, false));
	                  window.setVisible(true);
	               } catch (Exception e) {
	                  e.printStackTrace();
	               }
	            }
	         });
	   }
}
