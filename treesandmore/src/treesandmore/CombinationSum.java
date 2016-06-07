package treesandmore;

// https://leetcode.com/problems/combination-sum-iii/
/*
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

   Ensure that numbers within the set are sorted in ascending order.
 */
public class CombinationSum {
    
    public static int newMemberToMakeSum(int n, int sumSoFar, int k) {
        if (n - sumSoFar > k) {
            return n - sumSoFar;
        } else {
            return -1;
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n=9, k=3;
        Integer a[] = new Integer[k];
        int initialSum = 0;
        for (int i=0;i<k;i++) {
            a[i] = 1+i;
            initialSum += a[i];
        }
        System.out.println(initialSum);
        
        for (int i=0;i<k;i++) {
            int newMember = newMemberToMakeSum(n, initialSum - a[i], k); 
            if (newMember >= 0) {
                System.out.print("[");
                for (int j=0; j<k; j++) {
                    if (j != i) {
                        System.out.print(a[j] + " , ");
                    }
                }
                System.out.println(newMember + "]");
            }
        }
        
    }

}
