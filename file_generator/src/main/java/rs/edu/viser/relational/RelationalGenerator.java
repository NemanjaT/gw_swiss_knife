package rs.edu.viser.relational;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import rs.edu.viser.json.generator.config.FileGeneratorConfigReader;
import rs.edu.viser.json.generator.config.FileGeneratorPattern;
import rs.edu.viser.json.generator.config.FileGeneratorPatternConcrete;
import rs.edu.viser.json.generator.config.FileGeneratorPattern.Type;
import rs.edu.viser.logger.LOG;
import rs.edu.viser.relational.generator.SqlFileGenerator;
import rs.edu.viser.relational.generator.columns.Column;
import rs.edu.viser.relational.generator.columns.sql.IntColumn;
import rs.edu.viser.relational.generator.columns.sql.NumericColumn;
import rs.edu.viser.relational.generator.columns.sql.VarcharColumn;

public class RelationalGenerator {
	private static LOG logger = new LOG(RelationalGenerator.class);
	
	private SqlFileGenerator sqlFileGenerator;
	private String website;
	
	public static void main(String[] args) {
		new RelationalGenerator().generate();
	}
	
	/**
	 * Initializes the generation of the SQL file.
	 */
	public void generate() {
		logger.info("Starting the relational generator.");
		
		/*
		 * Calling the reader and getting the list of patterns and website
		 */
		FileGeneratorConfigReader reader = FileGeneratorConfigReader.getReader();
		this.sqlFileGenerator = new SqlFileGenerator();
		this.website = reader.getWebsite();
		
		try {
			ArrayList<FileGeneratorPatternConcrete> patterns = new ArrayList<>();
			ArrayList<FileGeneratorPatternConcrete> helperPatternList = new ArrayList<>();
			for (FileGeneratorPattern p : reader.getPatterns()) {
				patterns.add(new FileGeneratorPatternConcrete(this.website, p));
			}
			
			/*
			 * TODO: solve concurrent issue
			 * Shuffling through the patterns and initializes SQL query, for every inner object it's being inserted into a new
			 * list and the process repeats (in a while loop).
			 */
//			while (patterns.size() > 0) {
				for (FileGeneratorPatternConcrete pattern : patterns) {
					
					if (pattern.getFileGeneratorPattern().getType() == Type.OBJECT) {
						JSONObject object = pattern.getJSONObject();
						
						generateObject(object, pattern.getFileGeneratorPattern().getName(), helperPatternList);
					} else if (pattern.getFileGeneratorPattern().getType() == Type.ARRAY) {
						JSONArray array = pattern.getJSONArray();
						
						generateArray(array, pattern.getFileGeneratorPattern().getName(), helperPatternList);
					}
				}
				
				patterns = helperPatternList;
//			}
			
			/*
			 * Writes the data into a file
			 */
			sqlFileGenerator.writeToFile();
		} catch (IOException | JSONException e) {
			logger.error("Failed to retrieve JSON file: " + e.getMessage());
		}
	}
	
	/**
	 * Generates an object
	 * @param obj
	 * @param name
	 * @param list
	 * @throws JSONException
	 * @throws IOException
	 */
	public void generateObject(JSONObject obj, String name, ArrayList<FileGeneratorPatternConcrete> list) throws JSONException, IOException {
		Iterator<?> keys = obj.keys();
		List<Column> columns = new ArrayList<Column>();
		
		/*
		 * Shuffle through all of the keys
		 */
		while (keys.hasNext()) {
			String key = (String) keys.next();
			Object inner = obj.get(key);
			
			/*
			 * If the data is an object or an array add it to the list and insert a foreign key inside
			 */
			if (inner instanceof JSONObject) {
				FileGeneratorPattern pattern = new FileGeneratorPattern();
				pattern.setName(key);
				pattern.setType("OBJECT");
				FileGeneratorPatternConcrete concrete = new FileGeneratorPatternConcrete(this.website, pattern);
				concrete.setJSONObject((JSONObject) inner);
				list.add(concrete);
				
				columns.add(new IntColumn().name(key + "_id").notNull(false));
			} else if (inner instanceof JSONArray) {
				FileGeneratorPattern pattern = new FileGeneratorPattern();
				pattern.setName(key);
				pattern.setType("ARRAY");
				FileGeneratorPatternConcrete concrete = new FileGeneratorPatternConcrete(this.website, pattern);
				concrete.setJSONArray((JSONArray) inner);
				list.add(concrete);
				
				columns.add(new IntColumn().name(key + "_id").notNull(false));
				
			/*
			 * If it's not an object or array insert the appropriate data.
			 */
			} else {
				String val = inner.toString();
				if (val.matches("\\d*\\.\\d+")) {
					columns.add(new NumericColumn().name(key).size(18).scale(4).notNull(false));
				} else if (val.matches("\\d+") || val.matches("(true|false)")) {
					columns.add(new IntColumn().name(key).notNull(false));
				} else {
					columns.add(new VarcharColumn().name(key).size(2000).notNull(false).defaultVal(""));
				}
			}
		}
		
		this.sqlFileGenerator.createTable(name, true, columns.toArray(new Column[columns.size()]));
	}
	
	public void generateArray(JSONArray array, String name, ArrayList<FileGeneratorPatternConcrete> list) throws JSONException, IOException {
		List<Column> columns = new ArrayList<Column>();
		
		
		
		this.sqlFileGenerator.createTable(name, true, columns.toArray(new Column[columns.size()]));
	}
	
}
