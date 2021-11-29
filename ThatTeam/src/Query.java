import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Connection;

public class Query {
	
	String statement = "SELECT * from pokemon_database ";
	String filter = null;
	String sortField = null;
	String sortBy = null;
	ArrayList<TypeFilter> tfs;
	ArrayList<GenerationFilter> gfs;
	ArrayList<SizeFilter> sfs;
	ArrayList<WeightFilter> wfs;

	public Query(String filter, String sortField, ArrayList<TypeFilter> tfs, ArrayList<GenerationFilter> gfs, ArrayList<SizeFilter> sfs, ArrayList<WeightFilter> wfs) {
		this.filter = filter;
		this.sortField = sortField;
		this.tfs = tfs;
		this.gfs = gfs;
		this.sfs = sfs;
		this.wfs = wfs;
	}
	
	public void setSort(String sortField) {
		this.sortField = sortField;
	}
	public void setTypeFilters(ArrayList<TypeFilter> tfs) {
		this.tfs = tfs;
	}
	public void setGenFilters(ArrayList<GenerationFilter> gfs) {
		this.gfs = gfs;
	}
	public void setSizeFilters(ArrayList<SizeFilter> sfs) {
		this.sfs = sfs;
	}
	public void setWeightFilters(ArrayList<WeightFilter> wfs) {
		this.wfs = wfs;
	}
	
	private String and(ArrayList<String> queryComponents) {
		return "(" + String.join(" AND ", queryComponents) + ")";
	}
	
	private String or(ArrayList<String> queryComponents) {
		return "(" + String.join(" OR ", queryComponents) + ")";
	}
	
	
	private String constructStatement() {
		String typeString = null;
		String genString = null;
		String sizeString = null;
		String weightString = null;
		
	    System.out.println("tfs: " + tfs);
	    System.out.println("gfs: " + gfs);
	    System.out.println("sfs: " + sfs);
	    System.out.println("wfs: " + wfs);
		
		if (tfs != null) {
			ArrayList<String> typeQC = new ArrayList<>();
			for (int i = 0; i < tfs.size(); i++) {
				typeQC.add(tfs.get(i).getQueryComponent());
			}
			typeString = or(typeQC);
		}
		if (gfs != null) {
			ArrayList<String> genQC = new ArrayList<>();
			for (int i = 0; i < gfs.size(); i++) {
				genQC.add(gfs.get(i).getQueryComponent());
			}
			genString = or(genQC);
		}
		if (sfs != null) {
			ArrayList<String> sizeQC = new ArrayList<>();
			for (int i = 0; i < sfs.size(); i++) {
				sizeQC.add(sfs.get(i).getQueryComponent());
			}
			sizeString = and(sizeQC);
		}
		if (wfs != null) {
			ArrayList<String> weightQC = new ArrayList<>();
			for (int i = 0; i < wfs.size(); i++) {
				weightQC.add(wfs.get(i).getQueryComponent());
			}
			weightString = and(weightQC);
		}
		ArrayList<String> fullQC = new ArrayList<>();
		if (typeString != null) {
			fullQC.add(typeString);
		}
		if (genString != null) {
			fullQC.add(genString);
		}
		if (sizeString != null) {
			fullQC.add(sizeString);
		}
		if (weightString != null) {
			fullQC.add(weightString);
		}
	
		// No filters used.
		if (tfs == null && gfs == null && sfs == null && wfs == null) {
			filter = "";
		}
		else {
			filter = " WHERE " + and(fullQC);
		}
		// Not sort order specified.
		if (sortField == null) {
			sortBy = "";
		}
		else {
			sortBy = " order by " + sortField + " asc";
		}
		return statement + filter + sortBy;
	}
	
	public ResultSet executeQuery(Connection conn) {
		ResultSet result = null;
		 try(
	    		  Statement stmt = conn.createStatement();	  
	          ) {
			      String statement = constructStatement();
			      PreparedStatement pstmt = conn.prepareStatement(statement);
			      int iterator = 1;
					if (tfs != null) {
						for (int i = 0; i < tfs.size(); i++) {
							tfs.get(i).setInPreparedStatement(pstmt, iterator);
							iterator++;
						}
					}
					if (gfs != null) {
						for (int i = 0; i < gfs.size(); i++) {
							gfs.get(i).setInPreparedStatement(pstmt, iterator);
							iterator++;
						}
					}
					if (sfs != null) {
						for (int i = 0; i < sfs.size(); i++) {
							sfs.get(i).setInPreparedStatement(pstmt, iterator);
							iterator++;
						}
					}
					if (wfs != null) {
						for (int i = 0; i < wfs.size(); i++) {
							wfs.get(i).setInPreparedStatement(pstmt, iterator);
							iterator++;
						}
					}
			      System.out.println(pstmt);
			      result = pstmt.executeQuery();
		 } catch (SQLException e) {
			e.printStackTrace();
		}
		 return result;
	}
	
}
