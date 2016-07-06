package rs.edu.viser.services.filler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import rs.edu.viser.services.filler.config.FillerArrayPatternConfig;
import rs.edu.viser.services.filler.config.FillerObjectPatternConfig;
import rs.edu.viser.services.filler.config.FillerPatternConfig;

/**
 * 
 * Used as a simple helper to shorten the code in filler group classes.
 * @author neman
 * 
 */
public class FillerHelper {
	
	/**
	 * Gets an integer parameter if one exists.
	 * @param obj
	 * @param param
	 * @return Integer param or null
	 */
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
	
	/**
	 * Gets a double parameter if one exists.
	 * @param obj
	 * @param param
	 * @return Double param or null
	 */
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
	
	/**
	 * Gets a boolean parameter if one exists.
	 * @param obj
	 * @param param
	 * @return Boolean param or null
	 */
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
	
	/**
	 * Gets a string parameter if one exists.
	 * @param obj
	 * @param param
	 * @return String param or null
	 */
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
	
	/**
	 * Returns a list of integers from parameter if one exists
	 * @param obj
	 * @param param
	 * @return an ArrayList of Integers (never null)
	 */
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
	
	/**
	 * Returns a list of doubles from parameter if one exists
	 * @param obj
	 * @param param
	 * @return an ArrayList of Doubles (never null)
	 */
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
	
	/**
	 * Returns a list of booleans from parameter if one exits
	 * @param obj
	 * @param param
	 * @return an ArrayList of Booleans (never null)
	 */
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
	
	/**
	 * Returns a list of strings from a parameter is one exists
	 * @param obj
	 * @param param
	 * @return an ArrayList of Strings (never null)
	 */
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
	
	/**
	 * Orders the filler pattern config objects by their instance, so arrays are listen first,
	 * then objects.<br/>
	 * ie.
	 * <ol>
	 * <li>FillerArrayPatternConfig f1</li>
	 * <li>FillerObjectPatternConfig f2</li>
	 * <li>FillerArrayPatternConfig f3</li>
	 * </ol>
	 * to:
	 * <ol>
	 * <li>FillerArrayPatternConfig f1</li>
	 * <li>FillerArrayPatternConfig f3</li>
	 * <li>FillerObjectPatternConfig f2</li>
	 * </ol>
	 * @param fillers
	 * @return an ordered array of fillers.
	 */
	public FillerPatternConfig[] orderFillerPatternConfigs(FillerPatternConfig[] fillers) {
		List<FillerPatternConfig> list = Arrays.asList(fillers);
		
		list = list.stream()
			.sorted((n, m) -> {
				System.out.println("Sorting " + n + " and " + m);
				return n instanceof FillerObjectPatternConfig ? 1 : -1;
			}).collect(Collectors.toList());
		
		return list.toArray(new FillerPatternConfig[list.size()]);
	}
}
