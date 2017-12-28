package treessandtrees;
import java.util.*;
public class ConcatenatedWords {
    HashSet<String> dict;
    int breaks, maxBreaks;
    ConcatenatedWords() {
        dict = new HashSet<String>();
        breaks=maxBreaks=0;
    }
    public void getConcatenatedWords(String s, int index, String prevString, String currString) {
        if (index == s.length()) {
            if (dict.contains(currString)) {
                System.out.println("p: " + prevString + " q:" + currString);
            }
            return;
        } else {
            if (index >= s.length())
                return;
            
            for(int i=index;i<s.length();i++) {
                currString += s.charAt(i);
                getConcatenatedWords(s, i+1, prevString, currString);
                if (dict.contains(currString)) {
                    breaks++;
                    if (breaks > maxBreaks) {
                        maxBreaks = breaks;
                    }
                    String tempStore = prevString; // ?? is this needed
                    prevString += currString;
                    prevString += " ";
                    currString = "";
                    getConcatenatedWords(s, i+1, prevString, currString);
                    breaks--;
                    prevString = tempStore;
                }
                if (currString.length() > 0)
                    currString = currString.substring(0, currString.length());
                else {
                    currString = "";
                }
            }
        }
    }
    
    public void stringDFS(String s, String curr, int index) {
        if (curr.length() == s.length()) {
            System.out.println(curr);
        } else {
            System.out.println(curr);
        }
        for(int i=index;i<s.length();i++) {
            curr += s.charAt(i);
            stringDFS(s, curr, i+1);
            if (curr.length() > 0) {
                curr = curr.substring(0, curr.length()-1);
            }
            else 
                curr = "";
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        ConcatenatedWords obj = new ConcatenatedWords(); //catsdogcats
        String dictStr[] = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat","do","g"};
        for(int i=0;i<dictStr.length;i++) {
            obj.dict.add(dictStr[i]);
        }

        obj.getConcatenatedWords("dogcatsdog", 0, "", "");
        System.out.println("Numbers of breaks is " + obj.maxBreaks);
//        obj.stringDFS("monil", "", 0);
    }

}
