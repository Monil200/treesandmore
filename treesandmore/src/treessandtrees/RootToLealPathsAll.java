package treessandtrees;

public class RootToLealPathsAll {
    public Node root;
    RootToLealPathsAll() {
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
    
    public void sumOfRootToLeafPaths(Node root, int currSum) {
        if (root == null)
            return;
        else {
            currSum += root.data;
            sumOfRootToLeafPaths(root.left, currSum);
            sumOfRootToLeafPaths(root.right, currSum);
            if (root.left == null && root.right == null)
                System.out.println(currSum);
        }
    }
    
    public void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + ", ");
        inorder(root.right);
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        RootToLealPathsAll obj = new RootToLealPathsAll();
        obj.insert(4);
        obj.insert(2);
        obj.insert(1);
        obj.insert(3);
        obj.insert(6);
        obj.insert(5);
        obj.insert(7);
        obj.inorder(obj.root);
        System.out.println();
        obj.sumOfRootToLeafPaths(obj.root, 0);
    }

}
