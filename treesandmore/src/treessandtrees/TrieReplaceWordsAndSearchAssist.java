package treessandtrees;
import java.util.*;
class TrieN {
    char t;
    boolean isLeaf;
    HashMap<Character,TrieN> children = new HashMap<Character, TrieN>();
    TrieN() {}
    TrieN(char c) {
        t = c;
    }
}
public class TrieReplaceWordsAndSearchAssist {
    TrieN root;
    TrieReplaceWordsAndSearchAssist() {
        root = new TrieN();
    }
    
    public void insert(String s) {
        if (s == null)
            return;
        HashMap<Character, TrieN> children = root.children;
        TrieN node = null;
        for(int i=0;i<s.length();i++) {
            char t = s.charAt(i);
            if (children.containsKey(t)) {
                node = children.get(t);
                children = node.children;
            } else {
                node = new TrieN(t);
                children.put(t, node);
                children = node.children;
            }
        }
        node.isLeaf = true;
    }
    
    public void search(String s) {
        if (s==null || s.length() == 0 || root == null)
            return;
        
        HashMap<Character, TrieN> children = root.children;
        TrieN node = null;
        for(int i=0;i<s.length();i++) {
            char t = s.charAt(i);
            if (children.containsKey(t)) {
                node = children.get(t);
                children = node.children;
            } else {
                System.out.println("No such string");
                break;
            }
        }
        if (node.isLeaf) {
            System.out.println("Yes string " + s + " found");
        } else {
            System.out.println("No such string found");
        }
    }
    
    public TrieN baseNode(String s) {
        if (s == null || s.length() ==0 || root == null) {
            return null;
        }
        
        HashMap<Character, TrieN> children = root.children;
        TrieN node = root;
        for(int i=0;i<s.length();i++) {
            char t  = s.charAt(i);
            if (children.containsKey(t)) {
                node = children.get(t);
                children = node.children;
            } else {
                break;
            }
        }
        
        if (node != null) {
            return node;
        } else {
            return null;
        }
        
    }
    
    
    public void searchAssist(TrieN base, String s) {
        if (base == null) {
            return;
        }
        if (base.isLeaf) {
            System.out.println(s);
        }
        if (base.children.size() == 0)
            return;
        Set<Map.Entry<Character, TrieN>> set = base.children.entrySet();
        for(Map.Entry<Character, TrieN> i : set) {
            s += i.getKey()+ "";
            searchAssist(i.getValue(), s);
            s = s.substring(0,  s.length()-1);
        }
    }
    
    public String partialTrie(String s) {
        if (s == null || s.length() ==0 || root == null) {
            return null;
        }
        
        HashMap<Character, TrieN> children = root.children;
        TrieN node = root;
        String partial = "";
        for(int i=0;i<s.length();i++) {
            char t  = s.charAt(i);
            if (children.containsKey(t)) {
                partial += t + "";
                node = children.get(t);
                children = node.children;
            } else {
                break;
            }
        }
        
        if (node != null && node.isLeaf) {
            return partial;
        }
        return null;
    }
    
    public void replaceWordsWithShorterWords(String s[]) {
        
        if (s.length == 0)
            return;
        String replace = null;
        for(int i=0;i<s.length;i++) {
            replace = partialTrie(s[i]);
            if (replace != null && replace.length() > 0)
                s[i] = replace;
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TrieReplaceWordsAndSearchAssist obj = new TrieReplaceWordsAndSearchAssist();
        obj.insert("home");
        obj.insert("homemade");
        obj.insert("homework");
        obj.search("home");
        
        TrieN pre = obj.baseNode("hom");
        if (pre != null)
            System.out.println("Base/partial node exists!!");
        else {
            System.out.println("No such base node");
        }
        
        // assist
        System.out.println("Search Assist...");
        obj.searchAssist(pre, "hom");
        
        // replace with shorter words.
        System.out.println("Sentence compaction.");
        obj.insert("cat");
        obj.insert("bat");
        obj.insert("rat");
        String sentence = "I am cattle batman I hate rattles";
        String sentenceArray[] = sentence.split(" ");
        System.out.println(Arrays.toString(sentenceArray));
        obj.replaceWordsWithShorterWords(sentenceArray);
        System.out.println(Arrays.toString(sentenceArray));
    }

}
