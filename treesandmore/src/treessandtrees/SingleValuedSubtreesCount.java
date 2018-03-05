package treessandtrees;
/*
 * Given a binary tree, write a program to count the number of Single Valued Subtrees. A Single Valued Subtree is one in which all the nodes have same value. Expected time complexity is O(n).
 */
public class SingleValuedSubtreesCount {
    
    public Node root;
    int count = 0;
    SingleValuedSubtreesCount() {
        root = null;
    }
    
    public void insert(int val) {
        if (root == null) {
            root = new Node(val);
        } else {
            Node current = root;
            while(true) {
                if (current.data >= val) {
                    if (current.left != null) {
                        current = current.left;
                    } else {
                        current.left = new Node(val);
                        break;
                    }
                } else {
                    if (current.right != null) {
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
    
    public void getCountOfSingleValuedSubtrees(Node root) {
        if (root == null) {
            return;
        } else {
            getCountOfSingleValuedSubtrees(root.left);
            getCountOfSingleValuedSubtrees(root.right);
            
            if (root.left == null && root.right == null) {
                count++;
            } else if (root.left == null && root.right != null && root.data == root.right.data) {
                count++;
            } else if (root.right == null && root.left != null && root.data == root.left.data) {
                count++;
            } else if (root.left != null && root.right != null) {
                if (root.left.data == root.right.data && root.left.data == root.data) {
                    count++;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SingleValuedSubtreesCount obj = new SingleValuedSubtreesCount();
        obj.root = new Node(5);
        obj.root.left = new Node(1);
        obj.root.right = new Node(5);
        obj.root.left.left = new Node(5);
        obj.root.left.right = new Node(5);
        obj.root.right.right = new Node(5);
        System.out.println("---------Inorder--------");
        obj.inorder(obj.root);
        
        obj.getCountOfSingleValuedSubtrees(obj.root);
        System.out.println("\n---------Answers--------");
        System.out.println(obj.count);
    }

}
