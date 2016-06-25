package rs.edu.viser.json;

import org.json.JSONException;
import org.json.JSONObject;
import rs.edu.viser.logger.LOG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by neman on 22-Jun-16.
 *
 * Used to retrieve JSON from a URL/URI
 */
public class JsonRetriever {

    public JSONObject getJsonObject(String url) throws JSONException, IOException {
        LOG log = new LOG(this.getClass());

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

}
