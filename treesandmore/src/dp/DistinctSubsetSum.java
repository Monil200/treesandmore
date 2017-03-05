package dp;

import java.util.Arrays;

public class DistinctSubsetSum {
    
    public static void distinctSubsets(int a[]) {
        if (a.length == 0 || a == null)
            return;
        int sum = 0;
        for(int i=0;i<a.length;i++) {
            sum+=a[i];
        }
        int opt[][] = new int[a.length+1][sum+1];
        opt[0][0] = 1;
        for(int i=1;i<=sum;i++) {
            opt[0][i] = 0;
        }
        for(int i=1;i<=a.length;i++) {
            opt[i][0] = 1;
        }
        
        boolean sumFormed = false;
        for(int i=1;i<a.length+1;i++) {
            for(int j=1;j<=sum;j++) {
                if ((j - a[i-1]) >= 0) {
                    sumFormed = (opt[i-1][j - a[i-1]] == 1) ? true : false; 
                }
                if (opt[i-1][j] == 1) {
                    sumFormed = true;
                }
                if (sumFormed) {
                    opt[i][j] = 1;
                }
                sumFormed = false;
            }
        }
        for(int i=0;i<a.length+1;i++) {
            System.out.println(Arrays.toString(opt[i]));
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // find sum of distinct subsets
        int a[] = {1,2,3};
        distinctSubsets(a);
        
        
    }

}
