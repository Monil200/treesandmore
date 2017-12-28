package nontrees;
import java.util.*;
public class PossibleExpressionsEvaluatingToTarget {
    public static void possibleExpressionsDFS(char[] nums, int numStart) {
        if (numStart >= nums.length) {
            System.out.println(Arrays.toString(nums));
            return;
        }
        
        System.out.println("numStart: " + numStart);
        nums[numStart] = '+';
        possibleExpressionsDFS(nums, numStart + 2);
        nums[numStart] = '-';
        possibleExpressionsDFS(nums, numStart + 2);
        nums[numStart] = '*';
        possibleExpressionsDFS(nums, numStart + 2);
        nums[numStart] = '/';
        possibleExpressionsDFS(nums, numStart + 2);
        
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String a = "123";
        int numCount = 0;
        char targetChar[] = new char[a.length()*2 -1];
        for(int i=0;i<targetChar.length;i++) {
            if (i%2==0) {
                targetChar[i] = a.charAt(numCount);
                ++numCount;
            } else {
                targetChar[i] = '`';
            }
        }
        System.out.println(Arrays.toString(targetChar));
        possibleExpressionsDFS(targetChar, 1);
    }

}
