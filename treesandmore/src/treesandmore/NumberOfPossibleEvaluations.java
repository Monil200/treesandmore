package treesandmore;
import java.util.*;
public class NumberOfPossibleEvaluations {
    
    public ArrayList<Integer> getPossibleAnswersOfExpressions(String s) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i=0;i<s.length();i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*') {
                ArrayList<Integer> left =  getPossibleAnswersOfExpressions(s.substring(0,i)); // i is excluding
                ArrayList<Integer> right =  getPossibleAnswersOfExpressions(s.substring(i+1)); // i is excluding 
                
                switch(s.charAt(i)) {
                    case '+':
                        res.addAll(operations('+', left, right));
                        break;
                    case '-':
                        res.addAll(operations('-', left, right));
                        break;
                    case '*':
                        res.addAll(operations('*', left, right));
                        break;
                }
            }
        }
        // if its a single char
        if (res.size() == 0) {
            res.add(Integer.valueOf(s));
        }
        System.out.println("for input s:" + s + " return:" + res);
        return res;
    }
    
    public ArrayList<Integer> operations(char c, ArrayList<Integer> a, ArrayList<Integer> b) {
        if (a.size() == 0 && b.size() == 0)
            return null;
        else if (a.size() == 0 && b.size() > 0) {
            return b;
        } else if (a.size() > 0 && b.size() == 0) {
            return a;
        } else {
            ArrayList<Integer> res = new ArrayList<Integer>();
            for(Integer i : a)  {
                for(Integer j: b) {
                    switch(c) {
                        case '+':
                            res.add(i+j);
                            break;
                        case '-':
                            res.add(i-j);
                            break;
                        case '*':
                            res.add(i*j);
                            break;
                    }
                }
            }
            return res;
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        NumberOfPossibleEvaluations obj = new NumberOfPossibleEvaluations();
        System.out.println(obj.getPossibleAnswersOfExpressions("2*1+1"));
    }

}
