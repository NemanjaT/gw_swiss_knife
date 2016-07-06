package rs.edu.viser.services.filler.groups;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import rs.edu.viser.json.JsonRetriever;
import rs.edu.viser.json.models.Achievement;
import rs.edu.viser.json.models.AchievementCategory;
import rs.edu.viser.json.models.AchievementGroup;
import rs.edu.viser.json.models.DailyAchievements;
import rs.edu.viser.json.models.GeneratedJsonArrays;
import rs.edu.viser.json.models.TomorrowDailyAchievements;
import rs.edu.viser.logger.LOG;
import rs.edu.viser.services.filler.FillerHelper;
import rs.edu.viser.services.filler.config.FillerArrayPatternConfig;
import rs.edu.viser.services.filler.config.FillerConfigReader;
import rs.edu.viser.services.filler.config.FillerGroupConfig;
import rs.edu.viser.services.filler.config.FillerObjectPatternConfig;
import rs.edu.viser.services.filler.config.FillerPatternConfig;
import rs.edu.viser.services.filler.config.JacksonModeler;

public class AchievementFillerGroup extends FillerGroup {
	private GeneratedJsonArrays arrays;
	private List<Achievement> achievementList;
	private List<AchievementCategory> achievementCategoryList;
	private DailyAchievements dailyAchievements;
	private TomorrowDailyAchievements tomorrowDailyAchievements;
	private List<AchievementGroup> achievementGroupList;
	
	private FillerConfigReader reader;
	private JacksonModeler jack;
	
	private String url;
	private LOG log;
	
	public AchievementFillerGroup() {
		this.arrays = new GeneratedJsonArrays();
		this.achievementList = new ArrayList<>();
		this.achievementCategoryList = new ArrayList<>();
		this.dailyAchievements = new DailyAchievements();
		this.tomorrowDailyAchievements = new TomorrowDailyAchievements();
		this.achievementGroupList = new ArrayList<>();
		
		this.reader = FillerConfigReader.getFillerConfigReader();
		this.helper = new FillerHelper();
		this.retriever = new JsonRetriever();
		this.jack = new JacksonModeler();
		
		this.log = new LOG(this.getClass());
	}
	
	@Override
	public void getModels(SchedulerTypes type) {
		FillerGroupConfig fillerGroup = reader.getFillerGroups(FillerGroupTypes.ACHIEVEMENT)[0];
		log.info("Initializing Achievement Filler Group");
		
		//getting the filler patterns. . .
		FillerPatternConfig[] patternGroup = fillerGroup.getFillerPatterns();
		this.url = fillerGroup.getUrlSufix();
		
		//sorting patterns so all arrays are called in first. . .
		patternGroup = helper.orderFillerPatternConfigs(patternGroup);
		
		this.readThroughPatterns(patternGroup, type);
		
		log.info("Achievement Filler Group initialization finished!");
	}
	
	@Override
	protected Object filterObjects(FillerObjectPatternConfig pattern) {
		if (pattern.getObject() instanceof Achievement) {
			processAchievement(pattern);
		} else if (pattern.getObject() instanceof AchievementCategory) {
			processAchievementCategory(pattern);
		} else if (pattern.getObject() instanceof DailyAchievements) {
			processDailyAchievements(pattern);
		} else if (pattern.getObject() instanceof TomorrowDailyAchievements) {
			processTomorrowDailyAchievements(pattern);
		} else if (pattern.getObject() instanceof AchievementGroup) {
			processAchievementGroup(pattern);
		}
		
		return this;
	}

	@Override
	protected Object filterArrays(FillerArrayPatternConfig pattern) {
		if (pattern.getPropertyName().equals("achievements")) {
			processAchievements(pattern);
		} else if (pattern.getPropertyName().equals("achievementCategories")) {
			processAchievementCategories(pattern);
		} else if (pattern.getPropertyName().equals("achievementGroups")) {
			processAchievementGroups(pattern);
		}
		
		return this;
	}

	private void processAchievement(FillerObjectPatternConfig object) {
		log.info("Accessing Achievement Filler Group :: Achievement processor");
		try {
			for (Integer i : arrays.getAchievements()) {
				JSONObject json = 
						this.retriever.getParametarizedJsonObject(url + object.getUrlPattern(), i.toString());
			
				this.achievementList.add(jack.readValue(json.toString(), Achievement.class));
			}
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}

	private void processAchievementCategory(FillerObjectPatternConfig object) {
		log.info("Accessing Achievement Filler Group :: Achievement Category processor");
		try {
			for (Integer i : arrays.getAchievementCategories()) {
				JSONObject json = 
						this.retriever.getParametarizedJsonObject(url + object.getUrlPattern(), i.toString());
			
				this.achievementCategoryList.add(jack.readValue(json.toString(), AchievementCategory.class));
			}
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}

	private void processDailyAchievements(FillerObjectPatternConfig object) {
		log.info("Accessing Achievement Filler Group :: Daily Achievement processor");
		try {
			JSONObject json = 
					this.retriever.getParametarizedJsonObject(url + object.getUrlPattern());
		
			this.dailyAchievements = jack.readValue(json.toString(), DailyAchievements.class);
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}

	private void processTomorrowDailyAchievements(FillerObjectPatternConfig object) {
		log.info("Accessing Achievement Filler Group :: Tomorrow Daily Achievement processor");
		try {
			JSONObject json = 
					this.retriever.getParametarizedJsonObject(url + object.getUrlPattern());
		
			this.tomorrowDailyAchievements = jack.readValue(json.toString(), TomorrowDailyAchievements.class);
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}

	private void processAchievementGroup(FillerObjectPatternConfig object) {
		log.info("Accessing Achievement Filler Group :: Achievement Group processor");
		try {
			for (String i : arrays.getAchievementGroups()) {
				JSONObject json = 
						this.retriever.getParametarizedJsonObject(url + object.getUrlPattern(), i);
			
				this.achievementGroupList.add(jack.readValue(json.toString(), AchievementGroup.class));
			}
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}

	private void processAchievements(FillerArrayPatternConfig array) {
		log.info("Accessing Account Filler Group :: Achievements processor");
		try {
			JSONArray json = 
					this.retriever.getParametarizedJsonArray(url + array.getUrlPattern());
			
			this.arrays.setAchievements(jack.readValue(json.toString(),
					jack.getTypeFactory().constructCollectionType(List.class, Integer.class)));
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}

	private void processAchievementCategories(FillerArrayPatternConfig array) {
		log.info("Accessing Account Filler Group :: Achievement Categories processor");
		try {
			JSONArray json = 
					this.retriever.getParametarizedJsonArray(url + array.getUrlPattern());
			
			this.arrays.setAchievementCategories(jack.readValue(json.toString(),
					jack.getTypeFactory().constructCollectionType(List.class, Integer.class)));
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}

	private void processAchievementGroups(FillerArrayPatternConfig array) {
		log.info("Accessing Account Filler Group :: Achievement Groups processor");
		try {
			JSONArray json = 
					this.retriever.getParametarizedJsonArray(url + array.getUrlPattern());
			
			this.arrays.setAchievementGroups(jack.readValue(json.toString(),
					jack.getTypeFactory().constructCollectionType(List.class, String.class)));
		} catch (IOException | JSONException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public List<String> getAchievementGroups() {
		return arrays.getAchievementGroups();
	}
	
	public List<Integer> getAchievementCategories() {
		return arrays.getAchievementCategories();
	}
	
	public List<Integer> getAchievements() {
		return arrays.getAchievements();
	}
	
	public List<AchievementGroup> getAchievementGroup() {
		return achievementGroupList;
	}
	
	public TomorrowDailyAchievements getTomorrowDailyAchievements() {
		return tomorrowDailyAchievements;
	}
	
	public DailyAchievements getDailyAchievements() {
		return dailyAchievements;
	}
	
	public List<AchievementCategory> getAchievementCategory() {
		return achievementCategoryList;
	}
	
	public List<Achievement> getAchievement() {
		return achievementList;
	}

}
