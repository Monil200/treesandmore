package nontrees;
import java.util.*;
    
    /*
     *                  root
                          |
                        HashMap
                          |
                        HashMap
                          |
                         ....
     */

class TrieNode {
    boolean isLeaf;
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    char c;
    public TrieNode() {}
    public TrieNode(char c) {
        this.c = c;
    }
}
public class Trie {
    public static TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String s) {
        TrieNode temp = null;
        HashMap<Character, TrieNode> children = root.children;
        char t;
        for(int i=0;i<s.length();i++) {
            t = s.charAt(i);
            if(children.containsKey(t)) {
                temp = children.get(t);// this assignment is needed as home maybe a new word and homework is existing word in dictionary.
                children = temp.children;
            } else {
                temp = new TrieNode(t);
                children.put(t, temp);
                children = temp.children;
            }
        }
        temp.isLeaf = true;
    }
    
    public boolean searchWord(String s) {
        if (s.length() == 0) {
            return false;
        } else{
            TrieNode isWordPresent = search(s);
            if (isWordPresent != null && isWordPresent.isLeaf) {
                return true;
            } else {
                return false;
            }
        }
    }
    
    public void searchPrefix(String s) {
        if (s.length() == 0) {
            return;
        } else{
            TrieNode prefixNode = search(s);
            if (prefixNode != null) {
                System.out.println("Prefix found");
            } else {
                System.out.println("No such prefix");
            }
        }
    }
    
    public TrieNode search(String s) {
        HashMap<Character, TrieNode> temp = root.children;
        char t;
        TrieNode node = null;
        for(int i=0;i<s.length();i++) {
            t = s.charAt(i);
            if (temp.containsKey(t)) {
                node = temp.get(t);
                temp = node.children;
            } else {
                return null;
            }
        }
        return node;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Trie obj = new Trie();
        obj.insert("home");
        obj.insert("homo");
        System.out.println(obj.searchWord("home"));
        obj.searchPrefix("hom");
    }

}
