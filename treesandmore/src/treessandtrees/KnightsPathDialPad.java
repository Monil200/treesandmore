package treessandtrees;
import java.util.*;
public class KnightsPathDialPad {
    
    HashMap<Integer, ArrayList<Integer>> map;
    KnightsPathDialPad() {
        map = new HashMap<Integer, ArrayList<Integer>>();
        map.put(1, new ArrayList<Integer>(Arrays.asList(5)));
        map.put(2, new ArrayList<Integer>(Arrays.asList(4,6)));
        map.put(3, new ArrayList<Integer>(Arrays.asList(5)));
        map.put(4, new ArrayList<Integer>(Arrays.asList(2,8)));
        map.put(5, new ArrayList<Integer>(Arrays.asList(1,3,7,9)));
        map.put(6, new ArrayList<Integer>(Arrays.asList(8,2)));
        map.put(7, new ArrayList<Integer>(Arrays.asList(5,0)));
        map.put(8, new ArrayList<Integer>(Arrays.asList(6,4)));
        map.put(9, new ArrayList<Integer>(Arrays.asList(5,0)));
        map.put(0, new ArrayList<Integer>(Arrays.asList(7,9)));
    }
    
    public void knightsPathLimit(int k, int start, ArrayList<Integer> a) {
        if (a.size() == k) {
            Iterator<Integer> it = a.iterator();
            while(it.hasNext()) {
                System.out.print(it.next());
            }
            System.out.println();
            return;
        }
        for(int i=0;i<map.get(start).size();i++) {
            Integer newStart = map.get(start).get(i);
//            System.out.println(newStart);
            a.add(newStart);
            int sizeNow = a.size();
            knightsPathLimit(k, newStart, a);
            a.remove(sizeNow-1);
        }

    }
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
            KnightsPathDialPad obj = new KnightsPathDialPad();
            obj.knightsPathLimit(4, 5, new ArrayList<Integer>(Arrays.asList(5)));
        
        }

}
