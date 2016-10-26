// A proper BT is a tree with every node having 0 or 2 children
package treesandmore;
import java.util.*;

public class ProperBinaryTree {
     public static Node root;
     public ProperBinaryTree() {
         root = null;
     }
 
     public void insert(int val) {
         if (root == null) {
             root = new Node(val);
             return;
         } else {
             Node current = root;
             while (true) {
                 if (current.data > val) {
                     if (current.left !=null) {
                         current = current.left;
                         continue;
                     } else {
                         current.left = new Node(val);
                         return;
                     }
                 }
                 if (current.data < val) {
                     if (current.right !=null) {
                         current = current.right;
                         continue;
                     } else {
                         current.right = new Node(val);
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
             System.out.print(root.data +  " , ");
             inorderTraversal(root.right);
         }
     }
     
     
     public boolean isProper(Node root) {
         if (root == null || (root.left == null && root.right == null)) {
             return true;
         } else {
             return (root.left != null && root.right!=null && isProper(root.left) && isProper(root.right));
         }
     }
     
     public boolean hasOneChildEach(Node root) { // check if every internal node has just 1 child
         if (root == null || (root.left == null && root.right == null)) {
             return true;
         } else {
             return (((root.left != null && root.right == null) || (root.right!=null && root.left ==null)) && hasOneChildEach(root.left) && hasOneChildEach(root.right));
         }
     }
     
     public boolean isComplete(Node root) { // every internal node has 2 children expect last level and in last level nodes must be left aligned
         if (root == null) {
             return true;
         } else {
             Queue<Node> q = new LinkedList<Node>();
             Node current = root;
             q.add(current);
             int incompleteNodes = 0;
             while(!q.isEmpty()) {
                 current = q.remove();
                 if (current.left == null && current.right!=null) {
                     return false;
                 }
                 if (current.right == null && current.left != null) {
                     incompleteNodes++;
                 }
                 if (incompleteNodes >=2 ) {
                     return false;
                 }
                 if (current.left != null) {
                     q.add(current.left);
                 }
                 if (current.right != null) {
                     q.add(current.right);
                 }
             }
             return true;
         }
     }
     
     
     
     
 
 
 
     public static void main(String[] args) {
         // TODO Auto-generated method stub
         ProperBinaryTree b = new ProperBinaryTree();
         b.insert(4);
         b.insert(2);
         b.insert(6);
         System.out.println("inorder traversal before doubling \n");
         b.inorderTraversal(root);
         System.out.println("Is this tree Proper \n" + b.isProper(root));
         
         Node n = new Node(6);
         n.left = new Node(7);
         n.left.right = new Node(8);
         
         System.out.println("check if every internal node has just 1 child \n" + b.hasOneChildEach(n));
         
         System.out.println("check if BT is complete \n" + b.isComplete(root));
         System.out.println("check if BT is complete \n" + b.isComplete(n));
         
     }

}
