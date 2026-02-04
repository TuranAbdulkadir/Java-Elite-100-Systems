package Dijkstra_Shortest_Path;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("[DIJKSTRA] Finding shortest path in Graph...");
        
        Graph g = new Graph(6);
        g.addEdge(0, 1, 4); // Node 0 -> 1 (Weight 4)
        g.addEdge(0, 2, 2);
        g.addEdge(1, 2, 5);
        g.addEdge(1, 3, 10);
        g.addEdge(2, 3, 3);
        
        System.out.println("Shortest Path from Node 0 to Node 3:");
        g.dijkstra(0, 3);
    }
}

class Graph {
    private int V;
    private List<List<Node>> adj;

    public Graph(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
    }

    public void addEdge(int src, int dest, int weight) {
        adj.get(src).add(new Node(dest, weight));
    }

    public void dijkstra(int src, int target) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;
        pq.add(new Node(src, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.node;

            if (u == target) {
                System.out.println("Minimum Cost: " + dist[u]);
                return;
            }

            for (Node neighbor : adj.get(u)) {
                int v = neighbor.node;
                int weight = neighbor.cost;
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }
    }

    static class Node {
        int node, cost;
        public Node(int node, int cost) { this.node = node; this.cost = cost; }
    }
}