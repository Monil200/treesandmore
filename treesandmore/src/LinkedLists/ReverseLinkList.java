package LinkedLists;

public class ReverseLinkList {
    
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
    
    public void traversal() {
        if (head == null) {
            return;
        } else {
            Node temp = head;
            while(temp!=null) {
                System.out.print(temp.data+ ",");
                temp = temp.next;
            }
        }
    }
    
    public void reverseRecursive(Node head) {
        if (head == null) {
            return;
        } else {
            reverseRecursive(head.next);
            System.out.print(head.data+",");
        }
    }
    
    public void reverseIterative() {
        if (head == null || head.next == null) {
            return;
        } else {
            Node prev = head;
            Node current = head.next;
            Node next = null;
            int counter = 0;
            while(current!=null) {
                counter++;
                if (counter == 1) {
                    prev.next = null;
                }
                next = current.next;
                current.next = prev;
                prev = current;
                head = current;
                current = next;
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ReverseLinkList l = new ReverseLinkList();
        l.push(5);
        l.push(4);
        l.push(3);
        l.push(2);
        l.push(1);
        System.out.println("Traverse a LL");
        l.traversal();
        System.out.println("Recursive Reverse LL");
        l.reverseRecursive(head);
        System.out.println("\n Iterative Reverse LL");
        l.reverseIterative();
        System.out.println("Traverse a LL after reverseIterative");
        l.traversal();
    }

}
