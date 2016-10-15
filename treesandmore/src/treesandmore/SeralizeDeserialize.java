package treesandmore;
import java.util.*;

public class SeralizeDeserialize {
    public static Node root;
    public SeralizeDeserialize() {
        root = null;
    }
    public String[] seralize(Node root) {
        
        if (root == null) {
            return null;
        } else {
            Stack<Node> s = new Stack<Node>();
            Node current = root;
            s.push(current);
            String data ="";
            while(!s.isEmpty()) {
                current = s.pop();
                if(current == null) {
                    data+="#,";
                } else {
                    data += (current.data + ",");
                    s.push(current.right);
                    s.push(current.left);
                }
            }
            return data.split(",");
        }
    }
    public Node deserizlize(String data[]) {
        if (data[0].equals("#")) {
            return null ;
        } else {
            int count[] = {0};
            System.out.println(Arrays.toString(data));
            return helper(data, count);
            
        }
    }
    
    public Node helper(String data[], int[] nthNode) {
        if(data[nthNode[0]].equals("#")) {
            return null;
        }
        
        Node node = new Node(Integer.parseInt(data[nthNode[0]]));
        System.out.println(nthNode[0] + "<- left call");
        nthNode[0]+=1;
        node.left = helper(data, nthNode);
        System.out.println(nthNode[0] + "<- right call");
        nthNode[0]+=1;
        node.right = helper(data, nthNode);
        return node;
    }
    
    public void inorderTraversal(Node root) {
        if (root == null) {
            return;
        } else {
            inorderTraversal(root.left);
            System.out.print(root.data + ",");
            inorderTraversal(root.right);
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SeralizeDeserialize obj = new SeralizeDeserialize();
        root = new Node(4);
        root.left = new Node(2);
        root.left.right = new Node(3);
        root.right = new Node(6);
        root.right.right = new Node(8);
        String data[] = obj.seralize(root);
        obj.inorderTraversal(obj.deserizlize(data));
    }

}
