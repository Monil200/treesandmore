package LinkedLists;
//class Node{
//    int data;
//    Node next;
//    public Node(int val) {
//        this.data = val;
//        this.next = null;
//    }
//}

public class MoveANode {
    public static Node head;
    
    public MoveANode() {
        head = null;
    }
    
    public void insert(int val) {
        if (head == null) {
            head = new Node(val);
        } else {
            Node temp = new Node(val);
            temp.next = head;
            head = temp;
        }
    }
    
    void traversal(Node head) {
        if (head == null) {
            return;
        } else {
            System.out.print(head.data + ",");
            traversal(head.next);
        }
    }
    
    void moveNode(Node head, int targetLocation, int nodeVal) {
        if (head == null) {
            return;
        } else {
            // get Target node's next
            Node target = head;
            while(target !=null && target.data != nodeVal) {
                target = target.next;
            }
            // get previous of targetLocation
            Node temp = head;
            Node prev = null;
            int count =1;
            while(temp!=null && count < targetLocation) {
                prev = temp;
                temp = temp.next;
                count++;
            }
            
            // switch next links
            prev.next = target;
            temp.next = target.next;
            target.next = temp;
//            System.out.println("Next is" + target.next);
//            System.out.println("Previous of target location is " + prev.data);
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MoveANode obj = new MoveANode();
        obj.insert(4);
        obj.insert(3);
        obj.insert(2);
        obj.insert(1);
        obj.traversal(head);
        obj.moveNode(head, 2,4);//move 4 to 3rd location
        System.out.print("\n Traversal after moving nodes \n");
        obj.traversal(head);
    }

}
