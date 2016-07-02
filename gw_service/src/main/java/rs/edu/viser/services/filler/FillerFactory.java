package rs.edu.viser.services.filler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import rs.edu.viser.logger.LOG;
import rs.edu.viser.services.filler.config.FillerConfigReader;
import rs.edu.viser.services.filler.config.FillerGroupConfig;
import rs.edu.viser.services.filler.groups.AccountFillerGroup;
import rs.edu.viser.services.filler.groups.AchievementFillerGroup;
import rs.edu.viser.services.filler.groups.CharacterFillerGroup;
import rs.edu.viser.services.filler.groups.CommerceFillerGroup;
import rs.edu.viser.services.filler.groups.DecorativeFillerGroup;
import rs.edu.viser.services.filler.groups.FillerGroup;
import rs.edu.viser.services.filler.groups.ItemFillerGroup;
import rs.edu.viser.services.filler.groups.PvpFillerGroup;
import rs.edu.viser.services.filler.groups.SystemFillerGroup;
import rs.edu.viser.services.filler.groups.WorldFillerGroup;
import rs.edu.viser.services.filler.groups.WvwFillerGroup;
import rs.edu.viser.services.filler.groups.FillerGroup.FillerGroupTypes;

/**
 * Reads through the configuration reader and sets the values of 
 * website and filler groups array.
 * @author neman
 *
 */
public class FillerFactory {
	private FillerConfigReader reader;
	private LOG log;
	
	private String website;
	private FillerGroupConfig[] fillerGroups;
	
	/**
	 * Reads through the config file and returns all filler groups.
	 */
	public FillerFactory() {
		this.reader = FillerConfigReader.getFillerConfigReader();
		this.log = new LOG(this.getClass());
		
		log.info("Initializing filler factory. . . . . . . . .");
		
		this.website = reader.getWebsite();
		this.fillerGroups = reader.getFillerGroups();
	}
	
	/**
	 * Replaces the type to just the types that have a group type specified.
	 * @param type filler group type
	 * @return this
	 */
	public FillerFactory fillerGroups(FillerGroupTypes type) {
		log.info("Filtering group types (" + type.toString() + ") ...");
		//If it's set to all types, don't filter anything...
		if (type == FillerGroupTypes.ALL) {
			return this;
		}
		List<FillerGroupConfig> toRemove = new LinkedList<>(Arrays.asList(this.fillerGroups));
		toRemove.removeAll(Arrays.asList(reader.getFillerGroups(type)));
		List<FillerGroupConfig> subList = new LinkedList<>(Arrays.asList(this.fillerGroups));
		subList.removeAll(toRemove);
		this.fillerGroups = subList.toArray(new FillerGroupConfig[subList.size()]);
		return this;
	}
	
	/**
	 * Returns a list of filler group classes.
	 * @return
	 */
	public List<FillerGroup> getFillerGroup() {
		List<FillerGroup> fillerGroupList = new ArrayList<>();
		log.info("Importing filler groups...");
		
		//Check the type of the filler group and add the right filler class to the list.
		for (FillerGroupConfig groupConf : fillerGroups) {
			String fullWebsite = website + groupConf.getUrlSufix();
			groupConf.setUrlSufix(fullWebsite);
			
			log.info("Searching for filler group for " + groupConf.getFillerGroupType());
			
			if (groupConf.getFillerGroupType() == FillerGroupTypes.ACCOUNT) {
				fillerGroupList.add(new AccountFillerGroup());
				
			} else if (groupConf.getFillerGroupType() == FillerGroupTypes.ACHIEVEMENT) {
				fillerGroupList.add(new AchievementFillerGroup());
			
			} else if (groupConf.getFillerGroupType() == FillerGroupTypes.CHARACTER) {
				fillerGroupList.add(new CharacterFillerGroup());
			
			} else if (groupConf.getFillerGroupType() == FillerGroupTypes.COMMERCE) {
				fillerGroupList.add(new CommerceFillerGroup());
				
			} else if (groupConf.getFillerGroupType() == FillerGroupTypes.DECORATIVE) {
				fillerGroupList.add(new DecorativeFillerGroup());
				
			} else if (groupConf.getFillerGroupType() == FillerGroupTypes.ITEM) {
				fillerGroupList.add(new ItemFillerGroup());
				
			} else if (groupConf.getFillerGroupType() == FillerGroupTypes.PVP) {
				fillerGroupList.add(new PvpFillerGroup());
				
			} else if (groupConf.getFillerGroupType() == FillerGroupTypes.SYSTEM) { 
				fillerGroupList.add(new SystemFillerGroup());
				
			} else if (groupConf.getFillerGroupType() == FillerGroupTypes.WORLD) {
				fillerGroupList.add(new WorldFillerGroup());
				
			} else if (groupConf.getFillerGroupType() == FillerGroupTypes.WVW) {
				fillerGroupList.add(new WvwFillerGroup());
				
			} else {
				log.warning("Filler group not found! (" + groupConf.getFillerGroupType().toString() + ")");
			}
		}
		
		return fillerGroupList;
	}

}
