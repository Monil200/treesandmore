package treessandtrees;
import java.util.*;
class LL {
    LL next, prev;
    int data;
    LL (int val) {
        data = val;
    }
}
public class LRUagainagain {
    LL head;
    HashMap<Integer, LL> map;
    LRUagainagain () {
        head = null;
        map = new HashMap<Integer, LL>();
    }
    
    public void insert(int val) {
        // check if head is null for 1st time
        if (head == null) {
            LL node = new LL(val);
            head = node;
            map.put(val, node);
            return;
        } else {
            if (map.containsKey(val)) { // bring it from middle to first
                LL node = map.get(val);
                LL prev = node.prev;
                LL next = node.prev;
                
                // detached and now floating in var LL
                prev.next = next;
                next.prev = prev;
                
                node.next = head;
                head.prev = node;
                head = node;
            } else { // add to map and make it as head
                LL node = new LL(val);
                map.put(val, node);
                node.next = head;
                head.prev = node;
                head = node;
            }
        }
    }
    
    public void get(int val) {
        if (head == null) {
            return;
        } else {
            if (!map.containsKey(val)) {
                System.out.println("in return");
                return;
            } else {
                // 2 cases
                LL node = map.get(val);
                if (node == head) {
                    System.out.println("Fetched node" + node.data);
                } else {
                    System.out.println("Fetched node in else" + node.data);
                    // bring it to front
                    LL prev = node.prev;
                    LL next = node.next;
                    
                    // detached and now floating in var LL
                    prev.next = next;
                    if (next != null)
                        next.prev = prev;
                    
                    node.next = head;
                    head.prev = node;
                    head = node;
                }
            }
        }
    }
    
    public void printCache() {
        if (head == null) {
            return;
        } else {
            LL current = head;
            while(current != null) {
                System.out.print(current.data + ", ");
                current = current.next;
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LRUagainagain obj = new LRUagainagain();
        obj.insert(5);
        obj.insert(4);
        obj.insert(3);
        obj.insert(2);
        obj.insert(1);
        
        obj.printCache();
        
        obj.get(5);
        obj.printCache();
        
        obj.get(1);
        obj.printCache();
    }

}
