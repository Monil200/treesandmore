package treesandmore;
class NodeIdenticalLeftRightSubtree  extends Node {
    NodeIdenticalLeftRightSubtree left,right;
    NodeIdenticalLeftRightSubtree(int val) {
        super(val);
    }
    boolean identicalLRSubtree = false;
}
public class IdenticalLeftRightSubtrees {
    NodeIdenticalLeftRightSubtree root;
    public void inorder(NodeIdenticalLeftRightSubtree root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.println(root.data + " isIdenticalLRSubtree:"  + root.identicalLRSubtree);
        inorder(root.right);
    }
    
    public void isIdenticalLRSubtree(NodeIdenticalLeftRightSubtree root) {
        if (root == null) {
            return;
        } else {
            isIdenticalLRSubtree(root.left);
            isIdenticalLRSubtree(root.right);
            if (root.left == null && root.right == null) {
                root.identicalLRSubtree = true;
            } else {
                if (root.left!=null && root.right !=null) {
                    if (root.left.data == root.right.data) {
                        root.identicalLRSubtree = true;
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        IdenticalLeftRightSubtrees obj = new IdenticalLeftRightSubtrees();
        obj.root = new NodeIdenticalLeftRightSubtree(50);
        obj.root.left = new NodeIdenticalLeftRightSubtree(10);
        obj.root.right = new NodeIdenticalLeftRightSubtree(60);
        obj.root.left.left = new NodeIdenticalLeftRightSubtree(5);
        obj.root.left.right = new NodeIdenticalLeftRightSubtree(20);
        obj.root.right.left = new NodeIdenticalLeftRightSubtree(70);
        obj.root.right.left.left = new NodeIdenticalLeftRightSubtree(65);
        obj.root.right.left.right = new NodeIdenticalLeftRightSubtree(80);
        obj.root.right.right = new NodeIdenticalLeftRightSubtree(70);
        obj.root.right.right.left = new NodeIdenticalLeftRightSubtree(65);
        obj.root.right.right.right = new NodeIdenticalLeftRightSubtree(80);
        
        obj.isIdenticalLRSubtree(obj.root);
        obj.inorder(obj.root);
        
    }

}
