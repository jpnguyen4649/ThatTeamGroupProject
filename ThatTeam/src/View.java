import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This class implements a pop up view of the pokemon's information. 
 * @author rachelmao
 *
 */

public class View extends JFrame {
	
	boolean isAdmin; 
	
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
	JTextField typeField;
	JTextField genField;
	JTextField weightField;
	JTextField sizeField;
	
	JButton editBtn;
	JButton republishBtn;
	
	/**
	 * This constructs a View object that displays information about the specified Pokemon. 
	 * @param pokemon
	 * @throws SQLException
	 */
	public View (Pokemon pokemon ) throws SQLException {
		
		// Set access levels.
		if (User.getInstance().getAccessLevel() == 1) isAdmin = true;
		else isAdmin = false;
		
		Database db = Database.getInstance();
		
		setSize(300,300);
		
	    Container mainContainer = this.getContentPane();
//	    mainContainer.setLayout(new GridLayout(6, 1, 5, 2));
	    mainContainer.setLayout(new BoxLayout(mainContainer, BoxLayout.PAGE_AXIS));
	    nameLabel = new JLabel("Name: ");
	    typeLabel = new JLabel("Type: ");
	    genLabel = new JLabel("Generation: ");
	    weightLabel = new JLabel("Weight: ");
	    sizeLabel = new JLabel("Size: ");
	    
	    pokemonName = new JLabel(pokemon.getName());
	    pokemonType = new JLabel(pokemon.getTypes());
	    pokemonGen = new JLabel(Integer.toString(pokemon.getGeneration()));
	    pokemonWeight = new JLabel(Float.toString(pokemon.getWeight()));
	    pokemonSize = new JLabel(Integer.toString(pokemon.getSize()));
	    
	    editBtn = new JButton("Edit");
	    republishBtn = new JButton("Republish");
	    
	    JPanel namePanel = new JPanel();
	    namePanel.setLayout(new GridBagLayout());
	    namePanel.add(nameLabel);
	    namePanel.add(pokemonName);
	    
	    JPanel typePanel = new JPanel();
	    typePanel.setLayout(new GridBagLayout());
//	    typePanel.setLayout(new GridLayout(1, 2, 5, 5));
	    typePanel.add(typeLabel);
	    typePanel.add(pokemonType);
	    
	    JPanel genPanel = new JPanel();
	    genPanel.setLayout(new GridBagLayout());
	    genPanel.add(genLabel);
	    genPanel.add(pokemonGen);
	    
	    JPanel weightPanel = new JPanel();
	    weightPanel.setLayout(new GridBagLayout());
	    weightPanel.add(weightLabel);
	    weightPanel.add(pokemonWeight);	    
	    
	    JPanel sizePanel = new JPanel();
	    sizePanel.setLayout(new GridBagLayout());
	    sizePanel.add(sizeLabel);
	    sizePanel.add(pokemonSize);
	    
	    nameField = new JTextField();
	    typeField = new JTextField();
	    genField = new JTextField();
	    weightField = new JTextField();
	    sizeField = new JTextField();

	    getContentPane().add(namePanel);
	    getContentPane().add(typePanel);
	    getContentPane().add(genPanel);
	    getContentPane().add(weightPanel);
	    getContentPane().add(sizePanel);
	    
	    if (isAdmin) {
	    	getContentPane().add(editBtn);
	    	if (!pokemon.isVisible()) {
	    		getContentPane().add(republishBtn);
	    	}
	    }
	    
	   editBtn.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
        	   // User confirms edit.
        	   // NOTE: This code is reused in Add.java, find a better solution later.
        	   if (editBtn.getText() == "Confirm") {
        		   
        		    // Check that text field values are valid.
	   				boolean validName = true;
	   				boolean validType = true;
	   				boolean validGeneration = true;
	   				boolean validWeight = true;
	   				boolean validSize = true;
	   				
	   				String name = nameField.getText();
	   				String type = typeField.getText();
	   				int gen = 0;
	   				float weight = 0;
	   				int size = 0;
	   				try {
	   					gen = Integer.parseInt(genField.getText());
	   				}
	   				catch (NumberFormatException nfe) {
	   					
	   				}
	   				try {
	   					weight = Float.parseFloat(weightField.getText());
	   				}
	   				catch (NumberFormatException nfe) {
	   					
	   				}
	   				try {
	   					size = Integer.parseInt(sizeField.getText());
	   				}
	   				catch (NumberFormatException nfe){
	   					
	   				}
	   				// All fields are valid.
	   				if (validName && validType && validGeneration && validWeight && validSize == true) {
	   					pokemon.setName(name);
	   					pokemon.setTypes(type);
	   					pokemon.setGeneration(gen);
	   					pokemon.setWeight(weight);
	   					pokemon.setSize(size);
	   					db.updateDatabase(pokemon);
	   					
	   					pokemonName.setText(pokemon.getName());
	   					pokemonType.setText(pokemon.getTypes());
	   					pokemonGen.setText(Integer.toString(pokemon.getGeneration()));
	   					pokemonWeight.setText(Float.toString(pokemon.getWeight()));
	   					pokemonSize.setText(Integer.toString(pokemon.getSize()));
	   					
	   					namePanel.remove(nameField);
	   					namePanel.add(pokemonName);
	   					typePanel.remove(typeField);
	   					typePanel.add(pokemonType);
	   					genPanel.remove(genField);
	   					genPanel.add(pokemonGen);
	   					weightPanel.remove(weightField);
	   					weightPanel.add(pokemonWeight);
	   					sizePanel.remove(sizeField);
	   					sizePanel.add(pokemonSize);
	   					
	   					namePanel.repaint();
	   					typePanel.repaint();
	   					genPanel.repaint();
	   					weightPanel.repaint();
	   					sizePanel.repaint();
	   					
	   					editBtn.setText("Edit");
	   				}
	   				// Fields have error.
	   				else {
	   					
	   				}
        	   }
        	   // User clicks "edit".
        	   else {
            	   nameField.setText(pokemonName.getText());
            	   typeField.setText(pokemonType.getText());
            	   genField.setText(pokemonGen.getText());
            	   weightField.setText(pokemonWeight.getText());
            	   sizeField.setText(pokemonSize.getText());
            	   
            	   namePanel.remove(pokemonName);
            	   namePanel.add(nameField);
            	   typePanel.remove(pokemonType);
            	   typePanel.add(typeField);
            	   genPanel.remove(pokemonGen);
            	   genPanel.add(genField);
            	   weightPanel.remove(pokemonWeight);
            	   weightPanel.add(weightField);
            	   sizePanel.remove(pokemonSize);
            	   sizePanel.add(sizeField);
            	   
            	   namePanel.repaint();
            	   typePanel.repaint();
            	   genPanel.repaint();
            	   weightPanel.repaint();
            	   sizePanel.repaint();
        		   
        	   }
        	   
        	   
        	   editBtn.setText("Confirm");
           }
       });
	
		setVisible(true);
	}
}
