package Custom_DNS_Resolver;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("[DNS] Querying Google Public DNS (8.8.8.8) for 'www.example.com'...");
        
        DatagramSocket socket = new DatagramSocket();
        InetAddress dnsServer = InetAddress.getByName("8.8.8.8");
        
        // Construct simplified DNS Header + Question (Hardcoded for demo)
        byte[] request = new byte[] {
            0x00, 0x01, 0x01, 0x00, 0x00, 0x01, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, // Header
            0x03, 'w', 'w', 'w', 0x07, 'e', 'x', 'a', 'm', 'p', 'l', 'e', 0x03, 'c', 'o', 'm', 0x00, // QNAME
            0x00, 0x01, 0x00, 0x01 // QTYPE (A), QCLASS (IN)
        };
        
        DatagramPacket packet = new DatagramPacket(request, request.length, dnsServer, 53);
        socket.send(packet);
        
        byte[] buffer = new byte[512];
        DatagramPacket response = new DatagramPacket(buffer, buffer.length);
        socket.receive(response);
        
        System.out.println("[DNS] Response Received: " + response.getLength() + " bytes.");
        System.out.println("[DNS] Raw Hex: " + javax.xml.bind.DatatypeConverter.printHexBinary(Arrays.copyOf(buffer, response.getLength())));
        socket.close();
    }
}