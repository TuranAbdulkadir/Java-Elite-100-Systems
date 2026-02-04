package MapReduce_Engine;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("[MapReduce] Processing Big Data Log...");
        
        List<String> dataset = Arrays.asList(
            "error login failed",
            "info user created",
            "error timeout",
            "info logout success",
            "error login failed"
        );

        // 1. MAP
        List<String> mapped = dataset.stream()
            .map(line -> line.split(" ")[0]) // Extract Log Level (INFO/ERROR)
            .collect(Collectors.toList());
            
        // 2. REDUCE (Count occurrences)
        Map<String, Integer> reduced = new HashMap<>();
        for (String key : mapped) {
            reduced.put(key, reduced.getOrDefault(key, 0) + 1);
        }

        System.out.println("Result: " + reduced);
    }
}