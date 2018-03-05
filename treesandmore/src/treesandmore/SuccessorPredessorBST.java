package treesandmore;

public class SuccessorPredessorBST {
    Node root;
    SuccessorPredessorBST() {
        root = null;
    }
    public void insert(int val) {
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
    
    public void getPredecessor(Node root, int target, int predecessor) { // get largest Node smaller than target
        // when making right turn, note down the node
        if (root == null) {
            return;
        } else {
            if (root.data == target) {
                System.out.println("Predecessor is:" + predecessor);
                return;
            }
            if (root.data > target) {
                getPredecessor(root.left, target,predecessor);
            } else if (root.data < target) {
                predecessor = root.data;
                getPredecessor(root.right, target, predecessor);
            }
        }
    }
    
    public void getSuccessor(Node root, int target, int successor) { // get Smallest Node greater than target
        if (root == null) {
            return;
        } else {
            if (root.data == target) {
                System.out.println("Predecessor is:" + successor);
                return;
            }
            if (root.data > target) {
                successor = root.data;
                getSuccessor(root.left, target,successor);
            } else if (root.data < target) {
                getSuccessor(root.right, target, successor);
            }
        }
    }
    public void inorder(Node root) {
        if (root == null)
            return;
        else {
            inorder(root.left);
            System.out.print(root.data + ", ");
            inorder(root.right);
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SuccessorPredessorBST obj= new SuccessorPredessorBST();
        obj.insert(4);
        obj.insert(2);
        obj.insert(1);
        obj.insert(3);
        obj.insert(6);
        obj.insert(5);
        obj.insert(7);
        obj.inorder(obj.root);
        System.out.println();
        
        obj.getPredecessor(obj.root, 3, -1);
        obj.getSuccessor(obj.root, 3, -1);
    }

}
