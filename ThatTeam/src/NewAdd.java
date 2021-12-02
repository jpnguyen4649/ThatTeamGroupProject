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

public class NewAdd extends JFrame {
	
	String[] pokemonTypes = {"Poison", "Ground", "Flying", "Water", "Rock", "Ghost", "Grass", "Fighting", "Dark", "Ice", "Fairy", "Normal", "Fire", "Dragon", "Bug", "Electric", "Psychic"};
	JLabel nameLabel;
	JLabel typeLabel;
	JLabel genLabel;
	JLabel weightLabel;
	JLabel sizeLabel;
	
	JTextField nameField;
	CustomComboCheck typeField;
	JSpinner genField;
	JSpinner weightField;
	JSpinner sizeField;
	
	/**
	 * This constructs a View object that displays information about the specified Pokemon. 
	 * @param pokemon
	 * @throws SQLException
	 */
	public NewAdd () throws SQLException {
		
		
		Database db = Database.getInstance();
		
		setTitle("Add Pokemon");
		setSize(300,280);

		
	    Container mainContainer = this.getContentPane();
	    mainContainer.setLayout(new BoxLayout(mainContainer, BoxLayout.PAGE_AXIS));

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
	    nameWrapper.add(nameField);
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
	    typeWrapper.add(typeField);
	    formPanel.add(typeWrapper);
	    
	    // Generation.
	    genLabel = new JLabel("Generation: ");
	    sl_formPanel.putConstraint(SpringLayout.NORTH, genLabel, 15, SpringLayout.SOUTH, typeLabel);
	    sl_formPanel.putConstraint(SpringLayout.WEST, genLabel, 20, SpringLayout.WEST, formPanel);
	    formPanel.add(genLabel);
	    
	    JPanel genWrapper = new JPanel();
	    sl_formPanel.putConstraint(SpringLayout.EAST, genWrapper, -20, SpringLayout.EAST, formPanel);
	    genWrapper.setLayout(new GridLayout());
	    genField = new JSpinner();
	    sl_formPanel.putConstraint(SpringLayout.WEST, genWrapper, 5, SpringLayout.EAST, genLabel);
	    sl_formPanel.putConstraint(SpringLayout.VERTICAL_CENTER, genWrapper, 0, SpringLayout.VERTICAL_CENTER, genLabel);
	    
	       genField.setModel(new SpinnerNumberModel(1, 1, 9, 1));
	       genField.setEditor(new JSpinner.NumberEditor(genField,"#"));

	    genWrapper.add(genField);
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

		   
	    sizeWrapper.add(sizeField);
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
		   
	    weightWrapper.add(weightField);
	    formPanel.add(weightWrapper);
	    
	    JPanel buttonPanel = new JPanel();
	    buttonPanel.setLayout(new FlowLayout());
	    JButton cancelBtn = new JButton("Cancel");
	    JButton addBtn = new JButton("Add");
	    buttonPanel.add(cancelBtn);
	    buttonPanel.add(addBtn);
	    
	    mainContainer.add(formWrapper);
	    mainContainer.add(buttonPanel);
	    
	    
	    
	    
	    // Align all fields.
	    sl_formPanel.putConstraint(SpringLayout.WEST,  nameWrapper, 0, SpringLayout.WEST, genWrapper);
	    sl_formPanel.putConstraint(SpringLayout.WEST,  typeWrapper, 0, SpringLayout.WEST, genWrapper);
	    sl_formPanel.putConstraint(SpringLayout.WEST,  sizeWrapper, 0, SpringLayout.WEST, genWrapper);
	    sl_formPanel.putConstraint(SpringLayout.WEST,  weightWrapper, 0, SpringLayout.WEST, genWrapper);
	    
	    
	    
	    addBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
            	ArrayList<String> selectedTypes = typeField.getSelected();
            	String types = String.join(", ", selectedTypes);
            	int gen = (int) genField.getValue();
            	int size = (int) sizeField.getValue();
            	double weight = (double) weightField.getValue();
            	DecimalFormat df = new DecimalFormat("#.#");
            	float roundedWeight = Float.valueOf(df.format(weight));
            	
            	Pokemon pokemon = new Pokemon(name, types, gen, roundedWeight, size, true);
            	if (db.addPokemon(pokemon)) {
					JOptionPane.showMessageDialog(null, "Successfully added Pokemon.");
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Error in adding Pokemon. Please try again.");
				}
				
			}
	    	
	    });
	    
	    cancelBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
	    	
	    });

       
        addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
            	try {
					NewMainWindow.refreshArchived();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
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
	            	   NewAdd window = new NewAdd();
	                  window.setVisible(true);
	               } catch (Exception e) {
	                  e.printStackTrace();
	               }
	            }
	         });
	   }
}
