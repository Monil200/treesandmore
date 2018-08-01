package toD;
import java.util.*;
public class PairSumInBST {
    
    Node root;
    PairSumInBST() {
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
    
    public void findSum(Node root, int target) {
        if (root == null) {
            return;
        }
        Stack<Node> pre = new Stack<Node>();
        Stack<Node> preReverse = new Stack<Node>();
        boolean run1 = true,run2 = true;
        Node currentl=root,currentr = root;
        currentl =root; currentr = root;
        
        while(true) {
            while((currentl!=  null || !pre.isEmpty()) && run1) {
                if (currentl!= null) {
                    pre.push(currentl);
                    currentl = currentl.left;
                } else {
                    currentl = pre.pop();
                    System.out.println("curr:" + currentl.data);
                    run1 = false;
                }
            }
            
            while((currentr!=  null || !preReverse.isEmpty()) && run2) {
                if (currentr!= null) {
                    preReverse.push(currentr);
                    currentr = currentr.right;
                } else {
                    currentr = preReverse.pop();
                    System.out.println("curr2:" + currentr.data);
                    run2 = false;
                }
            }
            
            if ((currentl.data + currentr.data) == target) {
                System.out.println("Sum formed");
                break;
            } else if (currentl.data + currentr.data > target) {
                currentr = currentr.left;
                run2 = true;
                run1 = false;
            } else if (currentl.data + currentr.data < target) {
                currentl = currentl.right;
                run1 = true;
                run2 = false;
            }
        }
        
    }
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        PairSumInBST obj = new PairSumInBST();
        obj.insert(4);
        obj.insert(2);
        obj.insert(1);
        obj.insert(3);
        obj.insert(6);
        obj.insert(5);
        obj.insert(7);
        obj.insert(8);
        
        obj.findSum(obj.root, 11);
    }

}
