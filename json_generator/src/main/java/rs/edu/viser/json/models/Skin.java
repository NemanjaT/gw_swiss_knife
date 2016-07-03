package rs.edu.viser.json.models;

import java.util.List;
import java.util.ArrayList;

import rs.edu.viser.json.JsonModelFactoryMaster;

/**
 * Class generated by rs.edu.viser.json.generator.ClassFileWriter
 * Generated from: https://api.guildwars2.com/v2/skins/1994
 */
public class Skin extends JsonModelFactoryMaster {

	private String name;

	private List<String> flags;

	private String icon;

	private List<Object> restrictions; //TODO: GW-0001 

	private SkinDetails details;

	private Integer id;

	private String type;

	private String rarity;

	//Getters and setters

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

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String val) {
		this.icon = val;
	}

	public List<Object> getRestrictions() {
		return this.restrictions;
	}

	public void setRestrictions(List<Object> val) {
		this.restrictions = val;
	}

	public SkinDetails getDetails() {
		return this.details;
	}

	public void setDetails(SkinDetails val) {
		this.details = val;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer val) {
		this.id = val;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String val) {
		this.type = val;
	}

	public String getRarity() {
		return this.rarity;
	}

	public void setRarity(String val) {
		this.rarity = val;
	}

	public Skin() {
		this.flags = new ArrayList<String>();
		this.restrictions = new ArrayList<Object>();
	}

}
