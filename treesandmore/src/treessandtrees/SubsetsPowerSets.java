package treessandtrees;
/*
 * Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
https://leetcode.com/problems/combination-sum/discuss/16502
 */
import java.util.*;
public class SubsetsPowerSets {
    
    // no dups in set
    public void printSets(int a[], List<ArrayList<Integer>> res, ArrayList<Integer> toAdd, int start) {
        System.out.println(toAdd);
        res.add(new ArrayList<Integer>(toAdd));
        
        for(int i=start; i<a.length;i++) {
            toAdd.add(a[i]);
            printSets(a, res, toAdd, 1+i);
            toAdd.remove(toAdd.size()-1);
        }
    }
    
    public HashSet<ArrayList<Integer>> getSubsetsWithDups(int a[], HashSet<ArrayList<Integer>> res, ArrayList<Integer> hold, int start) {
        res.add(new ArrayList<Integer>(hold));
        
        for(int i=start;i<a.length;i++) {
            hold.add(a[i]);
            getSubsetsWithDups(a, res, hold, 1+i);
            hold.remove(hold.size() -1);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SubsetsPowerSets obj = new SubsetsPowerSets();
        int a[] = {1,2,3};
        // variation 1 - no dups
        obj.printSets(a, new ArrayList<ArrayList<Integer>>(), new ArrayList<Integer>(), 0);
        
        // variation 2 - with dups
        int b[] = {1,2,2};
        HashSet<ArrayList<Integer>> res = new HashSet<ArrayList<Integer>>(); 
        res = obj.getSubsetsWithDups(b, new HashSet<ArrayList<Integer>>(), new ArrayList<Integer>(), 0);
        System.out.println(res);
    }

}
