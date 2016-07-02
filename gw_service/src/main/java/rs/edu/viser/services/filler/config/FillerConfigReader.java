package rs.edu.viser.services.filler.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import rs.edu.viser.services.filler.groups.FillerGroup.FillerGroupTypes;
import rs.edu.viser.services.filler.groups.FillerGroup.SchedulerTypes;

/**
 * Reads through the fillerConfig xml configuration file and returns the results.
 * @author neman
 *
 */
public class FillerConfigReader {
	
	private static FillerConfigReader instance;
	
	private String website;
	private FillerGroupConfig[] fillerGroups;
	
	/**
	 * Sets the data from the xml configuration file (from an existing file or returns a new one).
	 */
	public static FillerConfigReader getFillerConfigReader() {
		if (instance == null) {
			instance = new FillerConfigReader();
		}
		return instance;
	}
	
	/**
	 * constructor . . .
	 */
	private FillerConfigReader() {
		//Open file context and read data
		ApplicationContext context = new ClassPathXmlApplicationContext("schedulerTasks.xml");
		FillerConfig filler = (FillerConfig) context.getBean("fillerConfig");
		
		//Setting the data
		this.website = filler.getWebsite();
		this.fillerGroups = filler.getFillerGroups();
		
		//Closing the context
        ((ConfigurableApplicationContext) context).close();
	}

	/**
	 * Returns website
	 * @return
	 */
	public String getWebsite() {
		return website;
	}

//	/**
//	 * Sets website
//	 * @param website
//	 */
//	public void setWebsite(String website) {
//		this.website = website;
//	}

	/**
	 * Returns filler groups
	 * @return
	 */
	public FillerGroupConfig[] getFillerGroups() {
		return fillerGroups;
	}
	
	/**
	 * Sets filler groups of scheduler type
	 * @param schedulerTypes
	 * @return
	 */
	public FillerGroupConfig[] getFillerGroups(SchedulerTypes schedulerTypes) {
		//If it's all skip and return all
		if (schedulerTypes == SchedulerTypes.ALL) {
			return fillerGroups;
		}
		List<FillerGroupConfig> list = new ArrayList<>();
		for (FillerGroupConfig groupConf : fillerGroups) {
			if (groupConf.getSchedulerType() == schedulerTypes) {
				list.add(groupConf);
			}
		}
		return list.toArray(new FillerGroupConfig[list.size()]);
	}
	
	/**
	 * Gets filler groups of filler group type
	 * @param groupTypes
	 * @return
	 */
	public FillerGroupConfig[] getFillerGroups(FillerGroupTypes groupTypes) {
		//If it's all skip and return all
		if (groupTypes == FillerGroupTypes.ALL) {
			return fillerGroups;
		}
		List<FillerGroupConfig> list = new ArrayList<>();
		for (FillerGroupConfig groupConf : fillerGroups) {
			if (groupConf.getFillerGroupType() == groupTypes) {
				list.add(groupConf);
			}
		}
		return list.toArray(new FillerGroupConfig[list.size()]);
	}
	
	/**
	 * Gets filler groups of filler group type and of scheduler type
	 * @param groupTypes
	 * @param schedulerTypes
	 * @return
	 */
	public FillerGroupConfig[] getFillerGroups(FillerGroupTypes groupTypes, SchedulerTypes schedulerTypes) {
		//If both are all return all
		if (groupTypes == FillerGroupTypes.ALL && schedulerTypes == SchedulerTypes.ALL) {
			return fillerGroups;
		}
		List<FillerGroupConfig> list = new ArrayList<>();
		for (FillerGroupConfig groupConf : fillerGroups) {
			if ((groupConf.getFillerGroupType() == groupTypes 
					|| groupTypes == FillerGroupTypes.ALL)
					&& (groupConf.getSchedulerType() == schedulerTypes
							|| schedulerTypes == SchedulerTypes.ALL)) {
				list.add(groupConf);
			}
		}
		return list.toArray(new FillerGroupConfig[list.size()]);
	}

//	/**
//	 * Sets filler groups
//	 * @param fillerGroups
//	 */
//	public void setFillerGroups(FillerGroupConfig[] fillerGroups) {
//		this.fillerGroups = fillerGroups;
//	}
//	
//	/**
//	 * Sets filler groups of scheduler type
//	 * @param schedulerTypes
//	 */
//	public void setFillerGroups(SchedulerTypes schedulerTypes) {
//		List<FillerGroupConfig> list = new ArrayList<>();
//		for (FillerGroupConfig groupConf : fillerGroups) {
//			if (groupConf.getSchedulerType() == schedulerTypes || schedulerTypes == SchedulerTypes.ALL) {
//				list.add(groupConf);
//			}
//		}
//		this.fillerGroups = list.toArray(new FillerGroupConfig[list.size()]);
//	}
//	
//	/**
//	 * Sets the filler groups of group type
//	 * @param groupTypes
//	 */
//	public void setFillerGroups(FillerGroupTypes groupTypes) {
//		List<FillerGroupConfig> list = new ArrayList<>();
//		for (FillerGroupConfig groupConf : fillerGroups) {
//			if (groupConf.getFillerGroupType() == groupTypes || groupTypes == FillerGroupTypes.ALL) {
//				list.add(groupConf);
//			}
//		}
//		this.fillerGroups = list.toArray(new FillerGroupConfig[list.size()]);
//	}
	
}
