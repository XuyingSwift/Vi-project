/*

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Foo {
    public static void main(String... args) throws IOException {
        String json = formatJson(new FileReader("rawOutput.json"));
        System.out.println(json);
    }

    public static String formatJson(Reader reader) throws IOException {
        // group array items by fileName
        final Function<List<Map<String, Object>>, Map<String, List<Object>>> groupByFileName =
                data -> data.stream().collect(Collectors.groupingBy(map -> (String)map.get("File"), TreeMap::new,
                        Collectors.mapping(Function.identity(), Collectors.toList())));

        // convert source item structure into required
        final Function<Map.Entry<String, List<Object>>, Map<String, Object>> convert = entry -> {
            Map<String, Map<String, Map<String, String>>> tmp = new LinkedHashMap<>();

            entry.getValue().stream()
                    .map(value -> (Map<String, String>)value)
                    .forEach(map -> {
                        Map<String, Map<String, String>> classes = tmp.computeIfAbsent(map.get("Class"), cls -> new TreeMap<>());
                        Map<String, String> methods = classes.computeIfAbsent(map.get("Method"), method -> new TreeMap<>());

                        map.entrySet().stream()
                                .filter(e -> !"Class".equals(e.getKey()) && !"Method".equals(e.getKey()) && !"File".equals(e.getKey()))
                                .forEach(e -> methods.put(e.getKey(), e.getValue()));
                    });

            return Collections.singletonMap(entry.getKey(), tmp);
        };

        ObjectMapper mapper = new ObjectMapper();

        // read json as array of Maps
        List<Map<String, Object>> data = Arrays.stream(mapper.readValue(reader, Map[].class))
                .map(map -> map.values().iterator().next())
                .map(item -> (Map<String, Object>)item)
                .collect(Collectors.toList());

        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(groupByFileName.apply(data).entrySet().stream()
                .map(convert).collect(Collectors.toList()));
    }
}*/
