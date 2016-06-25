package rs.edu.viser.json.generator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import rs.edu.viser.json.JsonRetriever;
import rs.edu.viser.json.generator.config.FileGeneratorConfigReader;
import rs.edu.viser.json.generator.config.FileGeneratorPattern;
import rs.edu.viser.logger.LOG;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Initializer JSON object to Java class file generation.
 */
public class JSONFileGenerator {
    private LOG log;

    private String url;
    private String jsonName;
    private ClassFileWriter classFileWriter;
    private ClassNamer classNamer;

    private JSONFileGenerator(String url, String jsonName) {
        this.log = new LOG(this.getClass());

        this.url = url;
        this.jsonName = jsonName;

        try {
            //Retrieving the jsonObject
            JSONObject jsonObject = new JsonRetriever().getJsonObject(url);
            generate(jsonObject, jsonName);
        } catch (JSONException | IOException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }

    private JSONFileGenerator(JSONObject object, String jsonName) {
        this.jsonName = jsonName;
        this.log = new LOG(this.getClass());

        generate(object, jsonName);
    }

    /**
     * Initializes generation. . .
     * @param jsonObject
     * @param jsonName
     */
    private void generate(JSONObject jsonObject, String jsonName) {
        //Getting the Java name of the json name passed
        this.classNamer = new ClassNamer();
        String javaName = classNamer.jsonToJava(jsonName, true);

        log.info("Starting to initialize " + javaName);

        //Open a new file and iterate through every JSON element
        try {
            Iterator<?> jsonIterator = jsonObject.keys();
            this.classFileWriter = new ClassFileWriter(javaName, "Generated from: " + url);

            while (jsonIterator.hasNext()) {
                String key = (String) jsonIterator.next();
                Object object = jsonObject.get(key);

                if (object instanceof JSONObject) {
                    generateObject(jsonObject, key);
                } else if (object instanceof JSONArray) {
                    generateArray((JSONArray) object, key);
                } else {
                    generateAttribute(jsonObject, key);
                }

            }

            this.classFileWriter.writeGettersAndSetters();
            this.classFileWriter.finishFile();
        } catch (JSONException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }

        log.info("Finished with " + javaName);
    }

    /**
     * Generates an object and writes it down. . .
     * @param object
     * @param key
     */
    private void generateObject(JSONObject object, String key) {
        try {
            JSONObject innerObject = object.getJSONObject(key);
            String innerJsonName = this.jsonName + "_" + key;

            if (! innerJsonName.equals(this.jsonName + "_")) {
            	new Thread(() -> {
        			new JSONFileGenerator(innerObject, innerJsonName);
        		}).start();
        		
        		String innerJavaName = classNamer.jsonToJava(innerJsonName, true);
                String innerJavaAttribute = classNamer.jsonToJava(innerJsonName, false);

                classFileWriter.writeCustomObject(innerJavaName, innerJavaAttribute);
            } else {
            	log.error("Object has no name!");
            }
        } catch (JSONException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Generates an array and writes it down. . .
     * @param array
     * @param key
     */
    private void generateArray(JSONArray array, String key) {
    	//Gathering info. . .
    	String innerJsonName = this.jsonName + "_" + key;
    	
    	//Check the type of an array. . .
    	char firstChar = array.toString().charAt(1);
    	
    	switch (firstChar) {
    	//If it's an array of objects. . .
    	case '{':
    		JSONObject fullObject = new JsonRetriever().interpretateArray(array);
    		
    		if (! innerJsonName.equals(this.jsonName + "_")) {
    			new Thread(() -> {
    				new JSONFileGenerator(fullObject, innerJsonName);
    			}).start();
    			
    			String innerJavaName = classNamer.jsonToJava(innerJsonName, true);
    	        String innerJavaAttribute = classNamer.jsonToJava(innerJsonName, false);

    	        classFileWriter.writeCustomObject("List<" + innerJavaName + ">", innerJavaAttribute);
    		} else {
    			log.error("Object has no name!");
    		}
    		
    		break;
    		
    	//If it's an array of arrays. . .
    	case '[':
    		//TODO: Array inside array. . . do

    		classFileWriter.writeComment("TODO: GW-0002");
    		
    		break;
    		
    	//If it's a null array. . .
    	case ']':
    		classFileWriter.writeCustomObject("List<Object>", classNamer.jsonToJava(key, false), "TODO: GW-0001");
    		
    		break;
    		
    	//If it's an array of values. . .
		default:
			List<String> list = new ArrayList<>();
			for (int i = 0; i < array.length(); i++) {
				try {
					list.add(array.getString(i));
				} catch (JSONException e) {
					log.error("Not all objects in the array are attributes!");
					e.printStackTrace();
				}
			}
			classFileWriter.writeAttributeArray(classNamer.jsonToJava(key, false), list);
    	}
    }

    /**
     * Generates an attribute and writes it down. . .
     * @param object
     * @param key
     */
    private void generateAttribute(JSONObject object, String key) {
        try {
            String value = object.getString(key);
            String attributeName = classNamer.jsonToJava(key, false);

            classFileWriter.writeAttribute(attributeName, value);
        } catch (JSONException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Main class for Java class generation.
     *
     */
    public static void main(String[] args) {
        LOG log = new LOG(JSONFileGenerator.class);
        log.info("Started successfully!");

        FileGeneratorConfigReader reader = FileGeneratorConfigReader.getReader();

        for (FileGeneratorPattern pattern : reader.getPatterns()) {
            if (pattern.getType() == FileGeneratorPattern.Type.OBJECT) {

                new Thread(() -> {
                    new JSONFileGenerator(reader.getWebsite() + pattern.getUrl(), pattern.getName());
                }).start();
                Thread.yield();

            }
        }
    }

}
