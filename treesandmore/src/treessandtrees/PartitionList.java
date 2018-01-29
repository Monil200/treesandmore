package treessandtrees;
/*
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
 */

class LNode {
    int data;
    LNode next,prev; // singly
    LNode(int val) {
        data = val;
    }
}
public class PartitionList {
    LNode head;
    PartitionList() {
        head = null;
    }
    public void display(LNode head) {
        LNode current = head;
        while(current!=null) {
            System.out.print(current.data + ",");
            current = current.next;
        }
        System.out.println();
    }
    
    public void insert(int val) {
        if (head == null)
            head = new LNode(val);
        else {
            LNode newNode = new LNode(val);
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }
    
    public void partition(LNode head, int target) {
        if (head == null)
            return;
        else {
            // 2 cases.
            // 1. head is less than target
            // 2. head is not less than target
            LNode low = null;
            LNode current  = head;
            while(current!= null) {
                System.out.println("current: " + current.data);
                if (current.data < target) { // move it to front
                    if (low == null) { // no low is formed yet
                        if (current == head) {
                            low = current;
                            System.out.println("low: " + low.data);
                        } else { // create new head
                            LNode newHead = current;
                            LNode prev = current.prev;
                            LNode next = current.next;
                            if (next != null) {
                                prev.next = next;
                            }
                            next.prev = prev;
                            newHead.next = head;
                            head.prev = newHead;
                            head = newHead;
                        }
                        current = current.next;
                    } else {
//                        Given 1->4->3->2->5->2 and x = 3,
                        LNode nextCurr = current.next;
//                        System.out.println("currentNext: " + nextCurr.data);
                        LNode lowPrev = low;
                        LNode lowNext = low.next;
                        
                        LNode prev = current.prev;
                        LNode next = current.next;
                        
                        if (next!=null) {
                            next.prev = prev;
                        }
                        prev.next = next;
                        
                        
                        lowPrev.next = current;
                        current.prev = lowPrev;
                        current.next = lowNext;
                        lowNext.prev = current;
                        low = current;
                        current = nextCurr;
                    }
                } else {
                    current = current.next;
                }
            }
            
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //Given 1->4->3->2->5->2 and x = 3
        
        PartitionList obj = new PartitionList();
        obj.insert(2);
        obj.insert(5);
        obj.insert(2);
        obj.insert(3);
        obj.insert(4);
        obj.insert(1);
        obj.display(obj.head);
        
        obj.partition(obj.head, 3);
        obj.display(obj.head);
    }

}
