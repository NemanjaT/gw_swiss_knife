package rs.edu.viser.services.filler.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import rs.edu.viser.services.filler.groups.FillerGroup.SchedulerTypes;

public abstract class FillerPatternConfig implements ApplicationContextAware, BeanNameAware {
	
	private String urlPattern;
	private SchedulerTypes schedulerType;
	
	public String getUrlPattern() {
		return this.urlPattern;
	}
	
	public void setUrlPattern(String urlPattern) {
		this.urlPattern = urlPattern;
	}

	public SchedulerTypes getSchedulerType() {
		return schedulerType;
	}

	public void setSchedulerType(String schedulerType) {
		this.schedulerType = SchedulerTypes.valueOf(schedulerType);
	}

	@Override
	public void setBeanName(String name) {
		// ?
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// ?
	}

}
