package toD;

import java.util.*;

class Node {
    int data;
    Node left,right;
    Node(int val) {
        data = val;
    }
}
public class TreesAll {
    Node root;
    TreesAll() {
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
        System.out.print(root.data + ",");
        inorder(root.right);
    }
    
    public int getSize(Node root) {
        if (root == null) {
            return 0;
        } else {
            return getSize(root.left) + getSize(root.right) + 1; 
        }
    }
    
    public int getHeight(Node root) {
        if (root == null) {
            return 0;
        } else {
            int left = getHeight(root.left) +1;
            int right = getHeight(root.right) +1;
            
            return Math.max(left, right);
        }
    }
    
    public boolean isBST(Node root) {
        if (root == null) {
            return true;
        } else {
            boolean isLeftOk = (root.left != null) ? root.data >= root.left.data : true;
            boolean isRightOk = (root.right != null) ? root.data < root.right.data : true;
            return isLeftOk && isRightOk && isBST(root.left) && isBST(root.right);
        }
    }
    
    public void iterativeInorder(Node root) {
        if (root == null)
            return;
        else {
            Stack<Node> s = new Stack<Node>();
//            s.add(root);
            Node current = root;
            while(!s.isEmpty() || current!= null) {                                                                                                                                                                     
                if (current != null) {
                    s.add(current);
                    current = current.left;
                } else {
                    current = s.pop();
                    System.out.print(current.data+ ",");
                    current= current.right;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreesAll obj = new TreesAll();
        obj.insert(4);
        obj.insert(2);
        obj.insert(1);
        obj.insert(3);
        obj.insert(6);
        obj.insert(5);
        obj.insert(7);
        obj.inorder(obj.root);
        System.out.println();
        
        System.out.println("Size:" + obj.getSize(obj.root));
        System.out.println("Height:" + obj.getHeight(obj.root));
        System.out.println("IS BST?:" + obj.isBST(obj.root));
        System.out.println("Iterative inorder:");
        obj.iterativeInorder(obj.root);
        
    }

}
