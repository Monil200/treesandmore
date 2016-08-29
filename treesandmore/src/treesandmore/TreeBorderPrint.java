package treesandmore;
import java.util.*;

public class TreeBorderPrint {
    public static Node root;
    public TreeBorderPrint() {
        root= null;
    }
    
    public void insert(int val) {
        if (root == null) {
            root = new Node(val);
        } else {
            Node current = root;
            Node newNode = new Node(val);
            while(true) {
                if (newNode.data > current.data) {
                    if (current.right !=null) {
                        current = current .right;
                        continue;
                    } else {
                        current.right = newNode;
                        return;
                    }
                } else {
                    if (current.left !=null) {
                        current = current .left;
                        continue;
                    } else {
                        current.left = newNode;
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
            System.out.println(root.data + ",");
            inorderTraversal(root.right);
        }
    }
    
    public void printBorder(Node root) {
        if (root == null ){
            return ;
        } else {
            Queue<Node> q1 = new LinkedList<Node>();
            Queue<Node> q2 = new LinkedList<Node>();
            int counter1= 0;
            int counter2= 0;
            q1.add(root);
            while(!q1.isEmpty()) {
                Node temp1 = q1.poll();
                if (counter1 == 0 || q1.isEmpty() || (temp1.left == null && temp1.right==null)) {
                    System.out.println(temp1.data + ",");
                }
                counter1++;
                if (q1.isEmpty()) {
                    counter1 = 0;
                }
                if (temp1.left != null) {
                    q2.add(temp1.left);
                }
                if (temp1.right != null) {
                    q2.add(temp1.right);
                }
                while(!q2.isEmpty()) {
                    Node temp2= q2.poll();
                    if (counter2 == 0 || q2.isEmpty() || (temp2.left == null && temp2.right==null)) {
                        System.out.println(temp2.data + ",");
                    }
                    counter2++;
                    if (q2.isEmpty()) {
                        counter2 = 0;
                    }
                    if (temp2.left != null) {
                        q1.add(temp2.left);
                    }
                    if (temp2.right != null) {
                        q1.add(temp2.right);
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeBorderPrint bst = new TreeBorderPrint();
        bst.insert(4);
        bst.insert(2);
        bst.insert(1);
        bst.insert(3);
        bst.insert(8);
        bst.insert(9);
        bst.insert(6);
        bst.insert(7);
        bst.insert(5);
        bst.inorderTraversal(root);
        System.out.println("-------------");
        bst.printBorder(root);

    }

}
