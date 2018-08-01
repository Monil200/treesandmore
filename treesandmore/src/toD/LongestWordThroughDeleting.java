package toD;
import java.util.*;
public class LongestWordThroughDeleting {
    String maxLengthWord = "";
    public void getLongestWordThroughDeleting(HashMap<String,Integer> map, int start, String origin,String res) {
        System.out.println("res:" + res);
        if (map.containsKey(res) && map.get(res) == 1) {
            if (res.length() > maxLengthWord.length()) {
                maxLengthWord = res;
            }
        }
        if (start >= origin.length()) return;
        //abpcplea
        for(int i=start;i<origin.length();i++) {
            if (map.containsKey(res + origin.charAt(i))) {
                res += origin.charAt(i);
                getLongestWordThroughDeleting(map,i+1, origin, res);
                res = "";
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LongestWordThroughDeleting obj = new LongestWordThroughDeleting();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("a",0);
        map.put("al",0);
        map.put("ale",1);
        
        map.put("a",0);
        map.put("ap",0);
        map.put("app",0);
        map.put("appl",0);
        map.put("apple",1);
        
        map.put("m",0);
        map.put("mo",0);
        map.put("mon",0);
        map.put("monk",0);
        map.put("monke",0);
        map.put("monkey",1);
        
        map.put("p",0);
        map.put("pl",0);
        map.put("ple",0);
        map.put("plea",1);
        map.put("pleas",0);
        map.put("pleasa",0);
        map.put("pleasan",0);
        map.put("pleasant",0);
        map.put("pleasanto",0);
        map.put("pleasanton",1);
        
        obj.getLongestWordThroughDeleting(map, 0, "abpcpleasanton", "");
        System.out.println("Largest word in dict available: " + obj.maxLengthWord);
    }

}
