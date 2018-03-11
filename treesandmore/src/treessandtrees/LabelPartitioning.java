package treessandtrees;
import java.util.*;
public class LabelPartitioning {
    
    public void partitionLabels(String s) {
        if (s == null || s.length() == 0) {
            return;
        }
        
        HashMap<Character, ArrayList<Integer>> map = new HashMap<Character, ArrayList<Integer>>();
        
        for(int i=0;i<s.length();i++) {
            if (map.containsKey(s.charAt(i))) {
                ArrayList<Integer> temp = map.get(s.charAt(i));
                if (temp.size() > 1)
                    temp.remove(1);
                temp.add(1, i);
                map.put(s.charAt(i), temp);
            } else {
                map.put(s.charAt(i), new ArrayList<Integer>(Arrays.asList(i)));
            }
        }
        
        Set<Map.Entry<Character, ArrayList<Integer>>> set = map.entrySet();
        
        for(Map.Entry<Character, ArrayList<Integer>> i : set) {
            System.out.println("key: " + i.getKey() + " value:" + Arrays.toString(i.getValue().toArray()));
        }
        
        ArrayList<Integer> mergedList[] = new ArrayList[s.length()];
        
        mergedList[0] = map.get(s.charAt(0));
        int currentIndex = 0;
        
        for(int i=1;i<s.length();i++) {
            if (map.containsKey(s.charAt(i))) {
                ArrayList<Integer> temp = map.get(s.charAt(i));
                if (temp.get(0) < mergedList[currentIndex].get(mergedList[currentIndex].size()-1)) {
                    if (temp.get(temp.size()-1) > mergedList[currentIndex].get(mergedList[currentIndex].size()-1)) {
                        mergedList[currentIndex].remove(mergedList[currentIndex].size()-1);
                        mergedList[currentIndex].add(temp.get(temp.size()-1));
                    }
                } else {
                    currentIndex++;
                    mergedList[currentIndex] = map.get(s.charAt(i));
                }
                map.remove(s.charAt(i));
            }
        }
        
        for(int i=0;i<mergedList.length;i++) {
            if (mergedList[i] != null) {
                System.out.println(Arrays.toString(mergedList[i].toArray()));
            }
        }
        
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LabelPartitioning obj = new LabelPartitioning();
        obj.partitionLabels("ababcbacadefegdehijhklij");
    }

}
