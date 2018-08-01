package toD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class T9andMore {
    HashMap<Integer, ArrayList<Character>> map;
    static HashMap<Integer, ArrayList<String>> urls;
    T9andMore() {
        map = new HashMap<Integer, ArrayList<Character>>();
        map.put(2, new ArrayList(Arrays.asList('a', 'b', 'c')));
        map.put(3, new ArrayList(Arrays.asList('d', 'e', 'f')));
        map.put(4, new ArrayList(Arrays.asList('g', 'h', 'i')));
        map.put(5, new ArrayList(Arrays.asList('j', 'k', 'l')));
        map.put(6, new ArrayList(Arrays.asList('m', 'n', 'o')));
        map.put(7, new ArrayList(Arrays.asList('p', 'q', 'r', 's')));
        map.put(8, new ArrayList(Arrays.asList('t', 'u', 'v')));
        map.put(9, new ArrayList(Arrays.asList('w', 'x', 'y', 'z')));
        
        // urls
        urls = new HashMap<Integer, ArrayList<String>>();
        urls.put(0, new ArrayList(Arrays.asList("http", "https")));
        urls.put(1, new ArrayList(Arrays.asList("facebook", "yahoo", "amazon")));
        urls.put(2, new ArrayList(Arrays.asList("in", "com", "co.in")));
    }
    
    public void getT9(int keyStrokes[], int index, ArrayList<Character> res) {
        if (res.size() == keyStrokes.length) {
            System.out.println(res);
        }
        if (index >= keyStrokes.length) return;
        for(int i=0;i<map.get(keyStrokes[index]).size();i++) {
            res.add(map.get(keyStrokes[index]).get(i));
            getT9(keyStrokes, index+1, new ArrayList<Character>(res));
            res.remove(res.size()-1);
        }
    }
    
    public void urlPrinting(int index, ArrayList<String> res) {
        if (res.size() == urls.size()) {
            System.out.println(res);
        }
        if (index >= urls.size()) return;
        
        for(int i=0;i<urls.get(index).size();i++) {
            res.add(urls.get(index).get(i));
            urlPrinting(index+1, new ArrayList<String>(res));
            res.remove(res.size()-1);
        }
    }
    
    public void getCombinationSumNoRepeat(int a[], int index, int target, int currTarget, ArrayList<Integer> res) {
        if (target == currTarget) {
            System.out.println(res);
        }
        if (index >= a.length) return;
        
        for(int i=index;i<a.length;i++) {
            if ((currTarget + a[i]) <= target) {
                res.add(a[i]);
                currTarget += a[i];
                getCombinationSumNoRepeat(a, index+1, target, currTarget, res);
                currTarget -= a[i];
                res.remove(res.size()-1);
            }
        }
    }
    
    public void allSubsets(int a[], int index, ArrayList<Integer> res) {
        System.out.println(res);
        if (index >= a.length) return;
        
        for(int i=index;i<a.length;i++) {
            res.add(a[i]);
            allSubsets(a,i+1,new ArrayList<Integer>(res));
            res.remove(res.size()-1);
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        T9andMore obj = new T9andMore();
        int keyStrokes[] = {2,3,4};
        obj.getT9(keyStrokes, 0, new ArrayList<Character>());
        String url[] = new String[urls.size()];
        obj.urlPrinting(0, new ArrayList<String>());
//        
        // all combinations
        // no repeat
        int a[] = {1,2,3,4,6,7};
        obj.getCombinationSumNoRepeat(a, 0, 7, 0, new ArrayList());
//        // yes repeat
//        System.out.println("--------------type 2- get to target WITH repetitions-------------");
//        obj.getCombinationSumYesRepeat(a, 0, 7, new ArrayList());
        System.out.println("--------------type 3- all subsets-------------");
        obj.allSubsets(keyStrokes, 0, new ArrayList());
    }

}
