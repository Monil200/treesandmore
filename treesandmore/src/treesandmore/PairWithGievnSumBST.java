package treesandmore;
import java.util.*;

public class PairWithGievnSumBST {
    public static Node root;
    public PairWithGievnSumBST() {
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
    
    public Node largestElement(Node root) {
        Node current = root;
        while(current != null) {
            if (current.right !=null) {
                current = current.right;
            } else {
                return current;
            }
        }
        return root;
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
    
    public void findPair(Node root, int target) {
        if (root == null ){
            return;
        } else {
            Stack<Node> s1 = new Stack<Node>();
            Stack<Node> s2 = new Stack<Node>();
            Node current1 = root;
            Node current2 = root;
            Boolean run1 = true;
            Boolean run2 = true;
            while(true) {
                // first stack with normal inorder
                System.out.println("----------S1---------");
                while((current1!=null || !s1.isEmpty()) && run1) {
                    if (current1!=null) {
                        System.out.println(current1.data);
                        s1.push(current1);
                        current1= current1.left;
                    } else {
                        current1= s1.pop();
                        run1 = false;
                    }
                }
                
                System.out.println("----------S2---------");
                // second stack with reverse inorder root-right-left
                while((current2!=null || !s2.isEmpty()) && run2) {
                    if (current2!=null) {
                        System.out.println(current2.data);
                        s2.push(current2);
                        current2= current2.right;
                    } else {
                        current2= s2.pop();
//                        current2 = current2.left;
                        run2 = false;
                    }
                }
                
                
                if (current1.data + current2.data == target) {
                    System.out.println("Yes sum found");
                    return;
                }
                if (current1.data + current2.data > target) {
                    run1 = false;
                    current2 = current2.left;
                    run2 = true;
                }
                if (current1.data + current2.data < target) {
                    run1 = true;
                    run2 = false;
                    current1 = current1.right;
                }
                if (s1.isEmpty() || s2.isEmpty()) {
                    System.out.println("NO sum found");
                    return;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        PairWithGievnSumBST bst = new PairWithGievnSumBST();
        bst.insert(4);
        bst.insert(2);
        bst.insert(1);
        bst.insert(3);
        bst.insert(8);
        bst.insert(9);
        bst.insert(6);
        bst.insert(7);
        bst.insert(5);
//        bst.inorderTraversal(root);
        System.out.println("-------------");
        bst.findPair(root, 12);

    }

}

