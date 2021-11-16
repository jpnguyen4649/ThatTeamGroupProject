import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * This class implements the APIs between the database and the rest of the program.
 * @author rachelmao
 *
 */
public class Database {

   static final String DB_URL = "jdbc:mysql://us-cdbr-east-04.cleardb.com/heroku_d5ade1ff64f1a35";
   static final String USER = "b8b971738b2c3f"; 
   static final String PASS = "4908cd46";
   private Connection conn;
   
   private static Database single_instance = null;

   

   /**
    * This method updates the values in a Pokemon object. 
    * NOTE: this method should be called after a Pokemon's data is changed in the database.
    * @param pokemon the Pokemon object to be updated.
    */
   public void updatePokemon(Pokemon pokemon) {
      try(
    		  Statement stmt = conn.createStatement();	  
          ) {
		      String updateStatement = "SELECT * FROM pokemon_database WHERE id = ?";
		      PreparedStatement pstmt = conn.prepareStatement(updateStatement);
		      pstmt.setInt(1, pokemon.getID());
		      ResultSet result = pstmt.executeQuery();
		      assert result.getFetchSize() == 1;
		      result.next();
			  String name = result.getString("Pokemon");
	          String type = result.getString("Type");
	          int gen = result.getInt("Generation");
	          float weight = result.getFloat("Weight");
	          int size = result.getInt("Size");
	          boolean visible = result.getBoolean("Visible");
	          pokemon.setName(name);
	          pokemon.setTypes(type);
	          pokemon.setGeneration(gen);
	          pokemon.setWeight(weight);
	          pokemon.setSize(size);
	          pokemon.setVisibility(visible);
          }
          catch (SQLException e){
        	  e.printStackTrace();
          }
   }
   
   
   public void filterPokemon(ArrayList<Filter> filters) {
	   try(
			   Statement stmt = conn.createStatement();
	      ) {
		   	 //get all the selected filters
		     //create a filter for each selected filter
			 
			 //Generation filters
			 GenerationFilter gf = new GenerationFilter(1, "=");
			 GenerationFilter gf2 = new GenerationFilter(2, "=");
			 GenerationFilter gf3 = new GenerationFilter(3, "=");
			 GenerationFilter gf4 = new GenerationFilter(4, "=");
			 GenerationFilter gf5 = new GenerationFilter(5, "=");
			 GenerationFilter gf6 = new GenerationFilter(6, "=");
			 GenerationFilter gf7 = new GenerationFilter(7, "=");
			 GenerationFilter gf8 = new GenerationFilter(8, "=");
			 
			 //Size filters 
			 SizeFilter sf = new SizeFilter(1, ">"); // ~ 0
			 SizeFilter sf1 = new SizeFilter(2, ">"); // ~ 1
			 SizeFilter sf2 = new SizeFilter(3, ">"); // ~ 2
			 SizeFilter sf3 = new SizeFilter(4, ">"); // ~ 3
			 SizeFilter sf4 = new SizeFilter(4, "<"); // 3 < 
			 
			 //Weight filters
			 WeightFilter wf = new WeightFilter(80.0f, "<"); // 80+
			 WeightFilter wf2 = new WeightFilter(80.0f, ">"); // 70+
			 WeightFilter wf3 = new WeightFilter(70.0f, ">"); // 60+
			 WeightFilter wf4 = new WeightFilter(60.0f, ">"); // 50+
			 WeightFilter wf5 = new WeightFilter(50.0f, ">"); // 40+
			 WeightFilter wf6 = new WeightFilter(40.0f, ">"); // 30+
			 WeightFilter wf7 = new WeightFilter(30.0f, ">"); // 20+
			 WeightFilter wf8 = new WeightFilter(20.0f, ">"); // 10+
			 WeightFilter wf9 = new WeightFilter(10.0f, ">"); // 0+
			 
			 //Type filters 
			 TypeFilter tf = new TypeFilter("Electric", "LIKE");
			 TypeFilter tf2 = new TypeFilter("Water", "LIKE");
			 TypeFilter tf3 = new TypeFilter("Fire", "LIKE");
			 TypeFilter tf4 = new TypeFilter("Ground", "LIKE");
			 TypeFilter tf5 = new TypeFilter("Psychic", "LIKE");
			 TypeFilter tf6 = new TypeFilter("Fairy", "LIKE");
			 TypeFilter tf7 = new TypeFilter("Bug", "LIKE");
			 TypeFilter tf8 = new TypeFilter("Flying", "LIKE");
			 TypeFilter tf9 = new TypeFilter("Poison", "LIKE");
			 TypeFilter tf10 = new TypeFilter("Dark", "LIKE");
			 TypeFilter tf11 = new TypeFilter("Dragon", "LIKE");
			 TypeFilter tf12 = new TypeFilter("Fighting", "LIKE");
			 TypeFilter tf13 = new TypeFilter("Ghost", "LIKE");
			 TypeFilter tf14 = new TypeFilter("Grass", "LIKE");
			 TypeFilter tf15 = new TypeFilter("Ice", "LIKE");
			 TypeFilter tf16 = new TypeFilter("Normal", "LIKE");
			 TypeFilter tf17 = new TypeFilter("Rock", "LIKE");
			 
			 String statement = "SELECT * FROM pokemon_database WHERE ";
			 
			 ArrayList<TypeFilter> selected_types = new ArrayList<>(Arrays.asList(tf, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9, tf10, tf11, tf12, tf13, tf14, tf15, tf16, tf17));
		
		     for (int i = 0; i < selected_types.size(); i++) {
		        filters.add(new TypeFilter(statement, selected_types.get(i).getQueryComponent())); //Statement is wrong, just didn't know what to put
		     }
			 
		     ArrayList<GenerationFilter> selected_generations = new ArrayList<>(Arrays.asList(gf, gf2, gf3, gf4, gf5, gf6, gf7, gf8));
				
		     for (int i = 0; i < selected_generations.size(); i++) {
		        filters.add(new TypeFilter(statement, selected_generations.get(i).getQueryComponent())); //Statement is wrong, just didn't know what to put 
		     }
		     
		     ArrayList<SizeFilter> selected_sizes = new ArrayList<>(Arrays.asList(sf, sf1, sf2, sf3, sf4));
				
		     for (int i = 0; i < selected_sizes.size(); i++) {
		        filters.add(new TypeFilter(statement, selected_sizes.get(i).getQueryComponent())); //Statement is wrong, just didn't know what to put 
		     }
		     
		     ArrayList<WeightFilter> selected_weights = new ArrayList<>(Arrays.asList(wf, wf2, wf3, wf4, wf5, wf6, wf7, wf8, wf9));
				
		     for (int i = 0; i < selected_weights.size(); i++) {
		        filters.add(new TypeFilter(statement, selected_weights.get(i).getQueryComponent())); //Statement is wrong, just didn't know what to put 
		     }
			 
			 for (int i = 0; i < filters.size(); i++) {
		        statement = statement + " AND " + filters.get(i).getQueryComponent();
		     }
			 
		     PreparedStatement pstmt = conn.prepareStatement(statement);
		     
		     for (int i = 0; i < filters.size(); i++) {
		        filters.get(i).setInPreparedStatement(pstmt, i+1);
		     }
	   } catch (SQLException e){
     	  e.printStackTrace();
       }
   }
   
   
   /**
    * This method updates the value of a pokemon in the Database.
    * NOTE: this method should be called after there is a change in the Pokemon object's data
    * @param pokemon the Pokemon object whose data in the database must be updated.
    */
   public void updateDatabase(Pokemon pokemon) {
      try(
    		  Statement stmt = conn.createStatement();	  
          ) {
		      String updateStatement = "UPDATE pokemon_database SET Pokemon = ?, Type = ?, Generation = ?, Weight = ?, Size = ?, Visible = ? WHERE id = ?";
		      System.out.println(updateStatement);
		      PreparedStatement pstmt = conn.prepareStatement(updateStatement);
		      pstmt.setString(1, pokemon.getName());
		      pstmt.setString(2,  pokemon.getTypes());
		      pstmt.setInt(3, pokemon.getGeneration());
		      pstmt.setFloat(4,  pokemon.getWeight());
		      pstmt.setInt(5, pokemon.getSize());
		      pstmt.setBoolean(6, pokemon.isVisible());
		      pstmt.setInt(7,  pokemon.getID());
		      pstmt.executeUpdate();
          }
          catch (SQLException e){
        	  e.printStackTrace();
          }
   }
   
   /**
    * This method adds a Pokemon into the database.
    * @param pokemon the Pokemon to be added.
    * @return if the Pokemon was successfully added. 
    */
   public boolean addPokemon(Pokemon pokemon) {
      try(
		  Statement stmt = conn.createStatement();	  
      ) {
	      String updateStatement = "INSERT INTO pokemon_database (Pokemon, Type, Generation, Weight, Size, Visible) VALUES (?, ?, ?, ?, ?, ?)";
	      PreparedStatement pstmt = conn.prepareStatement(updateStatement);
	      pstmt.setString(1, pokemon.getName());
	      pstmt.setString(2, pokemon.getTypes());
	      pstmt.setInt(3, pokemon.getGeneration());
	      pstmt.setFloat(4, pokemon.getWeight());
	      pstmt.setInt(5, pokemon.getSize());
	      pstmt.setBoolean(6, pokemon.isVisible());
	      pstmt.executeUpdate();
	      return true;
      }
      catch (SQLException e){
    	  e.printStackTrace();
    	  return false;
      }
   
   }
   
   /**
    * This method archives a Pokemon.
    * @param pokemon the Pokemon to be archived.
    * @return if the Pokemon was successfully archived.
    */
   public boolean archivePokemon(Pokemon pokemon) {
      try(
    		  Statement stmt = conn.createStatement();	  
          ) {
    	      String updateStatement = "UPDATE POKEMON_DATABASE SET Visible = ? WHERE id = ?";
    	      PreparedStatement pstmt = conn.prepareStatement(updateStatement);
    	      pstmt.setBoolean(1, false);
    	      pstmt.setInt(2, pokemon.getID());
    	      pstmt.executeUpdate();
    	      updatePokemon(pokemon);
    	      return true;
          }
          catch (SQLException e){
        	  e.printStackTrace();
        	  return false;
          }
       
   }
   
   // Republish a Pokemon. Returns true if success, fails if false.
   /**
    * This method republishes an archived Pokemon.
    * @param pokemon the Pokemon to be republished.
    * @return if the Pokemon was successfully republished;
    */
   public boolean republishPokemon(Pokemon pokemon) {
      try(
    		  Statement stmt = conn.createStatement();	  
          ) {
    	      String updateStatement = "UPDATE POKEMON_DATABASE SET Visible = ? WHERE id = ?";
    	      PreparedStatement pstmt = conn.prepareStatement(updateStatement);
    	      pstmt.setBoolean(1, true);
    	      pstmt.setInt(2, pokemon.getID());
    	      pstmt.executeUpdate();
    	      updatePokemon(pokemon);
    	      return true;
          }
          catch (SQLException e){
        	  e.printStackTrace();
        	  return false;
          }
       
   }
   
   /**
    * This method returns a Pokemon ArrayList containing all Pokemon in the database.
    * @return an ArrayList containing all Pokemon in the database.
    */
   public ArrayList<Pokemon> getPokemon() {
	   ArrayList<Pokemon> list = new ArrayList<>();
	   try ( Statement stmt = conn.createStatement();
			   PreparedStatement statement = conn.prepareStatement("SELECT * FROM pokemon_database");
			   ResultSet results = statement.executeQuery()
			   ) {
		   while (results.next() ) {
			   int id = results.getInt("id");
			   String name = results.getString("Pokemon");
	           String type = results.getString("Type");
	           int gen = results.getInt("Generation");
	           float weight = results.getFloat("Weight");
	           int size = results.getInt("Size");
	           boolean visible = results.getBoolean("Visible");
	           list.add(new Pokemon(id, name, type, gen, weight, size, visible));
		   }
	   }
	   catch (SQLException e) {
		   e.printStackTrace();
	   }
	   return list;
   }
   
 //sort alphabetically

   public ArrayList<Pokemon> sortedAlphabetically(){
	   ArrayList<Pokemon> sorted = new ArrayList<>();
	   try ( Statement stmt = conn.createStatement();
			   PreparedStatement statement = conn.prepareStatement("SELECT * FROM pokemon_database order by Pokemon asc");
			   ResultSet results = statement.executeQuery()
			   ) {
		   while (results.next() ) {
			   int id = results.getInt("id");
			   String name = results.getString("Pokemon");
	           String type = results.getString("Type");
	           int gen = results.getInt("Generation");
	           float weight = results.getFloat("Weight");
	           int size = results.getInt("Size");
	           boolean visible = results.getBoolean("Visible");
	           sorted.add(new Pokemon(id, name, type, gen, weight, size, visible));
		   }
	   }
	   catch (SQLException e) {
		   e.printStackTrace();
	   }
	   return sorted;
	   
   }
   
   //sort by size
   
   public ArrayList<Pokemon> sortedBySize(){
	   ArrayList<Pokemon> sorted = new ArrayList<>();
	   try ( Statement stmt = conn.createStatement();
			   PreparedStatement statement = conn.prepareStatement("SELECT * FROM pokemon_database order by Size asc");
			   ResultSet results = statement.executeQuery()
			   ) {
		   while (results.next() ) {
			   int id = results.getInt("id");
			   String name = results.getString("Pokemon");
	           String type = results.getString("Type");
	           int gen = results.getInt("Generation");
	           float weight = results.getFloat("Weight");
	           int size = results.getInt("Size");
	           boolean visible = results.getBoolean("Visible");
	           sorted.add(new Pokemon(id, name, type, gen, weight, size, visible));
		   }
	   }
	   catch (SQLException e) {
		   e.printStackTrace();
	   }
	   return sorted;
	   
   }
	
   //sort by weight
   public ArrayList<Pokemon> sortedByWeight(){
	   ArrayList<Pokemon> sorted = new ArrayList<>();
	   try ( Statement stmt = conn.createStatement();
			   PreparedStatement statement = conn.prepareStatement("SELECT * FROM pokemon_database order by Weight asc");
			   ResultSet results = statement.executeQuery()
			   ) {
		   while (results.next() ) {
			   int id = results.getInt("id");
			   String name = results.getString("Pokemon");
	           String type = results.getString("Type");
	           int gen = results.getInt("Generation");
	           float weight = results.getFloat("Weight");
	           int size = results.getInt("Size");
	           boolean visible = results.getBoolean("Visible");
	           sorted.add(new Pokemon(id, name, type, gen, weight, size, visible));
		   }
	   }
	   catch (SQLException e) {
		   e.printStackTrace();
	   }
	   return sorted;
	   
   }
   // sort by generation
   public ArrayList<Pokemon> sortedByGeneration(){
	   ArrayList<Pokemon> sorted = new ArrayList<>();
	   try ( Statement stmt = conn.createStatement();
			   PreparedStatement statement = conn.prepareStatement("SELECT * FROM pokemon_database order by Generation asc");
			   ResultSet results = statement.executeQuery()
			   ) {
		   while (results.next() ) {
			   int id = results.getInt("id");
			   String name = results.getString("Pokemon");
	           String type = results.getString("Type");
	           int gen = results.getInt("Generation");
	           float weight = results.getFloat("Weight");
	           int size = results.getInt("Size");
	           boolean visible = results.getBoolean("Visible");
	           sorted.add(new Pokemon(id, name, type, gen, weight, size, visible));
		   }
	   }
	   catch (SQLException e) {
		   e.printStackTrace();
	   }
	   return sorted;
	   
   }
   // sorted by type
   public ArrayList<Pokemon> sortedByType(){
	   ArrayList<Pokemon> sorted = new ArrayList<>();
	   try ( Statement stmt = conn.createStatement();
			   PreparedStatement statement = conn.prepareStatement("SELECT * FROM pokemon_database order by Type asc");
			   ResultSet results = statement.executeQuery()
			   ) {
		   while (results.next() ) {
			   int id = results.getInt("id");
			   String name = results.getString("Pokemon");
	           String type = results.getString("Type");
	           int gen = results.getInt("Generation");
	           float weight = results.getFloat("Weight");
	           int size = results.getInt("Size");
	           boolean visible = results.getBoolean("Visible");
	           sorted.add(new Pokemon(id, name, type, gen, weight, size, visible));
		   }
	   }
	   catch (SQLException e) {
		   e.printStackTrace();
	   }
	   return sorted;
	   
   }
   
   
   /**
    * Connects to the database.
    * @throws SQLException
    */
   public void connectDatabase() throws SQLException {
	   conn = DriverManager.getConnection(DB_URL, USER, PASS);
   }
   
   /**
    * Closes the connection to the database.
    * @throws SQLException
    */
   public void closeConnection() throws SQLException {
	   conn.close();
   }
   
   private Database() throws SQLException {
	   connectDatabase();
   }
   
   /**
    * This method creates a new or returns the current instance of the Database.
    * @return the current instance of the Database
    * @throws SQLException
    */
   public static Database getInstance() throws SQLException {
	   if (single_instance == null) {
		   single_instance = new Database();
	   }
	   return single_instance;
   }
   
}
