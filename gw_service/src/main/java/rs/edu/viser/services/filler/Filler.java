package rs.edu.viser.services.filler;

import rs.edu.viser.services.filler.config.FillerArrayPatternConfig;
import rs.edu.viser.services.filler.config.FillerConfigReader;
import rs.edu.viser.services.filler.config.FillerObjectPatternConfig;
import rs.edu.viser.services.filler.groups.FillerGroup;
import rs.edu.viser.services.filler.groups.FillerGroup.FillerGroupTypes;
import rs.edu.viser.services.filler.groups.FillerGroup.SchedulerTypes;

public class Filler {
	
	public static void main(String[] args) {
//		FillerConfigReader reader = FillerConfigReader.getFillerConfigReader();
//		System.out.println(reader.getWebsite());
//		for (int i = 0; i < reader.getFillerGroups().length; i++) {
//			System.out.println("\t" + reader.getFillerGroups()[i].getUrlSufix());
//			System.out.println("\t" + reader.getFillerGroups()[i].getFillerGroupType());
//			System.out.println("\t" + reader.getFillerGroups()[i].getSchedulerType());
//			for (int j = 0; j < reader.getFillerGroups()[i].getFillerPatterns().length; j++) {
//				System.out.println("\t\t" + reader.getFillerGroups()[i].getFillerPatterns()[j].getUrlPattern());
//				System.out.println("\t\tfull url: " + reader.getWebsite() + reader.getFillerGroups()[i].getUrlSufix() + reader.getFillerGroups()[i].getFillerPatterns()[j].getUrlPattern());
//				if (reader.getFillerGroups()[i].getFillerPatterns()[j] instanceof FillerObjectPatternConfig) {
//					FillerObjectPatternConfig obj = 
//							(FillerObjectPatternConfig)reader.getFillerGroups()[i].getFillerPatterns()[j];
//					System.out.println("\t\t" + obj.getObject());
//				} else if (reader.getFillerGroups()[i].getFillerPatterns()[j] instanceof FillerArrayPatternConfig) {
//					FillerArrayPatternConfig obj = 
//							(FillerArrayPatternConfig)reader.getFillerGroups()[i].getFillerPatterns()[j];
//					System.out.println("\t\t" + obj.getPropertyName());
//				}
//				System.out.println();
//			}
//			System.out.println();
//		}
//		
//		System.out.println("-----");
		
		FillerFactory ff = new FillerFactory().scheduler(SchedulerTypes.ALL).fillerGroups(FillerGroupTypes.ALL);
		for (FillerGroup fg : ff.getFillerGroup()) {
			fg.setAccessToken("79D451B9-26E6-6943-BDA6-AC9D05EE563DA640C336-0F50-4875-8350-23E6C642A0F1");
			fg.getModels(SchedulerTypes.ALL);
			System.out.println(fg);
		}
	}

}
