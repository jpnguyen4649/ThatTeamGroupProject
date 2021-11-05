import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Database {

   static final String DB_URL = "jdbc:mysql://localhost/";
   static final String DBtable_URL = "jdbc:mysql://localhost/pokemon";
   static final String USER = "root"; 
   static final String PASS = "oi279551"; //change this to your password
   private Connection conn;
   

   public void addPokemon(Pokemon pokemon) {
      try(
		  Statement stmt = conn.createStatement();	  
      ) {
	      String updateStatement = "INSERT INTO pokemon_database (Pokemon, Type, Generation, Weight, Size, Visibility) VALUES (?, ?, ?, ?, ?, ?)";
	      PreparedStatement pstmt = conn.prepareStatement(updateStatement);
	      pstmt.setString(1, pokemon.getName());
	      pstmt.setString(2, pokemon.getTypes());
	      pstmt.setString(3, pokemon.getGeneration());
	      pstmt.setString(4, pokemon.getWeight());
	      pstmt.setString(5, pokemon.getSize());
	      pstmt.setBoolean(6, pokemon.getVisibility());
	      pstmt.executeUpdate();
      }
      catch (SQLException e){
    	  e.printStackTrace();
      }
   
   }
   
   public void archivePokemon(Pokemon pokemon) {
      try(
    		  Statement stmt = conn.createStatement();	  
          ) {
    	      String updateStatement = "UPDATE POKEMON_DATABASE SET Visibility = ? WHERE id = ?";
    	      PreparedStatement pstmt = conn.prepareStatement(updateStatement);
    	      pstmt.setBoolean(1, pokemon.getVisibility());
    	      pstmt.setInt(2, pokemon.getID());
    	      pstmt.executeUpdate();
          }
          catch (SQLException e){
        	  e.printStackTrace();
          }
       
   }
   
   public ArrayList<Pokemon> getPokemon() {
	   ArrayList<Pokemon> list = new ArrayList<>();
	   try ( Statement stmt = conn.createStatement();
			   PreparedStatement statement = conn.prepareStatement("SELECT * FROM pokemon_database");
			   ResultSet results = statement.executeQuery()
			   ) {
		   while (results.next() ) {
			   String name = results.getString("Pokemon");
	           String type = results.getString("Type");
	           String gen = results.getString("Generation");
	           String weight = results.getString("Weight");
	           String size = results.getString("Size");
	           boolean visibility = results.getBoolean("Visibility");
	           list.add(new Pokemon(name, type, gen, weight, size, visibility));
		   }
	   }
	   catch (SQLException e) {
		   e.printStackTrace();
	   }
	   return list;
   }
   
   public void connectDatabase() throws SQLException {
	   conn = DriverManager.getConnection(DBtable_URL, USER, PASS);
   }
   
   public void closeConnection() throws SQLException {
	   conn.close();
   }
   
   public Database() throws SQLException {
	   connectDatabase();
   }
   
}
