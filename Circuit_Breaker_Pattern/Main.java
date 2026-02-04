package Circuit_Breaker_Pattern;

public class Main {
    public static void main(String[] args) {
        CircuitBreaker cb = new CircuitBreaker(3); // 3 failures allowed
        
        System.out.println("[HYSTRIX] Sending requests to External Service...");
        
        for(int i=0; i<5; i++) {
            cb.executeRequest(false); // Simulate failure
        }
        
        System.out.println("Trying one more time...");
        cb.executeRequest(true); // Even if success, circuit is OPEN
    }
}

class CircuitBreaker {
    enum State { CLOSED, OPEN }
    private State state = State.CLOSED;
    private int failureCount = 0;
    private int threshold;
    
    public CircuitBreaker(int threshold) { this.threshold = threshold; }
    
    public void executeRequest(boolean success) {
        if(state == State.OPEN) {
            System.out.println("   [BLOCKED] Circuit is OPEN. Request fail fast.");
            return;
        }
        
        if(success) {
            System.out.println("   [SUCCESS] Request processed.");
            failureCount = 0;
        } else {
            failureCount++;
            System.out.println("   [FAIL] Timeout/Error detected. Count: " + failureCount);
            if(failureCount >= threshold) {
                state = State.OPEN;
                System.out.println("   !!! CIRCUIT TRIPPED TO OPEN STATE !!!");
            }
        }
    }
}