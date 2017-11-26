package treessandtrees;

public class DeleteNodesOutsideRange {
    public Node root;
    DeleteNodesOutsideRange() {
        root = null;
    }
    
    public void insert(int val) {
        if (root == null) {
            root = new Node(val);
        } else {
            Node current = root;
            while(true) {
                if (current.data >= val) {
                    if (current.left != null) {
                        current = current.left;
                    } else {
                        current.left = new Node(val);
                        break;
                    }
                } else {
                    if (current.right != null) {
                        current = current.right;
                    } else {
                        current.right = new Node(val);
                        break;
                    }
                }
            }
        }
    }
    
    public void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + ", ");
        inorder(root.right);
    }
    
    // a - lower bound
    // b - upper bound
    public void deleteOutsideRange(Node root, Node parent, int a, int b, boolean isRoot, boolean isLeft) {
        if (root == null) {
            return;
        } else {
            if (isRoot) {
                if (root.data < a) {
                    root = root.right;
                    deleteOutsideRange(root, null, a,b, true, false);
                } else if (root.data > b) {
                    root = root.left;
                    deleteOutsideRange(root, null, a,b, true, false);
                }
            } else {
                if (root.data < a) {
                    if(isLeft) {
                        if (root.right!=null) {
                            parent.left = root.right;
                        } else {
                            parent.left = null;
                        }
                    } else {
                     // no use case
                    }
                } else if (root.data > b) {
                    if(isLeft) {
                        // no use case
                    } else {
                        if(root.left!= null) {
                            parent.right = root.left;
                        } else {
                            parent.right = null;
                        }
                    }
                }
            }
            deleteOutsideRange(root.left, root, a,b, false, true);
            deleteOutsideRange(root.right, root, a,b, false, false);
            
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DeleteNodesOutsideRange obj = new DeleteNodesOutsideRange();
        obj.insert(4);
        obj.insert(2);
        obj.insert(1);
        obj.insert(3);
        obj.insert(6);
        obj.insert(5);
        obj.insert(7);
        System.out.println("---------Inorder--------");
        obj.inorder(obj.root);
        System.out.println("---------trim it--------");
        obj.deleteOutsideRange(obj.root, null, 1,6,true, false);
        System.out.println("---------Inorder after trim--------");
        obj.inorder(obj.root);
    }

}
