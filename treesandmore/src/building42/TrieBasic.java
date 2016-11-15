package building42;
import java.util.*;
class TrieNode {
    char c;
    HashMap<Character, TrieNode> children = new HashMap<Character,TrieNode>();
    boolean isLeaf;
    public TrieNode() {
    }
    public TrieNode(char c) {
        this.c = c;
    }
}
public class TrieBasic {
    TrieNode root;
    public TrieBasic() {
        if (root == null) {
            root = new TrieNode();
        }
    }
    public void insert(String s) {
        if (s == null || s.length() == 0) {
            return;
        }
        char t;
        HashMap<Character,TrieNode> children = root.children;
        TrieNode temp = null;
        for(int i=0;i<s.length();i++) {
            t= s.charAt(i);
            if (children.containsKey(t)) {
                children = children.get(t).children;
            } else {
                children.put(t, new TrieNode(t));
                temp = children.get(t);
                children = temp.children;
            }
        }
        temp.isLeaf = true;
    }
    
    public TrieNode search(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        char t;
        HashMap<Character,TrieNode> children = root.children;
        TrieNode temp = null;
        for(int i=0;i<s.length();i++) {
            t = s.charAt(i);
            if (children.containsKey(t)) {
                temp = children.get(t);
                children = temp.children;
            } else {
                return null;
            }
        }
        if (temp.isLeaf)
            return temp;
        return null;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TrieBasic obj = new TrieBasic();
        obj.insert("monil");
        TrieNode result = obj.search("monil");
        if (result != null) {
            System.out.println("String found");
        } else {
            System.out.println("String NOT found");
        }
    }

}
