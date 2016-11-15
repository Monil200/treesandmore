package treesandmore;

public class SumAllGreaterValueNodesBST {
    
    Node root;
    int sum = 0;
    public SumAllGreaterValueNodesBST() {
        this.root = null;
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
                        current= current.left;
                    } else {
                        current.left = newNode;
                        break;
                    }
                } else {
                    if (current.right != null) {
                        current= current.right;
                    } else {
                        current.right = newNode;
                        break;
                    }
                }
            }
        }
    }
    
    public void inorder(Node root) {
        if (root == null) {
            return;
        } else {
            inorder(root.left);
            System.out.print(root.data + ",");
            inorder(root.right);
        }
    }
    
    public void sumAllGreatervalueNode(Node root) {
        if (root == null) {
            return;
        } else {
            sumAllGreatervalueNode(root.right);
            int temp = root.data;
            root.data = sum;
            sum = temp + sum;
            sumAllGreatervalueNode(root.left);
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SumAllGreaterValueNodesBST obj = new SumAllGreaterValueNodesBST();
        obj.insert( 4);
        obj.insert( 2);
        obj.insert( 6);
        obj.inorder(obj.root);
        
        
        obj.sumAllGreatervalueNode(obj.root);
        System.out.println();
        obj.inorder(obj.root);
    }

}
