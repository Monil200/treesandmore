package treessandtrees;
import java.util.*;
//Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
public class SubarryWithEqualOnesAndZeros {
    SubarryWithEqualOnesAndZeros() {}
    
    public void prepareMinMaxHolder(int a[], HashMap<Integer, ArrayList<Integer>> map) {
        int runningSum = 0;
        for(int i=0;i<a.length;i++) {
            if (a[i] == 1) {
                runningSum -= 1;
            } else {
                runningSum += 1;
            }
            if (map.containsKey(runningSum)) {
                List<Integer> getMap = map.get(runningSum);
                getMap.add(i);
            } else {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(i);
                map.put(runningSum, temp);
            }
        }
    }
    
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a[] = {1,1,0,0,0,1,1,1,0,1,1,1,0,1};
        int maxDiff = Integer.MIN_VALUE;
        SubarryWithEqualOnesAndZeros obj = new SubarryWithEqualOnesAndZeros();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        obj.prepareMinMaxHolder(a, map);
        
        Set<Map.Entry<Integer, ArrayList<Integer>>> set = map.entrySet();
        for(Map.Entry<Integer, ArrayList<Integer>> i : set) {
            System.out.print("key:" + i.getKey() + " ");
            List<Integer> temp = i.getValue();
            Iterator<Integer> it = temp.iterator();
            while(it.hasNext()) {
                System.out.print("\t" + it.next());
            }
            if (temp.size() >= 2) {
                int tempDiff = temp.get(temp.size()-1) - temp.get(0);
                if (tempDiff > maxDiff) {
                    maxDiff = tempDiff;
                }
            }
            System.out.println();
        }
        System.out.println( " --Longest subarray is " + maxDiff);
    }

}
