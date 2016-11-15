package nontrees;
import java.util.*;

//class TrieNode {
//    boolean isLeaf;
//    char c;
//    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
//    
//    public TrieNode(){
//        
//    }
//    public TrieNode(char c){
//        this.c = c;
//    }
//}
public class TrieSearchAssist {
    TrieNode root;
    
    public TrieSearchAssist() {
        root = new TrieNode();
    }
    
    public void insert(String s) {
        char t;
        TrieNode temp = null;
        HashMap<Character, TrieNode> children = root.children;
        
        for(int i=0;i<s.length();i++) {
            t = s.charAt(i);
            if (children.containsKey(t)) {
                temp = children.get(t);
                children = children.get(t).children;
            } else {
                temp = new TrieNode(t);
                children.put(t, temp);
                children = children.get(t).children;
            }
        }
        temp.isLeaf = true;
    }
    
    public TrieNode search(String s) {
        char t;
        TrieNode temp = null;
        HashMap<Character, TrieNode> children = root.children;
        
        for(int i=0;i<s.length();i++) {
            t= s.charAt(i);
            if (children.containsKey(t)) {
                temp = children.get(t);
                children = children.get(t).children;
            } else {
                return null;
            }
        }
        
        return temp;
    }
    
    public void traverseTrie(TrieNode root, String output) { // like search Assist
        if (root.isLeaf) {
            System.out.println(output);
        }
        if (root.children == null || root.children.size() == 0) {
            return;
        }
        Set<Map.Entry<Character, TrieNode>> set = root.children.entrySet();
        for(Map.Entry<Character, TrieNode> i : set) {
            output += i.getKey() + "";
            TrieNode temp = i.getValue();
            traverseTrie(temp, output);
            output = output.substring(0, output.length() -1); // backtrack
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TrieSearchAssist obj = new TrieSearchAssist();
        obj.insert("mad");
        obj.insert("man");
        obj.insert("homework");
        obj.insert("homemade");
        obj.insert("home");
        obj.insert("homesick");
        
        if (obj.search("man").isLeaf)
            System.out.println("Key found.");
        else {
            System.out.println("Key NOT found");
        }
        
//        obj.traverseTrie(obj.root,"");
        
        if (obj.search("home") != null) // this prefix is available in trie
            obj.traverseTrie(obj.search("home"), "home");
        
        
    }

}

