package treesandmore;
import java.util.*;


public class VerticalSum {
    
    public static Node root;
    public static HashMap<Integer,ArrayList<Node>> h = new HashMap<Integer,ArrayList<Node>>();
    public VerticalSum() {
        root = null;
    }
    
    public void insert(int val) {
        if (root == null) {
            root = new Node(val);
        } else {
            Node newNode = new Node(val);
            Node current = root;
            while(true) {
                if (newNode.data < current.data) {
                    if (current.left !=null) {
                        current = current.left;
                        continue;
                    } else {
                        current.left = newNode;
                        return;
                    }
                } else {
                    if (current.right != null) {
                        current = current.right;
//                        continue;
                    } else {
                        current.right = newNode;
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
    
    // collect nodes with distance from root in HM
    public HashMap<Integer,ArrayList<Node>> verticalSumUtil(Node root, int leftDistance) {
        if (root == null) {
            return null;
        } else {
            ArrayList<Node> list = new ArrayList<Node>();
            if (h.containsKey(leftDistance)) {
                System.out.println(root.data + " - "+leftDistance + "- if");
                list = h.get(leftDistance);
                list.add(root);
                h.put(leftDistance, list);
            } else {
                System.out.println(root.data + " - "+leftDistance + "- else");
                list.add(root);
                h.put(leftDistance, list);
            }
            //list.clear();
            verticalSumUtil(root.left, leftDistance-1);
            verticalSumUtil(root.right, leftDistance+1);
            return h;
        }
    }
    
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        VerticalSum b = new VerticalSum();
        b.insert(4);
        b.insert(2);
        b.insert(1);
        b.insert(3);
        b.insert(8);
        b.inorderTraversal(root);
        System.out.println("\n printExtremeLevelNodesAlternate");
        b.verticalSumUtil(root, 0);
        System.out.println("HM size " + h.size());
        Set <Map.Entry<Integer,ArrayList<Node>>> s = h.entrySet();
        for(Map.Entry<Integer, ArrayList<Node>> i : s) {
            System.out.print("Level "+i.getKey() + ": ");
            int size = i.getValue().size();
            int sum=0;
            ArrayList<Node> list = i.getValue();
            for(int j=0;j<size;j++) {
                sum+=list.get(j).data;
            }
            System.out.println(sum);
        }
        }

}
