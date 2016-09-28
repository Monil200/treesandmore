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
    
    public static void main(String args[]) {
        String str = "ABC";
        permuteString(str, 0, str.length());
        // ABC ACB BAC BCA CBA CAB
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
//        String[] temp = new String[flattenedA.size()];
//        temp = flattenedA.toArray(temp);
//        System.out.println(Arrays.toString(temp));
    }
}
