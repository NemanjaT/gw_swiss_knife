package rs.edu.viser.relational.generator.columns.sql;

import rs.edu.viser.relational.generator.columns.Column;

public class IntColumn implements Column {
	private String name;
	private Boolean notNull;
	private Integer defaultVal;

	@Override
	public Column name(String name) {
		this.name = name.toUpperCase().equals("ID") ? "SEQ_NO" : name;
		return this;
	}

	@Override
	public Column size(Integer size) {
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
		try {
			this.defaultVal = Integer.valueOf(defaultVal);
		} catch (NumberFormatException e) {
			this.defaultVal = 0;
		}
		return this;
	}

	@Override
	public String get() {
		notNull = notNull == null ? false : notNull;
		
		return "`" + name.toUpperCase() + "` int " + (notNull ? "not null " : "") + (defaultVal == null ? "" : "default " + defaultVal);
	}

}
