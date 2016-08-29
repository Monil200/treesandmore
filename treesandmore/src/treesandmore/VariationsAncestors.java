package treesandmore;
import java.util.*;

public class VariationsAncestors {
    
    public static Node root;
    public static Stack<Node> nodes;
    public VariationsAncestors() {
        root = null;
    }
    
    public void insert(int val) {
        if (root == null) {
            root = new Node(val);
        } else {
            Node newNode = new Node(val);
            Node current = root;
            while(true) {
                if (newNode.data < current.data) {
                    if (current.left !=null) {
                        current = current.left;
                        continue;
                    } else {
                        current.left = newNode;
                        return;
                    }
                } else {
                    if (current.right != null) {
                        current = current.right;
                        continue;
                    } else {
                        current.right = newNode;
                        return;
                    }
                }
            }
        }
    }
    
    public void inorderTraversal(Node root) {
        if (root == null) {
            return;
        } else {
            inorderTraversal(root.left);
            System.out.println(root.data + ",");
            inorderTraversal(root.right);
        }
    }
    
    public Node lowestCommonAncestor(Node root, int a, int b) {
        if (root == null) {
            return null;
        } else {
            if (root.data > b && root.data > a) {
                return lowestCommonAncestor(root.left, a,b);
            } else if (root.data < a && root.data < b) {
                return lowestCommonAncestor(root.right, a,b);
            }
        }
        return root;
    }
    
    public void printAllAncestors(Node root, int a, LinkedList<Node> l) {
        if (root == null) {
            return;
        } else {
            if (root.data == a) {
                Iterator<Node> i = l.iterator();
                while(i.hasNext()) {
                    System.out.println(i.next().data);
                }
                return;
            }
            l.add(root);
            printAllAncestors(root.left, a, new LinkedList<Node>(l));
            printAllAncestors(root.right, a, new LinkedList<Node>(l));
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        VariationsAncestors b = new VariationsAncestors();
        b.insert(4);
        b.insert(2);
        b.insert(1);
        b.insert(3);
        b.insert(6);
        b.insert(8);
        b.inorderTraversal(root);
        System.out.println("LCA : " + b.lowestCommonAncestor(root, 1, 3).data);
        LinkedList<Node> l = new LinkedList<Node>();
        b.printAllAncestors(root, 3, l);
    }

}