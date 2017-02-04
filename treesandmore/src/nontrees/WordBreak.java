package nontrees;

/*
 * Given a valid sentence without any spaces between the words and a dictionary of valid English words, find all possible ways to break the sentence in individual dictionary words.

Example

Consider the following dictionary 
{ i, like, sam, sung, samsung, mobile, ice, 
  cream, icecream, man, go, mango}

Input: "ilikesamsungmobile"
Output: i like sam sung mobile
        i like samsung mobile

Input: "ilikeicecreamandmango"
Output: i like ice cream and man go
        i like ice cream and mango
        i like icecream and man go
        i like icecream and mango
 */
import java.util.*;
public class WordBreak {
    public static void wordBreakRecurr(String s, String curr, String word, int i, HashSet<String> dict) {
        if (i == word.length()) {
            if (dict.contains(curr))
                System.out.println(s+curr);
        } else {
            curr += word.charAt(i);
            wordBreakRecurr(s, curr, word, i+1, dict);
            if (dict.contains(curr)) {
                s += curr + " ";
                curr = "";
                wordBreakRecurr(s, curr, word, i+1, dict);
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        HashSet<String> dict = new HashSet<String>();
        dict.add("i");
        dict.add("like");
        dict.add("sam");
        dict.add("sung");
        dict.add("samsung");
        dict.add("mobile");
        dict.add("ice");
        dict.add("cream");
        dict.add("icecream");
        dict.add("man");
        dict.add("go");
        dict.add("mango");
        dict.add("and");
        
        String word = "ilikeicecreamandmango";
        wordBreakRecurr("", "", word, 0, dict);
    }

}
