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
		
	}
	
	@Override
	protected Object filterObjects(FillerObjectPatternConfig pattern) {

		return null;
	}

	@Override
	protected Object filterArrays(FillerArrayPatternConfig pattern) {
		
		return null;
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
