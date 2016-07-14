package rs.edu.viser.json.models;

import java.util.List;
import java.util.ArrayList;

import rs.edu.viser.json.JsonModelFactoryMaster;

/**
 * Class generated by rs.edu.viser.json.generator.ClassFileWriter
 * Generated from: https://api.guildwars2.com/v2/emblem/foregrounds/1
 */
public class EmblemForeground extends JsonModelFactoryMaster {

	private List<String> layers;

	private Integer id;

	//Getters and setters

	public List<String> getLayers() {
		return this.layers;
	}

	public void setLayers(List<String> val) {
		this.layers = val;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer val) {
		this.id = val;
	}

	public EmblemForeground() {
		this.layers = new ArrayList<String>();
	}

}