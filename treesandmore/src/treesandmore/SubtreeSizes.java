package treesandmore;

class NodeSize extends Node {
    NodeSize left;
    NodeSize right;
    int size;
    public NodeSize(int val) {
        super(val);
        this.left = null;
        this.right = null;
        this.size = -1;
    }
}
public class SubtreeSizes {
    NodeSize root;
    public SubtreeSizes() {
        this.root = null;
    }
    public void insert(int val) {
        if (this.root == null) {
            this.root = new NodeSize(val);
        } else {
            NodeSize current = this.root;
            while(true) {
                if (current.data > val) {
                    if (current.left != null) {
                        current = current.left;
                    } else {
                        current.left = new NodeSize(val);
                        break;
                    }
                } else {
                    if (current.right != null) {
                        current = current.right;
                    } else {
                        current.right = new NodeSize(val);
                        break;
                    }
                }
            }
        }
    }
    
    public int memoizedSizes(NodeSize root) {
        if (root == null) {
            return 0;
        } else {
            root.size = 1 + memoizedSizes(root.left) + memoizedSizes(root.right);
            return root.size;
        }
        
    }
    
    public boolean isBalanced(NodeSize root) {
        if (root == null) {
            return true;
        } else {
            int left, right;
            if (root.left != null)
                left = root.left.size;
            else 
                left = 0;
            if (root.right != null)
                right = root.right.size;
            else 
                right = 0;
            return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }
    
    
    public void inorderTraversal(NodeSize root) {
        if (root == null) {
            return;
        } else {
            inorderTraversal(root.left);
            System.out.print(root.data +  " , ");
            inorderTraversal(root.right);
        }
    }
    
    public void inorderTraversalSize(NodeSize root) {
        if (root == null) {
            return;
        } else {
            inorderTraversalSize(root.left);
            System.out.print(root.size +  " , ");
            inorderTraversalSize(root.right);
        }
    }
    public static void main(String args[]) {
        SubtreeSizes obj = new SubtreeSizes();
        
        
        obj.insert(4);
        obj.insert(2);
        obj.insert(1);
        obj.insert(3);
        obj.insert(6);
        obj.insert(5);
        obj.insert(8);
        System.out.println("\n size of tree :" + obj.memoizedSizes(obj.root));
        obj.inorderTraversalSize(obj.root);
        System.out.println("\n Is balanced :" + obj.isBalanced(obj.root));
    }
}
