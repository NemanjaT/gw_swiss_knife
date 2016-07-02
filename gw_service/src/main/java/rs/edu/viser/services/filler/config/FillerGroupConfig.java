package rs.edu.viser.services.filler.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import rs.edu.viser.services.filler.groups.FillerGroup.FillerGroupTypes;
import rs.edu.viser.services.filler.groups.FillerGroup.SchedulerTypes;

public class FillerGroupConfig implements ApplicationContextAware, BeanNameAware {
	
	private FillerGroupTypes fillerGroupType;
	private SchedulerTypes schedulerType;
	private String urlSufix;
	private FillerPatternConfig[] fillerPatterns;

	public FillerGroupTypes getFillerGroupType() {
		return fillerGroupType;
	}

	public void setFillerGroupType(FillerGroupTypes fillerGroupType) {
		this.fillerGroupType = fillerGroupType;
	}

	public SchedulerTypes getSchedulerType() {
		return schedulerType;
	}

	public void setSchedulerType(SchedulerTypes schedulerType) {
		this.schedulerType = schedulerType;
	}

	public String getUrlSufix() {
		return urlSufix;
	}

	public void setUrlSufix(String urlSufix) {
		this.urlSufix = urlSufix;
	}

	public FillerPatternConfig[] getFillerPatterns() {
		return fillerPatterns;
	}

	public void setFillerPatterns(FillerPatternConfig[] fillerPatterns) {
		this.fillerPatterns = fillerPatterns;
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
