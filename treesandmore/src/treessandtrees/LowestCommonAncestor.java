package treessandtrees;

public class LowestCommonAncestor {
    public Node root;
    LowestCommonAncestor() {
        root = null;
    }
    public void insert(int val) {
        if (root == null)
            root = new Node(val);
        else {
            Node current = root;
            while(true) {
                if (current.data >= val) {
                    if (current.left!= null) {
                        current = current.left;
                    } else {
                        current.left = new Node(val);
                        break;
                    }
                } else {
                    if (current.right!= null) {
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
    
    public Node lcaRecursive(Node root, int a, int b) {
        if (root == null) {
            return null;
        } else {
            if (root.data == a || root.data == b)
                return root;
            
            Node l = lcaRecursive(root.left, a,b);
            Node r = lcaRecursive(root.right, a,b);
            
            if (l != null && r != null) {
                return root;
            }
            return (l != null) ? l : r;
                        
        }
                   
    }
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LowestCommonAncestor obj = new LowestCommonAncestor();
        obj.insert(4);
        obj.insert(2);
        obj.insert(1);
        obj.insert(3);
        obj.insert(6);
        obj.insert(5);
        obj.insert(7);
        System.out.println("LCA of 2 numbers is " + obj.lcaRecursive(obj.root, 1,3).data);
        obj.inorder(obj.root);
    }

}
