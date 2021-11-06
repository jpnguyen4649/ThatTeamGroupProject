public class Pokemon {
    private String name;
    private String types;
    private int generation;
    private float weight;
    private int size;
    private boolean visible;
    private int id;

    public Pokemon(int id, String name, String types, int generation, float weight, int size, boolean visible) {
    	this.id = id;
    	this.name = name;
    	this.types = types;
    	this.generation = generation;
    	this.weight = weight;
    	this.size = size;
    	this.visible = visible;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    public void setTypes(String types) {
    	this.types = types;
    }
    public void setGeneration(int generation) {
    	this.generation = generation;
    }
    public void setWeight(float weight) {
    	this.weight = weight;
    }
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
        return this.name;
    }
    
    
}
