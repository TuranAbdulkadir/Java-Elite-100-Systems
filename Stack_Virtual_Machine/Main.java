package Stack_Virtual_Machine;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println("[VM] Executing Bytecode: PUSH 10, PUSH 20, ADD, PRINT");
        
        Stack<Integer> stack = new Stack<>();
        String[] program = {"PUSH", "10", "PUSH", "20", "ADD", "PRINT"};
        
        for(int i=0; i<program.length; i++) {
            String op = program[i];
            switch(op) {
                case "PUSH": stack.push(Integer.parseInt(program[++i])); break;
                case "ADD": stack.push(stack.pop() + stack.pop()); break;
                case "PRINT": System.out.println("Result: " + stack.peek()); break;
            }
        }
    }
}