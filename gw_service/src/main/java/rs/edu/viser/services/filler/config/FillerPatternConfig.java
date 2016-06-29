package rs.edu.viser.services.filler.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public abstract class FillerPatternConfig implements ApplicationContextAware, BeanNameAware {
	
	private String urlPattern;
	
	public String getUrlPattern() {
		return this.urlPattern;
	}
	
	public void setUrlPattern(String urlPattern) {
		this.urlPattern = urlPattern;
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
