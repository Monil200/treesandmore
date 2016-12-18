package postbuilding42;
import java.util.*;
public class SerializeDeserialize {
    Node root;
    Node dRoot; // deserialized
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
    
    public String[] serialize(Node root) {
        if (root == null) {
            return null;
        } else {
            Stack<Node> s = new Stack<Node>();
            s.push(root);
            String data = "";
            Node current = null;
            while(!s.isEmpty()) {
                current = s.pop();
                if (current != null) {
                    data += current.data + ",";
                    s.push(current.right);
                    s.push(current.left);
                } else { 
                    data += "#,";
                }
            }
            return data.split(",");
        }
    }
    
    public void deSerialize(String a[]) {
        if (a == null || a.length == 0) {
            return;
        } else {
            int index[] = {0};
            dRoot = helperDeserialize(dRoot, index,a);
            inorder(dRoot);
        }
    }
    
    public Node helperDeserialize(Node root, int a[], String[] data) {
        if (data[a[0]].equals("#")) {
            return null;
        }
            
        root = new Node(Integer.parseInt(data[a[0]]));
        a[0]++;
        root.left = helperDeserialize(root.left, a,data);
        a[0]++;
        root.right = helperDeserialize(root.right, a,data);
        return root;
    }
    
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SerializeDeserialize obj = new SerializeDeserialize();
        obj.insert(4);
        obj.insert(2);
        obj.insert(1);
        obj.insert(3);
        obj.insert(6);
        obj.insert(8);
        obj.inorder(obj.root);
        System.out.println();
        System.out.println(Arrays.toString(obj.serialize(obj.root)));
        obj.deSerialize(obj.serialize(obj.root));
    }

}
