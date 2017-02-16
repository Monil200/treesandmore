package aaplQuYelBay;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
class Node {
    int data;
    Node left,right;
    Node(int val) {
        data = val;
    }
}
public class VerticalOrderTraversal {
    Node root;
    HashMap<Integer, ArrayList<Node>> level;
    String a = "abc";
   
    
    VerticalOrderTraversal() {
        level = new HashMap<Integer, ArrayList<Node>>();
    }
    public void insert(int val) {
        if (root == null) {
            root = new Node(val);
        } else {
            Node newNode = new Node(val);
            Node current = root;
            while(true) {
                if (current.data > val) {
                    if (current.left != null) {
                        current = current.left;
                    } else {
                        current.left = newNode;
                        break;
                    }
                } else {
                    if (current.right != null) {
                        current = current.right;
                    } else {
                        current.right = newNode;
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
        System.out.print(root.data + ",");
        inorder(root.right);
    }
    
    void verticalOrderTraversal(Node root, int l) {
        if (root == null) {
            return;
        } else {
            if (!level.containsKey(l)) {
                System.out.println("root" + root.data);
                ArrayList<Node> a = new ArrayList<Node>();
                a.add(root);
                level.put(l,a);
            } else {
                ArrayList<Node> temp = level.get(l);
                temp.add(root);
                level.put(l,temp);
                temp.clear();
            }
            verticalOrderTraversal(root.left,l-1);
            verticalOrderTraversal(root.right,l+1);
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        VerticalOrderTraversal obj = new VerticalOrderTraversal();
        obj.insert(4);
        obj.insert(2);
        obj.insert(1);
        obj.insert(3);
        obj.insert(6);
        obj.insert(8);
        obj.inorder(obj.root);
        obj.verticalOrderTraversal(obj.root, 0);
        System.out.println();
        for(Map.Entry<Integer, ArrayList<Node>> i : obj.level.entrySet()) {
            System.out.print(i.getKey() + " - " + i.getValue().size() + " -> ");
            for(Node j : i.getValue()) {
                System.out.print(j.data + "");
            }
            System.out.println();
        }
        
    }

}
