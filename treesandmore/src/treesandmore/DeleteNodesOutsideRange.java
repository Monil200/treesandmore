package treesandmore;
import java.util.*;

public class DeleteNodesOutsideRange {
    public static Node root;
    public void DeleteNodesOutsideRange() {
        root = null;
    }
    public void insert(int val) {
        Node newNode = new Node(val);
        if (root == null) {
            root = newNode;
        } else {
            Node temp = root;
            while(true) {
                if (temp.data > val) {
                    if (temp.left!=null) {
                        temp = temp.left;
                        continue;
                    } else {
                        temp.left = newNode;
                        return;
                    }
                } else if (temp.data < val) {
                    if (temp.right!=null) {
                        temp = temp.right;
                        continue;
                    } else {
                        temp.right = newNode;
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
            System.out.println(root.data + " ");
            inorderTraversal(root.right);
        }
    }
    
    public void deleteNodesOutsideRange(Node root, int min, int max, Node parent, boolean isLeft, boolean isRoot) {
        root = DeleteNodesOutsideRange.root;
        if (root == null) {
            return;
        } else {
            if (isRoot) {
                if (root.data < min) {
                    System.out.println("Yead + " + root.data);
                    root = root.right;
                    deleteNodesOutsideRange(root, min, max, root, false,true);
                } else if (root.data > max) {
                    System.out.println("Yead + " + root.data);
                    root = root.left;
                    deleteNodesOutsideRange(root, min, max, root, false,true);
                }
            } else {
                if (root.data < min) {
                    if (isLeft)
                        parent.left = root.right;
                    else
                        parent.right = root.right;
                } else if (root.data > max) {
                    if (isLeft) {
                        parent.left = root.left;
                    } else {
                        parent.right = root.left; 
                    }
                }
                deleteNodesOutsideRange(root.left, min,max,root, true, false);
                deleteNodesOutsideRange(root.right, min,max,root, false, false);
            }
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DeleteNodesOutsideRange b = new DeleteNodesOutsideRange();
        b.insert(6);
        b.insert(-13);
        b.insert(-8);
        b.insert(14);
        b.insert(13);
        b.insert(15);
        b.insert(7);
        b.inorderTraversal(root);
        System.out.println("-------------");
        b.deleteNodesOutsideRange(root, -8, 10, root, false,true);
        b.inorderTraversal(root);
    }

}

