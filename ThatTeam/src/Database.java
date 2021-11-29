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
   private QueryBuilder qb; // select query that finds current pokemon in list.
   
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
    * @return if the Pokemon was successfully republished.
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
   
   public ArrayList<Pokemon>  filterOR(ArrayList<Filter> filters) {
	   ArrayList<Pokemon> list = new ArrayList<>();
	   try(
			   Statement stmt = conn.createStatement();
	      ) {
		    String statement = "SELECT * FROM pokemon_database WHERE ";
		    
	        for (int i = 0; i < filters.size() - 1; i++) {
	            statement = statement + filters.get(i).getQueryComponent() + " OR ";
	        }
	        // CHANGE THIS.
	        statement = statement + filters.get(filters.size() - 1).getQueryComponent();
	        PreparedStatement pstmt = conn.prepareStatement(statement);
	        filters.get(0).setInPreparedStatement(pstmt, 1);
	        for (int i = 1; i < filters.size(); i++) {
	            filters.get(i).setInPreparedStatement(pstmt, i+1);
	        }
	        System.out.println(pstmt);
	        ResultSet results = pstmt.executeQuery();
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
	   } catch (SQLException e){
     	  e.printStackTrace();
       }
	   return list;
   }
   
   public ArrayList<Pokemon>  filterPokemon(ArrayList<TypeFilter> typeFilters, ArrayList<GenerationFilter> genFilters, ArrayList<SizeFilter> sizeFilters, ArrayList<WeightFilter> weightFilters) {
	   ArrayList<Pokemon> list = new ArrayList<>();
	   try(
			   Statement stmt = conn.createStatement();
	      ) {
		   
		   
		    if (typeFilters.size() > 0) qb.setTypeFilters(typeFilters);
		    if (genFilters.size() > 0) qb.setGenFilters(genFilters);
//		    if (sizeFilters.size() > 0) qb.setSizeFilters(sizeFilters);
//		    if (weightFilters.size() > 0) qb.setWeightFilters(weightFilters);
		    Query query = qb.getQuery();
		    
		    
		    System.out.println("typeFilters: " + typeFilters);
		    System.out.println("typeFilters: " + genFilters);
		    System.out.println("typeFilters: " + sizeFilters);
		    System.out.println("typeFilters: " + weightFilters);
		    
		    ResultSet results = query.executeQuery(conn);
		    while(results.next()) {
				   int id = results.getInt("id");
				   String name = results.getString("Pokemon");
		           String type = results.getString("Type");
		           int gen = results.getInt("Generation");
		           float weight = results.getFloat("Weight");
		           int size = results.getInt("Size");
		           boolean visible = results.getBoolean("Visible");
		           list.add(new Pokemon(id, name, type, gen, weight, size, visible));
		    }
		    

	   } catch (SQLException e){
     	  e.printStackTrace();
       }
	   return list;
   }
   
   public ArrayList<Pokemon> getDisplayedPokemon() {
	   ArrayList<Pokemon> list = new ArrayList<>();
	   try(
			   Statement stmt = conn.createStatement();
	      ) {
		    Query query = qb.getQuery();
		    ResultSet results = query.executeQuery(conn);
		    while(results.next()) {
				   int id = results.getInt("id");
				   String name = results.getString("Pokemon");
		           String type = results.getString("Type");
		           int gen = results.getInt("Generation");
		           float weight = results.getFloat("Weight");
		           int size = results.getInt("Size");
		           boolean visible = results.getBoolean("Visible");
		           list.add(new Pokemon(id, name, type, gen, weight, size, visible));
		    }
		    

	   } catch (SQLException e){
     	  e.printStackTrace();
       }
	   return list;		    
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
//			   PreparedStatement statement = conn.prepareStatement("SELECT * FROM pokemon_database order by Pokemon asc");
//			   ResultSet results = statement.executeQuery()
			   ResultSet results = qb.setSort("Pokemon").getQuery().executeQuery(conn);
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
//			   PreparedStatement statement = conn.prepareStatement("SELECT * FROM pokemon_database order by Size asc");
//			   ResultSet results = statement.executeQuery()
			   ResultSet results = qb.setSort("Size").getQuery().executeQuery(conn);
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
//			   PreparedStatement statement = conn.prepareStatement("SELECT * FROM pokemon_database order by Weight asc");
//			   ResultSet results = statement.executeQuery()
			   ResultSet results = qb.setSort("Weight").getQuery().executeQuery(conn);
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
//			   PreparedStatement statement = conn.prepareStatement("SELECT * FROM pokemon_database order by Generation asc");
//			   ResultSet results = statement.executeQuery()
			   ResultSet results = qb.setSort("Generation").getQuery().executeQuery(conn);
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
//			   PreparedStatement statement = conn.prepareStatement("SELECT * FROM pokemon_database order by Type asc");
//			   ResultSet results = statement.executeQuery()
			   ResultSet results = qb.setSort("Type").getQuery().executeQuery(conn);
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
	   qb = new QueryBuilder();
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
