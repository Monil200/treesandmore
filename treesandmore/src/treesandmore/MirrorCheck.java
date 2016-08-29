package treesandmore;
import java.util.*;

public class MirrorCheck {
    
    
    public void insert(Node root,int val) {
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
            System.out.print(root.data + ",");
            inorderTraversal(root.right);
        }
    }
    
    public boolean isMirror(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else {
            return (root1!=null && root2!=null &&
                    root1.data == root2.data &&
                    isMirror(root1.left, root2.right) && 
                    isMirror(root1.right, root2.left)
           );
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // tree 1
        Node node1 = new Node(4);
        MirrorCheck bst = new MirrorCheck();
        bst.insert(node1,2);
        bst.insert(node1,1);
        bst.insert(node1,3);
        
        // tree 2
        Node node2 = new Node(4);
//        MirrorCheck bst1 = new MirrorCheck();
        node2.right = new Node(2);
        node2.right.left = new Node(3);
        node2.right.right = new Node(1);
        
        System.out.println("------TREE1-------");
        bst.inorderTraversal(node1);
        System.out.println("\n------TREE2-------");
        bst.inorderTraversal(node2);
        System.out.println(bst.isMirror(node1, node2));
        
        // tree 3, to check if tree is similar- using only one tree
        Node node3 = new Node(4);
//      MirrorCheck bst1 = new MirrorCheck();
      node3.right = new Node(2);
      node3.right.left = new Node(3);
      node3.right.right = new Node(1);
      
      node3.left = new Node(2);
      node3.left.left = new Node(1);
      node3.left.right = new Node(3);
      System.out.println("\n------TREE3-------");
      System.out.println(bst.isMirror(node3.left, node3.right));

    }

}

