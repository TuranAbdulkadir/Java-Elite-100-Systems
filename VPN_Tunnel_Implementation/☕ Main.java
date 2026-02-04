package VPN_Tunnel_Implementation;

import javax.net.ssl.SSLSocketFactory;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        System.out.println("[VPN] Initiating TLS Handshake...");
        try {
            SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            // Google'a güvenli tünel (443) açma simülasyonu
            Socket socket = factory.createSocket("www.google.com", 443);
            
            System.out.println("[VPN] Tunnel Established: " + socket.isConnected());
            System.out.println("[VPN] Cipher Suite: " + ((javax.net.ssl.SSLSocket)socket).getSession().getCipherSuite());
            
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}