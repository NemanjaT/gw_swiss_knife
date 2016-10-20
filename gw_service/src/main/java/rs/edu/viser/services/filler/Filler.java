package rs.edu.viser.services.filler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import rs.edu.viser.logger.LOG;
import rs.edu.viser.services.filler.config.FillerConfigReader;
import rs.edu.viser.services.filler.config.FillerGroupConfig;
import rs.edu.viser.services.filler.config.FillerObjectPatternConfig;
import rs.edu.viser.services.filler.config.FillerPatternConfig;
import rs.edu.viser.services.filler.groups.FillerFactory;
import rs.edu.viser.services.filler.groups.FillerGroup.FillerGroupTypes;

public class Filler {

	private static LOG logger = new LOG(Filler.class);
	
	public static void main(String[] args) {
		logger.info("Initializing filler.");
		
		/*
		 * Open reading stream
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		/*
		 * Getting all of the possible enum values
		 */
		String[] stringValues = new String[FillerGroupTypes.values().length];
		for (int i = 0; i < stringValues.length; i++) {
			stringValues[i] = FillerGroupTypes.values()[i].toString();
		}
		final String options = String.join(" - ", stringValues);
		final int paddingNum = 72 / 2 - (options.length() / 2);
		final String padding = String.format("%" + paddingNum + "s", "");
		System.out.println("\n"
				+ "********************************************************************************\n"
				+ "    Choose between one of the possible values you wish to run the script for    \n"
				+ "                                                                                \n"
				+ "    " + padding + options + padding + "    \n"
				+ "********************************************************************************\n");
		try {
			/*
			 * Getting the information from the user
			 */
			final String answer = bufferedReader.readLine().toUpperCase();
			
			try {
				process(FillerGroupTypes.valueOf(answer));
			} catch (IllegalArgumentException e) {
				System.out.println("Answer " + answer + " is not recognized");
			}
		} catch (IOException e) {
			logger.error("IO failed.");
			System.err.println(e);
		}
		
		logger.info("Filler finished.");
	}

	private static void process(final FillerGroupTypes type) {
		FillerConfigReader fillerConfigReader = FillerConfigReader.getFillerConfigReader();
		final String website = fillerConfigReader.getWebsite();
		
		/*
		 * Printing out what we've got :-)
		 * Code is separated for easy lookup for me later on. This is a very fast for loop, so no harm done.
		 */
		FillerGroupConfig[] configs = fillerConfigReader.getFillerGroups(type);
		System.out.println("...");
		for (FillerGroupConfig c : configs) {
			System.out.println(c.getFillerGroupType());
			for (FillerPatternConfig d : c.getFillerPatterns()) {
				System.out.print("\t" + 
						(d instanceof FillerObjectPatternConfig ? "FillerObjectPatternConfig" : "FillerArrayPatternConfig"));
				System.out.println(" - " + fillerConfigReader.getWebsite() + c.getUrlSufix() + d.getUrlPattern());
			}
		}
		
		/*
		 * How it all works:
		 * 
		 */
		for (FillerGroupConfig config : configs) {
//			FillerPatternConfig[] patterns = config.getFillerPatterns();
			FillerFactory product = FillerFactory.get(config.getFillerGroupType());
			product.fill();
//			for (FillerPatternConfig pattern : patterns) {
//				String websiteFull = website + config.getUrlSufix() + pattern.getUrlPattern();
//				
//				if ()
//			}
		}
	}

}
