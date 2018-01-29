package treessandtrees;
/*
 * There is a strange printer with the following two special requirements:

The printer can only print a sequence of the same character each time.
At each turn, the printer can print new characters starting from and ending at any places, and will cover the original existing characters.
Given a string consists of lower English letters only, your job is to count the minimum number of turns the printer needed in order to print it.

Example 1:
Input: "aaabbb"
Output: 2
Explanation: Print "aaa" first and then print "bbb".
Example 2:
Input: "aba"
Output: 2
Explanation: Print "aaa" first and then print "b" from the second place of the string, which will cover the existing character 'a'.
Hint: Length of the given string will not exceed 100.
 */
import java.util.*;
public class StrangePrinter {
    public void getMinKeyStrokes(String s) {
        if (s == null || s.length() == 0) {
            return;
        }
        
        char typed[] = new char[s.length()];
        int opt[] = new int[s.length()];
        opt[0] = 1;
        HashMap<Character, ArrayList<Integer>> map = new HashMap<Character, ArrayList<Integer>>();
        for(int i=0;i<s.length();i++) {
            typed[i] = s.charAt(0);
            if (map.containsKey(s.charAt(i))) {
                ArrayList<Integer> temp = map.get(s.charAt(i));
                temp.add(1, i);
                map.put(s.charAt(i), temp);
            } else {
                map.put(s.charAt(i), new ArrayList<Integer>(Arrays.asList(i)));
            }
        }
        
        for(int i=1;i<s.length();i++) {
            if (typed[i] != s.charAt(i)) {
                if (s.charAt(i) == typed[i-1]) {
                    opt[i] = opt[i-1];
                    continue;
                } // dunno wht is this doing, answer for aabaaba = 4 but this if is making it 3
                // other way to think, this if says - if i printed the same char in previous iteration i know the ending index of my print
                opt[i] = opt[i-1] + 1;
                ArrayList<Integer> firstLast = map.get(s.charAt(i));
                System.out.print("in if for:" + s.charAt(i) + " firstLast size:" + firstLast.size());
                if (firstLast.size() > 1 && i == firstLast.get(0)) { // change typed array only if this is first occourance of the char 
                    System.out.println(" > 1: " + firstLast.get(0) + " - " + firstLast.get(1));
                    for(int j=firstLast.get(0);j<=firstLast.get(1);j++) {
                        typed[j] = s.charAt(i);
                    }
                } else {
                    System.out.println(" size < 1");
                    typed[i] = s.charAt(i);
                }
                System.out.println("\t" + Arrays.toString(typed));
            } else {
                opt[i] = opt[i-1];
            }
        }
        
        System.out.println(Arrays.toString(typed));
        System.out.println("Min chars" + opt[s.length()-1]);
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        StrangePrinter obj = new StrangePrinter();
//        obj.getMinKeyStrokes("monil");
        obj.getMinKeyStrokes("aabaaba");
    }

}
