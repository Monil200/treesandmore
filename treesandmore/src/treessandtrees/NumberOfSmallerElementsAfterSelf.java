package treessandtrees;
import java.util.*;
class NodeCountSmallerElements {
    int data, leftTreeCount;
    int smallerThanSelf;
    NodeCountSmallerElements left,right;
    NodeCountSmallerElements(int val) {
        data = val;
        leftTreeCount = smallerThanSelf = 0;
    }
}
public class NumberOfSmallerElementsAfterSelf {
    NodeCountSmallerElements root;
    NumberOfSmallerElementsAfterSelf() {
        root = null;
    }
    
    public void insert(int val) {
        if (root == null) {
            root = new NodeCountSmallerElements(val);
        } else {
            NodeCountSmallerElements newNode = new NodeCountSmallerElements(val);
            NodeCountSmallerElements current = root;
            while(true) {
                if (current.data > val) {
                    current.leftTreeCount++;
                    if (current.left != null) {
                        current = current.left;
                    } else {
                        current.left = newNode;
                        break;
                    }
                } else {
                    newNode.smallerThanSelf += 1;
                    newNode.smallerThanSelf += current.leftTreeCount;
                    if (current.right != null) {
                        current = current.right;
                    } else {
                        current.right = newNode;
                        break;
                    }
                }
            }
        }
    }
    
    public void inorder(NodeCountSmallerElements root) {
        if (root == null) {
            return;
        } else {
            inorder(root.left);
            System.out.println("data:" + root.data  + " smaller than self count:" + root.smallerThanSelf + " leftSubtree size:" + root.leftTreeCount);
            inorder(root.right);
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        NumberOfSmallerElementsAfterSelf obj = new NumberOfSmallerElementsAfterSelf();
        int a[] = {5,2,3,4,6,1};
        for(int i=a.length-1;i>=0;i--) {
            obj.insert(a[i]);
        }
        
        obj.inorder(obj.root);
    }

}
