package nontrees;

public class Solution {
    public int hammingDistance(int x, int y) {
        int diff = 0;
        int c = x ^ y;
        String a = Integer.toBinaryString(c);
        
        for(int i=0;i<a.length(); i++) {
            if (a.charAt(i) == '1') {
                diff++;
            }
        }
        
        return diff;
    }
    
    public int totalHammingDistance(int[] nums) {
        int distance = 0;
        for(int i=0;i<nums.length-1;i++) {
            for(int j=i+1; j< nums.length;j++) {
                distance += hammingDistance(nums[i], nums[j]);
            }
        }
        return distance;
    }
    public static void main(String args[]) {
        Solution obj = new Solution();
        int a[] = {4,14,2};
        System.out.println(obj.totalHammingDistance(a));
    }
}
