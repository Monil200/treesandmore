package LinkedLists;

public class DeleteNode {
    
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
    public void deleteNode(int n) {
        if (head == null) {
            return;
        } else {
            // if head is to be deleted.
            while (head.data == n) {
                head = head.next;
            }
            Node current = head.next;
            Node prev = head;
            // delete all occurance of given node
            while(current!=null) {
                if (current.data == n) {
                    prev.next = current.next;
                }
                prev = current;
                current = current.next;
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DeleteNode l = new DeleteNode();
        l.push(8);
        l.push(7);
        l.push(1);
        l.push(6);
        l.push(5);
        l.push(4);
        l.push(3);
        l.push(2);
        l.push(1);
        l.push(1);
        l.traversal(head);
        l.deleteNode(1);
        System.out.println(" \n Traversae after Delete");
        l.traversal(head);
    }

}
