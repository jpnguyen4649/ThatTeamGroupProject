public class Pokemon {
    private String name;
    private String types;
    private String generation;
    private String weight;
    private String size;
    private boolean visible;
    private int id;

    public Pokemon(String name, String types, String generation, String weight, String size, boolean visible) {
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
    public void setGeneration(String generation) {
    	this.generation = generation;
    }
    public void setWeight(String weight) {
    	this.weight = weight;
    }
    public void setSize(String size) {
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
    public String getGeneration() {
    	return this.generation;
    }
    public String getWeight() {
    	return this.weight;
    }
    public String getSize() {
    	return this.size;
    }
    public boolean getVisibility() {
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
