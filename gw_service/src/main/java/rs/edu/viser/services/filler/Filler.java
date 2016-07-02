package rs.edu.viser.services.filler;

import rs.edu.viser.logger.LOG;
import rs.edu.viser.services.filler.groups.FillerGroup;
import rs.edu.viser.services.filler.groups.FillerGroup.FillerGroupTypes;
import rs.edu.viser.services.filler.groups.FillerGroup.SchedulerTypes;

public class Filler {
	
	public static void main(String[] args) {
		
		FillerFactory ff = new FillerFactory().fillerGroups(FillerGroupTypes.ACCOUNT);
		for (FillerGroup fg : ff.getFillerGroup()) {
			//placeholder access token: 79D451B9-26E6-6943-BDA6-AC9D05EE563DA640C336-0F50-4875-8350-23E6C642A0F1
			fg.setAccessToken("79D451B9-26E6-6943-BDA6-AC9D05EE563DA640C336-0F50-4875-8350-23E6C642A0F1");
			new LOG(Filler.class).info(fg.toString());
			fg.getModels(SchedulerTypes.DAILY);
		}
		
	}

}
