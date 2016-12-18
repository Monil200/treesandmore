package postbuilding42;

public class FloorCeil {
    Node root;
    
    public void insert(int val) {
        if (root == null) {
            root = new Node(val);
        } else {
            Node current = root;
            Node newNode= new Node(val);
            while(true) {
                if (current.data >= val) {
                    if (current.left != null) {
                        current = current.left;
                    } else {
                        current.left = newNode;
                        return;
                    }
                } else {
                    if (current.right != null) {
                        current = current.right;
                    } else {
                        current.right = newNode;
                        return;
                    }
                }
            }
        }
    }
    
    public void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + ",");
        inorder(root.right);
                   
    }
    
    public Node getMax(Node root) {
        if (root == null) {
            return null;
        } else {
            if (root.right == null)
                return root;
            else
                return getMax(root.right);
        }
    }
    
    public Node getMin(Node root) {
        if (root == null) {
            return null;
        } else {
            if (root.left == null)
                return root;
            else
                return getMin(root.left);
        }
    }
    
    public Node getFloor(Node root, int target, Node parent) {
        if (root == null) {
            return null;
        } else {
            if (root.data > target) {
                return getFloor(root.left,target, parent);
            } else if (root.data < target){
                parent = root;
                return getFloor(root.right,target, parent);
            } else if (root.data == target) {
                if (root.left != null)
                    return getMax(root.left);
                else
                    return parent;
            }
            return null;
        }
    }
    
    public Node getCeil(Node root, int target, Node parent) {
        if (root == null) {
            return null;
        } else {
            if (root.data > target) {
                parent = root;
                return getCeil(root.left,target, parent);
            } else if (root.data < target){
                return getCeil(root.right,target, parent);
            } else if (root.data == target) {
                if (root.right != null)
                    return getMin(root.right);
                else
                    return parent;
            }
            return null;
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        FloorCeil obj = new FloorCeil();
        obj.insert(4);
        obj.insert(2);
        obj.insert(1);
        obj.insert(3);
        obj.insert(6);
        obj.insert(8);
        obj.inorder(obj.root);
        int target = 2;
        System.out.println("\n The floor of:" + target + " is: " + obj.getFloor(obj.root, target, null).data);
        System.out.println("\n The Ceil of:" + target + " is: " + obj.getCeil(obj.root, target, null).data);
    }

}
