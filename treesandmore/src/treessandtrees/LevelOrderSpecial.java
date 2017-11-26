package treessandtrees;
import java.util.*;

public class LevelOrderSpecial {
    Node root;
    LevelOrderSpecial() {
        root = null;
    }
    
    public void insert(int val) {
        if (root == null)
            root = new Node(val);
        else {
            Node current = root;
            while(true) {
                if(current.data >= val) {
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
    
    public void levelOrderSpecial(Node root) {
        if (root == null)
            return;
        else {
            Queue<Node> ql = new LinkedList<Node>();
            Queue<Node> qr = new LinkedList<Node>();
            Node current = root;
            System.out.print(current.data + ", ");
            ql.add(current.left);
            qr.add(current.right);
            while(!ql.isEmpty() && !qr.isEmpty()) {
                Node nodeLeft = (!ql.isEmpty()) ? ql.remove() : null;
                Node nodeRight = (!qr.isEmpty()) ? qr.remove() : null;
                
                if (nodeLeft != null) {
                    System.out.print(nodeLeft.data + ", ");
                    if (nodeLeft.left != null) {
                        ql.add(nodeLeft.left);
                    }
                    if (nodeLeft.right != null) {
                        ql.add(nodeLeft.right);
                    }
                }
                if (nodeRight != null) {
                    System.out.print(nodeRight.data + ", ");
                    if (nodeRight.right != null) {
                        qr.add(nodeRight.right);
                    }
                    if (nodeRight.left != null) {
                        qr.add(nodeLeft.left);
                    }
                }
            } // while end
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LevelOrderSpecial obj = new LevelOrderSpecial();
        obj.insert(4);
        obj.insert(2);
        obj.insert(1);
        obj.insert(3);
        obj.insert(6);
        obj.insert(5);
        obj.insert(7);
        System.out.println("---------Inorder--------");
        obj.inorder(obj.root);
        System.out.println("\n ---------Level Order Special--------");
        obj.levelOrderSpecial(obj.root);
    }

}
