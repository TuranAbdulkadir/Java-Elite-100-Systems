package Database_Sharding_Logic;

public class Main {
    public static void main(String[] args) {
        System.out.println("[DB] Initializing 3 Shards (Shard-0, Shard-1, Shard-2)...");
        
        int userId1 = 100;
        int userId2 = 101;
        int userId3 = 102;
        
        System.out.println("Routing User " + userId1 + " -> " + getShard(userId1));
        System.out.println("Routing User " + userId2 + " -> " + getShard(userId2));
        System.out.println("Routing User " + userId3 + " -> " + getShard(userId3));
    }
    
    static String getShard(int id) {
        int shardId = id % 3; // Modulo 3 sharding
        return "Shard-" + shardId;
    }
}