package rs.edu.viser.json.models;

import java.util.List;
import java.util.ArrayList;

import rs.edu.viser.json.JsonModelFactoryMaster;

/**
 * Class generated by rs.edu.viser.json.generator.ClassFileWriter
 * Generated from: null
 */
public class ProfessionTraining extends JsonModelFactoryMaster {

	private String name;

	private Integer id;

	private String category;

	private List<ProfessionTrainingTrack> professionTrainingTrack;

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

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String val) {
		this.category = val;
	}

	public List<ProfessionTrainingTrack> getProfessionTrainingTrack() {
		return this.professionTrainingTrack;
	}

	public void setProfessionTrainingTrack(List<ProfessionTrainingTrack> val) {
		this.professionTrainingTrack = val;
	}

	public ProfessionTraining() {
		this.professionTrainingTrack = new ArrayList<ProfessionTrainingTrack>();
	}

}
