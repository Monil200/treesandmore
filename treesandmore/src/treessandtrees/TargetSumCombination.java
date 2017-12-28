package treessandtrees;

import java.util.Arrays;

/*
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

https://leetcode.com/problems/target-sum/description/
 */
public class TargetSumCombination {
    char operator[] = new char[2];
    TargetSumCombination() {
        operator[0] = '+';
        operator[1] = '-';
    }
    public void giveCombinations(int nums[], int res[], int pos) {
        if (pos == nums.length) {
            System.out.println(Arrays.toString(res));
            return;
        }
        
        res[pos] = nums[pos];
        giveCombinations(nums, res, ++pos);
        --pos;
        res[pos] = -1*nums[pos];
        giveCombinations(nums, res, ++pos);
        --pos;
        
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TargetSumCombination obj = new TargetSumCombination();
        int nums[] = {1,1,1};
        int res[] = new int[nums.length];
        obj.giveCombinations(nums, res, 0);
    }

}
