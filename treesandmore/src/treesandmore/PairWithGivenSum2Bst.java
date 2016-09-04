package treesandmore;
import java.util.*;

public class PairWithGivenSum2Bst {
    
    public void insert(Node root, int val) {
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
            System.out.print(root.data + ",");
            inorderTraversal(root.right);
        }
    }
    
    // find pair within same tree.
    public void findPair(Node root1, Node root2, int target) {
        if (root1 == null || root2 == null){
            return;
        } else {
            Stack<Node> s1 = new Stack<Node>();
            Stack<Node> s2 = new Stack<Node>();
            Boolean run1 = true;
            Boolean run2 = true;
            Node current1= root1;
            Node current2= root2;
            while(true) {
                while((current1!=null || !s1.isEmpty()) && run1) {
                    if (current1!=null) {
                        s1.push(current1);
                        current1 = current1.left;
                    } else {
                        current1 = s1.pop();
                        run1 = false;
                    }
                }
                while((current2!=null || !s2.isEmpty()) && run2) {
                    if (current2!=null) {
                        s2.push(current2);
                        current2 = current2.right;
                    } else {
                        current2 = s2.pop();
                        run2 = false;
                    }
                }
                System.out.println("Current1:" + current1.data + " current2:" + current2.data);
                if (current1.data + current2.data == target) {
                    System.out.println("Sum "+target+" is found");
                    return;
                }
                if (current1.data + current2.data > target) {
                        run2 = true;
                        current2 = current2.left;
                }
                if (current1.data + current2.data < target) {
                    run1 = true;
                    current1 = current1.right;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        PairWithGivenSum2Bst bst = new PairWithGivenSum2Bst();
        Node n1 = new Node(4);
        bst.insert(n1, 2);
        bst.insert(n1, 1);
        bst.insert(n1, 3);
        bst.insert(n1, 8);
        bst.insert(n1, 6);
        // tree1
        System.out.println("----TREE1----");
        bst.inorderTraversal(n1);
        
        Node n2 = new Node(10);
        bst.insert(n2, 4);
        bst.insert(n2, 2);
        bst.insert(n2, 7);
        bst.insert(n2, 11);
        bst.insert(n2, 13);
        System.out.println("\n----TREE2----");
        bst.inorderTraversal(n2);
        bst.findPair(n1, n2, 14);
    }

}

