
package Redis_Clone_InMemory_Cache;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        MiniRedis redis = new MiniRedis();
        redis.set("user:100", "Abdulkadir");
        redis.set("session_active", "true");
        
        System.out.println("GET user:100 -> " + redis.get("user:100"));
        System.out.println("GET unknown -> " + redis.get("unknown"));
    }
}

class MiniRedis {
    private Map<String, String> store = new HashMap<>();
    
    public void set(String key, String value) {
        store.put(key, value);
        System.out.println("[REDIS] SET " + key);
    }
    
    public String get(String key) {
        return store.getOrDefault(key, "(nil)");
    }
}