package rs.edu.viser.relational.generator.columns.sql;

import rs.edu.viser.relational.generator.columns.Column;

public class NumericColumn implements Column {
	private String name;
	private Integer size;
	private Integer scale;
	private Boolean notNull;
	private Double defaultVal;

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
		this.scale = scale;
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
			this.defaultVal = Double.valueOf(defaultVal);
		} catch (NumberFormatException e) {
			this.defaultVal = .0;
		}
		return this;
	}

	@Override
	public String get() {
		notNull = notNull == null ? false : notNull;
		size = size == null ? 8 : size;
		scale = scale == null ? 2 : scale;
		
		return "`" + name.toUpperCase() + "` numeric(" + size + "," + scale +") " + (notNull ? "not null " : "") 
				+ (defaultVal == null ? "" : "default " + defaultVal);
	}

}
