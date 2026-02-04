package API_Rate_Limiter;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("[GATEWAY] Token Bucket Capacity: 5. Refill Rate: 1/sec");
        TokenBucket bucket = new TokenBucket(5, 1000); // 5 jeton kapasite, her 1 saniyede yenilenir

        // 10 tane hızlı istek gönderiyoruz
        for(int i=0; i<10; i++) {
            if(bucket.tryConsume()) {
                System.out.println("Request " + i + ": Allowed (200 OK)");
            } else {
                System.out.println("Request " + i + ": Blocked (429 Too Many Requests)");
            }
            Thread.sleep(100); // Çok hızlı istekler
        }
    }
}

class TokenBucket {
    private int capacity;
    private int tokens;
    private long lastRefill;
    private int refillInterval;

    public TokenBucket(int capacity, int refillInterval) {
        this.capacity = capacity;
        this.tokens = capacity;
        this.refillInterval = refillInterval;
        this.lastRefill = System.currentTimeMillis();
    }

    public synchronized boolean tryConsume() {
        refill();
        if(tokens > 0) {
            tokens--;
            return true;
        }
        return false;
    }

    private void refill() {
        long now = System.currentTimeMillis();
        if(now - lastRefill > refillInterval) {
            tokens = capacity; // Jetonları yenile
            lastRefill = now;
        }
    }
}