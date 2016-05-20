package treesandmore;

public class Node {
    int data;
    Node left;
    Node right;
    public Node(int val){
       this.data = val;
       this.left = null;
       this.right = null;
    }
}

class BinarySearchTree{
    public static Node root;
    public BinarySearchTree() {
        this.root = null;
    }
    
    public void insert(int val) {
        Node newNode = new Node(val);
        if (root == null) {
            root = newNode;
            return;
        } else {
            Node current = root;
            while(true) {
                if (current.data > newNode.data) {
                    if (current.left != null) {
                        current = current.left;
                        continue;
                    } else {
                        current.left = newNode;
                        return;
                    }
                } else {
                    if (current.right != null) {
                        current = current.right;
                        continue;
                    } else {
                        current.right = newNode;
                        return;
                    }
                }
            }
        }
    }
    
    public void delete(Node root, int val) {
        if (root == null) {
            return;
        } else {
            Node parent = root;
            Node current = root;
            Boolean isLeft = false;
            // find location of parent and current target to be deleted.
            while(current.data != val && current!=null) {
                parent = current;
                current = (parent.data > val) ? parent.left : parent.right;
                if (parent.data > val) {
                    isLeft = true;
                } else {
                    isLeft = false;
                }
            }
            if (current == null) {
                return; // no node found.
            }
            // case 1 - node to be deleted is leaf node
            if (current.left == null && current.right == null) {
                if (isLeft) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            } else if (current.left == null && current.right != null) {
                if (isLeft) {
                    parent.left = current.right;
                } else {
                    parent.right = current.right;
                }
            } else if (current.left != null && current.right == null) {
                if (isLeft) {
                    parent.left = current.left;
                } else {
                    parent.right = current.left;
                }
            } else {
                // find smallest element in the tree where current is root
            }
        }
    }
    
    public Node find(Node root, int val) {
        Node current = root;
        while(current!=null) {
            if (current.data == val) {
                return current;
            } else if (current.data > val) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }
    
    public void preorderTraversal(Node root) {
        if (root!=null) {
            preorderTraversal(root.left);
            System.out.print(root.data + " | ");
            preorderTraversal(root.right);
        }
    }
    
    public void inorderTraversal(Node root) {
        if (root!=null) {
            System.out.print(root.data + " | ");
            inorderTraversal(root.left);
            inorderTraversal(root.right);
        }
    }
    
    public void postorderTraversal(Node root) {
        if (root!=null) {
            postorderTraversal(root.right);
            postorderTraversal(root.left);
            System.out.print(root.data + " | ");
        }
    }
    
    public static void main(String args[]) {
        BinarySearchTree b = new BinarySearchTree();
        b.insert(100);
        b.insert(81);
        b.insert(1200);
        b.insert(1400);
        System.out.println("\n----------Preorder Traversal-------------");
        b.preorderTraversal(root);
        System.out.println("\n----------InOrder Traversal-------------");
        b.inorderTraversal(root);
        System.out.println("\n----------Postorder Traversal-------------");
        b.postorderTraversal(root);
        Node findNode = b.find(root, 100);
        if (findNode!= null)
            System.out.println("\n----------Find a node-------------" + findNode.data);
        else
            System.out.println("\n----------Find a node - No Result found-------------");
       b.delete(root, 1200);
       System.out.println("\n----------Preorder Traversal after deletion-------------");
       b.preorderTraversal(root);
        
    }
}