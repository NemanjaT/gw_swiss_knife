package rs.edu.viser.json.models;

import java.util.List;
import java.util.ArrayList;

import rs.edu.viser.json.JsonModelFactoryMaster;

/**
 * Class generated by rs.edu.viser.json.generator.ClassFileWriter
 * Generated from: null
 */
public class ProfessionWeaponsSword extends JsonModelFactoryMaster {

	private List<ProfessionWeaponsSwordSkills> skills;

	//Getters and setters

	public List<ProfessionWeaponsSwordSkills> getSkills() {
		return this.skills;
	}

	public void setSkills(List<ProfessionWeaponsSwordSkills> val) {
		this.skills = val;
	}

	public ProfessionWeaponsSword() {
		this.skills = new ArrayList<ProfessionWeaponsSwordSkills>();
	}

}
