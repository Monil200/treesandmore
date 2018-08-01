package toD;
import java.util.*;
class NodeLRU {
    NodeLRU next, prev;
    int data;
    String key; 
    NodeLRU(String k, int val) {
        data = val;
        key = k;
    }
}



public class LRULimit {
    NodeLRU head;
    NodeLRU tail;
    int limit;
    HashMap<String, NodeLRU> map;
    LRULimit(int l) {
        head = null;
        limit = l;
        map = new HashMap<String, NodeLRU>();
    }
    
    
    public void addSet(String key, int val) {
        if (head == null) {
            head = new NodeLRU(key, val);
            tail = head;
            map.put(key, head);
        } else {
            if (map.containsKey(key)) {
                NodeLRU current = map.get(key);
                if (head == current) return;
                if (tail == current) {
                    tail = current.prev;
                    tail.next = null;
                    current.next = head;
                    head.prev = current;
                    head = current;
                } else {
                    NodeLRU next = current.next;
                    NodeLRU prev = current.next;
                    
                    prev.next = next;
                    next.prev = prev;
                    head.prev = current;
                    current.next = head;
                    head = current;
                }
            } else {
                NodeLRU newNode = new NodeLRU(key, val);
                if (map.size() == limit) {
                    NodeLRU tailPrev = tail.prev;
                    tailPrev.next = null;
                    tail = tailPrev;
                    map.remove(tail.key);
                }
                map.put(key, newNode);
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
        }
    }
    
    public void traverse(NodeLRU node) {
        if (node == null) return;
        NodeLRU current = node;
        while(current!= null) {
            System.out.print("key:" + current.key + " data:" + current.data + ", ");
            current = current.next;
        }
    }
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LRULimit obj = new LRULimit(3);
        obj.addSet("Roger", 1);
        obj.addSet("Rafa", 2);
        obj.addSet("zverev", 3);
        obj.addSet("Roger", 1);
        obj.addSet("waw", 232);
        obj.addSet("nole", 21);
        obj.addSet("andy", 44);
        obj.addSet("rafa", 2);
        obj.traverse(obj.head);
    }

}
