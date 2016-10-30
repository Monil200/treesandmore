package nontrees;
import java.util.*;
//https://community.topcoder.com/stat?c=problem_statement&pm=8019&rd=10773
// .. only search part of it 

//class TrieNode {
//    boolean isLeaf;
//    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>(); 
//    char c;
//    public TrieNode() {};
//    public TrieNode(char c) {
//        this.c = c;
//    }
//}
public class TrieSearchBox {
    
    public static TrieNode root;
    public TrieSearchBox() {
        root = new TrieNode();
    }
    public void insert(String s) {
        HashMap<Character, TrieNode> children = root.children;
        TrieNode temp = null;
        char t;
        for(int i=0;i<s.length();i++) {
            t = s.charAt(i);
            if (children.containsKey(t)) {
                temp = children.get(t);
                children = children.get(t).children;
            } else {
                temp = new TrieNode(t);
                children.put(t, temp);
                children = temp.children;
            }
        }
        temp.isLeaf = true;
    }
    
    public void search(String s) {
        if (s.length() == 0) {
            System.out.println("Please enter a search string");
        } else {
            TrieNode result = searchWord(s);
            if (result != null && result.isLeaf) {
                System.out.println("String found");
            } else {
                System.out.println("String NOT found");
            }
        }
    }
    
    public TrieNode searchWord(String s) {
        if (s.length() == 0) {
            return null;
        } else {
            HashMap<Character, TrieNode> children = root.children;
            char t;
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
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TrieSearchBox obj = new TrieSearchBox();
        String s = "I am a boy";
        String[] words = s.split(" ");
        for(int i=0;i<words.length;i++) {
            obj.insert(words[i]);
        }
        obj.search("am");
    }

}
