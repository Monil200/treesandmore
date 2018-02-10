package dp;

import java.util.Arrays;

public class LongestZipZagSubsequence {
    
    public void getLongestSubsequenceZipZag(int a[]) {
        
        int optinc[] = new int[a.length];
        optinc[0] = 1;
        
        int optdec[] = new int[a.length];
        optdec[0] = 1;
        
        int max = 0, currMax = 0;
        for(int i=1;i<a.length;i++) {
            currMax = 0;
            max = 1; // a new subsequence always starts with current val
            for(int j=0;j<i;j++) { // increasing ?
                if (a[i] > a[j]) {
                    currMax = optdec[j]+1;
                    if (currMax > max) {
                        max = currMax;
                    }
                }
            }
            optinc[i] = max;
            max = 1;
            currMax = 0;
            for(int j=0;j<i;j++) { // decreasing ?
                if (a[i] < a[j]) {
                    currMax = optinc[j]+1;
                    if (currMax > max) {
                        max = currMax;
                    }
                }
            }
            optdec[i] = max;
        }
        
        System.out.println(Arrays.toString(optinc));
        System.out.println(Arrays.toString(optdec));
        max = 1;
        for(int i=0;i<a.length;i++) {
            max = Math.max(max, Math.max(optinc[i], optdec[i]));
        }
        System.out.println("Max lengt hzig zag is:" + max);
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LongestZipZagSubsequence obj = new LongestZipZagSubsequence();
        int a[] = {1,2,4,3,2,6};
        obj.getLongestSubsequenceZipZag(a);
    }

}
