package treesandmore;
import java.util.*;

public class RootToLeafPathVariations {
    public static Node root;
    public void RootToLeafPathVariations() {
        root = null;
    }
    public void insert(int val) {
        Node newNode = new Node(val);
        if (root == null) {
            root = newNode;
        } else {
            Node temp = root;
            while(true) {
                if (temp.data > val) {
                    if (temp.left!=null) {
                        temp = temp.left;
                        continue;
                    } else {
                        temp.left = newNode;
                        return;
                    }
                } else if (temp.data < val) {
                    if (temp.right!=null) {
                        temp = temp.right;
                        continue;
                    } else {
                        temp.right = newNode;
                        return;
                    }
                }
            }
        }
    }
    
    public void inorderTraversal(Node root) {
        if (root == null) {
            return;
        } else {
            inorderTraversal(root.left);
            System.out.println(root.data + " ");
            inorderTraversal(root.right);
        }
    }
    
//    public void printAllRootToLeafPaths(Node root,  Queue<Node> qu) {
//        if (root == null) {
//            return;
//        } else {
//            qu.add(root);
//            if (root.left == null && root.right == null) {
//                System.out.println("-------" + root.data + "---------");
//                Iterator<Node> i = qu.iterator();
//                while(i.hasNext()) {
//                    System.out.print(i.next().data);
//                }
//                //return;
//            }
//            printAllRootToLeafPaths(root.left, new LinkedList<Node>(qu));
//            printAllRootToLeafPaths(root.right, new LinkedList<Node>(qu));
//        }
//    }
    
    public void rootToleafPaths(Node root, LinkedList<Node> l) {
        if (root == null) {
            return;
        } else {
            l.add(root);
            if (root.left == null & root.right == null) {
                Iterator<Node> it = l.iterator();
                System.out.println("--------PATHS--------");
                while(it.hasNext()) {
                    System.out.print(it.next().data+ ",");
                }
                System.out.println();
            }
            rootToleafPaths(root.left, new LinkedList<Node>(l));
            rootToleafPaths(root.right, new LinkedList<Node>(l));
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        RootToLeafPathVariations b = new RootToLeafPathVariations();
        b.insert(4);
        b.insert(2);
        b.insert(6);
        b.insert(8);
//        b.inorderTraversal(root);
        LinkedList<Node> qu = new LinkedList<Node>();
        b.rootToleafPaths(root, qu);
    }

}
