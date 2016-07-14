package rs.edu.viser.json.models;

import java.util.List;
import java.util.ArrayList;

import rs.edu.viser.json.JsonModelFactoryMaster;

/**
 * Class generated by rs.edu.viser.json.generator.ClassFileWriter
 * Generated from: null
 */
public class TomorrowDailyAchievementsWvw extends JsonModelFactoryMaster {

	private TomorrowDailyAchievementsWvwLevel level;

	private Integer id;

	private List<String> requiredAccess;

	//Getters and setters

	public TomorrowDailyAchievementsWvwLevel getLevel() {
		return this.level;
	}

	public void setLevel(TomorrowDailyAchievementsWvwLevel val) {
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

	public TomorrowDailyAchievementsWvw() {
		this.requiredAccess = new ArrayList<String>();
	}

}