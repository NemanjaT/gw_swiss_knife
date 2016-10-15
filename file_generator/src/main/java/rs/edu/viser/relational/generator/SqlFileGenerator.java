package rs.edu.viser.relational.generator;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import rs.edu.viser.json.generator.config.FileGeneratorConfigReader;
import rs.edu.viser.logger.LOG;
import rs.edu.viser.relational.generator.columns.Column;
import rs.edu.viser.relational.generator.columns.sql.DatetimeColumn;
import rs.edu.viser.relational.generator.columns.sql.VarcharColumn;

public class SqlFileGenerator implements FileGenerator {
	private LOG logger = new LOG(SqlFileGenerator.class);
	
	private List<String> queryList = new ArrayList<>();

	/**
	 * Creates a string builder, builds up a SQL query string to create a table and inputs it in a file.
	 */
	@Override
	public void createTable(String tableName, boolean containsMetaDates, Column[] columns) {
		logger.info("Initializing generation of string for the " + tableName.toUpperCase() + " table");
		
		tableName = tableName.replace(' ', '_');
		
		StringBuilder createTableString = new StringBuilder("create table `" + tableName.toUpperCase() + "` (\n");
		createTableString.append("\tID int primary key auto_increment,\n");
		
		if (containsMetaDates) {
			ArrayList<Column> tempColumns = new ArrayList<>(Arrays.asList(columns));
			tempColumns.add(new DatetimeColumn().name("DC").notNull(false).defaultVal("true"));
			tempColumns.add(new VarcharColumn().name("UC").notNull(false).size(60).defaultVal(""));
			tempColumns.add(new DatetimeColumn().name("DM").notNull(false).size(60).defaultVal("false"));
			tempColumns.add(new VarcharColumn().name("UM").notNull(false).defaultVal(""));
			columns = tempColumns.toArray(new Column[tempColumns.size()]);
		}
		
		for (Column column : columns) {
			createTableString.append("\t" + column.get() + ",\n");
		}
		
		createTableString.setLength(createTableString.length() - 2);
		createTableString.append("\n);\n\n");
		
		logger.info("Finished generation of string for the " + tableName.toUpperCase() 
				+ " table: " + createTableString.toString().replace('\n', ' ').replace('\t', ' '));
		
		queryList.add(createTableString.toString());
	}
	
	public void writeToFile() {
		String location = "src/main/java" + FileGeneratorConfigReader.getReader().getPackageFile().replace('.', '/') 
				+ "/ti_tables.sql";

		try {
			Path file = Paths.get(location);
			Files.write(file, queryList, Charset.forName("UTF-8"), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
		} catch (IOException e) {
			logger.error("IO failed with exception: " + e.getMessage());
		}
	}
}
