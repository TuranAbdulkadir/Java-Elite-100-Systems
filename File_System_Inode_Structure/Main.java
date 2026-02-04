package File_System_Inode_Structure;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        FileSystem fs = new FileSystem();
        
        System.out.println("[FS] Creating file 'notes.txt'...");
        fs.createFile("notes.txt", "Buy milk", 1024);
        
        System.out.println("[FS] Reading 'notes.txt'...");
        fs.readFile("notes.txt");
    }
}

class FileSystem {
    Map<String, Inode> directory = new HashMap<>();
    
    public void createFile(String name, String content, int size) {
        Inode node = new Inode(size, content);
        directory.put(name, node);
        System.out.println("   > Inode Created. ID: " + node.hashCode());
    }
    
    public void readFile(String name) {
        Inode node = directory.get(name);
        System.out.println("   > Data: " + node.data);
        System.out.println("   > Permissions: " + node.permissions);
    }
}

class Inode {
    int size; String data; String permissions = "rw-r--r--";
    public Inode(int s, String d) { size=s; data=d; }
}