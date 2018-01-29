package treessandtrees;
import java.util.*;
public class BreakWord {
    Set<String> map;
    int minBreaks = Integer.MAX_VALUE;
    BreakWord(String s[]) {
        map = new HashSet<String>();
        map.addAll(Arrays.asList(s));
    }
    
    public void breakWord(String a, int index, String current, int breaks, String sentence) {
        System.out.println("sentence:" + sentence + " | current:" + current);
        if (index == a.length() && map.contains(current)) {
            if (breaks < minBreaks) {
                minBreaks = breaks;
                System.out.println("*************" + sentence + " " + current);
            }
        }
        if (index >= a.length()) {
            return;
        }
        for(int i=index;i<a.length();i++) {
            current += a.charAt(i);
            breakWord(a, 1+i, current, breaks, "");
            if (map.contains(current)) {
                System.out.println("current:" + current + " index:" + i);
                String sentenceCopy = sentence;
                String currentCopy = current;
                sentence += current + " ";
                current = "";
                breakWord(a, 1+i, current, ++breaks, sentence);
                --breaks;
                current = currentCopy;
                sentence = sentenceCopy;
            }
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s[] = {"and", "sand", "dog", "c", "ats"};
        BreakWord obj = new BreakWord(s);
        obj.breakWord("catsanddog", 0, "", 0, "");
        System.out.println(obj.minBreaks);
        
    }

}
