package treessandtrees;
// 1. Saggregate even/odd nodes
// 2. K shift


public class LLManipulation {
    ListNode head;
    public void insert(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }
    
    public void print(ListNode h) {
        if (h == null)
            return;

        ListNode current = h;
        while(current!= null) {
            System.out.print(current.data + ", ");
            current = current.next;
        }
    }
    
    public void saggregateEvenOdd(ListNode h) {
        if (h == null)
            return;
        
        ListNode odd = head, even = head.next, evenHead = even;
        // awesome, copied from leetcode.
        while(even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
    }
    
    public void rightShift(ListNode h, int k) {
        if (k == 0 || h == null)
            return;
        int counter = 0;
        ListNode current = h;
        ListNode kthFromRight = h;
        ListNode kthFromRightPrev = null;
        ListNode currentPrev = null;
        while(current!=null) {
            if (counter >= k) {
                kthFromRightPrev = kthFromRight;
                kthFromRight = kthFromRight.next;
            }
            counter++;
            currentPrev = current;
            current = current.next;
        }
        
        currentPrev.next = head;
        kthFromRightPrev.next = null;
        head = kthFromRight;
        
        
        System.out.println("\nKthFromRight" + kthFromRight.data);
        System.out.println("KthFromRightPrev" + kthFromRightPrev.data);
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LLManipulation obj = new LLManipulation();
        obj.insert(6);
        obj.insert(5);
        obj.insert(4);
        obj.insert(3);
        obj.insert(2);
        obj.insert(1);
        obj.saggregateEvenOdd(obj.head);
        obj.print(obj.head);
        
        // rightshift 
        obj.rightShift(obj.head, 2);
        obj.print(obj.head);
    }

}
