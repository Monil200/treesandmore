package treessandtrees;
import java.util.*;
class TrieNode {
    boolean isLeaf;
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    char c;
    TrieNode() {}
    TrieNode(char t) {
        c = t;
    }
}
public class ReplaceWordsWithSuccessor {
    TrieNode root;
    ReplaceWordsWithSuccessor() {
        root = new TrieNode();
    }
    public void insert(String s) {
        if (s== null || s.length() == 0) {
            return;
        }
        HashMap<Character, TrieNode> children = root.children;
        TrieNode newNode = null;
        for(int i=0;i<s.length();i++) {
            char t = s.charAt(i);
            if (!children.containsKey(t)) {
                newNode = new TrieNode(t);
                children.put(t, newNode);
                children = newNode.children;
            } else {
                newNode = children.get(t);
                children = children.get(t).children;
            }
        }
        if (newNode!= null)
            newNode.isLeaf = true;
    }
    
    public TrieNode search(String s) {
        if (s== null || s.length() == 0) {
            return null;
        }
        HashMap<Character, TrieNode> children = root.children;
        TrieNode node = null;
        for(int i=0;i<s.length();i++) {
            char t = s.charAt(i);
            if (!children.containsKey(t)) {
                return null;
            } else {
                node = children.get(t);
                children = node.children; 
            }
        }
        return node;
    }
    
    public void replaceWords(String s) {
        if (s == null || s.length() == 0)
            return;
        String breaks[] = s.split(" ");
        TrieNode temp = null;
        String t = "";
        for(int i=0;i<breaks.length;i++) {
            t = "";
            for(int j=0;j<breaks[i].length();j++) {
                t += breaks[i].charAt(j);
                temp = search(t);
                if (temp == null) {
                    break;
                } else {
                    if (temp.isLeaf) {
                        breaks[i] = t;
                        break;
                    } else {
                        continue;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(breaks));
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ReplaceWordsWithSuccessor obj = new ReplaceWordsWithSuccessor();
        obj.insert("cat");
        obj.insert("bat");
        obj.insert("rat");
//        TrieNode temp = obj.search("moniq");
//        if (temp!=null) {
//            if (temp.isLeaf) {
//                System.out.println("Full string found in trie");
//            } else {
//                System.out.println("Intermediate string found");
//            }
//        } else {
//            System.out.println("String not in trie");
//        }
        
        String sentence = "the cattle was rattled by the battery.";
        obj.replaceWords(sentence);
    }

}
