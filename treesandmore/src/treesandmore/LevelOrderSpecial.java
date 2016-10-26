package treesandmore;
import java.util.Stack;
public class LevelOrderSpecial {
     public static Node root;
     public LevelOrderSpecial() {
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
     
     public void specialLevelOrder(Node root) {
         if (root == null) {
             return;
         } else {
             Stack<Node> readStack = new Stack<Node>();
             Stack<Node> answerStack = new Stack<Node>();
             readStack.push(root);
             answerStack.push(root);
             answerStack.push(null);
             int stackCount = readStack.size();
             Node pop1;
             Node pop2 =null;
             int count=0;
             while(true) {
                 stackCount = readStack.size();
                 if (stackCount == 0) {
                     break;
                 }
                 while(stackCount > 0) {
                     pop1 = readStack.pop();
                     stackCount--;
                     if (stackCount>0) {
                         pop2 = readStack.pop();
                         stackCount--;
                     }
                     if (pop1.left != null) {
                         answerStack.push(pop1.left);
                         readStack.push(pop1.left);
                     }
                     if (count > 0) {
                         if(pop2!=null && pop2.right != null) {
                             answerStack.push(pop2.right);
                             readStack.push(pop2.right);
                         }
                     }
                     if (pop1.right != null) {
                         answerStack.push(pop1.right);
                         readStack.push(pop1.right);
                     }
                     if (count > 0) {
                         if(pop2.left != null &&pop2!=null) {
                             answerStack.push(pop2.left);
                             readStack.push(pop2.left);
                         }
                     }
                     count++;
                 }
                 answerStack.push(null);
             }
             while(answerStack.size() > 0) {
                 Node temp = answerStack.pop();
                 if (temp!=null) {
                     System.out.print(temp.data + ",");
                 } else {
                     System.out.println();
                 }
             }
         }
     }
     
     public static void main(String[] args) {
         // TODO Auto-generated method stub
         LevelOrderSpecial b = new LevelOrderSpecial();
         b.insert(4);
         b.insert(2);
         b.insert(6);
         b.insert(1);
         b.insert(3);
         b.insert(5);
         b.insert(7);
         System.out.println("Preorder traversal  \n");
         b.preOrderTraversal(root);
         System.out.println("\n");
         b.specialLevelOrder(root); // perfectly complete tree only
     }

}
