package treesandmore;

import java.util.*;

public class LowestCommonAncestor {
    
    public static Node root;
    
    public LowestCommonAncestor() {
        root = null;
    }
    
    public void insert (int val) {
        if (root == null) {
            root = new Node(val); 
        } else {
            Node current = root;
            while(true) {
                if (current.data > val) {
                    if (current.left != null) {
                        current = current.left;
                    } else {
                        current.left = new Node(val);
                        return;
                    }
                } else {
                    if (current.right != null) {
                        current = current.right;
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
            System.out.print(root.data + ",");
            inorderTraversal(root.right);
        }
    }
    
    public List<Node> getAllAncestors(Node root, int t, ArrayList<Node> al) {
        if (root == null) {
            return null;
        } else {
            List<Node> ancestor = al;
            if (root.data == t) {
                return ancestor;
            }
            ancestor.add(root);
            if (root.data > t) {
                return getAllAncestors(root.left, t, new ArrayList<Node>(ancestor));
            } else {
                return getAllAncestors(root.right, t, new ArrayList<Node>(ancestor));
            }
        }
    }
    
    // considering args are in format (lower value, higher value) as arguments
    public Node lowestCommonAncestorinBST(Node root, int a, int b, Node parent) {
        if (root == null) {
            return null;
        } else {
            if (root.data >= a && root.data <= b) {
                return root;
            }
            if (root.data > a && root.data < b) {
                return parent;
            } else if(root.data > a && root.data > b) {
                return lowestCommonAncestorinBST(root.left, a, b, root);
            } else {
                return lowestCommonAncestorinBST(root.right, a, b, root);
            }
        }
    }
    
    public Node lcaRecursive(Node root, int a, int b) {
        if (root == null) {
            return null;
        } else {
            if (root.data == a || root.data == b) {
                return root;
            }
            
            Node lNode = lcaRecursive(root.left, a,b);
            Node rNode = lcaRecursive(root.right, a,b);
            
            if (lNode != null && rNode != null) {
                return root;
            }
            return (lNode !=null) ? lNode : rNode;
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LowestCommonAncestor bst = new LowestCommonAncestor();
        bst.insert(4);
        bst.insert(2);
        bst.insert(6);
        bst.insert(1);
        bst.inorderTraversal(root);
        System.out.println();
        List<Node> ancestors1 = new ArrayList<Node>();
        ancestors1 = bst.getAllAncestors(root, 1, new ArrayList<Node>());
        List<Node> ancestors2 = new ArrayList<Node>();
        ancestors2 = bst.getAllAncestors(root, 6, new ArrayList<Node>());
        Iterator<Node> i1 = ancestors1.iterator();
        Iterator<Node> i2 = ancestors2.iterator();
        System.out.println("LCA are:");
        while(i1.hasNext() && i2.hasNext()) {
            int temp1 = i1.next().data;
            int temp2 = i2.next().data;
            if (temp1 == temp2) {
                System.out.print(temp1 + ",");
            } else {
                break;
            }
        }
        System.out.println("\nLCA in BST:" + bst.lowestCommonAncestorinBST(root, 2, 6, root).data);
        System.out.println("\nLCA in BST Recursive:" + bst.lcaRecursive(root, 1, 6).data);
    }

}
