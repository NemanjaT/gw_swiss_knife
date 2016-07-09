package rs.edu.viser.services.filler.groups;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import rs.edu.viser.json.models.GeneratedJsonArrays;
import rs.edu.viser.json.models.WvwMatch;
import rs.edu.viser.json.models.WvwObjective;
import rs.edu.viser.services.filler.config.FillerArrayPatternConfig;
import rs.edu.viser.services.filler.config.FillerObjectPatternConfig;

public class WvwFillerGroup extends FillerGroup {
	private GeneratedJsonArrays arrays;
	private List<WvwMatch> wvwMatchList;
	private List<WvwObjective> wvwObjectiveList;

	public WvwFillerGroup() {
		super(FillerGroupTypes.WVW);

		this.arrays = new GeneratedJsonArrays();
		this.wvwMatchList = new ArrayList<>();
		this.wvwObjectiveList = new ArrayList<>();
	}

	@Override
	public void getModels(SchedulerTypes type) {
		this.readThroughPatterns(type);
		
		log.info("Wvw Filler Group initialization finished!");
	}

	@Override
	protected Object filterObjects(FillerObjectPatternConfig pattern) {
		if (pattern.getObject() instanceof WvwMatch) {
			processWvwMatch(pattern);
		} else if (pattern.getObject() instanceof WvwObjective) {
			processWvwObjective(pattern);
		}
		
		return this;
	}

	@Override
	protected Object filterArrays(FillerArrayPatternConfig pattern) {
		if (pattern.getPropertyName().equals("wvwMatches")) {
			processWvwMatches(pattern);
		} else if (pattern.getPropertyName().equals("wvwObjectives")) {
			processWvwObjectives(pattern);
		}

		return this;
	}
	
	private void processWvwMatches(FillerArrayPatternConfig pattern) {
		log.info("Accessing Wvw Filler Group :: Wvw Matches processor");
		try {
			JSONArray json = 
					this.retriever.getParametarizedJsonArray(url + pattern.getUrlPattern());
			
			this.arrays.setWvwMatches(jack.readValue(json.toString(),
					jack.getTypeFactory().constructCollectionType(List.class, String.class)));
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Wvw Filler Group :: Wvw Matches processor");
	}

	private void processWvwObjectives(FillerArrayPatternConfig pattern) {
		log.info("Accessing Wvw Filler Group :: Wvw Objectives processor");
		try {
			JSONArray json = 
					this.retriever.getParametarizedJsonArray(url + pattern.getUrlPattern());
			
			this.arrays.setWvwObjectives(jack.readValue(json.toString(),
					jack.getTypeFactory().constructCollectionType(List.class, String.class)));
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Wvw Filler Group :: Wvw Objectives processor");
	}

	private void processWvwMatch(FillerObjectPatternConfig pattern) {
		log.info("Accessing Wvw Filler Group :: Wvw Match processor");
		try {
			for (String i : arrays.getWvwMatches()) {
				JSONObject json = 
						this.retriever.getParametarizedJsonObject(url + pattern.getUrlPattern(), i);
			
				this.wvwMatchList.add(jack.readValue(json.toString(), WvwMatch.class));
			}
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Wvw Filler Group :: Wvw Match processor");
	}

	private void processWvwObjective(FillerObjectPatternConfig pattern) {
		log.info("Accessing Wvw Filler Group :: Wvw Objective processor");
		try {
			for (String i : arrays.getWvwObjectives()) {
				JSONObject json = 
						this.retriever.getParametarizedJsonObject(url + pattern.getUrlPattern(), i);
			
				this.wvwObjectiveList.add(jack.readValue(json.toString(), WvwObjective.class));
			}
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Wvw Filler Group :: Wvw Objective processor");
	}
	
	public List<String> getWvwMatches() {
		return arrays.getWvwMatches();
	}
	
	public List<String> getWvwObjectives() {
		return arrays.getWvwObjectives();
	}

	public List<WvwMatch> getWvwMatchList() {
		return wvwMatchList;
	}

	public List<WvwObjective> getWvwObjectiveList() {
		return wvwObjectiveList;
	}

}
