package rs.edu.viser.json.models;

import java.util.List;
import java.util.ArrayList;

import rs.edu.viser.json.JsonModelFactoryMaster;

/**
 * Class generated by rs.edu.viser.json.generator.ClassFileWriter
 * Generated from: null
 */
public class ProfessionWeaponsFocus extends JsonModelFactoryMaster {

	private List<ProfessionWeaponsFocusSkills> professionWeaponsFocusSkills;

	//Getters and setters

	public List<ProfessionWeaponsFocusSkills> getProfessionWeaponsFocusSkills() {
		return this.professionWeaponsFocusSkills;
	}

	public void setProfessionWeaponsFocusSkills(List<ProfessionWeaponsFocusSkills> val) {
		this.professionWeaponsFocusSkills = val;
	}

	public ProfessionWeaponsFocus() {
		this.professionWeaponsFocusSkills = new ArrayList<ProfessionWeaponsFocusSkills>();
	}

}
