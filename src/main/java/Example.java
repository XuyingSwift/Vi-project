/*
import org.json.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Example {
    public static void main(String[] args) throws JSONException {
        System.out.println(getFormattedJson("C:\\Users\\xuyin\\IdeaProjects\\Vi-project\\src\\main\\resources\\example.json"));
    }

    private static String getFormattedJson(String text) throws JSONException{
        JSONArray result = new JSONArray();
        JSONArray jsonArray = null;

        //get the json array
        jsonArray = new JSONArray(text);

        //loop through items in the array and insert them formatted to the result
        for (int i = 0; i < jsonArray.length(); i++) {
            //get object inside the number
            JSONObject object = getJsonChild(jsonArray.getJSONObject(i));

            //get these attributes
            String file = object.getString("File");
            String clas = object.getString("Class");
            String meth = object.getString("Method");
            String anno = object.getString("Annotation");

            //create a custom type of the object's attributes
            Map<String, String> map = new HashMap<>();
            map.put("Annotation", anno);
            Map<String, Object> map1 = new HashMap<>();
            map1.put(meth, map);
            Map<String, Object> map2 = new HashMap<>();
            map2.put(clas, map1);
            Map<String, Object> map3 = new HashMap<>();
            map3.put(file, map2);

            //loop through repeating values to also add them to one value as you expected
            for (int j = jsonArray.length() - 1; j > i; j--) {
                JSONObject obj = getJsonChild(jsonArray.getJSONObject(j));

                String file1 = obj.getString("File");
                String clas1 = obj.getString("Class");
                String meth1 = obj.getString("Method");
                String anno1 = obj.getString("Annotation");

                if (file1.equals(file)) {
                    if (map2.containsKey(clas1)) {
                        if (childrenContains(map2, meth1)) {
                            //if the difference was annotation value
                            map.put("Annotation", anno1);
                        } else {
                            //if the difference was method names
                            Map<String, String> map_ = new HashMap<>();
                            map_.put("Annotation", anno1);
                            ((Map<String, Object>) map2.get(clas1)).put(meth1, map_);
                        }
                    } else {
                        //if the difference was class names
                        Map<String, String> map_ = new HashMap<>();
                        map_.put("Annotation", anno1);
                        Map<String, Object> map1_ = new HashMap<>();
                        map1_.put(meth1, map_);
                        map2.put(clas1, map1_);
                    }

                    //remove the (value added) object
                    jsonArray.remove(j);
                }
            }

            //add the map to the result
            result.put(map3);
        }

        return  result.toString(4);
    }

    private static boolean childrenContains(Map<String, Object> map1, String meth1) {
        for (String childKey : map1.keySet()) {
            Map<String, Object> child = (Map<String, Object>) map1.get(childKey);
            if (child.containsKey(meth1))
                return true;
        }
        return false;
    }

    private static JSONObject getJsonChild(JSONObject object) throws JSONException {
        Iterator<String> keys = object.keys();
        String key = "";
        while (keys.hasNext()) {
            key = (String) keys.next();
        }
        return object.getJSONObject(key);
    }
    private static JSONArray readFromFile(String filePath){
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            return new JSONArray(sb.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}

*//*


import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class Example{
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("C:\\Users\\xuyin\\IdeaProjects\\Vi-project\\src\\main\\resources\\example.json")) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONArray fileList = (JSONArray) obj;
            System.out.println(fileList);
        } catch (FileNotFoundException e) {

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private static String getFormattedJson(JSONArray jsonArray) throws JSONException {
        JSONArray result = new JSONArray();

        //loop through items in the array and insert them formatted to the result
        for (int i = 0; i < jsonArray.size(); i++) {
            //get object inside the number
            JSONObject object = getJsonChild(jsonArray.get(i));

            //get these attributes
            String file = object.getString("File");
            String clas = object.getString("Class");
            String meth = object.getString("Method");
            String anno = object.getString("Annotation");

            //create a custom type of the object's attributes
            Map<String, String> map = new HashMap<>();
            map.put("Annotation", anno);
            Map<String, Object> map1 = new HashMap<>();
            map1.put(meth, map);
            Map<String, Object> map2 = new HashMap<>();
            map2.put(clas, map1);
            Map<String, Object> map3 = new HashMap<>();
            map3.put(file, map2);

            //loop through repeating values to also add them to one value as you expected
            for (int j = jsonArray.length() - 1; j > i; j--) {
                JSONObject obj = getJsonChild(jsonArray.getJSONObject(j));

                String file1 = obj.getString("File");
                String clas1 = obj.getString("Class");
                String meth1 = obj.getString("Method");
                String anno1 = obj.getString("Annotation");

                if (file1.equals(file)) {
                    if (map2.containsKey(clas1)) {
                        if (childrenContains(map2, meth1)) {
                            //if the difference was annotation value
                            map.put("Annotation", anno1);
                        } else {
                            //if the difference was method names
                            Map<String, String> map_ = new HashMap<>();
                            map_.put("Annotation", anno1);
                            ((Map<String, Object>) map2.get(clas1)).put(meth1, map_);
                        }
                    } else {
                        //if the difference was class names
                        Map<String, String> map_ = new HashMap<>();
                        map_.put("Annotation", anno1);
                        Map<String, Object> map1_ = new HashMap<>();
                        map1_.put(meth1, map_);
                        map2.put(clas1, map1_);
                    }

                    //remove the (value added) object
                    jsonArray.remove(j);
                }
            }

            //add the map to the result
            result.put(map3);
        }

        return  result.toString(4);
    }

    private static JSONObject getJsonChild(JSONObject object) throws JSONException {
        Iterator<String> keys = object.keySet().iterator();
        String key = "";
        while (keys.hasNext()) {
            key = (String) keys.next();
        }
        return object.}
}*/
