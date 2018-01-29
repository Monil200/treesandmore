package treessandtrees;
import java.util.*;
public class DuplicateSubtrees {
    Node root;
    DuplicateSubtrees() {
        root = null;
    }
    public String postorder(Node cur, Map<String, Integer> map, List<Node> res) {
        if (cur == null) return "#";  
        String serial = cur.data + "," + postorder(cur.left, map, res) + "," + postorder(cur.right, map, res);
        if (map.getOrDefault(serial, 0) >= 1) 
            res.add(cur);
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        return serial;
    }
    
    public void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + ",");
        inorder(root.right);
    }
    public static void main(String[] args) {
        
        DuplicateSubtrees obj = new DuplicateSubtrees();
        obj.root = new Node(1);
        obj.root.left = new Node(2);
        obj.root.left.right = new Node(4);
        
        obj.root.right = new Node(2);
        obj.root.right.right = new Node(4);
        obj.inorder(obj.root);
        System.out.println();
        List<Node> res = new LinkedList<>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        obj.postorder(obj.root, map, res);
        Iterator<Node> it = res.iterator();
        System.out.println("Nodes with dup subtrees");
        while(it.hasNext()) {
            System.out.println(it.next().data + ",");
        }
        
        System.out.println("Map contents----");
        Set<Map.Entry<String, Integer>> st = map.entrySet();
        for(Map.Entry<String, Integer> i : st) {
            System.out.println(i.getKey() + " - " + i.getValue());
        }
    }

}
