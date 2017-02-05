package treesandmore;
import java.util.*;
public class LargestIndependentSet {
    Node root;
    public LargestIndependentSet() {
        this.root = null;
    }
    public void inorderTraversal(Node root) {
        if (root == null) {
            return;
        } else {
            inorderTraversal(root.left);
            System.out.print(root.data +  " , ");
            inorderTraversal(root.right);
        }
    }
    
    public int largetIndependentSet(Node root) {
        if (root == null) {
            return 0; 
        } else {
            
            int set_excl = largetIndependentSet(root.left) + largetIndependentSet(root.right); // excluding root 
            int set_inc = root.data;
//            int set_inc = 1;// if set size is needed
            if (root.left != null) {
                set_inc += largetIndependentSet(root.left.left) + largetIndependentSet(root.left.right);
            }
            if (root.right != null) {
                set_inc += largetIndependentSet(root.right.left) + largetIndependentSet(root.right.right);
            }
            return Math.max(set_excl, set_inc);
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LargestIndependentSet obj = new LargestIndependentSet();
        obj.root = new Node(10);
        obj.root.left = new Node(20);
        obj.root.right = new Node(30);
        obj.root.right.right = new Node(60);
        obj.root.left.left = new Node(40);
        obj.root.left.right = new Node(50);
        obj.root.left.right.left = new Node(70);
        obj.root.left.right.right = new Node(80);
        obj.inorderTraversal(obj.root);
        
        System.out.print("\nSize of the Largest Independent Set is :" + obj.largetIndependentSet(obj.root));
    }
    
    

}
