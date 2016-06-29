package rs.edu.viser.services.filler.groups;

import java.util.List;

import rs.edu.viser.json.JsonModelFactoryMaster;

public abstract class FillerGroup {
	
	public enum FillerGroupTypes {
		ACCOUNT, ACHIEVEMENT, CHARACTER, COMMERCE, DECORATIVE, ITEM, PVP, SYSTEM, WORLD, WVW
	}
	
	public abstract List<JsonModelFactoryMaster> getModel();
	
}
