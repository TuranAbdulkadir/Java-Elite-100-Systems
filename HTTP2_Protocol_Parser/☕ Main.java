
package HTTP2_Protocol_Parser;

import java.nio.ByteBuffer;

public class Main {
    public static void main(String[] args) {
        // Example HTTP/2 Frame Header (9 Bytes)
        // Length: 12, Type: 1 (HEADERS), Flags: 4 (END_HEADERS), StreamID: 1
        byte[] frameHeader = { 0x00, 0x00, 0x0C, 0x01, 0x04, 0x00, 0x00, 0x00, 0x01 };
        
        System.out.println("[HTTP/2] Parsing Frame Header...");
        ByteBuffer buf = ByteBuffer.wrap(frameHeader);
        
        int length = ((buf.get() & 0xFF) << 16) | ((buf.get() & 0xFF) << 8) | (buf.get() & 0xFF);
        byte type = buf.get();
        byte flags = buf.get();
        int streamId = buf.getInt() & 0x7FFFFFFF; // Ignore reserved bit
        
        System.out.println("   > Payload Length: " + length);
        System.out.println("   > Frame Type: " + (type == 1 ? "HEADERS" : "UNKNOWN"));
        System.out.println("   > Stream ID: " + streamId);
    }
}