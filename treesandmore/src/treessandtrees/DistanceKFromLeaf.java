package treessandtrees;
public class DistanceKFromLeaf {
    public Node root;
    DistanceKFromLeaf() {
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
    
    public int distanceKFromLeaf(Node root, int k) {
        if (root == null) {
            return 0 ;
        } else {
            int l = distanceKFromLeaf(root.left, k) + 1;
            int r = distanceKFromLeaf(root.right, k) + 1;
            
            if (l==k || r==k) {
                System.out.print(root.data+ ", ");
            }
            return (l<=k) ? l : r; 
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DistanceKFromLeaf obj = new DistanceKFromLeaf();
        obj.insert(4);
        obj.insert(2);
        obj.insert(1);
        obj.insert(3);
        obj.insert(6);
        obj.insert(5);
        obj.insert(7);
        System.out.println("---------Inorder--------");
        obj.inorder(obj.root);
        System.out.println("---------Distance k from root--------");
        obj.distanceKFromLeaf(obj.root,3);
    }

}
