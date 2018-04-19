package treessandtrees;
//https://leetcode.com/problems/binary-tree-pruning/description/
public class BTPrune {
    Node root;
    BTPrune() {
        root = null;
    }
    public void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + ", ");
        inorder(root.right);
    }
    
    
    public boolean prune(Node root, Node parent, boolean isLeft) {
        if (root == null)
            return false;
        else {
            boolean isOneOnLeft = prune(root.left, root, true);
            boolean isOneOnRight = prune(root.right, root, false);
            
            if (!isOneOnLeft && !isOneOnRight && parent!= null && root.data != 1) {
                if (isLeft) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
            if (root.data == 1) {
                return true;
            }
            return (isOneOnLeft || isOneOnRight);
            
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BTPrune obj = new BTPrune();
        obj.root = new Node(1);
        obj.root.left = new Node(0);
        obj.root.left.left = new Node(0);
        obj.root.left.right = new Node(1); // momo
        obj.root.right = new Node(0);
        obj.root.right.right = new Node(1);
        obj.root.right.left = new Node(0);
        obj.inorder(obj.root);
        System.out.println();
        obj.prune(obj.root, null, false);
        obj.inorder(obj.root);
        
        
    }

}
