package Assembly_Instruction_Emulator;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        CPU cpu = new CPU();
        
        System.out.println("[ASM] Executing Program...");
        cpu.execute("MOV AX 10"); // AX = 10
        cpu.execute("MOV BX 20"); // BX = 20
        cpu.execute("ADD AX BX"); // AX = AX + BX (30)
        
        System.out.println("Register AX: " + cpu.registers.get("AX"));
    }
}

class CPU {
    Map<String, Integer> registers = new HashMap<>();
    
    public void execute(String instruction) {
        String[] parts = instruction.split(" ");
        String op = parts[0];
        
        if(op.equals("MOV")) {
            registers.put(parts[1], Integer.parseInt(parts[2]));
        } else if(op.equals("ADD")) {
            int val1 = registers.get(parts[1]);
            int val2 = registers.get(parts[2]);
            registers.put(parts[1], val1 + val2);
        }
        System.out.println("   > " + instruction);
    }
}