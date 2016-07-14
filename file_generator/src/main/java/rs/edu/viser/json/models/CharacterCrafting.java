package rs.edu.viser.json.models;

import java.util.List;
import java.util.ArrayList;

import rs.edu.viser.json.JsonModelFactoryMaster;

/**
 * Class generated by rs.edu.viser.json.generator.ClassFileWriter
 * Generated from: https://api.guildwars2.com/v2/characters/Aliron%20Rapidblade/crafting?access_token=79D451B9-26E6-6943-BDA6-AC9D05EE563DA640C336-0F50-4875-8350-23E6C642A0F1
 */
public class CharacterCrafting extends JsonModelFactoryMaster {

	private List<CharacterCraftingCrafting> crafting;

	//Getters and setters

	public List<CharacterCraftingCrafting> getCrafting() {
		return this.crafting;
	}

	public void setCrafting(List<CharacterCraftingCrafting> val) {
		this.crafting = val;
	}

	public CharacterCrafting() {
		this.crafting = new ArrayList<CharacterCraftingCrafting>();
	}

}