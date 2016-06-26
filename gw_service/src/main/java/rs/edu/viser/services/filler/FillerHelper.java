package rs.edu.viser.services.filler;

import org.json.JSONException;
import org.json.JSONObject;

public class FillerHelper {
	
	public Integer getIntValue(JSONObject object, String key) {
		if (object.has(key)) {
			try {
				return object.getInt(key);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public String getStringValue(JSONObject object, String key) {
		if (object.has(key)) {
			try {
				return object.getString(key);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
}
