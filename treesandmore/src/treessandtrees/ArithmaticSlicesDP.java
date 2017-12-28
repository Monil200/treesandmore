package treessandtrees;
import java.util.*;
public class ArithmaticSlicesDP {
    ArrayList<HashMap<Integer, Integer>> map;
    int nums[] = {2,4,6,8,10, 12};
    ArithmaticSlicesDP() {
        map = new ArrayList<HashMap<Integer, Integer>>();
        for(int i=0;i<nums.length;i++) {
            map.add(i, new HashMap<Integer, Integer>());
        }
    }
    public void getAllSlices() {
        int res[] = new int[nums.length];
        for(int i=1;i<nums.length;i++) {
            for(int j=i-1;j>=0;j--) {
                System.out.println("i:" + i + " j:" + j);
                int diff = nums[i] - nums[j];
                HashMap<Integer, Integer> currMap = map.get(i); // map of i
                currMap.put(diff, 0);
                HashMap<Integer, Integer> tempMap = map.get(j);
                Set<Map.Entry<Integer, Integer>> st = tempMap.entrySet();
                for(Map.Entry<Integer, Integer> s : st) {
                    System.out.println("\t of lopping map " + "key:" + s.getKey() + " val:" + s.getValue());
                    if (s.getKey() == diff && s.getValue() == 0) {
                        currMap.put(diff, 1);
                        res[i] += currMap.get(diff);
                    } else if (s.getKey() == diff && s.getValue() > 0) {
                        currMap.put(diff, s.getValue() + 1);
                        res[i] += currMap.get(diff);
                    }
                }
                
                map.add(i, new HashMap<Integer, Integer>(currMap)); // put updated map again
            }
            Set<Map.Entry<Integer, Integer>> st = map.get(i).entrySet();
            for(Map.Entry<Integer, Integer> s : st) {
                System.out.println("\t" + "i:" + i +" key:" + s.getKey() + " val:" + s.getValue());
            }
            res[i] += res[i-1];
        }
        System.out.println(Arrays.toString(res));
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArithmaticSlicesDP obj = new ArithmaticSlicesDP();
        obj.getAllSlices();
    }

}
