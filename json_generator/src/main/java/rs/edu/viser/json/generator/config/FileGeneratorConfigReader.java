package rs.edu.viser.json.generator.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by neman on 22-Jun-16.
 *
 * Reads through the fileGeneratorConfig.xml file and outputs the results just like any POJO.
 */
public class FileGeneratorConfigReader {

    private static FileGeneratorConfigReader fileGeneratorConfigReader;

    private String website;
    private String packageFile;
    private FileGeneratorPattern[] patterns;

    /**
     * Creates a singleton object if it doesn't exist related to reading config file and returns it.
     * @return FileGeneratorConfigReader singleton object
     */
    public static FileGeneratorConfigReader getReader() {
        if (fileGeneratorConfigReader == null) {
            fileGeneratorConfigReader = new FileGeneratorConfigReader();
        }
        return fileGeneratorConfigReader;
    }

    private FileGeneratorConfigReader() {
        //Open file context and read bean
        ApplicationContext context = new ClassPathXmlApplicationContext("fileGeneratorConfig.xml");
        FileGeneratorConfig fileGenConf = (FileGeneratorConfig) context.getBean("fileGeneratorConfig");

        //Setting the data
        this.website = fileGenConf.getWebsite();
        this.packageFile = fileGenConf.getPackageFile();
        this.patterns = fileGenConf.getFileGeneratorPatternList();
        
        //Closing the context
        ((ConfigurableApplicationContext) context).close();
    }

    /**
     * Return the name of the website (eg. http://mywebsite.com/)
     * @return website
     */
    public String getWebsite() {
        return website;
    }

    /**
     * Return the package file in which the classes will be generated (eg. com.path.to.my.package)
     * @return package name
     */
    public String getPackageFile() {
        return packageFile;
    }

    /**
     * Return the list of URL patterns.
     * @return URL patterns
     */
    public FileGeneratorPattern[] getPatterns() {
        return patterns;
    }

    /**
     * Return all the names from the URL pattern list.
     * @return URL pattern names
     */
    public List<String> getPatternNames() {
        List<String> names = new ArrayList<>();
        for (FileGeneratorPattern pattern : patterns) {
            names.add(pattern.getName());
        }
        return names;
    }

    /**
     * Return all the URLs from the URL pattern list.
     * @return URLs from pattern list
     */
    public List<String> getPatternURLs() {
        List<String> urls = new ArrayList<>();
        for (FileGeneratorPattern pattern : patterns) {
            urls.add(pattern.getUrl());
        }
        return urls;
    }

    /**
     * Returns all the types from the URL pattern list
     * @return types from pattern list
     */
    public List<String> getPatternTypes() {
        List<String> urls = new ArrayList<>();
        for (FileGeneratorPattern pattern : patterns) {
            urls.add(String.valueOf(pattern.getType()));
        }
        return urls;
    }
}
