package treessandtrees;
import java.util.*;
public class IterativeTraversals {
    public Node root;
    IterativeTraversals() {
        root = null;
    }
    
    public void insert(int val) {
        if (root == null) {
            root = new Node(val);
        } else {
            Node current = root;
            while(true) {
                if (current.data >= val) {
                    if (current.left != null) {
                        current = current.left;
                    } else {
                        current.left = new Node(val);
                        break;
                    }
                } else {
                    if (current.right != null) {
                        current = current.right;
                    } else {
                        current.right = new Node(val);
                        break;
                    }
                }
            }
        }
    }
    
    public void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + ", ");
        inorder(root.right);
    }
    
    public void iterativeInorder(Node root) {
        if (root == null)
            return;
        else {
            Stack<Node> s = new Stack<Node>();
            Node current = root;
            while(!s.isEmpty() || current!= null) {
                if (current != null) {
                    s.push(current);
                    current = current.left;
                } else {
                    current = s.pop();
                    System.out.print(current.data + ", ");
                    current=current.right;
                    
                }
            }
        }
    }
    
    public void iterativePreorder(Node root) {
        if (root == null)
            return;
        else {
            Stack<Node> s = new Stack<Node>();
            Node current = root;
            s.push(current);
            while(!s.isEmpty()) {
                current = s.pop();
                System.out.print(current.data + ", ");
                if (current.right != null) {
                    s.push(current.right);
                }
                if (current.left!= null) {
                    s.push(current.left);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        IterativeTraversals obj = new IterativeTraversals();
        obj.insert(4);
        obj.insert(2);
        obj.insert(1);
        obj.insert(3);
        obj.insert(6);
        obj.insert(5);
        obj.insert(7);
        System.out.println("---------Inorder--------");
        obj.inorder(obj.root);
        System.out.println("\n ---------Iterative Inorder--------");
        obj.iterativeInorder(obj.root);
        System.out.println("\n ---------Iterative Preorder--------");
        obj.iterativePreorder(obj.root);
    }

}

