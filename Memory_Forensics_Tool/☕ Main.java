
package Memory_Forensics_Tool;

public class Main {
    public static void main(String[] args) {
        System.out.println("[FORENSICS] Scanning JVM Heap...");
        
        // Simüle edilmiş hassas veri (Bellekte String olarak duruyor)
        String sensitiveData = "PASSWORD=SuperSecret123"; 
        
        long total = Runtime.getRuntime().totalMemory();
        long free = Runtime.getRuntime().freeMemory();
        
        System.out.println("   > Total Memory: " + (total / 1024 / 1024) + " MB");
        System.out.println("   > Used Memory: " + ((total - free) / 1024 / 1024) + " MB");
        
        // Basit bir Heap tarama simülasyonu (Reflection olmadan kavramsal)
        if (sensitiveData.contains("PASSWORD")) {
            System.out.println("[ALERT] Plaintext Password found in String Pool!");
        }
    }
}