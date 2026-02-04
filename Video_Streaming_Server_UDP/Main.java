package Video_Streaming_Server_UDP;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("[NETFLIX] Starting Stream: 'Movie_4K.mp4'...");
        
        int totalFrames = 50;
        for(int seq=1; seq<=totalFrames; seq++) {
            byte[] videoData = new byte[1024]; // 1KB Frame
            Packet p = new Packet(seq, videoData);
            
            sendPacket(p);
            
            // 24 FPS Simulation (~41ms)
            Thread.sleep(41); 
        }
        System.out.println("[STREAM] Movie Ended.");
    }
    
    static void sendPacket(Packet p) {
        // UDP doesn't guarantee delivery
        if(Math.random() > 0.9) {
            System.out.println("   [LOSS] Frame " + p.sequence + " dropped (Network Glitch)!");
        } else {
            System.out.println("   [UDP] Sent Frame " + p.sequence + " (" + p.data.length + " bytes)");
        }
    }
}

class Packet {
    int sequence; byte[] data;
    public Packet(int s, byte[] d) { sequence=s; data=d; }
}