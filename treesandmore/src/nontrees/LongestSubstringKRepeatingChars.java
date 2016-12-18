package nontrees;
import java.util.*;
//Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.
/*Input:
s = "aaabb", k = 3

Output:
3

The longest substring is "aaa", as 'a' is repeated 3 times.*/
public class LongestSubstringKRepeatingChars {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String a = "aaabb";
        int k = 1;
        
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        for(int i=0;i<a.length();i ++) {
            if (!count.containsKey(a.charAt(i))) {
                count.put(a.charAt(i), 1);
            } else {
                count.put(a.charAt(i), count.get(a.charAt(i))+1);
            }
        }
        
        Set<Map.Entry<Character, Integer>> set = count.entrySet();
        
        for(Map.Entry<Character, Integer> j : set) {
            System.out.println(j.getKey() + " - " + j.getValue());
        }
        
        System.out.println("-------------");
        int windowStart = 0;
        int windowEnd = 0;
        int maxLength = 0;
        for(int i=0;i<a.length();i++) {
            if (count.get(a.charAt(i)) < k) {
                windowStart = i;
                windowEnd = i;
            } else {
                windowEnd++;
            }
            if (windowEnd - windowStart > maxLength) {
                maxLength = windowEnd - windowStart;
            }
        }
        System.out.println(maxLength);
    }

}
