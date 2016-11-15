package LinkedLists;
class DNode{
    int data;
    DNode prev;
    DNode next;
    public DNode(int val) {
        prev = next = null;
        data = val;
    }
}
public class ReverseDLL {
    DNode head;
    public ReverseDLL() {
        head = null;
    }
    
    public void insert(int val) {
        if (head == null) {
            head = new DNode(val);
        } else {
            DNode newNode =new DNode(val);
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }
    
    public void traverseDLL(DNode head) {
        if (head == null) {
            return;
        } else {
            DNode current = head;
            while(current!=null) {
                System.out.print(current.data + ",");
                current= current.next;
            }
            System.out.println();
        }
    }
    
    public void reverseDLL(DNode head) {
        if (head == null) {
            return;
        } else {
            DNode current = head;
            DNode prev = null;
            DNode next = null;
            while(current!=null) {
                next = current.next;
                current.next = prev;
                current.prev = next;
                prev = current;
                current = next;
            }
            head = prev;
            head.prev = null;
            
            traverseDLL(head);
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ReverseDLL obj = new ReverseDLL();
        obj.insert(5);
        obj.insert(4);
        obj.insert(3);
        obj.insert(2);
        obj.insert(1);
        obj.traverseDLL(obj.head);
        obj.reverseDLL(obj.head);
    }

}
