package aaplQuYelBay;

class NodeSmallerSelf extends Node {
//    int data;
    int smaller, size;
    NodeSmallerSelf left,right;
    NodeSmallerSelf(int val) {
        super(val);
    }
}
public class SmallerElementsAfterSelf {
    NodeSmallerSelf root;
    
    void insert(int val) {
        if (root == null) {
            root = new NodeSmallerSelf(val);
            root.smaller = 0;
        } else {
            NodeSmallerSelf current = root;
            while(true) {
                if (current.data >= val) {
                    if (current.left != null) {
                        current = current.left;
                    } else {
                        current.left = new NodeSmallerSelf(val);
                        break;
                    }
                } else {
                    if (current.right != null) {
                        current = current.right;
                    } else {
                        current.right = new NodeSmallerSelf(val);
                        break;
                    }
                }
            }
        }
    }
    
    void inorder(NodeSmallerSelf root) {
        if (root == null)
            return;
        else {
            inorder(root.left);
            System.out.println(root.data + " leftSize:" + root.size);
            inorder(root.right);
        }
    }
    
    int memoizedSizes(NodeSmallerSelf root) {
        if (root == null) {
            return 0;
        } else {
            root.size = memoizedSizes(root.left) + memoizedSizes(root.right) +1;
            return root.size;
        }
    }
    
    void findSmallerElementsOnRight(int n, NodeSmallerSelf root, int count) {
        if (root == null) {
            return;
        } else {
            if (root.data > n) {
                findSmallerElementsOnRight(n, root.left, count);
            } else if (n > root.data) {
                if (root.left!= null)
                    count += root.left.size + 1;
                else 
                    count+=1;
                findSmallerElementsOnRight(n, root.right, count);
            } else if (n == root.data) {
                if (root.left != null)
                    count += root.left.size;
                System.out.println("node:" + n + " smaller:" + count);
                return;
            }
//            return count;
        }
    }
    
    public static void main(String args[]) {
        SmallerElementsAfterSelf obj = new SmallerElementsAfterSelf();
        obj.insert(4);
        obj.insert(2);
        obj.insert(1);
        obj.insert(3);
        obj.insert(6);
        obj.insert(5);
        obj.insert(8);
        obj.memoizedSizes(obj.root);
        obj.inorder(obj.root);
        int a[] = {4,2,1,3,6,5,8};
        
        for(int i=0;i<a.length;i++) {
            obj.findSmallerElementsOnRight(a[i], obj.root,0);
        }
    }
 }
