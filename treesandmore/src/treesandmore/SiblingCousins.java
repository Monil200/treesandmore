package treesandmore;
import java.util.*;

class NodeMod { // Node Modified
    int data;
    NodeMod left;
    NodeMod right;
    int height;
    public NodeMod(int val) {
        this.data = val;
        this.left = null;
        this.left = null;
        this.height = -1; 
    }
}
public class SiblingCousins {
    
    public static NodeMod root;
    public static Stack<NodeMod> nodes;
    public SiblingCousins() {
        root = null;
    }
    
    public void insert(int val) {
        if (root == null) {
            root = new NodeMod(val);
            root.height= 0;
        } else {
            NodeMod newNode = new NodeMod(val);
            NodeMod current = root;
            int height = 0;
            System.out.println();
            while(true) {
                height++;
                if (newNode.data < current.data) {
                    if (current.left !=null) {
                        current = current.left;
                        continue;
                    } else {
                        current.left = newNode;
                        newNode.height = ++height;
                        return;
                    }
                } else {
                    if (current.right != null) {
                        current = current.right;
//                        continue;
                    } else {
                        current.right = newNode;
                        newNode.height = ++height;
                        return;
                    }
                }
            }
        }
    }
    
    public void inorderTraversal(NodeMod root) {
        if (root == null) {
            return;
        } else {
            inorderTraversal(root.left);
            System.out.print(root.height + ",");
            inorderTraversal(root.right);
        }
    }
    
    public void findCousins(NodeMod root,  int targetHeight) {
        if (root == null) {
            return;
        } else {
//            System.out.println("currentHeight:" + currentHeight);
            if (root.height == targetHeight) {
                System.out.print(root.data + ",");
            }
            findCousins(root.left, targetHeight);
            findCousins(root.right, targetHeight);
        }
    }
    
    public NodeMod findTargetHeight(NodeMod root, int a) {
        if (root == null) {
            return null;
        } else {
            if (root.data == a) {
                return root;
            } else if (root.data > a) {
                return findTargetHeight(root.left, a);
            } else {
                return findTargetHeight(root.right, a);
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SiblingCousins b = new SiblingCousins();
        b.insert(4);
        b.insert(2);
        b.insert(1);
        b.insert(3);
        b.insert(6);
        b.insert(8);
        b.inorderTraversal(root);
        NodeMod target = b.findTargetHeight(root, 1);
        System.out.println("----------");
        System.out.println(target.height);
        b.findCousins(root,target.height);
    }

}
