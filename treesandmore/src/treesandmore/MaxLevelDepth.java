package treesandmore;

// Find max nodes on a particular level in BST. O(n^2). BUt can store in array the node count of particular level in array.
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

public class MaxLevelDepth {
    public static Node root;
    public MaxLevelDepth() {
        root = null;
    }
    
    public void insert(int val) {
        if (root == null) {
            root = new Node(val);
            return;
        } else {
            Node current = root;
            while (true) {
                if (current.data > val) {
                    if (current.left !=null) {
                        current = current.left;
                        continue;
                    } else {
                        current.left = new Node(val);
                        return;
                    }
                }
                if (current.data < val) {
                    if (current.right !=null) {
                        current = current.right;
                        continue;
                    } else {
                        current.right = new Node(val);
                        return;
                    }
                }
            }
        }
    }
    public void preOrderTraversal(Node root) {
        if (root == null) {
            return;
        } else {
            preOrderTraversal(root.left);
            System.out.print(root.data +  " , ");
            preOrderTraversal(root.right);
        }
    }
    
    public int height(Node root) {
        if (root == null) {
            return 0;
        } else {
            int ldepth = height(root.left);
            int rdepth = height(root.right);
            if (ldepth >= rdepth) {
                return ldepth+1;
            } else {
                return rdepth+1;
            }
        }
    }
    
    public int maxWidth(Node root) {
        if (root == null) {
            return 0;
        } else {
            int height = height(root);
            int maxDepth = 0, currentDepth = 0;
            for (int i=1;i<=height;i++) {
                currentDepth = getWidth(root, i);
                System.out.println("level:" + i + " nodes:" + currentDepth);
                if (currentDepth > maxDepth) {
                    maxDepth = currentDepth;
                }
            }
            return maxDepth;
        }
    }
    
    public int getWidth(Node root, int level) {
        if (root == null) {
            return 0;
        }
        if (level == 0) {
            return 1;
        } else {
            return (getWidth(root.left, level-1) + getWidth(root.right, level-1));
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MaxLevelDepth b = new MaxLevelDepth();
        b.insert(4);
        b.insert(2);
        b.insert(6);
        b.insert(1);
        b.insert(3);
        b.insert(5);
        b.insert(7);
        b.preOrderTraversal(root);
        System.out.println("Max nodes on a particular level is");
        System.out.println(b.maxWidth(root));
    }

}
