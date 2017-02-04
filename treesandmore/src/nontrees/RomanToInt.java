package nontrees;
import java.util.HashMap;
public class RomanToInt {
    public static HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    public static void  convert(String a) {
        char s[] = a.toCharArray();
        int i=0;
        Character prev = null;
        int result = 0;
        
        while(i<s.length) {
            if (i>0) {
                if (map.get(prev) < map.get(s[i])) {
                    result -= map.get(prev);
                    result += map.get(s[i]) - map.get(prev);
                } else {
                    result += map.get(s[i]);
                }
                prev = s[i];
            } else {
                prev = s[i];
                result += map.get(s[i]);
            }
            i++;
        }
        System.out.println(result);
        
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        map.put('I', 1);
        map.put('V', 5);
        map.put('C', 50);
        map.put('X', 10);
        map.put('L', 100);
        map.put('M', 1000);
        
        String input = "MCMLIX"; //1000 + 950+ 100+9
//        String input = "XXIV"; //1000 + 950+ 100+9
        convert(input);
        
    }

}
