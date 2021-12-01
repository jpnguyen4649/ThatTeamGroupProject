/**
 * This class implements a Pokemon object that stores all information.
 * @author rachelmao
 *
 */
public class Pokemon {
    private String name;
    private String types;
    private int generation;
    private float weight;
    private int size;
    private boolean visible;
    private int id;

    /**
     * This constructs a Pokemon object.
     * @param id the id of the pokemon.
     * @param name the name of the pokemon.
     * @param types the types of the pokemon.
     * @param generation the generation of the pokemon.
     * @param weight the weight of the pokemon.
     * @param size the size of the pokemon.
     * @param visible the visibility of the pokemon.
     */
    public Pokemon(int id, String name, String types, int generation, float weight, int size, boolean visible) {
    	this.id = id;
    	this.name = name;
    	this.types = types;
    	this.generation = generation;
    	this.weight = weight;
    	this.size = size;
    	this.visible = visible;
    }
    
    /**
     * This constructs a Pokemon object.
     * @param name the name of the pokemon.
     * @param types the types of the pokemon.
     * @param generation the generation of the pokemon.
     * @param weight the weight of the pokemon.
     * @param size the size of the pokemon.
     * @param visible the visibility of the pokemon.
     */
    public Pokemon(String name, String types, int generation, float weight, int size, boolean visible) {
    	this.name = name;
    	this.types = types;
    	this.generation = generation;
    	this.weight = weight;
    	this.size = size;
    	this.visible = visible;
    }
    
    /**
     * This method sets the Pokemon's name.
     * @param name the name of the pokemon.
     */
    public void setName(String name) {
    	this.name = name;
    }
    
    /**
     * This method sets the Pokemon's types.
     * @param types the types of the pokemon.
     */
    public void setTypes(String types) {
    	this.types = types;
    }
    
    /**
     * This method sets the Pokemon's generation.
     * @param generation the generation of the pokemon.
     */
    public void setGeneration(int generation) {
    	this.generation = generation;
    }
    /**
     * This method sets the Pokemon's weight.
     * @param weight the weight of the pokemon.
     */
    public void setWeight(float weight) {
    	this.weight = weight;
    }
    /**
     * This method sets the Pokemon's size.
     * @param size the size of the pokemon.
     */
    public void setSize(int size) {
    	this.size = size;
    }
    public void setVisibility(boolean visibility) {
    	this.visible = visibility;
    }
    public void setID(int id) {
    	this.id = id;
    }
    
    public String getName() {
    	return this.name;
    }
    public String getTypes() {
    	return this.types;
    }
    public int getGeneration() {
    	return this.generation;
    }
    public float getWeight() {
    	return this.weight;
    }
    public int getSize() {
    	return this.size;
    }
    public boolean isVisible() {
    	return this.visible;
    }
    public int getID() {
    	return this.id;
    }
    @Override
    public String toString() {
        return this.name + "\t" + this.generation + "\t" + this.size + "\t" + this.weight + "\t" + this.types;
    }
    
    
}
