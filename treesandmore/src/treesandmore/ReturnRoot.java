package treesandmore;


//class Node {
//    int data;
//    Node left;
//    Node right;
//    public Node(int val) {
//        this.data = val;
//        this.left = null;
//        this.right = null;
//    }
//}
public class ReturnRoot {
    public static Node root;
    
    public ReturnRoot() {
        root = null;
    }
    
    public void insert(int val) {
        if (root == null) {
            root = new Node(val);
        } else {
            Node newNode = new Node(val);
            Node current = root;
            while(true) {
                if (current.data > newNode.data) {
                    if (current.left!=null) {
                        current = current.left;
                        continue;
                    } else {
                        current.left = newNode;
                        break;
                    }
                }  else {
                    if (current.right!=null) {
                        current = current.right;
                        continue;
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
    
    public void getRooTOfTarget(Node root, int target, Node parent) {
        if (root == null) {
            // make this null return a possible parent;
            System.out.println("\n Possible parent: " + parent.data);
            return;
        } else {
            if (root.data == target) {
                System.out.println("\n The root of the target:" + target + " is " + parent.data);
                return;
            }
            if (root.data > target) {
                parent = root;
                getRooTOfTarget(root.left, target, parent);
            } else {
                parent = root;
                getRooTOfTarget(root.right, target, parent);
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ReturnRoot obj = new ReturnRoot();
        obj.insert(4);
        obj.insert(2);
        obj.insert(6);
        obj.insert(8);
        obj.inorderTraversal(root);
        obj.getRooTOfTarget(root, 10, root); // possible parent
        obj.getRooTOfTarget(root, 8, root);
    }

}
