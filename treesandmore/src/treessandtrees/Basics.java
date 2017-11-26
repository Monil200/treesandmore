package treessandtrees;

import java.util.*;

class Node {
    int data;
    Node left,right;
    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}
public class Basics {
    public Node root;
    public Basics() {
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
    public void preorder(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + ", ");
        preorder(root.left);
        preorder(root.right);
    }
    public void postorder(Node root) {
        if (root == null)
            return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + ", ");
    }
    
    // height
    public int height(Node root) {
        if(root == null)
            return 0;
        else {
            int hl = height(root.left) + 1;
            int hr = height(root.right) + 1;
            
            return Math.max(hl, hr);
        }
    }
    // size
    public int size(Node root) {
        if(root == null)
            return 0;
        else {
            return 1 + size(root.left) + size(root.right);
        }
    }
    
    // root to leaf paths
    public void rootToLeafPaths(Node root, int currSum) {
        if (root == null)
            return;
        else {
            currSum += root.data;
            if (root.left == null & root.right == null) {
                System.out.println("Path sum is : " + currSum);
            }
            rootToLeafPaths(root.left, currSum);
            rootToLeafPaths(root.right, currSum);
        }
    }
    // mirror A tree
    public void mirrorATree(Node root) {
        if (root == null || (root.left == null && root.right == null))
            return;
        else {
            mirrorATree(root.left);
            mirrorATree(root.right);
            
            Node temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
    }
    // double A tree
    public void doubleATree(Node root) {
        if (root == null)
            return;
        else {
            doubleATree(root.left);
            doubleATree(root.right);
            Node clone = new Node(root.data);
            if (root.left != null) {
                Node temp = root.left;
                root.left = clone;
                clone.left = temp;
            } else {
                root.left = clone;
            }
        }
    }
        
    //  isBST v1
    public boolean isBSTV1(Node root, int min, int max) {
        if (root == null) {
            return true; 
        } else {
            return (root.data > min && root.data <= max && isBSTV1(root.left, min, root.data) && isBSTV1(root.right, root.data, max));  
        }
    }
    
    // level order traversal
    public void levelOrder(Node root) {
        if (root == null)
            return;
        else {
            Queue<Node> q = new LinkedList<Node>();
            Node current = root;
            q.add(current);
            while(!q.isEmpty()) {
                current = q.remove();
                System.out.print(current.data + ", ");
                if (current.left != null) {
                    q.add(current.left);
                }
                if (current.right != null) {
                    q.add(current.right);
                }
            }
        }
    }
    
    // spiral order traversal
    public void spiralOrder(Node root) {
        if (root == null)
            return;
        else {
            Stack<Node> s1 = new Stack<Node>();
            Stack<Node> s = new Stack<Node>();
            Node current = root;
            s1.add(current);
            while(!s1.isEmpty() || !s.isEmpty()) {
                while(!s1.isEmpty()) {
                    current = s1.pop();
                    System.out.print(current.data + ", ");
                    if (current.left != null) {
                        s.add(current.left);
                    }
                    if (current.right != null) {
                        s.add(current.right);
                    }
                }
                while(!s.isEmpty()) {
                    current = s.pop();
                    System.out.print(current.data + ", ");
                    if (current.right != null) {
                        s1.add(current.right);
                    }
                    if (current.left != null) {
                        s1.add(current.left);
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Basics obj = new Basics();
        obj.insert(4);
        obj.insert(2);
        obj.insert(1);
        obj.insert(3);
        obj.insert(6);
        obj.insert(5);
        obj.insert(7);
        System.out.println("---------Inorder--------");
        obj.inorder(obj.root);
        System.out.println("\n---------preorder--------");
        obj.preorder(obj.root);
        System.out.println("\n---------postorder--------");
        obj.postorder(obj.root);
        System.out.println("\n---------height--------:" + obj.height(obj.root));
        System.out.println("---------Size----------:" + obj.size(obj.root));
        System.out.println("\n---------Root to leaf paths Sum--------");
        obj.rootToLeafPaths(obj.root, 0);
//        System.out.println("\n---------After Mirroring--------");
//        obj.mirrorATree(obj.root);
//        obj.inorder(obj.root);
//        System.out.println("\n---------After Doubling--------");
//        obj.doubleATree(obj.root);
//        obj.inorder(obj.root);
        System.out.println("\n---------is BST v1--------? : " + obj.isBSTV1(obj.root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println("\n---------Level order--------");
        obj.levelOrder(obj.root);
        System.out.println("\n---------Spiral order Traversal--------");
        obj.spiralOrder(obj.root);
    }

}
