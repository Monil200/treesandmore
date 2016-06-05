package treesandmore;

public class FloorCeiling {
 public static Node root;
 public FloorCeiling() {
     root = null;
 }
 
 public void insert(int val) {
     if (root == null) {
         root = new Node(val);
         return;
     } else {
         Node current = root;
         while (true) {
             if (current.data > val) {
                 if (current.left !=null) {
                     current = current.left;
                     continue;
                 } else {
                     current.left = new Node(val);
                     return;
                 }
             }
             if (current.data < val) {
                 if (current.right !=null) {
                     current = current.right;
                     continue;
                 } else {
                     current.right = new Node(val);
                     return;
                 }
             }
         }
     }
 }
 
 public void preOrderTraversal(Node root) {
     if (root == null) {
         return;
     } else {
         preOrderTraversal(root.left);
         System.out.print(root.data +  " , ");
         preOrderTraversal(root.right);
     }
 }
 
 public int floor(Node root, int target) {
     if (root == null) {
         return 0;
     } else {
         if (root.data == target) {
             return root.data;
         }
         if (target < root.data)
             return floor(root.left, target);
         else {
             int floor = floor(root.right, target);
             return (floor!=0) ? floor : root.data;
         }
     }
 }
 
 public int ceiling(Node root, int target) {
     if (root == null) {
         return 0;
     } else {
         if (root.data == target) {
             return root.data;
         }
         if (target > root.data)
             return ceiling(root.right, target);
         else {
             int ceiling = ceiling(root.left, target);
             return (ceiling!=0) ? ceiling : root.data;
         }
     }
 }
 
 public static void main(String[] args) {
     // TODO Auto-generated method stub
     FloorCeiling b = new FloorCeiling();
     b.insert(4);
     b.insert(2);
     b.insert(10);
     b.insert(1);
     b.insert(3);
     b.insert(5);
     b.insert(7);
     //           4
     //         /   \
     //        2     10
     //       / \   / \
     //      1   3 5   7
     b.preOrderTraversal(root);
     System.out.println();
     System.out.println(b.floor(root, 6)); // node with largest data smaller than key
     System.out.println(b.ceiling(root, 6)); // node with smallest data larger than key
     
 }

}
