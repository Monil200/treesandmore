package treesandmore;

public class BSTFromPreAndInOrder {
    Node root;
    public BSTFromPreAndInOrder() {
        this.root = null;
    }
    
    public Node createBSTFromPostANdInorder(Node root, int start, int end, int[] in, int[] post) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new Node(post[end]);
        }
        root = new Node(post[end]);
        // find number of nodes in left subtree of root;
        int newStart = start; // for left subtree
        while(in[newStart] != post[end]) {
            newStart++;
        }
        System.out.println("Start:" + start + " end:" + end);
        
        root.right =  createBSTFromPostANdInorder(root.right, newStart, end-1, in, post);
        root.left =  createBSTFromPostANdInorder(root.left, start, newStart-1, in, post);
        return root;
    }
    public void inorderTraversal(Node root) {
        if (root == null) {
            return;
        } else {
            inorderTraversal(root.left);
            System.out.print(root.data +  " , ");
            inorderTraversal(root.right);
        }
    }
    
    public static void main(String[] args) {
        int in[] = {4, 8, 2, 5, 1, 6, 3, 7};
        int post[] = {8, 4, 5, 2, 6, 7, 3, 1};
        
        BSTFromPreAndInOrder obj = new BSTFromPreAndInOrder();
        obj.root = obj.createBSTFromPostANdInorder(obj.root, 0, in.length -1, in, post);
        obj.inorderTraversal(obj.root);

    }

}
