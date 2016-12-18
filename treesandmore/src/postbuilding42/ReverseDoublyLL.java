package postbuilding42;
class DoublyLL {
    int data;
    DoublyLL prev;
    DoublyLL next;
    DoublyLL(int val) {
        data = val;
    }
}
public class ReverseDoublyLL {
    DoublyLL head;
    
    public void insert(int val) {
        if (head == null) {
            head = new DoublyLL(val);
        } else {
            DoublyLL newNode = new DoublyLL(val);
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }
    
    public void traverse(DoublyLL head) {
        if (head == null)
            return;
        else {
            DoublyLL current = head;
            while(current!= null) {
                System.out.println(current.data);
                current= current.next;
            }
        }
    }
    
    public void reverseDoublyLL(DoublyLL head) {
        if (head == null)
            return;
        else {
            DoublyLL current = head;
            DoublyLL prev = current.prev;
            DoublyLL next = null;
            while(current!=null) {
                next = current.next;
                current.next = prev;
                current.prev = next;
                prev = current;
                current = next;
            }
            head = prev;
            traverse(head);
        }
    }
    
    public void insertAtLocationK(int k, int newNodeData) {
        if (head == null)
            return;
        else {
            int index = 0;
            DoublyLL prev = head.prev;
            DoublyLL current = head;
            DoublyLL next = null;
            DoublyLL newNode = new DoublyLL(newNodeData);
            while(current!= null) {
                next = current.next;
                if (index == k) {
                    if (current == head) {
                        newNode.prev = prev;
                        newNode.next = current;
                        
                        current.prev = newNode;
                        head = newNode;
                        return;
                    } else {
                        prev.next = newNode;
                        
                        newNode.prev = prev;
                        newNode.next = current;
                        
                        current.prev = newNode;
                    }
                    return;
                }
                index++;
                prev = current;
                current = next;
            }
            
        }
    }
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ReverseDoublyLL obj = new ReverseDoublyLL();
        obj.insert(5);
        obj.insert(4);
        obj.insert(3);
        obj.insert(1);
        obj.traverse(obj.head);
//        System.out.println("\nPrint after reverse : ");
//        obj.reverseDoublyLL(obj.head);
        
        System.out.println("\nPrint after inserting : ");
        obj.insertAtLocationK(3, 10);
        obj.traverse(obj.head);
    }

}
