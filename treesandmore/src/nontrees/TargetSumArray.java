package nontrees;

import java.util.Arrays;

public class TargetSumArray {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        /*
         * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. 
         * Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
            Find out how many ways to assign symbols to make sum of integers equal to target S.
         * */
        int a[] = {1,1,1,1,1};
        int s = 3;
        int res[] = new int[a.length];
        
        dfsTargetSum(a, 0, 0, s,res);
    }
    
    public static void dfsTargetSum(int a[], int index, int currSum, int target, int res[]) {
        System.out.println("index:" + index + " currSum:" + currSum + " My array:" + Arrays.toString(res));
        if (currSum == target && index == a.length) {
            System.out.println("Target found");
            return;
        }
        if (index == a.length)
            return;
        for(int i=index;i<a.length;i++) {
            int currSumTemp = currSum;
            currSum += a[index]; // + for val
            res[index] = a[index];
            dfsTargetSum(a, ++index, currSum, target, res);
            --index;
            currSum = currSumTemp;
            currSum += a[index]*-1; // - for val
            res[index] = a[index]*-1;
            dfsTargetSum(a,++index, currSum, target,res);
        }
    }

}
