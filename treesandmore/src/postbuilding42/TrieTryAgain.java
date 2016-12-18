package postbuilding42;
import java.util.*;

class TrieNode {
    boolean isLeaf;
    char c;
    HashMap<Character, TrieNode> children = new HashMap<Character,TrieNode>();
    public TrieNode() {};
    public TrieNode(char t) {
        c = t;
        isLeaf = false;
    }
}
public class TrieTryAgain {
    TrieNode root;
    public TrieTryAgain() {
        if (root == null) {
            root = new TrieNode();
        }
    }
    public void insert(String s) {
        if (s== null || s.length() == 0) {
            return;
        }
        char t;
        HashMap<Character, TrieNode> children = root.children;
        TrieNode node = null;
        for(int i=0;i<s.length();i++) {
            t = s.charAt(i);
            if (children.containsKey(t)) {
                node = children.get(t);
                children = node.children;
            } else {
                children.put(t, new TrieNode(t));
                node = children.get(t);
                children = node.children;
            }
        }
        node.isLeaf = true;
        
    }
    
    public TrieNode searchString(String s) {
        if (s== null || s.length() == 0) {
            return null;
        }
        char t;
        HashMap<Character, TrieNode> children = root.children;
        TrieNode node = null;
        for(int i=0;i<s.length();i++) {
            t = s.charAt(i);
            if (children.containsKey(t)) {
                node = children.get(t);
                children = children.get(t).children;
            } else {
                return null;
            }
        }
        if (node.isLeaf) {
            return node;
        } else {
            return null;
        }
    }
    
    public TrieNode searchPrefix(String s) {
        if (s== null || s.length() == 0) {
            return null;
        }
        char t;
        HashMap<Character, TrieNode> children = root.children;
        TrieNode node = null;
        for(int i=0;i<s.length();i++) {
            t = s.charAt(i);
            if (children.containsKey(t)) {
                node = children.get(t);
                children = children.get(t).children;
            } else {
                return null;
            }
        }
        return node;
    }
    
    public void search(String s) {
        if (s== null || s.length() == 0) {
            return;
        } else {
            TrieNode result = searchString(s);
            if (result != null) {
                System.out.println("String found");
            } else {
                System.out.println("String not found.");
            }
        }
    }
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TrieTryAgain obj = new TrieTryAgain();
//        obj.root = new TrieNode();
        obj.insert("google");
        obj.insert("facebook");
        obj.insert("uber");
        obj.insert("ubereats");
        obj.insert("thefacebook");
        obj.search("facebook");
    }

}
