package rs.edu.viser.json.models;

import java.util.List;
import java.util.ArrayList;

import rs.edu.viser.json.JsonModelFactoryMaster;

/**
 * Class generated by rs.edu.viser.json.generator.ClassFileWriter
 * Generated from: null
 */
public class ItemDetailsInfixUpgrade extends JsonModelFactoryMaster {

	private List<ItemDetailsInfixUpgradeAttributes> attributes;

	private Integer id;

	//Getters and setters

	public List<ItemDetailsInfixUpgradeAttributes> getAttributes() {
		return this.attributes;
	}

	public void setAttributes(List<ItemDetailsInfixUpgradeAttributes> val) {
		this.attributes = val;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer val) {
		this.id = val;
	}

	public ItemDetailsInfixUpgrade() {
		this.attributes = new ArrayList<ItemDetailsInfixUpgradeAttributes>();
	}

}