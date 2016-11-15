package nontrees;
import java.util.*;
public class LongestSubstringKDistinctChars {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        String a = "ecelob";
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int k = 2, putCount = 0;
        char t;
        int start = 0;
        int currentLength = 0, maxLength = 0;
        for(int i=0;i<a.length();i++) {
            //put part
            t = a.charAt(i);
            if (map.containsKey(a.charAt(i))) {
                map.put(t, map.get(t) +1); // update count
            } else {
                putCount++;
                map.put(t, 1);
            }
            // remove part
            while (putCount > k) {
                t = a.charAt(start);
                if (map.get(t) > 1) {
                    map.put(t, map.get(t) -1);
                } else {
                    map.remove(t);
                    putCount--;
                }
                start++;
            }
            currentLength = i - start +1;
            if (maxLength < currentLength) {
                maxLength = currentLength;
            }
        }
        System.out.println("Larget substring of with max k distinct chars is :" + maxLength);
    }

}
