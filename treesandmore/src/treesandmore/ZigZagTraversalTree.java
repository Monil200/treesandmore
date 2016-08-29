package treesandmore;
import java.util.*;

public class ZigZagTraversalTree {
    public static Node root;
    public ZigZagTraversalTree() {
        root= null;
    }
    
    public void insert(int val) {
        if (root == null) {
            root = new Node(val);
        } else {
            Node current = root;
            Node newNode = new Node(val);
            while(true) {
                if (newNode.data > current.data) {
                    if (current.right !=null) {
                        current = current .right;
                        continue;
                    } else {
                        current.right = newNode;
                        return;
                    }
                } else {
                    if (current.left !=null) {
                        current = current .left;
                        continue;
                    } else {
                        current.left = newNode;
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
    
    public void zigZagTwoStacks(Node root) {
        if (root == null) {
            return;
        } else {
            Stack<Node> s1 = new Stack<Node>();
            Stack<Node> s2 = new Stack<Node>();
            s1.push(root);
            while(!s1.isEmpty()) {
                Node temp = s1.pop();
                System.out.println(temp.data + ",");
                if (temp.left != null) {
                    s2.push(temp.left);
                }
                if (temp.right != null) {
                    s2.push(temp.right);
                }
                while(!s2.isEmpty()) {
                    Node temp2 = s2.pop();
                    System.out.println(temp2.data + ",");
                    if (temp2.right != null) {
                        s1.push(temp2.right);
                    }
                    if (temp2.left != null) {
                        s1.push(temp2.left);
                    }
                }
                
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ZigZagTraversalTree bst = new ZigZagTraversalTree();
        bst.insert(4);
        bst.insert(2);
        bst.insert(1);
        bst.insert(3);
        bst.insert(8);
        bst.inorderTraversal(root);
        System.out.println("-------------");
        bst.zigZagTwoStacks(root);

    }

}
