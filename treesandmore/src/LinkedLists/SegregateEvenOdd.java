package LinkedLists;

public class SegregateEvenOdd {
    
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
    
    // since odd nodes which are moved to end of the list are not in the same order as they appear in original list,
    // we can craete new list just for odd nodes and append even nodes list to odd nodes list
    public void sagregateEvenOdd() {
        if (head == null || head.next==null) {
            return;
        } else {
            Node findeven = head;
            Node findodd = head;
            int temp;
            while(findodd!=null && findeven!=null) {
                while(findodd.data%2 == 0 && findodd!=null) {
                    findodd = findodd.next;
                }
                while(findeven!=null && findeven.data%2 == 1) {
                    findeven = findeven.next;
                }
                if (findeven != null && findodd!=null) {
                    System.out.println("\nOdd:" + findodd.data + " even:" + findeven.data);
                    temp = findodd.data;
                    findodd.data = findeven.data;
                    findeven.data = temp;
                    findodd = findodd.next;
                    findeven = findeven.next;
                    System.out.println("Traversal after  one loop");
                    traversal(head);
                }
            }
            
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SegregateEvenOdd l = new SegregateEvenOdd();
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
        l.sagregateEvenOdd();
        System.out.println(" \n Traverse after Sagregate even odd");
        l.traversal(head);
    }

}
