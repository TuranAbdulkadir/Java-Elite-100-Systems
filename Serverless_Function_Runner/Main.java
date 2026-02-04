package Serverless_Function_Runner;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        System.out.println("[AWS LAMBDA] Waiting for triggers...");
        
        // Define a Lambda function dynamically
        Function<String, String> upperCaseFunc = (input) -> "Result: " + input.toUpperCase();
        
        triggerFunction("hello serverless", upperCaseFunc);
    }
    
    static void triggerFunction(String payload, Function<String, String> func) {
        System.out.println("   > Event Received. Spinning up container...");
        String res = func.apply(payload);
        System.out.println("   > " + res);
        System.out.println("   > Execution done. Container destroyed.");
    }
}