package treessandtrees;
import java.util.*;
public class LFUCache {
    
    int capacity;
    HashMap<Integer, String> keyValue; // key val
    HashMap<Integer, Integer> count; // key to counts of that key
    HashMap<Integer, HashSet<Integer>> countMap; // count to values
    int minCount = 0;
    LFUCache(int c) {
        capacity = c;
        keyValue = new HashMap<Integer, String>();
        count = new HashMap<Integer, Integer>();
        countMap = new HashMap<Integer, HashSet<Integer>>();
    }
    
    public void insert(int key, String val) {
        if (keyValue.containsKey(key)) {
            return;
        }
        if (keyValue.size() >= capacity) {
            int candidateToRemove = countMap.get(minCount).iterator().next();
            countMap.get(minCount).remove(candidateToRemove);
            count.remove(candidateToRemove);
            keyValue.remove(candidateToRemove);
        }
        keyValue.put(key, val);
        minCount = 1;
        count.put(key, 1);
        if (countMap.containsKey(minCount)) {
            countMap.get(minCount).add(key);
        } else {
            HashSet<Integer> temp = new HashSet<Integer>();
            temp.add(key);
            countMap.put(minCount, new HashSet(temp));
        }
    }
    
    public void get(int key) {
        if (!keyValue.containsKey(key)) {
            return;
        } else {
            int currentCount = count.get(key);
            if (currentCount == minCount && countMap.get(currentCount).size() ==1 )
                minCount++;
            countMap.get(currentCount).remove(key);
            
            // update count.
            count.remove(key);
            count.put(key, currentCount+1);
            
            // add new count to new HashSet;
            
            if (countMap.get(currentCount).size() == 0) {
                countMap.remove(currentCount);
            }
            
            if (countMap.containsKey(currentCount+1)) {
                // if the currentHasSet has size= 1, remove it from countMap.
                HashSet<Integer> newHashSet = countMap.get(currentCount+1);
                newHashSet.add(key);
                countMap.put(currentCount+1, new HashSet(newHashSet));
            } else {
                HashSet<Integer> newHashSet = new HashSet<Integer>();
                newHashSet.add(key);
                countMap.put(currentCount+1, new HashSet(newHashSet));
                
            }
        } // else end
    }
    
    public static void main(String args[]) {
        LFUCache obj = new LFUCache(3);
        obj.insert(1, "roger");
        obj.insert(2, "rafa");
        obj.insert(3, "cilic");
        System.out.println("my cache: " + obj.keyValue);
        Set<Map.Entry<Integer, HashSet<Integer>>> st = obj.countMap.entrySet();
        for(Map.Entry<Integer, HashSet<Integer>> i : st) {
            System.out.print("In main count:" + i.getKey() + " keys: ");
            HashSet<Integer> j = i.getValue();
            Iterator<Integer> k = j.iterator();
            while(k.hasNext()) {
                System.out.print(k.next() + ", ");
            }
            System.out.println();
        }
        
        obj.get(1);
        obj.get(1);
        obj.get(1);
        obj.get(1);
        obj.get(2);
        
        
        System.out.println("count map after fetched: " + obj.count);
        System.out.println("min count so far count: " + obj.minCount);
        
        obj.insert(4, "zverev");
        
        System.out.println("my cache after overflowing: " + obj.keyValue);
        obj.insert(5, "theim");
        System.out.println("my cache after overflowing: " + obj.keyValue);
        System.out.println("my count after overflowing: " + obj.count);
        System.out.println("min count so far count: " + obj.minCount);
        obj.insert(6, "goffin");
        obj.get(6);
        System.out.println("min count so far count: " + obj.minCount);
        System.out.println("my cache after overflowing: " + obj.keyValue);
        
        
        
    }
}
