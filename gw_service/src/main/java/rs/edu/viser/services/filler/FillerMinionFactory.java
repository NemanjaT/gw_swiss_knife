package rs.edu.viser.services.filler;

import rs.edu.viser.json.JsonModelFactoryMaster;
import rs.edu.viser.json.models.File;
import rs.edu.viser.services.filler.minions.FileFillerMinion;

public class FillerMinionFactory {
	
	private JsonModelFactoryMaster model;
	
	public FillerMinionFactory(JsonModelFactoryMaster model) {
		this.model = model;
	}
	
	public FillerMinionFactoryObjectMaster work() {
		FillerMinionFactoryObjectMaster resObject = null;
		
		//TODO: add a bunch of if statements. . .
		// if (this.model instanceof SomeMinion) { ... }
		if (model instanceof File) {
			return new FileFillerMinion();
		}
		
		return resObject;
	}

}
