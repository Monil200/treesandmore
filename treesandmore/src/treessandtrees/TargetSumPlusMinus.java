package treessandtrees;

import java.util.Arrays;

// https://leetcode.com/problems/target-sum/description/
public class TargetSumPlusMinus {
    
    public void getTargetSum(int a[], int index, int target, char c[]) {
        if (a == null || a.length == 0) {
            return;
        }
        if (index >= c.length) {
//            if (isTargetSunAchieved(a, target, c)) {
//                System.out.println(Arrays.toString(a));
//            }
              for(int i=0;i<a.length;i++) {
                  System.out.print(a[i]);
                  if (i != a.length -1) {
                      System.out.print(c[i]);
                  }
              }
              System.out.println();
              return;
        }
        c[index] = '+';
        getTargetSum(a, index+1, target, c);
        c[index] = '-';
        getTargetSum(a, index+1, target, c);
    }
    
//    boolean isTargetSunAchieved(int a[], int target, char c[]) {
//        
//    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a[] = {1,1,1,1,1};
        char c[] = new char[a.length-1];
        TargetSumPlusMinus obj = new TargetSumPlusMinus();
        obj.getTargetSum(a, 0, 3, c);
    }

}
