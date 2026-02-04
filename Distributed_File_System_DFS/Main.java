package Distributed_File_System_DFS;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        DFS dfs = new DFS();
        dfs.uploadFile("movie.mp4", 500); // 500MB file
        dfs.listMetadata();
    }
}

class DFS {
    Map<String, List<String>> metadata = new HashMap<>(); // Filename -> List of Chunk IDs
    
    public void uploadFile(String filename, int sizeMB) {
        System.out.println("[DFS] Uploading " + filename + " (" + sizeMB + "MB)...");
        List<String> chunks = new ArrayList<>();
        int chunkCount = (int) Math.ceil(sizeMB / 128.0); // 128MB chunks
        
        for(int i=0; i<chunkCount; i++) {
            String chunkId = UUID.randomUUID().toString();
            chunks.add(chunkId);
            System.out.println("   -> Created Chunk: " + chunkId + " [Replicating to DataNode-1, DataNode-2]");
        }
        metadata.put(filename, chunks);
        System.out.println("[DFS] Upload Complete.");
    }
    
    public void listMetadata() {
        System.out.println("\n[NameNode Metadata]: " + metadata);
    }
}