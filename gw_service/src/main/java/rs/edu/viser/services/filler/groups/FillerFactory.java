package rs.edu.viser.services.filler.groups;

import rs.edu.viser.logger.LOG;
import rs.edu.viser.services.filler.config.FillerConfigReader;
import rs.edu.viser.services.filler.groups.FillerGroup.FillerGroupTypes;
import rs.edu.viser.services.filler.groups.products.ItemFiller;
import rs.edu.viser.services.filler.groups.products.WvwFiller;

public abstract class FillerFactory {
	protected static LOG logger = new LOG(FillerFactory.class);
	protected FillerGroupTypes type = FillerGroupTypes.ALL;
	
	public static FillerFactory get(FillerGroupTypes type) {
		switch(type) {
		case ITEM:
			return new ItemFiller();
		case WVW:
			return new WvwFiller();
		default:
			logger.warning(
					"How did I even get here? You forgot to put in a type here! Search for \"I suck at programming\" to find me"
				);
			break;
		}
		
		return null;
	}
	
	protected String getFullWebsite() {
		if (this.type == FillerGroupTypes.ALL) {
			return FillerConfigReader.getFillerConfigReader().getWebsite();
		}
		return FillerConfigReader.getFillerConfigReader().getWebsite() 
				+ FillerConfigReader.getFillerConfigReader().getFillerGroups(type)[0].getUrlSufix();
	}
	
	public abstract void fill();
}
