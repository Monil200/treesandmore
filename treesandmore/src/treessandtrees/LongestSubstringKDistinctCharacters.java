package treessandtrees;
//https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/description/
import java.util.*;
public class LongestSubstringKDistinctCharacters {
    int maxLength = Integer.MIN_VALUE;
    
    public void getMaxLength(String s, int k) {
        if (s == null || s.length() == 0)
            return;
        
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        for(int i=0;i<s.length(); i++) {
            if (count.containsKey(s.charAt(i))) {
                count.put(s.charAt(i), count.get(s.charAt(i))+1);
            } else {
                count.put(s.charAt(i), 1);
            }
        } // count done.
        
        Queue<Character> q = new LinkedList<Character>();
        HashMap<Character, Integer> qcount = new HashMap<Character, Integer>();
        int currLength = 0;
        for(int i=0;i<s.length();i++) {
            char t = s.charAt(i);
            System.out.println("char:" + t + " count:" + count.get(t));
            if (count.get(t) >= k) {
                q.add(t);
                if (qcount.containsKey(t)) {
                    qcount.put(t, qcount.get(t)+1);
                } else {
                    qcount.put(t, 1);
                }
                System.out.println("\tchar:" + t + " added to queue , qcount:" + qcount.get(t));
            } else {
                // remove everything from queue and note the current maxLength, coz new candidate substring shall form if any
                // clear qcount too
                while(!q.isEmpty()) {
                    while(true && !q.isEmpty()) {
                        char frontChar = q.poll();
                        System.out.println(" got something < k: " + frontChar + " its qcount:" + qcount.get(frontChar));
                        if (qcount.get(frontChar) >= k) {
                            currLength++;
                        } else {
                            break;
                        }
                    }
                    if (currLength > maxLength) {
                        maxLength = currLength;
                    }
                    currLength = 0;
                }
                qcount.clear();
            }
        }
        if (maxLength < q.size()) {
            maxLength = q.size();
        }
    } 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LongestSubstringKDistinctCharacters obj = new LongestSubstringKDistinctCharacters();
        obj.getMaxLength("cdaacdx", 2);
        System.out.println(obj.maxLength);
    }

}
