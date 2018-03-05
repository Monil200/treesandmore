package treessandtrees;
import java.util.*;
public class T9Dictionary {
    HashMap<Integer, ArrayList<Character>> map;
    HashMap<Integer, ArrayList<String>> urls;
    T9Dictionary() {
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
    
    public void possibleStrings(int k[], int start, ArrayList<Character> a) {
        if (a.size() == k.length) {
            Iterator<Character> it = a.iterator();
            while(it.hasNext()) {
                System.out.print(it.next() +" ");
            }
            System.out.println();
            return;
        }
//        System.out.println("start:" + start);
        for(int i=0;i<map.get(k[start]).size();i++) {
            a.add(map.get(k[start]).get(i));
            int currLength = a.size();
            possibleStrings(k, ++start, a);
            a.remove(currLength -1);
            --start;
        }
    }
    
    public void generateUrls(ArrayList<String> a, int start) {
        if (a.size() == urls.size()) {
            Iterator<String> it = a.iterator();
            while(it.hasNext()) {
                System.out.print(it.next());
            }
            System.out.println();
            return;
        }
        for(int i=0;i<urls.get(start).size();i++) {
            a.add(urls.get(start).get(i) + ".");
            int currSize = a.size();
            generateUrls(a, ++start);
            a.remove(currSize-1);
            --start;
        }
    }
    
    public void getT9Words(String s, int index, int keyStrokes[]) {
        if (s.length() == keyStrokes.length) {
            System.out.println(s);
            return;
        } else {
            for(int j=0;j<map.get(index).size();j++) {
                s += map.get(index).get(j);
                getT9Words(s, index+1, keyStrokes);
                s = s.substring(0, s.length()-1);
            }
        }
    }
    
    public void generateUrlsV2(ArrayList<String> s, int index) {
        if (s.size() == urls.size()) {
            System.out.println(s);
            return;
        } else {
            for(int j=0;j<urls.get(index).size();j++) {
                s.add(urls.get(index).get(j));
                generateUrls(s, j+1);
                s.remove(s.size()-1);
            }
        }
    }
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        T9Dictionary obj = new T9Dictionary();
        int keyStrokes[] = {2,3,4};
        obj.possibleStrings(keyStrokes, 0, new ArrayList<Character>());
        obj.generateUrls(new ArrayList<String>(), 0);
        
        // t9 v2
        System.out.println("V2-------");
        obj.getT9Words("", keyStrokes[0], keyStrokes);
        
        System.out.println("V2------- generate URLs");
        obj.generateUrls(new ArrayList<String>(), 0);
    }

}
