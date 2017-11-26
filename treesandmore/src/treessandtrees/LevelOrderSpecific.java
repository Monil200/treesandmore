package treessandtrees;
public class LevelOrderSpecific {
    public Node root;
    LevelOrderSpecific() {
        root = null;
    }
    
    public void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + ", ");
        inorder(root.right);
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LevelOrderSpecific obj = new LevelOrderSpecific();
        System.out.println("---------Inorder--------");
        obj.inorder(obj.root);
    }

}
