package treesandmore;
class LeafCount {
    int data;
    int leafCount = 0;
    LeafCount left, right;
    LeafCount(int val) {
        data = val;
    }
}
public class NodesWithKChildren {
    LeafCount root;
    NodesWithKChildren () {}
    public void insert(int val) {
        if (root == null) {
            root = new LeafCount(val);
        } else {
            LeafCount current = root;
            while(true) {
                if (current.data > val) {
                    if (current.left != null) {
                        current = current.left;
                    } else {
                        current.left = new LeafCount(val);
                        break;
                    }
                } else {
                    if (current.right != null) {
                        current= current.right;
                    } else {
                        current.right = new LeafCount(val);
                        break;
                    }
                }
            }
        }
    }
    
    public void inorder(LeafCount root) {
        if (root == null) {
            return;
        } else {
            inorder(root.left);
            System.out.print(root.data + ",");
            inorder(root.right);
        }
    }
    
    public void inorderLeafCount(LeafCount root) {
        if (root == null) {
            return;
        } else {
            inorderLeafCount(root.left);
            System.out.println(" data: " + root.data + "leafCount:" + root.leafCount);
            inorderLeafCount(root.right);
        }
    }
    
    public void nodesWithKChild(LeafCount root) {
        if (root == null) {
            return;
        } else {
            nodesWithKChild(root.left);
            nodesWithKChild(root.right);
            
            if (root.left == null && root.right == null)
                root.leafCount = 1;
            else {
                if (root.left != null) {
                    root.leafCount += root.left.leafCount;
                }
                if (root.right != null) {
                    root.leafCount += root.right.leafCount;
                }
            }
        }
    }
    
    public static void main(String args[]) {
        NodesWithKChildren obj = new NodesWithKChildren();
        obj.insert(4);
        obj.insert(2);
        obj.insert(6);
        obj.insert(1);
        obj.insert(3);
        obj.inorder(obj.root);
        obj.nodesWithKChild(obj.root);
        System.out.println("----");
        obj.inorderLeafCount(obj.root);
    }
}
