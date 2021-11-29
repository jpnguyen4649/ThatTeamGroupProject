import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class QueryBuilder {
	
	String filter = null;
	String sortField = null;
	ArrayList<TypeFilter> tfs;
	ArrayList<GenerationFilter> gfs;
	ArrayList<SizeFilter> sfs;
	ArrayList<WeightFilter> wfs;

	public QueryBuilder setSort(String sortField) {
		this.sortField = sortField;
		return this;
	}
	public QueryBuilder setTypeFilters(ArrayList<TypeFilter> tfs) {
		this.tfs = tfs;
		return this;
	}
	public QueryBuilder setGenFilters(ArrayList<GenerationFilter> gfs) {
		this.gfs = gfs;
		return this;
	}
	public QueryBuilder setSizeFilters(ArrayList<SizeFilter> sfs) {
		this.sfs = sfs;
		return this;
	}
	public QueryBuilder setWeightFilters(ArrayList<WeightFilter> wfs) {
		this.wfs = wfs;
		return this;
	}
	
	public Query getQuery() {
		return new Query(filter, sortField, tfs, gfs, sfs, wfs); 
	}

}
