package rs.edu.viser.services.filler;

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
		for (FillerGroup fgc : ff.fillerGroups(FillerGroupTypes.CHARACTER).getFillerGroup()) {
			fgc.setAccessToken("79D451B9-26E6-6943-BDA6-AC9D05EE563DA640C336-0F50-4875-8350-23E6C642A0F1");
			fgc.getModels(SchedulerTypes.ALL);
		}
	}

}
