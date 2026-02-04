package FTP_Server_Custom;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FTPServer server = new FTPServer();
        System.out.println("[FTP] Server Ready on Port 21. Waiting for commands...");
        
        // Simulating a Client Session
        server.handleCommand("USER admin");
        server.handleCommand("PASS 12345");
        server.handleCommand("LIST");
        server.handleCommand("RETR secret.txt");
    }
}

class FTPServer {
    boolean loggedIn = false;
    
    public void handleCommand(String cmd) {
        String[] parts = cmd.split(" ");
        String op = parts[0];
        
        switch(op) {
            case "USER": System.out.println("   < 331 Username OK, need password."); break;
            case "PASS": 
                if(parts[1].equals("12345")) {
                    loggedIn = true;
                    System.out.println("   < 230 User logged in."); 
                } else System.out.println("   < 530 Login incorrect.");
                break;
            case "LIST":
                if(!loggedIn) { System.out.println("   < 530 Not logged in."); return; }
                System.out.println("   < 150 Here comes the directory listing.\n     - file1.txt\n     - secret.txt");
                break;
            case "RETR":
                if(!loggedIn) { System.out.println("   < 530 Not logged in."); return; }
                System.out.println("   < 226 Transferring " + parts[1] + "...");
                break;
        }
    }
}