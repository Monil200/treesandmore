package treesandmore;
/*
 * Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
 */

import java.util.*;
public class BinaryTreeToSingleLL {
    
    Node root;
    public void insert(int val) {
        if (root == null) {
            root = new Node(val);
        } else {
            Node current = root;
            Node newNode = new Node(val);
            while(true) {
                if (current.data > val) {
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
    
    public void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + ",");
        inorder(root.right);
    }
    
    public void flattenBT(Node root) {
        if(root == null)
            return;
        else {
            Stack<Node> s = new Stack<Node>();
            Node current = root;
            Node prev = null;
            while(current!= null || !s.isEmpty()) {
                if (current == null) {
                    prev.left = s.pop();
                    current = prev.left;
                } else {
                    if (current.right!= null) {
                        s.push(current.right);
                        current.right = null;
                    }
                    prev = current;
                    current = current.left;
                }
            }
        }
    }
    
    public void traverseSingleLL(Node root) {
        Node current = root;
        while(current!=null) {
            System.out.print(current.data + ",");
            current = current.left;
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BinaryTreeToSingleLL obj = new BinaryTreeToSingleLL();
        obj.insert(5);
        obj.insert(2);
        obj.insert(1);
        obj.insert(3);
        obj.insert(4);
        obj.insert(8);
        obj.insert(7);
        obj.insert(6);
        obj.insert(9);
        
        obj.flattenBT(obj.root);
        System.out.print("after flattening");
        obj.traverseSingleLL(obj.root);
    }
}
