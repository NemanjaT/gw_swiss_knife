package rs.edu.viser.services.filler.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

/**
 * Preconfigured ObjectMapper (com.fastexml.jackson.databind.ObjectMapper)
 * @author nemanja.tozic
 * 
 */
public class JacksonModeler extends ObjectMapper {
	
	public JacksonModeler() {
		super();
		this.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
	}
	
}
