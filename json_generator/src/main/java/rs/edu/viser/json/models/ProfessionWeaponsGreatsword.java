package rs.edu.viser.json.models;

import java.util.List;
import java.util.ArrayList;

import rs.edu.viser.json.JsonModelFactoryMaster;

/**
 * Class generated by rs.edu.viser.json.generator.ClassFileWriter
 * Generated from: null
 */
public class ProfessionWeaponsGreatsword extends JsonModelFactoryMaster {

	private List<ProfessionWeaponsGreatswordSkills> skills;

	//Getters and setters

	public List<ProfessionWeaponsGreatswordSkills> getSkills() {
		return this.skills;
	}

	public void setSkills(List<ProfessionWeaponsGreatswordSkills> val) {
		this.skills = val;
	}

	public ProfessionWeaponsGreatsword() {
		this.skills = new ArrayList<ProfessionWeaponsGreatswordSkills>();
	}

}
