package treesandmore;
import java.util.*;
public class InvalidParanthesisRemoval {

    public static boolean isValid(String s, int originalLength) {
        if (s.length() != originalLength || s.charAt(s.length()-1) == '(' || s.charAt(0) == ')') {
            return false;
        }
        int count =0;
        for(int i=0;i<s.length();i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if(s.charAt(i) == ')') {
                count--;
            } else {
                continue;
            }
        }
        if (count ==0) {
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String  s = "(v)())()";
        List<String> results = new ArrayList<String>();
        HashSet<String> visited = new HashSet<String>();
        int counter = 0;
        Queue<String> q = new LinkedList<String>();
        q.add(s);
        while(!q.isEmpty()) {
            String popped = q.remove();
            if (counter > 0) {
                if (isValid(popped, s.length()-1)) {
                    results.add(popped);
                }
            }
            counter++;
            String temp = "";
            for(int i=0;i<popped.length();i++) {
                temp = popped.substring(0, i) + popped.substring(i+1, popped.length());
                if (!visited.contains(temp)) {
                    q.add(temp);
                    visited.add(temp);
                }
            }
        }
        for(String i : results) {
            System.out.println(i);
        }
    }

}
