package treesandmore;
/*
 *  https://leetcode.com/problems/longest-valid-parentheses/description/
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */
import java.util.*;
public class LongestValidParenthesis {
    
    public void getLongestValidParenthesis(String a) {
        int l=Integer.MAX_VALUE, r =0;
        int maxLength = Integer.MIN_VALUE;
        Stack<Integer> s = new Stack<Integer>();
        
        for(int i=0;i<a.length();i++){
            char t = a.charAt(i);
            
            if(t == '(') {
                s.push(i);
            } else { // pop, take care of substring formed.
                int currL = 0, currR = 0;
                if (s.size() > 0 && a.charAt(s.peek()) == '(') {
                    currL = s.pop();
                    currR = i;
                    if (l == Integer.MAX_VALUE) { // for the first time
                        l = currL;
                        r = currR;
                    } else {
                        if (currL == l-1) {
                            l = currL;
                            r = currR;
                        } else if (currL == r +1) {
                            r = currR;
                        } else { // new candidate substring
                            l = currL;
                            r = currR;
                        }
                    }
                    if ((r - l +1) > maxLength) {
                        maxLength = r - l + 1;
                    }
                } else {
                    // ignore that unbalanced close brace
                }
            }
        } // for end
        if (maxLength == Integer.MIN_VALUE) {
            System.out.println("Max length is: 0");
        } else {
            System.out.println("Max length is:" + maxLength);
        }
        
        
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LongestValidParenthesis obj = new LongestValidParenthesis();
        obj.getLongestValidParenthesis("))()(");
    }
}
