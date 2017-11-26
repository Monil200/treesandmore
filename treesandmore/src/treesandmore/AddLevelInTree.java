package treesandmore;

public class AddLevelInTree {
    public Node root;
    
    public AddLevelInTree() {
        this.root= null;
    }
    
    public void insert(int val) {
        if (root == null) {
            root = new Node(val);
        } else {
            Node current = root;
            Node newNode = new Node(val);
            while(true) {
                if (current.data > val) {
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
    
    public void addLevel(Node root, int level, int targetLevel) {
        if (root == null) {
            return;
        } else {
            if (level < targetLevel -1) {
                addLevel(root.left,++level, targetLevel);
                addLevel(root.right, ++level, targetLevel);
            } else {
                
                Node temp = root.left;
                root.left = new Node(1);
                root.left.left = temp;
                
                temp = root.right;
                root.right = new Node(1);
                root.right.right = temp;
            }
        }
    }
    
    public void inorder(Node root)  {
        if (root == null) {
            return;
        } else {
            inorder(root.left);
            System.out.print(root.data +", " );
            inorder(root.right);
        }
    }
    
    public static void main(String args[]) {
        AddLevelInTree obj = new AddLevelInTree();
        obj.insert(4);
        obj.insert(2);
        obj.insert(6);
//        obj.inorder(obj.root);
        obj.addLevel(obj.root, 1, 3);
        System.out.println("Inorder after adding level");
        obj.inorder(obj.root);
    }
    
    
}
