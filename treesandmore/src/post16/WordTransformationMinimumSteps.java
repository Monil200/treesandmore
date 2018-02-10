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

public class WordTransformationMinimumSteps {
  
      int minT = 0;
      ArrayList<Integer> countsReached = new ArrayList<Integer>();
      HashSet<String> visited = new HashSet<String>();
      
      public void minCount(String b, String e, ArrayList<String> list, int currT) {
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
      int minTransformations = Integer.MAX_VALUE;
      public void getMinTransformations(ArrayList<String> a, ArrayList<String> res, String target, String current, int transformations, boolean available[]) {
          if (target.equals(current)) {
             if (transformations <= minTransformations) {
                 minTransformations = transformations;
                 System.out.println("Min Transformations:" + res); // might not be min, will check later
             }
          }
          
          for(int i=0;i<a.size();i++) {
              if(!a.get(i).equals(current) && isDiffByOneChar(a.get(i), current) && available[i]) {
                  res.add(a.get(i));
                  transformations++;
                  available[i] = false;
                  getMinTransformations(a, res, target, a.get(i), transformations, available);
                  // backtrack
                  available[i] = true;
                  transformations--;
                  res.remove(res.size()-1);
              }
          }
      }
      
      public static boolean isDiffByOneChar(String a, String b) {
          int diff = 0;
          for(int i=0;i<a.length();i++) {
              if (a.charAt(i) != b.charAt(i)) {
                  diff++;
              }
          }
          if (diff > 1) {
              return false;
          }
          return true;
      }
  
  public static void main(String[] args) {
    WordTransformationMinimumSteps obj = new WordTransformationMinimumSteps();
    ArrayList<String> list = new ArrayList<String>();
    list.add("cog");
    list.add("dog");
    list.add("dot");
    list.add("log");
    list.add("lot");
    list.add("hot");

    obj.minCount("hit", "cog", list, 0);
    
    int min = Integer.MAX_VALUE;
    for(Integer i : obj.countsReached) {
        System.out.println(i);
        if (i < min) {
            min = i;
        }
    }
    
    System.out.println("min transfors are :" + min);
    
    // v2
    boolean available[] = new boolean[list.size()];
    for(int i=0;i<list.size();i++) {
        available[i] = true;
    }
    obj.getMinTransformations(list, new ArrayList<String>(), "cog", "hit", 0, available);
    
  }
}

