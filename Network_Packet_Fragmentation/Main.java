package Network_Packet_Fragmentation;

public class Main {
    public static void main(String[] args) {
        String data = "THIS_IS_A_VERY_LONG_MESSAGE_THAT_NEEDS_SPLITTING";
        int mtu = 10;
        
        System.out.println("[IP] Original Data: " + data);
        System.out.println("[IP] MTU Limit: " + mtu);
        
        for(int i=0; i<data.length(); i+=mtu) {
            int end = Math.min(i+mtu, data.length());
            String fragment = data.substring(i, end);
            System.out.println("   > Fragment (Offset " + i + "): " + fragment);
        }
    }
}