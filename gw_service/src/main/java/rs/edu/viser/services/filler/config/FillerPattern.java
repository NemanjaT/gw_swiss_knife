package rs.edu.viser.services.filler.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class FillerPattern implements ApplicationContextAware, BeanNameAware {

	public enum Type {
		OBJECT, ARRAY
	}
	
	private String className;
	private String pattern;
	private Type type;
	
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public Type getType() {
		return type;
	}

	public void setType(String type) {
		this.type = Type.valueOf(type);
	}

	public void setBeanName(String name) {
		// ?
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// ?
	}

}
