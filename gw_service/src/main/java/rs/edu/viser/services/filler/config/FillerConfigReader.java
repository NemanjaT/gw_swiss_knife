package rs.edu.viser.services.filler.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import rs.edu.viser.services.filler.groups.FillerGroup.FillerGroupTypes;
import rs.edu.viser.services.scheduler.SchedulerTypes;

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

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public FillerGroupConfig[] getFillerGroups() {
		return fillerGroups;
	}
	
	public FillerGroupConfig[] getFillerGroups(SchedulerTypes schedulerTypes) {
		List<FillerGroupConfig> list = new ArrayList<>();
		for (FillerGroupConfig groupConf : fillerGroups) {
			if (groupConf.getSchedulerType() == schedulerTypes) {
				list.add(groupConf);
			}
		}
		return list.toArray(new FillerGroupConfig[list.size()]);
	}
	
	public FillerGroupConfig[] getFillerGroups(FillerGroupTypes groupTypes) {
		List<FillerGroupConfig> list = new ArrayList<>();
		for (FillerGroupConfig groupConf : fillerGroups) {
			if (groupConf.getFillerGroupType() == groupTypes) {
				list.add(groupConf);
			}
		}
		return list.toArray(new FillerGroupConfig[list.size()]);
	}

	public void setFillerGroups(FillerGroupConfig[] fillerGroups) {
		this.fillerGroups = fillerGroups;
	}
	
	public void setFillerGroups(SchedulerTypes schedulerTypes) {
		List<FillerGroupConfig> list = new ArrayList<>();
		for (FillerGroupConfig groupConf : fillerGroups) {
			if (groupConf.getSchedulerType() == schedulerTypes) {
				list.add(groupConf);
			}
		}
		this.fillerGroups = list.toArray(new FillerGroupConfig[list.size()]);
	}
	
	public void setFillerGroups(FillerGroupTypes groupTypes) {
		List<FillerGroupConfig> list = new ArrayList<>();
		for (FillerGroupConfig groupConf : fillerGroups) {
			if (groupConf.getFillerGroupType() == groupTypes) {
				list.add(groupConf);
			}
		}
		this.fillerGroups = list.toArray(new FillerGroupConfig[list.size()]);
	}
	
}
