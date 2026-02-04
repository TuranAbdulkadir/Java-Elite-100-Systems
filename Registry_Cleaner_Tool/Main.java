package Registry_Cleaner_Tool;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("[REGEDIT] Scanning HKEY_CURRENT_USER...");
        
        Map<String, String> registry = new HashMap<>();
        registry.put("Software/App1/Path", "C:/Program Files/App1");
        registry.put("Software/OldGame/Path", "C:/Deleted/Game.exe"); // Broken
        
        for(String key : new ArrayList<>(registry.keySet())) {
            String path = registry.get(key);
            if(path.contains("Deleted")) {
                System.out.println("   [BROKEN] Found invalid key: " + key);
                registry.remove(key);
                System.out.println("   [CLEAN] Key removed.");
            } else {
                System.out.println("   [OK] " + key);
            }
        }
    }
}