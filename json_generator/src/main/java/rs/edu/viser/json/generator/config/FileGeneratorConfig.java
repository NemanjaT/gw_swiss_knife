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
public class FileGeneratorConfig implements ApplicationContextAware, BeanNameAware {

    private String packageFile;
    private String website;
    private FileGeneratorPattern[] fileGeneratorPatternList;

    String getPackageFile() {
        return packageFile;
    }

    public void setPackageFile(String packageFile) {
        this.packageFile = packageFile;
    }

    String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    FileGeneratorPattern[] getFileGeneratorPatternList() {
        return fileGeneratorPatternList;
    }

    public void setFileGeneratorPatternList(FileGeneratorPattern[] fileGeneratorPatternList) {
        this.fileGeneratorPatternList = fileGeneratorPatternList;
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
