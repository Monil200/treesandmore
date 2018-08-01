package nontrees;
import java.util.*;
public class LongestSubstringKDistinctChars {
    
    public void getLongestSubstringWithKDistingChars(String s, int k) {
        HashSet<Character> unique = new HashSet<Character>();
        Queue<Character> q = new LinkedList<Character>();
        HashMap<Character, Integer> qcount = new HashMap<Character, Integer>(); 
        
        if (k==0)
            return;
        q.add(s.charAt(0));
        unique.add(s.charAt(0));
        qcount.put(s.charAt(0), 1);
        int maxLength = 1; // base case
        int currLength = 1;
        for(int i=1;i<s.length();i++) {
            char t = s.charAt(i);
            q.add(t);
            unique.add(t);
            qcount.put(t, qcount.getOrDefault(t,0)+1);
            
            if (unique.size() > k) {
                while(q.size() > 0 && unique.size() > k) {
                    char removedChar = q.remove();
                    if (qcount.containsKey(removedChar) && qcount.get(removedChar) > 1) {
                        qcount.put(removedChar, qcount.get(removedChar)-1);
                    } else if (qcount.containsKey(removedChar) && qcount.get(removedChar) == 1){
                        qcount.remove(removedChar);
                        unique.remove(removedChar);
                    }
                }
            } else {
                currLength = q.size();
                if (currLength > maxLength) {
                    maxLength = currLength;
                }
            }
            System.out.println(q);
            System.out.println(unique);
            System.out.println(qcount);
            System.out.println();
        }
        
        System.out.println("Max length substring with max K distinct chars:" + maxLength);
        
    }
    
    public void getLongestSubstringWithKDistinctCharsV2(String s, int k) {
        int counts[] = new int[26];
        int start = 0, end= 0, counter = 0;
        int maxLength = Integer.MIN_VALUE;
        while(end<s.length()) {
            if (counts[s.charAt(end++) - 'a']++ == 0) {
                counter++;
            }
            while(counter > k) {
                if (counts[s.charAt(start) - 'a'] > 1) {
                    counts[s.charAt(start) - 'a']--;
                } else {
                    counts[s.charAt(start) - 'a'] = 0;
                    counter--;
                }
                start++;
            }
            if (end - start > maxLength) {
                maxLength = end - start;
            }
        }
        
        System.out.println("V2 - Max length substring with max K distinct chars:" + maxLength);
    }
    
    public void longestSubstringWithoutRepeatingChars(String s) {
        int counts[] = new int[26];
        int start = 0, end = 0, counter = 0;
        int maxLength = Integer.MIN_VALUE;
        while(end < s.length()) {
            if (counts[s.charAt(end) - 'a'] == 0) {
                counts[s.charAt(end) - 'a']++;
            } else if (counts[s.charAt(end) - 'a'] > 0) {
                counts[s.charAt(end) - 'a']++;
                counter++;
            }
            end++;
            
            while(counter > 0) {
                if (counts[s.charAt(start) - 'a'] > 1) {
                    counts[s.charAt(start) - 'a']--;
                } else {
                    counts[s.charAt(start) - 'a'] = 0;
                    counter--;
                }
                start++;
                if ((end - start) > maxLength) {
                    maxLength = end - start;
                }
            }
        }
        
        if (maxLength == Integer.MIN_VALUE) {
            maxLength = s.length();
        }
        
        System.out.println("Max length substring without repeating chars:" + maxLength + " String:" + s);
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        LongestSubstringKDistinctChars obj = new LongestSubstringKDistinctChars();
        obj.getLongestSubstringWithKDistingChars("abbxzbbzaz", 2);
        
        obj.getLongestSubstringWithKDistinctCharsV2("abbxzbbzaz", 2);
        
        // longest substring without repeating chars.
        obj.longestSubstringWithoutRepeatingChars("abcdcdh");
    }

}
