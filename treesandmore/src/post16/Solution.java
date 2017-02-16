package post16;

/**
Given two words (beginWord and endWord), and a valid word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.

For example, given:
  beginWord = "hit"
  endWord = "cog"
  wordList = ["cog", "dog", "dot", "hot", "log", "lot"]
Return 5 (one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog")
Return -1;
*/



import java.io.*;
import java.util.*;

class Solution {
  
  int minT = 0;
  ArrayList<Integer> countsReached = new ArrayList<Integer>();
  HashSet<String> visited = new HashSet<String>();
  
  public void minCount(String b, String e, HashSet<String> list, int currT) {
    if (b.equals(e)) {
        System.out.println("We moved from start to end word");
        countsReached.add(currT);
    }
    char temp;
    String bCopy = b;
    for(int i=0;i<b.length();i++) {
        // function -> a & b 1 distance apart.
        for(int j=97;j<=122;j++) {
            temp = (char) j;
            char strarr[] = b.toCharArray();
            strarr[i] = temp;
            b = String.valueOf(strarr);
            System.out.println(temp + " -> " + b);
            if (list.contains(b) && !visited.contains(b)) {
                visited.add(b);
                currT++;
                minCount(b, e, list, currT);
            }
            b = bCopy;
        }
    }
    
  }
  
  public static void main(String[] args) {
    Solution obj = new Solution();
    HashSet<String> list = new HashSet<String>();
    list.add("cog");
    list.add("dog");
    list.add("dot");
    list.add("log");
    list.add("lot");
    list.add("hot");
        
    String b = "hit";
    obj.minCount("hit", "cog", list, 0);
    
    int min = Integer.MAX_VALUE;
    for(Integer i : obj.countsReached) {
        System.out.println(i);
        if (i < min) {
            min = i;
        }
    }
    
    System.out.println("min transfors are :" + min);
    
  }
}

