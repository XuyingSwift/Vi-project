package Working;

import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class PropertiesHelper {
    private static final String POSITIVE = "positive";
    private static final String MEASURE = "measure";
    private static final String DIAGNOSTICS = "diagnostics";
    private static final String THRESHOLDS = "thresholds";
    private static final String NAME = "name";
    private static final String VALUE = "value";

    public static Map<String, Object> getFunctionalSyntaxInfo(JSONObject current){
        Map<String, Object> functionalSyntax = new HashMap<>();
        functionalSyntax.put(POSITIVE, current.get(POSITIVE));
        functionalSyntax.put(THRESHOLDS, current.get(THRESHOLDS));
        return functionalSyntax;
    }

    public static Map<String, Object> getFunctionalSyntaxMeasure(JSONObject current) {
        Map<String, Object> measure = new HashMap<>();
        measure.put((String) current.get(NAME), current.get(VALUE));
        return measure;
    }

    public static Map<String, Object> getFunctionalSyntaxDiagnostics(JSONObject current) {
        Map<String, Object> diagnostics = new HashMap<>();
        diagnostics.put(DIAGNOSTICS, current.get(DIAGNOSTICS));
        return diagnostics;
    }
}
