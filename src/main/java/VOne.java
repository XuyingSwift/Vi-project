import Working.CharacteristicsHelper;
import Working.PropertiesHelper;
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
    public static final String DATA_TYPE_INTEGRITY = "Data Type Integrity";
    public static final String DOCUMENTATION = "Documentation";
    public static final String EXCEPTION_HANDLING = "Exception Handling";
    public static final String ENCRYPTION = "Encryption";
    public static final String INPUT_OUTPUT_HANDLING = "Input Output Handling";
    public static final String STRUCTURE = "Structure";
    public static final String FUNCTIONAL_SEMANTICS = "Functional Semantics";
    public static final String MEASURE = "measure";
    public static final String DIAGNOSTICS = "diagnostics";


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

            // characteristics weights
            JSONObject characteristics = (JSONObject) jsonObject.get("characteristics");
            JSONObject char_security = (JSONObject) characteristics.get("Security");
            JSONObject char_security_weights = (JSONObject) char_security.get("weights");

            // functional syntax
            Map<String, Double> functional_syntax_child = new HashMap<>();
            functional_syntax_child.put(FUNCTIONAL_SYNTAX, (Double) char_security_weights.get(FUNCTIONAL_SYNTAX));
            System.out.println(functional_syntax_child);

            System.out.println("Build a sub tree");
            Map<String, Object> security = CharacteristicsHelper.getSecurity(weights);
            System.out.println(security);
            Map<String, Object> functionalSyntax = CharacteristicsHelper.getFunctionalSyntaxValue(char_security_weights);
            System.out.println(functionalSyntax);




            // format
            Map<String, Double> format_child = new HashMap<>();
            format_child.put(FORMAT, (Double) char_security_weights.get(FORMAT));
            System.out.println(format_child);

            // RESOURCE_HANDLING
            Map<String, Double> resource_handling = new HashMap<>();
            resource_handling.put(RESOURCE_HANDLING, (Double) char_security_weights.get(RESOURCE_HANDLING));
            System.out.println(resource_handling);

            // Data Type Integrity
            Map<String, Double> data_type_integrity = new HashMap<>();
            data_type_integrity.put(DATA_TYPE_INTEGRITY, (Double) char_security_weights.get(DATA_TYPE_INTEGRITY));
            System.out.println(data_type_integrity);

            // Documentation
            Map<String, Double> documentation = new HashMap<>();
            documentation.put(DOCUMENTATION, (Double) char_security_weights.get(DOCUMENTATION));
            System.out.println(documentation);

            // Exception Handling
            Map<String, Double> exception_handling = new HashMap<>();
            exception_handling.put(EXCEPTION_HANDLING, (Double) char_security_weights.get(EXCEPTION_HANDLING));
            System.out.println(exception_handling);

            // Encryption
            Map<String, Double> encryption = new HashMap<>();
            encryption.put(ENCRYPTION, (Double) char_security_weights.get(ENCRYPTION));
            System.out.println(encryption);

            // Input Output Handling
            Map<String, Double> input_output_handling = new HashMap<>();
            input_output_handling.put(INPUT_OUTPUT_HANDLING, (Double) char_security_weights.get(INPUT_OUTPUT_HANDLING));
            System.out.println(input_output_handling);

            // Structure
            Map<String, Double> structure = new HashMap<>();
            structure.put(STRUCTURE, (Double) char_security_weights.get(STRUCTURE));
            System.out.println(structure);

            // Functional Semantics
            Map<String, Double> functional_semantics = new HashMap<>();
            functional_semantics.put(FUNCTIONAL_SEMANTICS, (Double) char_security_weights.get(FUNCTIONAL_SEMANTICS));
            System.out.println(functional_semantics);

            // properties
            JSONObject properties = (JSONObject) jsonObject.get("properties");
            JSONObject pro_functional_syntax = (JSONObject) properties.get(FUNCTIONAL_SYNTAX);

            Map<String, Object> functionalSyntax1 = PropertiesHelper.getFunctionalSyntaxInfo(pro_functional_syntax);
            System.out.println(functionalSyntax1);

            JSONObject functional_syntax_measure = (JSONObject) pro_functional_syntax.get(MEASURE);

            Map<String, Object> measure = PropertiesHelper.getFunctionalSyntaxMeasure(functional_syntax_measure);
            System.out.println(measure);

            Map<String, Object> diagnostics = PropertiesHelper.getFunctionalSyntaxDiagnostics(functional_syntax_measure);
            System.out.println(diagnostics);








        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        Node<String, Object> root = createTree();
        printTree(root, " ");
    }


    private static Node<String, Object> createTree() {
         JSONParser parser = new JSONParser();

         try(Reader reader = new FileReader("C:\\Users\\xuyin\\IdeaProjects\\Vi-project\\src\\main\\resources\\qualityModel_ISO25010CSharpQualityModel.json"))  {

             JSONObject jsonObject = (JSONObject) parser.parse(reader);


             JSONObject tqi = (JSONObject) jsonObject.get("tqi");
             System.out.println(tqi);
             JSONObject weights = (JSONObject) tqi.get("weights");
             Double security_weight = (Double) weights.get(SECURITY);

             Map<String, Double> root = new HashMap<>();
             root.put("Security", security_weight);

             // characteristics weights
             JSONObject characteristics = (JSONObject) jsonObject.get("characteristics");
             JSONObject char_security = (JSONObject) characteristics.get("Security");
             JSONObject char_security_weights = (JSONObject) char_security.get("weights");

             // functional syntax
             Map<String, Double> functional_syntax_child = new HashMap<>();
             functional_syntax_child.put(FUNCTIONAL_SYNTAX, (Double) char_security_weights.get(FUNCTIONAL_SYNTAX));
             System.out.println(functional_syntax_child);






             // format
             Map<String, Double> format_child = new HashMap<>();
             format_child.put(FORMAT, (Double) char_security_weights.get(FORMAT));
             System.out.println(format_child);

             // RESOURCE_HANDLING
             Map<String, Double> resource_handling = new HashMap<>();
             resource_handling.put(RESOURCE_HANDLING, (Double) char_security_weights.get(RESOURCE_HANDLING));
             System.out.println(resource_handling);

             // Data Type Integrity
             Map<String, Double> data_type_integrity = new HashMap<>();
             data_type_integrity.put(DATA_TYPE_INTEGRITY, (Double) char_security_weights.get(DATA_TYPE_INTEGRITY));
             System.out.println(data_type_integrity);

             // Documentation
             Map<String, Double> documentation = new HashMap<>();
             documentation.put(DOCUMENTATION, (Double) char_security_weights.get(DOCUMENTATION));
             System.out.println(documentation);

             // Exception Handling
             Map<String, Double> exception_handling = new HashMap<>();
             exception_handling.put(EXCEPTION_HANDLING, (Double) char_security_weights.get(EXCEPTION_HANDLING));
             System.out.println(exception_handling);

             // Encryption
             Map<String, Double> encryption = new HashMap<>();
             encryption.put(ENCRYPTION, (Double) char_security_weights.get(ENCRYPTION));
             System.out.println(encryption);

             // Input Output Handling
             Map<String, Double> input_output_handling = new HashMap<>();
             input_output_handling.put(INPUT_OUTPUT_HANDLING, (Double) char_security_weights.get(INPUT_OUTPUT_HANDLING));
             System.out.println(input_output_handling);

             // Structure
             Map<String, Double> structure = new HashMap<>();
             structure.put(STRUCTURE, (Double) char_security_weights.get(STRUCTURE));
             System.out.println(structure);

             // Functional Semantics
             Map<String, Double> functional_semantics = new HashMap<>();
             functional_semantics.put(FUNCTIONAL_SEMANTICS, (Double) char_security_weights.get(FUNCTIONAL_SEMANTICS));
             System.out.println(functional_semantics);

             // properties
             JSONObject properties = (JSONObject) jsonObject.get("properties");
             JSONObject pro_functional_syntax = (JSONObject) properties.get(FUNCTIONAL_SYNTAX);

             Map<String, Object> functionalSyntax1 = PropertiesHelper.getFunctionalSyntaxInfo(pro_functional_syntax);
             System.out.println(functionalSyntax1);

             JSONObject functional_syntax_measure = (JSONObject) pro_functional_syntax.get(MEASURE);

             Map<String, Object> measure = PropertiesHelper.getFunctionalSyntaxMeasure(functional_syntax_measure);
             System.out.println(measure);

             Map<String, Object> diagnostics = PropertiesHelper.getFunctionalSyntaxDiagnostics(functional_syntax_measure);
             System.out.println(diagnostics);

             System.out.println("Build a sub tree");

             Map<String, Object> functionalSyntax = CharacteristicsHelper.getFunctionalSyntaxValue(char_security_weights);
             System.out.println(functionalSyntax);

             Node<String, Object> treeRoot = (Node<String, Object>) CharacteristicsHelper.getSecurity(weights);
             Node<String, Object> node1 = treeRoot.addChild((Node<String, Object>)CharacteristicsHelper.getFunctionalSyntaxValue(char_security_weights));




        return treeRoot;

         } catch (IOException | ParseException e) {
             e.printStackTrace();
         }

         return null;
     }

    private static <T> void printTree(Node<String, Object> node, String appender) {
        System.out.println(appender + node.getData());
        node.getChildren().forEach(each ->  printTree(each, appender + appender));
    }
}
