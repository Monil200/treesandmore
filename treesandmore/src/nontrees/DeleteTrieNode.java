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
public class DeleteTrieNode {
    TrieNode root;
    
    public DeleteTrieNode() {
        root = new TrieNode();
    }
    
    public void insert(String s) {
        char t;
        TrieNode temp = null;
        HashMap<Character, TrieNode> children = root.children;
        
        for(int i=0;i<s.length();i++) {
            t = s.charAt(i);
            if (children.containsKey(t)) {
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
        
        if (temp.isLeaf)
            return temp;
        return null;
    }
    
    public void delete(String s, TrieNode root, int i) {
        if (root.children == null || root.children.size() == 0 || i >= s.length()) {
            return;
        }
        
        if (root.children.containsKey(s.charAt(i))) {
            delete(s, root.children.get(s.charAt(i)), i+1);
        }
        root.children.remove(s.charAt(i));
        
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DeleteTrieNode obj = new DeleteTrieNode();
        obj.insert("monil");
        obj.insert("parikh");
        
        if (obj.search("monil") != null)
            System.out.println("Key found.");
        else {
            System.out.println("Key NOT found");
        }
        
        obj.delete("parikh", obj.root, 0);
        
        if (obj.search("parikh") != null)
            System.out.println("Key found.");
        else {
            System.out.println("Key NOT found");
        }
    }

}
