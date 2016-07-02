package rs.edu.viser.services.filler;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Used as a simple helper to shorten the code in filler group classes.
 * @author neman
 *
 */
public class FillerHelper {
	
	//Let's shorten it up... :)

	public Integer getIntParam(JSONObject obj, String param) {
		if (obj.has(param)) {
			try {
				return obj.getInt(param);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public Double getDoubleParam(JSONObject obj, String param) {
		if (obj.has(param)) {
			try {
				return obj.getDouble(param);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public Boolean getBoolParam(JSONObject obj, String param) {
		if (obj.has(param)) {
			try {
				return obj.getBoolean(param);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public String getStringParam(JSONObject obj, String param) {
		if (obj.has(param)) {
			try {
				return obj.getString(param);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public List<Integer> getIntList(JSONObject obj, String param) {
		List<Integer> list = new ArrayList<>();
		if (obj.has(param)) {
			JSONArray arr;
			try {
				arr = obj.getJSONArray(param);
				for (int i = 0; i < arr.length(); i++) {
					list.add(arr.getInt(i));
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public List<Double> getDoubleList(JSONObject obj, String param) {
		List<Double> list = new ArrayList<>();
		if (obj.has(param)) {
			JSONArray arr;
			try {
				arr = obj.getJSONArray(param);
				for (int i = 0; i < arr.length(); i++) {
					list.add(arr.getDouble(i));
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public List<Boolean> getBoolList(JSONObject obj, String param) {
		List<Boolean> list = new ArrayList<>();
		if (obj.has(param)) {
			JSONArray arr;
			try {
				arr = obj.getJSONArray(param);
				for (int i = 0; i < arr.length(); i++) {
					list.add(arr.getBoolean(i));
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public List<String> getStringList(JSONObject obj, String param) {
		List<String> list = new ArrayList<>();
		if (obj.has(param)) {
			JSONArray arr;
			try {
				arr = obj.getJSONArray(param);
				for (int i = 0; i < arr.length(); i++) {
					list.add(arr.getString(i));
				}
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
		}
		return list;
	}
}
