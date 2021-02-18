import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;

public class JsonReadExample
{
    public static void main(String[] args) throws Exception
    {
        // parsing file "JSONExample.json"
        Object obj = new JSONParser().parse(new FileReader("C:\\Users\\xuyin\\IdeaProjects\\Vi-project\\src\\main\\resources\\JSONExample.json"));

        // typecasting obj to JSONObject
        JSONObject jo = (JSONObject) obj;

        // getting address
        Map address = ((Map)jo.get("address"));

        // iterating address Map
        Iterator<Map.Entry> itr1 = address.entrySet().iterator();

        // getting phoneNumbers
        JSONArray ja = (JSONArray) jo.get("phoneNumbers");

        // iterating phoneNumbers
        Iterator itr2 = ja.iterator();

        while (itr2.hasNext())
        {
            itr1 = ((Map) itr2.next()).entrySet().iterator();
            while (itr1.hasNext()) {
                Map.Entry pair = itr1.next();
                System.out.println(pair.getKey() + " : " + pair.getValue());
            }
        }
    }
}