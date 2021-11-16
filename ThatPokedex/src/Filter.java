import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;



abstract class Filter<T extends Object> {
	protected T value = null;
	protected String condition;
	
	protected Filter(T value, String condition) {
		this.value = value;
		this.condition = condition;
	}
	
	abstract String getName();
	
	String getQueryComponent() {
		return this.getName() + " "  + condition + " " + value.toString();
	}
	
	void setInPreparedStatement(PreparedStatement pstmt, int index) throws SQLException {
		pstmt.setObject(index,  this.value);
	}

}

class WeightFilter extends Filter<Float> {

	protected WeightFilter(Float value, String condition) {
		super(value, condition);
	}

	@Override
	String getName() {
		return "Weight";
	}
	
}

class TypeFilter extends Filter<String> {

	protected TypeFilter(String value, String condition) {
		super(value, condition);
	}
	
	@Override 
	String getName() {
		return "Type";
	}
	
	@Override 
	String getQueryComponent() {
		// add the logic to modify query component for list of types
		return this.getName() + " "  + condition + " " + "%{"+ value + "}%";
	}
	
}




/*
 * 
 * SAMPLE IMPLEMENTATION: 
ArrayList <Filter> filters = new ArrayList<>();

applyBtn.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
    	//get all the selected filters
    	//create a filter for each selected filter
    	
    	statement = "SELECT * FROM pokemon_database WHERE ";
    	
    	selected_types = [];
    	for (int i = 0; i < selected_types.length; i++) {
    		filters.add(new TypeFilter());
    	}
    	
    	selected_generations = [];
    	//repeat
    	
    	for (int i = 0; i < filters.size(); i++) {
    		statement = statement + " AND " + filters.get(i).getQueryComponent();
    	}
    	PreparedStatment pstmt = conn.prepareStatment(statment);
    	for (int i = 0; i < filters.size(); i++) {
    		filters.get(i).setInPreparedStatement(pstmt, i+1);
    	}
    	    	
    	
    	
    }
});



String statement = "SELECT * FROM pokemon_database WHERE ";
WeightFilter wf = new WeightFilter(3.0f, "<");
WeightFilter wf2 = new WeightFilter(1.0f, ">");
TypeFilter tf = new TypeFilter("Electric", "LIKE");
TypeFilter tf2 = new TypeFilter("Water", "LIKE");


statement = statment + " AND " + wf.getQueryComponent();
statement = statment + " AND " + tf.getQueryComponent();
...

PreparedStatment pstmt = conn.prepareStatement(statement);
wf.setInPreparedStatment(pstmt, 1);
*/





