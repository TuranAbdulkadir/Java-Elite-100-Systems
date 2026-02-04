package Raft_Consensus_Simulator;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("[RAFT] Election Timeout triggered...");
        Node candidate = new Node(1);
        candidate.requestVotes();
    }
}

class Node {
    int id;
    public Node(int id) { this.id = id; }
    
    public void requestVotes() {
        System.out.println("Node-" + id + " requesting votes...");
        if(new Random().nextBoolean()) {
            System.out.println("Majority reached! Node-" + id + " is now LEADER.");
        } else {
            System.out.println("Vote failed. Retrying...");
        }
    }
}