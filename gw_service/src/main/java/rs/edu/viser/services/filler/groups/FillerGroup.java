package rs.edu.viser.services.filler.groups;

import rs.edu.viser.json.JsonRetriever;
import rs.edu.viser.services.filler.FillerHelper;

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
	
}
