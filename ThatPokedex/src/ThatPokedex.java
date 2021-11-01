import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
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

public class ThatPokedex {
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
                  ThatPokedex window = new ThatPokedex();
                  window.frmThatPokedex.setVisible(true);
               } catch (Exception e) {
                  e.printStackTrace();
               }
            }
         });
   }

	/**
	 * Create the application.
	 */
   public ThatPokedex() {
      initialize();
   }

	/**
	 * Initialize the contents of the frame.
	 */
   private void initialize() {
      frmThatPokedex = new JFrame();
      frmThatPokedex.setTitle("That Pokedex");
      frmThatPokedex.setBounds(100, 100, 579, 576);
      frmThatPokedex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frmThatPokedex.getContentPane().setLayout(null);
   	
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
      btnNewButton.setBounds(440, 340, 95, 32);
      frmThatPokedex.getContentPane().add(btnNewButton);
   	
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
      btnLogOut.setBounds(440, 382, 95, 32);
      frmThatPokedex.getContentPane().add(btnLogOut);
   	
      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setBounds(20, 21, 230, 307);
      frmThatPokedex.getContentPane().add(scrollPane);
   	
      JList list = new JList();
      scrollPane.setViewportView(list);
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
   	//////////////////////////////////////////////////
   	
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
   	
      JButton btnNewButton_1_1 = new JButton("Search");
      btnNewButton_1_1.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               String input = search.getText();
               String convert = input.toLowerCase();
            	
               if(convert.contains("absol")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Absol\r\n");
                  txtrInformationAboutThe.append("Type : Dark\r\n");;
                  txtrInformationAboutThe.append("Generation : 3\r\n");
                  txtrInformationAboutThe.append("Weight : 103.6 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 3 ft. 11 in.");
               }
               
               else if(convert.contains("aipom")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Aipom\r\n");
                  txtrInformationAboutThe.append("Type : Normal\r\n");;
                  txtrInformationAboutThe.append("Generation : 2\r\n");
                  txtrInformationAboutThe.append("Weight : 25.4 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 2 ft. 07 in.");
               }
               
               else if(convert.contains("amaura")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Amaura\r\n");
                  txtrInformationAboutThe.append("Type : Rock, Ice\r\n");;
                  txtrInformationAboutThe.append("Generation : 6\r\n");
                  txtrInformationAboutThe.append("Weight : 55.6 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 4 ft. 03 in.");
               }
               
               else if(convert.contains("anorith")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Anorith\r\n");
                  txtrInformationAboutThe.append("Type : Rock, Bug\r\n");;
                  txtrInformationAboutThe.append("Generation : 3\r\n");
                  txtrInformationAboutThe.append("Weight : 27.6 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 2 ft. 04 in.");
               }
               
               else if(convert.contains("applin")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Applin\r\n");
                  txtrInformationAboutThe.append("Type : Grass, Dragon\r\n");;
                  txtrInformationAboutThe.append("Generation : 8\r\n");
                  txtrInformationAboutThe.append("Weight : 1.1 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 0 ft. 08 in.");
               }
               
               else if(convert.equals("azumarill")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Azumarill\r\n");
                  txtrInformationAboutThe.append("Type : Water, Fairy\r\n");;
                  txtrInformationAboutThe.append("Generation : 2\r\n");
                  txtrInformationAboutThe.append("Weight : 62.8 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 2 ft. 07 in.");
               }
               
               else if(convert.equals("baltoy")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Baltoy\r\n");
                  txtrInformationAboutThe.append("Type : Ground, Psychic\r\n");;
                  txtrInformationAboutThe.append("Generation : 3\r\n");
                  txtrInformationAboutThe.append("Weight : 47.4 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 1 ft. 08 in.");
               }
               
               else if(convert.equals("barboach")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Barboach\r\n");
                  txtrInformationAboutThe.append("Type : Water, Ground\r\n");;
                  txtrInformationAboutThe.append("Generation : 3\r\n");
                  txtrInformationAboutThe.append("Weight : 4.2 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 1 ft. 04 in.");
               }
               
               else if(convert.equals("bellsprout")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Bellsprout\r\n");
                  txtrInformationAboutThe.append("Type : Grass, Poison\r\n");;
                  txtrInformationAboutThe.append("Generation : 1\r\n");
                  txtrInformationAboutThe.append("Weight : 8.8 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 2 ft. 04 in.");
               }
               
               else if(convert.equals("bergmite")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Bergmite\r\n");
                  txtrInformationAboutThe.append("Type : Ice\r\n");;
                  txtrInformationAboutThe.append("Generation : 6\r\n");
                  txtrInformationAboutThe.append("Weight : 219.4 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 3 ft. 03 in.");
               }
               
               else if(convert.equals("bulbasaur")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Bulbasaur\r\n");
                  txtrInformationAboutThe.append("Type : Grass, Poison\r\n");;
                  txtrInformationAboutThe.append("Generation : 1\r\n");
                  txtrInformationAboutThe.append("Weight : 15.2 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 2 ft. 04 in.");
               }
               
               else if(convert.equals("carbink")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Carbink\r\n");
                  txtrInformationAboutThe.append("Type : Rock, Fairy\r\n");;
                  txtrInformationAboutThe.append("Generation : 6\r\n");
                  txtrInformationAboutThe.append("Weight : 12.6 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 1 ft. 00 in.");
               }
               
               else if(convert.equals("caterpie")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Caterpie\r\n");
                  txtrInformationAboutThe.append("Type : Bug\r\n");;
                  txtrInformationAboutThe.append("Generation : 1\r\n");
                  txtrInformationAboutThe.append("Weight : 6.4 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 1 ft. 00 in.");
               }
               
               else if(convert.equals("celebi")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Celebi\r\n");
                  txtrInformationAboutThe.append("Type : Psychic, Grass\r\n");;
                  txtrInformationAboutThe.append("Generation : 2\r\n");
                  txtrInformationAboutThe.append("Weight : 11.0 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 2 ft. 00 in.");
               }
               
               else if(convert.equals("charmander")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Charmander\r\n");
                  txtrInformationAboutThe.append("Type : Fire\r\n");;
                  txtrInformationAboutThe.append("Generation : 1\r\n");
                  txtrInformationAboutThe.append("Weight : 18.7 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 2 ft. 00 in.");
               }
               
               else if(convert.equals("chespin")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Chespin\r\n");
                  txtrInformationAboutThe.append("Type : Grass\r\n");;
                  txtrInformationAboutThe.append("Generation : 6\r\n");
                  txtrInformationAboutThe.append("Weight : 19.8 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 1 ft. 04 in.");
               }
               
               else if(convert.equals("chinchou")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Chinchou\r\n");
                  txtrInformationAboutThe.append("Type : Water, Electric\r\n");;
                  txtrInformationAboutThe.append("Generation : 2\r\n");
                  txtrInformationAboutThe.append("Weight : 26.5 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 1 ft. 08 in.");
               }
               
               else if(convert.equals("clamperl")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Clamperl\r\n");
                  txtrInformationAboutThe.append("Type : Water\r\n");;
                  txtrInformationAboutThe.append("Generation : 3\r\n");
                  txtrInformationAboutThe.append("Weight : 115.7 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 1 ft. 04 in.");
               }
               
               else if(convert.equals("clefairy")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Clefairy\r\n");
                  txtrInformationAboutThe.append("Type : Fairy\r\n");;
                  txtrInformationAboutThe.append("Generation : 1\r\n");
                  txtrInformationAboutThe.append("Weight : 16.5 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 2 ft. 00 in.");
               }
               
               else if(convert.equals("cleffa")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Cleffa\r\n");
                  txtrInformationAboutThe.append("Type : Fairy\r\n");;
                  txtrInformationAboutThe.append("Generation : 2\r\n");
                  txtrInformationAboutThe.append("Weight : 6.6 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 1 ft. 00 in.");
               }
               
               else if(convert.equals("clobbopus")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Clobbopus\r\n");
                  txtrInformationAboutThe.append("Type : Fighting\r\n");;
                  txtrInformationAboutThe.append("Generation : 8\r\n");
                  txtrInformationAboutThe.append("Weight : 8.8 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 2 ft. 00 in.");
               }
               
               else if(convert.equals("corphish")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Corphish\r\n");
                  txtrInformationAboutThe.append("Type : Water\r\n");;
                  txtrInformationAboutThe.append("Generation : 3\r\n");
                  txtrInformationAboutThe.append("Weight : 25.4 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 2 ft. 00 in.");
               }
               
               else if(convert.equals("cutiefly")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Cutiefly\r\n");
                  txtrInformationAboutThe.append("Type : Bug, Fairy\r\n");;
                  txtrInformationAboutThe.append("Generation : 7\r\n");
                  txtrInformationAboutThe.append("Weight : 0.4 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 0 ft. 04 in.");
               }
               
               else if(convert.equals("cyndaquil")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Cyndaquil\r\n");
                  txtrInformationAboutThe.append("Type : Fire\r\n");;
                  txtrInformationAboutThe.append("Generation : 2\r\n");
                  txtrInformationAboutThe.append("Weight : 17.4 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 1 ft. 08 in.");
               }
               
               else if(convert.equals("dedenne")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Dedenne\r\n");
                  txtrInformationAboutThe.append("Type : Fairy\r\n");;
                  txtrInformationAboutThe.append("Generation : 6\r\n");
                  txtrInformationAboutThe.append("Weight : 4.9 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 0 ft. 08 in.");
               }
               
               else if(convert.equals("diglett")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Diglett\r\n");
                  txtrInformationAboutThe.append("Type : Ground\r\n");;
                  txtrInformationAboutThe.append("Generation : 1\r\n");
                  txtrInformationAboutThe.append("Weight : 1.8 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 0 ft. 08 in.");
               }
               
               else if(convert.equals("duskull")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Duskull\r\n");
                  txtrInformationAboutThe.append("Type : Ghost\r\n");;
                  txtrInformationAboutThe.append("Generation : 3\r\n");
                  txtrInformationAboutThe.append("Weight : 33.1 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 2 ft. 07 in.");
               }
               
               else if(convert.equals("eevee")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Eevee\r\n");
                  txtrInformationAboutThe.append("Type : Normal\r\n");;
                  txtrInformationAboutThe.append("Generation : 1\r\n");
                  txtrInformationAboutThe.append("Weight : 14.3 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 1 ft. 00 in.");
               }
               
               else if(convert.equals("feebas")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Feebas\r\n");
                  txtrInformationAboutThe.append("Type : Water\r\n");;
                  txtrInformationAboutThe.append("Generation : 3\r\n");
                  txtrInformationAboutThe.append("Weight : 16.3 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 2 ft. 00 in.");
               }
               
               else if(convert.equals("fennekin")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Fennekin\r\n");
                  txtrInformationAboutThe.append("Type : Fire\r\n");;
                  txtrInformationAboutThe.append("Generation : 6\r\n");
                  txtrInformationAboutThe.append("Weight : 20.7 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 1 ft. 04 in.");
               }
               
               else if(convert.equals("froakie")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Froakie\r\n");
                  txtrInformationAboutThe.append("Type : Water\r\n");;
                  txtrInformationAboutThe.append("Generation : 6\r\n");
                  txtrInformationAboutThe.append("Weight : 15.4 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 1 ft. 00 in.");
               }
               
               else if(convert.equals("geodude")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Geodude\r\n");
                  txtrInformationAboutThe.append("Type : Rock, Ground\r\n");;
                  txtrInformationAboutThe.append("Generation : 1\r\n");
                  txtrInformationAboutThe.append("Weight : 44.1 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 1 ft. 04 in.");
               }
               
               else if(convert.equals("goomy")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Goomy\r\n");
                  txtrInformationAboutThe.append("Type : Dragon\r\n");;
                  txtrInformationAboutThe.append("Generation : 6\r\n");
                  txtrInformationAboutThe.append("Weight : 6.2 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 1 ft. 00 in.");
               }
               
               else if(convert.equals("grubbin")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Grubbin\r\n");
                  txtrInformationAboutThe.append("Type : Bug\r\n");;
                  txtrInformationAboutThe.append("Generation : 7\r\n");
                  txtrInformationAboutThe.append("Weight : 9.7 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 1 ft. 04 in.");
               }
               
               else if(convert.equals("hatenna")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Hatenna\r\n");
                  txtrInformationAboutThe.append("Type : Psychic\r\n");;
                  txtrInformationAboutThe.append("Generation : 8\r\n");
                  txtrInformationAboutThe.append("Weight : 7.5 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 1 ft. 04 in.");
               }
               
               else if(convert.equals("hoppip")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Hoppip\r\n");
                  txtrInformationAboutThe.append("Type : Grass, Flying\r\n");;
                  txtrInformationAboutThe.append("Generation : 2\r\n");
                  txtrInformationAboutThe.append("Weight : 1.1 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 1 ft. 04 in.");
               }
               
               else if(convert.equals("jigglypuff")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Jigglypuff\r\n");
                  txtrInformationAboutThe.append("Type : Normal, Fairy\r\n");;
                  txtrInformationAboutThe.append("Generation : 1\r\n");
                  txtrInformationAboutThe.append("Weight : 12.1 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 1 ft. 08 in.");
               }
               
               else if(convert.equals("kyogre")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Kyogre\r\n");
                  txtrInformationAboutThe.append("Type : Water\r\n");;
                  txtrInformationAboutThe.append("Generation : 3\r\n");
                  txtrInformationAboutThe.append("Weight : 776.0 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 14 ft. 09 in.");
               }
               
               else if(convert.equals("latias")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Latias\r\n");
                  txtrInformationAboutThe.append("Type : Dragon, Psychic\r\n");;
                  txtrInformationAboutThe.append("Generation : 3\r\n");
                  txtrInformationAboutThe.append("Weight : 88.2 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 4 ft. 07 in.");
               }
               
               else if(convert.equals("ledyba")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Ledyba\r\n");
                  txtrInformationAboutThe.append("Type : Bug, Flying\r\n");;
                  txtrInformationAboutThe.append("Generation : 2\r\n");
                  txtrInformationAboutThe.append("Weight : 23.8 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 3 ft. 03 in.");
               }
               
               else if(convert.equals("lileep")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Lileep\r\n");
                  txtrInformationAboutThe.append("Type : Rock, Grass\r\n");;
                  txtrInformationAboutThe.append("Generation : 3\r\n");
                  txtrInformationAboutThe.append("Weight : 52.5 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 3 ft. 03 in.");
               }
               
               else if(convert.equals("lillipup")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Lillipup\r\n");
                  txtrInformationAboutThe.append("Type : Normal\r\n");;
                  txtrInformationAboutThe.append("Generation : 5\r\n");
                  txtrInformationAboutThe.append("Weight : 9.0 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 1 ft. 04 in.");
               }
               
               else if(convert.equals("litten")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Litten\r\n");
                  txtrInformationAboutThe.append("Type : Fire\r\n");;
                  txtrInformationAboutThe.append("Generation : 7\r\n");
                  txtrInformationAboutThe.append("Weight : 9.5 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 1 ft. 04 in.");
               }
               
               else if(convert.equals("luvdisc")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Luvdisc\r\n");
                  txtrInformationAboutThe.append("Type : Water\r\n");;
                  txtrInformationAboutThe.append("Generation : 3\r\n");
                  txtrInformationAboutThe.append("Weight : 19.2 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 2 ft. 00 in.");
               }
               
               else if(convert.equals("magikarp")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Magikarp\r\n");
                  txtrInformationAboutThe.append("Type : Water\r\n");;
                  txtrInformationAboutThe.append("Generation : 1\r\n");
                  txtrInformationAboutThe.append("Weight : 22.0 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 2 ft. 11 in.");
               }
               
               else if(convert.equals("mareanie")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Mareanie\r\n");
                  txtrInformationAboutThe.append("Type : Poison, Water\r\n");;
                  txtrInformationAboutThe.append("Generation : 7\r\n");
                  txtrInformationAboutThe.append("Weight : 17.6 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 1 ft. 04 in.");
               }
               
               else if(convert.equals("mareep")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Mareep\r\n");
                  txtrInformationAboutThe.append("Type : Electric\r\n");;
                  txtrInformationAboutThe.append("Generation : 2\r\n");
                  txtrInformationAboutThe.append("Weight : 17.2 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 2 ft. 00 in.");
               }
               
               else if(convert.equals("marill")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Marill\r\n");
                  txtrInformationAboutThe.append("Type : Water, Fairy\r\n");;
                  txtrInformationAboutThe.append("Generation : 2\r\n");
                  txtrInformationAboutThe.append("Weight : 18.7 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 1 ft. 04 in.");
               }
               
               else if(convert.equals("meowth")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Meowth\r\n");
                  txtrInformationAboutThe.append("Type : Normal\r\n");;
                  txtrInformationAboutThe.append("Generation : 1\r\n");
                  txtrInformationAboutThe.append("Weight : 9.3 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 1 ft. 04 in.");
               }
               
               else if(convert.equals("metapod")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Metapod\r\n");
                  txtrInformationAboutThe.append("Type : Bug\r\n");;
                  txtrInformationAboutThe.append("Generation : 1\r\n");
                  txtrInformationAboutThe.append("Weight : 21.8 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 2 ft. 04 in.");
               }
               
               else if(convert.equals("minccino")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Minccino\r\n");
                  txtrInformationAboutThe.append("Type : Normal\r\n");;
                  txtrInformationAboutThe.append("Generation : 5\r\n");
                  txtrInformationAboutThe.append("Weight : 12.8 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 1 ft. 04 in.");
               }
               
               else if(convert.equals("mudbray")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Mudbray\r\n");
                  txtrInformationAboutThe.append("Type : Ground\r\n");;
                  txtrInformationAboutThe.append("Generation : 7\r\n");
                  txtrInformationAboutThe.append("Weight : 242.5 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 3 ft. 03 in.");
               }
               
               else if(convert.equals("mudkip")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Mudkip\r\n");
                  txtrInformationAboutThe.append("Type : Water\r\n");;
                  txtrInformationAboutThe.append("Generation : 3\r\n");
                  txtrInformationAboutThe.append("Weight : 16.8 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 1 ft. 04 in.");
               }
               
               else if(convert.equals("munna")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Munna\r\n");
                  txtrInformationAboutThe.append("Type : Psychic\r\n");;
                  txtrInformationAboutThe.append("Generation : 5\r\n");
                  txtrInformationAboutThe.append("Weight : 51.3 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 2 ft. 00 in.");
               }
               
               else if(convert.equals("natu")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Natu\r\n");
                  txtrInformationAboutThe.append("Type : Psychic, Flying\r\n");;
                  txtrInformationAboutThe.append("Generation : 2\r\n");
                  txtrInformationAboutThe.append("Weight : 4.4 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 0 ft. 08 in.");
               }
               
               else if(convert.equals("oddish")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Oddish\r\n");
                  txtrInformationAboutThe.append("Type : Grass, Poison\r\n");;
                  txtrInformationAboutThe.append("Generation : 1\r\n");
                  txtrInformationAboutThe.append("Weight : 11.9 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 1 ft. 08 in.");
               }
               
               else if(convert.equals("oshawott")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Oshawott\r\n");
                  txtrInformationAboutThe.append("Type : Water\r\n");;
                  txtrInformationAboutThe.append("Generation : 5\r\n");
                  txtrInformationAboutThe.append("Weight : 13.0 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 1 ft. 08 in.");
               }
               
               else if(convert.equals("pansear")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Pansear\r\n");
                  txtrInformationAboutThe.append("Type : Fire\r\n");;
                  txtrInformationAboutThe.append("Generation : 5\r\n");
                  txtrInformationAboutThe.append("Weight : 24.3 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 2 ft. 00 in.");
               }
               
               else if(convert.equals("phantump")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Phantump\r\n");
                  txtrInformationAboutThe.append("Type : Ghost, Grass\r\n");;
                  txtrInformationAboutThe.append("Generation : 6\r\n");
                  txtrInformationAboutThe.append("Weight : 15.4 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 1 ft. 04 in.");
               }
               
               else if(convert.equals("phione")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Phione\r\n");
                  txtrInformationAboutThe.append("Type : Water\r\n");;
                  txtrInformationAboutThe.append("Generation : 4\r\n");
                  txtrInformationAboutThe.append("Weight : 6.8 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 1 ft. 04 in.");
               }
               
               else if(convert.equals("pichu")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Pichu\r\n");
                  txtrInformationAboutThe.append("Type : Electric\r\n");;
                  txtrInformationAboutThe.append("Generation : 2\r\n");
                  txtrInformationAboutThe.append("Weight : 4.4 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 1 ft. 00 in.");
               }
               
               else if(convert.equals("pidgey")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Pidgey\r\n");
                  txtrInformationAboutThe.append("Type : Normal, Flying\r\n");;
                  txtrInformationAboutThe.append("Generation : 1\r\n");
                  txtrInformationAboutThe.append("Weight : 4.0 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 1 ft. 00 in.");
               }
               
               else if(convert.equals("pikachu")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Pikachu\r\n");
                  txtrInformationAboutThe.append("Type : Electric\r\n");;
                  txtrInformationAboutThe.append("Generation : 1\r\n");
                  txtrInformationAboutThe.append("Weight : 13.0 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 1 ft. 04 in.");
               }
               
               else if(convert.equals("pikipek")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Pikipek\r\n");
                  txtrInformationAboutThe.append("Type : Normal, Flying\r\n");;
                  txtrInformationAboutThe.append("Generation : 7\r\n");
                  txtrInformationAboutThe.append("Weight : 2.6 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 1 ft. 00 in.");
               }
               
               else if(convert.equals("piplup")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Piplup\r\n");
                  txtrInformationAboutThe.append("Type : Water\r\n");;
                  txtrInformationAboutThe.append("Generation : 4\r\n");
                  txtrInformationAboutThe.append("Weight : 11.5 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 1 ft. 04 in.");
               }
               
               else if(convert.equals("politoed")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Politoed\r\n");
                  txtrInformationAboutThe.append("Type : Water\r\n");;
                  txtrInformationAboutThe.append("Generation : 2\r\n");
                  txtrInformationAboutThe.append("Weight : 74.7 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 3 ft. 07 in.");
               }
               
               else if(convert.equals("poliwag")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Poliwag\r\n");
                  txtrInformationAboutThe.append("Type : Water\r\n");;
                  txtrInformationAboutThe.append("Generation : 1\r\n");
                  txtrInformationAboutThe.append("Weight : 27.3 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 2 ft. 00 in.");
               }
               
               else if(convert.equals("ponyta")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Ponyta\r\n");
                  txtrInformationAboutThe.append("Type : Fire\r\n");;
                  txtrInformationAboutThe.append("Generation : 1\r\n");
                  txtrInformationAboutThe.append("Weight : 66.1 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 3 ft. 03 in.");
               }
               
               else if(convert.equals("popplio")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Popplio\r\n");
                  txtrInformationAboutThe.append("Type : Water\r\n");;
                  txtrInformationAboutThe.append("Generation : 7\r\n");
                  txtrInformationAboutThe.append("Weight : 16.5 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 1 ft. 04 in.");
               }
               
               else if(convert.equals("psyduck")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Psyduck\r\n");
                  txtrInformationAboutThe.append("Type : Water\r\n");;
                  txtrInformationAboutThe.append("Generation : 1\r\n");
                  txtrInformationAboutThe.append("Weight : 43.2 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 2 ft. 07 in.");
               }
               
               else if(convert.equals("pumpkaboo")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Pumpkaboo\r\n");
                  txtrInformationAboutThe.append("Type : Ghost, Grass\r\n");;
                  txtrInformationAboutThe.append("Generation : 6\r\n");
                  txtrInformationAboutThe.append("Weight : 7.7 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 1 ft. 00 in.");
               }
               
               else if(convert.equals("ralts")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Ralts\r\n");
                  txtrInformationAboutThe.append("Type : Psychic, Fairy\r\n");;
                  txtrInformationAboutThe.append("Generation : 3\r\n");
                  txtrInformationAboutThe.append("Weight : 14.6 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 1 ft. 04 in.");
               }
               
               else if(convert.equals("rattata")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Rattata\r\n");
                  txtrInformationAboutThe.append("Type : Normal\r\n");;
                  txtrInformationAboutThe.append("Generation : 1\r\n");
                  txtrInformationAboutThe.append("Weight : 7.7 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 1 ft. 00 in.");
               }
               
               else if(convert.equals("rockruff")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Rockruff\r\n");
                  txtrInformationAboutThe.append("Type : Rock\r\n");;
                  txtrInformationAboutThe.append("Generation : 7\r\n");
                  txtrInformationAboutThe.append("Weight : 20.3 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 1 ft. 08 in.");
               }
               
               else if(convert.equals("rowlet")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Rowlet\r\n");
                  txtrInformationAboutThe.append("Type : Grass, Flying\r\n");;
                  txtrInformationAboutThe.append("Generation : 7\r\n");
                  txtrInformationAboutThe.append("Weight : 3.3 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 1 ft. 00 in.");
               }
               
               else if(convert.equals("seel")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Seel\r\n");
                  txtrInformationAboutThe.append("Type : Water\r\n");;
                  txtrInformationAboutThe.append("Generation : 1\r\n");
                  txtrInformationAboutThe.append("Weight : 198.4 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 3 ft. 07 in.");
               }
               
               else if(convert.equals("sentret")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Sentret\r\n");
                  txtrInformationAboutThe.append("Type : Normal\r\n");;
                  txtrInformationAboutThe.append("Generation : 2\r\n");
                  txtrInformationAboutThe.append("Weight : 13.2 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 2 ft. 07 in.");
               }
               
               else if(convert.equals("shaymin")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Shaymin\r\n");
                  txtrInformationAboutThe.append("Type : Grass\r\n");;
                  txtrInformationAboutThe.append("Generation : 4\r\n");
                  txtrInformationAboutThe.append("Weight : 4.6 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 0 ft. 08 in.");
               }
               
               else if(convert.equals("shellder")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Shellder\r\n");
                  txtrInformationAboutThe.append("Type : Water\r\n");;
                  txtrInformationAboutThe.append("Generation : 1\r\n");
                  txtrInformationAboutThe.append("Weight : 8.8 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 1 ft. 00 in.");
               }
               
               else if(convert.equals("sinistea")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Sinistea\r\n");
                  txtrInformationAboutThe.append("Type : Ghost\r\n");;
                  txtrInformationAboutThe.append("Generation : 8\r\n");
                  txtrInformationAboutThe.append("Weight : 0.4 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 0 ft. 04 in.");
               }
               
               else if(convert.equals("slowpoke")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Slowpoke\r\n");
                  txtrInformationAboutThe.append("Type : Water, Psychic\r\n");;
                  txtrInformationAboutThe.append("Generation : 1\r\n");
                  txtrInformationAboutThe.append("Weight : 79.4 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 3 ft. 11 in.");
               }
               
               else if(convert.equals("snivy")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Snivy\r\n");
                  txtrInformationAboutThe.append("Type : Grass\r\n");;
                  txtrInformationAboutThe.append("Generation : 5\r\n");
                  txtrInformationAboutThe.append("Weight : 17.9 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 2 ft. 00 in.");
               }
               
               else if(convert.equals("snorlax")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Snorlax\r\n");
                  txtrInformationAboutThe.append("Type : Normal\r\n");;
                  txtrInformationAboutThe.append("Generation : 1\r\n");
                  txtrInformationAboutThe.append("Weight : 1014.1 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 6 ft. 11 in.");
               }
               
               else if(convert.equals("snorunt")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Snorunt\r\n");
                  txtrInformationAboutThe.append("Type : Ice\r\n");;
                  txtrInformationAboutThe.append("Generation : 3\r\n");
                  txtrInformationAboutThe.append("Weight : 37.0 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 2 ft. 04 in.");
               }
               
               else if(convert.equals("spewpa")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Spewpa\r\n");
                  txtrInformationAboutThe.append("Type : Bug\r\n");;
                  txtrInformationAboutThe.append("Generation : 6\r\n");
                  txtrInformationAboutThe.append("Weight : 18.5 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 1 ft. 00 in.");
               }
               
               else if(convert.equals("spinarak")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Spinarak\r\n");
                  txtrInformationAboutThe.append("Type : Bug, Poison\r\n");;
                  txtrInformationAboutThe.append("Generation : 2\r\n");
                  txtrInformationAboutThe.append("Weight : 18.7 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 1 ft. 08 in.");
               }
               
               else if(convert.equals("squirtle")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Squirtle\r\n");
                  txtrInformationAboutThe.append("Type : Water\r\n");;
                  txtrInformationAboutThe.append("Generation : 1\r\n");
                  txtrInformationAboutThe.append("Weight : 19.8 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 1 ft. 08 in.");
               }
               
               else if(convert.equals("sudowoodo")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Sudowoodo\r\n");
                  txtrInformationAboutThe.append("Type : Rock\r\n");;
                  txtrInformationAboutThe.append("Generation : 2\r\n");
                  txtrInformationAboutThe.append("Weight : 83.8 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 3 ft. 11 in.");
               }
               
               else if(convert.equals("sylveon")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Sylveon\r\n");
                  txtrInformationAboutThe.append("Type : Fairy\r\n");;
                  txtrInformationAboutThe.append("Generation : 6\r\n");
                  txtrInformationAboutThe.append("Weight : 51.8 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 3 ft. 03 in.");
               }
               
               else if(convert.equals("togepi")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Togepi\r\n");
                  txtrInformationAboutThe.append("Type : Fairy\r\n");;
                  txtrInformationAboutThe.append("Generation : 2\r\n");
                  txtrInformationAboutThe.append("Weight : 3.3 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 1 ft. 00 in.");
               }
               
               else if(convert.equals("torchic")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Torchic\r\n");
                  txtrInformationAboutThe.append("Type : Fire\r\n");;
                  txtrInformationAboutThe.append("Generation : 3\r\n");
                  txtrInformationAboutThe.append("Weight : 5.5 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 1 ft. 04 in.");
               }
               
               else if(convert.equals("totodile")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Totodile\r\n");
                  txtrInformationAboutThe.append("Type : Water\r\n");;
                  txtrInformationAboutThe.append("Generation : 2\r\n");
                  txtrInformationAboutThe.append("Weight : 20.9 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 2 ft. 00 in.");
               }
               
               else if(convert.equals("toxel")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Toxel\r\n");
                  txtrInformationAboutThe.append("Type : Electric, Poison\r\n");;
                  txtrInformationAboutThe.append("Generation : 8\r\n");
                  txtrInformationAboutThe.append("Weight : 24.3 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 1 ft. 04 in.");
               }
               
               else if(convert.equals("treecko")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Treecko\r\n");
                  txtrInformationAboutThe.append("Type : Grass\r\n");;
                  txtrInformationAboutThe.append("Generation : 3\r\n");
                  txtrInformationAboutThe.append("Weight : 11.0 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 1 ft. 08 in.");
               }
               
               else if(convert.equals("turtwig")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Turtwig\r\n");
                  txtrInformationAboutThe.append("Type : Grass\r\n");;
                  txtrInformationAboutThe.append("Generation : 4\r\n");
                  txtrInformationAboutThe.append("Weight : 22.5 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 1 ft. 04 in.");
               }
               
               else if(convert.equals("victini")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Victini\r\n");
                  txtrInformationAboutThe.append("Type : Psychic, Fire\r\n");;
                  txtrInformationAboutThe.append("Generation : 5\r\n");
                  txtrInformationAboutThe.append("Weight : 8.8 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 1 ft. 04 in.");
               }
               
               else if(convert.equals("vivillon")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Vivillon\r\n");
                  txtrInformationAboutThe.append("Type : Bug, Flying\r\n");;
                  txtrInformationAboutThe.append("Generation : 6\r\n");
                  txtrInformationAboutThe.append("Weight : 37.5 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 3 ft. 11 in.");
               }
               
               else if(convert.equals("vulpix")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Vulpix\r\n");
                  txtrInformationAboutThe.append("Type : Fire\r\n");;
                  txtrInformationAboutThe.append("Generation : 1\r\n");
                  txtrInformationAboutThe.append("Weight : 21.8 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 2 ft. 00 in.");
               }
               
               else if(convert.equals("wynaut")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Wynaut\r\n");
                  txtrInformationAboutThe.append("Type : Psychic\r\n");;
                  txtrInformationAboutThe.append("Generation : 3\r\n");
                  txtrInformationAboutThe.append("Weight : 30.9 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 2 ft. 00 in.");
               }
               
               else if(convert.equals("zubat")) {
                  txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                  txtrInformationAboutThe.setText("Zubat\r\n");
                  txtrInformationAboutThe.append("Type : Poison, Flying\r\n");;
                  txtrInformationAboutThe.append("Generation : 1\r\n");
                  txtrInformationAboutThe.append("Weight : 16.5 lbs\r\n");
                  txtrInformationAboutThe.append("Size : 2 ft. 07 in.");
               }
               
               else {
                  JOptionPane.showMessageDialog(null, "Pokemon not available or spelling is wrong.", "That Pokedex Search Error", JOptionPane.ERROR_MESSAGE);
                  search.setText(null);
               }
            }
         });
   	
   	
      btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
      btnNewButton_1_1.setBounds(247, 395, 88, 28);
      frmThatPokedex.getContentPane().add(btnNewButton_1_1);
   	
      JButton btnNewButton_1 = new JButton("Select");
      btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
      btnNewButton_1.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               try {
                  String pokemon = list.getSelectedValue().toString();
                  if(pokemon.contains("Absol")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Absol\r\n");
                     txtrInformationAboutThe.append("Type : Dark\r\n");;
                     txtrInformationAboutThe.append("Generation : 3\r\n");
                     txtrInformationAboutThe.append("Weight : 103.6 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 3 ft. 11 in.");
                  }
                  
                  else if(pokemon.contains("Aipom")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Aipom\r\n");
                     txtrInformationAboutThe.append("Type : Normal\r\n");;
                     txtrInformationAboutThe.append("Generation : 2\r\n");
                     txtrInformationAboutThe.append("Weight : 25.4 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 2 ft. 07 in.");
                  }
                  
                  else if(pokemon.contains("Amaura")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Amaura\r\n");
                     txtrInformationAboutThe.append("Type : Rock, Ice\r\n");;
                     txtrInformationAboutThe.append("Generation : 6\r\n");
                     txtrInformationAboutThe.append("Weight : 55.6 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 4 ft. 03 in.");
                  }
                  
                  else if(pokemon.contains("Anorith")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Anorith\r\n");
                     txtrInformationAboutThe.append("Type : Rock, Bug\r\n");;
                     txtrInformationAboutThe.append("Generation : 3\r\n");
                     txtrInformationAboutThe.append("Weight : 27.6 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 2 ft. 04 in.");
                  }
                  
                  else if(pokemon.contains("Applin")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Applin\r\n");
                     txtrInformationAboutThe.append("Type : Grass, Dragon\r\n");;
                     txtrInformationAboutThe.append("Generation : 8\r\n");
                     txtrInformationAboutThe.append("Weight : 1.1 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 0 ft. 08 in.");
                  }
                  
                  else if(pokemon.contains("Azumarill")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Azumarill\r\n");
                     txtrInformationAboutThe.append("Type : Water, Fairy\r\n");;
                     txtrInformationAboutThe.append("Generation : 2\r\n");
                     txtrInformationAboutThe.append("Weight : 62.8 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 2 ft. 07 in.");
                  }
                  
                  else if(pokemon.contains("Baltoy")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Baltoy\r\n");
                     txtrInformationAboutThe.append("Type : Ground, Psychic\r\n");;
                     txtrInformationAboutThe.append("Generation : 3\r\n");
                     txtrInformationAboutThe.append("Weight : 47.4 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 1 ft. 08 in.");
                  }
                  
                  else if(pokemon.contains("Barboach")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Barboach\r\n");
                     txtrInformationAboutThe.append("Type : Water, Ground\r\n");;
                     txtrInformationAboutThe.append("Generation : 3\r\n");
                     txtrInformationAboutThe.append("Weight : 4.2 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 1 ft. 04 in.");
                  }
                  
                  else if(pokemon.contains("Bellsprout")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Bellsprout\r\n");
                     txtrInformationAboutThe.append("Type : Grass, Poison\r\n");;
                     txtrInformationAboutThe.append("Generation : 1\r\n");
                     txtrInformationAboutThe.append("Weight : 8.8 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 2 ft. 04 in.");
                  }
                  
                  else if(pokemon.contains("Bergmite")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Bergmite\r\n");
                     txtrInformationAboutThe.append("Type : Ice\r\n");;
                     txtrInformationAboutThe.append("Generation : 6\r\n");
                     txtrInformationAboutThe.append("Weight : 219.4 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 3 ft. 03 in.");
                  }
                  
                  else if(pokemon.contains("Bulbasaur")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Bulbasaur\r\n");
                     txtrInformationAboutThe.append("Type : Grass, Poison\r\n");;
                     txtrInformationAboutThe.append("Generation : 1\r\n");
                     txtrInformationAboutThe.append("Weight : 15.2 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 2 ft. 04 in.");
                  }
                  
                  else if(pokemon.contains("Carbink")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Carbink\r\n");
                     txtrInformationAboutThe.append("Type : Rock, Fairy\r\n");;
                     txtrInformationAboutThe.append("Generation : 6\r\n");
                     txtrInformationAboutThe.append("Weight : 12.6 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 1 ft. 00 in.");
                  }
                  
                  else if(pokemon.contains("Caterpie")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Caterpie\r\n");
                     txtrInformationAboutThe.append("Type : Bug\r\n");;
                     txtrInformationAboutThe.append("Generation : 1\r\n");
                     txtrInformationAboutThe.append("Weight : 6.4 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 1 ft. 00 in.");
                  }
                  
                  else if(pokemon.contains("Celebi")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Celebi\r\n");
                     txtrInformationAboutThe.append("Type : Psychic, Grass\r\n");;
                     txtrInformationAboutThe.append("Generation : 2\r\n");
                     txtrInformationAboutThe.append("Weight : 11.0 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 2 ft. 00 in.");
                  }
                  
                  else if(pokemon.contains("Charmander")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Charmander\r\n");
                     txtrInformationAboutThe.append("Type : Fire\r\n");;
                     txtrInformationAboutThe.append("Generation : 1\r\n");
                     txtrInformationAboutThe.append("Weight : 18.7 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 2 ft. 00 in.");
                  }
                  
                  else if(pokemon.contains("Chespin")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Chespin\r\n");
                     txtrInformationAboutThe.append("Type : Grass\r\n");;
                     txtrInformationAboutThe.append("Generation : 6\r\n");
                     txtrInformationAboutThe.append("Weight : 19.8 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 1 ft. 04 in.");
                  }
                  
                  else if(pokemon.contains("Chinchou")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Chinchou\r\n");
                     txtrInformationAboutThe.append("Type : Water, Electric\r\n");;
                     txtrInformationAboutThe.append("Generation : 2\r\n");
                     txtrInformationAboutThe.append("Weight : 26.5 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 1 ft. 08 in.");
                  }
                  
                  else if(pokemon.contains("Clamperl")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Clamperl\r\n");
                     txtrInformationAboutThe.append("Type : Water\r\n");;
                     txtrInformationAboutThe.append("Generation : 3\r\n");
                     txtrInformationAboutThe.append("Weight : 115.7 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 1 ft. 04 in.");
                  }
                  
                  else if(pokemon.contains("Clefairy")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Clefairy\r\n");
                     txtrInformationAboutThe.append("Type : Fairy\r\n");;
                     txtrInformationAboutThe.append("Generation : 1\r\n");
                     txtrInformationAboutThe.append("Weight : 16.5 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 2 ft. 00 in.");
                  }
                  
                  else if(pokemon.contains("Cleffa")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Cleffa\r\n");
                     txtrInformationAboutThe.append("Type : Fairy\r\n");;
                     txtrInformationAboutThe.append("Generation : 2\r\n");
                     txtrInformationAboutThe.append("Weight : 6.6 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 1 ft. 00 in.");
                  }
                  
                  else if(pokemon.contains("Clobbopus")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Clobbopus\r\n");
                     txtrInformationAboutThe.append("Type : Fighting\r\n");;
                     txtrInformationAboutThe.append("Generation : 8\r\n");
                     txtrInformationAboutThe.append("Weight : 8.8 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 2 ft. 00 in.");
                  }
                  
                  else if(pokemon.contains("Corphish")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Corphish\r\n");
                     txtrInformationAboutThe.append("Type : Water\r\n");;
                     txtrInformationAboutThe.append("Generation : 3\r\n");
                     txtrInformationAboutThe.append("Weight : 25.4 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 2 ft. 00 in.");
                  }
                  
                  else if(pokemon.contains("Cutiefly")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Cutiefly\r\n");
                     txtrInformationAboutThe.append("Type : Bug, Fairy\r\n");;
                     txtrInformationAboutThe.append("Generation : 7\r\n");
                     txtrInformationAboutThe.append("Weight : 0.4 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 0 ft. 04 in.");
                  }
                  
                  else if(pokemon.contains("Cyndaquil")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Cyndaquil\r\n");
                     txtrInformationAboutThe.append("Type : Fire\r\n");;
                     txtrInformationAboutThe.append("Generation : 2\r\n");
                     txtrInformationAboutThe.append("Weight : 17.4 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 1 ft. 08 in.");
                  }
                  
                  else if(pokemon.contains("Dedenne")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Dedenne\r\n");
                     txtrInformationAboutThe.append("Type : Fairy\r\n");;
                     txtrInformationAboutThe.append("Generation : 6\r\n");
                     txtrInformationAboutThe.append("Weight : 4.9 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 0 ft. 08 in.");
                  }
                  
                  else if(pokemon.contains("Diglett")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Diglett\r\n");
                     txtrInformationAboutThe.append("Type : Ground\r\n");;
                     txtrInformationAboutThe.append("Generation : 1\r\n");
                     txtrInformationAboutThe.append("Weight : 1.8 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 0 ft. 08 in.");
                  }
                  
                  else if(pokemon.contains("Duskull")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Duskull\r\n");
                     txtrInformationAboutThe.append("Type : Ghost\r\n");;
                     txtrInformationAboutThe.append("Generation : 3\r\n");
                     txtrInformationAboutThe.append("Weight : 33.1 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 2 ft. 07 in.");
                  }
                  
                  else if(pokemon.contains("Eevee")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Eevee\r\n");
                     txtrInformationAboutThe.append("Type : Normal\r\n");;
                     txtrInformationAboutThe.append("Generation : 1\r\n");
                     txtrInformationAboutThe.append("Weight : 14.3 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 1 ft. 00 in.");
                  }
                  
                  else if(pokemon.contains("Feebas")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Feebas\r\n");
                     txtrInformationAboutThe.append("Type : Water\r\n");;
                     txtrInformationAboutThe.append("Generation : 3\r\n");
                     txtrInformationAboutThe.append("Weight : 16.3 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 2 ft. 00 in.");
                  }
                  
                  else if(pokemon.contains("Fennekin")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Fennekin\r\n");
                     txtrInformationAboutThe.append("Type : Fire\r\n");;
                     txtrInformationAboutThe.append("Generation : 6\r\n");
                     txtrInformationAboutThe.append("Weight : 20.7 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 1 ft. 04 in.");
                  }
                  
                  else if(pokemon.contains("Froakie")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Froakie\r\n");
                     txtrInformationAboutThe.append("Type : Water\r\n");;
                     txtrInformationAboutThe.append("Generation : 6\r\n");
                     txtrInformationAboutThe.append("Weight : 15.4 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 1 ft. 00 in.");
                  }
                  
                  else if(pokemon.contains("Geodude")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Geodude\r\n");
                     txtrInformationAboutThe.append("Type : Rock, Ground\r\n");;
                     txtrInformationAboutThe.append("Generation : 1\r\n");
                     txtrInformationAboutThe.append("Weight : 44.1 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 1 ft. 04 in.");
                  }
                  
                  else if(pokemon.contains("Goomy")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Goomy\r\n");
                     txtrInformationAboutThe.append("Type : Dragon\r\n");;
                     txtrInformationAboutThe.append("Generation : 6\r\n");
                     txtrInformationAboutThe.append("Weight : 6.2 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 1 ft. 00 in.");
                  }
                  
                  else if(pokemon.contains("Grubbin")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Grubbin\r\n");
                     txtrInformationAboutThe.append("Type : Bug\r\n");;
                     txtrInformationAboutThe.append("Generation : 7\r\n");
                     txtrInformationAboutThe.append("Weight : 9.7 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 1 ft. 04 in.");
                  }
                  
                  else if(pokemon.contains("Hatenna")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Hatenna\r\n");
                     txtrInformationAboutThe.append("Type : Psychic\r\n");;
                     txtrInformationAboutThe.append("Generation : 8\r\n");
                     txtrInformationAboutThe.append("Weight : 7.5 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 1 ft. 04 in.");
                  }
                  
                  else if(pokemon.contains("Hoppip")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Hoppip\r\n");
                     txtrInformationAboutThe.append("Type : Grass, Flying\r\n");;
                     txtrInformationAboutThe.append("Generation : 2\r\n");
                     txtrInformationAboutThe.append("Weight : 1.1 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 1 ft. 04 in.");
                  }
                  
                  else if(pokemon.contains("Jigglypuff")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Jigglypuff\r\n");
                     txtrInformationAboutThe.append("Type : Normal, Fairy\r\n");;
                     txtrInformationAboutThe.append("Generation : 1\r\n");
                     txtrInformationAboutThe.append("Weight : 12.1 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 1 ft. 08 in.");
                  }
                  
                  else if(pokemon.contains("Kyogre")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Kyogre\r\n");
                     txtrInformationAboutThe.append("Type : Water\r\n");;
                     txtrInformationAboutThe.append("Generation : 3\r\n");
                     txtrInformationAboutThe.append("Weight : 776.0 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 14 ft. 09 in.");
                  }
                  
                  else if(pokemon.contains("Latias")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Latias\r\n");
                     txtrInformationAboutThe.append("Type : Dragon, Psychic\r\n");;
                     txtrInformationAboutThe.append("Generation : 3\r\n");
                     txtrInformationAboutThe.append("Weight : 88.2 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 4 ft. 07 in.");
                  }
                  
                  else if(pokemon.contains("Ledyba")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Ledyba\r\n");
                     txtrInformationAboutThe.append("Type : Bug, Flying\r\n");;
                     txtrInformationAboutThe.append("Generation : 2\r\n");
                     txtrInformationAboutThe.append("Weight : 23.8 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 3 ft. 03 in.");
                  }
                  
                  else if(pokemon.contains("Lileep")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Lileep\r\n");
                     txtrInformationAboutThe.append("Type : Rock, Grass\r\n");;
                     txtrInformationAboutThe.append("Generation : 3\r\n");
                     txtrInformationAboutThe.append("Weight : 52.5 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 3 ft. 03 in.");
                  }
                  
                  else if(pokemon.contains("Lillipup")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Lillipup\r\n");
                     txtrInformationAboutThe.append("Type : Normal\r\n");;
                     txtrInformationAboutThe.append("Generation : 5\r\n");
                     txtrInformationAboutThe.append("Weight : 9.0 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 1 ft. 04 in.");
                  }
                  
                  else if(pokemon.contains("Litten")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Litten\r\n");
                     txtrInformationAboutThe.append("Type : Fire\r\n");;
                     txtrInformationAboutThe.append("Generation : 7\r\n");
                     txtrInformationAboutThe.append("Weight : 9.5 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 1 ft. 04 in.");
                  }
                  
                  else if(pokemon.contains("Luvdisc")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Luvdisc\r\n");
                     txtrInformationAboutThe.append("Type : Water\r\n");;
                     txtrInformationAboutThe.append("Generation : 3\r\n");
                     txtrInformationAboutThe.append("Weight : 19.2 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 2 ft. 00 in.");
                  }
                  
                  else if(pokemon.contains("Magikarp")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Magikarp\r\n");
                     txtrInformationAboutThe.append("Type : Water\r\n");;
                     txtrInformationAboutThe.append("Generation : 1\r\n");
                     txtrInformationAboutThe.append("Weight : 22.0 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 2 ft. 11 in.");
                  }
                  
                  else if(pokemon.contains("Mareanie")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Mareanie\r\n");
                     txtrInformationAboutThe.append("Type : Poison, Water\r\n");;
                     txtrInformationAboutThe.append("Generation : 7\r\n");
                     txtrInformationAboutThe.append("Weight : 17.6 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 1 ft. 04 in.");
                  }
                  
                  else if(pokemon.contains("Mareep")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Mareep\r\n");
                     txtrInformationAboutThe.append("Type : Electric\r\n");;
                     txtrInformationAboutThe.append("Generation : 2\r\n");
                     txtrInformationAboutThe.append("Weight : 17.2 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 2 ft. 00 in.");
                  }
                  
                  else if(pokemon.contains("Marill")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Marill\r\n");
                     txtrInformationAboutThe.append("Type : Water, Fairy\r\n");;
                     txtrInformationAboutThe.append("Generation : 2\r\n");
                     txtrInformationAboutThe.append("Weight : 18.7 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 1 ft. 04 in.");
                  }
                  
                  else if(pokemon.contains("Meowth")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Meowth\r\n");
                     txtrInformationAboutThe.append("Type : Normal\r\n");;
                     txtrInformationAboutThe.append("Generation : 1\r\n");
                     txtrInformationAboutThe.append("Weight : 9.3 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 1 ft. 04 in.");
                  }
                  
                  else if(pokemon.contains("Metapod")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Metapod\r\n");
                     txtrInformationAboutThe.append("Type : Bug\r\n");;
                     txtrInformationAboutThe.append("Generation : 1\r\n");
                     txtrInformationAboutThe.append("Weight : 21.8 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 2 ft. 04 in.");
                  }
                  
                  else if(pokemon.contains("Minccino")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Minccino\r\n");
                     txtrInformationAboutThe.append("Type : Normal\r\n");;
                     txtrInformationAboutThe.append("Generation : 5\r\n");
                     txtrInformationAboutThe.append("Weight : 12.8 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 1 ft. 04 in.");
                  }
                  
                  else if(pokemon.contains("Mudbray")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Mudbray\r\n");
                     txtrInformationAboutThe.append("Type : Ground\r\n");;
                     txtrInformationAboutThe.append("Generation : 7\r\n");
                     txtrInformationAboutThe.append("Weight : 242.5 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 3 ft. 03 in.");
                  }
                  
                  else if(pokemon.contains("Mudkip")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Mudkip\r\n");
                     txtrInformationAboutThe.append("Type : Water\r\n");;
                     txtrInformationAboutThe.append("Generation : 3\r\n");
                     txtrInformationAboutThe.append("Weight : 16.8 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 1 ft. 04 in.");
                  }
                  
                  else if(pokemon.contains("Munna")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Munna\r\n");
                     txtrInformationAboutThe.append("Type : Psychic\r\n");;
                     txtrInformationAboutThe.append("Generation : 5\r\n");
                     txtrInformationAboutThe.append("Weight : 51.3 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 2 ft. 00 in.");
                  }
                  
                  else if(pokemon.contains("Natu")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Natu\r\n");
                     txtrInformationAboutThe.append("Type : Psychic, Flying\r\n");;
                     txtrInformationAboutThe.append("Generation : 2\r\n");
                     txtrInformationAboutThe.append("Weight : 4.4 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 0 ft. 08 in.");
                  }
                  
                  else if(pokemon.contains("Oddish")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Oddish\r\n");
                     txtrInformationAboutThe.append("Type : Grass, Poison\r\n");;
                     txtrInformationAboutThe.append("Generation : 1\r\n");
                     txtrInformationAboutThe.append("Weight : 11.9 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 1 ft. 08 in.");
                  }
                  
                  else if(pokemon.contains("Oshawott")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Oshawott\r\n");
                     txtrInformationAboutThe.append("Type : Water\r\n");;
                     txtrInformationAboutThe.append("Generation : 5\r\n");
                     txtrInformationAboutThe.append("Weight : 13.0 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 1 ft. 08 in.");
                  }
                  
                  else if(pokemon.contains("Pansear")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Pansear\r\n");
                     txtrInformationAboutThe.append("Type : Fire\r\n");;
                     txtrInformationAboutThe.append("Generation : 5\r\n");
                     txtrInformationAboutThe.append("Weight : 24.3 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 2 ft. 00 in.");
                  }
                  
                  else if(pokemon.contains("Phantump")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Phantump\r\n");
                     txtrInformationAboutThe.append("Type : Ghost, Grass\r\n");;
                     txtrInformationAboutThe.append("Generation : 6\r\n");
                     txtrInformationAboutThe.append("Weight : 15.4 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 1 ft. 04 in.");
                  }
                  
                  else if(pokemon.contains("Phione")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Phione\r\n");
                     txtrInformationAboutThe.append("Type : Water\r\n");;
                     txtrInformationAboutThe.append("Generation : 4\r\n");
                     txtrInformationAboutThe.append("Weight : 6.8 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 1 ft. 04 in.");
                  }
                  
                  else if(pokemon.contains("Pichu")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Pichu\r\n");
                     txtrInformationAboutThe.append("Type : Electric\r\n");;
                     txtrInformationAboutThe.append("Generation : 2\r\n");
                     txtrInformationAboutThe.append("Weight : 4.4 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 1 ft. 00 in.");
                  }
                  
                  else if(pokemon.contains("Pidgey")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Pidgey\r\n");
                     txtrInformationAboutThe.append("Type : Normal, Flying\r\n");;
                     txtrInformationAboutThe.append("Generation : 1\r\n");
                     txtrInformationAboutThe.append("Weight : 4.0 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 1 ft. 00 in.");
                  }
                  
                  else if(pokemon.contains("Pikachu")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Pikachu\r\n");
                     txtrInformationAboutThe.append("Type : Electric\r\n");;
                     txtrInformationAboutThe.append("Generation : 1\r\n");
                     txtrInformationAboutThe.append("Weight : 13.0 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 1 ft. 04 in.");
                  }
                  
                  else if(pokemon.contains("Pikipek")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Pikipek\r\n");
                     txtrInformationAboutThe.append("Type : Normal, Flying\r\n");;
                     txtrInformationAboutThe.append("Generation : 7\r\n");
                     txtrInformationAboutThe.append("Weight : 2.6 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 1 ft. 00 in.");
                  }
                  
                  else if(pokemon.contains("Piplup")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Piplup\r\n");
                     txtrInformationAboutThe.append("Type : Water\r\n");;
                     txtrInformationAboutThe.append("Generation : 4\r\n");
                     txtrInformationAboutThe.append("Weight : 11.5 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 1 ft. 04 in.");
                  }
                  
                  else if(pokemon.contains("Politoed")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Politoed\r\n");
                     txtrInformationAboutThe.append("Type : Water\r\n");;
                     txtrInformationAboutThe.append("Generation : 2\r\n");
                     txtrInformationAboutThe.append("Weight : 74.7 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 3 ft. 07 in.");
                  }
                  
                  else if(pokemon.contains("Poliwag")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Poliwag\r\n");
                     txtrInformationAboutThe.append("Type : Water\r\n");;
                     txtrInformationAboutThe.append("Generation : 1\r\n");
                     txtrInformationAboutThe.append("Weight : 27.3 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 2 ft. 00 in.");
                  }
                  
                  else if(pokemon.contains("Ponyta")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Ponyta\r\n");
                     txtrInformationAboutThe.append("Type : Fire\r\n");;
                     txtrInformationAboutThe.append("Generation : 1\r\n");
                     txtrInformationAboutThe.append("Weight : 66.1 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 3 ft. 03 in.");
                  }
                  
                  else if(pokemon.contains("Popplio")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Popplio\r\n");
                     txtrInformationAboutThe.append("Type : Water\r\n");;
                     txtrInformationAboutThe.append("Generation : 7\r\n");
                     txtrInformationAboutThe.append("Weight : 16.5 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 1 ft. 04 in.");
                  }
                  
                  else if(pokemon.contains("Psyduck")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Psyduck\r\n");
                     txtrInformationAboutThe.append("Type : Water\r\n");;
                     txtrInformationAboutThe.append("Generation : 1\r\n");
                     txtrInformationAboutThe.append("Weight : 43.2 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 2 ft. 07 in.");
                  }
                  
                  else if(pokemon.contains("Pumpkaboo")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Pumpkaboo\r\n");
                     txtrInformationAboutThe.append("Type : Ghost, Grass\r\n");;
                     txtrInformationAboutThe.append("Generation : 6\r\n");
                     txtrInformationAboutThe.append("Weight : 7.7 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 1 ft. 00 in.");
                  }
                  
                  else if(pokemon.contains("Ralts")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Ralts\r\n");
                     txtrInformationAboutThe.append("Type : Psychic, Fairy\r\n");;
                     txtrInformationAboutThe.append("Generation : 3\r\n");
                     txtrInformationAboutThe.append("Weight : 14.6 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 1 ft. 04 in.");
                  }
                  
                  else if(pokemon.contains("Rattata")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Rattata\r\n");
                     txtrInformationAboutThe.append("Type : Normal\r\n");;
                     txtrInformationAboutThe.append("Generation : 1\r\n");
                     txtrInformationAboutThe.append("Weight : 7.7 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 1 ft. 00 in.");
                  }
                  
                  else if(pokemon.contains("Rockruff")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Rockruff\r\n");
                     txtrInformationAboutThe.append("Type : Rock\r\n");;
                     txtrInformationAboutThe.append("Generation : 7\r\n");
                     txtrInformationAboutThe.append("Weight : 20.3 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 1 ft. 08 in.");
                  }
                  
                  else if(pokemon.contains("Rowlet")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Rowlet\r\n");
                     txtrInformationAboutThe.append("Type : Grass, Flying\r\n");;
                     txtrInformationAboutThe.append("Generation : 7\r\n");
                     txtrInformationAboutThe.append("Weight : 3.3 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 1 ft. 00 in.");
                  }
                  
                  else if(pokemon.contains("Seel")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Seel\r\n");
                     txtrInformationAboutThe.append("Type : Water\r\n");;
                     txtrInformationAboutThe.append("Generation : 1\r\n");
                     txtrInformationAboutThe.append("Weight : 198.4 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 3 ft. 07 in.");
                  }
                  
                  else if(pokemon.contains("Sentret")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Sentret\r\n");
                     txtrInformationAboutThe.append("Type : Normal\r\n");;
                     txtrInformationAboutThe.append("Generation : 2\r\n");
                     txtrInformationAboutThe.append("Weight : 13.2 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 2 ft. 07 in.");
                  }
                  
                  else if(pokemon.contains("Shaymin")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Shaymin\r\n");
                     txtrInformationAboutThe.append("Type : Grass\r\n");;
                     txtrInformationAboutThe.append("Generation : 4\r\n");
                     txtrInformationAboutThe.append("Weight : 4.6 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 0 ft. 08 in.");
                  }
                  
                  else if(pokemon.contains("Shellder")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Shellder\r\n");
                     txtrInformationAboutThe.append("Type : Water\r\n");;
                     txtrInformationAboutThe.append("Generation : 1\r\n");
                     txtrInformationAboutThe.append("Weight : 8.8 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 1 ft. 00 in.");
                  }
                  
                  else if(pokemon.contains("Sinistea")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Sinistea\r\n");
                     txtrInformationAboutThe.append("Type : Ghost\r\n");;
                     txtrInformationAboutThe.append("Generation : 8\r\n");
                     txtrInformationAboutThe.append("Weight : 0.4 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 0 ft. 04 in.");
                  }
                  
                  else if(pokemon.contains("Slowpoke")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Slowpoke\r\n");
                     txtrInformationAboutThe.append("Type : Water, Psychic\r\n");;
                     txtrInformationAboutThe.append("Generation : 1\r\n");
                     txtrInformationAboutThe.append("Weight : 79.4 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 3 ft. 11 in.");
                  }
                  
                  else if(pokemon.contains("Snivy")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Snivy\r\n");
                     txtrInformationAboutThe.append("Type : Grass\r\n");;
                     txtrInformationAboutThe.append("Generation : 5\r\n");
                     txtrInformationAboutThe.append("Weight : 17.9 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 2 ft. 00 in.");
                  }
                  
                  else if(pokemon.contains("Snorlax")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Snorlax\r\n");
                     txtrInformationAboutThe.append("Type : Normal\r\n");;
                     txtrInformationAboutThe.append("Generation : 1\r\n");
                     txtrInformationAboutThe.append("Weight : 1014.1 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 6 ft. 11 in.");
                  }
                  
                  else if(pokemon.contains("Snorunt")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Snorunt\r\n");
                     txtrInformationAboutThe.append("Type : Ice\r\n");;
                     txtrInformationAboutThe.append("Generation : 3\r\n");
                     txtrInformationAboutThe.append("Weight : 37.0 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 2 ft. 04 in.");
                  }
                  
                  else if(pokemon.contains("Spewpa")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Spewpa\r\n");
                     txtrInformationAboutThe.append("Type : Bug\r\n");;
                     txtrInformationAboutThe.append("Generation : 6\r\n");
                     txtrInformationAboutThe.append("Weight : 18.5 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 1 ft. 00 in.");
                  }
                  
                  else if(pokemon.contains("Spinarak")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Spinarak\r\n");
                     txtrInformationAboutThe.append("Type : Bug, Poison\r\n");;
                     txtrInformationAboutThe.append("Generation : 2\r\n");
                     txtrInformationAboutThe.append("Weight : 18.7 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 1 ft. 08 in.");
                  }
                  
                  else if(pokemon.contains("Squirtle")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Squirtle\r\n");
                     txtrInformationAboutThe.append("Type : Water\r\n");;
                     txtrInformationAboutThe.append("Generation : 1\r\n");
                     txtrInformationAboutThe.append("Weight : 19.8 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 1 ft. 08 in.");
                  }
                  
                  else if(pokemon.contains("Sudowoodo")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Sudowoodo\r\n");
                     txtrInformationAboutThe.append("Type : Rock\r\n");;
                     txtrInformationAboutThe.append("Generation : 2\r\n");
                     txtrInformationAboutThe.append("Weight : 83.8 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 3 ft. 11 in.");
                  }
                  
                  else if(pokemon.contains("Sylveon")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Sylveon\r\n");
                     txtrInformationAboutThe.append("Type : Fairy\r\n");;
                     txtrInformationAboutThe.append("Generation : 6\r\n");
                     txtrInformationAboutThe.append("Weight : 51.8 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 3 ft. 03 in.");
                  }
                  
                  else if(pokemon.contains("Togepi")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Togepi\r\n");
                     txtrInformationAboutThe.append("Type : Fairy\r\n");;
                     txtrInformationAboutThe.append("Generation : 2\r\n");
                     txtrInformationAboutThe.append("Weight : 3.3 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 1 ft. 00 in.");
                  }
                  
                  else if(pokemon.contains("Torchic")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Torchic\r\n");
                     txtrInformationAboutThe.append("Type : Fire\r\n");;
                     txtrInformationAboutThe.append("Generation : 3\r\n");
                     txtrInformationAboutThe.append("Weight : 5.5 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 1 ft. 04 in.");
                  }
                  
                  else if(pokemon.contains("Totodile")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Totodile\r\n");
                     txtrInformationAboutThe.append("Type : Water\r\n");;
                     txtrInformationAboutThe.append("Generation : 2\r\n");
                     txtrInformationAboutThe.append("Weight : 20.9 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 2 ft. 00 in.");
                  }
                  
                  else if(pokemon.contains("Toxel")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Toxel\r\n");
                     txtrInformationAboutThe.append("Type : Electric, Poison\r\n");;
                     txtrInformationAboutThe.append("Generation : 8\r\n");
                     txtrInformationAboutThe.append("Weight : 24.3 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 1 ft. 04 in.");
                  }
                  
                  else if(pokemon.contains("Treecko")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Treecko\r\n");
                     txtrInformationAboutThe.append("Type : Grass\r\n");;
                     txtrInformationAboutThe.append("Generation : 3\r\n");
                     txtrInformationAboutThe.append("Weight : 11.0 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 1 ft. 08 in.");
                  }
                  
                  else if(pokemon.contains("Turtwig")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Turtwig\r\n");
                     txtrInformationAboutThe.append("Type : Grass\r\n");;
                     txtrInformationAboutThe.append("Generation : 4\r\n");
                     txtrInformationAboutThe.append("Weight : 22.5 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 1 ft. 04 in.");
                  }
                  
                  else if(pokemon.contains("Victini")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Victini\r\n");
                     txtrInformationAboutThe.append("Type : Psychic, Fire\r\n");;
                     txtrInformationAboutThe.append("Generation : 5\r\n");
                     txtrInformationAboutThe.append("Weight : 8.8 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 1 ft. 04 in.");
                  }
                  
                  else if(pokemon.contains("Vivillon")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Vivillon\r\n");
                     txtrInformationAboutThe.append("Type : Bug, Flying\r\n");;
                     txtrInformationAboutThe.append("Generation : 6\r\n");
                     txtrInformationAboutThe.append("Weight : 37.5 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 3 ft. 11 in.");
                  }
                  
                  else if(pokemon.contains("Vulpix")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Vulpix\r\n");
                     txtrInformationAboutThe.append("Type : Fire\r\n");;
                     txtrInformationAboutThe.append("Generation : 1\r\n");
                     txtrInformationAboutThe.append("Weight : 21.8 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 2 ft. 00 in.");
                  }
                  
                  else if(pokemon.contains("Wynaut")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Wynaut\r\n");
                     txtrInformationAboutThe.append("Type : Psychic\r\n");;
                     txtrInformationAboutThe.append("Generation : 3\r\n");
                     txtrInformationAboutThe.append("Weight : 30.9 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 2 ft. 00 in.");
                  }
                  
                  else if(pokemon.contains("Zubat")) {
                     txtrInformationAboutThe.setFont(new Font("Tahoma", Font.BOLD, 19));
                     txtrInformationAboutThe.setText("Zubat\r\n");
                     txtrInformationAboutThe.append("Type : Poison, Flying\r\n");;
                     txtrInformationAboutThe.append("Generation : 1\r\n");
                     txtrInformationAboutThe.append("Weight : 16.5 lbs\r\n");
                     txtrInformationAboutThe.append("Size : 2 ft. 07 in.");
                  }
               }
               catch(Exception error) {
                  JOptionPane.showMessageDialog(null, "Please select a Pokemon.", "That Pokedex Select Error", JOptionPane.ERROR_MESSAGE);
               }
            }
         });
      btnNewButton_1.setBounds(86, 338, 88, 27);
      frmThatPokedex.getContentPane().add(btnNewButton_1);
   	
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
   	
      JLabel lblFilter = new JLabel("Filter:");
      lblFilter.setFont(new Font("Tahoma", Font.BOLD, 16));
      lblFilter.setBounds(260, 218, 104, 26);
      frmThatPokedex.getContentPane().add(lblFilter);
   	
   	
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
   	
      checkBoxGroup = new ButtonGroup();
      checkBoxGroup.add(chckbxNewCheckBox);
      checkBoxGroup.add(chckbxGeneration);
      checkBoxGroup.add(chckbxSize);
      checkBoxGroup.add(chckbxWeight);
   	
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
               
               else {
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
            
            }
         
         });
      btnNewButton_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
      btnNewButton_1_1_1_1.setBounds(433, 244, 115, 28);
      frmThatPokedex.getContentPane().add(btnNewButton_1_1_1_1);
   	
      JButton btnNewButton_1_1_1_1_1 = new JButton("Clear Filter");
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
