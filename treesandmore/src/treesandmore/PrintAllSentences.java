package treesandmore;

import java.util.*;

// still WIP
public class PrintAllSentences {
    static String a[][]  = {{"you", "we"},{"have", "are"},{"sleep", "eat", "drink"}};
    
    public static void printSentence(int start, String[] output) {
        if (start == a.length) {
            System.out.println(Arrays.toString(output));
        } else {
            for(int i=0;i<a[start].length;i++) {
                output[start] = a[start][i];
                printSentence(start+1, output);
            }
        }
    }
    
    public static void printCombinations(int start, char[] output, String s) {
        if (start == s.length()) {
            System.out.println(Arrays.toString(output));
        } else {
            for(int i=start;i<s.length();i++) {
                char temp[] = s.toCharArray();
                char t = temp[start];
                temp[start] = temp[i];
                temp[i] = t;
                s = String.valueOf(temp);
                printCombinations(start+1, temp,s);
            }
        }
    }
    
    
    public static HashMap<Integer, String> keys = new HashMap<Integer, String>();
    public static void t9dictionary(int[] inputs, String[] output, int start) {
        if (start == inputs.length) {
            System.out.println(Arrays.toString(output));
        } else {
            for(int j=0; j<keys.get(inputs[start]).length(); j++) {
                output[start] = keys.get(inputs[start]).charAt(j) + "";
                t9dictionary(inputs, output, start+1);
            }
        }
    }
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        PrintAllSentences obj = new PrintAllSentences();
        String output[] = new String[a.length];
        printSentence(0, output);
        char o[] = {};
        printCombinations(0, o, "ABC");
        
        //t9
        keys.put(2, "abc");
        keys.put(3, "def");
        keys.put(4, "ghi");
        keys.put(5, "jkl");
        keys.put(6, "mno");
        keys.put(7, "pqrs");
        keys.put(8, "tuv");
        keys.put(9, "wxyz");
        
        int inputs[] = {2,3,4};
        
        String outputcomb[] = new String[inputs.length];
        t9dictionary(inputs , outputcomb, 0);
        
        
        
    }
    
    
    

}
