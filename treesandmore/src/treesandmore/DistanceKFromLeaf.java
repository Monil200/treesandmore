package treesandmore;

public class DistanceKFromLeaf {
    
    NodeM root;
    int sum = 0;
    public DistanceKFromLeaf() {
        this.root = null;
    }
    
    public void insert(int val) {
        if (root == null) {
            root = new NodeM(val);
        } else {
            NodeM current = root;
            NodeM newNode = new NodeM(val);
            while(true) {
                if (current.data > val) {
                    if (current.left != null) {
                        current= current.left;
                    } else {
                        current.left = newNode;
                        break;
                    }
                } else {
                    if (current.right != null) {
                        current= current.right;
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
            System.out.println(root.data + "," + " Ldistance:" + root.distanceL + " distanceR:" + root.distanceR);
            inorder(root.right);
        }
    }
    
    public void distanceFromLeaf(NodeM root) {
        if (root == null ) {
            return;
        } else {
            distanceFromLeaf(root.left);
            distanceFromLeaf(root.right);
            
            if (root.left == null && root.right == null) {
                root.distanceL = 0;
                root.distanceR = 0;
            } else {
                if (root.left != null)
                    root.distanceL = root.left.distanceL+1;
                if (root.right!=null)
                    root.distanceR = root.right.distanceR+1;
            }
//            return root.distanceL;
        }
    }
    
    public int distanceFromLeafV2(NodeM root, int k) {
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        } else {
            int distl = distanceFromLeafV2(root.left, k) + 1;
            int distr = distanceFromLeafV2(root.right, k) + 1;
            
            if (distl == k || distr == k )
                System.out.println(root.data);
            if (distl <= k)
                return distl;
            return distr;
            
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DistanceKFromLeaf obj = new DistanceKFromLeaf();
        obj.insert(4);
        obj.insert(2);
        obj.insert(1);
        obj.insert(3);
        obj.insert(6);
        obj.insert(8);
        obj.distanceFromLeaf(obj.root);
        obj.distanceFromLeafV2(obj.root, 0);
        obj.inorder(obj.root);
    }

}
