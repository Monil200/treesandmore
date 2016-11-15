package nontrees;
import java.util.*;

// find min window in a such that it contains all chars in target.
public class MinimumWindowSubstring {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String a= "this is a test string";
        String target = "etri";
        
        Queue<Character> toRemove = new LinkedList<Character>();
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        HashMap<Character, Integer> targetMap = new HashMap<Character, Integer>();
        int start = 0, putCount = 0;
        int minLength = Integer.MAX_VALUE, currentLength = 0;
        char t;
        
        for(int i=0;i<target.length();i++) {
            if (!targetMap.containsKey(target.charAt(i))) {
                targetMap.put(target.charAt(i), 1);
            }
        }
        for(int i=0;i<a.length();i++) {
            t = a.charAt(i);
            if (targetMap.containsKey(t)) {
                toRemove.add(t);
                putCount++;
                if (count.containsKey(t)) {
                    count.put(t, count.get(t) +1);
                } else {
                    count.put(t, 1);
                }
            }
            
            // backtrack start pointer
            while (putCount > target.length() && count.get(toRemove.peek()) > 1) {
                t = toRemove.poll();
                if (count.get(t) > 1) {
                    count.put(t, count.get(t) -1);
                } else {
                    count.remove(t);
                }
                putCount--;
                start++;
            }
            
            // move start to position where we again find any character in the target string.
            while(!targetMap.containsKey(a.charAt(start))) {
                start++;
                System.out.println(" char : " + a.charAt(i) + " - i:" + i + " Start :" + start);
                // calculate length
                currentLength = i - start +1;
                if (currentLength < minLength ) {
                    minLength = currentLength;
                    System.out.println("Minimum length in loop :" + minLength);
                }
            }
        }
        
        // final movement of start to goto first character in targetMap
        start ++;
        while(!targetMap.containsKey(a.charAt(start))) {
            start++;
            currentLength = a.length() - start;
            if (currentLength < minLength ) {
                minLength = currentLength;
                System.out.println("Minimum length in loop :" + minLength);
            }
        }
        System.out.println("Minimum window substring which contains all characters from target :" + minLength);
    }

}
