package rs.edu.viser.services.filler;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import rs.edu.viser.json.models.WvwMatch;
import rs.edu.viser.services.filler.config.FillerArrayPatternConfig;
import rs.edu.viser.services.filler.config.FillerObjectPatternConfig;
import rs.edu.viser.services.filler.config.FillerPatternConfig;

public class Filler {
	
	public static void main(String[] args) {
		System.out.println("GO!");
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
		
		List<FillerPatternConfig> list = new ArrayList<>();
		list.add(new FillerArrayPatternConfig());
		list.add(new FillerObjectPatternConfig());
		list.add(new FillerArrayPatternConfig());
		list.add(new FillerArrayPatternConfig());
		list.add(new FillerObjectPatternConfig());
		list.add(new FillerArrayPatternConfig());
		FillerPatternConfig[] arr = new FillerHelper().orderFillerPatternConfigs(list.toArray(new FillerPatternConfig[list.size()]));
		for (FillerPatternConfig g : arr) {
			System.out.println(g);
		}
	}

}
