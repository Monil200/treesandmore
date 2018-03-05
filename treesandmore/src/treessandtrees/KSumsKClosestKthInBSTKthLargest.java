package treessandtrees;
import java.util.*;
class MyPoint {
    int x,y;
    double distance;
    MyPoint(int xx, int yy) {
        x = xx;
        y = yy;
    }
    MyPoint(int xx, int yy, MyPoint origin) {
        x = xx;
        y = yy;
        distance = Math.sqrt(Math.pow(Math.abs(xx - origin.x), 2) + Math.pow(Math.abs(yy - origin.y), 2));
    }
}
public class KSumsKClosestKthInBSTKthLargest {
    // tree section
    NodeM root;
    KSumsKClosestKthInBSTKthLargest() {
        root = null;
    }
    
    public void insert(int val) {
        if (root == null) {
            root = new NodeM(val);
        } else {
            NodeM current = root;
            NodeM newNode = new NodeM(val);
            while(true) {
                if (current.data >= val) {
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
    
    public void inorder(NodeM root) {
        if (root == null)
            return;
        else {
            inorder(root.left);
            System.out.print(root.data + " (size: " + root.size+ "| height: " + root.height + "), ");
            inorder(root.right);
        }
    }
    
    public int getMemoizedSizes(NodeM root) {
        if (root == null)
            return 0;
        root.size = getMemoizedSizes(root.left) + getMemoizedSizes(root.right) + 1;
        return root.size;
    }
    
    public int getHeightOfBt(NodeM root) {
        if (root==null)
            return 0;
        else {
            int l = getHeightOfBt(root.left);
            int r = getHeightOfBt(root.right);
            
            return Math.max(l, r) + 1;
        }
    }
    public int getMomoizedHeights(NodeM root) {
        if (root == null)
            return 0;
        else {
            root.height = Math.max(getMomoizedHeights(root.left), getMomoizedHeights(root.right)) + 1;
            return root.height;
        }
    }
    
    public void getKthElementinBT(NodeM root, int k) {
        if (root == null)
            return;
        int countLeft = (root.left!=null) ? root.left.size : 0;
        if (countLeft == k-1) {
            System.out.println("Kth element is" + root.data);
        } else {
            if (countLeft >= k) {
                getKthElementinBT(root.left, k);
            } else {
                getKthElementinBT(root.right, k - countLeft - 1);
            }
        }
    }
    
    // k closest section
    
    public void getKClosestPoints(HashSet<MyPoint> points, int k) {
        PriorityQueue<MyPoint> pq = new PriorityQueue<MyPoint>(
            new Comparator<MyPoint>() {
                public int compare(MyPoint a, MyPoint b) {
                    if (b.distance >= a.distance) {
                        return 1; // descending
                    } else if (b.distance < a.distance) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            }
        );
        
        Iterator<MyPoint> it = points.iterator();
        int counter = 0;
        
        while(it.hasNext()) {
            MyPoint temp = it.next();
            if (counter < k) {
                pq.add(temp);
            } else if (pq.peek().distance > temp.distance) {
                pq.poll();
                pq.add(temp);
            }
            counter++;
        }
        
        while(pq.size() > 0) {
            MyPoint polled = pq.poll();
            System.out.println("distance:" + polled.distance + " x:" + polled.x + " y:" + polled.y);
        }
        
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        KSumsKClosestKthInBSTKthLargest obj = new KSumsKClosestKthInBSTKthLargest();
        obj.insert(4);
        obj.insert(2);
        obj.insert(1);
        obj.insert(-1);
        obj.insert(3);
        obj.insert(6);
        obj.insert(5);
        obj.insert(7);
        obj.getMemoizedSizes(obj.root);
        obj.getMomoizedHeights(obj.root);
        obj.inorder(obj.root);
        
        System.out.print("\n Kth node is: ");
        obj.getKthElementinBT(obj.root, 4);
        
        System.out.print("\n Height of BT is:" + obj.getHeightOfBt(obj.root));
        
        // k closest
        System.out.print("\n K closes points are: \n");
        MyPoint origin = new MyPoint(0,0);
        MyPoint p1 = new MyPoint(3,4, origin);
        MyPoint p2 = new MyPoint(10,3, origin);
        MyPoint p3 = new MyPoint(-4,4, origin);
        MyPoint p5 = new MyPoint(112,1, origin);
        MyPoint p4 = new MyPoint(6,12, origin);
        
        HashSet<MyPoint> set = new HashSet<MyPoint>();
        set.add(p1);set.add(p2);set.add(p3);set.add(p4);set.add(p5);
        
        obj.getKClosestPoints(set, 3);
    }

}
