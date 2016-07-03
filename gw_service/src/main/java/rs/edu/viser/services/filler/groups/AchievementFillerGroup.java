package rs.edu.viser.services.filler.groups;

import java.util.List;

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

public class AchievementFillerGroup extends FillerGroup {
	private GeneratedJsonArrays arrays;
	private Achievement achievement;
	private AchievementCategory achievementCategory;
	private DailyAchievements dailyAchievements;
	private TomorrowDailyAchievements tomorrowDailyAchievements;
	private AchievementGroup achievementGroup;
	
	@Override
	public void getModels(SchedulerTypes type) {
		this.retriever = new JsonRetriever();
		this.helper = new FillerHelper();
		
		this.arrays = new GeneratedJsonArrays();
		this.achievement = new Achievement();
		this.achievementCategory = new AchievementCategory();
		this.dailyAchievements = new DailyAchievements();
		this.tomorrowDailyAchievements = new TomorrowDailyAchievements();
		this.achievementGroup = new AchievementGroup();
		
		FillerConfigReader reader = FillerConfigReader.getFillerConfigReader();
		FillerGroupConfig[] groups = reader.getFillerGroups(FillerGroupTypes.ACHIEVEMENT);
		LOG log = new LOG(this.getClass());
		
		log.info("Initializing Achievement Filler Group filler class");
		
		for (FillerPatternConfig fpc : groups[0].getFillerPatterns()) {
			if (fpc.getSchedulerType() == type || type == SchedulerTypes.ALL) {
				if (fpc instanceof FillerObjectPatternConfig) {
					//all objects
					FillerObjectPatternConfig object = (FillerObjectPatternConfig) fpc;
					if (object.getObject() instanceof Achievement) {
						processAchievement(object, groups[0].getUrlSufix());
					} else if (object.getObject() instanceof AchievementCategory) {
						processAchievementCategory(object, groups[0].getUrlSufix());
					} else if (object.getObject() instanceof DailyAchievements) {
						processDailyAchievements(object, groups[0].getUrlSufix());
					} else if (object.getObject() instanceof TomorrowDailyAchievements) {
						processTomorrowDailyAchievements(object, groups[0].getUrlSufix());
					} else if (object.getObject() instanceof AchievementGroup) {
						processAchievementGroup(object, groups[0].getUrlSufix());
					}
				} else if (fpc instanceof FillerArrayPatternConfig) {
					//all arrays
					FillerArrayPatternConfig array = (FillerArrayPatternConfig) fpc;
					if (array.getPropertyName().equals("achievements")) {
						processAchievements(array, groups[0].getUrlSufix());
					} else if (array.getPropertyName().equals("achievementCategories")) {
						processAchievementCategories(array, groups[0].getUrlSufix());
					} else if (array.getPropertyName().equals("achievementGroups")) {
						processAchievementGroups(array, groups[0].getUrlSufix());
					}
				}
			}
		}
	}

	private void processAchievement(FillerObjectPatternConfig object, String urlSufix) {
		// TODO Auto-generated method stub
		
	}

	private void processAchievementCategory(FillerObjectPatternConfig object, String urlSufix) {
		// TODO Auto-generated method stub
		
	}

	private void processDailyAchievements(FillerObjectPatternConfig object, String urlSufix) {
		// TODO Auto-generated method stub
		
	}

	private void processTomorrowDailyAchievements(FillerObjectPatternConfig object, String urlSufix) {
		// TODO Auto-generated method stub
		
	}

	private void processAchievementGroup(FillerObjectPatternConfig object, String urlSufix) {
		// TODO Auto-generated method stub
		
	}

	private void processAchievements(FillerArrayPatternConfig array, String urlSufix) {
		// TODO Auto-generated method stub
		
	}

	private void processAchievementCategories(FillerArrayPatternConfig array, String urlSufix) {
		// TODO Auto-generated method stub
		
	}

	private void processAchievementGroups(FillerArrayPatternConfig array, String urlSufix) {
		// TODO Auto-generated method stub
		
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
	
	public AchievementGroup getAchievementGroup() {
		return achievementGroup;
	}
	
	public TomorrowDailyAchievements getTomorrowDailyAchievements() {
		return tomorrowDailyAchievements;
	}
	
	public DailyAchievements getDailyAchievements() {
		return dailyAchievements;
	}
	
	public AchievementCategory getAchievementCategory() {
		return achievementCategory;
	}
	
	public Achievement getAchievement() {
		return achievement;
	}

}
