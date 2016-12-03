package postbuilding42;
class Node {
    int data;
    Node left;
    Node right;
    public Node(int val) {
        data = val;
    }
}
public class TreesBasics {
    Node root;
    public TreesBasics() {
        
    }
    
    public void insert(int val) {
        if (root == null) {
            root = new Node(val);
        } else {
            Node newNode = new Node(val);
            Node current = root;
            while(true) {
                if (current.data > val) {
                    if (current.left != null) {
                        current = current.left;
                    } else {
                        current.left = newNode;
                        return;
                    }
                } else {
                    if (current.right != null) {
                        current = current.right;
                    } else {
                        current.right = newNode;
                        return;
                    }
                }
            }
        }
    }
    
    public int size(Node root) {
        if (root == null) {
            return 0;
        } else {
            return size(root.left) + size(root.right)  +1;
        }
    }
    
    public int height(Node root) {
        if (root == null) {
            return 0;
        } else {
            int ldepth = height(root.left);
            int rdepth = height(root.right);
            if (ldepth >= rdepth)
                return ldepth +1;
            else {
                return rdepth +1;
            }
        }
    }
    
    public void inorderTraversal(Node root) {
        if (root == null)
            return;
        inorderTraversal(root.left);
        System.out.print(root.data + "," );
        inorderTraversal(root.right);
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreesBasics obj = new TreesBasics();
        obj.insert(4);
        obj.insert(2);
        obj.insert(6);
        obj.insert(3);
        obj.insert(1);
        System.out.println("\n The inorder traversal is");
        obj.inorderTraversal(obj.root);
        System.out.println("\n The size is: " + obj.size(obj.root));
        System.out.println("\n The height is: " + obj.height(obj.root));
    }

}
