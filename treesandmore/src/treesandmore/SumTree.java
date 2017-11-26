package treesandmore;

public class SumTree {
     public Node root;
     public SumTree() {
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
     
     
     public int convertToSum(Node root) {
         if (root == null) {
             return 0;
         } else {
             int old = root.data;
             root.data = convertToSum(root.left) + convertToSum(root.right);
             return root.data + old;
         }
     }
     
     public int convertToSumV3(Node root) {
         if (root == null) {
             return 0;
         } else {
             if (root.left == null && root.right == null) {
                 int rootD = root.data;
//                 root.data = 0; // to so isSumTreeV3 check, but as per g4g it should be 0..
                 return rootD;
             }
             int rootData = root.data;
             root.data = convertToSumV3(root.left) + convertToSumV3(root.right);
             return rootData + root.data;
         }
     }
     
     public boolean isSumTreeV3(Node root) {
         if (root == null || (root.left == null && root.right==null))
             return true;
         else {
             isSumTreeV3(root.left);
             isSumTreeV3(root.right);
             int ldata = (root.left!=null) ? root.left.data : 0;
             int rdata = (root.right!=null) ? root.right.data : 0;
             if (root.data == (ldata + rdata))
                 return true;
             else {
                 return false;
             }
         }
     }
     
     public void convertToSumV2(Node root) {
         if (root == null || (root.left == null && root.right == null)) {
             return;
         } else {
             convertToSumV2(root.left);
             convertToSumV2(root.right);
             root.data += root.left.data + root.right.data;
         }
     }
     
     public int getSum(Node root) {
         if (root == null) {
             return 0;
         } else {
             return getSum(root.left) + root.data + getSum(root.right);
         }
     }
     
     public boolean isSumTree(Node root) {
         if (root == null || (root.left == null && root.right == null)) {
             return true;
         } else {
             return (root.data == (getSum(root.left) + getSum(root.right)) && isSumTree(root.left) && isSumTree(root.right));
         }
     }
     
     
 
 
 
     public static void main(String[] args) {
         // TODO Auto-generated method stub
         SumTree b = new SumTree();
         b.insert(4);
         b.insert(2);
         b.insert(6);
         System.out.println("Preodre traversal before convertSum \n");
         b.preOrderTraversal(b.root);
         b.convertToSum(b.root);
         System.out.println("Preodre traversal after convertSum \n");
         b.preOrderTraversal(b.root);
         
         Node n = new Node(26);
         n.left = new Node(10);
         n.left.left = new Node(6);
         n.left.right = new Node(4);
         
         n.right = new Node(3);
         n.right.left = new Node(3);
         
         System.out.println("\n is sumTree in O(n^2)\n" + b.isSumTree(n));
         
         
         Node n1 = new Node(1);
         n1.left = new Node(2);
         n1.right = new Node(3);
         n1.left.left = new Node(4);
         n1.left.right = new Node(5);
         
         n1.right.left = new Node(6);
         n1.right.right = new Node(7);
         
         System.out.println("Preodre traversal before convertSumV2 \n");
         b.preOrderTraversal(n1);
         b.convertToSumV2(n1);
         System.out.println("Preodre traversal after convertSumV2 \n");
         b.preOrderTraversal(n1);
         
         
         SumTree b1 = new SumTree();
         b1.insert(40);
         b1.insert(20);
         b1.insert(60);
         b1.insert(80);
         b1.insert(10);
         b1.insert(30);
         b.convertToSumV3(b1.root);
         System.out.println("\n Preodre traversal before convertSumV3 \n");
         b.preOrderTraversal(b1.root);
         System.out.println("\n Is SumTree V3? - " + b.isSumTreeV3(b1.root));
     }

}

