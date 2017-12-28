package treessandtrees;
/*
 * https://leetcode.com/problems/all-oone-data-structure/discuss/
 * Implement a data structure supporting the following operations:

Inc(Key) - Inserts a new key with value 1. Or increments an existing key by 1. Key is guaranteed to be a non-empty string.
Dec(Key) - If Key's value is 1, remove it from the data structure. Otherwise decrements an existing key by 1. If the key does not exist, this function does nothing. Key is guaranteed to be a non-empty string.
GetMaxKey() - Returns one of the keys with maximal value. If no element exists, return an empty string "".
GetMinKey() - Returns one of the keys with minimal value. If no element exists, return an empty string "".
Challenge: Perform all these in O(1) time complexity.
 */
import java.util.*;
class Key {
    int data;
    Key next, prev;
    ArrayList<Character> nodes;
    Key(int val) {
        data = val;
        nodes = new ArrayList<Character>();
        next = prev = null;
    }
}
public class OofOneDataStructure {
    HashMap<Character, Key> map;
    Key head;
    OofOneDataStructure() {
        map = new HashMap<Character, Key>();
        head = null;
    }
    
    void inc(Character key) {
        if (map.containsKey(key)) {
            Key currentKey = map.get(key);
//            currentKey.nodes.remove(key);

            Key nextKey = currentKey.next;
            if (currentKey.nodes.size() == 1) {
                if (currentKey == head) {
                    if (currentKey.next.data == (currentKey.data +1)) {
                        currentKey.next.nodes.add(key);
                        head = head.next;
                        map.put(key, currentKey.next);
                    } else {
                        Key newKey = new Key(currentKey.data +1);
                        Key keyNext = currentKey.next;
                        newKey.next = keyNext;
                        map.put(key, currentKey);
                        head = newKey;
                    }
                } else {
                    
                }
            } else {
                
            }
            if (nextKey != null && nextKey.data == (currentKey.data + 1)) {
                nextKey.nodes.add(key);
                map.put(key, nextKey);
            } else {
                Key newNextKey = new Key(currentKey.data +1);
                newNextKey.nodes.add(key);
                map.put(key, nextKey);
            }
        } else {
            if (head!= null && head.data == 1) {
                head.nodes.add(key);
                map.put(key, head);
            } else {
                Key newKey = new Key(1);
                newKey.next = head;
                head = newKey;
                map.put(key, head);
            }
        }
    }
    
    void dec(char key) {
        if (!map.containsKey(key))
            return;
        else {
            Key currentKey = map.get(key);
            
            // get prev and next;
            if (currentKey.data == 1) {
                // case 1 : that node is head
                if (currentKey.nodes.size() == 1) {
                    head = head.next;
                    map.remove(key);
                } else {
                    // case 1.1 head with value 1 has many nodes with val 1; 
                    currentKey.nodes.remove(key);
                    map.remove(key);
                }
            } else {
                // case 1
                if (currentKey.nodes.size() == 1) { 
                    // 2 cases
                    // case 1
                    if (currentKey == head ) {
                        Key next = null;
                        if (currentKey.next != null) {
                            next = currentKey.next;
                        }
                        Key newKey = new Key(currentKey.data -1);
                        newKey.nodes.add(key);
                        map.put(key, newKey);
                        newKey.next = next;
                        head = newKey;
                    } else {
                        if (currentKey.prev.data == (currentKey.data -1)) {
                            Key next = currentKey.next;
                            currentKey.prev.next = next;
                            currentKey.prev.nodes.add(key);
                            map.put(key, currentKey.prev);
                        } else {
                            currentKey.data -= 1;
                        }
                    }
                } else {
                    // size > 1
                    // case 1
                    if (currentKey == head) { // remove current node, create newKey and make newKey as head
                        currentKey.nodes.remove(key);
                        Key newKey = new Key(currentKey.data -1);
                        newKey.nodes.add(key);
                        map.put(key, newKey);
                        newKey.next = head;
                        head.prev = newKey;
                        head = newKey;
                    } else {
                        // 2 cases
                        // case 1 - do i have a decremented node?
                        if (currentKey.prev != null && currentKey.prev.data == (currentKey.data -1)) {
                            currentKey.nodes.remove(key);
                            currentKey.prev.nodes.add(key);
                            map.put(key, currentKey.prev);
                        } else { // create a decremented node and make prev, next adjustments
                            Key newKey = new Key(currentKey.data -1);
                            currentKey.nodes.remove(key);
                            Key prev = currentKey.prev;
                            newKey.prev = prev;
                            newKey.next = currentKey;
                            newKey.nodes.add(key);
                            map.put(key, newKey);
                        }
                    }
                }
                
            }
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        OofOneDataStructure obj = new OofOneDataStructure();
        obj.inc('C');
        obj.inc('D');
        
        System.out.println(obj.map.get('C').data);
        System.out.println(obj.map.get('D').data);
        
        obj.dec('D');
        obj.inc('C');
        System.out.println(obj.map.containsKey('D'));
        System.out.println(obj.map.get('C').next == null);
        System.out.println(obj.map.get('C').prev == null);
    }

}
