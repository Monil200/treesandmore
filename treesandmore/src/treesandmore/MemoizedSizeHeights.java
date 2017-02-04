package treesandmore;
class NodeM {
    int data;
    int height,size;
    NodeM left,right;
    NodeM(int val) {
        data = val;
    }
}
public class MemoizedSizeHeights {
    
    NodeM root;
    int diameter = 0;
    public void insert(int val) {
        if (root == null) {
            root = new NodeM(val);
        } else {
            NodeM current = root;
            NodeM newNode = new NodeM(val);
            while(true) {
                if (current.data > val) {
                    if (current.left != null) {
                        current = current.left;
                    } else {
                        current.left = newNode;
                        break;
                    }
                } else {
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
    
    public void inorder(NodeM root) {
        if (root == null) {
            return;
        } else {
            inorder(root.left);
            System.out.println(root.data + " height - " + root.height + " size:" + root.size);
            inorder(root.right);
        }
    }
    
    public int memoizedHeight(NodeM root) {
        if (root == null) {
            return 0;
        } else {
            
            int lheight = memoizedHeight(root.left) + 1;
            int rheight = memoizedHeight(root.right) + 1;
            
            root.height = Math.max(lheight, rheight);
            if (lheight >= rheight) {
                return lheight;
            } else {
                return rheight;
            }
        }
    }
    
    public int memoizedSize(NodeM root) {
        if (root == null) {
            return 0;
        } else {
            root.size = memoizedSize(root.left) + memoizedSize(root.right) +1;  
            return root.size;
        }
    }
    
    public void diameter(NodeM root) {
        if (root == null) {
            return;
        } else {
            int tempDiameter = 1;
            if (root.left != null) {
                tempDiameter += root.left.height;
            }
            if (root.right != null) {
                tempDiameter += root.right.height;
            }
            if (tempDiameter > diameter) {
                diameter = tempDiameter;
            }
            diameter(root.left);
            diameter(root.right);
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MemoizedSizeHeights obj = new MemoizedSizeHeights();
        obj.insert(4);
        obj.insert(2);
        obj.insert(1);
        obj.insert(3);
        obj.insert(6);
        obj.insert(8);
        obj.memoizedHeight(obj.root);
        obj.memoizedSize(obj.root);
        obj.inorder(obj.root);
        obj.diameter(obj.root);
        System.out.println("The diameter is" + obj.diameter);
    }

}
