package rs.edu.viser.relational.generator;

import rs.edu.viser.relational.generator.columns.Column;

public interface FileGenerator {
	
	void createTable(String tableName, boolean containsMetaDates, Column[] columns);

}
