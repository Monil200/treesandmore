package post16;
import java.util.*;
class TrieNode {
    boolean isLeaf;
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    char c;
    TrieNode() {}
    TrieNode(char ch) {
        c = ch;
    }
    
}
public class TrieBasics {
    TrieNode root;
    TrieBasics() {
        root = new TrieNode();
    }
    public void insert(String s) {
        if (s == null || s.length() == 0) {
            return;
        }
        char t;
        HashMap<Character, TrieNode> children = root.children;
        TrieNode node = null;
        for(int i=0;i<s.length();i++) {
            t = s.charAt(i);
            if (!children.containsKey(t)) {
                node = new TrieNode(); 
                children.put(t, node);
                children = node.children;
            } else {
                node = children.get(t);
                children = node.children;
            }
        }
        
        node.isLeaf = true; 
    }
    
    public boolean search(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        char t;
        HashMap<Character, TrieNode> children = root.children;
        TrieNode node = null;
        for(int i=0;i<s.length();i++) {
            t = s.charAt(i);
            if (!children.containsKey(t)) {
                return false;
            } else {
                node = children.get(t);
                children = node.children;
            }
        }
        return true;
    }
    
    public TrieNode searchPrefix(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        char t;
        HashMap<Character, TrieNode> children = root.children;
        TrieNode node = null;
        for(int i=0;i<s.length();i++) {
            t = s.charAt(i);
            if (!children.containsKey(t)) {
                return null;
            } else {
                node = children.get(t);
                children = node.children;
            }
        }
        if (node.isLeaf)
            return null;
         return node;
    }
    
    public void searchAssistUtil(String s) { // s is prefix
        if (s == null || s.length() == 0) {
            return;
        }
        TrieNode prefixNode = searchPrefix(s);
        if (prefixNode != null) {
            searchAssistUtil(prefixNode, s);
        }
    }
    
    /*
     *        h
     *        o
     *        m
     *        e
     *      m   w
     *      a   o
     *      d   r
     *      e   k
     *      
     */
    public void searchAssistUtil(TrieNode node, String s) {
        if (node.isLeaf) {
            System.out.println(s);
        } else {
            Set<Map.Entry<Character, TrieNode>> set = node.children.entrySet();
            for(Map.Entry<Character, TrieNode> i : set) {
                s += i.getKey() + "";
                searchAssistUtil(i.getValue(), s);
                s = s.substring(0, s.length()-1);
            }
        }
    }
    
    
    
    
    
    public static void main(String[] args) {
        TrieBasics obj = new TrieBasics();
        obj.insert("homework");
        obj.insert("homemade");
        
        System.out.println("Key Found ? " + obj.search("homework"));
        
        obj.searchAssistUtil("home");
        
    }
    
}
