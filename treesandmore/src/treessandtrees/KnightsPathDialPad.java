package treessandtrees;
import java.util.*;
public class KnightsPathDialPad {
    
//    HashMap<Integer, ArrayList<Integer>> map;
//    KnightsPathDialPad() {
//        map = new HashMap<Integer, ArrayList<Integer>>();
//        map.put(1, new ArrayList<Integer>(Arrays.asList(5)));
//        map.put(2, new ArrayList<Integer>(Arrays.asList(4,6)));
//        map.put(3, new ArrayList<Integer>(Arrays.asList(5)));
//        map.put(4, new ArrayList<Integer>(Arrays.asList(2,8)));
//        map.put(5, new ArrayList<Integer>(Arrays.asList(1,3,7,9)));
//        map.put(6, new ArrayList<Integer>(Arrays.asList(8,2)));
//        map.put(7, new ArrayList<Integer>(Arrays.asList(5,0)));
//        map.put(8, new ArrayList<Integer>(Arrays.asList(6,4)));
//        map.put(9, new ArrayList<Integer>(Arrays.asList(5,0)));
//        map.put(0, new ArrayList<Integer>(Arrays.asList(7,9)));
//    }
//    
//    public void knightsPathLimit(int k, int start, ArrayList<Integer> a) {
//        if (a.size() == k) {
//            Iterator<Integer> it = a.iterator();
//            while(it.hasNext()) {
//                System.out.print(it.next());
//            }
//            System.out.println();
//            return;
//        }
//        for(int i=0;i<map.get(start).size();i++) {
//            Integer newStart = map.get(start).get(i);
////            System.out.println(newStart);
//            a.add(newStart);
//            int sizeNow = a.size();
//            knightsPathLimit(k, newStart, a);
//            a.remove(sizeNow-1);
//        }
//    }
    
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
    KnightsPathDialPad() {
        map.put(0, new ArrayList<Integer>(Arrays.asList(4,6)));
        map.put(1, new ArrayList<Integer>(Arrays.asList(6,8)));
        map.put(2, new ArrayList<Integer>(Arrays.asList(7,9)));
        map.put(3, new ArrayList<Integer>(Arrays.asList(4,8)));
        map.put(4, new ArrayList<Integer>(Arrays.asList(3,9,0)));
        map.put(5, new ArrayList<Integer>(Arrays.asList()));
        map.put(6, new ArrayList<Integer>(Arrays.asList(1,7,0)));
        map.put(7, new ArrayList<Integer>(Arrays.asList(2,6)));
        map.put(8, new ArrayList<Integer>(Arrays.asList(1,3)));
        map.put(9, new ArrayList<Integer>(Arrays.asList(2,4)));
    }
    public void knightsPathLimit(int length, int start) {
        if (start == 5) {
            return;
        }
        int opt[][] = new int[10][length];
        opt[start][0] = 1;
        
        for(int i=1;i<length;i++) {
            for(int j=0;j<10;j++) { // traverse the OPT column
                if (opt[j][i-1] == 1) { // if 1 is found in prev column
                    ArrayList<Integer> candidates = map.get(j);
                    Iterator<Integer> it = candidates.iterator();
                    while(it.hasNext()) {
                        int path = it.next();
                        opt[path][i] += 1;
                    }
                }
            }
        }
        
        for(int i=0;i<10;i++) {
            System.out.println(Arrays.toString(opt[i]));
        }
        
    }
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
            KnightsPathDialPad obj = new KnightsPathDialPad();
//            obj.knightsPathLimit(4, 4, new ArrayList<Integer>(Arrays.asList(4)));
            obj.knightsPathLimit(4, 4); // length 4, start from 4
        
        }

}
