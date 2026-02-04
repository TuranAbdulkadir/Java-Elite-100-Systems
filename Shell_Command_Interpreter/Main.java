package Shell_Command_Interpreter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("MyShell v1.0 (Type 'exit' to quit)");
        Scanner scanner = new Scanner(System.in);
        
        while(true) {
            System.out.print("$ ");
            String input = scanner.nextLine();
            
            if(input.equals("exit")) break;
            
            if(input.startsWith("echo ")) {
                System.out.println(input.substring(5));
            } else if(input.equals("ls")) {
                System.out.println("file1.txt  program.java  image.png");
            } else {
                System.out.println("Unknown command: " + input);
            }
        }
        System.out.println("[SHELL] Terminated.");
    }
}