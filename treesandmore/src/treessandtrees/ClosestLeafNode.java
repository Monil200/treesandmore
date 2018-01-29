package treessandtrees;
class NodeLeaf {
    int leafDist, data;
    NodeLeaf left, right;
    NodeLeaf(int val) {
        data = val;
    }
}
public class ClosestLeafNode {
    NodeLeaf root;
    ClosestLeafNode() {
        root = null;
    }
    
    public void inorder(NodeLeaf root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + " -> (" + root.leafDist + ") ,");
        inorder(root.right);           
    }
    
    public int getBottomToTopLeafDistance(NodeLeaf root) {
        if (root == null)
            return 0;
        else {
            int left = getBottomToTopLeafDistance(root.left);
            int right = getBottomToTopLeafDistance(root.right);
            
            if (root.left == null && root.right == null) {
                root.leafDist = 0;
            } else {
                if (root.left == null && root.right != null) {
                    root.leafDist = right + 1;
                } else if (root.left != null && root.right == null) {
                    root.leafDist = left + 1;
                } else if (root.left != null && root.right != null) {
                    root.leafDist = Math.min(left, right) + 1;
                }
            }
            return root.leafDist;
            
        }
    }
    
    public void getMinLeafDist(NodeLeaf root, NodeLeaf parent) {
        if(root == null)
            return;
        else {
            if (parent!= null) {
                root.leafDist = Math.min(root.leafDist, parent.leafDist + 1);
            }
            getMinLeafDist(root.left, root);
            getMinLeafDist(root.right, root);
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ClosestLeafNode obj = new ClosestLeafNode();
        
        obj.root = new NodeLeaf(6);
        obj.root.left = new NodeLeaf(3);
        obj.root.left.left = new NodeLeaf(2);
        obj.root.left.right = new NodeLeaf(4);
        obj.root.left.right.right = new NodeLeaf(10);
        obj.root.left.right.right.right = new NodeLeaf(11);
        obj.root.left.left.left = new NodeLeaf(1);
        obj.root.left.left.left.left = new NodeLeaf(-1);
        
        obj.root.right = new NodeLeaf(7);
        
//        obj.inorder(obj.root);
        obj.getBottomToTopLeafDistance(obj.root);
        obj.inorder(obj.root);
        System.out.println();
        obj.getMinLeafDist(obj.root, null);
        obj.inorder(obj.root);
        
        /*
         *                6
         *           3       7
         *        2    4   
         *      1       10 
         *    -1          11
         */
        
    }

}
