package treesandmore;
import java.util.*;

class LinkNode {
    int data;
    LinkNode next;
    public LinkNode(int val) {
        this.data = val;
        this.next = null;
    }
}

public class LLToCompleteBT {
     public static Node root;
     public static LinkNode head;
     public LLToCompleteBT() {
         root = null;
         head = null;
     }
     
     public LinkNode push(int val) {
         if (head == null) {
             return new LinkNode(val);
         } else {
             LinkNode temp = new LinkNode(val);
             temp.next = head;
             head = temp;
             return head;
         }
     }
     
     public void linkTraverse(LinkNode head) {
         if (head == null) {
             return;
         } else {
             LinkNode temp = head;
             while(temp!=null) {
                 System.out.print(temp.data + ",");
                 temp = temp.next;
             }
         }
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
     public void inorder(Node root) {
         if (root == null) {
             return;
         } else {
             inorder(root.left);
             System.out.print(root.data +  ",");
             inorder(root.right);
         }
     }
     
     
     public void createBTFromLL(LinkNode head) {
         if (head == null) {
             return;
         } else {
             Queue<Node> rootQueue = new LinkedList<Node>();
             Node currentRoot = null;
             LinkNode currentHead = head;
             int nodeCompleted = 0;
             if (currentHead!=null) {
                 currentRoot = new Node(currentHead.data);
                 root = currentRoot;
             }
             currentHead = currentHead.next;
             while(currentHead!=null) {
                 if (nodeCompleted%2 == 0) {
                     currentRoot.left = new Node(currentHead.data);
                     rootQueue.add(currentRoot.left);
                 } else {
                     currentRoot.right = new Node(currentHead.data);
                     rootQueue.add(currentRoot.right);
                 }
                 currentHead = currentHead.next;
                 nodeCompleted++;
                 if (nodeCompleted == 2) {
                     nodeCompleted = 0;
                     currentRoot = rootQueue.remove();
                 }
             }
         }
     }
     
     
     
 
 
 
     public static void main(String[] args) {
         // TODO Auto-generated method stub
         LLToCompleteBT b = new LLToCompleteBT();
         
         System.out.println("\nlink list traversal\n");
         head = b.push(5);
         head = b.push(4);
         head = b.push(3);
         head = b.push(2);
         head = b.push(1);
         
         b.linkTraverse(head);
         
         System.out.println("Inorder traversal after creating Tree \n");
         b.createBTFromLL(head);
         
         System.out.println("\nlink list traversal\n");
         b.inorder(root);
     }

}
