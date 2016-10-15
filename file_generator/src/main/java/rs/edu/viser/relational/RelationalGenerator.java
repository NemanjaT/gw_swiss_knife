package rs.edu.viser.relational;

import java.io.IOException;

import org.json.JSONException;

import rs.edu.viser.json.JsonRetriever;
import rs.edu.viser.json.generator.config.FileGeneratorConfigReader;
import rs.edu.viser.json.generator.config.FileGeneratorPattern;
import rs.edu.viser.json.generator.config.FileGeneratorPattern.Type;
import rs.edu.viser.logger.LOG;
import rs.edu.viser.relational.generator.SqlFileGenerator;
import rs.edu.viser.relational.generator.columns.Column;
import rs.edu.viser.relational.generator.columns.sql.DatetimeColumn;
import rs.edu.viser.relational.generator.columns.sql.IntColumn;
import rs.edu.viser.relational.generator.columns.sql.NumericColumn;
import rs.edu.viser.relational.generator.columns.sql.VarcharColumn;

public class RelationalGenerator {
	private static LOG logger;
	
	
	public static void main(String[] args) {
		logger.info("Starting the relational generator.");
		
		FileGeneratorConfigReader reader = FileGeneratorConfigReader.getReader();
		SqlFileGenerator sqlFileGenerator = new SqlFileGenerator();
		JsonRetriever jsonRetriever = new JsonRetriever();
		
		try {
			for (FileGeneratorPattern pattern : reader.getPatterns()) {
				
				if (pattern.getType() == Type.OBJECT) {
					jsonRetriever.getJsonObject(reader.getWebsite() + pattern.getUrl());
					
					
				} else if (pattern.getType() == Type.ARRAY) {
					jsonRetriever.getJsonArray(reader.getWebsite() + pattern.getUrl());
					
					
				}
			}
		} catch (IOException | JSONException e) {
			logger.error("Failed to retrieve JSON file: " + e.getMessage());
		}
		
	}
	
}
