package Message_Broker_PubSub;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Broker broker = new Broker();
        Subscriber s1 = new Subscriber("Service-A");
        
        broker.subscribe("ALARM", s1);
        
        System.out.println("[BROKER] Publishing 'ALARM'...");
        broker.publish("ALARM", "High CPU Usage!");
    }
}

class Broker {
    Map<String, List<Subscriber>> topics = new HashMap<>();

    public void subscribe(String topic, Subscriber s) {
        topics.computeIfAbsent(topic, k -> new ArrayList<>()).add(s);
    }

    public void publish(String topic, String msg) {
        if(topics.containsKey(topic)) {
            for(Subscriber s : topics.get(topic)) s.notify(topic, msg);
        }
    }
}

class Subscriber {
    String name;
    public Subscriber(String n) { this.name = n; }
    public void notify(String t, String m) {
        System.out.println(name + " received [" + t + "]: " + m);
    }
}