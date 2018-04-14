package treessandtrees;
//https://leetcode.com/problems/smallest-range/description/
import java.util.*;
class RangeE {
    int v;
    int index;
    RangeE(int val, int i) {
        v = val;
        index = i;
    }
}
public class SmallestRange {
    
    public void getSmalletsRange(ArrayList<Integer> a[]) {
        
        PriorityQueue<RangeE> pq = new PriorityQueue<RangeE>(
            new Comparator<RangeE>() {
                public int compare(RangeE a, RangeE b) {
                    return a.v - b.v;
                }
            }
        );
        int index[] = new int[a.length];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++) {
            if (a[i].get(0) > max) {
                max = a[i].get(0);
            }
            if (a[i].get(0) < min) {
                min = a[i].get(0);
            }
            pq.add(new RangeE(a[i].get(0), i));
            index[i]++;
        }
        int window = max - min;
        int minWindowLength = window;
        System.out.println("Min is :" + min + " Max is:" + max);
        
        
        while(true) {
            RangeE popped = pq.poll();
            System.out.println("Element: " + popped.v + " from array: " + popped.index + " next index for that array: " + (index[popped.index]));    
            int nextArray = popped.index; // from which array
            int nextArrayIndex = index[popped.index]++;
            if (nextArrayIndex >= a[nextArray].size()) {
                break;
            }
            pq.add(new RangeE(a[nextArray].get(nextArrayIndex), nextArray));
            if (a[nextArray].get(nextArrayIndex) > max) {
                max = a[nextArray].get(nextArrayIndex);
            }
            min = pq.peek().v;
            window = max - min;
            if (window < minWindowLength) {
                minWindowLength = window;
            }
        }
        
        System.out.println("Min is :" + min + " Max is:" + max + " Min Window length is:" + minWindowLength);
        
        
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        ArrayList<Integer> a1 = new ArrayList<Integer>(){{
            add(4);
            add(10);
            add(15);
            add(24);
            add(26);
        }};
        
        ArrayList<Integer> a2 = new ArrayList<Integer>(){{
            add(0);
            add(9);
            add(12);
            add(20);
        }};

        ArrayList<Integer> a3 = new ArrayList<Integer>(){{
            add(5);
            add(18);
            add(26);
            add(30);
        }};
        
        ArrayList<Integer> a[] = new ArrayList[3];
        a[0] = new ArrayList<Integer>(a1);
        a[1] = new ArrayList<Integer>(a2);
        a[2] = new ArrayList<Integer>(a3);
        
        SmallestRange obj = new SmallestRange();
        obj.getSmalletsRange(a);
        
    }

}
