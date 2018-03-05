package treessandtrees;
import java.util.*;
public class BTBSTTraversalsAll {
    public Node root;
    BTBSTTraversalsAll() {
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
        Node current = root;
        Stack<Node> s = new Stack<Node>();
        
        while(!s.isEmpty() || current!= null) {
            if (current != null) {
                s.push(current);
                current = current.left;
            } else {
                current = s.pop();
                System.out.print(current.data + ", ");
                current = current.right;
            }
        }
    }
    
    public void iterativePreorder(Node root) {
        if (root == null)
            return;
        Node current = root;
        Stack<Node> s = new Stack<Node>();
        s.push(current);
        while(!s.isEmpty()) {
            current = s.pop();
            System.out.print(current.data + ", ");
            if (current.right!= null) {
                s.push(current.right);
            }
            if (current.left!=null) {
                s.push(current.left);
            }
        }
    }
    
    public void getSum(Node root, int target) {
        if (root == null)
            return;
        Stack<Node> s1 = new Stack<Node>();
        Stack<Node> s2 = new Stack<Node>();
        Node currentL = root;
        Node currentR = root;
        boolean run1 = true;
        boolean run2 = true;
        while(true) {
            // pointer from left
            while((!s1.isEmpty() || currentL!=null) && run1) {
                if(currentL!=null) {
                    s1.push(currentL);
                    currentL = currentL.left;
                } else {
                    run1 = false;
                    currentL = s1.pop();
                }
            }
            
            while((!s2.isEmpty() || currentR!=null) && run2) {
                if(currentR!=null) {
                    s2.push(currentR);
                    currentR = currentR.right;
                } else {
                    run2 = false;
                    currentR = s2.pop();
                }
            }
            
            // now check target
            if ((currentL.data + currentR.data) == target) {
                System.out.println("Target found at left:" + currentL.data + " right:" + currentR.data);
                break;
            } else if (target > (currentL.data + currentR.data)) {
                run1 = true;
                currentL = currentL.right;
            } else if (target < (currentL.data + currentR.data)) {
                run2 = true;
                currentR = currentR.left;
            }
            if (s1.isEmpty() || s2.isEmpty()) {
                System.out.println("No Sum Found");
                break;
            }
        }
        
    }
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BTBSTTraversalsAll obj = new BTBSTTraversalsAll();
        obj.insert(4);
        obj.insert(2);
        obj.insert(1);
        obj.insert(3);
        obj.insert(6);
        obj.insert(5);
        obj.insert(7);
        System.out.println("---------Inorder--------");
        obj.inorder(obj.root);
        
        System.out.println("\n---------Inorder Iterative--------");
        obj.iterativeInorder(obj.root);
        System.out.println("\n---------Inorder Preorder Root-L-Right--------");
        obj.iterativePreorder(obj.root);
        
        // check if Sum exists in BST.
        System.out.println("\n---------Sum exists--------");
        obj.getSum(obj.root, 8);
    }

}
