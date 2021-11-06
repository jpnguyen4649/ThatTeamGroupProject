import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Database {

   static final String DB_URL = "jdbc:mysql://us-cdbr-east-04.cleardb.com/heroku_d5ade1ff64f1a35";
   static final String USER = "b8b971738b2c3f"; 
   static final String PASS = "4908cd46";
   private Connection conn;
   
   // Updates the values in a Pokemon object. 
   // NOTE: Call this after anytime there is a change in the pokemon's data in the database.
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
   
   // Add a new Pokemon.
   // NOTE: method is currently untested.
   public void addPokemon(Pokemon pokemon) {
      try(
		  Statement stmt = conn.createStatement();	  
      ) {
	      String updateStatement = "INSERT INTO pokemon_database (Pokemon, Type, Generation, Weight, Size, Visibile) VALUES (?, ?, ?, ?, ?, ?)";
	      PreparedStatement pstmt = conn.prepareStatement(updateStatement);
	      pstmt.setString(1, pokemon.getName());
	      pstmt.setString(2, pokemon.getTypes());
	      pstmt.setInt(3, pokemon.getGeneration());
	      pstmt.setFloat(4, pokemon.getWeight());
	      pstmt.setInt(5, pokemon.getSize());
	      pstmt.setBoolean(6, pokemon.isVisible());
	      pstmt.executeUpdate();
      }
      catch (SQLException e){
    	  e.printStackTrace();
      }
   
   }
   
   // Archive a Pokemon.
   public void archivePokemon(Pokemon pokemon) {
      try(
    		  Statement stmt = conn.createStatement();	  
          ) {
    	      String updateStatement = "UPDATE POKEMON_DATABASE SET Visible = ? WHERE id = ?";
    	      PreparedStatement pstmt = conn.prepareStatement(updateStatement);
    	      System.out.println(pokemon.getName());
    	      System.out.println(pokemon.isVisible());
    	      System.out.println(pokemon.getID());
    	      pstmt.setBoolean(1, false);
    	      pstmt.setInt(2, pokemon.getID());
    	      pstmt.executeUpdate();
    	      updatePokemon(pokemon);
    	      System.out.println("After archiving");
    	      System.out.println(pokemon.isVisible());
          }
          catch (SQLException e){
        	  e.printStackTrace();
          }
       
   }
   
   // Return a Pokemon list with all Pokemon in the database.
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
   
   
   public void connectDatabase() throws SQLException {
	   conn = DriverManager.getConnection(DB_URL, USER, PASS);
   }
   
   public void closeConnection() throws SQLException {
	   conn.close();
   }
   
   public Database() throws SQLException {
	   connectDatabase();
   }
   
}
