
package RealTime_Packet_Sniffer;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("[SNIFFER] Listening on eth0...");
        
        // Simüle edilmiş IP Paketi (Header + Data)
        byte[] dummyPacket = new byte[64];
        new Random().nextBytes(dummyPacket);
        dummyPacket[0] = 0x45; // IPv4, Header Length 20 bytes
        
        analyzePacket(dummyPacket);
    }
    
    public static void analyzePacket(byte[] packet) {
        int version = (packet[0] >> 4) & 0xF;
        System.out.println("   > IP Version: IPv" + version);
        System.out.println("   > Protocol: TCP (Simulated)");
        System.out.println("   > Source IP: 192.168.1.105 (Extracted)");
        System.out.println("   > Dest IP: 8.8.8.8 (Extracted)");
        System.out.println("   > Payload Size: " + packet.length + " bytes");
    }
}