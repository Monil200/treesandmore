package treesandmore;
import java.util.*;
public class PermitationsOfString {
    
    // s = start to consider string from
    // e = end of string/substring
    // str = string/substring
    public static void permuteString(String str, int s, int e) {  
        if (s == e) {
            System.out.println(str); 
        } else {
            for(int i=s;i<str.length();i++) {
                char strarr[] = str.toCharArray();
                char temp = str.charAt(s);
                strarr[s] = strarr[i];
                strarr[i] = temp; 
                str = String.valueOf(strarr);
                permuteString(str, s+1, e);
            }
        }
    }
    
 // s = start to consider string from
    // e = end of string/substring
    // arr = string/substring
    public static void permuteArray(ArrayList<String> str, int s, int e) {  
        if (s == e) {
            String[] temp = new String[str.size()];
            temp = str.toArray(temp);
            System.out.println(Arrays.toString(temp)); 
        } else {
            for(int i=s;i<str.size();i++) {
                String temp = str.get(s);
                str.set(s, str.get(i));
                str.set(i, temp);
                permuteArray(new ArrayList<String>(str), s+1, str.size()); // sending new ARraylist every time is done...
                // .. in order to avoid backtracking and do the reverse swap to bring Str/arrayList to original form
            }
        }
    }
    
    public static void permuteWildString(String str, int s) {
        if (s == str.length()) {
            System.out.println(str);
        } else {
            String wildStrCopy;
            for(int i=s;i<str.length();i++) {
                if (str.charAt(i) == '?') {
//                   System.out.println("i:" + i + " char:" + str.charAt(i));
                   char temp[] = str.toCharArray();
                   temp[i] = '1';
                   wildStrCopy = String.valueOf(temp);
                   temp[i] = '0';
                   str = String.valueOf(temp);
                   permuteWildString(wildStrCopy, i+1);
                   permuteWildString(str, i+1);
                }
            }
        }
    }
    
    // t9 dictionary implementation.
    public static Map<Integer, String> dict = new HashMap<Integer, String>();
    public static void t9Permutations(String[] output, int[] keys, int currentDigit) {
        if (currentDigit == keys.length) {
            System.out.println(Arrays.toString(output));
        } else {
            for(int i=0;i<dict.get(keys[currentDigit]).length();i++) {
                output[currentDigit] = dict.get(keys[currentDigit]).charAt(i) + "";
                t9Permutations(output, keys, currentDigit+1);
            }
        }
    }
    
    
    public static void main(String args[]) {
        
        // program to get all permutations of a string
        // ABC ACB BAC BCA CBA CAB
        String str = "ABC";
        permuteString(str, 0, str.length());
        
        // program to get all combinations of sentences from words in an array.
        String a[][]  = {
            {"you"},
            {"have"},
            {"sleep"}
        };
        
        ArrayList<String> flattenedA = new ArrayList<String>();
        for (int i=0;i<a.length;i++) {
            for(int j=0;j<a[i].length;j++) {
                flattenedA.add(a[i][j]);
            }
        }
        permuteArray(flattenedA, 0 , flattenedA.size());
        
        // A wildcard char '?' can be '0' or '1'.
        // generate all possible combinations of a string.
        String wildStr = "000?";
        permuteWildString(wildStr, 0);
        
        // t9 dictionary.
        dict.put(2, "abc");
        dict.put(3, "def");
        dict.put(4, "ghi");
        dict.put(5, "jkl");
        dict.put(6, "mno");
        dict.put(7, "pqrs");
        dict.put(8, "tuv");
        dict.put(9, "wxyz");
        int strokes[] = {2,3,4};
        String temp[] = new String[strokes.length];
        t9Permutations(temp, strokes, 0);
    }
    
    
}
