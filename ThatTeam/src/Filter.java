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

class GenerationFilter extends Filter<Integer> {

    protected GenerationFilter(Integer value, String condition) {
        super(value, condition);
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