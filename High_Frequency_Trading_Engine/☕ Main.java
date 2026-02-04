package High_Frequency_Trading_Engine;

import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        OrderBook book = new OrderBook();
        book.addOrder(new Order(101, true, 150.50)); // BUY 150.50
        book.addOrder(new Order(102, false, 150.40)); // SELL 150.40 (Match!)
        book.addOrder(new Order(103, false, 151.00)); // SELL 151.00
    }
}

class Order implements Comparable<Order> {
    int id; boolean isBuy; double price;
    public Order(int id, boolean isBuy, double price) { this.id = id; this.isBuy = isBuy; this.price = price; }
    public int compareTo(Order o) { return Double.compare(o.price, this.price); } // High price first
}

class OrderBook {
    PriorityQueue<Order> buyOrders = new PriorityQueue<>();
    public void addOrder(Order o) {
        System.out.println("[EXCHANGE] New Order: " + (o.isBuy ? "BUY" : "SELL") + " @ " + o.price);
        // Matching logic simulation...
        if(!o.isBuy && !buyOrders.isEmpty() && buyOrders.peek().price >= o.price) {
            System.out.println("   >>> TRADE EXECUTED: " + o.price);
            buyOrders.poll();
        } else if (o.isBuy) {
            buyOrders.add(o);
        }
    }
}