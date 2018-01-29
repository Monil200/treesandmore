package treessandtrees;

public class MaxDepthOfBST {
    int maxDepth, minDepth;
    Node root;
    MaxDepthOfBST() {
        root = null;
        maxDepth =Integer.MIN_VALUE;
        minDepth =Integer.MAX_VALUE;
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
    
    public int getMaxDepth(Node root) {
        if (root == null) {
            return 0;
        } else {
            int left = getMaxDepth(root.left);
            int right = getMaxDepth(root.right);
            int depth = left+right + 1;
            if (depth > maxDepth) {
                maxDepth = depth;
            }
            return Math.max(left, right) +1;
        }
    }
    /*
     * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
     */
    public void getMinDepth(Node root, int level) {
        if (root == null) {
            return;
        } else {
            getMinDepth(root.left, 1+level);
            getMinDepth(root.right, 1+level);
            
            if (root.left == null && root.right == null) {
                if (minDepth > level) {
                    minDepth= level;
                }
            }
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
        MaxDepthOfBST obj = new MaxDepthOfBST();
        obj.insert(15);
        obj.insert(2);
        obj.insert(1);
        obj.root.left.right = new Node(20);
        obj.root.right = new Node(8);
        obj.inorder(obj.root);
        
        obj.getMaxDepth(obj.root);
        System.out.println("Max depth is: " + obj.maxDepth);
        
        
        obj.getMinDepth(obj.root, 1);
        System.out.println("Min depth is: " + obj.minDepth);
        
        
    }

}
