package nontrees;
import java.util.*;

// wrong solution
public class MatchSticksToSquare {
    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length <= 3) {
            return false;
        }
        int perimeter = 0, maxSide = 0;
        for(int i=0;i<nums.length;i++) {
            perimeter+=nums[i];
        }
        if (perimeter%4 != 0) {
            return false;
        }
        maxSide = perimeter/4;
//        Arrays.sort(nums);
        int visitedCount = 0;
        boolean visited[] = new boolean[nums.length];
        int bucket[] = new int[4]; // square has 4 sides, can be configurable
        int bucketNum = 0;
        while(visitedCount < nums.length) {
            for(int i=nums.length-1;i>=0;i--) {
                if (!visited[i]) {
                    if (bucket[bucketNum%4] + nums[i] <= maxSide) {
                        bucket[bucketNum%4] += nums[i];
                        visited[i] = true;
                        bucketNum++;
                        visitedCount++;
                        break;
                    }
                }
            }
        }
        for(int i=0;i<bucket.length;i++) {
            System.out.println(" i:" + i + "buckets:" + bucket[i]);
            if (bucket[i] != maxSide)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MatchSticksToSquare obj = new MatchSticksToSquare();
        int a[] = {5,5,5,5,4,4,4,4,3,3,3,3};
//        int a[] = {5,5,5,5,3};
        System.out.println(obj.makesquare(a));
    }

}
