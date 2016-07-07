package rs.edu.viser.services.filler.groups;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import rs.edu.viser.json.models.Color;
import rs.edu.viser.json.models.Currency;
import rs.edu.viser.json.models.GeneratedJsonArrays;
import rs.edu.viser.json.models.Item;
import rs.edu.viser.json.models.ItemStats;
import rs.edu.viser.json.models.Legend;
import rs.edu.viser.json.models.Materials;
import rs.edu.viser.json.models.Mini;
import rs.edu.viser.json.models.Pet;
import rs.edu.viser.json.models.Profession;
import rs.edu.viser.json.models.Recipe;
import rs.edu.viser.json.models.Skill;
import rs.edu.viser.json.models.Skin;
import rs.edu.viser.json.models.Specialization;
import rs.edu.viser.json.models.TokenInfo;
import rs.edu.viser.json.models.Trait;
import rs.edu.viser.services.filler.config.FillerArrayPatternConfig;
import rs.edu.viser.services.filler.config.FillerObjectPatternConfig;

public class ItemFillerGroup extends FillerGroup {
	private GeneratedJsonArrays arrays;
	private List<Color> colorList;
	private List<Currency> currencyList;
	private List<Item> itemList;
	private List<ItemStats> itemStatsList;
	private List<Legend> legendList;
	private List<Materials> materialsList;
	private List<Mini> miniList;
	private List<Pet> petList;
	private List<Profession> professionList;
	private List<Recipe> recipeList;
	private List<Skill> skillList;
	private List<Skin> skinList;
	private List<Specialization> specializationList;
	private TokenInfo tokenInfo;
	private List<Trait> traitList;

	public ItemFillerGroup() {
		super(FillerGroupTypes.ITEM);

		this.arrays = new GeneratedJsonArrays();
		this.colorList = new ArrayList<>();
		this.currencyList = new ArrayList<>();
		this.itemList = new ArrayList<>();
		this.itemStatsList = new ArrayList<>();
		this.legendList = new ArrayList<>();
		this.materialsList = new ArrayList<>();
		this.miniList = new ArrayList<>();
		this.petList = new ArrayList<>();
		this.professionList = new ArrayList<>();
		this.recipeList = new ArrayList<>();
		this.skillList = new ArrayList<>();
		this.skinList = new ArrayList<>();
		this.specializationList = new ArrayList<>();
		this.tokenInfo = new TokenInfo();
		this.traitList = new ArrayList<>();
	}

	@Override
	public void getModels(SchedulerTypes type) {
		this.readThroughPatterns(type);
		
		log.info("Item Filler Group initialization finished!");
	}

	@Override
	protected Object filterObjects(FillerObjectPatternConfig pattern) {
		if (pattern.getObject() instanceof Color) {
			processColor(pattern);
		} else if (pattern.getObject() instanceof Currency) {
			processCurrency(pattern);
		} else if (pattern.getObject() instanceof Item) {
			processItem(pattern);
		} else if (pattern.getObject() instanceof ItemStats) {
			processItemStats(pattern);
		} else if (pattern.getObject() instanceof Legend) {
			processLegends(pattern);
		} else if (pattern.getObject() instanceof Materials) {
			processMaterials(pattern);
		} else if (pattern.getObject() instanceof Mini) {
			processMini(pattern);
		} else if (pattern.getObject() instanceof Pet) {
			processPet(pattern);
		} else if (pattern.getObject() instanceof Profession) {
			processProfession(pattern);
		} else if (pattern.getObject() instanceof Recipe) {
			processRecipe(pattern);
		} else if (pattern.getObject() instanceof Skill) {
			processSkill(pattern);
		} else if (pattern.getObject() instanceof Skin) {
			processSkin(pattern);
		} else if (pattern.getObject() instanceof Specialization) {
			processSpecialization(pattern);
		} else if (pattern.getObject() instanceof TokenInfo) {
			processTokenInfo(pattern);
		} else if (pattern.getObject() instanceof Trait) {
			processTrait(pattern);
		}

		return this;
	}

	@Override
	protected Object filterArrays(FillerArrayPatternConfig pattern) {
		if (pattern.getPropertyName().equals("colors")) {
			processColors(pattern);
		} else if (pattern.getPropertyName().equals("currencies")) {
			processCurrencies(pattern);
		} else if (pattern.getPropertyName().equals("items")) {
			processItems(pattern);
		} else if (pattern.getPropertyName().equals("allItemStats")) {
			processAllItemStats(pattern);
		} else if (pattern.getPropertyName().equals("legends")) {
			processLegends(pattern);
		} else if (pattern.getPropertyName().equals("allMaterials")) {
			processAllMaterials(pattern);
		} else if (pattern.getPropertyName().equals("minis")) {
			processMinis(pattern);
		} else if (pattern.getPropertyName().equals("pets")) {
			processPets(pattern);
		} else if (pattern.getPropertyName().equals("professions")) {
			processProfessions(pattern);
		} else if (pattern.getPropertyName().equals("recipes")) {
			processRecipes(pattern);
		} else if (pattern.getPropertyName().equals("skills")) {
			processSkills(pattern);
		} else if (pattern.getPropertyName().equals("skins")) {
			processSkins(pattern);
		} else if (pattern.getPropertyName().equals("specializations")) {
			processSpecializations(pattern);
		} else if (pattern.getPropertyName().equals("traits")) {
			processTraits(pattern);
		}
		
		return this;
	}
	
	private void processColors(FillerArrayPatternConfig pattern) {
		log.info("Accessing Item Filler Group :: Colors processor");
		try {
			JSONArray json = 
					this.retriever.getParametarizedJsonArray(url + pattern.getUrlPattern());
			
			this.arrays.setColors(jack.readValue(json.toString(),
					jack.getTypeFactory().constructCollectionType(List.class, Integer.class)));
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Item Filler Group :: Colors processor");
	}

	private void processCurrencies(FillerArrayPatternConfig pattern) {
		log.info("Accessing Item Filler Group :: Currencies processor");
		try {
			JSONArray json = 
					this.retriever.getParametarizedJsonArray(url + pattern.getUrlPattern());
			
			this.arrays.setCurrencies(jack.readValue(json.toString(),
					jack.getTypeFactory().constructCollectionType(List.class, Integer.class)));
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Item Filler Group :: Currencies processor");
	}

	private void processItems(FillerArrayPatternConfig pattern) {
		log.info("Accessing Item Filler Group :: Items processor");
		try {
			JSONArray json = 
					this.retriever.getParametarizedJsonArray(url + pattern.getUrlPattern());
			
			this.arrays.setItems(jack.readValue(json.toString(),
					jack.getTypeFactory().constructCollectionType(List.class, Integer.class)));
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Item Filler Group :: Items processor");
	}

	private void processAllItemStats(FillerArrayPatternConfig pattern) {
		log.info("Accessing Item Filler Group :: All Item Stats processor");
		try {
			JSONArray json = 
					this.retriever.getParametarizedJsonArray(url + pattern.getUrlPattern());
			
			this.arrays.setAllItemStats(jack.readValue(json.toString(),
					jack.getTypeFactory().constructCollectionType(List.class, Integer.class)));
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Item Filler Group :: All Item Stats processor");
	}

	private void processLegends(FillerArrayPatternConfig pattern) {
		log.info("Accessing Item Filler Group :: Legends processor");
		try {
			JSONArray json = 
					this.retriever.getParametarizedJsonArray(url + pattern.getUrlPattern());
			
			this.arrays.setLegends(jack.readValue(json.toString(),
					jack.getTypeFactory().constructCollectionType(List.class, String.class)));
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Item Filler Group :: Legends processor");
	}

	private void processAllMaterials(FillerArrayPatternConfig pattern) {
		log.info("Accessing Item Filler Group :: All Materials processor");
		try {
			JSONArray json = 
					this.retriever.getParametarizedJsonArray(url + pattern.getUrlPattern());
			
			this.arrays.setAllMaterials(jack.readValue(json.toString(),
					jack.getTypeFactory().constructCollectionType(List.class, Integer.class)));
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Item Filler Group :: All Materials processor");
	}

	private void processMinis(FillerArrayPatternConfig pattern) {
		log.info("Accessing Item Filler Group :: Minis processor");
		try {
			JSONArray json = 
					this.retriever.getParametarizedJsonArray(url + pattern.getUrlPattern());
			
			this.arrays.setMinis(jack.readValue(json.toString(),
					jack.getTypeFactory().constructCollectionType(List.class, Integer.class)));
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Item Filler Group :: Minis processor");
	}

	private void processPets(FillerArrayPatternConfig pattern) {
		log.info("Accessing Item Filler Group :: Pets processor");
		try {
			JSONArray json = 
					this.retriever.getParametarizedJsonArray(url + pattern.getUrlPattern());
			
			this.arrays.setPets(jack.readValue(json.toString(),
					jack.getTypeFactory().constructCollectionType(List.class, Integer.class)));
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Item Filler Group :: Pets processor");
	}

	private void processProfessions(FillerArrayPatternConfig pattern) {
		log.info("Accessing Item Filler Group :: Professions processor");
		try {
			JSONArray json = 
					this.retriever.getParametarizedJsonArray(url + pattern.getUrlPattern());
			
			this.arrays.setProfessions(jack.readValue(json.toString(),
					jack.getTypeFactory().constructCollectionType(List.class, String.class)));
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Item Filler Group :: Professions processor");
	}

	private void processRecipes(FillerArrayPatternConfig pattern) {
		log.info("Accessing Item Filler Group :: Recipes processor");
		try {
			JSONArray json = 
					this.retriever.getParametarizedJsonArray(url + pattern.getUrlPattern());
			
			this.arrays.setRecipes(jack.readValue(json.toString(),
					jack.getTypeFactory().constructCollectionType(List.class, Integer.class)));
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Item Filler Group :: Recipes processor");
	}

	private void processSkills(FillerArrayPatternConfig pattern) {
		log.info("Accessing Item Filler Group :: Skills processor");
		try {
			JSONArray json = 
					this.retriever.getParametarizedJsonArray(url + pattern.getUrlPattern());
			
			this.arrays.setSkills(jack.readValue(json.toString(),
					jack.getTypeFactory().constructCollectionType(List.class, Integer.class)));
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Item Filler Group :: Skills processor");
	}

	private void processSkins(FillerArrayPatternConfig pattern) {
		log.info("Accessing Item Filler Group :: Skins processor");
		try {
			JSONArray json = 
					this.retriever.getParametarizedJsonArray(url + pattern.getUrlPattern());
			
			this.arrays.setSkins(jack.readValue(json.toString(),
					jack.getTypeFactory().constructCollectionType(List.class, Integer.class)));
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Item Filler Group :: Skins processor");
	}

	private void processSpecializations(FillerArrayPatternConfig pattern) {
		log.info("Accessing Item Filler Group :: Specializations processor");
		try {
			JSONArray json = 
					this.retriever.getParametarizedJsonArray(url + pattern.getUrlPattern());
			
			this.arrays.setSpecializations(jack.readValue(json.toString(),
					jack.getTypeFactory().constructCollectionType(List.class, Integer.class)));
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Item Filler Group :: Specializations processor");
	}

	private void processTraits(FillerArrayPatternConfig pattern) {
		log.info("Accessing Item Filler Group :: Traits processor");
		try {
			JSONArray json = 
					this.retriever.getParametarizedJsonArray(url + pattern.getUrlPattern());
			
			this.arrays.setTraits(jack.readValue(json.toString(),
					jack.getTypeFactory().constructCollectionType(List.class, Integer.class)));
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Item Filler Group :: Traits processor");
	}

	private void processColor(FillerObjectPatternConfig pattern) {
		log.info("Accessing Item Filler Group :: Color processor");
		try {
			for (Integer i : arrays.getColors()) {
				JSONObject json = 
						this.retriever.getParametarizedJsonObject(url + pattern.getUrlPattern(), i.toString());
			
				this.colorList.add(jack.readValue(json.toString(), Color.class));
			}
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Item Filler Group :: Color processor");
	}

	private void processCurrency(FillerObjectPatternConfig pattern) {
		log.info("Accessing Item Filler Group :: Currency processor");
		try {
			for (Integer i : arrays.getCurrencies()) {
				JSONObject json = 
						this.retriever.getParametarizedJsonObject(url + pattern.getUrlPattern(), i.toString());
			
				this.currencyList.add(jack.readValue(json.toString(), Currency.class));
			}
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Item Filler Group :: Currency processor");
	}

	private void processItem(FillerObjectPatternConfig pattern) {
		log.info("Accessing Item Filler Group :: Item processor");
		try {
			for (Integer i : arrays.getItems()) {
				JSONObject json = 
						this.retriever.getParametarizedJsonObject(url + pattern.getUrlPattern(), i.toString());
			
				this.itemList.add(jack.readValue(json.toString(), Item.class));
			}
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Item Filler Group :: Item processor");
	}

	private void processItemStats(FillerObjectPatternConfig pattern) {
		log.info("Accessing Item Filler Group :: Item Stats processor");
		try {
			for (Integer i : arrays.getAllItemStats()) {
				JSONObject json = 
						this.retriever.getParametarizedJsonObject(url + pattern.getUrlPattern(), i.toString());
			
				this.itemStatsList.add(jack.readValue(json.toString(), ItemStats.class));
			}
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Item Filler Group :: Item Stats processor");
	}

	private void processLegends(FillerObjectPatternConfig pattern) {
		log.info("Accessing Item Filler Group :: Legend processor");
		try {
			for (String i : arrays.getLegends()) {
				JSONObject json = 
						this.retriever.getParametarizedJsonObject(url + pattern.getUrlPattern(), i);
			
				this.legendList.add(jack.readValue(json.toString(), Legend.class));
			}
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Item Filler Group :: Legend processor");
	}

	private void processMaterials(FillerObjectPatternConfig pattern) {
		log.info("Accessing Item Filler Group :: Material processor");
		try {
			for (Integer i : arrays.getAllMaterials()) {
				JSONObject json = 
						this.retriever.getParametarizedJsonObject(url + pattern.getUrlPattern(), i.toString());
			
				this.materialsList.add(jack.readValue(json.toString(), Materials.class));
			}
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Item Filler Group :: Material processor");
	}

	private void processMini(FillerObjectPatternConfig pattern) {
		log.info("Accessing Item Filler Group :: Mini processor");
		try {
			for (Integer i : arrays.getMinis()) {
				JSONObject json = 
						this.retriever.getParametarizedJsonObject(url + pattern.getUrlPattern(), i.toString());
			
				this.miniList.add(jack.readValue(json.toString(), Mini.class));
			}
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Item Filler Group :: Mini processor");
	}

	private void processPet(FillerObjectPatternConfig pattern) {
		log.info("Accessing Item Filler Group :: Pet processor");
		try {
			for (Integer i : arrays.getPets()) {
				JSONObject json = 
						this.retriever.getParametarizedJsonObject(url + pattern.getUrlPattern(), i.toString());
			
				this.petList.add(jack.readValue(json.toString(), Pet.class));
			}
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Item Filler Group :: Pet processor");
	}

	private void processProfession(FillerObjectPatternConfig pattern) {
		log.info("Accessing Item Filler Group :: Profession processor");
		try {
			for (String i : arrays.getProfessions()) {
				JSONObject json = 
						this.retriever.getParametarizedJsonObject(url + pattern.getUrlPattern(), i);
			
				this.professionList.add(jack.readValue(json.toString(), Profession.class));
			}
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Item Filler Group :: Profession processor");
	}

	private void processRecipe(FillerObjectPatternConfig pattern) {
		log.info("Accessing Item Filler Group :: Recipe processor");
		try {
			for (Integer i : arrays.getRecipes()) {
				JSONObject json = 
						this.retriever.getParametarizedJsonObject(url + pattern.getUrlPattern(), i.toString());
			
				this.recipeList.add(jack.readValue(json.toString(), Recipe.class));
			}
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Item Filler Group :: Recipe processor");
	}

	private void processSkill(FillerObjectPatternConfig pattern) {
		log.info("Accessing Item Filler Group :: Skill processor");
		try {
			for (Integer i : arrays.getSkills()) {
				JSONObject json = 
						this.retriever.getParametarizedJsonObject(url + pattern.getUrlPattern(), i.toString());
			
				this.skillList.add(jack.readValue(json.toString(), Skill.class));
			}
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Item Filler Group :: Skill processor");
	}

	private void processSkin(FillerObjectPatternConfig pattern) {
		log.info("Accessing Item Filler Group :: Skin processor");
		try {
			for (Integer i : arrays.getSkins()) {
				JSONObject json = 
						this.retriever.getParametarizedJsonObject(url + pattern.getUrlPattern(), i.toString());
			
				this.skinList.add(jack.readValue(json.toString(), Skin.class));
			}
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Item Filler Group :: Skin processor");
	}

	private void processSpecialization(FillerObjectPatternConfig pattern) {
		log.info("Accessing Item Filler Group :: Specialization processor");
		try {
			for (Integer i : arrays.getSpecializations()) {
				JSONObject json = 
						this.retriever.getParametarizedJsonObject(url + pattern.getUrlPattern(), i.toString());
			
				this.specializationList.add(jack.readValue(json.toString(), Specialization.class));
			}
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Item Filler Group :: Specialization processor");
	}

	private void processTokenInfo(FillerObjectPatternConfig pattern) {
		log.info("Accessing Item Filler Group :: Token Info processor");
		try {
			JSONObject json = 
					this.retriever.getParametarizedJsonObject(url + pattern.getUrlPattern(), accessToken);
		
			this.tokenInfo = jack.readValue(json.toString(), TokenInfo.class);
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Item Filler Group :: Token Info processor");
	}

	private void processTrait(FillerObjectPatternConfig pattern) {
		log.info("Accessing Item Filler Group :: Trait processor");
		try {
			for (Integer i : arrays.getTraits()) {
				JSONObject json = 
						this.retriever.getParametarizedJsonObject(url + pattern.getUrlPattern(), i.toString());
			
				this.traitList.add(jack.readValue(json.toString(), Trait.class));
			}
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		log.info("Finished Item Filler Group :: Trait processor");
	}
	
	public List<Integer> getColors() {
		return this.arrays.getColors();
	}
	
	public List<Integer> getCurrencies() {
		return this.arrays.getCurrencies();
	}
	
	public List<Integer> getItems() {
		return this.arrays.getItems();
	}
	
	public List<Integer> getAllItemStats() {
		return this.arrays.getAllItemStats();
	}
	
	public List<String> getLegends() {
		return this.arrays.getLegends();
	}
	
	public List<Integer> getAllMaterials() {
		return this.arrays.getAllMaterials();
	}
	
	public List<Integer> getMinis() {
		return this.arrays.getMinis();
	}
	
	public List<Integer> getPets() {
		return this.arrays.getPets();
	}
	
	public List<String> getProfessions() {
		return this.arrays.getProfessions();
	}
	
	public List<Integer> getRecipes() {
		return this.arrays.getRecipes();
	}
	
	public List<Integer> getSkills() {
		return this.arrays.getSkills();
	}
	
	public List<Integer> getSkins() {
		return this.arrays.getSkins();
	}
	
	public List<Integer> getSpecializations() {
		return this.arrays.getSpecializations();
	}
	
	public List<Integer> getTraits() {
		return this.arrays.getTraits();
	}

	public List<Color> getColorList() {
		return colorList;
	}

	public List<Currency> getCurrencyList() {
		return currencyList;
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public List<ItemStats> getItemStatsList() {
		return itemStatsList;
	}

	public List<Legend> getLegendList() {
		return legendList;
	}

	public List<Materials> getMaterialsList() {
		return materialsList;
	}

	public List<Mini> getMiniList() {
		return miniList;
	}

	public List<Pet> getPetList() {
		return petList;
	}

	public List<Profession> getProfessionList() {
		return professionList;
	}

	public List<Recipe> getRecipeList() {
		return recipeList;
	}

	public List<Skill> getSkillList() {
		return skillList;
	}

	public List<Skin> getSkinList() {
		return skinList;
	}

	public List<Specialization> getSpecializationList() {
		return specializationList;
	}

	public TokenInfo getTokenInfo() {
		return tokenInfo;
	}

	public List<Trait> getTraitList() {
		return traitList;
	}

}
