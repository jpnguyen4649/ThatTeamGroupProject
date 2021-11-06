import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

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
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;

public class ThatPokedexAdmin {
   private ButtonGroup checkBoxGroup;
   private JFrame frmThatPokedex;
   private JTextField search;
	
	/**
	 * Launch the application.
	 */
   public static void main(String[] args) {
      EventQueue.invokeLater(
         new Runnable() {
            public void run() {
               try {
                  ThatPokedexAdmin window = new ThatPokedexAdmin();
                  window.frmThatPokedex.setVisible(true);
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
   public ThatPokedexAdmin() throws SQLException {
      initialize();
   }

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
   private void initialize() throws SQLException {

	   
      frmThatPokedex = new JFrame();
      frmThatPokedex.setTitle("That Pokedex - Admin");
      frmThatPokedex.setBounds(100, 100, 579, 576);
      frmThatPokedex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frmThatPokedex.getContentPane().setLayout(null);
   	
   	//Add the about button to bring them into the About page
      JButton btnNewButton = new JButton("About");
      btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
      btnNewButton.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               About about = new About(); 
               About.main(null);
               frmThatPokedex.dispose();
            }
         });
      btnNewButton.setBounds(453, 335, 95, 32);
      frmThatPokedex.getContentPane().add(btnNewButton);
   	
   	//Made the log out button and made a confirmation message if they really want to log out
      JButton btnLogOut = new JButton("Log Out");
      btnLogOut.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               if(JOptionPane.showConfirmDialog(btnLogOut, "Confirm if you want to log out", "That Pokedex",
               JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                  Login login = new Login(); 
                  Login.main(null);
                  frmThatPokedex.dispose();
               }	
            }
         });
      btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 14));
      btnLogOut.setBounds(453, 377, 95, 32);
      frmThatPokedex.getContentPane().add(btnLogOut);
   	
      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setBounds(20, 21, 230, 307);
      frmThatPokedex.getContentPane().add(scrollPane);
      
      Database db = new Database();
      ArrayList<Pokemon>  pokemonList = new ArrayList();
  
   	
   	//This is where we see the Pokemon listed with the scroll bar
      JList list = new JList();
      scrollPane.setViewportView(list);
      list.setModel(
         new AbstractListModel() {
        	ArrayList<Pokemon>  pokeList = pokemonList;
        	
            public int getSize() {
               return pokeList.size();
            }
            public Object getElementAt(int index) {
               return pokeList.get(index);
            }
         });
   	
      JTextArea txtrInformationAboutThe = new JTextArea();
      txtrInformationAboutThe.setFont(new Font("Tahoma", Font.PLAIN, 18));
      txtrInformationAboutThe.setLineWrap(true);
      txtrInformationAboutThe.setText("Information about the Pokemon you selected will be posted here.");
      txtrInformationAboutThe.setEditable(false);
      txtrInformationAboutThe.setBounds(265, 22, 270, 137);
      frmThatPokedex.getContentPane().add(txtrInformationAboutThe);
   	
      JLabel lblNewLabel = new JLabel("Search:");
      lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
      lblNewLabel.setBounds(20, 366, 104, 26);
      frmThatPokedex.getContentPane().add(lblNewLabel);
   	
      JLabel lblNewLabel_1 = new JLabel("Name:");
      lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
      lblNewLabel_1.setBounds(20, 394, 45, 31);
      frmThatPokedex.getContentPane().add(lblNewLabel_1);
   	
      search = new JTextField();
      search.setBounds(70, 395, 167, 30);
      frmThatPokedex.getContentPane().add(search);
      search.setColumns(10);
   	
   	//Made the search button. If the user types the pokemon correctly, then the info about that pokemon pops up.
   	//Otherwise, it shows an error message.
      JButton btnNewButton_1_1 = new JButton("Search");
   	
   	
      btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
      btnNewButton_1_1.setBounds(247, 395, 88, 28);
      frmThatPokedex.getContentPane().add(btnNewButton_1_1);
   	
   	//Made the select button, so that the user clicks a Pokemon in the list and gets the info.
   	//If you hit the select button without choosing a Pokemon, it brings an error message.
      JButton btnNewButton_1 = new JButton("Select");
      btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
      btnNewButton_1.setBounds(86, 338, 88, 27);
      frmThatPokedex.getContentPane().add(btnNewButton_1);
   	
   	//Made the refresh button to go back to the original display
      JButton btnNewButton_1_1_1 = new JButton("Refresh");
      btnNewButton_1_1_1.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               txtrInformationAboutThe.setFont(new Font("Tahoma", Font.PLAIN, 18));
               txtrInformationAboutThe.setText("Information about the Pokemon you selected will be posted here.");
            }
         });
      btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
      btnNewButton_1_1_1.setBounds(358, 169, 88, 28);
      frmThatPokedex.getContentPane().add(btnNewButton_1_1_1);
   	
      JLabel lblFilter = new JLabel("Sort By:");
      lblFilter.setFont(new Font("Tahoma", Font.BOLD, 16));
      lblFilter.setBounds(260, 218, 104, 26);
      frmThatPokedex.getContentPane().add(lblFilter);
   	
   	//Sort buttons are being made
   	
      JCheckBox chckbxNewCheckBox = new JCheckBox("Type");
      chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
      chckbxNewCheckBox.setBounds(266, 239, 53, 40);
      frmThatPokedex.getContentPane().add(chckbxNewCheckBox);
   	
      JCheckBox chckbxGeneration = new JCheckBox("Generation");
      chckbxGeneration.setFont(new Font("Tahoma", Font.PLAIN, 13));
      chckbxGeneration.setBounds(332, 239, 95, 40);
      frmThatPokedex.getContentPane().add(chckbxGeneration);
   	
      JCheckBox chckbxSize = new JCheckBox("Size");
      chckbxSize.setFont(new Font("Tahoma", Font.PLAIN, 13));
      chckbxSize.setBounds(265, 281, 62, 40);
      frmThatPokedex.getContentPane().add(chckbxSize);
   	
      JCheckBox chckbxWeight = new JCheckBox("Weight");
      chckbxWeight.setFont(new Font("Tahoma", Font.PLAIN, 13));
      chckbxWeight.setBounds(332, 281, 95, 40);
      frmThatPokedex.getContentPane().add(chckbxWeight);
   	
   	//Added this to prevent from clicking multiple checkboxes
      checkBoxGroup = new ButtonGroup();
      checkBoxGroup.add(chckbxNewCheckBox);
      checkBoxGroup.add(chckbxGeneration);
      checkBoxGroup.add(chckbxSize);
      checkBoxGroup.add(chckbxWeight);
   	
   	//Made an apply button so when you hit the sort, it shows the pokemon in the right order of that category.
      JButton btnNewButton_1_1_1_1 = new JButton("Apply");
      btnNewButton_1_1_1_1.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               if(chckbxNewCheckBox.isSelected()) {
                  list.setModel(
                     new AbstractListModel() {
                     //String[] values = new String[] {"Absol"};
                        String[] values = new String[] {"Caterpie - Bug", "Spewpa - Bug", "Metapod - Bug", "Grubbin - Bug", "Cutiefly - Bug, Fairy", "Vivillon - Bug, Flying", "Ledyba - Bug, Flying", "Spinarak - Bug, Poison", "Absol - Dark", "Goomy - Dragon", "Latias - Dragon, Psychic", "Pikachu - Electric", "Mareep - Electric", "Pichu - Electric", "Toxel - Electric, Poison", "Clefairy - Fairy", "Togepi - Fairy", "Cleffa - Fairy", "Sylveon - Fairy", "Dedenne - Fairy", "Clobbopus - Fighting", "Charmander - Fire", "Vulpix - Fire", "Ponyta - Fire", "Torchic - Fire", "Pansear - Fire", "Cyndaquil - Fire", "Fennekin - Fire", "Litten - Fire", "Duskull - Ghost", "Sinistea - Ghost", "Phantump - Ghost, Grass", "Pumpkaboo - Ghost, Grass", "Treecko - Grass", "Shaymin - Grass", "Turtwig - Grass", "Chespin - Grass", "Snivy - Grass", "Applin - Grass, Dragon", "Hoppip - Grass, Flying", "Rowlet - Grass, Flying", "Bulbasaur - Grass, Poison", "Oddish - Grass, Poison", "Bellsprout - Grass, Poison", "Diglett - Ground", "Mudbray - Ground", "Baltoy - Ground, Psychic", "Snorunt - Ice", "Bergmite - Ice", "Spheal - Ice, Water", "Rattata - Normal", "Meowth - Normal", "Minccino - Normal", "Lillipup - Normal", "Eevee - Normal", "Snorlax - Normal", "Sentret - Normal", "Aipom - Normal", "Jigglypuff - Normal, Fairy", "Pidgey - Normal, Flying", "Pikipek - Normal, Flying", "Zubat - Poison, Flying", "Mareanie - Poison, Water", "Munna - Psychic", "Wynaut - Psychic", "Hatenna - Psychic", "Ralts - Psychic, Fairy", "Victini - Psychic, Fire", "Natu - Psychic, Flying", "Celebi - Psychic, Grass", "Sudowoodo - Rock", "Rockruff - Rock", "Anorith - Rock, Bug", "Carbink - Rock, Fairy", "Lileep - Rock, Grass", "Geodude - Rock, Ground", "Amaura - Rock, Ice", "Squirtle - Water", "Psyduck - Water", "Poliwag - Water", "Seel - Water", "Mudkip - Water", "Phione - Water", "Piplup - Water", "Oshawott - Water", "Totodile - Water", "Froakie - Water", "Magikarp - Water", "Feebas - Water", "Corphish - Water", "Politoed - Water", "Clamperl - Water", "Luvdisc - Water", "Kyogre - Water", "Shellder - Water", "Popplio - Water", "Chinchou - Water, Electric", "Marill - Water, Fairy", "Azumarill - Water, Fairy", "Barboach - Water, Ground", "Slowpoke - Water, Psychic"};
                        public int getSize() {
                           return values.length;
                        }
                        public Object getElementAt(int index) {
                           return values[index];
                        }
                     });
               }
               
               else if(chckbxGeneration.isSelected()) {
                  list.setModel(
                     new AbstractListModel() {
                        String[] values = new String[] {"Pikachu - Gen. 1", "Bulbasaur - Gen. 1", "Diglett - Gen. 1", "Squirtle - Gen. 1", "Charmander - Gen. 1", "Rattata - Gen. 1", "Pidgey - Gen. 1", "Clefairy - Gen. 1", "Jigglypuff - Gen. 1", "Vulpix - Gen 1", "Zubat - Gen. 1", "Oddish - Gen. 1", "Caterpie - Gen. 1", "Meowth - Gen. 1", "Psyduck - Gen. 1", "Poliwag - Gen. 1", "Bellsprout - Gen. 1", "Geodude - Gen. 1", "Slowpoke - Gen. 1", "Ponyta - Gen. 1", "Seel - Gen. 1", "Eevee - Gen. 1", "Metapod - Gen. 1", "Snorlax - Gen. 1", "Magikarp - Gen. 1", "Shellder - Gen. 1", "Celebi - Gen. 2", "Cyndaquil - Gen. 2", "Mareep - Gen. 2", "Natu - Gen. 2", "Togepi - Gen. 2", "Totodile - Gen. 2", "Sentret - Gen. 2", "Ledyba - Gen. 2", "Spinarak - Gen. 2", "Chinchou - Gen. 2", "Pichu - Gen. 2", "Cleffa - Gen. 2", "Marill - Gen. 2", "Azumarill - Gen. 2", "Sudowoodo - Gen. 2", "Politoed - Gen. 2", "Hoppip - Gen. 2", "Aipom - Gen. 2", "Treecko - Gen. 3", "Torchic - Gen. 3", "Mudkip - Gen. 3", "Ralts - Gen. 3", "Duskull - Gen. 3", "Feebas - Gen. 3", "Anorith - Gen. 3", "Lileep - Gen. 3", "Baltoy - Gen. 3", "Corphish - Gen. 3", "Barboach - Gen. 3", "Absol - Gen. 3", "Wynaut - Gen. 3", "Snorunt - Gen. 3", "Spheal - Gen. 3", "Clamperl - Gen. 3", "Luvdisc - Gen. 3", "Latias - Gen. 3", "Kyogre - Gen. 3", "Shaymin - Gen. 4", "Phione - Gen. 4", "Piplup - Gen. 4", "Turtwig - Gen. 4", "Victini - Gen. 5", "Pansear - Gen. 5", "Minccino - Gen. 5", "Munna - Gen. 5", "Lillipup - Gen. 5", "Oshawott - Gen. 5", "Snivy - Gen. 5", "Vivillon - Gen. 6", "Spewpa - Gen. 6", "Chespin - Gen. 6", "Fennekin - Gen. 6", "Froakie - Gen. 6", "Amaura - Gen. 6", "Sylveon - Gen. 6", "Dedenne - Gen. 6", "Carbink - Gen. 6", "Goomy - Gen. 6", "Phantump - Gen. 6", "Pumpkaboo - Gen. 6", "Bergmite - Gen. 6", "Mudbray - Gen. 7", "Rowlet - Gen. 7", "Litten - Gen. 7", "Popplio - Gen. 7", "Pikipek - Gen. 7", "Grubbin - Gen. 7", "Cutiefly - Gen. 7", "Rockruff - Gen. 7", "Mareanie - Gen. 7", "Applin - Gen. 8", "Toxel - Gen. 8", "Clobbopus - Gen. 8", "Sinistea - Gen. 8", "Hatenna - Gen. 8"};
                        public int getSize() {
                           return values.length;
                        }
                        public Object getElementAt(int index) {
                           return values[index];
                        }
                     });
               }
               
               else if(chckbxSize.isSelected()) {
                  list.setModel(
                     new AbstractListModel() {
                        String[] values = new String[] {"Sinistea - 0 ft. 04 in.", "Cutiefly - 0 ft. 04 in.", "Diglett - 0 ft. 08 in.", "Shaymin - 0 ft. 08 in.", "Natu - 0 ft. 08 in.", "Dedenne - 0 ft. 08 in.", "Applin - 0 ft. 08 in.", "Rattata - 1 ft. 00 in.", "Pidgey - 1 ft. 00 in.", "Caterpie - 1 ft. 00 in.", "Spewpa - 1 ft. 00 in.", "Eevee - 1 ft. 00 in.", "Togepi - 1 ft. 00 in.", "Froakie - 1 ft. 00 in.", "Pichu - 1 ft. 00 in.", "Clegga - 1 ft. 00 in.", "Carbink - 1 ft. 00 in.", "Goomy - 1 ft. 00 in.", "Pumpkaboo - 1 ft. 00 in.", "Shellder - 1 ft. 00 in.", "Rowlet - 1 ft. 00 in.", "Pikipek - 1 ft. 00 in.", "Meowth - 1 ft. 04 in.", "Geodude - 1 ft. 04 in.", "Torchic - 1 ft. 04 in.", "Mudkip - 1 ft. 04 in.", "Ralts - 1 ft. 04 in.", "Victini - 1 ft. 04 in.", "Phione - 1 ft. 04 in.", "Piplup - 1 ft. 04 in.", "Turtwig - 1 ft. 04 in.", "Minccino - 1 ft. 04 in.", "Lillipup - 1 ft. 04 in.", "Chespin - 1 ft. 04 in.", "Fennekin - 1 ft. 04 in.", "Barboach - 1 ft. 04 in.", "Marill - 1 ft. 04 in.", "Hoppip - 1 ft. 04 in.", "Clamperl - 1 ft. 04 in.", "Phantump - 1 ft. 04 in.", "Toxel - 1 ft. 04 in.", "Pikachu - 1 ft. 04 in.", "Hatenna - 1 ft. 04 in.", "Litten - 1 ft. 04 in.", "Popplio - 1 ft. 04 in.", "Grubbin - 1 ft. 04 in.", "Mareanie - 1 ft. 04 in.", "Squirtle - 1 ft. 08 in.", "Jigglypuff - 1 ft. 08 in.", "Oddish - 1 ft. 08 in.", "Treecko - 1 ft. 08 in.", "Oshawott - 1 ft. 08 in.", "Cyndaquil - 1 ft. 08 in.", "Baltoy - 1 ft. 08 in.", "Spinarak - 1 ft. 08 in.", "Chinchou - 1 ft. 08 in.", "Rockruff - 1 ft. 08 in.", "Charmander - 2 ft. 00 in.", "Clefairy - 2 ft. 00 in.", "Vulpix - 2 ft. 00 in.", "Poliwag - 2 ft. 00 in.", "Celebi - 2 ft. 00 in.", "Pansear - 2 ft. 00 in.", "Munna - 2 ft. 00 in.", "Snivy - 2 ft. 00 in.", "Mareep - 2 ft. 00 in.", "Totodile - 2 ft. 00 in.", "Feebas - 2 ft. 00 in.", "Corphish - 2 ft. 00 in.", "Wynaut - 2 ft. 00 in.", "Luvdisc - 2 ft. 00 in.", "Clobbopus - 2 ft. 00 in.", "Bulbasaur - 2 ft. 04 in.", "Bellsprout - 2 ft. 04 in.", "Metapod - 2 ft. 04 in.", "Anorith - 2 ft. 04 in.", "Snorunt - 2 ft. 04 in.", "Zubat - 2 ft. 07 in.", "Psyduck - 2 ft. 07 in.", "Duskull - 2 ft. 07 in.", "Sentret - 2 ft. 07 in.", "Azumarill - 2 ft. 07 in.", "Aipom - 2 ft. 07 in.", "Spheal - 2 ft. 07 in.", "Magikarp - 2 ft. 11 in.", "Ponyta - 3 ft. 03 in.", "Mudbray - 3 ft. 03 in.", "Lileep - 3 ft. 03 in.", "Ledyba - 3 ft. 03 in.", "Sylveon - 3 ft. 03 in.", "Bergmite - 3 ft. 03 in.", "Seel - 3 ft. 07 in.", "Politoed - 3 ft. 07 in.", "Slowpoke - 3 ft. 11 in.", "Vivillon - 3 ft. 11 in.", "Sudowoodo - 3 ft. 11 in.", "Absol - 3 ft. 11 in.", "Amaura - 4 ft. 03 in.", "Latias - 4 ft. 03 in.", "Snorlax - 6 ft. 11 in.", "Kyogre - 14 ft. 09 in."};
                        public int getSize() {
                           return values.length;
                        }
                        public Object getElementAt(int index) {
                           return values[index];
                        }
                     });
               }
               
               else if(chckbxWeight.isSelected()) {
                  list.setModel(
                     new AbstractListModel() {
                        String[] values = new String[] {"Sinistea - 0.4 lbs", "Cutiefly - 0.4 lbs", "Hoppip - 1.1 lbs", "Applin - 1.1 lbs", "Diglett - 1.8 lbs", "Pikipek - 2.6 lbs", "Togepi - 3.3 lbs", "Rowlet - 3.3 lbs", "Pidgey - 4.0 lbs", "Barboach - 4.2 lbs", "Natu - 4.4 lbs", "Pichu - 4.4 lbs", "Shaymin - 4.6 lbs", "Dedenne - 4.9 lbs", "Torchic - 5.5 lbs", "Goomy - 6.2 lbs", "Caterpie - 6.4 lbs", "Cleffa - 6.6 lbs", "Phione - 6.8 lbs", "Hatenna - 7.5 lbs", "Rattata - 7.7 lbs", "Pumpkaboo - 7.7 lbs", "Bellsprout - 8.8 lbs", "Victini - 8.8 lbs", "Clobbopus - 8.8 lbs", "Shellder - 8.8 lbs", "Lillipup - 9.0 lbs", "Meowth - 9.3 lbs", "Litten - 9.5 lbs", "Grubbin - 9.7 lbs", "Treecko - 11.0 lbs", "Celebi - 11.0 lbs", "Piplup - 11.5 lbs", "Oddish - 11.9 lbs", "Jigglypuff - 12.1 lbs", "Carbink - 12.6 lbs", "Minccino - 12.8 lbs", "Pikachu - 13.0 lbs", "Oshawott - 13.0 lbs", "Sentret - 13.2 lbs", "Eevee - 14.3 lbs", "Ralts - 14.6 lbs", "Bulbasaur - 15.2 lbs", "Froakie - 15.4 lbs", "Phantump - 15.4 lbs", "Feebas - 16.3 lbs", "Clefairy - 16.5 lbs", "Zubat - 16.5 lbs", "Popplio - 16.5 lbs", "Mudkip - 16.8 lbs", "Mareep - 17.2 lbs", "Cyndaquil - 17.4 lbs", "Mareanie - 17.6 lbs", "Snivy 17.9 lbs", "Spewpa - 18.5 lbs", "Charmander - 18.7 lbs", "Spinarak - 18.7 lbs", "Marill - 18.7 lbs", "Luvdisc - 19.2 lbs", "Squirtle - 19.8 lbs", "Chespin - 19.8 lbs", "Rockruff - 20.3 lbs", "Fennekin - 20.7 lbs", "Totodile - 20.9 lbs", "Vulpix - 21.8 lbs", "Metapod - 21.8 lbs", "Magikarp - 22.0 lbs", "Turtwig - 22.5 lbs", "Ledyba - 23.8 lbs", "Pansear - 24.3 lbs", "Toxel - 24.3 lbs", "Corphish - 25.4 lbs", "Aipom - 25.4 lbs", "Chinchou - 26.5 lbs", "Poliwag - 27.3 lbs", "Anorith - 27.6 lbs", "Wynaut - 30.9 lbs", "Duskull - 33.1 lbs", "Snorunt - 37.0 lbs", "Vivillon - 37.5 lbs", "Psyduck - 43.2 lbs", "Geodude - 44.1 lbs", "Baltoy - 47.4 lbs", "Munna - 51.3 lbs", "Sylveon - 51.8 lbs", "Lileep - 52.5 lbs", "Amaura - 55.6 lbs", "Azumarill - 62.8 lbs", "Ponyta - 66.1 lbs", "Politoed - 74.7 lbs", "Slowpoke - 79.4 lbs", "Sudowoodo - 83.8 lbs", "Spheal - 87.1 lbs", "Latias - 88.2 lbs", "Absol - 103.6 lbs", "Clamperl - 115.7 lbs", "Seel - 198.4 lbs", "Bergmite - 219.4 lbs", "Mudbray - 242.5 lbs", "Kyogre - 776.0 lbs", "Snorlax 1014.1 lbs"};
                        public int getSize() {
                           return values.length;
                        }
                        public Object getElementAt(int index) {
                           return values[index];
                        }
                     });
               }
               
               
               else {
                  JOptionPane.showMessageDialog(null, "Please select a sort option before using this button.", "That Pokedex Apply Error", JOptionPane.ERROR_MESSAGE);
               }
            
            }
         
         });
      btnNewButton_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
      btnNewButton_1_1_1_1.setBounds(433, 244, 115, 28);
      frmThatPokedex.getContentPane().add(btnNewButton_1_1_1_1);
   	
   	//Made the sort filter button to go back to the list before
      JButton btnNewButton_1_1_1_1_1 = new JButton("Clear Sort");
      btnNewButton_1_1_1_1_1.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               checkBoxGroup.clearSelection();
               list.setModel(
                  new AbstractListModel() {
                     String[] values = new String[] {"Absol", "Aipom", "Amaura", "Anorith", "Applin", "Azumarill", "Baltoy", "Barboach", "Bellsprout", "Bergmite", "Bulbasaur", "Carbink", "Caterpie", "Celebi", "Charmander", "Chespin", "Chinchou", "Clamperl", "Clefairy", "Cleffa", "Clobbopus", "Corphish", "Cutiefly", "Cyndaquil", "Dedenne", "Diglett", "Duskull", "Eevee", "Feebas", "Fennekin", "Froakie", "Geodude", "Goomy", "Grubbin", "Hatenna", "Hoppip", "Jigglypuff", "Kyogre", "Latias", "Ledyba", "Lileep", "Lillipup", "Litten", "Luvdisc", "Magikarp", "Mareanie", "Mareep", "Marill", "Meowth", "Metapod", "Minccino", "Mudbray", "Mudkip", "Munna", "Natu", "Oddish", "Oshawott", "Pansear", "Phantump", "Phione", "Pichu", "Pidgey", "Pikachu", "Pikipek", "Piplup", "Politoed", "Poliwag", "Ponyta", "Popplio", "Psyduck", "Pumpkaboo", "Ralts", "Rattata", "Rockruff", "Rowlet", "Seel", "Sentret", "Shaymin", "Shellder", "Sinistea", "Slowpoke", "Snivy", "Snorlax", "Snorunt", "Spewpa", "Spheal", "Spinarak", "Squirtle", "Sudowoodo", "Sylveon", "Togepi", "Torchic", "Totodile", "Toxel", "Treecko", "Turtwig", "Victini", "Vivillon", "Vulpix", "Wynaut", "Zubat"};
                     public int getSize() {
                        return values.length;
                     }
                     public Object getElementAt(int index) {
                        return values[index];
                     }
                  });
            }
         });
      btnNewButton_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
      btnNewButton_1_1_1_1_1.setBounds(433, 286, 115, 28);
      frmThatPokedex.getContentPane().add(btnNewButton_1_1_1_1_1);
   	
      JSeparator separator = new JSeparator();
      separator.setBounds(265, 207, 290, 2);
      frmThatPokedex.getContentPane().add(separator);
   	
      JSeparator separator_1 = new JSeparator();
      separator_1.setBounds(265, 327, 290, 2);
      frmThatPokedex.getContentPane().add(separator_1);
   	
   	//Made an add button for the admin to add the pokemon and it brings them to a diff page
      JButton btnAdd = new JButton("Add");
      btnAdd.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               Add add = new Add(); 
               Add.main(null);
               frmThatPokedex.dispose();
            }
         });
      btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
      btnAdd.setBounds(348, 335, 95, 32);
      frmThatPokedex.getContentPane().add(btnAdd);
   	
   	//Made an archive button for the admin to archive the pokemon and it brings them to a diff page
      JButton btnArchive = new JButton("Archive");
//      btnArchive.addActionListener(
//         new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//               Archive archive = new Archive(); 
//               Archive.main(null);
//               frmThatPokedex.dispose();
//            }
//         });
      btnArchive.setFont(new Font("Tahoma", Font.PLAIN, 14));
      btnArchive.setBounds(348, 377, 95, 32);
      frmThatPokedex.getContentPane().add(btnArchive);
   	
   	//Adding Filter section
      JLabel lblFilterBy = new JLabel("Filter By:");
      lblFilterBy.setFont(new Font("Tahoma", Font.BOLD, 16));
      lblFilterBy.setBounds(20, 461, 104, 26);
      frmThatPokedex.getContentPane().add(lblFilterBy);
   	
      JComboBox comboBox = new JComboBox();
      comboBox.setModel(new DefaultComboBoxModel(new String[] {"Type", "Bug", "Bug, Fairy", "Bug, Flying", "Bug, Poison", "Dark", "Dragon", "Dragon, Psychic", "Electric", "Electric, Poison", "Fairy", "Fighting", "Fire", "Ghost ", "Ghost, Grass", "Grass", "Grass, Dragon", "Grass, Flying", "Grass, Poison", "Ground", "Ground, Psychic", "Ice", "Ice, Water", "Normal", "Normal, Fairy", "Normal, Flying", "Poison", "Poison, Flying", "Poison, Water", "Psychic", "Psychic, Fairy", "Psychic, Fire", "Psychic, Flying", "Psychic, Grass", "Rock", "Rock, Bug", "Rock, Fairy", "Rock, Grass", "Rock, Ground", "Rock, Ice", "Water", "Water, Electric", "Water, Fairy", "Water, Ground", "Water, Psychic"}));
      comboBox.setBounds(107, 466, 104, 21);
      frmThatPokedex.getContentPane().add(comboBox);
   	
      JComboBox comboBox_1 = new JComboBox();
      comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Generation", "Generation 1", "Generation 2", "Generation 3", "Generation 4", "Generation 5", "Generation 6", "Generation 7", "Generation 8"}));
      comboBox_1.setBounds(215, 466, 104, 21);
      frmThatPokedex.getContentPane().add(comboBox_1);
   	
      JComboBox comboBox_2 = new JComboBox();
      comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Size", "~ 0 ft.", "~ 1 ft.", "~ 2 ft.", "~ 3 ft.", "> 3 ft."}));
      comboBox_2.setBounds(323, 466, 104, 21);
      frmThatPokedex.getContentPane().add(comboBox_2);
   	
      JComboBox comboBox_3 = new JComboBox();
      comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Weight", "0 - 10 lbs", "10 - 20 lbs", "20 - 30 lbs", "30 - 40 lbs", "50 - 60 lbs", "60 - 70 lbs", "70 - 80 lbs", "80+ lbs"}));
      comboBox_3.setBounds(433, 466, 104, 21);
      frmThatPokedex.getContentPane().add(comboBox_3);
   	
   	//Apply button is made to filter what the user wants
      JButton btnNewButton_1_1_1_1_2 = new JButton("Apply");
      btnNewButton_1_1_1_1_2.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               String type = (String) comboBox.getSelectedItem();
               String gen = (String) comboBox_1.getSelectedItem();
               String size = (String) comboBox_2.getSelectedItem();
               String weight = (String) comboBox_3.getSelectedItem();
            	
            	//Individual Type filter
               if (type.equals("Bug")) {
                  list.setModel(
                     new AbstractListModel() {
                        String[] values = new String[] {"Caterpie - Bug", "Spewpa - Bug", "Metapod - Bug", "Grubbin - Bug", "Cutiefly - Bug, Fairy", "Vivillon - Bug, Flying", "Ledyba - Bug, Flying", "Spinarak - Bug, Poison"};
                        public int getSize() {
                           return values.length;
                        }
                        public Object getElementAt(int index) {
                           return values[index];
                        }
                     });
               }
               
               else if(type.equals("Bug, Fairy")) {
                  list.setModel(
                     new AbstractListModel() {
                        String[] values = new String[] {"Cutiefly - Bug, Fairy"};
                        public int getSize() {
                           return values.length;
                        }
                        public Object getElementAt(int index) {
                           return values[index];
                        }
                     });
               }
               
               else if(type.equals("Bug, Flying")) {
                  list.setModel(
                     new AbstractListModel() {
                        String[] values = new String[] {"Vivillon - Bug, Flying", "Ledyba - Bug, Flying"};
                        public int getSize() {
                           return values.length;
                        }
                        public Object getElementAt(int index) {
                           return values[index];
                        }
                     });
               }
               
               else if(type.equals("Bug, Poison")) {
                  list.setModel(
                     new AbstractListModel() {
                        String[] values = new String[] {"Spinarak - Bug, Poison"};
                        public int getSize() {
                           return values.length;
                        }
                        public Object getElementAt(int index) {
                           return values[index];
                        }
                     });
               }
               
               //Individual Generation Filter
               else if(gen.equals("Generation 1")) {
                  list.setModel(
                     new AbstractListModel() {
                        String[] values = new String[] {"Pikachu - Gen. 1", "Bulbasaur - Gen. 1", "Diglett - Gen. 1", "Squirtle - Gen. 1", "Charmander - Gen. 1", "Rattata - Gen. 1", "Pidgey - Gen. 1", "Clefairy - Gen. 1", "Jigglypuff - Gen. 1", "Vulpix - Gen 1", "Zubat - Gen. 1", "Oddish - Gen. 1", "Caterpie - Gen. 1", "Meowth - Gen. 1", "Psyduck - Gen. 1", "Poliwag - Gen. 1", "Bellsprout - Gen. 1", "Geodude - Gen. 1", "Slowpoke - Gen. 1", "Ponyta - Gen. 1", "Seel - Gen. 1", "Eevee - Gen. 1", "Metapod - Gen. 1", "Snorlax - Gen. 1", "Magikarp - Gen. 1", "Shellder - Gen. 1"};
                        public int getSize() {
                           return values.length;
                        }
                        public Object getElementAt(int index) {
                           return values[index];
                        }
                     });
               }
            	
            	//Not Individual Stuff
               if(gen.equals("Generation 1") && type.equals("Bug")) {
                  list.setModel(
                     new AbstractListModel() {
                        String[] values = new String[] {"Caterpie", "Metapod"};
                        public int getSize() {
                           return values.length;
                        }
                        public Object getElementAt(int index) {
                           return values[index];
                        }
                     });
               }
            }
         });
      btnNewButton_1_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
      btnNewButton_1_1_1_1_2.setBounds(192, 497, 115, 28);
      frmThatPokedex.getContentPane().add(btnNewButton_1_1_1_1_2);
   	
   	//Made a clear filter button, makes the JList back to normal
      JButton btnNewButton_1_1_1_1_1_1 = new JButton("Clear Filter");
      btnNewButton_1_1_1_1_1_1.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               list.setModel(
                  new AbstractListModel() {
                     String[] values = new String[] {"Absol", "Aipom", "Amaura", "Anorith", "Applin", "Azumarill", "Baltoy", "Barboach", "Bellsprout", "Bergmite", "Bulbasaur", "Carbink", "Caterpie", "Celebi", "Charmander", "Chespin", "Chinchou", "Clamperl", "Clefairy", "Cleffa", "Clobbopus", "Corphish", "Cutiefly", "Cyndaquil", "Dedenne", "Diglett", "Duskull", "Eevee", "Feebas", "Fennekin", "Froakie", "Geodude", "Goomy", "Grubbin", "Hatenna", "Hoppip", "Jigglypuff", "Kyogre", "Latias", "Ledyba", "Lileep", "Lillipup", "Litten", "Luvdisc", "Magikarp", "Mareanie", "Mareep", "Marill", "Meowth", "Metapod", "Minccino", "Mudbray", "Mudkip", "Munna", "Natu", "Oddish", "Oshawott", "Pansear", "Phantump", "Phione", "Pichu", "Pidgey", "Pikachu", "Pikipek", "Piplup", "Politoed", "Poliwag", "Ponyta", "Popplio", "Psyduck", "Pumpkaboo", "Ralts", "Rattata", "Rockruff", "Rowlet", "Seel", "Sentret", "Shaymin", "Shellder", "Sinistea", "Slowpoke", "Snivy", "Snorlax", "Snorunt", "Spewpa", "Spheal", "Spinarak", "Squirtle", "Sudowoodo", "Sylveon", "Togepi", "Torchic", "Totodile", "Toxel", "Treecko", "Turtwig", "Victini", "Vivillon", "Vulpix", "Wynaut", "Zubat"};
                     public int getSize() {
                        return values.length;
                     }
                     public Object getElementAt(int index) {
                        return values[index];
                     }
                  });
               comboBox.setModel(new DefaultComboBoxModel(new String[] {"Type", "Bug", "Bug, Fairy", "Bug, Flying", "Bug, Poison", "Dark", "Dragon", "Dragon, Psychic", "Electric", "Electric, Poison", "Fairy", "Fighting", "Fire", "Ghost ", "Ghost, Grass", "Grass", "Grass, Dragon", "Grass, Flying", "Grass, Poison", "Ground", "Ground, Psychic", "Ice", "Ice, Water", "Normal", "Normal, Fairy", "Normal, Flying", "Poison", "Poison, Flying", "Poison, Water", "Psychic", "Psychic, Fairy", "Psychic, Fire", "Psychic, Flying", "Psychic, Grass", "Rock", "Rock, Bug", "Rock, Fairy", "Rock, Grass", "Rock, Ground", "Rock, Ice", "Water", "Water, Electric", "Water, Fairy", "Water, Ground", "Water, Psychic"}));
               comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Generation", "Generation 1", "Generation 2", "Generation 3", "Generation 4", "Generation 5", "Generation 6", "Generation 7", "Generation 8"}));
               comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Size", "~ 0 ft.", "~ 1 ft.", "~ 2 ft.", "~ 3 ft.", "> 3 ft."}));
               comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Weight", "0 - 10 lbs", "10 - 20 lbs", "20 - 30 lbs", "30 - 40 lbs", "50 - 60 lbs", "60 - 70 lbs", "70 - 80 lbs", "80+ lbs"}));
            }
         });
      btnNewButton_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
      btnNewButton_1_1_1_1_1_1.setBounds(312, 497, 115, 28);
      frmThatPokedex.getContentPane().add(btnNewButton_1_1_1_1_1_1);
   	
      JSeparator separator_2 = new JSeparator();
      separator_2.setBounds(20, 449, 535, 2);
      frmThatPokedex.getContentPane().add(separator_2);
   }
}
