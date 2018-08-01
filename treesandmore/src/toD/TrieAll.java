package toD;
import java.util.*;

class TNode {
    
    HashMap<Character, TNode> children = new HashMap<Character, TNode>();
    boolean isLeaf;
    TNode() {}
}
public class TrieAll {
    TNode root;
    TrieAll() {
        root = new TNode();
    }
    
    public void insert(String s) {
        if (s.length() == 0 || s == null)
            return;
        
        HashMap<Character, TNode> children = root.children;
        TNode current = root;
        for(int i=0;i<s.length();i++) {
            char t = s.charAt(i);
            if (children.containsKey(t)) {
                current = children.get(t);
                children = current.children;
            } else {
                TNode newNode = new TNode();
                current.children.put(t, newNode);
                current = newNode;
                children = current.children;
            }
        }
        current.isLeaf = true;
    }
    
    public void search(String s) {
        if (s.length() == 0 || s == null)
            return;
        
        HashMap<Character, TNode> children = root.children;
        TNode current = root;
        for(int i=0;i<s.length();i++) {
            char t = s.charAt(i);
            if (children.containsKey(t)) {
                current = children.get(t);
                children = current.children;
            } else {
                if (current != null) {
                    System.out.println("Partial match found");
                    return;
                }
            }
        }
        if (current.isLeaf) {
            System.out.println("Full match found");
        }
    }
    
    public TNode getPrefixNode(String s) {
        if (s.length() == 0 || s == null)
            return null;
        
        HashMap<Character, TNode> children = root.children;
        TNode current = root;
        for(int i=0;i<s.length();i++) {
            char t = s.charAt(i);
            if (children.containsKey(t)) {
                current = children.get(t);
                children = current.children;
            } else {
                if (current != null) {
                    System.out.println("Partial match found");
                    return current;
                }
            }
        }
        return current;
    }
    
    
    public void assist(TNode node, String current) {
        if (node.isLeaf) {
            System.out.println(current);
        }
        
        Set<Map.Entry<Character, TNode>> set = node.children.entrySet();
        for(Map.Entry<Character, TNode> i : set) {
            current += i.getKey();
            assist(i.getValue(), current);
            current = current.substring(0, current.length()-1);
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TrieAll obj = new TrieAll();
        obj.insert("homework");
        obj.insert("home");
        obj.insert("homebody");
        obj.insert("homebots");
        obj.insert("homeless");
        obj.search("home1");
        obj.search("homeless");
//        
        TNode prefix = obj.getPrefixNode("home");
        if (prefix != null)
            obj.assist(prefix, "home");
        else {
            System.out.println("Null prefix received");
        }
        
    }

}
