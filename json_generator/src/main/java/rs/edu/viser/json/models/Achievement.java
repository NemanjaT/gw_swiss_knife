package rs.edu.viser.json.models;

import java.util.List;
import java.util.ArrayList;

import rs.edu.viser.json.JsonModelFactoryMaster;

/**
 * Class generated by rs.edu.viser.json.generator.ClassFileWriter
 * Generated from: https://api.guildwars2.com/v2/achievements/251
 */
public class Achievement extends JsonModelFactoryMaster {

	private List<Integer> prerequisites;

	private String lockedText;

	private List<AchievementTiers> tiers;

	private String name;

	private List<String> flags;

	private String description;

	private Integer id;

	private String requirement;

	private String type;

	private List<AchievementRewards> rewards;

	//Getters and setters

	public List<Integer> getPrerequisites() {
		return this.prerequisites;
	}

	public void setPrerequisites(List<Integer> val) {
		this.prerequisites = val;
	}

	public String getLockedText() {
		return this.lockedText;
	}

	public void setLockedText(String val) {
		this.lockedText = val;
	}

	public List<AchievementTiers> getTiers() {
		return this.tiers;
	}

	public void setTiers(List<AchievementTiers> val) {
		this.tiers = val;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String val) {
		this.name = val;
	}

	public List<String> getFlags() {
		return this.flags;
	}

	public void setFlags(List<String> val) {
		this.flags = val;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String val) {
		this.description = val;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer val) {
		this.id = val;
	}

	public String getRequirement() {
		return this.requirement;
	}

	public void setRequirement(String val) {
		this.requirement = val;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String val) {
		this.type = val;
	}

	public List<AchievementRewards> getRewards() {
		return this.rewards;
	}

	public void setRewards(List<AchievementRewards> val) {
		this.rewards = val;
	}

	public Achievement() {
		this.prerequisites = new ArrayList<Integer>();
		this.tiers = new ArrayList<AchievementTiers>();
		this.flags = new ArrayList<String>();
		this.rewards = new ArrayList<AchievementRewards>();
	}

}
