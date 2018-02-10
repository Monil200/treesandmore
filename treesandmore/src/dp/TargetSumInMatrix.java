package dp;

import java.util.*;

public class TargetSumInMatrix {
    public void getTargetSumPaths(int m[][], int target) {
        int opt[][][] = new int[m.length][m[0].length][target+1];
        
        for(int i=0;i<m[0].length;i++) { // fill first col
            if (m[0][i] <= target) {
                opt[0][i][m[0][i]] = m[0][i];
            }
        }
        
        for(int i=1;i<m.length;i++) { // fill first col
            if (m[i][0] <= target) {
                opt[i][0][m[i][0]] = m[i][0];
            }
        }
        
        for(int i=1;i<m.length;i++) {
            for(int j=1;j<m[0].length;j++) {
                int currSum = m[i][j];
                for(int k=0;k<=target;k++) {
                    System.out.println("i:" + i + " j:" + j + " k:" + k);
                    if (opt[i-1][j-1][k] + currSum <= target && k+currSum <= target) {
                        opt[i][j][k+currSum] += 1;
                    }
                    if (currSum + opt[i][j-1][k] <= target && k+currSum <= target) {
                        opt[i][j][k+currSum] += 1; 
                    }
                }
            }
        }
        
        
        System.out.println("Paths with target sum:" + target + " is - " + opt[m.length-1][m[0].length-1][target]);
        
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TargetSumInMatrix obj = new TargetSumInMatrix();
        int m[][] = {
                {1, 2, 3},
                {4, 6, 55},
                {3, 2, 1}
              };
        obj.getTargetSumPaths(m, 12);
        
        
    }

}
