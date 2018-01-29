package treessandtrees;
//https://leetcode.com/problems/combination-sum-iv/description/
import java.util.*;
public class NumberOfWaysToGetTarget {
    int num ;
    NumberOfWaysToGetTarget() {
        num = 0;
    }
    
    public ArrayList<ArrayList<Integer>> getTarget(int a[], int target, int currSum, int start, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> res) {
        if (currSum == target) {
            res.add(new ArrayList<Integer>(list));
            num++;
        }
        for(int i=start;i<a.length;i++) {
            if (currSum + a[i] <= target) {
                currSum += a[i];
                list.add(a[i]);
                getTarget(a, target, currSum, 0, list, res); // use same i
                currSum -= a[i]; // backtrack
                list.remove(list.size()-1);
            }
        }
        
        return res;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        NumberOfWaysToGetTarget obj = new NumberOfWaysToGetTarget();
        int a[] = {1,2,3};
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        res = obj.getTarget(a, 4, 0, 0, new ArrayList<Integer>(), res);
        System.out.println(obj.num);
        System.out.println(res);
    }

}
