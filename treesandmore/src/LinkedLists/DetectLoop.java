package LinkedLists;

public class DetectLoop {
    
    public Node push(Node head,int val) {
        if (head == null) {
            return new Node(val);
        } else {
            Node current = new Node(val);
            current.next = head;
            head = current;
            return head;
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
    
    public void detectLoop(Node head) {
        if (head == null) {
            return;
        } else {
            Node fast = head.next;
            Node slow = head;
            int counter = 0;
            while (slow != fast) { // this is for detecting loop
                counter++;
                if (counter%2 == 0) {
                    slow = slow.next;
                }
                fast = fast.next;
                if (slow == fast) {
                    System.out.println("Loop detected");
                    break;
                }
            }
            Node slowCopy = slow;
            slow = slow.next;
            counter=0;
            while(slow!=slowCopy) { // this is the number of nodes in loop
                counter++;
                slow = slow.next;
            }
            System.out.println("Number of nodes in loop:" + ++counter);
            Node near = head;
            Node far = head;
            Node prev = null;
            int counterToReach = 0;
            while(counterToReach != counter) {
                counterToReach++;
                prev = far;
                far = far.next;
            }
            System.out.println("Near:" + near.data + " far:" + far.data + " prev:" + prev.data);
            while(far !=near) {
                prev = far;
                far = far.next;
                near = near.next;
            }
            prev.next = null;
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Node head = null;
        Node temp = null;
        DetectLoop l = new DetectLoop();
        head = l.push(head,4);
        temp = head;
        head = l.push(head,3);
        head = l.push(head,2);
        head = l.push(head,1);
        temp.next = head;
//        l.traversal(head);
        l.detectLoop(head);
        System.out.println("Traversal after detecting and removing loop");
        l.traversal(head);
    }

}

