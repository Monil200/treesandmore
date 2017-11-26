package aaplQuYelBay;
import java.util.*;
class TrieNode {
    
    char c;
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    boolean isLeaf;
    TrieNode() {}
    TrieNode(char ch) {
        c = ch;
    }
}

public class TrieLongestWordDictionary {
    TrieNode root;
    TrieLongestWordDictionary() {
        root = new TrieNode();
    }
    
    public void insert(String s) {
        if (s.length() == 0 || s == null) {
            return;
        }
        char temp;
        HashMap<Character, TrieNode> children = root.children;
        TrieNode node= null;
        for(int i=0;i<s.length();i++) {
            temp = s.charAt(i);
            if (!children.containsKey(temp)) {
                children.put(temp, new TrieNode(temp));
                node = children.get(temp);
                children = node.children;
            } else {
                node = children.get(temp);
                children = node.children;
            }
        }
        node.isLeaf = true;
        
    }
    
    public boolean searchString(String s) {
        if (s.length() == 0 || s == null) {
            return false;
        }
        char temp;
        HashMap<Character, TrieNode> children = root.children;
        TrieNode node= null;
        for(int i=0;i<s.length();i++) {
            temp = s.charAt(i);
            if (!children.containsKey(temp)) {
                return false;
            } else {
                node = children.get(temp);
                children = node.children;
            }
         }
        
        if (node.isLeaf)
            return true;
        return false;
    }
    
    void DFSReadTrie(String s, TrieNode root) {
        if (root.isLeaf) {
            System.out.println(s);
        }
        if (root.children == null || root.children.size() == 0)
            return;
        HashMap<Character, TrieNode> children = root.children;
        TrieNode node = null;
        Set<Map.Entry<Character, TrieNode>> list = children.entrySet();
        for(Map.Entry<Character, TrieNode> i : list) {
            s += i.getKey() + "";
            node = i.getValue();
            DFSReadTrie(s,node);
            s = s.substring(0, s.length()-1);
        }
        
        
    }
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TrieLongestWordDictionary obj = new TrieLongestWordDictionary();
        obj.insert("home");
        obj.insert("homework");
        System.out.println(obj.searchString("home"));
        System.out.println(obj.searchString("homework"));
        obj.DFSReadTrie("", obj.root);
    }

}
