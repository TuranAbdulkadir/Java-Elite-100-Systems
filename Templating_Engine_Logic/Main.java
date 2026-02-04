package Templating_Engine_Logic;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String template = "Hello, {{name}}! Welcome to {{app}}.";
        System.out.println("[TEMPLATE] " + template);
        
        Map<String, String> data = new HashMap<>();
        data.put("name", "Abdulkadir");
        data.put("app", "Java Elite Systems");
        
        String result = render(template, data);
        System.out.println("[RENDER]   " + result);
    }
    
    static String render(String tpl, Map<String, String> data) {
        for(String key : data.keySet()) {
            tpl = tpl.replace("{{" + key + "}}", data.get(key));
        }
        return tpl;
    }
}