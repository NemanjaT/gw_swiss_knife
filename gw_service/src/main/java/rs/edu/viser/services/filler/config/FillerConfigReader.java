package rs.edu.viser.services.filler.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Reads through the fillerConfig xml configuration file and returns the results.
 * @author neman
 *
 */
public class FillerConfigReader {
	
	private static FillerConfigReader instance;
	
	private String website;
	private FillerPattern[] fillerPatterns;
	
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
		ApplicationContext context = new ClassPathXmlApplicationContext("fillerConfig.xml");
		FillerConfig filler = (FillerConfig) context.getBean("fillerConfig");
		
		//Setting the data
		this.website = filler.getWebsite();
		this.fillerPatterns = filler.getFillerPatterns();
		
		//Closing the context
        ((ConfigurableApplicationContext) context).close();
	}

	/**
	 * Returns the website from the config file
	 * @return
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * Returns the filler pattern list from the config file
	 * @return
	 */
	public FillerPattern[] getFillerPatterns() {
		return fillerPatterns;
	}
	
	/**
	 * Returns all the names from the filler pattern
	 * @return
	 */
	public List<String> getFillerPatternClassNames() {
		List<String> res = new ArrayList<>();
		for (FillerPattern fp : fillerPatterns) {
			res.add(fp.getClassName());
		}
		return res;
	}
	
}
