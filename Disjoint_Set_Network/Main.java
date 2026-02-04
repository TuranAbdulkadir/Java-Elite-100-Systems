package Disjoint_Set_Network;

public class Main {
    public static void main(String[] args) {
        System.out.println("[DSU] Initializing 5 computers (0-4)...");
        DSU dsu = new DSU(5);
        
        dsu.union(0, 1); // Connect 0 and 1
        dsu.union(1, 2); // Connect 1 and 2 (Now 0-1-2 are connected)
        
        System.out.println("Are 0 and 2 connected? " + dsu.connected(0, 2));
        System.out.println("Are 0 and 4 connected? " + dsu.connected(0, 4));
    }
}

class DSU {
    int[] parent;
    public DSU(int n) {
        parent = new int[n];
        for(int i=0; i<n; i++) parent[i] = i;
    }
    
    public int find(int i) {
        if(parent[i] != i) parent[i] = find(parent[i]); // Path compression
        return parent[i];
    }
    
    public void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        if(rootI != rootJ) parent[rootI] = rootJ;
    }
    
    public boolean connected(int i, int j) {
        return find(i) == find(j);
    }
}