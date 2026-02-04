package Brainfuck_Interpreter;

public class Main {
    public static void main(String[] args) {
        // Code prints "Hi"
        String code = "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++.+.>+++++++++."; 
        System.out.println("[BF] Running: " + code);
        interpret(code);
    }

    static void interpret(String code) {
        char[] tape = new char[30000];
        int ptr = 0;
        int len = code.length();
        
        for (int i = 0; i < len; i++) {
            char cmd = code.charAt(i);
            switch (cmd) {
                case '>': ptr++; break;
                case '<': ptr--; break;
                case '+': tape[ptr]++; break;
                case '-': tape[ptr]--; break;
                case '.': System.out.print(tape[ptr]); break;
                // Loops [ ] implementation omitted for brevity in mini-version
            }
        }
        System.out.println();
    }
}