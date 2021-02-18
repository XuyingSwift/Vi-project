import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class VOne {
    public static final String SECURITY = "Security";
    public static final String FUNCTIONAL_SYNTAX = "Functional Syntax";
    public static final String FORMAT = "Format";
    public static final String RESOURCE_HANDLING = "Resource Handling";
    public static final String SECURITY = "Data Type Integrity";
    public static final String SECURITY = "Exception Handling";
    public static final String SECURITY = "Encryption";
    public static final String SECURITY = "Input Output Handling";
    public static final String SECURITY = "Structure";
    public static final String SECURITY = "Functional Semantics";


    public static void main(String[] args) throws FileNotFoundException {
        JSONParser parser = new JSONParser();

        try(Reader reader = new FileReader("C:\\Users\\xuyin\\IdeaProjects\\Vi-project\\src\\main\\resources\\qualityModel_ISO25010CSharpQualityModel.json"))  {

            JSONObject jsonObject = (JSONObject) parser.parse(reader);


            JSONObject tqi = (JSONObject) jsonObject.get("tqi");
            System.out.println(tqi);
            JSONObject weights = (JSONObject) tqi.get("weights");
            Double security_weight = (Double) weights.get(SECURITY);

            Map<String, Double> root = new HashMap<>();
            root.put("Security", security_weight);

            JSONObject characteristics = (JSONObject) jsonObject.get("characteristics");




        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
