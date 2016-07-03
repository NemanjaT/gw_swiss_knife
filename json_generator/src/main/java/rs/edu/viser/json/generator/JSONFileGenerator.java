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
                String innerJavaAttribute = classNamer.jsonToJava(key, false);

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
    	        String innerJavaAttribute = classNamer.jsonToJava(key, false);

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
     * Generates an array class.
     */
    public static void generateArrayClass() {
    	FileGeneratorConfigReader reader = FileGeneratorConfigReader.getReader();
    	JsonRetriever retriever = new JsonRetriever();
    	ClassNamer namer = new ClassNamer();
    	LOG log = new LOG(JSONFileGenerator.class);
    	
    	log.info("Initializing generation of the array class.");
    	ClassFileWriter fileWriter = new ClassFileWriter(reader.getArrayClassName(), 
    			"Array class containing all arrays from the config file.");
    	try {
    		//For every array in the pattern add it to the generated class (as a list).
	    	for (FileGeneratorPattern pattern : reader.getPatterns()) {
	    		if (pattern.getType() == FileGeneratorPattern.Type.ARRAY) {
	    			log.info("Generating information for the " + pattern.getName() + " array. . . - " 
	    					+ reader.getWebsite() + pattern.getUrl());
	    			
	    			JSONArray array = retriever.getJsonArray(reader.getWebsite() + pattern.getUrl());
	    			
	    			//Check if it's an array of values, objects, arrays or null.
	    			char firstCharOfArray = array.toString().charAt(1);
	    			switch (firstCharOfArray) {
	    			//If it's an array of objects. . .
	    			case '{':
	    				//Take the object, generate the java file for it and write it down. . .
	    				JSONObject object = retriever.interpretateArray(array);
	    				new JSONFileGenerator(object, pattern.getName());
	    				fileWriter.writeCustomObject("List<" + namer.jsonToJava(pattern.getName(), true) + ">", 
	    						namer.jsonToJava(pattern.getName(), false));
	    				
	    				break;
	    			//If it's a null array. . .
		    		case ']':
		    			fileWriter.writeCustomObject("List<Object>", 
		    					namer.jsonToJava(pattern.getName(), false), "TODO: GW-0003");
		    			//TODO: Array inside array. . . do
	    				break;
	    			//If it's an array of arrays. . .
	    			case '[':
	    				fileWriter.writeComment("TODO: GW-0004");
	    				break;
	    			//If it's an array of values. . .
	    			default:
	    				boolean isInt, isBool, isDouble;
	    				isInt = isDouble = isBool = true;
	    				String type = "List<";
	    				//Loop through a maximum of 100 elements (to reduce work time)
	    				for (int i = 0; i < (array.length() > 100 ? 100 : array.length()); i++) {
	    					if (! array.get(i).toString().matches(fileWriter.getRegex(true))) isInt = false;
	    					if (! array.get(i).toString().matches(fileWriter.getRegex(false))) isDouble = false;
	    					if (! array.get(i).toString().equals("true") 
	    							&& ! array.get(i).toString().equals("false")) isBool = false;
	    				}
	    				type += isInt ? "Integer" : isDouble ? "Double" : isBool ? "Boolean" : "String";
	    				
	    				fileWriter.writeCustomObject(type + ">", namer.jsonToJava(pattern.getName(), false));
	    			}
	    		}
	    	}
    	} catch (JSONException | IOException e) {
    		log.error(e.getMessage());
    		e.printStackTrace();
    	}
    	
    	fileWriter.writeGettersAndSetters();
    	fileWriter.finishFile();
    }

    /**
     * Main class for Java class generation.
     *
     */
    public static void main(String[] args) {
        LOG log = new LOG(JSONFileGenerator.class);
        log.info("Started successfully!");

        FileGeneratorConfigReader reader = FileGeneratorConfigReader.getReader();

        //Generate model classes
        for (FileGeneratorPattern pattern : reader.getPatterns()) {
            if (pattern.getType() == FileGeneratorPattern.Type.OBJECT) {

                new Thread(() -> {
                    new JSONFileGenerator(reader.getWebsite() + pattern.getUrl(), pattern.getName());
                }).start();
                Thread.yield();

            }
        }
        
        //Generate array class
        JSONFileGenerator.generateArrayClass();
    }

}
