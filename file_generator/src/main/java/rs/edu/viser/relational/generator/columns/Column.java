package rs.edu.viser.relational.generator.columns;

public interface Column {
	
	Column name(String name);
	Column size(Integer size);
	Column scale(Integer scale);
	Column notNull(Boolean notNull);
	Column defaultVal(String defaultVal);
	
	String get();
	
}
