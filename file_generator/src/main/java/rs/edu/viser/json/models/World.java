package rs.edu.viser.json.models;

import java.util.List;
import java.util.ArrayList;

import rs.edu.viser.json.JsonModelFactoryMaster;

/**
 * Class generated by rs.edu.viser.json.generator.ClassFileWriter
 * Generated from: https://api.guildwars2.com/v2/worlds/1022
 */
public class World extends JsonModelFactoryMaster {

	private String name;

	private Integer id;

	private String population;

	//Getters and setters

	public String getName() {
		return this.name;
	}

	public void setName(String val) {
		this.name = val;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer val) {
		this.id = val;
	}

	public String getPopulation() {
		return this.population;
	}

	public void setPopulation(String val) {
		this.population = val;
	}

	public World() {
	}

}