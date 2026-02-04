package Docker_Container_Engine_Sim;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        DockerDaemon docker = new DockerDaemon();
        
        System.out.println("[DOCKER] Pulling ubuntu:latest...");
        String containerId = docker.run("ubuntu", "bash script.sh");
        
        System.out.println("Container Started. ID: " + containerId);
        docker.logs(containerId);
        
        System.out.println("[DOCKER] Stopping container...");
        docker.stop(containerId);
    }
}

class DockerDaemon {
    Map<String, Container> containers = new HashMap<>();
    
    public String run(String image, String cmd) {
        String id = UUID.randomUUID().toString().substring(0, 8);
        containers.put(id, new Container(image, cmd, "RUNNING"));
        return id;
    }
    
    public void logs(String id) {
        System.out.println("[LOGS " + id + "] Executing: " + containers.get(id).cmd);
    }
    
    public void stop(String id) {
        if(containers.containsKey(id)) {
            containers.get(id).status = "EXITED";
            System.out.println("Container " + id + " is now EXITED.");
        }
    }
}

class Container {
    String image, cmd, status;
    public Container(String i, String c, String s) { image=i; cmd=c; status=s; }
}