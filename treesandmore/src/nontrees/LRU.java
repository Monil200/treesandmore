package nontrees;
import java.util.*;
class Node {
    int data;
    Node next;
    Node prev;
    String key;
    public Node(int val, String key) {
        this.data = val;
        this.next = null;
        this.prev = null;
        this.key = key;
    }
}

public class LRU {
    HashMap<String, Node> keys = new HashMap<String, Node>();
    Node head = null;
    
    public LRU() {
        this.head = null;
        this.keys = new HashMap<String, Node>();
    }
    
    public void setKey(String key, int val) {
        modifyHeadOfDLL(key, val);
    }
    
    public void modifyHeadOfDLL(String key, int val) {
        if (this.keys.size() > 0 && this.keys.containsKey(key)) {
            Node current = keys.get(key);
            Node prev = current.prev;
            Node next = current.next;
            
            current.next = this.head;
            current.prev = null;
            
            
            prev.next = next;
            next.prev = prev;
            
            this.head.prev = current;
            this.head = current;
            
        } else {
            Node newNode = new Node(val, key);
            this.keys.put(key, newNode);
            if (this.head == null) {
                this.head = newNode;
            } else {
                newNode.next = head;
                this.head.prev = newNode;
                this.head = newNode;
            }
        }
    }
    
    public void delete(String key) {
        if (this.keys.containsKey(key)) {
            Node temp = this.keys.get(key);
            Node prev = temp.prev;
            Node next = temp.next;
            prev.next = next;
            next.prev = prev;
        } else {
            System.out.println("No such key in cache");
        }
    }
    
    public String getRecentlyUsedKey() {
        return this.head.key;
    }
    
    public void DLLTraversal(Node head) {
        if (head==null) {
            return;
        } else {
            while(head!=null) {
                System.out.print(head.data + "");
                head = head.next;
            }
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LRU obj = new LRU();
        obj.setKey("a", 1);
        obj.setKey("b", 2);
        obj.setKey("c", 3);
        obj.setKey("d", 4);
        System.out.println("\n");
        obj.setKey("b", 41);
        System.out.println("\n" + obj.getRecentlyUsedKey() + "\n");
        obj.DLLTraversal(obj.head);
        
        obj.delete("d");
        System.out.println("\n");
        obj.DLLTraversal(obj.head);
        
        System.out.println("\n" + obj.getRecentlyUsedKey());
    }

}
