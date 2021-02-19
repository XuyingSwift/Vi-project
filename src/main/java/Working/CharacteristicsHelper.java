package Working;

import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class CharacteristicsHelper {

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

    public static Map<String, Object> getSecurity(JSONObject current) {
        Map<String, Object> security = new HashMap<>();
        security.put(SECURITY, current.get(SECURITY));
        return security;
    }

    public static Map<String, Object> getFunctionalSyntaxValue(JSONObject current) {
        Map<String, Object> functionalSyntax = new HashMap<>();
        functionalSyntax.put(FUNCTIONAL_SYNTAX, current.get(FUNCTIONAL_SYNTAX));
        return functionalSyntax;
    }
}
