package postbuilding42;
import java.util.*;

class LL {
    int data;
    LL prev;
    LL next;
    String key;
    LL(int val, String k) {
        data = val;
        key = k;
    }
}

public class LRUAgain {
    
    HashMap<String, LL> LRU = new HashMap<String, LL>();
    LL head;
    
    public void set(String key, Integer value) {
        if (LRU.containsKey(key)) {
            LL node = LRU.get(key);
            LL nextN = node.next;
            LL prevN = node.prev;
            
            prevN.next = nextN;
            nextN.prev = prevN;
            
            node.next = head;
            head.prev = node;
            node.prev = null;
            head= node;
        } else {
            if (head == null) { // LRU is empty
                head = new LL(value, key);
            } else { // LRU not empty, make new node as head of LL
                LL newNode = new LL(value, key);
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
            LRU.put(key, head);
        }
    }
    
    public void traverse(LL head) {
        if (head == null)
            return;
        else {
            LL current = head;
            while(current!= null) {
                System.out.println(current.data + " - " + current.key);
                current= current.next;
            }
        }
    }
    
    public void get(String key) {
        if (LRU.containsKey(key)) {
            System.out.println(LRU.get(key).data);
            // move the accessed node to the head of DLL
            LL node = LRU.get(key);
            LL nextN = node.next;
            LL prevN = node.prev;
            
            prevN.next = nextN;
            nextN.prev = prevN;
            
            node.next = head;
            head.prev = node;
            node.prev = null;
            head= node;
        } else {
            System.out.println("Key does not exist");
        }
    }
    
    public void delete(String key) {
        if (LRU.containsKey(key)) {
            System.out.println(LRU.get(key).data);
            // move the accessed node to the head of DLL
            LL node = LRU.get(key);
            LL nextN = node.next;
            LL prevN = node.prev;
            if (head == node) {
                head = head.next;
            } else if (node.next == null) {
                 prevN.next = null;
            } else {
                prevN.next = nextN;
                nextN.prev = prevN;
            }
            LRU.remove(key);
        } else {
            System.out.println("Key does not exist");
        }
    }
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LRUAgain obj = new LRUAgain();
        obj.set("monil", 1);
        obj.set("USC", 2);
        obj.set("yahoo", 3);
        obj.traverse(obj.head);
        System.out.println(" after accessing a key");
        obj.get("USC");
        obj.traverse(obj.head);
        
        System.out.println(" after deleting");
        obj.delete("monil");
        obj.traverse(obj.head);
        
        System.out.println(" after accessing a key");
        obj.get("monil");
        obj.traverse(obj.head);
    }

}
