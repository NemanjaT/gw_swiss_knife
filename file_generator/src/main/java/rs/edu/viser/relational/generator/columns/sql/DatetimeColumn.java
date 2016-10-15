package rs.edu.viser.relational.generator.columns.sql;

import rs.edu.viser.relational.generator.columns.Column;

public class DatetimeColumn implements Column {
	private String name;
	private Boolean notNull;
	private Boolean defaultVal;

	@Override
	public Column name(String name) {
		this.name = name;
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
		if (defaultVal.toUpperCase().equals("Y")) {
			this.defaultVal = false;
		} else {
			this.defaultVal = true;
		}
		return this;
	}

	@Override
	public String get() {
		defaultVal = defaultVal ? false : defaultVal;
		
		return "`" + name.toUpperCase() + "` datetime " + (notNull ? "not null " : "") + (defaultVal ? "default current_timestamp" : "");
	}

}
