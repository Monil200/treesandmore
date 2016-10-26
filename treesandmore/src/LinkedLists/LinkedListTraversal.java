package LinkedLists;

class Node {
    int data;
    Node next;
    public Node(int val) {
        this.data = val;
        this.next = null;
    }
}
public class LinkedListTraversal {
    
    public static Node head;
    public void push(int val) {
        if (head == null) {
            head = new Node(val);
        } else {
            Node current = new Node(val);
            current.next = head;
            head = current;
        }
    }
    
    public void traversal(Node head) {
        if (head == null) {
            return;
        } else {
            Node current = head;
            while(current!=null) {
                System.out.print(current.data + ",");
                current = current.next;
            }
        }
    }
    
    public void traversalRecursive(Node head) {
        if (head == null) {
            return;
        } else {
            System.out.print(head.data + ",");
            traversalRecursive(head.next);
        }
    }
    
    public void printReverseRecursive(Node head) {
        if (head == null) {
            return;
        } else {
            Node temp = head;
            printReverseRecursive(temp.next);
            System.out.print(head.data + ",");
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LinkedListTraversal l = new LinkedListTraversal();
        l.push(4);
        l.push(3);
        l.push(2);
        l.push(1);
        System.out.println("--------My First Java Linkedlist Traversal-----------");
        l.traversal(head);
        System.out.println("--------My First Java Linkedlist Traversal recursive-----------");        
        l.traversalRecursive(head);
        System.out.println("--------Linkedlist Traversal Reverse recursive-----------");
        l.printReverseRecursive(head);
    }

}
