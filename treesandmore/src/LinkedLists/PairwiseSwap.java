package LinkedLists;

public class PairwiseSwap {
    
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
    public void pairwiseSwap() {
        if (head == null || head.next==null) {
            return;
        } else {
            Node current = head.next;
            Node prev = head;
            int temp;
            while(current!=null) {
                temp = current.data;
                current.data = prev.data;
                prev.data = temp;
                if (current.next == null || current.next.next==null) {
                    break;
                }
                prev = current.next;
                current = current.next.next;
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        PairwiseSwap l = new PairwiseSwap();
        l.push(9);
        l.push(8);
        l.push(7);
        l.push(6);
        l.push(5);
        l.push(4);
        l.push(3);
        l.push(2);
        l.push(1);
        l.traversal(head);
        l.pairwiseSwap();
        System.out.println(" \n Traverse after PairwiseSwap");
        l.traversal(head);
    }

}
