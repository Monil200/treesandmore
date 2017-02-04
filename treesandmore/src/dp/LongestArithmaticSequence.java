package dp;
import java.util.*;

public class LongestArithmaticSequence {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a[] = {1, 7, 13, 15, 19, 29};
        int opt[] = new int[a.length];
        Map<Integer, Integer> ints = new HashMap<Integer, Integer>();
        for(int i=0;i<a.length;i++) {
            if (!ints.containsKey(a[i])) {
                ints.put(a[i], 1);
            } else {
                ints.put(a[i], ints.get(a[i]) +1);
            }
        }
        opt[0] = 0;
        for(int i=1;i<a.length;i++) {
            for(int j=0;j<i;j++) {
                int diff = a[i] - a[j];
                diff = a[i] + diff; // double it
                if (ints.containsKey(diff)) {
                    int count = ints.get(diff);
                    if (count == 1) {
                        ints.remove(diff);
                    } else {
                        ints.put(diff, ints.get(diff)-1);
                    }
                    if (opt[j] > 0) {
                        opt[i] = opt[j] +1;
                    } else {
                        System.out.println(diff + " in " + "i:" + i);
                        opt[i] = 3;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(opt));
    }

}
