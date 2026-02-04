package USB_Hardware_Event_Listener;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("[OS] Listening for Hardware Events...");
        
        Thread.sleep(1000);
        
        // Simulate Insertion
        onDeviceInserted("USB_Mass_Storage_Device", "Kingston_32GB");
    }
    
    static void onDeviceInserted(String type, String name) {
        System.out.println("\n>>> HARDWARE INTERRUPT <<<");
        System.out.println("   New Device Detected: " + name);
        System.out.println("   Type: " + type);
        System.out.println("   [DRIVER] Loading 'usb_storage.sys'...");
        System.out.println("   [MOUNT] Mounted at E:\\");
    }
}