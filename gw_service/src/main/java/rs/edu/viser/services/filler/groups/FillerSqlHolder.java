package rs.edu.viser.services.filler.groups;

import java.util.ArrayList;
import java.util.List;

public class FillerSqlHolder {
	private List<String> queries;
	
	public FillerSqlHolder() {
		queries = new ArrayList<>();
	}

	public List<String> getQueries() {
		return queries;
	}

	public void setQueries(List<String> queries) {
		this.queries = queries;
	}
}
