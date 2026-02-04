package Web_Crawler_MultiThreaded;

import java.util.*;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("[SPIDER] Starting Crawl on 'https://example.com'...");
        Crawler crawler = new Crawler();
        crawler.start("https://example.com");
    }
}

class Crawler {
    private Set<String> visited = ConcurrentHashMap.newKeySet();
    private ExecutorService pool = Executors.newFixedThreadPool(5);
    
    public void start(String seedUrl) {
        pool.submit(new CrawlTask(seedUrl));
    }
    
    class CrawlTask implements Runnable {
        String url;
        public CrawlTask(String u) { url = u; }
        
        public void run() {
            if(!visited.add(url)) return; // Already visited
            
            System.out.println("   [VISIT] Indexing: " + url + " (Thread: " + Thread.currentThread().getId() + ")");
            
            // Simulation of finding links
            try { Thread.sleep(500); } catch(Exception e){} // Network delay
            
            if(url.length() < 30) { // Limit depth for demo
                pool.submit(new CrawlTask(url + "/page1"));
                pool.submit(new CrawlTask(url + "/about"));
            }
        }
    }
}