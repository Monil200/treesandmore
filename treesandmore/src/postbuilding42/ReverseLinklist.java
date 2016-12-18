package postbuilding42;
class LinkNode {
    int data;
    LinkNode next;
    public LinkNode(int val) {
        data = val;
    }
}
public class ReverseLinklist {
    LinkNode head;
    
    public void insert(int val) {
        if (head == null) {
            head = new LinkNode(val);
        } else {
            LinkNode newNode = new LinkNode(val);
            newNode.next = head;
            head = newNode;
        }
    }
    
    public void traverse(LinkNode head) {
        if (head == null) {
            return;
        } else {
            System.out.print(head.data + ",");
            traverse(head.next);
        }
    }
    
    public void reverseLL(LinkNode head) {
        if (head == null) {
            System.out.println("return");
            return;
        } else {
            LinkNode nextNode = null;
            LinkNode prev = null;
            LinkNode current = head;
            while(current!=null) {
                nextNode = current.next;
                current.next = prev;
                prev = current;
                current = nextNode;
            }
            head = prev;
            traverse(head);
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ReverseLinklist obj = new ReverseLinklist();
        obj.insert(5);
        obj.insert(4);
        obj.insert(3);
        obj.insert(1);
        obj.traverse(obj.head);
        System.out.println("\nPrint after reverse : ");
        obj.reverseLL(obj.head);
    }

}
