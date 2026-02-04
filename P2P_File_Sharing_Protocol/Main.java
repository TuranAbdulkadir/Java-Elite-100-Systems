package P2P_File_Sharing_Protocol;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Peer p1 = new Peer("Peer-1");
        Peer p2 = new Peer("Peer-2");
        
        // Peer-1 A parçasına sahip, Peer-2 B parçasına sahip
        p1.hasChunk("Chunk_A");
        p2.hasChunk("Chunk_B");
        
        System.out.println("[P2P] Peer-1 requesting Chunk_B...");
        p1.requestChunk("Chunk_B", p2);
    }
}

class Peer {
    String id;
    Set<String> chunks = new HashSet<>();

    public Peer(String id) { this.id = id; }
    
    public void hasChunk(String c) { chunks.add(c); }
    
    public void requestChunk(String c, Peer target) {
        if(target.upload(c)) {
            System.out.println("   -> " + id + ": Downloaded " + c + " from " + target.id);
            chunks.add(c);
        } else {
            System.out.println("   -> " + target.id + " does not have " + c);
        }
    }
    
    public boolean upload(String c) { return chunks.contains(c); }
}