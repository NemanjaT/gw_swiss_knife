package rs.edu.viser.json.models;

import java.util.List;
import java.util.ArrayList;

import rs.edu.viser.json.JsonModelFactoryMaster;

/**
 * Class generated by rs.edu.viser.json.generator.ClassFileWriter
 * Generated from: https://api.guildwars2.com/v2/achievements/groups/65B4B678-607E-4D97-B458-076C3E96A810
 */
public class AchievementGroup extends JsonModelFactoryMaster {

	private String name;

	private String description;

	private String id;

	private List<Integer> categories;

	private Integer order;

	//Getters and setters

	public String getName() {
		return this.name;
	}

	public void setName(String val) {
		this.name = val;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String val) {
		this.description = val;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String val) {
		this.id = val;
	}

	public List<Integer> getCategories() {
		return this.categories;
	}

	public void setCategories(List<Integer> val) {
		this.categories = val;
	}

	public Integer getOrder() {
		return this.order;
	}

	public void setOrder(Integer val) {
		this.order = val;
	}

	public AchievementGroup() {
		this.categories = new ArrayList<Integer>();
	}

}