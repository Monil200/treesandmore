package treessandtrees;
import java.util.*;
/*
 * 
 * Given a dictionary ["Cat", "Mat", "Ca", 
     "tM", "at", "C", "Dog", "og", "Do"]

Input :  Pattern "CatMat"
Output : 1 
Explanation: we can break the sentences
in three ways, as follows:
CatMat = [ Cat Mat ]  break 1
CatMat = [ Ca tM at ] break 2
CatMat = [ C at Mat ] break 2  so the 
         output is :1
 */
public class MinimumBreakWords {
    public Trie root;
    int breaks = Integer.MAX_VALUE;
    MinimumBreakWords() {
        root = new Trie();
    }
    public void insert(String s) {
        if (s== null | s.length() == 0)
            return;
        HashMap<Character, Trie> children = root.children;
        Trie current = root;
        for(int i=0;i<s.length();i++) {
            char t = s.charAt(i);
            if(children.containsKey(t)) {
                current = children.get(t);
                children = current.children;
            } else {
                current = new Trie(t);
                children.put(t, current);
                children = current.children;
            }
        }
        current.isLeaf = true;
    }
    
    public boolean search(String s) {
        if (s== null | s.length() == 0)
            return false;
        HashMap<Character, Trie> children = root.children;
        Trie current = null;
        for(int i=0;i<s.length();i++) {
            char t = s.charAt(i);
            current = null;
            if(children.containsKey(t)) {
                current = children.get(t);
                children = current.children;
            } else {
                return false;
//                System.out.println("String " + s + " not found in trie");
//                break;
            }
        }
        if (current.isLeaf)
            return true;
        else {
            return false;
        }
    }
    
    public void minimumGap(String s, int indexAt, String part, int currentBreaks, boolean isOrig) {
        //CatMat
        System.out.println("Out : String - " + s + " | part =" + part);
        for(int i=0;i<s.length();i++) {
            if (isOrig)
                currentBreaks = 0;
            part += s.charAt(i) +"";
            System.out.println("\t In : String - " + s + " | part =" + part + " | breaksTillnow = " + currentBreaks);
            boolean inTrie = search(part);
            if (inTrie) {
                ++currentBreaks;
                System.out.println("| currentBreaks " + currentBreaks);
                if ((i+1) == s.length() && inTrie) {
                    if (breaks > currentBreaks) {
                        breaks = currentBreaks;
                    }
                    System.out.println("I am returning for String " + s);
                }
                minimumGap(s.substring(i+1, s.length()), 0, "", currentBreaks, false);
            }
        }
    }
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MinimumBreakWords obj = new MinimumBreakWords();
        obj.insert("Cat");
//        obj.insert("Mat");
        obj.insert("Ca");
        obj.insert("tM");
        obj.insert("at");
        obj.insert("C");
        obj.insert("Dog");
        obj.insert("og");
        obj.insert("Do");
//        obj.search("og"); CatMat
        obj.minimumGap("CatMat", 0, "", 0, true);
        System.out.println(obj.breaks + "---");
        
        
    }

}
