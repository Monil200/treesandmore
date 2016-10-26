package treesandmore;

public class DoubleATree {
     public static Node root;
     public DoubleATree() {
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
     
     
     public void doubleATree(Node root) {
         if (root == null) {
             return;
         } else {
             doubleATree(root.left);
             doubleATree(root.right);
             Node temp = root.left;
             Node newNode = new Node(root.data);
             newNode.left = temp;
             root.left = newNode;
         }
     }
 
 
 
     public static void main(String[] args) {
         // TODO Auto-generated method stub
         DoubleATree b = new DoubleATree();
         b.insert(4);
         b.insert(2);
         b.insert(6);
         System.out.println("Preodre traversal before doubling \n");
         b.preOrderTraversal(root);
         b.doubleATree(root);
         System.out.println("\nPreodre traversal after doubling \n");
         b.preOrderTraversal(root);
     }

}
