package treessandtrees;
import java.util.*;
class Trie {
    boolean isLeaf;
    char c;
    HashMap<Character, Trie> children = new HashMap<Character, Trie>();
    Trie() {}
    Trie(char t) {
        c = t;
        isLeaf = false;
    }
}
public class TrieBasic {
    Trie root;
    TrieBasic() {
        root = new Trie();
    }
    public void insert(String s) {
        if (s == null || s.length() == 0) {
            return;
        }
        Trie current = null;
        HashMap<Character, Trie> children = root.children;
        for(int i=0;i<s.length();i++) {
            char t = s.charAt(i);
            if (children.containsKey(t)) {
                current = children.get(t);
                children = current.children;
            } else {
                current = new Trie(t);
                children.put(t, current);
                children = current.children;
            }
        }
        if (current != null)
            current.isLeaf = true;
        
    }
    
    public void search(String s) {
        if (s == null || s.length() == 0) {
            return;
        }
        Trie current = root;
        for(int i=0;i<s.length();i++) {
            char t = s.charAt(i);
            HashMap<Character, Trie> children = current.children;
            if (children.containsKey(t)) {
                current = children.get(t);
            } else {
                System.out.println("String " + s + " not found!!");
                break;
            }
        }
        if (current.isLeaf)
            System.out.println("String " + s + " found successfully");
        else {
            System.out.println("String " + s + " not found");
        }
    }
    
    public Trie searchAssistBase(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        Trie current = root;
        HashMap<Character, Trie> children = root.children;
        for(int i=0;i<s.length();i++) {
            char t = s.charAt(i);
            if (children.containsKey(t)) {
                current = children.get(t);
                children = current.children;
            } else {
               System.out.println("Base not found, returning null");
               return current;
            }
        }
        return current;
    }
    
    public void searchAssist(Trie node, String s) {
        if (node == null) {
            return;
        }
        if (node.isLeaf) {
            System.out.println(s);
        }
        if (node.children.size() == 0)
            return;
        HashMap<Character, Trie> children = node.children;
        Set<Map.Entry<Character, Trie>> iterator = children.entrySet();
        for(Map.Entry<Character, Trie> i : iterator) {
            s += i.getKey();
            Trie temp = i.getValue();
            searchAssist(temp,s);
            s = s.substring(0, s.length()-1);
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TrieBasic obj = new TrieBasic();
        obj.insert("homework");
        obj.insert("home");
        obj.insert("homebody");
        obj.insert("homebots");
        obj.insert("homeless");
        obj.search("home");
        
        String s = "ho";
        Trie baseTrieOfAssistString = obj.searchAssistBase(s);
        if (baseTrieOfAssistString != null) {
            System.out.println(baseTrieOfAssistString.c + "--" + baseTrieOfAssistString.isLeaf);
            obj.searchAssist(baseTrieOfAssistString,s);
        }
    }

}
