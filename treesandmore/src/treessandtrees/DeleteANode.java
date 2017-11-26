package treessandtrees;
public class DeleteANode {
    public Node root;
    DeleteANode() {
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
    
    public Node getMin(Node root) {
        if (root == null)
            return null;
        else {
            if (root.left == null && root.right == null) {
                return root;
            }
            Node current = root;
            Node prev = null;
            Node temp = null;
            while(current!=null) {
                prev = temp;
                temp = current;
                current = current.left;
            }
            prev.left = null;
            return temp;
        }
    }
    public Node getMax(Node root) {
        if (root == null)
            return null;
        else {
            if (root.left == null && root.right == null) {
                return root;
            }
            Node current = root;
            Node temp = null;
            Node prev = null;
            while(current!=null) {
                prev = temp;
                temp = current;
                current = current.right;
            }
            prev.right = null;
            return temp;
        }
    }
    
    public void deleteNode(Node root, Node parent, boolean isLeft, int k) { // k is to be deleted
        if (root == null) {
            return;
        } else {
            if (root.data == k) {
                if (root.left == null && root.right == null) {
                    if (isLeft) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                } else { // 3 cases
                    // case 1 - both right and left children are present
                    if ((root.left != null && root.right != null) || (root.left != null && root.right == null)) {
                        // trying to combine 2 cases here
                        // case 1.1 - both children present
                        // case 1.2 - right absent, left present
                        Node candidate = getMax(root.left);
                        if (isLeft) {
                            parent.left = candidate;
                        } else {
                            parent.right = candidate;
                        }
                    } else if (root.left == null && root.right!= null) {
                        Node candidate = getMin(root.right);
                        if (isLeft) {
                            parent.left = candidate;
                        } else {
                            parent.right = candidate;
                        }
                    }
                }
            } else if (root.data > k) {
                deleteNode(root.left, root, true,k);
            } else {
                deleteNode(root.right, root, false,k);
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DeleteANode obj = new DeleteANode();
        obj.insert(4);
        obj.insert(2);
        obj.insert(1);
        obj.insert(3);
        obj.insert(6);
        obj.insert(5);
        obj.insert(7);
        System.out.println("---------Deleting--------// need to handle root seperately");
        obj.deleteNode(obj.root, null, false, 4);
        System.out.println("---------Inorder after deleting--------");
        obj.inorder(obj.root);
    }

}

