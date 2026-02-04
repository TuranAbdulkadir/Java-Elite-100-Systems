package Mathematical_Expression_Evaluator;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Main {
    public static void main(String[] args) throws Exception {
        String expr = "(10 + 20) * 2 - 5";
        System.out.println("[MATH] Evaluating: " + expr);
        
        // Using Java's built-in JS engine for simplicity in logic demonstration
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        
        Object result = engine.eval(expr);
        System.out.println("Result: " + result);
    }
}