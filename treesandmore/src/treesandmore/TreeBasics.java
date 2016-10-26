package treesandmore;
import java.util.*;

public class TreeBasics {
    public static Node root;
    
    public TreeBasics() {
        root = null;
    }
    
    public void insert(int val) {
        if (root == null) {
            root = new Node(val);
        } else {
            Node current = root;
            Node newNode = new Node(val);
            while(true) {
                if (current.data > val) {
                    if (current.left !=null) {
                        current = current.left;
                    } else {
                        current.left = newNode;
                        break;
                    }
                } else {
                    if (current.right!=null) {
                        current = current.right;
                    } else {
                        current.right = newNode;
                        break;
                    }
                }
            }
        }
    }
    
    public void inorderTraversal(Node root){
        if (root == null) {
            return;
        } else {
            inorderTraversal(root.left);
            System.out.print(root.data + ",");
            inorderTraversal(root.right);
        }
    }
    public int size(Node root) {
        if (root == null) {
            return 0;
        } else {
            return (1 + size(root.left) + size(root.right));
        }
    }
    
    public int height(Node root) { //maxDepth
        if (root == null) {
            return 0;
        } else {
            int ldepth = height(root.left);
            int rdepth = height(root.right);
            
            if (ldepth >= rdepth) {
                return ldepth+1;
            } else {
                return rdepth+1;
            }
        }
    }
    
    public boolean isMirror(Node leftChild, Node rightChild) {
        if (leftChild == null && rightChild == null) {
            return true;
        } else {
            return (leftChild.data == rightChild.data 
                    && isMirror(leftChild.left, rightChild.right) 
                    && isMirror(leftChild.right, rightChild.left));
        }
    }
    
    public boolean isBSTv1(Node root) {
        if (root == null) {
            return true;
        } else {
            boolean isLeftOk = false;
            boolean isRightOk = false;
            if (root.left != null) {
                isLeftOk = root.data > root.left.data; 
            } else {
                isLeftOk = true;
            }
            if (root.right != null) {
                isRightOk = root.data < root.right.data; 
            } else {
                isRightOk = true;
            }
            return (isLeftOk && isRightOk && isBSTv1(root.left) && isBSTv1(root.right));
        }
    }
    
    public boolean isBSTv2(Node root, int min, int max) {
        if (root == null) {
            return true;
        } else {
            return (root.data > min && root.data<max && isBSTv2(root.left, min, root.data) && isBSTv2(root.right, root.data, max));
        }
    }
    
    public void findKthElement(Node root, int k) {
        if (root == null) {
            return;
        } else {
            int size = size(root.left);
            if (size == k -1) {
                System.out.println(" The kth  element is:" + root.data);
            } else if (size > k) {
                findKthElement(root.left, k);
            } else {
                findKthElement(root.right, k - size - 1);
            }
        }
    }
    
    public void generateMirror(Node root) {
        if (root == null) {
            return;
        } else {
            Node left = root.left != null ? root.left : null;
            Node right = root.right != null ? root.right : null;
            root.left = right;
            root.right = left;
            generateMirror(root.left);
            generateMirror(root.right);
        }
    }
    
    public void printPaths(Node root, ArrayList<Node> paths) {
        if (root == null) {
            return;
        } else {
            paths.add(root);
            if (root.left == null && root.right == null) { // print them
                for(Node temp : paths) {
                    System.out.print(temp.data + ",");
                }
                System.out.println();
            } else {
                printPaths(root.left, new ArrayList<Node>(paths));
                printPaths(root.right, new ArrayList<Node>(paths));
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeBasics obj = new TreeBasics();
        obj.insert(4);
        obj.insert(2);
        obj.insert(6);
        obj.insert(8);
        System.out.println("--------Inorder traversal------");
        obj.inorderTraversal(root);
        System.out.println("\n--------Size------: " + obj.size(root));
        System.out.println("\n--------Max Depth------: " + obj.height(root));
        
        // new BT;
        Node n = new Node(1);
        n.left = new Node(2);
        n.right = new Node(2);
        n.left.left = new Node(3);
        n.left.right = new Node(4);
        n.right.left = new Node(4);
        n.right.right = new Node(3);
        // n.right.right = new Node(4); use this to make it false
        System.out.println("\n--------Is Mirror------: " + obj.isMirror(n.left,n.right));
        
        // is BST V1
        System.out.println("\n--------Is BST V1------: " + obj.isBSTv1(root));
        System.out.println("\n--------Is BST V1------: " + obj.isBSTv1(n)); // not a bst
        
        // is BST v2
        System.out.println("\n--------Is BST V2------: " + obj.isBSTv2(root, -1000, 1000));
        System.out.println("\n--------Is BST V2------: " + obj.isBSTv2(n, -1000, 1000)); // not a bst
        
        // kth element
        System.out.println("\n--------Kth element is ------: ");
        obj.findKthElement(root, 4);
        
        // generate mirror
        System.out.println("Inorder traversal before");
        obj.inorderTraversal(root);
        obj.generateMirror(root);
        System.out.println("\n Inorder traversal after:");
        obj.inorderTraversal(root);
        
        // print all root to leaf paths
        System.out.println("\n Print all root to leaf paths");
        obj.printPaths(root, new ArrayList<Node>());
    }

}
