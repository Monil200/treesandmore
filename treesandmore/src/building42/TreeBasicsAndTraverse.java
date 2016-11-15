package building42;
import java.util.*;
class Node {
    int data;
    Node left, right;
    public Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}
public class TreeBasicsAndTraverse {
    Node root;
    public TreeBasicsAndTraverse() {
        root = null;
    }
    
    public void insert(int val) {
        if (root == null) {
            root = new Node(val);
        } else {
            Node current = root;
            Node newNode = new Node(val);
            while(true) {
                if (current.data >= val) {
                    if (current.left != null) {
                        current = current.left;
                    } else {
                        current.left = newNode;
                        break;
                    }
                } else {
                    if (current.right != null) {
                        current = current.right;
                    } else {
                        current.right = newNode;
                        break;
                    }
                }
            }
        }
    }
    int size(Node root) {
        if (root == null) {
            return 0;
        } else {
            return size(root.left) + size(root.right)  +1;
        }
    }
    
    int height(Node root) {
        if (root == null) {
            return 0;
        } else {
            int ldepth = height(root.left);
            int rdepth = height(root.right);
            if (ldepth >= rdepth)
                return ldepth +1;
            else {
                return rdepth +1;
            }
        }
    }
    void inorder(Node root) {
        if (root == null) {
            return;
        } else {
            inorder(root.left);
            System.out.print(root.data + ",");
            inorder(root.right);
        }
    }
    
    public void inorderIterative(Node root) {
        if (root == null)
            return;
        Stack<Node> s = new Stack<Node>();
        Node current = root;
        while(!s.isEmpty() || current != null) {
            if (current != null) {
                s.push(current);
                current = current.left;
            } else {
                current = s.pop();
                System.out.print(current.data + ",");
                current = current.right;
            }
        }
    }
    
    public void preorderIterative(Node root) {
        if (root == null)
            return;
        Stack<Node> s = new Stack<Node>();
        Node current = root;
        s.push(current);
        while(!s.isEmpty()) {
            current = s.pop();
            System.out.print(current.data + ",");
            if (current.right != null) {
                s.push(current.right);
            }
            if (current.left != null)
                s.push(current.left);
        }
        
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeBasicsAndTraverse obj = new TreeBasicsAndTraverse();
        obj.insert(4);
        obj.insert(2);
        obj.insert(1);
        obj.insert(3);
        obj.insert(6);
        obj.insert(8);
        System.out.println("Inorder Traversal \n");
        obj.inorder(obj.root);
        System.out.println("\nSize of tree is \n");
        System.out.println(obj.size(obj.root));
        System.out.println("\n Height of tree is \n");
        System.out.println(obj.height(obj.root));
        System.out.println("\n Inorder Traversal terative \n");
        obj.inorderIterative(obj.root);
    }

}
