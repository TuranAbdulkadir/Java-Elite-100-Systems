package Blockchain_Ledger_Core;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static List<Block> chain = new ArrayList<>();
    public static int difficulty = 4;

    public static void main(String[] args) {
        System.out.println("[SYSTEM] Initializing Blockchain...");
        
        System.out.println("Mining Genesis Block...");
        Block genesis = new Block("Genesis: System Start", "0");
        genesis.mineBlock(difficulty);
        chain.add(genesis);
        
        System.out.println("Mining Block 2...");
        Block b2 = new Block("Tx: User1 -> User2 (50 BTC)", chain.get(chain.size()-1).hash);
        b2.mineBlock(difficulty);
        chain.add(b2);
        
        System.out.println("Blockchain Size: " + chain.size());
        System.out.println("Latest Hash: " + chain.get(chain.size()-1).hash);
    }
}

class Block {
    public String hash;
    public String previousHash;
    private String data;
    private long timeStamp;
    private int nonce;

    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
    }

    public String calculateHash() {
        return applySha256(previousHash + Long.toString(timeStamp) + Integer.toString(nonce) + data);
    }

    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0');
        while(!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calculateHash();
        }
        System.out.println("Block Mined: " + hash);
    }

    public static String applySha256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch(Exception e) { throw new RuntimeException(e); }
    }
}