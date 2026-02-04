package Multi_Threaded_Web_Server;

public class Main {
    public static void main(String[] args) {
        System.out.println("[SERVER] Listening on Port 8080...");
        
        // Simulating 3 concurrent clients
        for(int i=1; i<=3; i++) {
            new ClientHandler(i).start();
        }
    }
}

class ClientHandler extends Thread {
    int id;
    public ClientHandler(int id) { this.id = id; }
    
    public void run() {
        System.out.println("   [THREAD] Handling Client " + id);
        try { Thread.sleep(1000); } catch(Exception e){} // Simulate work
        System.out.println("   [DONE] Client " + id + " response sent.");
    }
}