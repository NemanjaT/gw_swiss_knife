package rs.edu.viser.services.filler;

import java.io.IOException;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import rs.edu.viser.json.models.WvwMatch;

public class Filler {
	
	public static void main(String[] args) {
		final long startTime = System.nanoTime();
		ObjectMapper mapper = new ObjectMapper();
		mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
		
		try {
			WvwMatch match = mapper.readValue(new URL("https://api.guildwars2.com/v2/wvw/matches/2-6"), WvwMatch.class);
			System.out.println(match);
		} catch (IOException e) {
			e.printStackTrace();
		}
		final long duration = System.nanoTime() - startTime;
		System.out.println(duration / 1000000000.);
	}

}
