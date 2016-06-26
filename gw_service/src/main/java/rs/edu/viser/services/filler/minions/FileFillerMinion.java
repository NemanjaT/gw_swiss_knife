package rs.edu.viser.services.filler.minions;

import org.json.JSONObject;

import rs.edu.viser.json.models.File;
import rs.edu.viser.services.filler.FillerHelper;
import rs.edu.viser.services.filler.FillerMinionFactoryObjectMaster;

public class FileFillerMinion implements FillerMinionFactoryObjectMaster {
	
	private FillerHelper helper;
	private File file;
	
	public FileFillerMinion() {
		this.helper = new FillerHelper();
		this.file = new File();
	}
	
	@Override
	public void fill(JSONObject object) {
		file.setId(helper.getStringValue(object, "id"));
		file.setIcon(helper.getStringValue(object, "icon"));
	}
	
}
