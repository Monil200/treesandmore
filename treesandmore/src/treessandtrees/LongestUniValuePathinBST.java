package treessandtrees;

public class LongestUniValuePathinBST {
    Node root;
    int maxLength = Integer.MIN_VALUE;
    public void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + ",");
        inorder(root.right);
    }
    
    public int longestUniValue(Node root) {
        if (root == null) {
            return 0;
        }
        int left = longestUniValue(root.left);
        int right = longestUniValue(root.right);
        int retLeft = 0, retRight = 0;
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left != null && root.data == root.left.data) {
            retLeft = left + 1;
        }
        if (root.right != null && root.data == root.right.data) {
            retRight = right + 1;
        }
        if (Math.max(retLeft, retRight) > maxLength) {
            maxLength = Math.max(retLeft, retRight);
        }
        return Math.max(retLeft, retRight);
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LongestUniValuePathinBST obj = new LongestUniValuePathinBST();
        obj.root = new Node(5);
        obj.root.right = new Node(5);
        obj.root.left = new Node(4);
        obj.root.left.left = new Node(4);
        obj.root.left.right = new Node(1);
        obj.root.left.left.left = new Node(4);
        obj.root.left.left.right = new Node(9);
        
        obj.inorder(obj.root);
        obj.longestUniValue(obj.root);
        System.out.println("Max length univalue path:" + obj.maxLength);
    }

}
