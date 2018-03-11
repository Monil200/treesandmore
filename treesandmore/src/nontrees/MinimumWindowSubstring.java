package nontrees;
import java.util.*;

// find min window in a such that it contains all chars in target.
public class MinimumWindowSubstring {
    
    public void getMinimumWindowSubstring(String s, String t) {
        int counts[] = new int[26];
        
        for(int i=0;i<t.length();i++) {
            char c = t.charAt(i);
            counts[c - 'a']++;
        }
        
        System.out.println(Arrays.toString(counts));
        
        int end = 0, start = 0;
        int minLength = Integer.MAX_VALUE;
        int counter = 0;
        
        while(end < s.length()) {
            if (counts[s.charAt(end++) - 'a'] > 0) {
                counter++;
            }
            if (counter == t.length()) {
                int currLength = end - start;
                if (currLength < minLength) {
                    minLength = currLength;
                }
                while(counter == t.length() && start < s.length()) {
                    if (counts[s.charAt(start++) - 'a'] > 0) {
                        counter--;
                    }
                }
            }
        }
        
        System.out.println("Minimum window substring is of length:" + minLength);
        
        
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MinimumWindowSubstring obj = new MinimumWindowSubstring();
        obj.getMinimumWindowSubstring("adobecbanc", "abc");
    }

}
