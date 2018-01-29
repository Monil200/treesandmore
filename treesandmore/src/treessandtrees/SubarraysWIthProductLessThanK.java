package treessandtrees;
//https://leetcode.com/problems/subarray-product-less-than-k/description/
/*
 * Your are given an array of positive integers nums.

Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.
 */
import java.util.*;
public class SubarraysWIthProductLessThanK {
    
    public void subarraysWithProduct(int a[], int k) {
        if (a == null || a.length == 0)
            return;
        int opt[] = new int[a.length];
        int leftPointer = 0, currentProduct = a[0];
        opt[0] = 1;
        //[10, 5, 2, 6]
        for(int i=1;i<a.length;i++) {
            currentProduct *= a[i];
            if (a[i]*currentProduct < k) {
                opt[i]  = 1 + (i - leftPointer);
            } else {
                while(currentProduct >= k && leftPointer <=i) {
                    currentProduct = currentProduct/a[leftPointer];
                    leftPointer++;
                }
                opt[i]  = 1 + (i - leftPointer); 
            }
            System.out.println("currentProduct:" + currentProduct + " leftPointer:" + leftPointer + " opt[i]" + opt[i]);
        }
        System.out.println(Arrays.toString(opt));
        
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SubarraysWIthProductLessThanK obj = new SubarraysWIthProductLessThanK();
        int a[] = {10, 5, 2, 6};
        obj.subarraysWithProduct(a, 100);

    }

}
