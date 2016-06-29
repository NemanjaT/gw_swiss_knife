package rs.edu.viser.services.filler;

import java.util.ArrayList;
import java.util.List;

import rs.edu.viser.services.filler.config.FillerConfigReader;
import rs.edu.viser.services.filler.config.FillerGroupConfig;
import rs.edu.viser.services.filler.groups.AccountFillerGroup;
import rs.edu.viser.services.filler.groups.AchievementFillerGroup;
import rs.edu.viser.services.filler.groups.FillerGroup;
import rs.edu.viser.services.filler.groups.FillerGroup.FillerGroupTypes;

public class FillerFactory {
	private String website;
	private FillerGroupConfig[] fillerGroups;
	
	public FillerFactory() {
		FillerConfigReader reader = FillerConfigReader.getFillerConfigReader();
		
		this.website = reader.getWebsite();
		this.fillerGroups = reader.getFillerGroups();
	}
	
	public FillerFactory(FillerGroupTypes type) {
		FillerConfigReader reader = FillerConfigReader.getFillerConfigReader();
		
		this.website = reader.getWebsite();
		this.fillerGroups = reader.getFillerGroups(type);
	}
	
	public List<FillerGroup> getFillerGroup() {
		List<FillerGroup> fillerGroupList = new ArrayList<>();
		
		for (FillerGroupConfig groupConf : fillerGroups) {
			String fullWebsite = website + groupConf.getUrlSufix();
			groupConf.setUrlSufix(fullWebsite);
			
			if (groupConf.getFillerGroupType() == FillerGroupTypes.ACCOUNT) {
				fillerGroupList.add(new AccountFillerGroup());
			} else if (groupConf.getFillerGroupType() == FillerGroupTypes.ACHIEVEMENT) {
				fillerGroupList.add(new AchievementFillerGroup());
			}
			//TODO: . . .
		}
		
		return fillerGroupList;
	}

}
