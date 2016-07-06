package rs.edu.viser.services.filler;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import rs.edu.viser.json.models.WvwMatch;
import rs.edu.viser.services.filler.config.FillerArrayPatternConfig;
import rs.edu.viser.services.filler.config.FillerGroupConfig;
import rs.edu.viser.services.filler.config.FillerObjectPatternConfig;
import rs.edu.viser.services.filler.config.FillerPatternConfig;
import rs.edu.viser.services.filler.groups.FillerGroup;
import rs.edu.viser.services.filler.groups.FillerGroup.FillerGroupTypes;
import rs.edu.viser.services.filler.groups.FillerGroup.SchedulerTypes;

public class Filler {
	
	public static void main(String[] args) {
//		System.out.println("GO!");
//		final long startTime = System.nanoTime();
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
//		
//		try {
//			WvwMatch match = mapper.readValue(new URL("https://api.guildwars2.com/v2/wvw/matches/2-6"), WvwMatch.class);
//			System.out.println(match);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		final long duration = System.nanoTime() - startTime;
//		System.out.println(duration / 1000000000.);
		
		FillerFactory ff = new FillerFactory();
		for (FillerGroup fgc : ff.fillerGroups(FillerGroupTypes.ACCOUNT).getFillerGroup()) {
			fgc.setAccessToken("79D451B9-26E6-6943-BDA6-AC9D05EE563DA640C336-0F50-4875-8350-23E6C642A0F1");
			fgc.getModels(SchedulerTypes.ALL);
		}
	}

}
