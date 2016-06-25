package rs.edu.viser.json.models;

import java.util.List;
import java.util.ArrayList;

import rs.edu.viser.json.JsonModelFactoryMaster;

/**
 * Class generated by rs.edu.viser.json.generator.ClassFileWriter
 * Generated from: https://api.guildwars2.com/v2/currencies/2
 */
public class Currency extends JsonModelFactoryMaster {

	private String name;

	private String icon;

	private String description;

	private Integer id;

	private Integer order;

	//Getters and setters

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

	public Integer getOrder() {
		return this.order;
	}

	public void setOrder(Integer val) {
		this.order = val;
	}

	public Currency() {
	}

}
