package rs.edu.viser.services.filler.groups;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import rs.edu.viser.json.models.CharacterCore;
import rs.edu.viser.json.models.CharacterCrafting;
import rs.edu.viser.json.models.CharacterEquipment;
import rs.edu.viser.json.models.CharacterInventory;
import rs.edu.viser.json.models.CharacterRecipes;
import rs.edu.viser.json.models.CharacterSpecializations;
import rs.edu.viser.json.models.GeneratedJsonArrays;
import rs.edu.viser.services.filler.config.FillerArrayPatternConfig;
import rs.edu.viser.services.filler.config.FillerObjectPatternConfig;

public class CharacterFillerGroup extends FillerGroup {
	private GeneratedJsonArrays arrays;
	private HashMap<String, CharacterCore> characterCoreMap;
	private HashMap<String, CharacterCrafting> characterCraftingMap;
	private HashMap<String, CharacterEquipment> characterEquipmentMap;
	private HashMap<String, CharacterInventory> characterInventoryMap;
	private HashMap<String, CharacterRecipes> characterRecipesMap;
	private HashMap<String, CharacterSpecializations> characterSpecializationsMap;
	
	public CharacterFillerGroup() {
		super(FillerGroupTypes.CHARACTER);
		
		this.arrays = new GeneratedJsonArrays();
		this.characterCoreMap = new HashMap<>();
		this.characterCraftingMap = new HashMap<>();
		this.characterEquipmentMap = new HashMap<>();
		this.characterInventoryMap = new HashMap<>();
		this.characterRecipesMap = new HashMap<>();
		this.characterSpecializationsMap = new HashMap<>();
	}

	@Override
	public void getModels(SchedulerTypes type) {
		this.readThroughPatterns(type);
		
		log.info("Character Filler Group initialization finished!");
	}

	@Override
	protected Object filterObjects(FillerObjectPatternConfig pattern) {
		if (pattern.getObject() instanceof CharacterCore) {
			processCharacterCore(pattern);
		} else if (pattern.getObject() instanceof CharacterCrafting) {
			processCharacterCrafting(pattern);
		} else if (pattern.getObject() instanceof CharacterEquipment) {
			processCharacterEquipment(pattern);
		} else if (pattern.getObject() instanceof CharacterInventory) {
			processCharacterInventory(pattern);
		} else if (pattern.getObject() instanceof CharacterRecipes) {
			processCharacterRecipes(pattern);
		} else if (pattern.getObject() instanceof CharacterSpecializations) {
			processCharacterSpecializations(pattern);
		}
		
		return null;
	}

	@Override
	protected Object filterArrays(FillerArrayPatternConfig pattern) {
		if (pattern.getPropertyName().equals("characters")) {
			processCharacters(pattern);
		}
		
		return null;
	}

	private void processCharacters(FillerArrayPatternConfig pattern) {
		log.info("Accessing Character Filler Group :: Characters processor");
		try {
			JSONArray json = 
					this.retriever.getParametarizedJsonArray(url + pattern.getUrlPattern(), accessToken);
			
			this.arrays.setCharacters(jack.readValue(json.toString(),
					jack.getTypeFactory().constructCollectionType(List.class, String.class)));
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Character Filler Group :: Characters processor");
	}
	
	private void processCharacterCore(FillerObjectPatternConfig pattern) {
		log.info("Accessing Character Filler Group :: Character Core processor");
		try {
			for (String i : arrays.getCharacters()) {
				JSONObject json =
						this.retriever.getParametarizedJsonObject(url + pattern.getUrlPattern(), i, accessToken);
				
				this.characterCoreMap.put(i, jack.readValue(json.toString(), CharacterCore.class));
			}
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
		}
		log.info("Finished Character Filler Group :: Character Core processor");
	}

	private void processCharacterCrafting(FillerObjectPatternConfig pattern) {
		log.info("Accessing Character Filler Group :: Character Crafting processor");
		try {
			for (String i : arrays.getCharacters()) {
				JSONObject json =
						this.retriever.getParametarizedJsonObject(url + pattern.getUrlPattern(), i, accessToken);
				
				this.characterCraftingMap.put(i, jack.readValue(json.toString(), CharacterCrafting.class));
			}
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
		}
		log.info("Finished Character Filler Group :: Character Crafting processor");
	}

	private void processCharacterEquipment(FillerObjectPatternConfig pattern) {
		log.info("Accessing Character Filler Group :: Character Equipment processor");
		try {
			for (String i : arrays.getCharacters()) {
				JSONObject json =
						this.retriever.getParametarizedJsonObject(url + pattern.getUrlPattern(), i, accessToken);
				
				this.characterEquipmentMap.put(i, jack.readValue(json.toString(), CharacterEquipment.class));
			}
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
		}
		log.info("Finished Character Filler Group :: Character Equipment processor");
	}

	private void processCharacterInventory(FillerObjectPatternConfig pattern) {
		log.info("Accessing Character Filler Group :: Character Inventory processor");
		try {
			for (String i : arrays.getCharacters()) {
				JSONObject json =
						this.retriever.getParametarizedJsonObject(url + pattern.getUrlPattern(), i, accessToken);
				
				this.characterInventoryMap.put(i, jack.readValue(json.toString(), CharacterInventory.class));
			}
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
		}
		log.info("Finished Character Filler Group :: Character Inventory processor");
	}

	private void processCharacterRecipes(FillerObjectPatternConfig pattern) {
		log.info("Accessing Character Filler Group :: Character Recipes processor");
		try {
			for (String i : arrays.getCharacters()) {
				JSONObject json =
						this.retriever.getParametarizedJsonObject(url + pattern.getUrlPattern(), i, accessToken);
				
				this.characterRecipesMap.put(i, jack.readValue(json.toString(), CharacterRecipes.class));
			}
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
		}
		log.info("Finished Character Filler Group :: Character Recipes processor");
	}

	private void processCharacterSpecializations(FillerObjectPatternConfig pattern) {
		log.info("Accessing Character Filler Group :: Character Specializations processor");
		try {
			for (String i : arrays.getCharacters()) {
				JSONObject json =
						this.retriever.getParametarizedJsonObject(url + pattern.getUrlPattern(), i, accessToken);
				
				this.characterSpecializationsMap.put(i, jack.readValue(json.toString(), CharacterSpecializations.class));
			}
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
		}
		log.info("Finished Character Filler Group :: Character Specializations processor");
	}
	
	public List<String> getCharacters() {
		return arrays.getCharacters();
	}
	
	public HashMap<String, CharacterCore> getCharacterCoreMap() {
		return this.characterCoreMap;
	}
	
	public HashMap<String, CharacterCrafting> getCharacterCraftingMap() {
		return this.characterCraftingMap;
	}
	
	public HashMap<String, CharacterEquipment> getCharacterEquipmentMap() {
		return this.characterEquipmentMap;
	}
	
	public HashMap<String, CharacterInventory> getCharacterInventoryMap() {
		return this.characterInventoryMap;
	}
	
	public HashMap<String, CharacterRecipes> getCharacterRecipesMap() {
		return this.characterRecipesMap;
	}

	public HashMap<String, CharacterSpecializations> getCharacterSpecializationsMap() {
		return this.characterSpecializationsMap;
	}
}
