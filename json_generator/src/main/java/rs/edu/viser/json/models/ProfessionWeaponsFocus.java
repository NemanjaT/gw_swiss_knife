package rs.edu.viser.json.models;

import java.util.List;
import java.util.ArrayList;

import rs.edu.viser.json.JsonModelFactoryMaster;

/**
 * Class generated by rs.edu.viser.json.generator.ClassFileWriter
 * Generated from: null
 */
public class ProfessionWeaponsFocus extends JsonModelFactoryMaster {

	private List<ProfessionWeaponsFocusSkills> skills;

	//Getters and setters

	public List<ProfessionWeaponsFocusSkills> getSkills() {
		return this.skills;
	}

	public void setSkills(List<ProfessionWeaponsFocusSkills> val) {
		this.skills = val;
	}

	public ProfessionWeaponsFocus() {
		this.skills = new ArrayList<ProfessionWeaponsFocusSkills>();
	}

}
