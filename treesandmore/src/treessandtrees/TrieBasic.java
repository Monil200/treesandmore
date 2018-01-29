package treessandtrees;
import java.util.*;
class Trie {
    boolean isLeaf;
    HashMap<Character, Trie> children = new HashMap<Character, Trie>();
    char t;
    Trie() {}
    Trie(char temp) {
        t = temp;
    }
}
public class TrieBasic {
    Trie root;
    TrieBasic() {
        root = new Trie();
    }
    
    public void insert(String s) {
        
        char t;
        HashMap<Character, Trie> children = root.children;
        Trie node = null;
        
        for(int i=0;i<s.length();i++) {
            t = s.charAt(i);
            if (children.containsKey(t)) {
                node = children.get(t);
                children = node.children;
            } else {
                node = new Trie(t);
                children.put(t, node);
                children = node.children;
            }
        }
        
        node.isLeaf = true;
    }
    
    public Trie search(String s) {
        char t;
        HashMap<Character, Trie> children = root.children;
        Trie node = null;
        
        for(int i=0;i<s.length();i++) {
            t = s.charAt(i);
            if (children.containsKey(t)) {
                node = children.get(t);
                children = node.children;
            } else {
                System.out.println("Not found");
                return null;
            }
        }
        
        if (node.isLeaf) {
            System.out.println("Full match");
        } else {
            System.out.println("partial match");
        }
        return node;
    }
    
    public void assist(String s, Trie parent) {
        if (parent == null)
            return;
        if (parent.isLeaf) {
            System.out.println(s);
        }
        if (parent.children.size() == 0)
            return;
        
        HashMap<Character, Trie> children = parent.children;
        Set<Map.Entry<Character, Trie>> set = children.entrySet();
        for(Map.Entry<Character, Trie> i : set) {
            String sCopy = s;
            s += i.getKey() + "";
            assist(s, i.getValue());
            s = sCopy;
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
        obj.search("homeless");
        
        String s = "ho";
        Trie baseTrieOfAssistString = obj.search(s);
        if (baseTrieOfAssistString != null) {
            System.out.println(baseTrieOfAssistString.t + "--" + baseTrieOfAssistString.isLeaf);
            obj.assist(s, baseTrieOfAssistString);
        }
    }

}
