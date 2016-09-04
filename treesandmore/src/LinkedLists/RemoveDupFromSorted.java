package LinkedLists;

public class RemoveDupFromSorted {
    
    public Node push(Node head,int val) {
        if (head == null) {
            return new Node(val);
        } else {
            Node current = new Node(val);
            current.next = head;
            head = current;
            return head;
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
    
    public void removeDuplicates(Node head) {
        if (head == null) {
            return;
        } else {
            Node prev = head;
            Node current = prev.next;
            while(current!=null) {
                while(current!=null && prev.data == current.data) {
                    current = current.next;
                }
                prev.next = current;
                prev = current;
                if (current!=null)
                    current = current.next;
            }
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Node head = null;
        RemoveDupFromSorted l = new RemoveDupFromSorted();
        head = l.push(head,6);
        head = l.push(head,6);
        head = l.push(head,4);
        head = l.push(head,3);
        head = l.push(head,1);
        head = l.push(head,1);
        head = l.push(head,1);
        l.traversal(head);
        System.out.println("\n LinkedList after dup removal");
        l.removeDuplicates(head);
        l.traversal(head);
    }

}

