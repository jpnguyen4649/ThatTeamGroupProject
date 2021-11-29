import java.sql.PreparedStatement;
import java.sql.SQLException;


abstract class Filter<T extends Object> {
    protected T value = null;
    protected String condition = "=";
    
    protected Filter(T value, String condition) {
        this.value = value;
        this.condition = condition;
    }
    
    protected Filter(T value) {
    	this.value = value;
    }
    
    abstract String getName();
    
    String getQueryComponent() {
    	return this.getName() + " " + condition + " ? ";
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

class GenerationFilter extends Filter<Integer> {

    protected GenerationFilter(Integer value) {
        super(value);
    }

    @Override
    String getName() {
        return "Generation";
    }
    
}

class SizeFilter extends Filter<Integer> {

    protected SizeFilter(Integer value, String condition) {
        super(value, condition);
    }

    @Override
    String getName() {
        return "Size";
    }
    
}

class TypeFilter extends Filter<String> {

    protected TypeFilter(String value) {
        super("%" + value + "%");
        this.condition = "LIKE";
    }
    
    @Override 
    String getName() {
        return "Type";
    }
    
}