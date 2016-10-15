package rs.edu.viser.json.generator.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import rs.edu.viser.logger.LOG;

/**
 * Created by neman on 21-Jun-16.
 *
 */
public class FileGeneratorPattern implements ApplicationContextAware, BeanNameAware {

    public enum Type {
        OBJECT, ARRAY
    }

    private String url;
    private String name;
    private Type type;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(String type) {
        this.type = Type.valueOf(type);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        LOG log = new LOG(this.getClass());
        log.info("Initializing application context.");
    }

    @Override
    public void setBeanName(String name) {
        LOG log = new LOG(this.getClass());
        log.info("Initializing bean name.");
    }
}
