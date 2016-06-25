package rs.edu.viser.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import rs.edu.viser.logger.LOG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

/**
 * Created by neman on 22-Jun-16.
 *
 * Used to retrieve JSON from a URL/URI
 */
public class JsonRetriever {
	
	private LOG log;
	
	public JsonRetriever() {
		this.log = new LOG(this.getClass());
	}

	/**
	 * Visits the provided url and returns a JSON object from it
	 * @param url
	 * @return JSONObject
	 * @throws JSONException
	 * @throws IOException
	 */
    public JSONObject getJsonObject(String url) throws JSONException, IOException {
    	
    	//If it's not a http url, returns null
        if (!url.contains("http")) {
            log.error("The URL must contain 'http'!");
            return null;
        }

        BufferedReader bufferedReader = null;

        try {
            log.info("Retrieving the object from a URL (" + url + ")");
            URL urlLink = new URL(url);
            bufferedReader = new BufferedReader(new InputStreamReader(urlLink.openStream()));
            StringBuilder stringBuffer = new StringBuilder();
            log.info("Filling up a JSONObject (" + url + ")");
            int read;
            char[] chars = new char[1024];
            while((read = bufferedReader.read(chars)) != -1) {
                stringBuffer.append(chars, 0, read);
            }
            return new JSONObject(stringBuffer.toString());
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e) {
                    log.error(e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }
    
    /**
     * Visits a provided url and returns a JSON array from it.
     * @param url
     * @return
     * @throws IOException
     * @throws JSONException
     */
    public JSONArray getJsonArray(String url) throws IOException, JSONException {
    	
    	//If it's not a http url, return null
    	if (! url.contains("http")) {
    		log.error("The URL must contain 'http'!");
    		return null;
    	}
    	
    	BufferedReader bufferedReader = null;

        try {
            log.info("Retrieving the object from a URL (" + url + ")");
            URL urlLink = new URL(url);
            bufferedReader = new BufferedReader(new InputStreamReader(urlLink.openStream()));
            StringBuilder stringBuffer = new StringBuilder();
            log.info("Filling up a JSONObject (" + url + ")");
            int read;
            char[] chars = new char[1024];
            while((read = bufferedReader.read(chars)) != -1) {
                stringBuffer.append(chars, 0, read);
            }
            return new JSONArray(stringBuffer.toString());
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e) {
                    log.error(e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Takes an array of JSON objects and returns a full object (an object that contains all of the
     * attributes that are found in all of the objects in the array).
     * @param array
     * @return JSONObject
     */
	public JSONObject interpretateArray(JSONArray array) {
		JSONObject object = new JSONObject();
		
		//Iterate through all of the objects. . .
		for (int i = 0; i < array.length(); i++) {
			try {
				JSONObject inner = array.getJSONObject(i);
				
				/*
				 * Iterate through all of the values and add the attribute to 'object'
				 * if it isn't added already. . .
				 */
				Iterator<?> iterator = inner.keys();
				while (iterator.hasNext()) {
					String key = (String) iterator.next();
					
					if (! object.has(key)) {
						object.put(key, inner.get(key));
					}
				}
			} catch (JSONException e) {
				log.error("Some value inside the array is not an object!");
				e.printStackTrace();
			}
		}
		
		return object;
	}

}
