package nontrees;
import java.util.*;

class NumBucket {
    List<Integer> positions = new ArrayList<Integer>();
    public NumBucket() {}
    public NumBucket(int num, int pos) {
        this.positions.add(pos);
    }
    
}

public class LargestNumOneSwap {

    

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String a = "9239";
        process(a);
    }
    
    public static void process(String a) {
        
        if (a == null || a.length() == 0)
            return;
        
        char num[] = a.toCharArray();
        NumBucket buckets[] = new NumBucket[10];
        
        for(int i=0;i<num.length;i++) {
            int temp = Integer.valueOf(num[i]) - 48;
            System.out.println(temp);
            if (buckets[temp] == null)
                buckets[temp] = new NumBucket();
            buckets[temp].positions.add(i);
        }
        
        // only for display
        for(int i=0;i<10;i++) {
            if (buckets[i] != null && buckets[i].positions.size() > 0) {
                System.out.print("number - " + i);
                for(int j: buckets[i].positions) {
                    System.out.println("\t occourances at pos " + j + ",");
                }
                System.out.println();
            }
        }
        int max = Integer.valueOf(a);
        for(int i=0;i<num.length-1;i++) {
            if (num[i] == '9')
                continue;
            char s[] = num;
            for(int j=i+1;j<num.length;j++) {
                if (Integer.valueOf(num[j]) > Integer.valueOf(num[i]) ) {
                    List<Integer> pos = buckets[(Integer.valueOf(num[j]) - 48)].positions;
                    for(int k : pos) {
                        if (k > i) {
                            char l = s[i];
                            s[i] = s[j];
                            s[j] = l;
                            System.out.println(Arrays.toString(s) + " -> i:" + i + " ->j:" + j);
                            if (Integer.valueOf(String.valueOf(s)) > max) {
                                max = Integer.valueOf(String.valueOf(s));
                            }
                        }
                        s = num; // reset s
                    }
                }
            }
        }
        System.out.println(max);
    }

}
