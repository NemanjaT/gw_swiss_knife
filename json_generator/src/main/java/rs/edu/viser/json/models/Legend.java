package rs.edu.viser.json.models;

import java.util.List;
import java.util.ArrayList;

import rs.edu.viser.json.JsonModelFactoryMaster;

/**
 * Class generated by rs.edu.viser.json.generator.ClassFileWriter
 * Generated from: https://api.guildwars2.com/v2/legends/Legend2
 */
public class Legend extends JsonModelFactoryMaster {

	private Integer elite;

	private Integer swap;

	private Integer heal;

	private String id;

	private List<Integer> utilities;

	//Getters and setters

	public Integer getElite() {
		return this.elite;
	}

	public void setElite(Integer val) {
		this.elite = val;
	}

	public Integer getSwap() {
		return this.swap;
	}

	public void setSwap(Integer val) {
		this.swap = val;
	}

	public Integer getHeal() {
		return this.heal;
	}

	public void setHeal(Integer val) {
		this.heal = val;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String val) {
		this.id = val;
	}

	public List<Integer> getUtilities() {
		return this.utilities;
	}

	public void setUtilities(List<Integer> val) {
		this.utilities = val;
	}

	public Legend() {
		this.utilities = new ArrayList<Integer>();
	}

}
