package treessandtrees;
class ListNode {
    int data;
    ListNode next;
    ListNode(int val) {
        data = val;
    }
}
public class ReverseLLVariations {
    ListNode head;
    ReverseLLVariations() {
        head = null;
    }
    
    public void insert(int val) {
        if (head == null) {
            head = new ListNode(val);
        } else {
            ListNode newNode = new ListNode(val);
            newNode.next = head;
            head = newNode;
        }
    }
    
    public int addOne(ListNode head) {
        if (head == null) {
            return 0;
        } else {
            if (head.next == null) {
                if (head.data + 1 > 9 ) {
                    head.data = (head.data + 1)%10;
                    return (int) (head.data + 1)%9; 
                } else {
                    head.data = (head.data + 1);
                    return 0;
                }
            } else {
                int ret = addOne(head.next);
                if (head.data + ret > 9 ) {
                    head.data = (head.data + ret)%10;
                    return (int) (head.data + ret)%9; 
                } else {
                    head.data = (head.data + ret);
                    return 0;
                }
            }
        }
    }
    
    public void reverseLL(ListNode head1) {
        if (head1 == null || head1.next == null)
            return;
        ListNode current = head1;
        ListNode prev = null;
        ListNode next = current.next;
        
        while(current!=null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;            
        }
        head = prev;
        
    }
    
    public void reverseLLFromStartEnd(ListNode h, int start, int end) {        
        if (h == null)
            return;
        
        ListNode startPrev = null;
        ListNode endNext = null;
        
        ListNode current = h;
        int counter = 1;
        startPrev = current;
        while(counter!=start) {
            startPrev = current;
            current = current.next;
            counter++;
        }
        while(current!=null && counter!=end) {
            current= current.next;
            counter++;
        }
        if (current.next != null) {
            endNext = current.next;
        } else {
            endNext = null; // end is either limit or beyond ll length
        }
        
        ListNode prev = null;
        ListNode next = null;
        current = startPrev.next;
        ListNode currentCopy = current;
        
        while(current!=endNext) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        startPrev.next = prev;
        currentCopy.next = endNext;
        
        
    }
    
    public void showLL(ListNode head) {
        ListNode current = head;
        while(current!=null) {
            System.out.print(current.data + ",");
            current = current.next;
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ReverseLLVariations obj = new ReverseLLVariations();
        obj.insert(5);
        obj.insert(4);
        obj.insert(3);
        obj.insert(2);
        obj.insert(1);
        obj.showLL(obj.head);
        
        // now reverse it;
        System.out.println();
//        obj.reverseLL(obj.head);
//        obj.showLL(obj.head);
        
        // reverse from i-j
        System.out.println();
        obj.reverseLLFromStartEnd(obj.head,2,5);
        obj.showLL(obj.head);
        
        ReverseLLVariations obj1 = new ReverseLLVariations();
        obj1.insert(9);
        obj1.insert(8);
        obj1.insert(1);
        
        obj1.addOne(obj1.head);
        ListNode current1 = obj1.head;
        System.out.println("Add one to LL");
        while(current1!=null) {
            System.out.print(current1.data + ", ");
            current1 = current1.next;
        }
        
        
    }

}
