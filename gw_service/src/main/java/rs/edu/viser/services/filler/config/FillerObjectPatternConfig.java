package rs.edu.viser.services.filler.config;

import rs.edu.viser.json.JsonModelFactoryMaster;

public class FillerObjectPatternConfig extends FillerPatternConfig {
	
	private JsonModelFactoryMaster object;
	
	public JsonModelFactoryMaster getObject() {
		return this.object;
	}
	
	public void setObject(JsonModelFactoryMaster object) {
		this.object = object;
	}

}
