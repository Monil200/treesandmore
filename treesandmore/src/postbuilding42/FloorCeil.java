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
    
    public void getCeil(Node root, int target, Node ceil) {
        if (root == null) {
            return;
        } else {
            if (root.data == target && ceil != null) {
                Node maxIfAny = getMax(root);
                if (maxIfAny.data > ceil.data) {
                    System.out.println("the ceil of target " + target + " is " + maxIfAny.data);
                } else {
                    System.out.println("the ceil of target " + target + " is " + ceil.data);
                }
                return;
            }
            if (root.data > target) {
                ceil = root;
                getCeil(root.left, target, ceil);
            } else {
                getCeil(root.right, target,ceil);
            }
        }
    }
    
    public void getFloor(Node root, int target, Node floor) {
        if (root == null) {
            return;
        } else {
            if (root.data == target) {
                Node minIfAny = getMin(root);
                if (floor == null) {
                    if (minIfAny == null) {
                        System.out.println("No min found");
                    } else {
                        System.out.println("the FLoor of target " + target + " is " + minIfAny.data);
                    }
                } else{
                    if (minIfAny.data < floor.data) {
                        System.out.println("the FLoor of target " + target + " is " + minIfAny.data);
                    } else {
                        System.out.println("the FLoor of target " + target + " is " + floor.data);
                    }
                }
                return;
            }
            if (root.data < target) {
                floor = root;
                getFloor(root.right, target, floor);
            } else {
                getFloor(root.left, target,floor);
            }
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
        int target = 4;
        Node ceil = null;
        System.out.println();
        obj.getCeil(obj.root, target, ceil);
        obj.getFloor(obj.root, target, ceil);
        
    }

}
