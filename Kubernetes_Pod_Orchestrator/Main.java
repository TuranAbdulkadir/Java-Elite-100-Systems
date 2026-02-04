package Kubernetes_Pod_Orchestrator;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Cluster cluster = new Cluster();
        cluster.addNode(new Node("Node-1", 100)); // 100 CPU capacity
        cluster.addNode(new Node("Node-2", 50));  // 50 CPU capacity
        
        System.out.println("[K8S] Scheduling Pods...");
        cluster.schedulePod("Pod-A", 40);
        cluster.schedulePod("Pod-B", 40);
        cluster.schedulePod("Pod-C", 60); // Should go to Node-1 or fail
    }
}

class Cluster {
    List<Node> nodes = new ArrayList<>();
    
    public void addNode(Node n) { nodes.add(n); }
    
    public void schedulePod(String podName, int requiredCpu) {
        // Simple Scheduler: Find first node with enough space
        for(Node node : nodes) {
            if(node.freeCpu >= requiredCpu) {
                node.freeCpu -= requiredCpu;
                System.out.println("   > Assigned " + podName + " to " + node.name);
                return;
            }
        }
        System.out.println("   > [ERROR] No node available for " + podName);
    }
}

class Node {
    String name; int freeCpu;
    public Node(String n, int c) { name=n; freeCpu=c; }
}