package treessandtrees;
import java.util.*;
public class DecodeString {
    
    public void decodeString(Stack<Integer> count, String s) {
        if (s == null || s.length() == 0) {
            return;
        }
        StringBuilder num = new StringBuilder();
        StringBuilder chars = new StringBuilder();
        for(int i=0;i<s.length();i++) {
            if ((int) s.charAt(i) >= 48 && (int) s.charAt(i) <= 57) { // if num
                num.append(s.charAt(i));
            } else if ((int) s.charAt(i) >= 97 && (int) s.charAt(i) <= 122 || (int) s.charAt(i) >= 64 && (int) s.charAt(i) <= 89) {
                chars.append(s.charAt(i));
            } else if (s.charAt(i) == '[') {
                if (num.length() > 0) {
                    count.push(Integer.parseInt(num.toString()));
                    num.setLength(0);
                }
            } else if (s.charAt(i) == ']') {
                // do the string forming operation here
                int counter = count.size() > 0 ? count.pop() : 0;
                System.out.println("before entring for loop chars:" + chars);
                StringBuilder temp = new StringBuilder();
                for(int j=0;j<counter;j++) {
                    temp.append(chars);
                }
                chars = new StringBuilder(temp);
                System.out.println("counter: " + counter +  " Result from intermediate stage:" + chars);
            }
        }
        System.out.println(chars);
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DecodeString obj = new DecodeString();
        obj.decodeString(new Stack<Integer>(), "3[2[2[ab]cd]]"); //       ababcdababcd
    }

}
