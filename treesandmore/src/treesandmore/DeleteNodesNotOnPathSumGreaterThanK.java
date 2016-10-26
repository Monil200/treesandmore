package treesandmore;

import java.util.*;
class NodeNew {
    int sumPathVal;
    NodeNew left;
    NodeNew right;
    int data;
    public NodeNew(int val) {
        this.data = val;
        this.left= null;
        this.right= null;
        this.sumPathVal = 0;
    }
}
public class DeleteNodesNotOnPathSumGreaterThanK {
    public static NodeNew root;
    
    public DeleteNodesNotOnPathSumGreaterThanK() {
        root = null;
    }
    
    public void rootToLeafSum(NodeNew root, ArrayList<NodeNew> al) {
        if (root == null) {
            return;
        } else {
            al.add(root);
            if (root.left == null && root.right == null) {
                int pathSum = 0;
                for(NodeNew temp: al) {
                    pathSum += temp.data;
                }
                for(NodeNew temp:al) {
                    if (temp.sumPathVal < pathSum) {
                        temp.sumPathVal = pathSum;
                    }
                }
                pathSum = 0;
            } else {
                rootToLeafSum(root.left, new ArrayList<NodeNew>(al));
                rootToLeafSum(root.right, new ArrayList<NodeNew>(al));
            }
        }
    }
    
    public void deleteNodes(NodeNew root, NodeNew previous, int k, boolean isLeft) {
        if (root == null) {
            return;
        } else {
            if (root.sumPathVal <= k) {
                if (isLeft) {
                    previous.left = null;
                } else {
                    previous.right = null;
                }
            }
            deleteNodes(root.left, root, k, true);
            deleteNodes(root.right, root, k, false);
        }
    }
    
    
    
    public void inorderTraversal(NodeNew root) {
        if (root == null) {
            return;
        } else {
            inorderTraversal(root.left);
            System.out.print(root.data + ",");
            inorderTraversal(root.right);
        }
    }
    
    public void inorderTraversalSumPrint(NodeNew root) {
        if (root == null) {
            return;
        } else {
            inorderTraversal(root.left);
            System.out.print(root.sumPathVal + ",");
            inorderTraversal(root.right);
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DeleteNodesNotOnPathSumGreaterThanK obj = new DeleteNodesNotOnPathSumGreaterThanK();
        root = new NodeNew(1);
        root.left = new NodeNew(2);
        root.right = new NodeNew(3);
        root.left.left = new NodeNew(4);
        root.left.right = new NodeNew(5);
        root.right.left = new NodeNew(6);
        root.right.right = new NodeNew(7);
        root.left.left.left = new NodeNew(8);
        root.left.left.right = new NodeNew(9);
        root.left.right.left = new NodeNew(12);
        root.right.right.left = new NodeNew(10);
        root.right.right.left.right = new NodeNew(11);
        root.left.left.right.left = new NodeNew(13);
        root.left.left.right.right = new NodeNew(14);
        root.left.left.right.right.left = new NodeNew(15);
        
        System.out.println("\nInorder traversal after before sum calculation\n");
        obj.inorderTraversal(root);
        System.out.println("\nInorder traversal after sum calculation\n");
        obj.rootToLeafSum(root, new ArrayList<NodeNew>());
        obj.inorderTraversalSumPrint(root);
        System.out.println("\nInorder traversal after deletion\n");
        obj.deleteNodes(root, null, 20, false);
        obj.inorderTraversal(root);
    }

}
