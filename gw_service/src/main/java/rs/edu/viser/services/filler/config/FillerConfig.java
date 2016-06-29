package rs.edu.viser.services.filler.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class FillerConfig implements ApplicationContextAware, BeanNameAware {

	private String website;
	private FillerGroupConfig[] fillerGroups;

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public FillerGroupConfig[] getFillerGroups() {
		return fillerGroups;
	}

	public void setFillerGroups(FillerGroupConfig[] fillerGroups) {
		this.fillerGroups = fillerGroups;
	}

	public void setBeanName(String name) {
		// ?
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// ?
	}

}
