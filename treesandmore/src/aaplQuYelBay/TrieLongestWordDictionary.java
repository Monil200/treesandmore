package aaplQuYelBay;
import java.util.*;

class TrieNode {
    char t;
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    boolean isLeaf;
    TrieNode(char x) {
        t = x;
        isLeaf = false;
    }
    TrieNode() {
        
    }
;}

public class TrieLongestWordDictionary {
    TrieNode root;
    
    TrieLongestWordDictionary() {
        root = new TrieNode();
    }
    
    public void insert(String s) {
        if (s == null || s.length() == 0)
            return;
        
        HashMap<Character, TrieNode> children = root.children;
        TrieNode current = null;
        
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if (children.containsKey(c)) {
                current = children.get(c);
                children = current.children;
            } else {
                current = new TrieNode(c);
                children.put(c,current);
                children = current.children;
            }
        }
        
        if (current!= null) {
            current.isLeaf = true;
        }
    }
    
    public void search(String s) {
        if (s == null || s.length() == 0)
            return;
        HashMap<Character, TrieNode> children = root.children;
        TrieNode current = null;
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if (!children.containsKey(c)) {
                System.out.println("No such word in trie");
                return;
            } else {
                current = children.get(c);
                children = current.children;
            }
        }
        
        if (!current.isLeaf) {
            System.out.println("No such word in trie");
            return;
        } else {
            System.out.println("Word found in trie");
        }
    }
    
    public TrieNode searchPrefix(String s) {
        if (s == null || s.length() == 0)
            return null;
        HashMap<Character, TrieNode> children = root.children;
        TrieNode current = null;
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if (!children.containsKey(c)) {
                System.out.println("No such word in trie");
                return null;
            } else {
                current = children.get(c);
                children = current.children;
            }
        }
        
        if (current.isLeaf) {
            System.out.println("No such prefix in trie, its a full word");
            return null;
        } else {
            return current;
        }
    }
    
    public void autoComplete(TrieNode root, String s) {
        if (root == null) {
            return;
        }
        if (root.isLeaf) {
            System.out.println(s);
        }
        Set<Map.Entry<Character, TrieNode>> set = root.children.entrySet();
        for(Map.Entry<Character, TrieNode> i : set) {
            s += i.getKey();
            autoComplete(i.getValue(), s);
        }
    }
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TrieLongestWordDictionary obj = new TrieLongestWordDictionary();
        obj.insert("homework");
        obj.insert("homemaker");
        obj.search("home");
        
        TrieNode prefix = obj.searchPrefix("hom");
        if (prefix != null) {
            obj.autoComplete(prefix, "hom");
        }
    }

}
