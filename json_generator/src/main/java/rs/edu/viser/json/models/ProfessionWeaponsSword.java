package rs.edu.viser.json.models;

import java.util.List;
import java.util.ArrayList;

import rs.edu.viser.json.JsonModelFactoryMaster;

/**
 * Class generated by rs.edu.viser.json.generator.ClassFileWriter
 * Generated from: null
 */
public class ProfessionWeaponsSword extends JsonModelFactoryMaster {

	private List<ProfessionWeaponsSwordSkills> professionWeaponsSwordSkills;

	//Getters and setters

	public List<ProfessionWeaponsSwordSkills> getProfessionWeaponsSwordSkills() {
		return this.professionWeaponsSwordSkills;
	}

	public void setProfessionWeaponsSwordSkills(List<ProfessionWeaponsSwordSkills> val) {
		this.professionWeaponsSwordSkills = val;
	}

	public ProfessionWeaponsSword() {
		this.professionWeaponsSwordSkills = new ArrayList<ProfessionWeaponsSwordSkills>();
	}

}
