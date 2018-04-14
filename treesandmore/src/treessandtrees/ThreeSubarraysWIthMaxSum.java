package treessandtrees;
import java.util.*;
public class ThreeSubarraysWIthMaxSum {
    
    public void getMaxSumOfThreeSubarraysOfSizeK(int a[], int k) {
        int leftSubarray[] = new int[a.length];
        int rightSubarray[] = new int[a.length];
        int leftSum[] = new int[a.length];
        int rightSum[] = new int[a.length];
        
        leftSum[0] = a[0];
        for(int i=1;i<a.length;i++) {
            leftSum[i] = leftSum[i-1] + a[i];
        }
        
        rightSum[a.length-1] = a[a.length-1];
        for(int i=a.length-2;i>0;i--) {
            rightSum[i] = rightSum[i+1] + a[i];
        }
        
        leftSubarray[0] = a[0];
        for(int i=1;i<a.length;i++) {
            if (i>=k) {
                leftSubarray[i] = leftSum[i-1] + a[i] - leftSum[i-k];
            } else {
                leftSubarray[i] = leftSum[i-1] + a[i];
            }
        }
        
        rightSubarray[a.length-1] = a[a.length-1];
        for(int i=a.length-2;i>=0;i--) {
            if (i<a.length-k) {
                rightSubarray[i] = rightSum[i+1] + a[i] - rightSum[i+k];
            } else {
                rightSubarray[i] = rightSum[i+1] + a[i];
            }
        }
        
        System.out.println(Arrays.toString(leftSum));
        System.out.println(Arrays.toString(leftSubarray));
        System.out.println(Arrays.toString(rightSubarray));
        System.out.println(Arrays.toString(rightSum));
        
        
        int leftMax[] = new int[a.length];
        int rightMax[] = new int[a.length];
        
        leftMax[k-1] = leftSubarray[k-1];
        for(int i=k;i<a.length;i++) {
            leftMax[i] = Math.max(leftSubarray[i], leftMax[i-1]);
        }
        rightMax[a.length-k] = rightSubarray[k];
        for(int i=a.length-k-1;i>=0;i--) {
            rightMax[i] = Math.max(rightSubarray[i], rightMax[i+1]);
        }
        
        System.out.println(Arrays.toString(leftMax));
        System.out.println(Arrays.toString(rightMax));
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ThreeSubarraysWIthMaxSum obj = new ThreeSubarraysWIthMaxSum();
        int a[] = {1,2,1,2,6,7,5,1};
        int k= 2;
        obj.getMaxSumOfThreeSubarraysOfSizeK(a, k);
    }

}
