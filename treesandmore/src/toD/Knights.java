package toD;
import java.util.*;
/*
 * 1 2 3
 * 4 5 6
 * 7 8 9
 *   0
 */
public class Knights {
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
    Knights() {
        map.put(1, new ArrayList(Arrays.asList(6,8)));
        map.put(2, new ArrayList(Arrays.asList(7,9)));
        map.put(3, new ArrayList(Arrays.asList(4,8)));
        map.put(4, new ArrayList(Arrays.asList(3,9,0)));
        map.put(5, new ArrayList());
        map.put(6, new ArrayList(Arrays.asList(1,7)));
        map.put(7, new ArrayList(Arrays.asList(2,6)));
        map.put(8, new ArrayList(Arrays.asList(1,3)));
        map.put(9, new ArrayList(Arrays.asList(4,2)));
        map.put(0, new ArrayList(Arrays.asList(4,6)));
    }
    
    public void getTotalPathsRecursive(int length, int start, ArrayList<Integer> res) {
        if (res.size() >= length) {
            System.out.println(res);
            return;
        }
        for(int i=0;i<map.get(start).size();i++) {
            res.add(map.get(start).get(i));
            getTotalPathsRecursive(length, map.get(start).get(i), new ArrayList<Integer>(res));
            res.remove(res.size()-1);
        }
    }
    
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Knights obj = new Knights();
        ArrayList<Integer> res = new ArrayList<Integer>();
        int start = 3;
        res.add(start);
        obj.getTotalPathsRecursive(start, 1, res);
    }

}
