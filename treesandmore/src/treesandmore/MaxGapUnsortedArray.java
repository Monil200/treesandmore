package treesandmore;
/*
 * https://leetcode.com/problems/maximum-gap/description/
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Try to solve it in linear time/space.

Return 0 if the array contains less than 2 elements.

You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 */

import java.util.*;

public class MaxGapUnsortedArray {
    
    public void maxGap(int a[]) {
        
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++) {
            if (a[i] > max) {
                max =a[i];
            }
            if (a[i] < min) {
                min = a[i];
            }
        }
        
        System.out.println("Min:" + min + " max:" + max);
        System.out.println((int) Math.ceil((double) 17/7));
        int buckets = (int) Math.ceil((double) (max - min)/a.length);
        System.out.println("buckets:" + buckets);
        
        int low[] = new int[a.length];
        int high[] = new int[a.length];
        
        for(int i=0;i<a.length;i++) {
            int target = (int) Math.floor(a[i]/buckets);
            System.out.println(target + " a[i]" + a[i]);
            putLow(low, target, a[i]);
            putHigh(high, target, a[i]);
        }
        
        System.out.println(Arrays.toString(low));
        System.out.println(Arrays.toString(high));
        
        for(int i=0;i<a.length;i++) {
            if ((int) Math.abs(high[i] - low[i]) > max) {
                max = (int) Math.abs(high[i] - low[i]);
            }
        }
        System.out.println("Max diff is:" + max);
        
    }
    
    public void putLow(int low[], int slot, int val) {
        if (low[slot] == 0) {
            low[slot] = val;
        } else if (low[slot] > val) {
            low[slot] = val;
        }
    }
    public void putHigh(int high[], int slot, int val) {
        if (high[slot] == 0) {
            high[slot] = val;
        } else if (high[slot] < val) {
            high[slot] = val;
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a[] = {9,7,2,18,1,3,6};
        MaxGapUnsortedArray obj = new MaxGapUnsortedArray();
        obj.maxGap(a);
    }

}
