package rs.edu.viser.services.filler.groups;

import java.util.Arrays;

import rs.edu.viser.json.JsonRetriever;
import rs.edu.viser.services.filler.FillerHelper;
import rs.edu.viser.services.filler.config.FillerArrayPatternConfig;
import rs.edu.viser.services.filler.config.FillerObjectPatternConfig;
import rs.edu.viser.services.filler.config.FillerPatternConfig;

public abstract class FillerGroup {
	
	public enum FillerGroupTypes {
		ALL, ACCOUNT, ACHIEVEMENT, CHARACTER, COMMERCE, DECORATIVE, ITEM, PVP, SYSTEM, WORLD, WVW
	}
	
	public enum SchedulerTypes {
		ALL, DAILY, CONTINUOUS, REQUESTED
	}

	protected String accessToken;
	protected FillerHelper helper;
	protected JsonRetriever retriever;
	
	/**
	 * Fetches the models from the URL provided... Uses the access token 
	 * (from <code>setAccessToken()</code>) if needed.
	 */
	public abstract void getModels(SchedulerTypes type);
	
	/**
	 * Sets the access token for the url.
	 * @param accessToken
	 */
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
	/**
	 * Goes through the array of patterns, checks if the scheduler type is OK and calls the
	 * right filter method (filterObjects or filterArrays).
	 * @param patternGroup
	 * @param schedulerType
	 */
	protected void readThroughPatterns(FillerPatternConfig[] patternGroup, SchedulerTypes schedulerType) {
		/*
		 * 1. takes the array, transforming it into a stream and maps it.
		 * 2. Looks up if the scheduler type parameter is equal to the object scheduler type,
		 *    or if the parameter is ALL and if the object is either Object or Array.
		 * 3. Depending on the type invokes the corresponding method.
		 */
		Arrays.asList(patternGroup)
				.stream()
				.forEach(pattern -> {
					if (pattern.getSchedulerType() == schedulerType 
							|| schedulerType == SchedulerTypes.ALL) {
						if (pattern instanceof FillerObjectPatternConfig) {
							filterObjects((FillerObjectPatternConfig) pattern);
						} else if (pattern instanceof FillerArrayPatternConfig) {
							filterArrays((FillerArrayPatternConfig) pattern);
						}
					}
				});
//				.map(pattern -> 
//						((schedulerType == pattern.getSchedulerType() 
//						|| schedulerType == SchedulerTypes.ALL)
//						&& pattern instanceof FillerObjectPatternConfig)
//						? filterObjects((FillerObjectPatternConfig) pattern)
//							: ((schedulerType == pattern.getSchedulerType()
//								|| schedulerType == SchedulerTypes.ALL)
//								&& pattern instanceof FillerObjectPatternConfig)
//								? filterArrays((FillerArrayPatternConfig) pattern)
//								: null);
	}
	
	/**
	 * Finds the appropriate object (by instanceof) and fills in the appropriate data.
	 * @param pattern
	 * @return Should return 'this' object to correspond with map stream.
	 */
	protected abstract Object filterObjects(FillerObjectPatternConfig pattern);
	/**
	 * Finds the appropriate array (by propertyName property) and fills in the appropriate data.
	 * @param pattern
	 * @return Should return 'this' object to correspond with map stream.
	 */
	protected abstract Object filterArrays(FillerArrayPatternConfig pattern);
	
}
