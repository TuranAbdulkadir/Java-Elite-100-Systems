package Cache_Coherence_Protocol;

public class Main {
    public static void main(String[] args) {
        System.out.println("[CPU] Core 1 reads Address X");
        System.out.println("   > State: EXCLUSIVE (E)");
        
        System.out.println("[CPU] Core 2 reads Address X");
        System.out.println("   > State Transition: E -> SHARED (S)");
        
        System.out.println("[CPU] Core 1 writes to Address X");
        System.out.println("   > Core 1 State: MODIFIED (M)");
        System.out.println("   > Core 2 State: INVALID (I)");
    }
}