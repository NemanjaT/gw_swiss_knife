package rs.edu.viser.json.generator.config;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import rs.edu.viser.json.JsonRetriever;
import rs.edu.viser.json.generator.config.FileGeneratorPattern.Type;

public class FileGeneratorPatternConcrete {
	
	private FileGeneratorPattern pattern;
	private JSONObject jsonObject;
	private JSONArray jsonArray;
	
	public FileGeneratorPatternConcrete(String website, FileGeneratorPattern pattern) throws JSONException, IOException {
		this.pattern = pattern;
		JsonRetriever retriever = new JsonRetriever();
		
		if (pattern.getType() == Type.OBJECT) {
			this.jsonObject = retriever.getJsonObject(website + pattern.getUrl());
		} else if (pattern.getType() == Type.ARRAY) {
			this.jsonArray = retriever.getJsonArray(website + pattern.getUrl());
		}
	}
	
	public FileGeneratorPattern getFileGeneratorPattern() {
		return pattern;
	}
	
	public JSONObject getJSONObject() {
		return jsonObject;
	}
	
	public JSONArray getJSONArray() {
		return jsonArray;
	}

}
