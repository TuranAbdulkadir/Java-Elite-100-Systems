package GRPC_Remote_Procedure_Call;

public class Main {
    public static void main(String[] args) {
        System.out.println("[CLIENT] Calling remote method 'getUser(5)'...");
        
        // Stub: A local representation of the remote service
        UserServiceStub stub = new UserServiceStub();
        String response = stub.getUser(5);
        
        System.out.println("[CLIENT] Response received: " + response);
    }
}

class UserServiceStub {
    public String getUser(int id) {
        // Serialize request, send over network, wait for response (Simulated)
        System.out.println("   [NETWORK] Sending binary request -> Server...");
        return "{id: " + id + ", name: 'Alice'}";
    }
}