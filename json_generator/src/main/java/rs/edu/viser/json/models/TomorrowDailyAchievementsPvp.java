package rs.edu.viser.json.models;

import java.util.List;
import java.util.ArrayList;

import rs.edu.viser.json.JsonModelFactoryMaster;

/**
 * Class generated by rs.edu.viser.json.generator.ClassFileWriter
 * Generated from: null
 */
public class TomorrowDailyAchievementsPvp extends JsonModelFactoryMaster {

	private TomorrowDailyAchievementsPvpLevel level;

	private Integer id;

	private List<String> requiredAccess;

	//Getters and setters

	public TomorrowDailyAchievementsPvpLevel getLevel() {
		return this.level;
	}

	public void setLevel(TomorrowDailyAchievementsPvpLevel val) {
		this.level = val;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer val) {
		this.id = val;
	}

	public List<String> getRequiredAccess() {
		return this.requiredAccess;
	}

	public void setRequiredAccess(List<String> val) {
		this.requiredAccess = val;
	}

	public TomorrowDailyAchievementsPvp() {
		this.requiredAccess = new ArrayList<String>();
	}

}
