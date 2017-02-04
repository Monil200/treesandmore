package postbuilding42;
import java.util.*;
public class T9AndCo {
    
    public static void combinationsOfString(String s, int start) {
        if (start == s.length()) {
            System.out.println(s);
        } else {
            for(int i=start; i<s.length();i++) {
                char toChar[] = s.toCharArray();
                char temp = toChar[start];
                toChar[start] = toChar[i];
                toChar[i] = temp;
                s = String.valueOf(toChar);
                combinationsOfString(s, start+1);
            }
        }
    }
    /*
     * T9 dictionalry
    */
    
    static HashMap<Integer, String> dict = new HashMap<Integer, String>();
    public static void t9dictionary(String s, int start, int[] strokes) {
        if (s.length() == strokes.length) {
            System.out.println(s);
            return;
        } else {
            for(int i=0;i<dict.get(strokes[start]).length();i++) {
                s += dict.get(strokes[start]).charAt(i);
                t9dictionary(s, start+1, strokes);
                s = s.substring(0, s.length()-1);
            }
        }
    }
    
    static String[][] urls = {{"http.", "https."},{"yahoo.", "google."}, {"com", "co.in"}};
    public static void urlCombinations(String s, int start) {
        if (start == urls.length) {
            System.out.println(s);
        } else {
            for(int i=0;i<urls[start].length;i++) {
                s += urls[start][i];
                urlCombinations(s, start+1);
                s = s.replace(urls[start][i], "");
            }
        }
    }
    
    public static void binaryWatch(int watch[], int start, int count, int setTillNow) {
        if (setTillNow == count ) {
            System.out.println(Arrays.toString(watch));
            return;
        } else {
            for(int i=start;i<watch.length;i++) {
                watch[i] = 1;
                setTillNow++;
                binaryWatch(watch, start+1, count, setTillNow);
                watch[i] = 0;
                setTillNow--;
            }
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        combinationsOfString("abc", 0);
        dict.put(2, "abc");
        dict.put(3, "def");
        dict.put(4, "ghi");
        dict.put(5, "jkl");
        dict.put(6, "mno");
        dict.put(7, "pqrs");
        dict.put(8, "tuv");
        dict.put(9, "wxyz");
        
        System.out.println("-----------------T9----------------");
        int strokes[] = {2,3,4};
        t9dictionary("", 0, strokes);
        
        System.out.println("-----------------URL combinations----------------");
        urlCombinations("", 0);
        
        System.out.println("-----------------Binary watch----------------");
        int watch[] = new int[10];
        
        binaryWatch(watch, 0, 4, 0);
        
    }

}
