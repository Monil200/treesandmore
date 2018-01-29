package treessandtrees;

import java.util.Arrays;

public class ThreeSum {
    public void findThreeSum(int a[], int target, int temp) {
        if (a == null || a.length == 0) {
            return;
        }
        
        Arrays.sort(a);
        int start = 0, end = a.length-1, mid = 0, currTarget = 0;
        for(int i=1;i<a.length-1;i++) {
            start = i-1;
            end = a.length-1;
            mid = i;
            while(mid < end) {
                currTarget = a[start] + a[mid] + a[end];
                if (currTarget == target) {
                    System.out.println("Found-> data" + "Start:" + a[start] + " mid:" + a[mid] + " end:" + a[end] + " temp:" + temp);
                    return;
                }
                if (currTarget > target) {
                    end--;
                } else if (currTarget  < target) {
                    mid++;
                }
            }
        }
    }
    
    public void fourSum(int a[], int target) {
        if (a == null || a.length == 0) {
            return;
        }
        for(int i=0;i<a.length;i++) {
            int temp = a[i];
            a[i] = -999; // technically neutralize;
            target -= temp;
            findThreeSum(a, target, temp);
            a[i] = temp;
            target += temp;
        }
        
        
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ThreeSum obj = new ThreeSum();
        int a[] = {4, 5, 7, -2, 2, 9};
        obj.fourSum(a,11);
    }

}
