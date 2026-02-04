package TimeSeries_Database_Engine;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        TSDB db = new TSDB();
        long t = System.currentTimeMillis();
        
        db.insert(t - 1000, 45.5);
        db.insert(t - 2000, 46.0);
        db.insert(t - 3000, 47.2);
        
        System.out.println("[TSDB] Querying range...");
        System.out.println("Result: " + db.query(t - 3500, t - 1500));
    }
}

class TSDB {
    private TreeMap<Long, Double> store = new TreeMap<>();
    
    public void insert(long time, double val) {
        store.put(time, val);
    }
    
    public Collection<Double> query(long start, long end) {
        return store.subMap(start, true, end, true).values();
    }
}