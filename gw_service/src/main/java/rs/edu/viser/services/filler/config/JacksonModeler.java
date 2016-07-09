package rs.edu.viser.services.filler.config;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

/**
 * Preconfigured ObjectMapper (com.fastexml.jackson.databind.ObjectMapper)
 * @author nemanja.tozic
 * 
 */
public class JacksonModeler extends ObjectMapper {
	
	/**
	 * Generated Serial Version UID
	 */
	private static final long serialVersionUID = 5483307002054409347L;

	public JacksonModeler() {
		super();
		
		this.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
		this.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
	}
	
}
