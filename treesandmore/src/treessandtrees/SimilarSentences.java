package treessandtrees;
import java.util.*;

public class SimilarSentences {
    public void areSentencesSimilar(String a[], String b[], String pairs[][]) {
//    public void areSentencesSimilar() {
        
        HashMap<String, ArrayList<String>> transitive = new HashMap<String, ArrayList<String>>();
        
        HashSet<String> cancel = new HashSet<String>();
        for(int i=0;i<a.length;i++) {
            cancel.add(a[i]);
        }
        for(int i=0;i<b.length;i++) {
            if (cancel.contains(b[i])) {
                cancel.remove(b[i]);
            } else {
                cancel.add(b[i]);
            }
        }
        System.out.println("In progress..:" + cancel.size());
        // now handle pairs
        for(int i=0;i<pairs.length;i++) {
            if (cancel.contains(pairs[i][0]) && cancel.contains(pairs[i][1])) { // straight forward case
                System.out.println("Removing:" + pairs[i][0] + " and " + pairs[i][1]);
                cancel.remove(pairs[i][0]);
                cancel.remove(pairs[i][1]);
                if (transitive.containsKey(pairs[i][0])) {
                    ArrayList<String> temp = transitive.get(pairs[i][0]);
                    for(int j=0;j<temp.size();j++) {
                        cancel.remove(temp.get(j));
                    }
                }
                if (transitive.containsKey(pairs[i][1])) {
                    ArrayList<String> temp = transitive.get(pairs[i][1]);
                    for(int j=0;j<temp.size();j++) {
                        cancel.remove(temp.get(j));
                    }
                }
            } else {
                // case 2.1
                if (cancel.contains(pairs[i][0]) && !cancel.contains(pairs[i][1])) {
                    System.out.println("Added to pool 1 " + pairs[i][1]);
                    cancel.add(pairs[i][1]);
                    ArrayList<String> temp = transitive.getOrDefault(pairs[i][1], new ArrayList<String>());
                    temp.add(pairs[i][0]);
                    transitive.put(pairs[i][1], temp);
                    System.out.println("Added to HM 1 " + pairs[i][0]);
                } else if (cancel.contains(pairs[i][1]) && !cancel.contains(pairs[i][0])) {
                    System.out.println("Added to pool 2" + pairs[i][0]);
                    cancel.add(pairs[i][0]);
                    ArrayList<String> temp = transitive.getOrDefault(pairs[i][0], new ArrayList<String>());
                    temp.add(pairs[i][1]);
                    transitive.put(pairs[i][0], temp);
                    System.out.println("Added to HM 2 " + pairs[i][1]);
                }
            }
        }
        
        
        
        if (cancel.size() == 0 || cancel == null)
            System.out.println("Sentences are similar");
        else {
            System.out.println("Sentences are NOT similar ...size:" + cancel.size() + " removing:");
        }
        
        
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SimilarSentences obj = new SimilarSentences();
        String a[] = {"great", "acting", "skills"};
        String b[] = {"fine", "drama", "talent"};
        String pairs[][] = {{"great", "good"}, {"fine", "good"}, {"acting","drama"}, {"skills","talent"}};
        obj.areSentencesSimilar(a,b,pairs);
    }

}
