package postbuilding42;

public class RearrageOddEvenPositionNodesLL {
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
    
    public void rearrange(LinkNode last, int length) {
        if (head == null) {
            return;
        } else {
            LinkNode current = head;
            LinkNode next = null;
            LinkNode nextNext = null;
            int index =0;
            while(index<length) {
                System.out.println("current:" + current.data);
                next = current.next;
                nextNext = next.next;
                
                current.next = nextNext;
                
                last.next = next;
                next.next = null;
                last = next;
                
                current = nextNext;
                index = index+2;
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        RearrageOddEvenPositionNodesLL obj = new RearrageOddEvenPositionNodesLL();
        obj.insert(5);
        obj.insert(4);
        obj.insert(3);
        obj.insert(2);
        obj.insert(1);
        obj.traverse(obj.head);
        LinkNode current = obj.head;
        LinkNode last = null;
        int length = 0;
        while(current != null) {
            last = current;
            current = current.next;
            length++;
        }
        System.out.println("last->" + last.data + " index" + length);
        
        if (length > 2)
            obj.rearrange(last,length);
        obj.traverse(obj.head);
        
    }

}
