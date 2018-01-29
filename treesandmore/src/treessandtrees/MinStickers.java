package treessandtrees;
import java.util.*;
public class MinStickers {
    int minCount;
    MinStickers() {
        minCount = Integer.MAX_VALUE; 
    }
    public HashMap<Character,Integer> getSetHashMap(String target) {
        if (target == null || target.length() == 0)
            return null;
        HashMap<Character,Integer> freq = new HashMap<Character,Integer>();
        for(int i=0;i<target.length();i++) {
            freq.put(target.charAt(i), freq.getOrDefault(target.charAt(i), 0) + 1);
        }
        return freq;
    }
    public void getMinStickers(String[] pool, String target, HashMap<Character, Integer> map, int depth, int count) {
        
        for(int i=0;i<pool.length;i++) {
            boolean isValidSticker = false;
            HashMap<Character, Integer> restoreMap = new HashMap<Character, Integer>();
            for(int j=0;j<pool[i].length();j++) {
                char t = pool[i].charAt(j);
                if (map.containsKey(t)) {
                    isValidSticker = true;
                    if (map.get(t) > 1) {
                        map.put(t, map.get(t) - 1);
                    } else {
                        map.remove(t);
                    }
                    restoreMap.put(t, restoreMap.getOrDefault(t, 0) + 1);
                }
            }
            
            System.out.println("depth:" + depth + " i:" + i + " Pool:" + pool[i] + " isValid:" + isValidSticker + " count:" + count + " mapSize:" + map.size());
            
            if (isValidSticker) {
                count++;
                if (map.size() == 0) {
                    if (minCount > count) {
                        minCount = count;
                    }
                }
                getMinStickers(pool, target, map, ++depth, count);
                // restore - whatever was changed in original map is restored;
                Set<Map.Entry<Character, Integer>> set = restoreMap.entrySet();
                for(Map.Entry<Character, Integer> s : set) {
                    if (map.containsKey(s.getKey())) {
                        map.put(s.getKey(), map.get(s.getKey()) + s.getValue());
                    } else {
                        map.put(s.getKey(), s.getValue());
                    }
                }
                depth--;
            }
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MinStickers obj = new MinStickers();
        String target = "thehat";
        String pool[] = {"with", "example", "science"};
        HashMap<Character,Integer> map = obj.getSetHashMap(target);
        obj.getMinStickers(pool, target, map,0,0);
        System.out.println(obj.minCount);
    }

}
