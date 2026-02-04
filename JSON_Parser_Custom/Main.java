package JSON_Parser_Custom;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String json = "{\"name\":\"Abdulkadir\", \"role\":\"Admin\", \"id\":\"101\"}";
        System.out.println("[PARSER] Input: " + json);
        
        Map<String, String> map = parse(json);
        System.out.println("Parsed Object: " + map);
        System.out.println("Get 'name': " + map.get("name"));
    }
    
    static Map<String, String> parse(String json) {
        Map<String, String> map = new HashMap<>();
        // Remove { } and split by comma
        String content = json.replaceAll("[{}\"]", "");
        String[] pairs = content.split(",");
        
        for(String pair : pairs) {
            String[] parts = pair.split(":");
            map.put(parts[0].trim(), parts[1].trim());
        }
        return map;
    }
}