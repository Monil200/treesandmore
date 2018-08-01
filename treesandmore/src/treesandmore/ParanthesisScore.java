package treesandmore;
import java.util.*;
public class ParanthesisScore {
    
    public int depth = 1;
    int res = 0;
    public void calculateScore(String a) {
        if (a == null || a.length() == 0) return;
        Stack<Integer> s = new Stack<Integer>();
        
        for(int i=0;i<a.length();i++) {
            if (a.charAt(i) == '(') {
                depth++;
                s.push(-1);
            } else {
                s.push(1);
                sumStack(s, false);
                depth--;
            }
        }
        
        sumStack(s, true);
        
        System.out.println("Score is" + res);
    }
    
    
    
    public void sumStack(Stack<Integer> s, boolean isFinal) {
        int currSum = 0;
        
        while (s.size() == 0 && s.peek() != -1) {
            currSum += s.pop();
        }
        s.pop(); // pop -1
        res += depth*currSum;
        
        // (())
        // 
        // 3+2+1
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }

}
