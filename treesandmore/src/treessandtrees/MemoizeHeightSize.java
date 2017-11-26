package treessandtrees;

class NodeM {
    NodeM left,right;
    int height,size,data,nHeight;
    NodeM(int val) {
        data=val;
        left = right = null;
        height = -1;
        nHeight = -1;
    }
    NodeM(int val, int height) {
        data=val;
        left = right = null;
        this.height = height;
    }
}
public class MemoizeHeightSize {
    public NodeM root;
    int currDiameter, maxDiameter = 0;
    MemoizeHeightSize() {
        root = null;
    }
    
    public void insert(int val) {
        if (root == null) {
            root = new NodeM(val);
            root.height = 0;
        } else {
            NodeM current = root;
            int height = 0;
            while(true) {
                ++height;
                if (current.data >= val) {
                    if (current.left != null) {
                        current = current.left;
                    } else {
                        current.left = new NodeM(val, height);
                        break;
                    }
                } else {
                    if (current.right != null) {
                        current = current.right;
                    } else {
                        current.right = new NodeM(val, height);
                        break;
                    }
                }
            }
        }
    }
    
    public int memoizedHeight(NodeM root) {
        if (root == null) {
            return 0;
        } else {
            int l = memoizedHeight(root.left) +1;
            int r = memoizedHeight(root.right) +1;
            
            root.nHeight = Math.max(l,r);
            return root.nHeight;
        }
    }
    
    public void diameter(NodeM root) {
        if (root == null)
            return;
        else {
            int lh = (root.left != null) ? root.left.nHeight : 0;
            int rh = (root.right != null) ? root.right.nHeight : 0;
            currDiameter = 1 + lh + rh;
            if (currDiameter > maxDiameter)
                maxDiameter = currDiameter;
            diameter(root.left);
            diameter(root.right);
        }
    }
    
    public int memoizedSize(NodeM root) {
        if (root == null)
            return 0;
        else {
            root.size = memoizedSize(root.left) + memoizedSize(root.right) + 1;
            return root.size;
        }
    }
    
    public void inorder(NodeM root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.println(root.data + "( Height = " + root.height + " -- Size = " + root.size + " -- nHeight = " + root.nHeight + ")");
        inorder(root.right);
    }
    
    public boolean isHeightBalanced(NodeM root) {
        if (root == null)
            return true;
        else {
            int l = (root.left != null) ? root.left.nHeight : 0;
            int r = (root.right != null) ? root.right.nHeight : 0;
            
            return (Math.abs(l - r) <= 1 && isHeightBalanced(root.left) && isHeightBalanced(root.right));
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MemoizeHeightSize obj = new MemoizeHeightSize();
        obj.insert(4);
        obj.insert(2);
        obj.insert(1);
        obj.insert(3);
        obj.insert(6);
        obj.insert(5);
        obj.insert(7);
        obj.insert(70);
        obj.memoizedSize(obj.root);
        obj.memoizedHeight(obj.root);
        obj.inorder(obj.root);
        System.out.print("Is height balanced ? - ");
        System.out.println(obj.isHeightBalanced(obj.root));
        obj.diameter(obj.root);
        System.out.print("-------------Diameter-------" + obj.maxDiameter);
    }

}
