package treesandmore;

import java.util.*;

//class TrieNode{
//    char c;
//    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
//    boolean isLeaf;
//    public TrieNode() {
//        
//    }
//    public TrieNode(char c) {
//        this.c = c;
//    }
//}

public class BoggleWordSearch {
    public static TrieNode root;
    
    
    
    HashSet<String> result = new HashSet<String>();
    
    public void searchBoggle() {
        char[][] board = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
                };
        int[][] visited = new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                searchBoggleUtility(board,visited,i,j ,"");
            }
        }
        
        for(String s: result) {
            System.out.println(s);
        }
        System.out.println(result.size());
    }
    
    public void searchBoggleUtility(char[][] board, int[][] visited, int i,int j, String str) {
           if (i<0 || j>=board[0].length || i>=board.length || j<0) {
               return;
           }
           if (visited[i][j] == 1) {
               return;
           }
           str += board[i][j];
           if (!searchPrefix(str)) {
               return;
           }
           if (searchWord(str)) {
               result.add(str);
           }
           visited[i][j] = 1;
           searchBoggleUtility(board, visited, i+1, j, str);
           searchBoggleUtility(board, visited, i, j+1, str);
           searchBoggleUtility(board, visited, i-1, j, str);
           searchBoggleUtility(board, visited, i, j-1, str);
           
           // diagonals
           searchBoggleUtility(board, visited, i+1, j+1, str);
           searchBoggleUtility(board, visited, i+1, j-1, str);
           searchBoggleUtility(board, visited, i-1, j+1, str);
           searchBoggleUtility(board, visited, i-1, j-1, str);
           visited[i][j] = 0;
    }
    
    
    
    public BoggleWordSearch() {
        root = new TrieNode();
    }
    
    public void insert(String s) {
        if (s.length() == 0) {
            return;
        } else {
            char c;
            HashMap<Character, TrieNode> children = root.children;
            TrieNode node = null;
            for(int i=0;i<s.length();i++) {
                c = s.charAt(i);
                if(children.containsKey(c)) {
                    children = children.get(c).children;
                    node = children.get(c);
                } else {
                    node = new TrieNode(c);
                    children.put(c, node);
                    children = node.children;
                }
            }
            node.isLeaf = true;
        }
    }
    
    public boolean searchWord(String s) { // search word or prefix pattern
        if (s.length() == 0) {
            return false;
        } else {
            TrieNode result = searchUtility(s);
            if (result != null && result.isLeaf) {
                return true;
            }
        }
        return false;
    }
    
    public boolean searchPrefix(String s) { // search word or prefix pattern
        if (s.length() == 0) {
            return false;
        } else {
            TrieNode result = searchUtility(s);
            if (result != null) {
                return true;
            }
        }
        return false;
    }
    
    public TrieNode searchUtility(String s) {
        if (s.length() == 0) {
            return null;
        } else {
            HashMap<Character, TrieNode> children = root.children;
            char c;
            TrieNode node = null;
            for(int i=0;i<s.length();i++) {
                c = s.charAt(i);
                if (children.containsKey(c)) {
                    node = children.get(c);
                    children = node.children;
                } else {
                    return null; // no word/prefix;
                }
            }
            return node;
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BoggleWordSearch obj = new BoggleWordSearch();
        obj.insert("oath");
        obj.insert("pea");
        obj.insert("eat");
        obj.insert("rain");
        obj.insert("otaan");
        System.out.println("Do we have this Prefix in Trie structure ? :" + obj.searchPrefix("te"));
        obj.searchBoggle();
    }

}
