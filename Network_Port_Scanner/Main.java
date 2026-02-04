package Network_Port_Scanner;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        String target = "localhost"; // Scan local machine
        System.out.println("[NMAP] Scanning " + target + " (Ports 1-1000)...");
        
        ExecutorService pool = Executors.newFixedThreadPool(20);
        
        for(int port=1; port<=100; port++) { // Scanning first 100 for demo
            final int p = port;
            pool.submit(() -> {
                try {
                    Socket socket = new Socket();
                    socket.connect(new InetSocketAddress(target, p), 200);
                    socket.close();
                    System.out.println("   [OPEN] Port " + p + " is open!");
                } catch (Exception e) {
                    // Port closed, ignore
                }
            });
        }
        pool.shutdown();
    }
}