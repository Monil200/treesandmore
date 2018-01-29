package treessandtrees;

import java.util.Arrays;

public class MaxNumberFormedByOneSwap {
    
    public static void getMaxNumber(int num) {
        String n = Integer.toString(num);
        int buckets[] = new int[10];
        for(int i=0;i<n.length();i++) {
            String temp = n.charAt(i) + "";
            int t= Integer.valueOf(temp);
            buckets[t] +=1;
        }
        int swapTo = -1,swapFrom = -1;
        boolean candidateFound = false;
        System.out.println(Arrays.toString(buckets));
        for(int i=0;i<n.length();i++) {
            String temp = n.charAt(i) + "";
            int t= Integer.valueOf(temp);
            swapFrom = t;
            buckets[t] -=1;
            for(int j=9;j>t;j--) {
                System.out.println("i:" + i + " j:" + j);
                if (buckets[j] > 0) {
                    swapTo = j;
                    candidateFound = true;
                    break;
                }
            }
            if (candidateFound)
                break;
        }
        if (swapTo == -1) {
            System.out.println("Swap not possible");
        } else {
            System.out.println("Swap candidates swapTo:" + swapTo + " swapFrom:" + swapFrom);
        }
        
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        getMaxNumber(989);
    }

}
