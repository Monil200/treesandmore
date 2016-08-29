package treesandmore;

class NodesWithSmallerCount {
    int data;
    NodesWithSmallerCount left;
    NodesWithSmallerCount right;
    int smallerCount;
    public NodesWithSmallerCount(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
        this.smallerCount = 0;
    }
}

public class SmallerNumberAfterSelf {
    public static NodesWithSmallerCount root;
    public void insert(int val){
        NodesWithSmallerCount newNode = new NodesWithSmallerCount(val);
        if (root == null) {
            root = newNode;
            return;
        } else {
            NodesWithSmallerCount current = root;
            while(true) {
                if (current.data > val) {
                    current.smallerCount +=1;
                    if (current.left != null) {
                        current = current.left;
                        continue;
                    } else {
                        current.left = newNode;
                        return;
                    }
                }
                if (current.data < val) {
                    if (current.right != null) {
                        current = current.right;
                        continue;
                    } else {
                        current.right = newNode;
                        return;
                    }
                }
            }
        }
    }
    
    public void inorderTraversal(NodesWithSmallerCount root) {
        if (root == null) {
            return;
        } else {
            inorderTraversal(root.left);
            System.out.print(root.smallerCount + " ");
            inorderTraversal(root.right);
        }
    }
    
    public void find(NodesWithSmallerCount root, int val) {
        if (root == null) {
            return;
        } else {
            if (root.data == val) {
                System.out.println(root.data + " found with small count " + root.smallerCount);
            } else if (root.data > val) {
                find(root.left, val);
            } else {
                find(root.right, val);
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SmallerNumberAfterSelf b = new SmallerNumberAfterSelf();
        b.insert(6);
        b.insert(4);
        b.insert(2);
        b.insert(8);
        b.inorderTraversal(root);
        System.out.println();
        b.find(root, 4);
    }

}
