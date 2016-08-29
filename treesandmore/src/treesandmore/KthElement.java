package treesandmore;
import java.util.*;

public class KthElement {
    public static Node root;
    public KthElement() {
        root = null;
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
            System.out.println(root.data );
            inorderTraversal(root.right);
        }
    }
    
    public int size(Node root) {
        if (root == null) {
            return 0;
        } else {
            return (1+size(root.left) + size(root.right));
        }
    }
    
    public void findKthElement(Node root, int k) {
        if (root == null ){
            return;
        } else {
            if (size(root.left) == k-1) {
                System.out.println("Kth largest element is " + root.data);
            } else if (size(root.left) >= k) {
                findKthElement(root.left, k);
            } else {
                findKthElement(root.right, k - size(root.left) - 1);
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        KthElement bst = new KthElement();
        bst.insert(4);
        bst.insert(2);
        bst.insert(1);
        bst.insert(3);
        bst.insert(8);
        bst.insert(9);
        bst.insert(6);
        bst.insert(7);
        bst.insert(5);
        bst.insert(15);
        bst.inorderTraversal(root);
        System.out.println("-------------");
        bst.findKthElement(root, 10);
    }

}

