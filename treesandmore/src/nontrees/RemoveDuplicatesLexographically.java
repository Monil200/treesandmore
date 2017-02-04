package nontrees;
import java.util.*;
public class RemoveDuplicatesLexographically {
    public static void removeDups(String s) {
        if (s.length() == 0 || s== null) {
            return;
        }
        
        Stack<Character> st = new Stack<Character>();
        HashMap<Character, Integer> lastIndex = new HashMap<Character, Integer>();
        HashSet<Character> insert = new HashSet<Character>();
        for(int i=0;i<s.length();i++) {
            lastIndex.put(s.charAt(i), i);
        }
        //cbacdcbc
        for(Map.Entry<Character, Integer> i : lastIndex.entrySet()) {
            System.out.println(i.getKey() + "- "+ i.getValue());
        }
        st.push(s.charAt(0));
        for(int i=1;i<s.length();i++) {
            char t = s.charAt(i);
            if ((int) s.charAt(i) > (int) st.peek()) {
               st.push(t);
            } else {
                while(!st.isEmpty() && ((int) st.peek() > (int) t) && lastIndex.get(st.peek()) > i) {
                    st.pop();
                }
                st.push(t);
            }
            System.out.println("------for loop-----");
            for(Character j : st) {
                System.out.print(j + "-");
            }
            System.out.println();
        }
        
        // show stack contents
        for(Character i : st) {
            System.out.print(i + "-");
        }
        
        
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s = "cbacdcbc";
        removeDups(s);
        
    }

}
