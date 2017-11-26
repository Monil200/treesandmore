package treesandmore;

public class SortedArrayToBST {
    Node root;
    public SortedArrayToBST() {
        this.root = null; 
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
    
    public Node sortedArrayToBST(Node root, int min, int max, int a[]) {
        if (min >max) {
            return null;
        } else {
            int mid = (min + max)/2;
            root = new Node(a[mid]);
            root.left = sortedArrayToBST(root.left, min, mid-1, a);
            root.right = sortedArrayToBST(root.right, mid+1, max, a);
            return root;
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a[] = {1,2,3,4,5,6,7, 9};
        SortedArrayToBST obj = new SortedArrayToBST();
        obj.root = obj.sortedArrayToBST(obj.root, 0, a.length-1,a);
        obj.inorderTraversal(obj.root);
    }

}
