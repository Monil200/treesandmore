package treessandtrees;

public class ReconstructBST {
    Node first,current,last, root;
    ReconstructBST() {
        first= current= last = null;
    }
    public void insert(int val) {
        if (root == null) {
            root = new Node(val);
        } else {
            Node current = root;
            Node newNode = new Node(val);
            while(true) {
                if (current.data >= val) {
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
    
    public void reconstruct(Node root, Node prev) {
        if (root == null)
            return;
        else {
            reconstruct(root.left, root);
            if (current != null && root.data < current.data && first== null) {
                first = current;
            }
            current = root;
            if (prev!=null && root.data < prev.data && first!= null) {
                last = root;
            }
            reconstruct(root.right, root);
        }
    }
    public void inorder(Node root) {
        if (root == null)
            return;
        else {
            inorder(root.left);
            System.out.print(root.data + ",");
            inorder(root.right);
        }
    }
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ReconstructBST obj = new ReconstructBST();
        obj.insert(15);
        obj.insert(2);
        obj.insert(1);
        obj.root.left.right = new Node(20);
        obj.root.right = new Node(8);
        obj.inorder(obj.root);
        
        obj.reconstruct(obj.root, null);
        
        System.out.println("first:" + obj.first.data + " current:" + obj.current.data + " last:" + obj.last.data);
    }

}
