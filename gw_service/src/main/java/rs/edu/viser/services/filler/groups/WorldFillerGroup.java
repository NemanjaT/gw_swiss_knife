package rs.edu.viser.services.filler.groups;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import rs.edu.viser.json.models.Continent;
import rs.edu.viser.json.models.GeneratedJsonArrays;
import rs.edu.viser.json.models.Map;
import rs.edu.viser.json.models.World;
import rs.edu.viser.services.filler.config.FillerArrayPatternConfig;
import rs.edu.viser.services.filler.config.FillerObjectPatternConfig;

public class WorldFillerGroup extends FillerGroup {
	private GeneratedJsonArrays arrays;
	private List<World> worldList;
	private List<Continent> continentList;
	private List<Map> mapList;
	
	public WorldFillerGroup() {
		super(FillerGroupTypes.WORLD);
		
		this.arrays = new GeneratedJsonArrays();
		this.worldList = new ArrayList<>();
		this.continentList = new ArrayList<>();
		this.mapList = new ArrayList<>();
	}

	@Override
	public void getModels(SchedulerTypes type) {
		this.readThroughPatterns(type);
		
		log.info("World Filler Group initialization finished!");
	}

	@Override
	protected Object filterObjects(FillerObjectPatternConfig pattern) {
		if (pattern.getObject() instanceof World) {
			processWorld(pattern);
		} else if (pattern.getObject() instanceof Continent) {
			processContinent(pattern);
		} else if (pattern.getObject() instanceof Map) {
			processMap(pattern);
		}
		
		return this;
	}

	@Override
	protected Object filterArrays(FillerArrayPatternConfig pattern) {
		if (pattern.getPropertyName().equals("worlds")) {
			processWorlds(pattern);
		} else if (pattern.getPropertyName().equals("continents")) {
			processContinents(pattern);
		} else if (pattern.getPropertyName().equals("maps")) {
			processMaps(pattern);
		}
		
		return this;
	}
	
	private void processWorlds(FillerArrayPatternConfig pattern) {
		log.info("Accessing World Filler Group :: Worlds processor");
		try {
			JSONArray json = 
					this.retriever.getParametarizedJsonArray(url + pattern.getUrlPattern());
			
			this.arrays.setWorlds(jack.readValue(json.toString(),
					jack.getTypeFactory().constructCollectionType(List.class, Integer.class)));
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished World Filler Group :: Worlds processor");
	}

	private void processContinents(FillerArrayPatternConfig pattern) {
		log.info("Accessing World Filler Group :: Continents processor");
		try {
			JSONArray json = 
					this.retriever.getParametarizedJsonArray(url + pattern.getUrlPattern());
			
			this.arrays.setContinents(jack.readValue(json.toString(),
					jack.getTypeFactory().constructCollectionType(List.class, Integer.class)));
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished World Filler Group :: Continents processor");
	}

	private void processMaps(FillerArrayPatternConfig pattern) {
		log.info("Accessing World Filler Group :: Maps processor");
		try {
			JSONArray json = 
					this.retriever.getParametarizedJsonArray(url + pattern.getUrlPattern());
			
			this.arrays.setMaps(jack.readValue(json.toString(),
					jack.getTypeFactory().constructCollectionType(List.class, Integer.class)));
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished World Filler Group :: Maps processor");
	}
	
	private void processWorld(FillerObjectPatternConfig pattern) {
		log.info("Accessing World Filler Group :: World processor");
		try {
			for (Integer i : arrays.getWorlds()) {
				JSONObject json = 
						this.retriever.getParametarizedJsonObject(url + pattern.getUrlPattern(), i.toString());
			
				this.worldList.add(jack.readValue(json.toString(), World.class));
			}
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished World Filler Group :: World processor");
	}

	private void processContinent(FillerObjectPatternConfig pattern) {
		log.info("Accessing World Filler Group :: Continent processor");
		try {
			for (Integer i : arrays.getContinents()) {
				JSONObject json = 
						this.retriever.getParametarizedJsonObject(url + pattern.getUrlPattern(), i.toString());
			
				this.continentList.add(jack.readValue(json.toString(), Continent.class));
			}
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished World Filler Group :: Continent processor");
	}

	private void processMap(FillerObjectPatternConfig pattern) {
		log.info("Accessing World Filler Group :: Map processor");
		try {
			for (Integer i : arrays.getMaps()) {
				JSONObject json = 
						this.retriever.getParametarizedJsonObject(url + pattern.getUrlPattern(), i.toString());
			
				this.mapList.add(jack.readValue(json.toString(), Map.class));
			}
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished World Filler Group :: Map processor");
	}

	public List<Integer> getWorlds() {
		return arrays.getWorlds();
	}
	
	public List<Integer> getContinents() {
		return arrays.getContinents();
	}
	
	public List<Integer> getMaps() {
		return arrays.getMaps();
	}

	public List<World> getWorldList() {
		return worldList;
	}

	public List<Continent> getContinentList() {
		return continentList;
	}

	public List<Map> getMapList() {
		return mapList;
	}

}
