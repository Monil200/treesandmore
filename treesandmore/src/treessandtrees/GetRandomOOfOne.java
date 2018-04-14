package treessandtrees;
import java.util.*;
public class GetRandomOOfOne {
    HashMap<Integer, LinkedHashSet<Integer>> locs;
    List<Integer> list;
    GetRandomOOfOne() {
        list = new ArrayList<Integer>();
        locs = new HashMap<Integer, LinkedHashSet<Integer>>();
    }
    
    public void insert(int key) {
        if (!locs.containsKey(key)) {
            locs.put(key, new LinkedHashSet<Integer>());
        }
        
        list.add(key);
        locs.get(key).add(list.size()-1); // position of current element in our list;
        System.out.println("list after addition" + list);
        System.out.println("locs after addition" + locs);
    }
    
    public void delete(int key) {
        if (!locs.containsKey(key)) {
            return;
        } else {
            int firstLocationOfThisKey = locs.get(key).iterator().next();
            
            System.out.println("firstLocationOfThisKey:" + firstLocationOfThisKey);
            
            // now swap this with last element in list of nums
            if (firstLocationOfThisKey < list.size() -1) {
                if (locs.get(key).size() == 1) {
                    locs.remove(key);
                } else {
                    locs.get(key).remove(locs.get(key).iterator().next());
                }
                int lastOne = list.get(list.size()-1);
                list.set(firstLocationOfThisKey, lastOne);
                list.remove(list.size()-1); // removed last
            }
            System.out.println("list after deletion" + list);
            System.out.println("locs after deletion" + locs);
        }
    }
    
    public void getRandom() {
        int rand = (int) (Math.random()*(list.size()));
        System.out.println("Random element is:" + list.get(rand));
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        GetRandomOOfOne obj = new GetRandomOOfOne();
        obj.insert(1);
        obj.insert(2);
        obj.insert(2);
        obj.insert(3);
        
        obj.delete(2);
        
        obj.getRandom();
        obj.getRandom();
        obj.getRandom();
        obj.getRandom();
    }

}
