package treesandmore;

import java.util.*;

// https://leetcode.com/problems/combination-sum-iii/
/*
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and 
 * each combination should be a unique set of numbers.

   Ensure that numbers within the set are sorted in ascending order.
   Currently changed to have unique results in resultList as opposed to unique numbers
 */
public class CombinationSum {
    
    public void uniQueCombinations(int target, int currSum, int index, ArrayList<Integer> res, int targetSetLimit) {
        if (res.size() > targetSetLimit) {
            return;
        }
        if (currSum == target && res.size()== targetSetLimit) {
            System.out.println(res); // unique need to be handled
            return;
        }
        if (currSum > target || index > 9) {
            return;
        }
        for(int i=index;i<=9;i++) {
            currSum += i;
            res.add(i);
            uniQueCombinations(target, currSum, i+1, res,targetSetLimit);
            currSum -= i;
            res.remove(res.size()-1);
        }
    }
    
    public void getCombinationSumV2(int a[], int currSum, int index, ArrayList<Integer> res, int target) {
        if (currSum == target && res.size() <= a.length) {
            System.out.println(res);
        }
        if (index >= a.length) {
            return;
        }
        if (currSum > target) {
            return;
        }
        for(int i=0;i<a.length;i++) {
            currSum += a[i];
            res.add(a[i]);
            getCombinationSumV2(a, currSum, i+1, res, target);
            currSum -= a[i];
            res.remove(res.size() -1);
        }
    }
    
    public void getRepeatedCombinations(int target, int currSum, ArrayList<Integer> res) {
        if (target == currSum) {
            System.out.println(res);
            return;
        } else {
            for(int i=1;i<=target;i++) {
                if ((currSum + i) <= target) {
                    currSum += i;
                    res.add(i);
                    getRepeatedCombinations(target, currSum, res);
                    currSum -= i;
                    res.remove(res.size()-1);
                }
            }
        }
    }
    
    public void getToTargetWithUniqueSet(int target, int currSum, ArrayList<Integer> res, int index) {
        if (currSum == target) {
            System.out.println(res);
            return;
        } else {
            for(int i=index;i<target;i++) {
                if ((currSum + i) <= target) {
                    currSum += i;
                    res.add(i);
                    getToTargetWithUniqueSet(target, currSum, res,i+1);
                    currSum -= i;
                    res.remove(res.size()-1);
                }
            }
        }
    }
    
    public void getToTargetWithUniqueCombinationsInputARrayGiven(int a[], int index, int target, int currSum, ArrayList<Integer> res) {
        if (currSum == target) {
            System.out.println(res);
            return;
        } else {
            if (index >= a.length) {
                return;
            } else {
                for(int i=index;i<a.length;i++) {
                    if ((currSum + a[i]) <= target) {
                        currSum += a[i];
                        res.add(a[i]);
                        getToTargetWithUniqueCombinationsInputARrayGiven(a, i+1, target, currSum, res);
                        currSum -= a[i];
                        res.remove(res.size() -1);
                    }
                }
            }
        }
    }
   
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n=9, k=3;
        CombinationSum obj = new CombinationSum();
        obj.uniQueCombinations(n, 0, 1, new ArrayList<Integer>(), k);
        
        // other variation
        /*
         * Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]
         */
        // v2 start
        System.out.println("--------------v2-------------");
        int arr[] = {2, 3, 6, 7, 7};
        int target = 7;
        obj.getCombinationSumV2(arr, 0, 0, new ArrayList<Integer>(), target);
        
        
        // new 2 types
        // type 1- get to target with repetitions
        System.out.println("--------------type 1- get to target with repetitions-------------");
        obj.getRepeatedCombinations(9, 0, new ArrayList<Integer>());
        System.out.println("--------------type 2- get to target without repetitions-------------");
        obj.getToTargetWithUniqueSet(9, 0, new ArrayList<Integer>(), 1);
        System.out.println("--------------type 3- get to target without repetitions from given array-------------");       
        obj.getToTargetWithUniqueCombinationsInputARrayGiven(arr, 0,9,0,new ArrayList<Integer>());
    }
    
    
}
