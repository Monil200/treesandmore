package treesandmore;

public class DeletANode {
    Node root;
    public DeletANode() {
        this.root = null;
    }
    public void insert(int n) {
        if (root == null) {
            root = new Node(n);
        } else {
            Node current = root;
            Node newNode = new Node(n);
            while(true) {
                if (current.data > n) {
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
    
    public void inorderTraversal(Node root) {
        if (root == null) {
            return;
        } else {
            inorderTraversal(root.left);
            System.out.print(root.data + ",");
            inorderTraversal(root.right);
        }
    }
    
    public void deleteNode(Node root, int target, Node parent, boolean isLeft) {
        if (root == null) {
            return;
        } else {
            deleteNode(root.left, target, root, true);
            deleteNode(root.right, target, root, false);
            
            if (root.data == target) {
                // case 1:
                if (root.left == null && root.right == null) {
                    if (isLeft) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                    return;
                } else if((root.left == null && root.right != null) || (root.right == null && root.left != null)) {
                    if (root.left == null) {
                        if (isLeft)
                            parent.left.data = getMin(root.right);
                        else {
                            parent.right.data = getMin(root.right);
                        }
                    } else if (root.right == null) {
                        if (isLeft) {
                            parent.left.data = getMax(root.left); // here
                        } else {
                            parent.right.data = getMax(root.left);
                        }
                    }
                } else if (root.left != null && root.right!= null) {
                    if (isLeft) {
                        parent.left.data = getMax(root.left); // can do 
                    } else {
                        parent.left.data = getMin(root.right); // can do
                    }
                }
            }
         }
    }
    
    int getMin(Node root) {
        if (root == null) {
            return -1;
        } else {
            if (root.left == null && root.right == null) {
                int temp = root.data;
                root = null;
                return temp;
            }
            Node prev = root;
            while(root.left!=null) {
                prev = root;
                root = root.left;
            }
            prev.left = null;
            return root.data;
            
        }
    }
    
    int getMax(Node root) {
        if (root == null) {
            return -1;
        } else {
            if (root.left == null && root.right == null) {
                int temp = root.data;
                root = null;
                return temp;
            }
            Node prev= root;
            while(root.right!=null) {
                prev = root;
                root = root.right;
            }
            prev.right = null;
            return root.data;
            
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DeletANode obj = new DeletANode();
        obj.insert(4);
        obj.insert(2);
        obj.insert(1);
        obj.insert(8);
        obj.insert(6);
        obj.insert(7);
        obj.inorderTraversal(obj.root);
        obj.deleteNode(obj.root, 2, null, false);
        System.out.println("\n After deletion");
        obj.inorderTraversal(obj.root);
    }

}
