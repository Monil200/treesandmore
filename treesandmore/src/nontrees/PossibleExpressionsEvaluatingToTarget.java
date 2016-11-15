package nontrees;
import java.util.*;
public class PossibleExpressionsEvaluatingToTarget {
    public static char[] expressions = {'$', '+', '-', '*'};
    public static void possibleExpressions(char[] nums, int start) {
        if (start >= nums.length) {
            System.out.println(Arrays.toString(nums));
        } else {
            for(int i=start; i<nums.length; i = i+2) {
                for(int j=0;j<expressions.length;j++) {
                    nums[start] = expressions[j];
                    possibleExpressions(nums, start+2);
                }
            }
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String a = "123";
        int signCount = 0;
        char targetChar[] = new char[a.length()*2 -1];
        for(int i=0;i<a.length()*2;i++) {
            targetChar[i] = a.charAt(i/2);
            signCount = i+1;
            if (signCount < a.length()*2 -1)
                targetChar[signCount] = '$';
            i = signCount;
        }
        System.out.println(Arrays.toString(targetChar));
        possibleExpressions(targetChar, 1);
//        System.out.println(Arrays.toString(targetChar));
    }

}
