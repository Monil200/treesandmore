package LinkedLists;

public class NthFromLast {
    
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
    public void findNthFromLast(Node head, int n) {
        if (head == null) {
            return;
        } else {
            Node current = head;
            Node startNthFromFirst = head;
            int counter = 0;
            while(current!=null) {
                counter++;
                if (counter > n) {
                    startNthFromFirst = startNthFromFirst.next;
                }
                current = current.next;
            }
            System.out.println("Nth node ("+n+") from last is " + startNthFromFirst.data);
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        NthFromLast l = new NthFromLast();
        l.push(8);
        l.push(7);
        l.push(6);
        l.push(5);
        l.push(4);
        l.push(3);
        l.push(2);
        l.push(1);
        System.out.println("--------My First Java Linkedlist Traversal-----------");
        l.traversal(head);
        l.findNthFromLast(head, 8);
    }

}
