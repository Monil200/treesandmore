
class Node {
    int val;
    Node next;
    Node (int v) {
        val = v;
        next = null;
    }
}

public class ReverseLL {

    public static void main(String args[]) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        Node reversedHead = reverseLL(head);
        Node current = reversedHead;
        while(current != null) {
            System.out.println("Node data:" + current.val);
            current = current.next;
        }

    }

    // Returns head of reversed LL
    public static Node reverseLL(Node head) {

        if (head == null) {
            return null; // return null
        }

        Node current = head;
        Node prev = null;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev; // prev is the last valid node, which means new head.
    }
}
