package rs.edu.viser.json.generator;

/**
 * Created by neman on 22-Jun-16.
 *
 * Used for generating Java class names from JSON objects and JSON object names from Java class names.
 */
public class ClassNamer {

    /**
     * Turns a json object name to Java class file name (eg. my_json_object -> MyJsonObject)
     * @param json JSON object name format
     * @return Java class name format
     */
    public String jsonToJava(String json, boolean capitalFirstLetter) {
        StringBuilder stringBuilder = new StringBuilder(json);
        if (capitalFirstLetter) {
            stringBuilder.setCharAt(0, (char) (stringBuilder.charAt(0) - 32));
        }
        int index;
        while ((index = stringBuilder.toString().indexOf('_')) > -1) {
            stringBuilder.deleteCharAt(index);
            if (index < stringBuilder.toString().length() && stringBuilder.charAt(index) > 96) {
                stringBuilder.setCharAt(index, (char) (stringBuilder.charAt(index) - 32));
            }
        }
        return stringBuilder.toString();
    }

    /**
     * Turns a Java class name format to json object name format (eg. MyJavaObject -> my_java_object)
     * @param java Java object name format
     * @return Json object name format
     */
    public String javaToJson(String java) {
        StringBuilder stringBuilder = new StringBuilder(java);
        boolean keepGoing = true;
        int index = 0;
        if (stringBuilder.charAt(0) > 64 && stringBuilder.charAt(0) < 91) {
            stringBuilder.setCharAt(index, (char) (stringBuilder.charAt(index) + 32));
        }
        while (keepGoing) {
            int charAscii = stringBuilder.charAt(index);
            if (charAscii > 64 && charAscii < 91) {
                stringBuilder.setCharAt(index, (char) (stringBuilder.charAt(index) + 32));
                String tempString = stringBuilder.toString();
                tempString = tempString.substring(0, index) + "_" + tempString.substring(index, tempString.length());
                stringBuilder = new StringBuilder(tempString);
            }
            index++;
            keepGoing = index < stringBuilder.length();
        }
        return stringBuilder.toString();
    }

}
