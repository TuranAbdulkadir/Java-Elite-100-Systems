package Abstract_Syntax_Tree_Builder;

public class Main {
    public static void main(String[] args) {
        // Representing: 1 + (2 * 3)
        System.out.println("[AST] Building Tree for: 1 + 2 * 3");
        
        Node two = new Node("2");
        Node three = new Node("3");
        Node mul = new Node("*", two, three); // (2 * 3)
        
        Node one = new Node("1");
        Node add = new Node("+", one, mul);   // 1 + ...
        
        printTree(add, "");
    }
    
    static void printTree(Node node, String indent) {
        System.out.println(indent + node.val);
        if(node.left != null) printTree(node.left, indent + "  ");
        if(node.right != null) printTree(node.right, indent + "  ");
    }
}

class Node {
    String val; Node left, right;
    public Node(String v) { val = v; }
    public Node(String v, Node l, Node r) { val=v; left=l; right=r; }
}