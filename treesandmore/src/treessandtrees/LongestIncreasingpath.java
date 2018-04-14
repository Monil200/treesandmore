package treessandtrees;

import java.util.Arrays;
//https://leetcode.com/problems/longest-increasing-path-in-a-matrix/description/

public class LongestIncreasingpath {
    
    public void getLongestIncreasingpathInMatrix(int a[][]) {
        
        int opt[][] = new int[a.length][a[0].length];
        
        opt[0][0] = 1;
        for(int i=1;i<a[0].length;i++) {
            if (a[0][i] > a[0][i-1]) {
                opt[0][i] = opt[0][i-1] +1;
            } else {
                opt[0][i] = 1;
            }
        }
        for(int i=1;i<a.length;i++) {
            if (a[i][0] > a[i-1][0]) {
                opt[i][0] = opt[i-1][0] +1;
            } else {
                opt[i][0] = 1;
            }
        }
        
        int topExtend = 0, leftEntend = 0;
        for(int i=1;i<a.length;i++) {
            for(int j=1;j<a[0].length;j++) {
                topExtend = leftEntend = 0;
                if (a[i][j] > a[i-1][j]) {
                    topExtend = opt[i-1][j]+1;
                }
                if (a[i][j] > a[i][j-1]) {
                    leftEntend = opt[i][j-1]+1;
                }
                opt[i][j] = Math.max(Math.max(topExtend, leftEntend), 1);
            }
        }
        
        for(int i=0;i<a.length;i++)
            System.out.println(Arrays.toString(opt[i]));
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LongestIncreasingpath obj = new LongestIncreasingpath();
        int a[][] = {
            {3,4,5},
            {3,2,6},
            {2,2,1}
        };
        
        obj.getLongestIncreasingpathInMatrix(a); // similarly do it for decreasing
    }

}
