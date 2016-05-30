package treesandmore;

// Deepest Left child
class ResultData{
    int deepestLevel;
    public ResultData(int level) {
        this.deepestLevel = level; 
    }
}

public class DeepestLeft {
    public static Node root;
    public DeepestLeft() {
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
    
    public void deepestLeftChild(Node root, int level, Boolean isLeft, ResultData result) {
        if (root == null) {
            return;
        } else {
            if (level > result.deepestLevel && isLeft) {
                if (level > result.deepestLevel) {
                    result.deepestLevel = level;
                }
            }
            deepestLeftChild(root.left, level +1, true, result);
            deepestLeftChild(root.right, level +1, false, result);
        }
        
    }
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DeepestLeft b = new DeepestLeft();
        ResultData result = new ResultData(0);
        b.insert(4);
        b.insert(2);
        b.insert(6);
        b.insert(1);
        b.insert(3);
        b.insert(5);
        b.insert(7);
        b.insert(0);
        b.insert(-1);
        //           4
        //         /   \
        //        2     6
        //       / \   / \
        //      1   3 5   7
        b.preOrderTraversal(root);
        System.out.println();
        b.deepestLeftChild(root, 1 , false, result);
        System.out.println(result.deepestLevel);
    }

}
