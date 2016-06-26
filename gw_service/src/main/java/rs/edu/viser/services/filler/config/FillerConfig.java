package rs.edu.viser.services.filler.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class FillerConfig implements ApplicationContextAware, BeanNameAware {

	private String website;
	private FillerPattern[] fillerPatterns;

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public FillerPattern[] getFillerPatterns() {
		return fillerPatterns;
	}

	public void setFillerPatterns(FillerPattern[] fillerPatterns) {
		this.fillerPatterns = fillerPatterns;
	}

	public void setBeanName(String name) {
		// ?
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// ?
	}

}
