package rs.edu.viser.json.models;

import java.util.List;
import java.util.ArrayList;

import rs.edu.viser.json.JsonModelFactoryMaster;

/**
 * Class generated by rs.edu.viser.json.generator.ClassFileWriter
 * Generated from: https://api.guildwars2.com/v2/professions/Guardian
 */
public class Profession extends JsonModelFactoryMaster {

	private String iconBig;

	private List<Integer> specializations;

	private String name;

	private String icon;

	private List<ProfessionTraining> training;

	private String id;

	private ProfessionWeapons weapons;

	//Getters and setters

	public String getIconBig() {
		return this.iconBig;
	}

	public void setIconBig(String val) {
		this.iconBig = val;
	}

	public List<Integer> getSpecializations() {
		return this.specializations;
	}

	public void setSpecializations(List<Integer> val) {
		this.specializations = val;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String val) {
		this.name = val;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String val) {
		this.icon = val;
	}

	public List<ProfessionTraining> getTraining() {
		return this.training;
	}

	public void setTraining(List<ProfessionTraining> val) {
		this.training = val;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String val) {
		this.id = val;
	}

	public ProfessionWeapons getWeapons() {
		return this.weapons;
	}

	public void setWeapons(ProfessionWeapons val) {
		this.weapons = val;
	}

	public Profession() {
		this.specializations = new ArrayList<Integer>();
		this.training = new ArrayList<ProfessionTraining>();
	}

}