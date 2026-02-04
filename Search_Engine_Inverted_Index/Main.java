package Search_Engine_Inverted_Index;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Indexer engine = new Indexer();
        
        engine.addDocument(1, "java programming language");
        engine.addDocument(2, "python programming vs java");
        engine.addDocument(3, "advanced distributed systems");
        
        System.out.println("[SEARCH] Query: 'java'");
        System.out.println("Found in Docs: " + engine.search("java"));
        
        System.out.println("[SEARCH] Query: 'programming'");
        System.out.println("Found in Docs: " + engine.search("programming"));
    }
}

class Indexer {
    Map<String, List<Integer>> index = new HashMap<>();
    
    public void addDocument(int id, String text) {
        for(String word : text.split(" ")) {
            index.computeIfAbsent(word, k -> new ArrayList<>()).add(id);
        }
    }
    
    public List<Integer> search(String query) {
        return index.getOrDefault(query, Collections.emptyList());
    }
}