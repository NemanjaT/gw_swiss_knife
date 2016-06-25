package rs.edu.viser.json.generator;

import rs.edu.viser.json.generator.config.FileGeneratorConfigReader;
import rs.edu.viser.logger.LOG;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by neman on 21-Jun-16.
 *
 * Writes a Java class file.
 */
public class ClassFileWriter {
	public class Attribute {
		private String name;
		private String type;
		
		public Attribute(String name, String type) {
			this.name = name;
			this.type = type;
		}
		public String getName() {
			return name;
		}
		public String getType() {
			return type;
		}
		public String getNameGetter() {
			return "get" + name.substring(0, 1).toUpperCase() + name.substring(1);
		}
		public String getNameSetter() {
			return "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
		}
	}

    private LOG log;

    private BufferedWriter fileWriter;
    private String className;
    private String fullPath;
    private List<Attribute> attributes;

    private String regexInt = "^-?\\d+$";
    private String regexDouble = "^-?\\d+\\.?\\d*$";

    /**
     * Starts a Java file and loads all the needed components.
     */
    ClassFileWriter(String className, String... comments) {
        log = new LOG(this.getClass());
        log.info("Initializing a class file.");

        //Load components.
        FileGeneratorConfigReader reader = FileGeneratorConfigReader.getReader();
        this.className = className;
        this.attributes = new ArrayList<>();

        try {
            //Search for file and warn the user if an existing one is going to be overridden.
            this.fullPath = "src/main/java/" + reader.getPackageFile().replace('.', '/') + "/" + className + ".java";
            File file = new File(fullPath);
            log.info("Writing file in " + fullPath);
            if (file.exists()) {
                log.warning("File already exists and will be overriden.");
            } else {
                log.info("Initializing a new file type: " + reader.getPackageFile() + "." + className);
            }

            //Write initial stuff in the database (class definition, documentation comment, imports, package)
            this.fileWriter = new BufferedWriter(new FileWriter(file));
            fileWriter.write(
                    "package " + reader.getPackageFile() + ";\n\n" +
                    "import java.util.List;\n" +
                    "import java.util.ArrayList;\n\n" +
                    "import rs.edu.viser.json.JsonModelFactoryMaster;\n\n" +
                    "/**\n" +
                    " * Class generated by " + this.getClass().getName() + "\n"
            );
            for (String comment : comments) {
                fileWriter.write(" * " + comment + "\n");
            }
            fileWriter.write(
                    " */\n" +
                    "public class " + className + " extends JsonModelFactoryMaster {\n\n"
            );
            log.info("Opened class definition for " + className);

            closeFile(null);
        } catch (IOException e) {
            closeFile(e);
        }
    }

    void writeCustomObject(String className, String objectName, String... comments) {
        openFile();
        String comment = "";
        if (comments.length > 0) {
        	comment += " //";
        	for (String comm : comments) {
        		comment += comm + " ";
        	}
        }
        try {
            fileWriter.write("\tprivate " + className + " " + objectName + ";" + comment + "\n\n");
            log.info("Created object attribute " + objectName + " of type " + className + " for class " + this.className);

            attributes.add(new Attribute(objectName, className));
            closeFile(null);
        } catch (IOException e) {
            closeFile(e);
        }
    }

    /**
     * Creates one of four attribute types - Integer, Double, Boolean or String
     * @param attributeName attribute name
     * @param value attribute value
     */
    void writeAttribute(String attributeName, String value) {
        openFile();
        try {
            String type;

            if (value.matches(regexInt)) {
                type = "Integer";
            } else if (value.matches(regexDouble)) {
                type = "Double";
            } else if (value.equals("false") || value.equals("true")) {
                type = "Boolean";
            } else {
                type = "String";
            }

            fileWriter.write("\tprivate " + type + " " + attributeName + ";\n\n");
            log.info("Created attribute " + attributeName + " for a class " + className + "!");

            attributes.add(new Attribute(attributeName, type));
            closeFile(null);
        } catch (IOException e) {
            closeFile(e);
        }
    }
    
    /**
     * Reads through all of the values, finds of of the following type - String, Integer, Double, Boolean
     * and writes it down on the file.
     * @param attributeName
     * @param attributeValues
     */
    void writeAttributeArray(String attributeName, List<String> attributeValues) {
    	openFile();
    	try {
	    	boolean isInt, isDouble, isBool;
	    	isInt = isDouble = isBool = true;
	    	
	    	String type = "List<";
	    	
	    	for (String attValue : attributeValues) {
	    		if (! attValue.matches(regexInt)) {
	    			isInt = false;
	    		}
	    		if (! attValue.matches(regexDouble)) {
	    			isDouble = false;
	    		}
	    		if (! attValue.equals("false") && ! attValue.equals("true")) {
	    			isBool = false;
	    		}
	    	}
	    	
	    	if (isInt) {
	    		type += "Integer>";
	    	} else if (isDouble) {
	    		type += "Double>";
	    	} else if (isBool) {
	    		type += "Boolean>";
	    	} else {
	    		type += "String>";
	    	}
	    	//TODO: if if if if if if if if if if . . . there has to be a better way . . .
	    	
	    	fileWriter.write("\tprivate " + type + " " + attributeName + ";\n\n");
	    	log.info("Created list " + type + " to class " + className + " successfully!");
	    	
	    	attributes.add(new Attribute(attributeName, type));
	    	closeFile(null);
    	} catch (IOException e) {
    		closeFile(e);
    	}
    }
    
    /**
     * Writes custom string comment. If it's one line it's a // comment, if it's more than one line, it's
     * a /* comment
     */
    void writeComment(String... string) {
    	openFile();
    	try {
    		if (string.length > 0) {
    			if (string.length == 1) {
    				fileWriter.write("\t//" + string[0] + "\n\n");
    			} else {
    				fileWriter.write("\t/*\n");
    				for (String str : string) {
    					fileWriter.write(" * " + str + "\n");
    				}
    				fileWriter.write("\t */\n\n");
    			}
    		}
    		
			closeFile(null);
		} catch (IOException e) {
			closeFile(e);
		}
    }
    
    /**
     * Write getters and setters. . .
     */
    void writeGettersAndSetters() {
    	writeComment("Getters and setters");
    	
    	openFile();
    	try {
    		log.info("Initializing getters and setters for " + className);
    		
    		for (Attribute attribute : attributes) {
    			log.info("Writing getter and setter for attribute " + attribute.getName() + " (" + className +")");
    			
    			fileWriter.write(
    					"\tpublic " + attribute.getType() + " " + attribute.getNameGetter() + "() {\n" +
    					"\t\treturn this." + attribute.getName() + ";\n" +
    					"\t}\n\n" +
    					"\tpublic void " + attribute.getNameSetter() + "(" + attribute.getType() + " val) {\n" +
    					"\t\tthis." + attribute.getName() + " = val;\n" +
    					"\t}\n\n"
    			);
    		}
    		
    		closeFile(null);
    	} catch (IOException e) {
    		closeFile(e);
    	}
    }

    /**
     * Finishes the file and closes the file writer.
     */
    void finishFile() {
        //Finish and close the file
        openFile();
        try {
        	//write a constructor to initialize all arraylist's. . .
        	fileWriter.write("\tpublic " + className + "() {\n");
        	
        	log.info("Initializing constructor for " + className);
        	for (Attribute attribute : attributes) {
        		if (attribute.getType().contains("List<")) {
        			fileWriter.write(
        					"\t\tthis." + attribute.getName() + " = new " +
        					attribute.getType().replace("List<", "ArrayList<").replace(">", ">()") + ";\n"
        			);
        		}
        	}
        	
        	//close the constructor and the file
            fileWriter.write("\t}\n\n}\n");
            log.info("Class file " + className + " successfully closed.");

            closeFile(null);
        } catch (IOException e) {
            closeFile(e);
        }
    }
    
    private void closeFile(Exception e) {
        if (e != null) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        try {
            if (fileWriter != null) {
                fileWriter.close();
            }
        } catch (IOException e1) {
            log.error(e1.getMessage());
            e1.printStackTrace();
        }
    }

    private void openFile() {
        File file = new File(this.fullPath);

        //Open the stream
        try {
            this.fileWriter = new BufferedWriter(new FileWriter(file, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
