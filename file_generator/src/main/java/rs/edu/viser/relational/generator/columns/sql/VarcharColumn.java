package rs.edu.viser.relational.generator.columns.sql;

import rs.edu.viser.relational.generator.columns.Column;

public class VarcharColumn implements Column {
	private String name;
	private Integer size;
	private Boolean notNull;
	private String defaultVal;

	@Override
	public Column name(String name) {
		this.name = name;
		return this;
	}

	@Override
	public Column size(Integer size) {
		this.size = size;
		return this;
	}

	@Override
	public Column scale(Integer scale) {
		return this;
	}

	@Override
	public Column notNull(Boolean notNull) {
		this.notNull = notNull;
		return this;
	}

	@Override
	public Column defaultVal(String defaultVal) {
		this.defaultVal = defaultVal;
		return this;
	}

	@Override
	public String get() {
		size = size == null ? 1000 : size;
		notNull = notNull == null ? false : notNull;
		defaultVal = defaultVal == null ? "" : defaultVal;
		
		return "`" + name.toUpperCase() + "` varchar(" + size + ") " + (notNull ? "not null " : "") 
				+ (defaultVal == null ? "" : "default '" + defaultVal.trim() + "'");
	}

}
