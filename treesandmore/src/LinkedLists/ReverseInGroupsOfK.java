package LinkedLists;

public class ReverseInGroupsOfK {
    Node head;
    
    public void insert(int val) {
        if (head == null) {
            head = new Node(val);
        } else {
            Node newNode = new Node(val);
            newNode.next = head;
            head = newNode;
        }
     }
    
    public void traverse(Node head) {
        if (head == null) {
            return;
        } else {
            while(head!= null) {
                System.out.print(head.data + ",");
                head = head.next;
            }
        }
    }
    
    public void prepareLL(int k) {
        if (head == null) {
            return;
        } else {
            int size = 0;
            Node prev = null;
            Node current = head;
            while(current!= null) {
                prev = current;
                current = current.next;
                size++;
                if (size == k) {
                    Node newNode = new Node(-99);
                    prev.next = newNode;
                    newNode.next = current;
                    size = 0;
                }
            }
        }
    }
    
    public void reverseInGroupsofK(int k) {
        if (head == null) {
            return;
        } else {
            Node current = head;
            Node prev = null;
            Node next = null;
            int count = 0;
            boolean isFirst = true;
            Node firstPrev = null;
            Node dummy = null;
            Node prevDummy = null;
            while(current!=null) {
                System.out.println("current:" + current.data);
                if (current.data == -99) {
                    count =0;
                    // do reverse;
                    prevDummy = dummy;
                    dummy = current;
                    if (isFirst) {
                        head = prev;
                        firstPrev.next = dummy;
                        isFirst = false;
                    } else {
                        firstPrev.next = dummy;
                        prevDummy.next = prev; 
                    }
                    prev = current;
                    current = current.next;
                } else {
                    next = current.next;
                    current.next = prev;
                    prev = current;
                    if (count == 0) {
                        firstPrev = prev;
                    }
                    current = next;
                    count++;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ReverseInGroupsOfK obj = new ReverseInGroupsOfK();
        obj.insert(5);
        obj.insert(4);
        obj.insert(3);
        obj.insert(2);
        obj.insert(1);
        obj.traverse(obj.head);
        int groupSize = 3;
        obj.prepareLL(groupSize);
        System.out.println("\n Traverse after modification");
        obj.traverse(obj.head);
        obj.reverseInGroupsofK(2);
        System.out.println("\n Traverse after reverse");
        obj.traverse(obj.head);
    }

}
